package com.yc.music.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import com.yc.music.common.context.YcContext;


/**
 * http apache 工具包
 * @author panguixiang
 *
 */
public class HttpUtil {

	/**
	 * httpclient发送post请求
	 * @param url
	 * @param Map<String,String>  data
	 * @return
	 */
	public static String sendPost(String url, Map<String,String> data) throws Exception{
		HttpClient httpclient = new HttpClient();
		//设置http头  
        List<Header> headers = new ArrayList<Header>();  
        headers.add(new Header("User-Agent", "AS39e2dkdoi283/4.0"));  
	    httpclient.getHostConfiguration().getParams().setParameter("http.default-headers", headers);
        PostMethod method = new PostMethod(url);
        method.setRequestHeader("Connection", "close");
        method.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,  
                new DefaultHttpMethodRetryHandler(3, false)); 
        httpclient.getHttpConnectionManager().getParams().setConnectionTimeout(4000);//请求超时时长
        NameValuePair[] param = new NameValuePair[data.size()];
        int offSet=0;
        for (Map.Entry<String, String> entry : data.entrySet()) {
        	param[offSet] = new NameValuePair(entry.getKey(), entry.getValue());
        	++offSet;
        }
        try {
		    method.setRequestBody(param);
			httpclient.executeMethod(method);
			byte[] b  = method.getResponseBody();
			String resutl = new String(b,YcContext.ENCODE_UTF8);
			return resutl;
		} catch (Exception e) {
			throw new Exception("发送http=== "+url+" , post请求发生系统异常===",e);
		} finally {
			if(method!=null) {
				method.abort();
				method.releaseConnection();
			}
		}
	}
	
	/**
	 * httpclient发送get请求
	 * @param url
	 * @param data
	 * @return
	 */
	public static String sendGet(String url, String data) throws Exception{
		HttpClient httpclient = new HttpClient();
		//设置http头  
        List<Header> headers = new ArrayList<Header>();  
        headers.add(new Header("User-Agent", "AS39e2dkdoi283/4.0"));  
	    httpclient.getHostConfiguration().getParams().setParameter("http.default-headers", headers);
		url+="?data="+data;
        GetMethod method = new GetMethod(url);
        method.setRequestHeader("Connection", "close");
        method.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,  
                new DefaultHttpMethodRetryHandler(3, false)); 
        httpclient.getHttpConnectionManager().getParams().setConnectionTimeout(4000);//请求超时时长
		try {
			httpclient.executeMethod(method);
			byte[] b  = method.getResponseBody();
			String resutl = new String(b,YcContext.ENCODE_UTF8);
			return resutl;
		} catch (Exception e) {
			throw new Exception("发送http=== "+url+" , get请求发生系统异常===",e);
		} finally {
			if(method!=null) {
				method.abort();
				method.releaseConnection();
			}
		}
	}
	
	
	/**
	 * httpclient发送get请求
	 * @param url
	 * @param data
	 * @return
	 */
	public static String sendMobileCodeGet(String url, String data) throws Exception{
		HttpClient httpclient = new HttpClient();
		//设置http头  
        List<Header> headers = new ArrayList<Header>();  
        headers.add(new Header("User-Agent", "AS39e2dkdoi283/4.0"));  
	    httpclient.getHostConfiguration().getParams().setParameter("http.default-headers", headers);
		url+="?"+data;
        GetMethod method = new GetMethod(url);
        method.setRequestHeader("Connection", "close");
        method.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,  
                new DefaultHttpMethodRetryHandler(3, false)); 
        httpclient.getHttpConnectionManager().getParams().setConnectionTimeout(4000);//请求超时时长
		try {
			httpclient.executeMethod(method);
			byte[] b  = method.getResponseBody();
			String resutl = new String(b,YcContext.ENCODE_UTF8);
			return resutl;
		} catch (Exception e) {
			throw new Exception("发送短信验证码http=== "+url+" ,GET请求发生系统异常===",e);
		} finally {
			if(method!=null) {
				method.abort();
				method.releaseConnection();
			}
		}
	}
}
