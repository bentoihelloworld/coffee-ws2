package com.coffee.ws.test;


import com.coffee.ws.DataCollectionThread;
import com.coffee.ws.data.AuctionData;
import com.coffee.ws.data.Status;

public class MainTest {



	public static void main(String args[]) {

		AuctionData model = fetchDataFromSource();
		
		DataCollectionThread thr = new DataCollectionThread(model, "DataCollection");
		thr.start();

	}

	private static AuctionData fetchDataFromSource() {

		AuctionData m = new AuctionData();

		m.setRootElem("Auction");
		m.setAuctionLocation("Cebu");
		m.setAuctionStatus(Status.STOP);
		m.setAuctionLocationID("101");
		m.setCarmake("Toyota");
		m.setCarcount("10");
		m.setRunningcount("0");

		return m;
	}
	
	

}
