package com.coffee.ws;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.coffee.ws.data.AuctionData;
import com.coffee.ws.data.Status;

@Path("/scraping")
public class DataCollection {
	@Context
	private HttpServletRequest request;

	@GET
	@Path("/start")
	@Produces(MediaType.APPLICATION_JSON)
	public void startScraping() {

		String header = request.getHeader("authorization");
		BasicAuthentication bauth = new BasicAuthentication();
		if (bauth.isUserAuthenticated(header)) {

			AuctionData model = fetchDataFromSource();
			
			DataCollectionThread thr = new DataCollectionThread(model, "DataCollection");
			thr.start();


		}

	}

	private AuctionData fetchDataFromSource() {

		AuctionData m = new AuctionData();

		m.setRootElem("Auction");
		m.setAuctionLocation("Cebu");
		m.setAuctionStatus(Status.STARTED);
		m.setAuctionLocationID("101");
		m.setCarmake("Toyota");
		m.setCarcount("10");
		m.setRunningcount("0");
		return m;
	}

}
