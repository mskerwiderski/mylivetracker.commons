package de.msk.mylivetracker.commons.protocol;

import java.math.BigInteger;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

import org.apache.commons.lang3.StringUtils;

/**
 * classname: KeyDsc
 * 
 * @author michael skerwiderski, (c)2012
 * @version 000
 * @since 1.5.0
 * 
 * history:
 * 000	2013-01-03	revised for v1.5.x.
 * 
 */
public class KeyDsc {
	private String name = null;
	private KeyType keyType = null;
	private BigInteger modulus = null;
	private BigInteger exponentPrivate = null;
	private BigInteger exponentPublic = null;

	public static enum KeyType {
		Key512(512, 53, 64),
		Key1024(1024, 117, 128), 
		Key2048(2048, 245, 256), 
		Key4096(4096, 501, 512);

		private int keyLength;
		private int blockSize;
		private int encBlockSize;

		private KeyType(int keyLength, int blockSize, int encBlockSize) {
			this.keyLength = keyLength;
			this.blockSize = blockSize;
			this.encBlockSize = encBlockSize;
		}
		public int getKeyLength() {
			return keyLength;
		}
		public int getBlockSize() {
			return this.blockSize;
		}
		public int getEncBlockSize() {
			return this.encBlockSize;
		}
	}
	
	public KeyDsc(String name, KeyType keyType, BigInteger modulus,
		BigInteger exponentPublic, BigInteger exponentPrivate) {
		if (StringUtils.isEmpty(name)) {
			throw new IllegalArgumentException("name must not be empty.");
		}
		if (keyType == null) {
			throw new IllegalArgumentException("keyType must not be null.");
		}
		if (modulus == null) {
			throw new IllegalArgumentException("modulus must not be null.");
		}
		if ((exponentPublic == null) && (exponentPrivate == null)) {
			throw new IllegalArgumentException(
				"exponentPublic and exponentPrivate must not both be empty.");
		}
		this.name = name;
		this.keyType = keyType;
		this.modulus = modulus;
		this.exponentPublic = exponentPublic;
		this.exponentPrivate = exponentPrivate;		
	}
	
	public KeyDsc(String name, KeyType keyType, String modulus,
		String exponentPublic, String exponentPrivate) {
		if (StringUtils.isEmpty(name)) {
			throw new IllegalArgumentException("name must not be empty.");
		}
		if (keyType == null) {
			throw new IllegalArgumentException("keyType must not be null.");
		}
		if (StringUtils.isEmpty(modulus)) {
			throw new IllegalArgumentException("modulus must not be empty.");
		}
		if ((StringUtils.isEmpty(exponentPublic))
			&& (StringUtils.isEmpty(exponentPrivate))) {
			throw new IllegalArgumentException(
					"exponentPublic and exponentPrivate must not both be empty.");
		}
		this.name = name;
		this.keyType = keyType;
		this.modulus = new BigInteger(modulus);
		if (!StringUtils.isEmpty(exponentPublic)) {
			this.exponentPublic = new BigInteger(exponentPublic);
		}
		if (!StringUtils.isEmpty(exponentPrivate)) {
			this.exponentPrivate = new BigInteger(exponentPrivate);
		}
	}

	public Key getPublicKey(KeyFactory keyFactory) {
		if (keyFactory == null) {
			throw new IllegalArgumentException("keyFactory must not be null.");
		}
		if (this.exponentPublic == null) {
			throw new RuntimeException(
					"method getPublicKey() is not supported, because public exponent is null.");
		}
		Key publicKey = null;
		try {
			publicKey = keyFactory.generatePublic(new RSAPublicKeySpec(
					this.modulus, this.exponentPublic));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return publicKey;
	}

	public Key getPrivateKey(KeyFactory keyFactory) {
		if (keyFactory == null) {
			throw new IllegalArgumentException("keyFactory must not be null.");
		}
		if (this.exponentPrivate == null) {
			throw new RuntimeException(
					"method getPrivateKey() is not supported, because private exponent is null.");
		}
		Key privateKey = null;
		try {
			privateKey = keyFactory.generatePrivate(new RSAPrivateKeySpec(
					this.modulus, this.exponentPrivate));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return privateKey;
	}

	public String getName() {
		return this.name;
	}

	public KeyType getKeyType() {
		return this.keyType;
	}

	@Override
	public String toString() {
		return "KeyDsc [name=" + name + ", keyType=" + keyType + ", modulus="
			+ modulus + ", exponentPrivate=" + exponentPrivate
			+ ", exponentPublic=" + exponentPublic + "]";
	}
}
