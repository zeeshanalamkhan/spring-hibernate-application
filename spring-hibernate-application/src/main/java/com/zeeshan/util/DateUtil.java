package com.zeeshan.util;

import java.util.Date;

import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil {

	private static final Logger logger = Logger.getLogger(DateUtil.class);

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

	public static String dateToString(Date date) {

		logger.info("dateToString method");
		String strDate = sdf.format(date);
		return strDate;
	}

	public static Date stringToDate(String strDate) throws ParseException {

		logger.info("stringToDate method");
		Date date = sdf.parse(strDate);
		return date;
	}
}
