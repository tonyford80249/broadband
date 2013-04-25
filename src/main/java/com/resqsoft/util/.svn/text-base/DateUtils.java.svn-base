package com.resqsoft.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class DateUtils {
	
	private static final Logger logger = Logger.getLogger(DateUtils.class);
	
	public static Date parseToDate(String year, String month, String day) {
		StringBuilder s = new StringBuilder();
		s.append(year);
		s.append('/');
		s.append(month);
		s.append('/');
		s.append(day);
		
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Date date = null;
		try {
			date = format.parse(s.toString());
		} catch (ParseException e) {
			logger.error("Error parsing string to date with string : [" + s.toString() + "]");
		}
		return date;
	}

}
