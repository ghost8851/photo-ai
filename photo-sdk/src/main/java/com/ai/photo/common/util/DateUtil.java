package com.ai.photo.common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static  final String DATE_FORMAT_STR = "yyyy-MM-dd HH:mm:ss";
	public static final DateFormat DATE_FORMAT = new SimpleDateFormat(DateUtil.DATE_FORMAT_STR);  
	public static String getCurTime(){
		return DATE_FORMAT.format(new Date());
	}
}
