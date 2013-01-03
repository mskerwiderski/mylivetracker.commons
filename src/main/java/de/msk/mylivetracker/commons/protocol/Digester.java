package de.msk.mylivetracker.commons.protocol;

import org.apache.commons.lang.StringUtils;

import de.msk.mylivetracker.commons.util.md5.MD5;

/**
 * classname: Digester
 * 
 * @author michael skerwiderski, (c)2012
 * @version 000
 * @since 1.5.0
 * 
 * history:
 * 000	2013-01-03	revised for v1.5.x.
 * 
 */
public class Digester {
	public static boolean equals(String dataStr, String expectedDigest) {
		return StringUtils.equals(calc(dataStr), expectedDigest);
	}

	public static String calc(String dataStr) {
		if (StringUtils.isEmpty(dataStr)) {
			throw new IllegalArgumentException("data must not be null.");
		}
		String digestStr = null;
		try {
			MD5 md5 = new MD5();
			md5.Update(dataStr, null);
			digestStr = md5.asHex();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return digestStr;
	}
}

