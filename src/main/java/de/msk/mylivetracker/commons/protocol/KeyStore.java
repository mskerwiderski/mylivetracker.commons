package de.msk.mylivetracker.commons.protocol;

import java.security.Key;
import java.security.KeyFactory;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * KeyStore.
 * 
 * @author michael skerwiderski, (c)2011
 * 
 * @version 000
 * 
 *          history 000 initial 2011-08-11
 * 
 */
public class KeyStore {
	private KeyFactory keyFactory = null;
	private Map<String, KeyDsc> keyMap = new HashMap<String, KeyDsc>();

	public KeyStore(KeyDsc... keyDscs) {
		try {
			this.keyFactory = KeyFactory.getInstance("RSA");
			for (KeyDsc keyDsc : keyDscs) {
				if (this.keyMap.containsKey(keyDsc.getName())) {
					throw new IllegalArgumentException(
							"duplicate name of keyDsc found: "
									+ keyDsc.getName());
				}
				this.keyMap.put(keyDsc.getName(), keyDsc);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public KeyDsc.KeyType getKeyType(String name) {
		if (StringUtils.isEmpty(name)) {
			throw new IllegalArgumentException("name must not be empty.");
		}
		if (!this.keyMap.containsKey(name)) {
			throw new IllegalArgumentException("keyDsc '" + name
					+ "' does not exist.");
		}
		return ((KeyDsc) this.keyMap.get(name)).getKeyType();
	}

	public Key getPublicKey(String name) {
		if (StringUtils.isEmpty(name)) {
			throw new IllegalArgumentException("name must not be empty.");
		}
		if (!this.keyMap.containsKey(name)) {
			throw new IllegalArgumentException("keyDsc '" + name
					+ "' does not exist.");
		}
		return ((KeyDsc) this.keyMap.get(name)).getPublicKey(this.keyFactory);
	}

	public Key getPrivateKey(String name) {
		if (StringUtils.isEmpty(name)) {
			throw new IllegalArgumentException("name must not be empty.");
		}
		if (!this.keyMap.containsKey(name)) {
			throw new IllegalArgumentException("keyDsc '" + name
					+ "' does not exist.");
		}
		return ((KeyDsc) this.keyMap.get(name)).getPrivateKey(this.keyFactory);
	}
}
