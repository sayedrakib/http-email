package me.screenful.rnd.httpemail;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class UrlDataReader {

	public static void main(String[] args) throws Exception {

		// URL address
		String varURL = args[0];
		// recipient's address
		String emailID = args[1];

		URL url = new URL(varURL);
		BufferedReader br = new BufferedReader(new InputStreamReader(
				url.openStream()));

		StringBuffer result = new StringBuffer();
		String line = "";

		while ((line = br.readLine()) != null) {
			result.append(line);

		}

		String bodyMessage = result.toString();

		EmailSender.SendEmail(emailID, bodyMessage);

	}
}
