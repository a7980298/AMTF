package com.amtf.demo.util;

public class NumberUtil {

	/**
	 * String强转int
	 */
	public static int toInt(String obj) {
		int str = 0;
		if (!CommonUtil.isEmpty(obj)) {
			str = Integer.parseInt(obj);
		}
		return str;
	}

	/**
	 * Object强转int
	 */
	public static int toInt(Object obj) {
		int str = 0;
		if (!CommonUtil.isEmpty(obj)) {
			str = Integer.parseInt(String.valueOf(obj));
		}
		return str;
	}
}
