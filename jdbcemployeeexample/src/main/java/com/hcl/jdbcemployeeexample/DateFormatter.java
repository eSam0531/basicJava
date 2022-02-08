package com.hcl.jdbcemployeeexample;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateFormatter {
	public static final SimpleDateFormat dateformat1 = new SimpleDateFormat("MM-dd-yyyy");

	public static Date stringToDate(String sdate) throws ParseException {
		Date date = null;

		try {
			date = dateformat1.parse(sdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;
	}
}
