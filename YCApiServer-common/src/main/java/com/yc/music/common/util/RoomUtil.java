package com.yc.music.common.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.yc.music.common.context.YcContext;

public class RoomUtil {

	
	
	public static String findNextVal(String file) {
		SimpleDateFormat formatDate = new SimpleDateFormat(YcContext.nextVal);
		StringBuilder builder = new StringBuilder(file);
		builder.append(formatDate.format(new Date()));
		return builder.append(String.valueOf(Math.round(Math.random() * 89999 + 10000))).toString();
	}
	
	/**
	 * 获得业务系统服务器的IP
	 * 
	 * @param request
	 * @return
	 */
	public static String getClientIp(HttpServletRequest request) {
		String ipAddress = null;
		// ipAddress = this.getRequest().getRemoteAddr();
		ipAddress = request.getHeader("x-forwarded-for");
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
			if (ipAddress.equals(YcContext.redis_ip)) {
				// 根据网卡取本机配置的IP
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					ipAddress="";
				}
				ipAddress = inet.getHostAddress();
			}

		}
		// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length()
															// = 15
			if (ipAddress.indexOf(",") > 0) {
				ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
			}
		}
		return ipAddress;
	}
	
	private static final String url_pattern="[^//]*?\\.(com|cn|net|org|biz|info|cc|tv)";
	private static final String http_suff="http://";
	
	/**
	 * 
	 * replaceAllDomain:(替换掉url字符串里面的域名包括http). <br/> 
	 *
	 * @author panguixiang
	 * @param urlStr
	 * @return
	 * @since JDK 1.7
	 */
	public static String replaceAllDomain(String urlStr) {
		//("(?<=http://|\\.)[^.]*?\\.(com|cn|net|org|biz|info|cc|tv)
		Pattern pattern = Pattern.compile(url_pattern,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(urlStr);
		String y=YcContext.EMPTY_STRING;
		while(matcher.find()) {
			y=matcher.group();
			urlStr=urlStr.replace(http_suff.concat(y), YcContext.EMPTY_STRING);
		}
		return urlStr;
	}
	
	public static String batchSlash(String strSlash) {
		if(StringUtils.isBlank(strSlash)) {
			return YcContext.EMPTY_STRING;
		}
		strSlash=strSlash.replace(",", ",/");
		if(strSlash.charAt(0)!=YcContext.Slashchar) {
			strSlash=YcContext.Slash.concat(strSlash);
		}
		strSlash=strSlash.replace("//", "/");
		return strSlash;
	}
	/**
	 * 
	 * batchDomain:(strSlash 添加域名). <br/> 
	 *  str="/abc/a.html,/dec/b.html"
	 * @author panguixiang
	 * @param strSlash 逗号分隔的地址
	 * @param domain
	 * @return
	 * @since JDK 1.7
	 */
	public static String batchDomain(String strSlash,String domain) {
		if(StringUtils.isBlank(strSlash)) {
			return YcContext.EMPTY_STRING;
		}
		strSlash=strSlash.replace(",/", ","+domain+YcContext.Slash);
		strSlash=domain.concat(strSlash);
		return strSlash;
	}
	
	/**
	 * 添加单个url地址的域名
	 * 1.url为空的情况
	 * 2.url带domain域名的请求
	 * 3.url带其他域名的情况
	 * 4.url不带域名的情况
	 * 5.url不带域名，第一个字符不是 '/'的情况
	 * @param url
	 * @param domain
	 * @return
	 */
	public static String jointDomain(String url,String domain) {
		if(StringUtils.isBlank(url)) {//若url为空，则返回空字符串
			return YcContext.EMPTY_STRING;
		}
		if(url.indexOf(domain)>-1) {//判断此url是否已经有了此domain域名
			return url;
		}
		if(url.indexOf(YcContext.http_header)>-1) {//判断此url是否存在其他域名，有则先删除
			int index=url.indexOf(YcContext.Slash, url.indexOf(YcContext.Slash)+2);
			StringBuffer buffer = new StringBuffer(url);
			buffer.replace(0, index, YcContext.EMPTY_STRING);
			url=buffer.toString();
		}
		url=(url.charAt(0)!=YcContext.Slashchar)?String.valueOf(YcContext.Slashchar).concat(url):url;//处理 url没有 '/' 的请求
		url=replaceAllDomain(url);
		url=domain.concat(url);
		return url;
	}
	
	
	/**
     * 随机生成6位随机验证码
      * 方法说明
      * @Discription:扩展说明
      * @return
      * @return String
      * @Author: feizi
      * @Date: 2015年4月17日 下午7:19:02
      * @ModifyUser：feizi
      * @ModifyDate: 2015年4月17日 下午7:19:02
     */
    public static String createRandomVcode(){
        //验证码
        StringBuffer vcode = new StringBuffer();
        for (int i = 0; i < 6; i++) {
        	vcode.append((int)(Math.random() * 9));
        }
        return vcode.toString();
    }
    
}
