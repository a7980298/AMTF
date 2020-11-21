package com.amtf.demo.util;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtil {

	/**
	 * 非空判断
	 */
	public static boolean isEmpty(Object obj) {
		if (obj == null) {
			return true;
		}
		if(StringUtils.isEmpty(obj)){
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

	/**
	 * 非空判断
	 */
	public static boolean isEmptyList(java.util.List<?> obj) {
		if (obj == null || obj.size() == 0) {
			return true;
		}
		return false;
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

	/**
	 * 筛选字符串
	 * @param p
	 * @param str
	 * @return
	 */
	public static String matchResult(String p, String str) {
		StringBuilder sb = new StringBuilder();
		Matcher m = Pattern.compile(p,Pattern.CASE_INSENSITIVE).matcher(str);
		return m.replaceAll("");
	}

	public static String getTextForty(String text){
		String htmlStr = text.replaceAll("\"", "'");
		// 定义script的正则表达式
		String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>";
		// 定义style的正则表达式
		String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>";
		// 定义HTML标签的正则表达式
		String regEx_html = "<[^>]+>";
		// 过滤script标签
		htmlStr = matchResult(regEx_script,htmlStr);
		// 过滤style标签
		htmlStr = matchResult(regEx_style,htmlStr);
		// 过滤html标签
		htmlStr = matchResult(regEx_html,htmlStr);
		// 过滤空格
		htmlStr = htmlStr.replaceAll("&nbsp;",Constant.EMPTY);
		if(htmlStr.length() > 40){
			htmlStr = htmlStr.substring(0,40);
		}
		return htmlStr.trim();
	}
}
