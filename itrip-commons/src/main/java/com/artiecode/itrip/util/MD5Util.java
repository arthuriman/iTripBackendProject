package com.artiecode.itrip.util;

import java.security.MessageDigest;

/**
 * <b>使用MD5加密算法对于字符串进行加密</b>
 * @author Arthur
 * @version 4.0.0
 * @since 3.0.0
 */
public class MD5Util {
	private static final String KEY_MD5 = "MD5";

	public static String encrypt(String message) {
		StringBuffer sb = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance(KEY_MD5);
			byte[] inputData = message.getBytes("UTF-8");
			byte[] encryptionData = md.digest(inputData);
			for (int i = 0; i < encryptionData.length; i++) {
				int value = ((int) encryptionData[i]) & 0xff;
				if (value < 16) {
					sb.append("0");
				}
				sb.append(Integer.toHexString(value));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}
