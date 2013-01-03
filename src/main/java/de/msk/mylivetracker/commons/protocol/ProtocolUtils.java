package de.msk.mylivetracker.commons.protocol;

import de.msk.mylivetracker.commons.util.md5.MD5;

/**
 * classname: ProtocolUtils
 * 
 * @author michael skerwiderski, (c)2012
 * @version 000
 * @since 1.5.0
 * 
 * history:
 * 000	2013-01-03	revised for v1.5.x.
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
