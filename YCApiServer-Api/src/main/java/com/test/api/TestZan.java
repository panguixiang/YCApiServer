/**
 * Project Name:YCApiServer-Api
 * File Name:TestZan.java
 * Package Name:com.test.api
 * Date:2016年6月6日下午2:47:22
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
 * ClassName: TestZan <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年6月6日 下午2:47:22 <br/>
 *
 * @author panguixiang
 * @version 
 */
public class TestZan {

	public static void main(String args[]){
		System.out.println(saveZan());
	}
	
	public static String saveZan() {
		String message = "";
		String entrData = "";
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("exptime", UUID.randomUUID().toString());
		param.put("work_id", 42);
		param.put("target_uid", 32);
		param.put("user_id", 12);
		param.put("wtype", 1);
		param.put("token", "2d83cae7167f7bfc484a6090f487272b");
		entrData=JSONObject.toJSONString(param);
		String url="http://112.124.125.2/java/workzan/optZan";
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
}
