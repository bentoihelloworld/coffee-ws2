package com.coffee.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/authenticate2")
public class Authenticate {
	
	@GET
	@Path("/{param}")
	public Response getWebMessage(@PathParam("param") String msg){
		String output  = "reponse: "+ msg;
		
		return Response.status(200).entity(output).build();
		
	}
	

}
