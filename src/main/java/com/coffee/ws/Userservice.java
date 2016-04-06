package com.coffee.ws;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.coffee.ws.data.User;

@Path("/validate")
public class Userservice {
	@Context
	private HttpServletRequest request;

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public User doValidation() {

		String header = request.getHeader("authorization");
		BasicAuthentication bauth = new BasicAuthentication();
		User u = new User();

//		System.out.println("------------->" + header);
		if (bauth.isUserAuthenticated(header)) {

			u.setUsername("Melvin");
			u.setPasswd("test");
			return u;
		}

		return null;

	}

}
