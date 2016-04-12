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
			XMLViewer viewer = new XMLViewer(model.getDocument());

			AuctionController controller = new AuctionController(model, viewer);
			controller.createAuctionElementforViewer();
			controller.createAuctionAttributeforViewer();
			controller.setAttrValueforViewer();
			controller.setAttrNodeforViewer();
			controller.doAppendChild();
			controller.updateViewer();

		}

	}

	private AuctionData fetchDataFromSource() {

		AuctionData m = new AuctionData();

		m.setRootElem("Auction");
		m.setAuctionLocation("Japan");
		m.setAuctionStatus(Status.STARTED);
		m.setAuctionLocationID("101");
		m.setCarmake("Toyota");
		m.setCarcount("100");
		m.setRunningcount("0");

		XMLHandler xml = new XMLHandler(m.getRootElem());

		m.setDocument(xml.createNewDocument());

		return m;
	}

}
