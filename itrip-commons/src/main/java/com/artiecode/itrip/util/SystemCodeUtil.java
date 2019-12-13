package com.artiecode.itrip.util;

import java.util.Random;

/**
 * <b>系统使用各种代码生成工具类</b>
 * <p>例如使用的验证码，订单编号等</p>
 * @author Arthur
 * @version 3.1.1 2019-12-13
 * @since 3.1.1
 */
public class SystemCodeUtil {
	/**
	 * <b>随机生成四位账户激活码</b>
	 * @return
	 * @throws Exception
	 */
	public static String createActiveCode() throws Exception {
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			int code = random.nextInt(10);
			sb.append(code);
		}
		return sb.toString();
	}
}
