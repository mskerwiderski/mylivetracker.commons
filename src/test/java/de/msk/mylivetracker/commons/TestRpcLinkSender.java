package de.msk.mylivetracker.commons;

import java.net.URL;

import junit.framework.TestCase;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;

import de.msk.mylivetracker.commons.rpc.LinkSenderRequest;
import de.msk.mylivetracker.commons.rpc.LinkSenderResponse;
import de.msk.mylivetracker.commons.util.datetime.DateTime;

/**
 * TestRpcLinkSender.
 * 
 * @author michael skerwiderski, (c)2011
 * 
 * @version 000
 * 
 * history
 * 000 initial 2011-08-14
 * 
 */
public class TestRpcLinkSender extends TestCase {

	public void testRpcCall() {
		try {
			JsonRpcHttpClient client = new JsonRpcHttpClient(
			    new URL("http://localhost:8080/mylivetracker.server/rpc.json"));
			
			String aboutStr = (String)client.invoke("about", new Object[0], String.class);
			System.out.println(aboutStr);
			
			LinkSenderRequest request = new LinkSenderRequest("de", 
				"1234", "MySender", "msk", "1964b3b7171e857e4fb7b1eec12c1807", DateTime.TIME_ZONE_GERMANY);			
			LinkSenderResponse response = 
				(LinkSenderResponse)client.invoke("linkSender", new Object[] { request }, LinkSenderResponse.class);
			System.out.println(
				"[" + response.getResultCode() + "] " + 
				response.getResultMessage());
			if (response.getResultCode().isSuccess()) {
				System.out.println(response.toString());
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
