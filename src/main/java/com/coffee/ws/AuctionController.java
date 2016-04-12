package com.coffee.ws;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import com.coffee.ws.data.AuctionData;
import com.coffee.ws.data.Status;

public class AuctionController {

	private XMLViewer viewer;
	private AuctionData model;
	private Status auctionStatus;
	public Element root;
	public Element auctionlocation;
	public Element carmake;
	public Attr auctid;
	public Attr auctstat;
	public Attr totalcarcount;
	public Attr runningcount;
	public String valueOfRunningCount;
	public Document doc;

	public Document getDoc() {
		return doc;
	}

	public void setDoc(Document doc) {
		model.setDocument(doc);
	}

	public String getValueOfRunningCount() {
		return valueOfRunningCount;
	}

	public void setValueOfRunningCount(String valueOfRunningCount) {
		model.setRunningcount(valueOfRunningCount);
		;
	}

	public AuctionController(AuctionData model, XMLViewer viewer) {
		this.model = model;
		this.viewer = viewer;

	}

	public Status getAuctionStatus() {
		return auctionStatus;
	}

	public void setAuctionStatus(Status auctionStatus) {
		this.auctionStatus = auctionStatus;
	}

	public void createAuctionElementforViewer() {

		root = model.getDocument().createElement(model.getRootElem());
		auctionlocation = model.getDocument().createElement(model.getAuctionLocation());
		carmake = model.getDocument().createElement(model.getCarmake());

	}

	public void createAuctionAttributeforViewer() {

		auctid = model.getDocument().createAttribute("id");
		auctstat = model.getDocument().createAttribute("status");
		totalcarcount = model.getDocument().createAttribute("carcount");
		runningcount = model.getDocument().createAttribute("runningcount");

	}

	public void setAttrValueforViewer() {

		auctid.setValue(model.getAuctionLocationID());
		auctstat.setValue(model.getAuctionStatus().toString());
		totalcarcount.setValue(model.getCarcount());
		runningcount.setValue(model.getRunningcount());

	}

	public void setAttrNodeforViewer() {

		auctionlocation.setAttributeNode(auctid);
		auctionlocation.setAttributeNode(auctstat);
		carmake.setAttributeNode(totalcarcount);
		carmake.setAttributeNode(runningcount);

	}

	public void doAppendChild() {

		model.getDocument().appendChild(root);
		root.appendChild(auctionlocation);
		auctionlocation.appendChild(carmake);

	}

	public void updateRunningCarCountValue() {

		Node auclocation = model.getDocument().getElementsByTagName(model.getCarmake()).item(0);
		NamedNodeMap attr = auclocation.getAttributes();
		Node rcountattr = attr.getNamedItem("runningcount");
		rcountattr.setTextContent(model.getRunningcount());

	}

	public void updateViewer() {

		viewer = new XMLViewer(model.getDocument());
		viewer.generateXMLViewer(false);

	}

}
