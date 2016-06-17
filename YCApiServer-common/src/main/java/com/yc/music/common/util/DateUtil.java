package com.yc.music.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具
 * 
 * @author panguixiang
 *
 */
public class DateUtil {
	
	/**
	 * 比较两个时间之间的描述差 验证码使用
	 * 
	 * @param codeDate
	 * @return
	 */
	public static boolean compareCodeDateTime(Date codeDate) {
		Date after = new Date();
		boolean flag = codeDate.before(after);
		if (!flag) {
			return false;
		}
		long l = (after.getTime() - codeDate.getTime()) / 1000;
		if (l>0&&l<=60) {
			return true;
		}
		return false;
	}
	
	public static String patternDateToStr(Date date,String pattern) {
		 SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		 return dateFormat.format(date);
	}
	
	public static Date stringToDate(String dateStr,String pattern) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);                
		 Date date = sdf.parse(dateStr);
		 return date;
	}
	
	/**
	 * 
	 * checkSendSmsCodeTime:(校验dateA+minute秒是否小于dateB). <br/> 
	 *
	 * @author panguixiang
	 * @param dateB  需要比较的时间 
	 * @throws ParseException 
	 * @since JDK 1.7
	 */
	public static boolean checkSendSmsCodeTime(Date dateA) throws ParseException {
		Calendar cal = Calendar.getInstance();
		long now = cal.getTimeInMillis();
		cal.setTime(dateA);
		long lastly = cal.getTimeInMillis();
		long c = now - lastly;
		if(c<=60*1000) {//一分钟之内时间差
			return true;
		} else {
			return false;
		}
	}
	
	
}
