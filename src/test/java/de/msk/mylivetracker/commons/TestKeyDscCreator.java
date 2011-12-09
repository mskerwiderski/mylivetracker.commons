package de.msk.mylivetracker.commons;

import junit.framework.TestCase;
import de.msk.mylivetracker.commons.protocol.EncDecCryptor;
import de.msk.mylivetracker.commons.protocol.EncDecCryptor.Mode;
import de.msk.mylivetracker.commons.protocol.KeyDsc;
import de.msk.mylivetracker.commons.protocol.KeyDsc.KeyType;
import de.msk.mylivetracker.commons.protocol.KeyDscCreator;
import de.msk.mylivetracker.commons.protocol.KeyStore;

/**
 * TestKeyDscCreator.
 * 
 * @author michael skerwiderski, (c)2011
 * 
 * @version 000
 * 
 * history
 * 000 initial 2011-08-11
 * 
 */
public class TestKeyDscCreator extends TestCase {

	public void testKeyDscCreator() {
		KeyDsc keyDsc = KeyDscCreator.createKeyDsc("Key1024", KeyType.Key1024);
		System.out.println(keyDsc.toString());
		
		KeyStore keyStore = new KeyStore(keyDsc);
		EncDecCryptor encCryptor = new EncDecCryptor(keyStore, Mode.encrypt, "Key1024");
		EncDecCryptor decCryptor = new EncDecCryptor(keyStore, Mode.decrypt, "Key1024");
		
		String sourceStr = "This is a test input string.";
		System.out.println("sourceStr: " + sourceStr);
		String encryptedStr = encCryptor.encrypt(sourceStr.getBytes());
		System.out.println("encryptedStr: " + encryptedStr);
		byte[] bytes = decCryptor.decrypt(encryptedStr);
		String decryptedStr = new String(bytes, 0, bytes.length);
		System.out.println("decryptedStr: " + decryptedStr);
		
		assertEquals(sourceStr, decryptedStr);
	}
}
