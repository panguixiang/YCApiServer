/**
 * Project Name:YCApiServer-Api
 * File Name:WorkZanController.java
 * Package Name:com.yc.music.controller.Api.auth
 * Date:2016年5月19日上午10:31:58
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.music.common.context.YcContext;
import com.yc.music.model.OptWork;
import com.yc.music.service.service103.WorkFovService;
/**
 * 歌词，歌曲，收藏  api
 * ClassName: WorkFovController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月19日 上午10:53:21 <br/>
 *
 * @author panguixiang
 * @version 
 */
@Controller
@RequestMapping("/workfov")
public class WorkFovController {
	private static Logger logger = Logger.getLogger(WorkFovController.class);
	
	@Autowired
	private WorkFovService workFovService;
	
	/**
	 * 
	 * OptWork:(歌词 歌曲  收藏，取消收藏). <br/> 
	 *
	 * @author panguixiang
	 * @param opt
	 * @param binding
	 * @return
	 * @since JDK 1.7
	 */
	@ResponseBody
	@RequestMapping(value="optZan", method = RequestMethod.POST, produces = "application/json")
	public Map<String,Object> optZan(@Valid OptWork opt, BindingResult binding) {
		
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			workFovService.optWorkFov(opt, binding, result);
		} catch (Exception e) {
			result.put(YcContext.CODE, 500);
			result.put(YcContext.MESSAGE, YcContext.SYS_ERROR_MSG);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			logger.error(e);
		}
		return result;
	}
}
