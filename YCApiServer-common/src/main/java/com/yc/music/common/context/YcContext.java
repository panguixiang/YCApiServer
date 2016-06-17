package com.yc.music.common.context;

public class YcContext {
	public final static String ENCODE_UTF8="UTF-8";
	
	public final static String DATE_STR_PATTERN="yyyy-MM-dd HH:mm:ss";
	
	public final static String DATE_STR_PATTERN_SSS="yyyy-MM-dd HH:mm:ss:SSS";
	
	public final static String DATE_YMDHmm="yyyy-MM-dd HH:mm";
	
	public final static String DATE_STR_YYYYMM="yyyyMM";
	
	public final static String DATE_STR_YMD="yyyy-MM-dd";
	
	public final static int TOKEN_EXPRESSION_TIME=2592000;
	
	public final static int OFTEN_EXPRESSION_TIME=30;//十分钟之内,开发30秒之内
	
	public static String redis_ip="127.0.0.1";
	
	public static int redis_port=6379;
	
	public static int redis_timeout=300;
	
	public static int redis_MaxIdle=100;
	
	public static long redis_MaxWaitMillis=1l;
	
	public static String redis_auth="2red5**helows0";
	
	public static final String CODE="code";
	
	public static final String MESSAGE="message";
	
	public static final String DATA="data";
	
	public final static String EMPTY_STRING="";
	
	public final static String token="token";
	
	public final static String Slash="/";
	
	public final static char Slashchar='/';
	
	public final static String nextVal = "yyyyMMddHHmmssSSS";
	
	public final static String http_header="http://";
	
	public final static String USER_DEFAULT_HEADER="/default_photo.jpg";
	
	public final static String SYS_ERROR_MSG="系统繁忙";
	
	public final static String Mobile_PARTTEN="^((13[0-9])|(15[^4,\\D])|(18[0-9])|(17[0-9])|(147))\\d{8}$";
}
