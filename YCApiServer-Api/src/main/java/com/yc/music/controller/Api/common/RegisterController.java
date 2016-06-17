/**
 * Project Name:YCApiServer-Api
 * File Name:RegisterController.java
 * Package Name:com.yc.music.controller.Api.common
 * Date:2016年5月3日上午11:30:14
 * Copyright (c) 2016 
 *
 */
package com.yc.music.controller.Api.common;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.music.common.context.YcContext;
import com.yc.music.model.User;
import com.yc.music.service.service103.UserService1003;

/**
 * 注册controller
 * ClassName: RegisterController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月3日 上午11:30:14 <br/>
 *
 * @author panguixiang
 * @version 
 */
@Controller
@RequestMapping("/common/regist")
public class RegisterController {

	private static Logger logger = Logger.getLogger(RegisterController.class);
	
	@Autowired
	private UserService1003 userService;
	
	/**
	 * 用户手机注册
	 * @param user
	 * @param errors
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="mobile", method = RequestMethod.POST, produces = "application/json")
	public Map<String,Object> registerMobile(@Valid User user,BindingResult binding) {
		
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			userService.saveMobileUser(user,binding,result);
		} catch (Exception e) {
			result.put(YcContext.CODE, 500);
			result.put(YcContext.MESSAGE, YcContext.SYS_ERROR_MSG);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			logger.error(e);
		}
		return result;
	}
}
