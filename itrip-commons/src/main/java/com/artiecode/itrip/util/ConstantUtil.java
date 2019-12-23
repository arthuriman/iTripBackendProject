package com.artiecode.itrip.util;

import java.util.Properties;

/**
 * <b>系统工具类</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
public class ConstantUtil {
	private static final Properties props = new Properties();

	static {
		try {
			props.load(ConstantUtil.class.getClassLoader().getResourceAsStream("itrip.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static final Long ACTIVE_CODE_TIMEOUT = Long.parseLong(props.getProperty("active.code.timeout"));

	public static final String MAIL_FROM = props.getProperty("mail.from");

	public static final String AUTH_SECRET = props.getProperty("auth.secret");
}
