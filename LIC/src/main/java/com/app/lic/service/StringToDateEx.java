package com.app.lic.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class StringToDateEx {

	public static String convertDateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");

		String dateToString = sdf.format(date);
		return (dateToString);
	}

	public static Date convertStringToDate(String Sdate) {
		SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
		Date date = null;
		try {
			date = sdf.parse(Sdate);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return date;
	}

	public static void main(String[] args) {
		Date date = new Date();
		String s = convertDateToString(date);

		Date date1 = convertStringToDate(s);

		System.out.println(s);
	}
}
