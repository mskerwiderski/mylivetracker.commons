package de.msk.mylivetracker.commons;

import de.msk.mylivetracker.commons.protocol.SerDeserializer;
import de.msk.mylivetracker.commons.protocol.UploadDataPacket;
import junit.framework.TestCase;

/**
 * TestSerDeserializer.
 * 
 * @author michael skerwiderski, (c)2011
 * 
 * @version 000
 * 
 * history
 * 000 initial 2011-08-13
 * 
 */
public class TestSerDeserializer extends TestCase {

	public void testSerDeserializerWithoutCompress() {
		testSerDeserializerAux(false);
	}
	
	public void testSerDeserializerWithCompress() {
		testSerDeserializerAux(true);
	}
	
	private static void testSerDeserializerAux(boolean compress) {
		UploadDataPacket src = TestData.createUploadDataPacket();
		UploadDataPacket dest = null;		
		SerDeserializer serDeserializer = new SerDeserializer(compress);		
		byte[] bytes = serDeserializer.serialize(src);
		System.out.println("len[compressed=" + compress + "]: " + bytes.length + " bytes");
		dest = serDeserializer.deserialize(bytes);
		assertEquals(src.toString(), dest.toString());
	}
}
