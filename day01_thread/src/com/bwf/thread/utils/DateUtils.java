package com.bwf.thread.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private static String pattern = "yyyy-MM-dd HH:mm:ss";
	private static String pattern2 = "yyyy-MM-dd HH:mm:ss:SSS";
	private static SimpleDateFormat sdf = new SimpleDateFormat(pattern);
	
	public static String getNowTime(){
		
		return sdf.format(new Date());
	}
	
}
