/**
 * Project Name:YCApiServer-Api
 * File Name:WorkController.java
 * Package Name:com.yc.music.controller.Api.common
 * Date:2016年5月5日下午6:54:47
 * Copyright (c) 2016 
 *
 */
package com.yc.music.controller.Api.common;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yc.music.common.context.YcContext;
import com.yc.music.common.util.RedisUtil;
import com.yc.music.model.UserLoginVo;

@Controller
@RequestMapping("/common/tredis")
public class TredisController {
	
	@ResponseBody
	@RequestMapping(value="do", method = RequestMethod.GET, produces = "application/json")
	public Map<String,Object> tRedis(@RequestParam(value="token",required=false) String token,
			@RequestParam(value="page",required=false) Integer page) {
		UserLoginVo loginVo = null;
		if(!RedisUtil.checkLoginToken(token,YcContext.TOKEN_EXPRESSION_TIME)) {
			String loginToken = DigestUtils.md5Hex(UUID.randomUUID().toString());
			loginVo=new UserLoginVo();
			loginVo.setHeadurl("http://www.baidu.com/a/j.jpg");
			loginVo.setLoginToken(loginToken);
			loginVo.setName("小明");
			RedisUtil.saveString(loginToken,JSONObject.toJSONString(loginVo),2536323);
		} 
			
		Map<String,Object> result  = new HashMap<String,Object>();
		result.put(YcContext.CODE, 200);
		result.put(YcContext.MESSAGE, YcContext.EMPTY_STRING);
		result.put(YcContext.DATA,loginVo);
		return result;
	}
	
}
