package com.coffee.ws.test;

import com.coffee.ws.AuctionController;
import com.coffee.ws.XMLHandler;
import com.coffee.ws.XMLViewer;
import com.coffee.ws.data.AuctionData;
import com.coffee.ws.data.Status;

public class MainTest {

	static XMLHandler xml;

	public static void main(String args[]) {

		AuctionData model = fetchDataFromSource();
		XMLViewer viewer = new XMLViewer(model.getDocument());

		AuctionController controller = new AuctionController(model, viewer);
		controller.createAuctionElementforViewer();
		controller.createAuctionAttributeforViewer();
		controller.setAttrValueforViewer();
		controller.setAttrNodeforViewer();
		controller.doAppendChild();
		controller.updateViewer();

		// update xmlviewer by carmake
		controller.setDoc(xml.parseDocument());
		controller.setStrCarMake("Toyota");
		controller.setValueOfRunningCount("10021");
		controller.updateRunningCarCountValueByCarMake();
		controller.updateViewer();

	}

	private static AuctionData fetchDataFromSource() {

		AuctionData m = new AuctionData();

		m.setRootElem("Auction");
		m.setAuctionLocation("Cebu");
		m.setAuctionStatus(Status.STARTED);
		m.setAuctionLocationID("101");
		m.setCarmake("Toyota");
		m.setCarcount("100");
		m.setRunningcount("0");

		xml = new XMLHandler(m.getRootElem());

		m.setDocument(xml.createNewDocument());

		return m;
	}

}
