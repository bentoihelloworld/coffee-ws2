package com.coffee.ws;

import java.io.File;

import com.coffee.ws.data.AuctionData;
import com.coffee.ws.data.Status;

public class DataCollectionThread extends Thread {

	public AuctionData model;
	private Thread t;
	private String threadName;
	public AuctionController controller;
	public XMLViewer viewer;
	public XMLHandler xml;

	public DataCollectionThread(AuctionData model, String threadName) {
		this.model = model;
		this.threadName = threadName;

		initialize();
		File f = new File(XMLViewer.XMLVIEWER);

		if (f.exists()) {
			insertNewElemAttr();
		} else {
			createNewDocument();
		}
	}

	public void initialize() {
		viewer = new XMLViewer(model.getDocument());
		xml = new XMLHandler(model.getRootElem());
		controller = new AuctionController(model, viewer);

	}

	public void createNewDocument() {

		controller.setDoc(xml.createNewDocument());
		setCreateElementAttr();
		controller.doAppendChild();
		controller.updateViewer();

	}

	public void insertNewElemAttr() {
		
		System.out.println("xml viewer is exist: do insert element");
		controller.setDoc(xml.parseDocument());
		setCreateElementAttr();
		controller.doInsertChild();
		controller.updateViewer();

	}

	public void setCreateElementAttr() {

		controller.createAuctionElementforViewer();
		controller.createAuctionAttributeforViewer();
		controller.setAttrValueforViewer();
		controller.setAttrNodeforViewer();
	}

	public void run() {

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
					sleep(1000);

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
