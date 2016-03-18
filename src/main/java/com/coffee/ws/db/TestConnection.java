package com.coffee.ws.db;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {

	public static void main(String args[]) {

		try {
			
//			String OS = System.getProperty("os.name");
//			if(OS.contains("Window"))
//					System.out.println(OS);
//			System.exit(0);

			Class.forName("org.postgresql.Driver");

			DBConnection  dbconn = new DBConnection();
			Connection c = dbconn.getConnectionURI();
			
			if(c !=null){
				
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
