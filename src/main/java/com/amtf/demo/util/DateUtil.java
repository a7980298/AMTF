package com.amtf.demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public final static String DATE_TOSTR1 = "yyyy-MM-dd HH:mm:ss";

	public final static String DATE_TOSTR2 = "yyyy/MM/dd HH:mm:ss";

	public final static String DATE_TOSTR3 = "yyyy-MM-dd";

	public final static String DATE_TOSTR4 = "yyyy-MM";

	public final static String DATE_TOSTR5 = "MM-dd";

	public final static String DATE_TOSTR6 = "HH:mm:ss";

	public final static String DATE_TOSTR7 = "HH:mm";

	public final static String DATE_TOSTR8 = "mm:ss";

	public final static String DATE_TOSTR_YEAR = "yyyy";

	public final static String DATE_TOSTR_MONTH = "MM";

	public final static String DATE_TOSTR_DAY = "dd";

	public final static String DATE_TOSTR_HOUR = "HH";

	public final static String DATE_TOSTR_MINUTE = "mm";

	public final static String DATE_TOSTR_second = "ss";

	/**
	 * Util日期转换String
	 * @param date
	 * @param format
	 * @return
	 */
	public static String dateToStr(java.util.Date date, String format) {
		String str = "";
		try {
			SimpleDateFormat formatter = new SimpleDateFormat(format);
			str = formatter.format(date);
		} catch (Exception e) {
			return "";
		}
		return str;
	}
	/**
	 * Sql日期转换String
	 * @param date
	 * @param format
	 * @return
	 */
	public static String dateToStr(java.sql.Date date, String format) {
		String str = "";
		try {
			str = new SimpleDateFormat(format).format(date);
		} catch (Exception e) {
			return "";
		}
		return str;
	}

	/**
	 * String转String时间类型
	 * @param strdate
	 * @param format
	 * @return
	 */
	public static String strdateToStr(String strdate, String format) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = "";
		try {
			Date date = simpleDateFormat.parse(strdate);
			str = new SimpleDateFormat(format).format(date);
		} catch (Exception e) {
			return "";
		}
		return str;
	}

	public static void strTostr(String str) {
		str.replace("-", "").replace("/", "").replace(" ", "").replace(":", "");
	}

	public static String strTostrT(String str) {
		return  str.replace("-", "").replace("/", "").replace(" ", "").replace(":", "");
	}
}
