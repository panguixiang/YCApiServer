/**
 * Project Name:YCApiServer-Api
 * File Name:WorkController.java
 * Package Name:com.yc.music.controller.Api.common
 * Date:2016年5月5日下午6:54:47
 * Copyright (c) 2016 
 *
 */
package com.yc.music.controller.Api.auth;

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
import com.yc.music.model.musicuser.UserInfo;
import com.yc.music.service.service103.UserCenterService;
import com.yc.music.service.service103.UserService1003;

/**
 * 用户个人主页
 * ClassName: UserCenterController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月8日 下午5:44:19 <br/>
 *
 * @author panguixiang
 * @version
 */
@Controller
@RequestMapping("/userCenter")
public class UserCenterController {
	
	private static Logger logger = Logger.getLogger(UserCenterController.class);

	@Autowired
	private UserCenterService userCenterService;
	
	@Autowired
	private UserService1003 userService;
	
	/**
	 * 
	 * index:(用户个人中心). <br/> 
	 *
	 * @author panguixiang
	 * @param uid 用户ID 
	 * @param type 可为空  （ null,0,1=歌曲，2=歌词，3=收藏,4=灵感记录）
	 * @return
	 * @since JDK 1.7
	 */
	@ResponseBody
	@RequestMapping(value="index", method = RequestMethod.GET, produces = "application/json")
	public Map<String,Object> index(
			@RequestParam("uid") Long uid,
			@RequestParam(value="page",required=false) Integer page,
			@RequestParam(value="type",required=false) Integer type) {
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			userCenterService.userCenterDetail(uid, type,page,result);
		} catch (Exception e) {
			result.put(YcContext.CODE, 500);
			result.put(YcContext.MESSAGE, YcContext.SYS_ERROR_MSG);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			logger.error(e);
		}
		return result;
	}
	/**
	 * 
	 * updateUserInfo:(修改个人信息). <br/> 
	 *
	 * @author panguixiang
	 * @param info
	 * @return
	 * @since JDK 1.7
	 */
	@ResponseBody
	@RequestMapping(value="updateuserinfo", method = RequestMethod.POST, produces = "application/json")
	public Map<String,Object> updateUserInfo(UserInfo info) {
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			userService.updateUserInfo(info, result);
		} catch (Exception e) {
			result.put(YcContext.CODE, 500);
			result.put(YcContext.MESSAGE, YcContext.SYS_ERROR_MSG);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			logger.error(e);
		}
		return result;
	}
	
	/**
	 * 
	 * deleteWork:(删除个人主页歌曲，歌词，灵感记录). <br/> 
	 *
	 * @author panguixiang
	 * @param id
	 * @param type  1=歌曲，2=歌词，3=灵感记录
	 * @return
	 * @since JDK 1.7
	 */
	@ResponseBody
	@RequestMapping(value="deleteWork", method = RequestMethod.POST, produces = "application/json")
	public Map<String,Object> deleteWork(@RequestParam("id") Long id,@RequestParam("type") Integer type) {
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			userCenterService.deleteWork(id,type, result);
		} catch (Exception e) {
			result.put(YcContext.CODE, 500);
			result.put(YcContext.MESSAGE, YcContext.SYS_ERROR_MSG);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			logger.error(e);
		}
		return result;
	}
}
