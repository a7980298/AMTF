package com.amtf.demo.util;

public class StringUtil {

	/**
	 * int强转String
	 */
	public static String toStr(int obj) {
		String str = "";
		if (!CommonUtil.isEmpty(obj)) {
			str = String.valueOf(obj);
		}
		return str;
	}

	/**
	 * float强转String
	 */
	public static String toStr(float obj) {
		String str = "";
		if (!CommonUtil.isEmpty(obj)) {
			str = String.valueOf(obj);
		}
		return str;
	}

	/**
	 * Long强转String
	 */
	public static String toStr(Long obj) {
		String str = "";
		if (!CommonUtil.isEmpty(obj)) {
			str = String.valueOf(obj);
		}
		return str;
	}

	/**
	 * Long强转String
	 */
	public static String toStr(Object obj) {
		String str = "";
		if (!CommonUtil.isEmpty(obj)) {
			str = String.valueOf(obj);
		}
		return str;
	}
}
