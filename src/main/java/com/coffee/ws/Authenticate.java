package com.coffee.ws;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.coffee.ws.db.DBConnection;

@Path("/authenticate")
public class Authenticate {

	@GET
	@Path("/db")
	public Response getWebMessage() {
		
		String output = "DB not connected";

		try {
			Class.forName("org.postgresql.Driver");
			DBConnection dbconn = new DBConnection();

			Connection c = dbconn.getConnectionURI();
			
			if (c != null) {

				output = "DB connected";
			}

		

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Response.status(200).entity(output).build();

	}

}
