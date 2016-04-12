package com.coffee.ws.data;

import org.w3c.dom.Document;

public class AuctionData {

	private String rootElem;
	private String auctionLocation;
	private String carmake;
	private String auctionLocationID;
	private String carcount;
	private String runningcount;
	private Status auctionStatus;
	private Document document;

	public Status getAuctionStatus() {
		return auctionStatus;
	}

	public void setAuctionStatus(Status auctionStatus) {
		this.auctionStatus = auctionStatus;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public String getRootElem() {
		return rootElem;
	}

	public void setRootElem(String rootElem) {
		this.rootElem = rootElem;
	}

	public String getAuctionLocation() {
		return auctionLocation;
	}

	public void setAuctionLocation(String auctionLocation) {
		this.auctionLocation = auctionLocation;
	}

	public String getCarmake() {
		return carmake;
	}

	public void setCarmake(String carmake) {
		this.carmake = carmake;
	}

	public String getAuctionLocationID() {
		return auctionLocationID;
	}

	public void setAuctionLocationID(String auctionLocationID) {
		this.auctionLocationID = auctionLocationID;
	}

	public String getCarcount() {
		return carcount;
	}

	public void setCarcount(String carcount) {
		this.carcount = carcount;
	}

	public String getRunningcount() {
		return runningcount;
	}

	public void setRunningcount(String runningcount) {
		this.runningcount = runningcount;
	}

}
