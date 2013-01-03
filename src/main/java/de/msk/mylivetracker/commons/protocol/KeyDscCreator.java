package de.msk.mylivetracker.commons.protocol;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

import de.msk.mylivetracker.commons.protocol.KeyDsc.KeyType;

/**
 * classname: KeyDscCreator
 * 
 * @author michael skerwiderski, (c)2012
 * @version 000
 * @since 1.5.0
 * 
 * history:
 * 000	2013-01-03	revised for v1.5.x.
 * 
 */
public class KeyDscCreator {

	public static KeyDsc createKeyDsc(String keyDscName, KeyType keyType) {
		if (keyType == null) {
			throw new IllegalArgumentException("keyType must not be null.");
		}
		KeyDsc keyDsc = null;
		try {
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(keyType.getKeyLength());
			KeyPair keyPair = keyPairGenerator.genKeyPair();			
			RSAPublicKeySpec publicKeySpec = 
				keyFactory.getKeySpec(keyPair.getPublic(),
					RSAPublicKeySpec.class);
			RSAPrivateKeySpec privateKeySpec = 
				keyFactory.getKeySpec(keyPair.getPrivate(),
					RSAPrivateKeySpec.class);
			keyDsc = new KeyDsc(keyDscName, keyType, 
				publicKeySpec.getModulus(),
				publicKeySpec.getPublicExponent(),
				privateKeySpec.getPrivateExponent());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return keyDsc;
	}
}
