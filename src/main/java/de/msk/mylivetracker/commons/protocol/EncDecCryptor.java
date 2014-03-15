package de.msk.mylivetracker.commons.protocol;

import javax.crypto.Cipher;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import de.msk.mylivetracker.commons.util.base64.Base64;

/**
 * classname: EncDecCryptor
 * 
 * @author michael skerwiderski, (c)2012
 * @version 000
 * @since 1.5.0
 * 
 * history:
 * 000	2013-01-03	revised for v1.5.x.
 * 
 */
public class EncDecCryptor {
	private Mode mode = null;
	private String keyDscName = null;
	private KeyDsc.KeyType keyType = null;
	private Cipher cipher = null;

	public static enum Mode {
		encrypt, decrypt;
	}

	public EncDecCryptor(KeyStore keyStore, Mode mode, String keyDscName) {
		if (keyStore == null) {
			throw new IllegalArgumentException("keyStore must not be null.");
		}
		if (mode == null) {
			throw new IllegalArgumentException("mode must not be null.");
		}
		if (StringUtils.isEmpty(keyDscName))
			throw new IllegalArgumentException("keyDscName must not be empty.");
		try {
			this.mode = mode;
			this.keyDscName = keyDscName;
			this.keyType = keyStore.getKeyType(keyDscName);
			this.cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			if (mode.equals(Mode.encrypt))
				this.cipher.init(1, keyStore.getPublicKey(keyDscName));
			else if (mode.equals(Mode.decrypt))
				this.cipher.init(2, keyStore.getPrivateKey(keyDscName));
			else
				throw new RuntimeException("unknown mode.");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public String encrypt(byte[] bytes) {
		if (this.mode != Mode.encrypt) {
			throw new RuntimeException(
					"method encrypt() is not supported, because EncDecCryptor is in decrypt mode.");
		}
		byte[] buffer = null;
		try {
			for (int i = 0; i <= bytes.length / this.keyType.getBlockSize(); i++) {
				byte[] block = ArrayUtils.subarray(bytes, 
					i * this.keyType.getBlockSize(), 
					(i + 1) * this.keyType.getBlockSize());
				buffer = ArrayUtils.addAll(
					buffer, this.cipher.doFinal(block));				
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return Base64.encodeToString(buffer, false);
	}

	public byte[] decrypt(String encDataStr) {		
		if (this.mode != Mode.decrypt) {
			throw new RuntimeException(
				"method decrypt() is not supported, because EncDecCryptor is in encrypt mode.");
		}
		byte[] buffer = null;
		try {
			byte[] bytes = Base64.decode(encDataStr);
			for (int i = 0; 
				i < bytes.length / this.keyType.getEncBlockSize(); i++) {
				byte[] block = ArrayUtils.subarray(bytes, 
					i * this.keyType.getEncBlockSize(), 
					(i + 1) * this.keyType.getEncBlockSize());
				buffer = ArrayUtils.addAll(buffer, 
					this.cipher.doFinal(block));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return buffer;
	}

	public String getKeyDscName() {
		return this.keyDscName;
	}

	public Mode getMode() {
		return this.mode;
	}
}
