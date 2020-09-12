package com.amtf.demo.util;

public class CommonUtil {

	/**
	 * 非空判断
	 */
	public static boolean isEmpty(Object obj) {
		if (obj == null) {
			return true;
		}
		if (Constant.EMPTY.equals(obj)) {
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

	/*
	 * @SuppressWarnings("unused") public static Object getObjectClassValue(Object
	 * obj, String name) { // 创建Field数组接收反射的Class的属性 Field[] fieldobj1 =
	 * obj.getClass().getDeclaredFields(); // 定义返回值 Object lists = null; if
	 * (!CommonUtil.isEmpty(fieldobj1)) { for (int i = 0; i < fieldobj1.length; i++)
	 * { // 开启权限 fieldobj1[i].setAccessible(true); // 判断反射Class的属性是否等于name if
	 * (fieldobj1[i].getName().equals(name)) { try { // 开启权限
	 * fieldobj1[i].setAccessible(true); // 等于name将值赋给返回值 lists =
	 * fieldobj1[i].get(obj); } catch (Exception e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); } } } } return lists; }
	 */
}
