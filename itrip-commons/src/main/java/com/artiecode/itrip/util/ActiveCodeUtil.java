package com.artiecode.itrip.util;

import java.util.Random;

/**
 * <b>激活码生成工具类</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
public class ActiveCodeUtil {
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
