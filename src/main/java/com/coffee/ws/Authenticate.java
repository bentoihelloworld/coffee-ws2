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
		ResultSet rs = null;
		Statement st1 = null;
		String tablename = "AUTHENTICATION";

		String sql = "CREATE TABLE AUTHENTICATION " + "(id INTEGER not NULL, " + " username VARCHAR(10), "
				+ " password VARCHAR(10), " + " PRIMARY KEY ( id ))";

		String sqlForTable = "SELECT tables.table_name FROM information_schema.tables WHERE table_name = '" + tablename
				+ "'";

		try {
			Class.forName("org.postgresql.Driver");
			DBConnection dbconn = new DBConnection();

			Connection con = dbconn.connectURI();

			if (con != null) {
				st = con.createStatement();
				rs = st.executeQuery(sqlForTable);

				if (rs != null) {

					while (rs.next()) {
						if (rs.getString(1).equalsIgnoreCase(tablename)) {
							output = "table is exists :" + tablename;
						} else {
							st1 = con.createStatement();
							st1.executeUpdate(sql);

							output = "table is not exist and create new :" + tablename;

						}

					}

				}

				// System.out.println("Created table in given database...");
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

	@GET
	@Path("/insertvalue")
	public Response getResponseforInsertValue() {

		return Response.status(200).entity("value is inserted joke lang...").build();

	}

}
