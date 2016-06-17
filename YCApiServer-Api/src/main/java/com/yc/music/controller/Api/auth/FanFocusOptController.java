/**
 * Project Name:YCApiServer-Api
 * File Name:FanFocusOptController.java
 * Package Name:com.yc.music.controller.Api.auth
 * Date:2016年5月19日上午11:20:06
 * Copyright (c) 2016 
 *
 */
package com.yc.music.controller.Api.auth;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.music.common.context.YcContext;
import com.yc.music.model.fansfocus.FansOpt;
import com.yc.music.service.service103.FansFocusService;

/**
 * ClassName: FanFocusOptController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月19日 上午11:20:06 <br/>
 *
 * @author panguixiang
 * @version 
 */
@Controller
@RequestMapping("/fanfocus")
public class FanFocusOptController {

	private static Logger logger = Logger.getLogger(FanFocusOptController.class);
	
	@Autowired
	private FansFocusService fansFocusService;
	
	/**
	 * 
	 * optFans:(粉丝关注，取消关注). <br/> 
	 *
	 * @author panguixiang
	 * @param opt
	 * @param binding
	 * @return
	 * @since JDK 1.7
	 */
	@ResponseBody
	@RequestMapping(value="optFans", method = RequestMethod.POST, produces = "application/json")
	public Map<String,Object> optFans(@Valid FansOpt opt, BindingResult binding) {
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			fansFocusService.optFansFocus(opt, binding, result);
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
	 * optFans:(获得关注，粉丝 列表). <br/> 
	 *
	 * @author panguixiang
	 * @param userid  当前登录用户的id
	 * @param page  页码 
	 * @param type  1=我的粉丝列表 (别人关注我) 2=我的关注列表 （我关注别人）
	 * @return
	 * @since JDK 1.7
	 */
	@ResponseBody
	@RequestMapping(value="fanslist", method = RequestMethod.GET, produces = "application/json")
	public Map<String,Object> fanslist(@RequestParam("userid") Long userid,
			@RequestParam("type") Integer type,@RequestParam(value="page",required=false) Integer page) {
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			fansFocusService.foucusList(userid, page,type, result);
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
	 * optFans:(获得别人关注，粉丝 列表). <br/> 
	 *
	 * @author panguixiang
	 * @param userid  进入空间的用户id
	 * @param uid  我的id
	 * @param page  页码 
	 * @param type  1=别人的粉丝列表  2=别人的关注列表 
	 * @return
	 * @since JDK 1.7
	 */
	@ResponseBody
	@RequestMapping(value="otherfanslist", method = RequestMethod.GET, produces = "application/json")
	public Map<String,Object> otherfanslist(@RequestParam("userid") Long userid,
			@RequestParam("uid") Long uid,
			@RequestParam("type") Integer type,@RequestParam(value="page",required=false) Integer page) {
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			fansFocusService.otherfoucusList(userid,uid, page,type, result);
		} catch (Exception e) {
			e.printStackTrace();
			result.put(YcContext.CODE, 500);
			result.put(YcContext.MESSAGE, YcContext.SYS_ERROR_MSG);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			logger.error(e);
		}
		return result;
	}
}
