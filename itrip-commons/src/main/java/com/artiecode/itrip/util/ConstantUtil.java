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

	/**
	 * <b>容联云account_sid</b>
	 */
	public static final String SMS_ACCOUNT_SID = props.getProperty("sms.account.sid");

	/**
	 * <b>容联云account_token</b>
	 */
	public static final String SMS_ACCOUNT_TOKEN = props.getProperty("sms.account.token");

	/**
	 * <b>容联云appid</b>
	 */
	public static final String SMS_APPID = props.getProperty("sms.appid");

	/**
	 * <b>容联云模板id</b>
	 */
	public static final String SMS_TEMPLATE_ID = props.getProperty("sms.template.id");

	/**
	 * <b>手机号码正则表达式</b>
	 */
	public static final String REGEX_CELLPHONE = props.getProperty("regex.cellphone");

	/**
	 * <b>电子邮件正则表达式</b>
	 */
	public static final String REGEX_EMAIL = props.getProperty("regex.email");
}
