package de.msk.mylivetracker.commons.util.password;

public class PasswordEncoderForGpsGatePortal  {

	public static String encode(String plainPassword) {
		StringBuilder sb = null;
		if (plainPassword != null) {
			sb = new StringBuilder();
			int len = plainPassword.length();
			for (int idx=len-1; idx>=0; idx--) {
				char c = plainPassword.charAt(idx);
				if (c >= '0' && c <= '9') {
					sb.append((char)(9 - (c - '0') + '0'));
				} else if (c >= 'a' && c <= 'z') {
					sb.append((char)(('z' - 'a') - (c - 'a') + 'A'));
				} else if (c >= 'A' && c <= 'Z') {
					sb.append((char)(('Z' - 'A') - (c - 'A') + 'a'));
				}
			}
		}
		return (sb != null) ? sb.toString() : null;
	}
}