/**
 * Project Name:YCApiServer-Api
 * File Name:LoginController.java
 * Package Name:com.yc.music.controller.Api.common
 * Date:2016年5月3日上午11:47:38
 * Copyright (c) 2016 
 *
 */
package com.yc.music.controller.Api.common;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.music.common.context.YcContext;
import com.yc.music.common.util.RoomUtil;
import com.yc.music.service.service103.UserService1003;

/**
 * 登录controller
 * ClassName: LoginController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月3日 上午11:47:38 <br/>
 *
 * @author panguixiang
 * @version 
 */
@Controller
@RequestMapping("/common/login")
public class LoginController {
	
	private static Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	private UserService1003 userService;
	
	/**
	 * 用户手机登录
	 * @param user
	 * @param errors
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="mobile", method = RequestMethod.POST, produces = "application/json")
	public Map<String,Object> loginbymob(@RequestParam("mobile") String mobile,
			@RequestParam("password") String password,HttpServletRequest request) {
		
		Map<String,Object> result = new HashMap<String,Object>();
		String clientIp = RoomUtil.getClientIp(request);
		try {
			 userService.loginMobile(mobile, password,result,clientIp);
		} catch (Exception e) {
			result.put(YcContext.CODE, 500);
			result.put(YcContext.MESSAGE, YcContext.SYS_ERROR_MSG);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			logger.error(e);
		}
		return result;
	}
	
	/**
	 * 校验token是否已经过期
	 * @param user
	 * @param errors
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="tokenCheck", method = RequestMethod.POST, produces = "application/json")
	public Map<String,Object> tokenCheck(@RequestParam("token") String token) {
		
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			 userService.checkToken(token,result);
		} catch (Exception e) {
			result.put(YcContext.CODE, 500);
			result.put(YcContext.MESSAGE, YcContext.SYS_ERROR_MSG);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			logger.error(e);
		}
		return result;
	}
	
	
	/**
	 * 密码重置
	 * @param user
	 * @param errors
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="resetPassword", method = RequestMethod.POST, produces = "application/json")
	public Map<String,Object> resetPassword(@RequestParam("mobile") String mobile,
			@RequestParam("code") String code,
			@RequestParam("password") String password) {
		
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			result=userService.resetpassword(mobile,code,password,result);
		} catch (Exception e) {
			result.put(YcContext.CODE, 500);
			result.put(YcContext.MESSAGE, YcContext.SYS_ERROR_MSG);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			logger.error(e);
		}
		return result;
	}
	
	
	/**
	 * 退出登录
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="logout", method = RequestMethod.POST, produces = "application/json")
	public Map<String,Object> logout(@RequestParam("token") String token) {
		
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			 userService.loginOut(token,result);
		} catch (Exception e) {
			result.put(YcContext.CODE, 500);
			result.put(YcContext.MESSAGE, YcContext.SYS_ERROR_MSG);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			logger.error(e);
		}
		return result;
	}
}
