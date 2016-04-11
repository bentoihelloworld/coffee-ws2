package com.coffee.ws;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/scraping")
public class DataCollection {
	@Context
	private HttpServletRequest request;
	
	@GET
	@Path("/start")
	@Produces(MediaType.APPLICATION_JSON)
	public void startScraping(){
		
		String header = request.getHeader("authorization");
		BasicAuthentication bauth = new BasicAuthentication();
		if (bauth.isUserAuthenticated(header)) {

	
		}



	
	}

}
