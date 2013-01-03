package de.msk.mylivetracker.commons.protocol;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * classname: EncDecoder
 * 
 * @author michael skerwiderski, (c)2012
 * @version 000
 * @since 1.5.0
 * 
 * history:
 * 000	2013-01-03	revised for v1.5.x.
 * 
 */
public class EncDecoder {
	private KeyStore keyStore = null;
	private SerDeserializer serDeserializer = null;
	private Map<String, EncDecCryptor> cryptorMap = new HashMap<String, EncDecCryptor>();

	public EncDecoder(KeyStore keyStore, boolean compress) {
		if (keyStore == null) {
			throw new IllegalArgumentException("keyStore must not be null.");
		}
		this.keyStore = keyStore;
		this.serDeserializer = new SerDeserializer(compress);
	}

	private EncDecCryptor getEncryptor(String keyDscName) {
		if (StringUtils.isEmpty(keyDscName)) {
			throw new IllegalArgumentException("keyDscName must not be null.");
		}
		return getCryptorAux(EncDecCryptor.Mode.encrypt, keyDscName);
	}

	private EncDecCryptor getDecryptor(String keyDscName) {
		if (StringUtils.isEmpty(keyDscName)) {
			throw new IllegalArgumentException("keyDscName must not be null.");
		}
		return getCryptorAux(EncDecCryptor.Mode.decrypt, keyDscName);
	}

	private EncDecCryptor getCryptorAux(EncDecCryptor.Mode mode,
			String keyDscName) {
		if (mode == null) {
			throw new IllegalArgumentException("mode must not be null.");
		}
		if (StringUtils.isEmpty(keyDscName)) {
			throw new IllegalArgumentException("keyDscName must not be null.");
		}
		EncDecCryptor cryptor = null;
		String mapKey = mode.name() + "_" + keyDscName;
		if (!this.cryptorMap.containsKey(mapKey)) {
			cryptor = new EncDecCryptor(this.keyStore, mode, keyDscName);
			this.cryptorMap.put(mapKey, cryptor);
		} else {
			cryptor = (EncDecCryptor) this.cryptorMap.get(mapKey);
		}
		return cryptor;
	}

	public static boolean isValidDataStr(String dataStr) {
		return (!StringUtils.isEmpty(dataStr))
				&& (StringUtils.startsWith(dataStr, "MLT"));
	}

	public static boolean isValidVersionCode(UploadDataPacket dataPacket) {
		if (dataPacket == null)
			return false;
		return dataPacket.getVersionCode() >= ProtocolUtils.PROTOCOL_VERSION_CODE;
	}

	public ParsingResult decode(String transferredStr) {
		if (StringUtils.isEmpty(transferredStr)) {
			throw new IllegalArgumentException(
				"transferredStr must not be empty.");
		}

		UploadDataPacket uploadDataPacket = null;
		String errorMessage = null;

		String transferredStrWoDigest = StringUtils.substringBeforeLast(
				transferredStr, "*");
		String digest = StringUtils.substringBeforeLast(
				StringUtils.substringAfterLast(transferredStr, "*"), "#");

		boolean success = true;
		if ((success) && (!Digester.equals(transferredStrWoDigest, digest))) {
			errorMessage = "invalid dataStr: digest does not match.";
			success = false;
		}

		String keyDscName = null;
		String encryptedData = null;
		if (success) {
			String[] dataArr = StringUtils.split(transferredStrWoDigest, ":");
			if ((dataArr == null) || (dataArr.length != 3)) {
				errorMessage = "invalid dataStr: format unknown.";
				success = false;
			} else {
				keyDscName = dataArr[1];
				encryptedData = dataArr[2];
			}
		}

		if (success) {
			byte[] decryptedData = getDecryptor(keyDscName).decrypt(encryptedData);
			uploadDataPacket = this.serDeserializer.deserialize(decryptedData);
			if (uploadDataPacket == null) {
				errorMessage = "invalid dataStr: deserialization failed.";
				success = false;
			}
		}
				
		return new ParsingResult(uploadDataPacket, errorMessage);
	}

	public String encode(String keyDscName, UploadDataPacket uploadDataPacket) {
		if (StringUtils.isEmpty(keyDscName)) {
			throw new IllegalArgumentException("keyDscName must not be null.");
		}
		if (uploadDataPacket == null) {
			throw new IllegalArgumentException(
					"uploadDataPacket must not be null.");
		}
		byte[] bytes = this.serDeserializer.serialize(uploadDataPacket);
		String encryptedGsonData = getEncryptor(keyDscName).encrypt(bytes);
		String dataStrForDataTransfer = "MLT:" + keyDscName + ":"
				+ encryptedGsonData;
		dataStrForDataTransfer = dataStrForDataTransfer + "*"
				+ Digester.calc(dataStrForDataTransfer) + "#";

		return dataStrForDataTransfer;
	}

	public static final class ParsingResult {
		private UploadDataPacket uploadDataPacket = null;
		private String errorMessage = null;

		private ParsingResult(UploadDataPacket uploadDataPacket,
				String errorMessage) {
			this.uploadDataPacket = uploadDataPacket;
			this.errorMessage = errorMessage;
		}

		public boolean isSuccess() {
			return StringUtils.isEmpty(this.errorMessage);
		}

		public UploadDataPacket getUploadDataPacket() {
			return this.uploadDataPacket;
		}

		public String getErrorMessage() {
			return this.errorMessage;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "ParsingResult [uploadDataPacket=" + uploadDataPacket
				+ ", errorMessage=" + errorMessage + "]";
		}		
	}	
}
