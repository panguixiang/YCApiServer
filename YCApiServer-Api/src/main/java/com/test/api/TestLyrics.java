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

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.yc.music.common.secret.RSAToolsClient;
import com.yc.music.common.util.HttpUtil;

/**
 * ClassName: TestLyrics <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月20日 下午3:04:08 <br/>
 *
 * @author panguixiang
 * @version 
 */
public class TestLyrics {

	public static void main(String args[]) {
		//System.out.println(testMusicDetail());
		//System.out.println(testgleedetail());
		System.out.println(saveLyrics());
	}
	public static String saveLyrics() {
		String message = "";
		String entrData = "";
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("exptime", UUID.randomUUID().toString());
		param.put("uid", 42);
		param.put("title", "gecdhititle");//825e46451d0cffee3f7b0c2809ae837a
		param.put("lyrics", "gesdchititle");
		param.put("pic", "gechitdsitle");
		param.put("token", "65c8aa2c42614147e085aef21fd775f3");//65c8aa2c42614147e085aef21fd775f3
		entrData=JSONObject.toJSONString(param);
		String url="http://112.124.125.2/java/lyricsopt/optLyrics";
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
	 * testLyricsDetail:(歌词-详情). <br/> 
	 *
	 * @author panguixiang
	 * @return
	 * @since JDK 1.7
	 */
	public static String testLyricsDetail() {
		String message = "";
		String entrData = "";
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("exptime", UUID.randomUUID().toString());
		
		param.put("id", 1);
		entrData=JSONObject.toJSONString(param);
		String url="http://localhost:8080/java/common/lyrics/detail";
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
	 * testLyricsFind:(发现-歌词). <br/> 
	 *
	 * @author panguixiang
	 * @return
	 * @since JDK 1.7
	 */
	public static String testLyricsFind() {
		String message = "";
		String entrData = "";
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("exptime", UUID.randomUUID().toString());
		param.put("name", "");
		entrData=JSONObject.toJSONString(param);
		String url="http://localhost:8080/java/common/find/morelyrics";
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
	
}
