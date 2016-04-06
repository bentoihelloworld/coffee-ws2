package com.coffee.ws;

import java.io.IOException;

import sun.misc.BASE64Decoder;

public class BasicAuthentication {

	public boolean isUserAuthenticated(String authString) {
		boolean returnValue = false;

		String decodedAuth = "";
		// Header is in the format "Basic 5tyc0uiDat4"
		// We need to extract data before decoding it back to original string
		String[] authParts = authString.split("\\s+");
		String authInfo = authParts[1];
		// Decode the data back to original string
		byte[] bytes = null;
		try {
			bytes = new BASE64Decoder().decodeBuffer(authInfo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		decodedAuth = new String(bytes);
		System.out.println("decode----:" + decodedAuth);

		String[] auth = decodedAuth.split(":");
		
		System.out.println("uname: " + auth[0]);
		System.out.println("password:" + auth[1]);

		if (auth[0].equals("admin") && auth[1].equals("adminpass") )
			returnValue = true;

		/**
		 * here you include your logic to validate user authentication. it can
		 * be using ldap, or token exchange mechanism or your custom
		 * authentication mechanism.ka
		 */
		// your validation code goes here....

		return returnValue;
	}

}
