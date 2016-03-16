package com.coffee.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.coffee.ws.data.User;

@Path("/validate")
public class Userservice {
	
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	
	public User doValidation(){
		
		User u = new User();
		u.setUsername("Melvin");
		u.setPasswd("test");
		
		return u;
		
	}

}
