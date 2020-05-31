package com.amtf.demo.util;

public class CommonUtil {

	/**
	 * 非空判断
	 */
	public static boolean isEmpty(Object obj) {
		if (obj == null) {
			return true;
		}
		if (FixedNumberUtil.EMPTY.equals(obj)) {
			return true;
		}
		return false;
	}

}
