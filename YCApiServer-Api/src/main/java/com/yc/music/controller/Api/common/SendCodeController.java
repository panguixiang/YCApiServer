/**
 * Project Name:YCApiServer-Api
 * File Name:SendCodeController.java
 * Package Name:com.yc.music.controller.Api.auth
 * Date:2016年5月11日上午10:05:06
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
import com.yc.music.service.service103.SendCodeService;

/**
 * 发送短信验证码
 * ClassName: SendCodeController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月11日 上午10:05:06 <br/>
 *
 * @author panguixiang
 * @version 
 */
@Controller
@RequestMapping("/common/send")
public class SendCodeController {
	
	private static Logger logger = Logger.getLogger(SendCodeController.class);

	@Autowired
	private SendCodeService sendCodeService;
	/**
	 * 验证码发送
	 * code:(这里用一句话描述这个方法的作用). <br/> 
	 *
	 * @author panguixiang
	 * @param mobile
	 * @param type
	 * @return
	 * @since JDK 1.7
	 */
	@ResponseBody
	@RequestMapping(value="code", method = RequestMethod.GET, produces = "application/json")
	public Map<String,Object> code(@RequestParam("mobile") String mobile,
			@RequestParam(value="type",required=false) String type,HttpServletRequest request) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			resultMap = sendCodeService.sendRegisterCode(mobile, type, RoomUtil.getClientIp(request),resultMap);
		} catch (Exception e) {
			resultMap.put(YcContext.CODE, 500);
			resultMap.put(YcContext.MESSAGE, YcContext.SYS_ERROR_MSG);
			resultMap.put(YcContext.DATA,YcContext.EMPTY_STRING);
			logger.error(e);
		}
		return resultMap;
	}
	
}
