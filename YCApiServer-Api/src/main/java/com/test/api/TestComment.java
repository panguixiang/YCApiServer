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

import com.alibaba.fastjson.JSONObject;
import com.yc.music.common.secret.RSAToolsClient;
import com.yc.music.common.util.HttpUtil;

/**
 * ClassName: TestComment <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月20日 下午3:04:08 <br/>
 *
 * @author panguixiang
 * @version 
 */
public class TestComment {

	public static void main(String args[]) {
		System.out.println(testLST());
	}
	
	public static String testLST() {
		String message = "";
		String entrData = "";
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("exptime", UUID.randomUUID().toString());
		param.put("itemid", 32);
		param.put("type", 1);
		entrData=JSONObject.toJSONString(param);
		String url="http://localhost:8080/java/common/comment/list";
		try {
			entrData=RSAToolsClient.encodeStr(RSAToolsClient.RSAENcode(entrData));;
			message=HttpUtil.sendMobileCodeGet(url,"data="+entrData);
			JSONObject result = JSONObject.parseObject(message);
			message=result.getString("data");
			message=RSAToolsClient.RSADecode(RSAToolsClient.decodeStr(message));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}
	
	
	public static String testSave() {
		String message = "";
		String entrData = "";
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("exptime", UUID.randomUUID().toString());
		param.put("comment", "13823605273");
		param.put("uid", 123);
		param.put("comment_type", 1);
		param.put("itemid", 137);
		param.put("type", 1);
		param.put("token", "2d83cae7167f7bfc484a6090f487272b");
		entrData=JSONObject.toJSONString(param);
		String url="http://localhost:8080/java/commentopt/save";
		try {
			entrData=RSAToolsClient.encodeStr(RSAToolsClient.RSAENcode(entrData));;
			
			Map<String,String> register = new HashMap<String,String>();
			register.put("data", entrData);
			message=HttpUtil.sendPost(url,register);
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
	
}
