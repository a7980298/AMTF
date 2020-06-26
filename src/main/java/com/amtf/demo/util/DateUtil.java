package com.amtf.demo.util;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class DateUtil {
	public final static String DATE_TOSTR1 = "yyyy-mm-dd HH:mi:ss";

	public final static String DATE_TOSTR2 = "yyyy/mm/dd HH:mi:ss";

	public final static String DATE_TOSTR3 = "yyyy-mm-dd";

	public final static String DATE_TOSTR4 = "yyyy-mm";

	public final static String DATE_TOSTR5 = "mm-dd";

	public final static String DATE_TOSTR6 = "HH:mi:ss";

	public final static String DATE_TOSTR7 = "HH:mi";

	public final static String DATE_TOSTR8 = "mi:ss";

	public final static String DATE_TOSTR_YEAR = "yyyy";

	public final static String DATE_TOSTR_MONTH = "mm";

	public final static String DATE_TOSTR_DAY = "dd";

	public final static String DATE_TOSTR_HOUR = "HH";

	public final static String DATE_TOSTR_MINUTE = "mi";

	public final static String DATE_TOSTR_second = "ss";

	public static String dateToStr(Date date, String format) {
		String str = "";
		try {
			str = new SimpleDateFormat(format).format(date);
		} catch (Exception e) {
			return "";
		}
		return str;
	}

	public static void strTostr(String str) {

		str.replace("-", "").replace(" ", "").replace(":", "");
	}
}
