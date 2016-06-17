/**
 * Project Name:YCApiServer-Api
 * File Name:OtherCenterController.java
 * Package Name:com.yc.music.controller.Api.common
 * Date:2016年5月10日下午1:21:14
 * Copyright (c) 2016 
 *
 */
package com.yc.music.controller.Api.common;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.music.common.context.YcContext;
import com.yc.music.service.service103.UserCenterService;

/**
 * 他人个人主页 api
 * ClassName: OtherCenterController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月10日 下午1:21:14 <br/>
 *
 * @author panguixiang
 * @version 
 */
@Controller
@RequestMapping("/common/otherCenter")
public class OtherCenterController {

	private static Logger logger = Logger.getLogger(OtherCenterController.class);
	
	@Autowired
	private UserCenterService userCenterService;
	
	/**
	 * 
	 * index:(他人中心). <br/> 
	 *
	 * @author panguixiang
	 * @param otherid 他人ID
	 * @param uid 用户ID 可为空
	 * @param type 可为空  （ null,0,1=歌曲，2=歌词，3=收藏）
	 * @return
	 * @since JDK 1.7
	 */
	@ResponseBody
	@RequestMapping(value="index", method = RequestMethod.GET, produces = "application/json")
	public Map<String,Object> index(@RequestParam("otherid") Long otherid,
			@RequestParam(value="uid",required=false) Long uid,
			@RequestParam(value="page",required=false) Integer page,
			@RequestParam(value="type",required=false) Integer type) {
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			userCenterService.otherUserCenterDetail(otherid, uid,type,page,result);
		} catch (Exception e) {
			result.put(YcContext.CODE, 500);
			result.put(YcContext.MESSAGE, YcContext.SYS_ERROR_MSG);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			logger.error(e);
		}
		return result;
	}
}
