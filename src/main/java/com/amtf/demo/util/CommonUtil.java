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

	/**
	 * String强转Integer
	 */
	public static Integer toIntegerUtil(String str) {
		Integer integer = 0;
		if (!CommonUtil.isEmpty(str)) {
			try {
				integer = Integer.valueOf(str);
			} catch (Exception e) {
				// TODO: handle exception
				return integer;
			}
		}
		return integer;
	}

	/**
	 * String强转Float
	 */
	public static Float toFloatUtil(String str) {
		Float floats = 0.0f;
		if (!CommonUtil.isEmpty(str)) {
			try {
				floats = Float.valueOf(str);
			} catch (Exception e) {
				// TODO: handle exception
				return floats;
			}

		}
		return floats;
	}
}
