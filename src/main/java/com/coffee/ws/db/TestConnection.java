package com.coffee.ws.db;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {

	public static void main(String args[]) {

		try {
			
//			String OS = System.getProperty("os.name");
//			if(OS.contains("Window"))
//					System.out.println(OS);
//			System.exit(0);
			
			Statement stmt = null;

			Class.forName("org.postgresql.Driver");

			DBConnection  dbconn = new DBConnection();
			Connection c = dbconn.connectURI();
			
			if(c !=null){
				stmt = c.createStatement();
				
				String sql = "CREATE TABLE COMPANY " +
	                      "(ID INT PRIMARY KEY    NOT NULL," +
	                      " USERNAME           TEXT    NOT NULL, " +
	                      " PASSWORD            INT     NOT NULL)";
				
	         stmt.executeUpdate(sql);
	         stmt.close();
	         c.close();
				System.out.println("DB connected");
			}

		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}
}
