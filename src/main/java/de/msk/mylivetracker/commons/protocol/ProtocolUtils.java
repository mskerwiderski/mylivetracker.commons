package de.msk.mylivetracker.commons.protocol;

import de.msk.mylivetracker.commons.util.md5.MD5;

/**
 * ProtocolUtils.
 * 
 * @author michael skerwiderski, (c)2011
 * 
 * @version 000
 * 
 * history
 * 000 initial 2011-08-11
 * 
 */
public final class ProtocolUtils {
	public static final Integer PROTOCOL_VERSION_CODE = Integer.valueOf(10);
	protected static final String DATA_STR_PREFIX = "MLT";
	protected static final String DELIMITER = ":";
	protected static final String DATA_STR_PREFIX_DIGEST = "*";
	protected static final String DATA_STR_POSTFIX = "#";

	public static String calcSeed(
		String deviceId, String username, String password) {
		String seed = null;
		String seedRaw = deviceId + ":" + username + ":" + password;
		try {
			MD5 md5 = new MD5();
			md5.Update(seedRaw, null);
			seed = md5.asHex();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return seed;
	}
}
