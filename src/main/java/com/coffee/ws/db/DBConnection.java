package com.coffee.ws.db;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	static String DATABASEURI = "postgres://zfjnroghdhylhr:NBo_CFJgUwswDRCZCLfuos4lMm@ec2-107-21-223-110.compute-1.amazonaws.com:5432/d46i7qbjv9e872";

	public Connection getConnection() throws URISyntaxException, SQLException {
		// String dbUrl = System.getenv("JDBC_DATABASE_URL");
		return DriverManager.getConnection(DATABASEURI);
	}

	public Connection getConnectionURI() throws URISyntaxException, SQLException {
		String compname = System.getenv("COMPUTERNAME");
		URI dbUri;

		if (System.getProperty("os.name").contains("Windows")) {
			if (compname.equals("5CG4310LZB")) {
				// set proxy when in office

				System.setProperty("http.proxyHost", "10.158.17.67");
				System.setProperty("http.proxyPort", "8080");

			}

			dbUri = new URI(DATABASEURI);

		} else {
			dbUri = new URI(System.getenv("DATABASE_URL"));

		}

		String username = dbUri.getUserInfo().split(":")[0];
		String password = dbUri.getUserInfo().split(":")[1];

		System.out.println("username-->" + username);
		System.out.println("password-->" + password);

		String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?user="
				+ username + "&password=" + password;

		System.out.println("db url: " + dbUrl);

		return DriverManager.getConnection(dbUrl);
	}

}
