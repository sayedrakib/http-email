package me.screenful.rnd.httpemail;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import com.postmark.java.PostmarkClient;
import com.postmark.java.PostmarkException;
import com.postmark.java.PostmarkMessage;

/**
 * Hello world!
 * 
 */
// Hello world
public class EmailSender {
	public static void SendEmail(String emailID, String bodyMessage)
			throws Exception {
		PostmarkMessage message = new PostmarkMessage("support@screenful.me", // fromAddress
				emailID, // toAddress
				"sayed@screenful.me", // replyToAddress
				"", // ccAddress
				"Testing Newsletter V1...", // subject
				bodyMessage, // body
				false, // isHTML
				"" // tag
		);

		String varURL = "https://www.dropbox.com/s/726edl5tnotnbdw/testHTML_2.txt?dl=1";
		URL url = new URL(varURL);
		BufferedReader br = new BufferedReader(new InputStreamReader(
				url.openStream()));

		StringBuffer result = new StringBuffer();
		String line = "";

		while ((line = br.readLine()) != null) {
			result.append(line);
		}
		String resultString = result.toString();
		message.setHtmlBody(resultString);

		String apiKey = "5913eaa0-923a-40ed-b1bd-a5497af2dac3";

		PostmarkClient client = new PostmarkClient(apiKey);

		try {
			client.sendMessage(message);
		} catch (PostmarkException pe) {
			System.out.println("An error has occurred : " + pe.getMessage());
		}
	}
}
