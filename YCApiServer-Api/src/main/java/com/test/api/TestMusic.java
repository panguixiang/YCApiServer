/**
 * Project Name:YCApiServer-Api
 * File Name:TestApi.java
 * Package Name:com.test.api
 * Date:2016年5月20日下午3:04:08
 * Copyright (c) 2016 
 *
 */
package com.test.api;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.NotBlank;

import com.alibaba.fastjson.JSONObject;
import com.yc.music.common.secret.RSAToolsClient;
import com.yc.music.common.util.HttpUtil;

/**
 * ClassName: TestMusic <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月20日 下午3:04:08 <br/>
 *
 * @author panguixiang
 * @version 
 */
public class TestMusic {

	public static void main(String args[]) {
		//System.out.println(testMusicDetail());
		//System.out.println(testgleedetail());
		System.out.println(testusercenter());
	}
	
	public static String testusercenter() {
		String message = "";
		String entrData = "";
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("exptime", UUID.randomUUID().toString());
		param.put("uid", 26244);
		param.put("token", "f61efafe9976d1b879ec01cfc9450a61");
		//param.put("page", 1);
		param.put("type", 1);
		entrData=JSONObject.toJSONString(param);
		String url="http://112.124.125.2/java/userCenter/index";
		try {
			entrData=RSAToolsClient.encodeStr(RSAToolsClient.RSAENcode(entrData));;
			message=HttpUtil.sendMobileCodeGet(url,"data="+entrData);
			JSONObject result = JSONObject.parseObject(message);
			System.out.println("=====code=="+result.get("code"));
			System.out.println("=====message=="+result.get("message"));
			message=result.getString("data");
			message=RSAToolsClient.RSADecode(RSAToolsClient.decodeStr(message));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}
	
	public static String turnmusic() {
		
		String message = "";
		String entrData = "";
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("exptime", UUID.randomUUID().toString());
		param.put("useheadset", 0);
		param.put("recordingsize", 1);
		param.put("musicurl", "/Zero.mp3");
		param.put("hotid", 1);
		param.put("uid", 3733);
		param.put("bgmsize", 1);
		param.put("createtype", "HOT");
		param.put("token", "af96374c7c0f39a2233b1fa5cb2c36a3");
		entrData=JSONObject.toJSONString(param);
		String url="http://112.124.125.2/java/musiopt/tuningMusic";
		try {
			entrData=RSAToolsClient.encodeStr(RSAToolsClient.RSAENcode(entrData));;
			
			Map<String,String> register = new HashMap<String,String>();
			register.put("data", entrData);
			message=HttpUtil.sendPost(url,register);
			JSONObject result = JSONObject.parseObject(message);
			System.out.println("=====result=="+result);
			message=result.getString("data");
			message=RSAToolsClient.RSADecode(RSAToolsClient.decodeStr(message));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}
	/**
	 * 
	 * testMusicDetail:(歌曲详情). <br/> 
	 *
	 * @author panguixiang
	 * @return
	 * @since JDK 1.7
	 */
	public static String testMusicDetail() {
		String message = "";
		String entrData = "";
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("exptime", UUID.randomUUID().toString());
		
		param.put("id", 327);
		param.put("openmodel", 1);
		entrData=JSONObject.toJSONString(param);
		String url="http://localhost:8080/java/common/music/work";
		try {
			entrData=RSAToolsClient.encodeStr(RSAToolsClient.RSAENcode(entrData));;
			message=HttpUtil.sendMobileCodeGet(url,"data="+entrData);
			JSONObject result = JSONObject.parseObject(message);
			System.out.println("=====code=="+result.get("code"));
			System.out.println("=====message=="+result.get("message"));
			message=result.getString("data");
			message=RSAToolsClient.RSADecode(RSAToolsClient.decodeStr(message));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}
	
	/**
	 * 
	 * testActivityFind:(发现-活动). <br/> 
	 *
	 * @author panguixiang
	 * @return
	 * @since JDK 1.7
	 */
	public static String testActivityFind() {
		String message = "";
		String entrData = "";
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("exptime", UUID.randomUUID().toString());
		param.put("name", "");
		entrData=JSONObject.toJSONString(param);
		String url="http://112.124.125.2/java/common/find/activelist";
		try {
			entrData=RSAToolsClient.encodeStr(RSAToolsClient.RSAENcode(entrData));;
			message=HttpUtil.sendMobileCodeGet(url,"data="+entrData);
			JSONObject result = JSONObject.parseObject(message);
			System.out.println("=====code=="+result.get("code"));
			System.out.println("=====message=="+result.get("message"));
			message=result.getString("data");
			if(StringUtils.isNotBlank(message)) {
				message=RSAToolsClient.RSADecode(RSAToolsClient.decodeStr(message));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}
	
	
	/**
	 * 
	 * testgleedetail:(歌单详情). <br/> 
	 *
	 * @author panguixiang
	 * @return
	 * @since JDK 1.7
	 */
	public static String testgleedetail() {
		String message = "";
		String entrData = "";
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("exptime", UUID.randomUUID().toString());
		param.put("id", 1);
		entrData=JSONObject.toJSONString(param);
		String url="http://112.124.125.2/java/common/glee/detail";
		try {
			entrData=RSAToolsClient.encodeStr(RSAToolsClient.RSAENcode(entrData));;
			message=HttpUtil.sendMobileCodeGet(url,"data="+entrData);
			JSONObject result = JSONObject.parseObject(message);
			System.out.println(result.toJSONString());
			message=result.getString("data");
			if(StringUtils.isNotBlank(message)) {
				message=RSAToolsClient.RSADecode(RSAToolsClient.decodeStr(message));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}
	
	
	public static String testuploadcallback() {
		String message = "";
		String entrData = "";
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("exptime", UUID.randomUUID().toString());
		param.put("type", 1);
		param.put("fixx", "lyrcover");
		entrData=JSONObject.toJSONString(param);
		String url="http://localhost:8080/java/common/uploadcallback/qiniutoken";
		try {
			entrData=RSAToolsClient.encodeStr(RSAToolsClient.RSAENcode(entrData));;
			message=HttpUtil.sendMobileCodeGet(url,"data="+entrData);
			JSONObject result = JSONObject.parseObject(message);
			System.out.println("=====result=="+result.toJSONString());
			message=result.getString("data");
			message=RSAToolsClient.RSADecode(RSAToolsClient.decodeStr(message));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}
}
