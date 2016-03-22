package com.coffee.ws;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.coffee.ws.db.DBConnection;

@Path("/db")
public class Authenticate {

	@GET
	@Path("/createtable")
	public Response getWebMessage() {

		String output = "DB not connected";
		Statement st = null;
		String sql = "CREATE TABLE AUTHENTICATION " + "(id INTEGER not NULL, " + " username VARCHAR(10), "
				+ " password VARCHAR(10), " + " PRIMARY KEY ( id ))";

		try {
			Class.forName("org.postgresql.Driver");
			DBConnection dbconn = new DBConnection();

			Connection con = dbconn.connectURI();

			if (con != null) {

				st = con.createStatement();
				st.executeUpdate(sql);

				output = "Created table in given database...";
//				System.out.println("Created table in given database...");
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
