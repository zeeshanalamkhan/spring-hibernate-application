package com.zeeshan.util;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

	public static String dateToString(Date date) {

		String strDate = sdf.format(date);
		return strDate;
	}

	public static Date stringToDate(String strDate) throws ParseException {

		Date date = sdf.parse(strDate);
		return date;
	}
}
