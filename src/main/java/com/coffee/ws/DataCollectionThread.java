package com.coffee.ws;

import com.coffee.ws.data.AuctionData;
import com.coffee.ws.data.Status;

public class DataCollectionThread extends Thread {

	public AuctionData model;
	private Thread t;
	private String threadName;

	public DataCollectionThread(AuctionData model, String threadName) {
		this.model = model;
		this.threadName = threadName;
	}

	public void run() {
		XMLViewer viewer = new XMLViewer(model.getDocument());
		XMLHandler xml = new XMLHandler(model.getRootElem());

		AuctionController controller = new AuctionController(model, viewer);

		controller.setDoc(xml.createNewDocument());
		controller.createAuctionElementforViewer();
		controller.createAuctionAttributeforViewer();
		controller.setAttrValueforViewer();
		controller.setAttrNodeforViewer();
		controller.doAppendChild();
		controller.updateViewer();

		try {

			// update xmlviewer by carmake
			if (!controller.isAuctionRunning()) {
				int countcar = 0;
				while (countcar <= Integer.valueOf(model.getCarcount())) {

					controller.setDoc(xml.parseDocument());
					controller.setValueOfRunningCount(String.valueOf(countcar));
					controller.updateRunningCarCountValueByCarMake();
					controller.updateAuctionStatusByAuctionLocation(Status.RUNNING);

					countcar++;
					sleep(10000);

					if (countcar > Integer.valueOf(model.getCarcount())) {
						controller.updateAuctionStatusByAuctionLocation(Status.COMPLETED);
					}

					controller.updateViewer();
				}

			} else {

				System.out.println("Data collection of " + model.getAuctionLocation() + " is still runing..");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void start() {

		System.out.println("starting thread: " + threadName);

		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}

}
