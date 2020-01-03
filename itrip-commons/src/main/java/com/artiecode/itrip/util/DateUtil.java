package com.artiecode.itrip.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static Date parseToDate(String str) throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		str = str.substring(0, 10);
		Date date = dateFormat.parse(str);
		return date;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(parseToDate("2020-01-03T00:00:00.000Z"));
	}
}
