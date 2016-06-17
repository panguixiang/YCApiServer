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
import com.yc.music.service.service103.MessageService;

/**
 * 系统消息中心 controller api
 * ClassName: SysMessageController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月13日 下午5:25:59 <br/>
 *
 * @author panguixiang
 * @version
 */
@Controller
@RequestMapping("/message")
public class SysMessageController {
	
	private static Logger logger = Logger.getLogger(SysMessageController.class);


	@Autowired
	private MessageService messageService;
	
	/**
	 * 
	 * center:(进入消息中心). <br/> 
	 *
	 * @author panguixiang
	 * @param uid
	 * @return
	 * @since JDK 1.7
	 */
	@ResponseBody
	@RequestMapping(value="center", method = RequestMethod.GET, produces = "application/json")
	public Map<String,Object> center(
			@RequestParam("uid") Long uid) {
		
		Map<String,Object> result  = new HashMap<String,Object>();
		try {
			messageService.center(uid,result);
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
	 * commentCenterList:(消息中心-评论列表). <br/> 
	 *
	 * @author panguixiang
	 * @param uid
	 * @param page
	 * @return
	 * @since JDK 1.7
	 */
	@ResponseBody
	@RequestMapping(value="commentCenterList", method = RequestMethod.GET, produces = "application/json")
	public Map<String,Object> commentCenterList(
			@RequestParam("uid") Long uid,
			@RequestParam(value="page",required=false) Integer page) {
		
		Map<String,Object> result  = new HashMap<String,Object>();
		try {
			messageService.commentCenterList(uid,page,result);
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
	 * zanCenterList:(消息中心-点赞列表). <br/> 
	 *
	 * @author panguixiang
	 * @param uid
	 * @param page
	 * @return
	 * @since JDK 1.7
	 */
	@ResponseBody
	@RequestMapping(value="zanCenterList", method = RequestMethod.GET, produces = "application/json")
	public Map<String,Object> zanCenterList(
			@RequestParam("uid") Long uid,
			@RequestParam(value="page",required=false) Integer page) {
		
		Map<String,Object> result  = new HashMap<String,Object>();
		try {
			messageService.zanCenterList(uid,page,result);
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
	 * fovMyCenterList:(消息中心-收藏列表). <br/> 
	 *
	 * @author panguixiang
	 * @param uid
	 * @param page
	 * @return
	 * @since JDK 1.7
	 */
	@ResponseBody
	@RequestMapping(value="fovMyCenterList", method = RequestMethod.GET, produces = "application/json")
	public Map<String,Object> fovMyCenterList(
			@RequestParam("uid") Long uid,
			@RequestParam(value="page",required=false) Integer page) {
		
		Map<String,Object> result  = new HashMap<String,Object>();
		try {
			messageService.fovMyCenterList(uid,page,result);
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
	 * sysNoteList:(消息中心-系统消息列表). <br/> 
	 * 后面做后台时候再规划，这里暂定
	 * @author panguixiang
	 * @param uid
	 * @param page
	 * @return
	 * @since JDK 1.7
	 */
	@ResponseBody
	@RequestMapping(value="sysNoteList", method = RequestMethod.GET, produces = "application/json")
	public Map<String,Object> sysNoteList(
			@RequestParam("uid") Long uid,
			@RequestParam(value="page",required=false) Integer page) {
		
		Map<String,Object> result  = new HashMap<String,Object>();
		result.put(YcContext.CODE, 200);
		result.put(YcContext.MESSAGE, YcContext.EMPTY_STRING);
		result.put(YcContext.DATA,YcContext.EMPTY_STRING);
		return result;
	}
}
