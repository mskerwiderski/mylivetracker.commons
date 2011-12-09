package de.msk.mylivetracker.commons;

import junit.framework.TestCase;
import de.msk.mylivetracker.commons.protocol.Digester;
import de.msk.mylivetracker.commons.protocol.EncDecoder;
import de.msk.mylivetracker.commons.protocol.EncDecoder.ParsingResult;
import de.msk.mylivetracker.commons.protocol.KeyDsc.KeyType;
import de.msk.mylivetracker.commons.protocol.KeyStore;
import de.msk.mylivetracker.commons.protocol.UploadDataPacket;

/**
 * TestEncDecoder.
 * 
 * @author michael skerwiderski, (c)2011
 * 
 * @version 000
 * 
 * history
 * 000 initial 2011-08-11
 * 
 */
public class TestEncDecoder extends TestCase {
	
	public static void main(String[] argv) {
		String dataStr ="MLT:Key1024:VRqcCOcA33fsYanugG7JJBgpf4LXa0atJiBtU+6Wjq6D5/qsUMC+GeDaSUmOnogZsZHDp/HLnTav48StfQ7/jiy2SrjMoAdONcTgv/y68aJ14Z1LxM05KP2/PUyiitUYAZ7pks2lc6Pns44MYAloGh/S1NpNRRHMxY06fuDKdJ14Gs/IUOO4Bc7Aww/3U353ZTzt0l4o8djU+XG6hmG+iEnFvHkiK/MpehlCexhEg0tomW+HPcYrfBo7Gl2+y4fdlUl2hgf9zI0JrX/7mKw7fesobP8jOy0shHTy8vMkLX0Wd3bH935cL2qEIhXfq6686fJduGpVqjCrh6U4qVEq8g==*fdc82aaf7c2333168796826634fe392c#";
		KeyStore keyStoreServer = new KeyStore(Keys.keyDscArrServer);
		EncDecoder decoder = new EncDecoder(keyStoreServer, true);
		System.out.println(decoder.decode(dataStr));
	}
	
	public void testEncoding() {
		String dataStr = "MLT:Key1024:XjGjl+cZ2cNfgAIWX5HaRDFlaxtG/Xt5fDgawr8GGjz4edPHbV+Ubvt+G8Y/8" +
			"Nel85aa4yQ5bXWSIn2mxpKVGABqh7hHVwt4tCEvVLmzaSfszi/YQ6druPh9QNz4RG1aBll6k0q4o51Zknh813m" +
			"HdPrLOqM8gRsc5S3CZFXJFZ+aMLVVoEOfo3ffBTe2qej/0C/mnlInt1N5t6u9HRXwWfrMEzMFGU4GfB+2vTiRb" +
			"myONRYGdaIRpErWVF7ucLy99nW0xGbIQW8TbmlkatFktZ+EeDG9/If/JBXRbyBG/83nNt5ERZP2j23talU+t61" +
			"ubKVAyacxmj643VUqING3JiQX0GOsFZbWsy3K42LqpJ0jq3JFVK+/v2Mq01buTE9DIXte7//v30nXRlT7wSqPl" +
			"KgfIf6bfB24zQwwqiPpQWpcEFtoCTWzphT3BcvvMkihh/leYWNu43Qn/SwdlMUQiQe1IKjvK0Bxph3IADRA0rO" +
			"uGEFz1jyI31oBO6oeQFDN*77835944723deee90879c66c0d6d1922#";
		KeyStore keyStoreServer = new KeyStore(Keys.keyDscArrServer);
		EncDecoder decoder = new EncDecoder(keyStoreServer, true);
		System.out.println(decoder.decode(dataStr));		
	}
	
	public void testEncDecodingWithoutCompress() {
		testEncDecodingAux(false);
	}
	
	public void testEncDecodingWithCompress() {
		testEncDecodingAux(true);
	}

	public static void testEncDecodingAux(boolean compress) {		
		KeyStore keyStoreServer = new KeyStore(Keys.keyDscArrServer);
		KeyStore keyStoreClient = new KeyStore(Keys.keyDscArrClient);
		UploadDataPacket uploadDataPacket = TestData.createUploadDataPacket();
		String digest = Digester.calc(uploadDataPacket.toString());
		EncDecoder encoder = new EncDecoder(keyStoreClient, compress);
		EncDecoder decoder = new EncDecoder(keyStoreServer, compress);
		
		for (KeyType keyType : KeyType.values()) {
			System.out.println("test (compress=" + compress + "): " + keyType.name());		
			String encodedDataStr = encoder.encode(keyType.name(), uploadDataPacket);
			System.out.println("encodedStr length: " + encodedDataStr.length());
			ParsingResult parsingResult = decoder.decode(encodedDataStr);
			assertTrue(parsingResult.isSuccess());
			UploadDataPacket decUploadDataPacket = parsingResult.getUploadDataPacket();
			assertNotNull(decUploadDataPacket);
			assertEquals(digest, Digester.calc(decUploadDataPacket.toString()));			
		}
	}		
}
