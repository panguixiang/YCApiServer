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
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.music.common.context.YcContext;
import com.yc.music.model.report.Report;
import com.yc.music.service.service103.FeedBackService;

/**
 * 意见反馈
 * ClassName: FeedBackController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月19日 上午11:20:06 <br/>
 *
 * @author panguixiang
 * @version 
 */
@Controller
@RequestMapping("/feedback")
public class FeedBackController {

	private static Logger logger = Logger.getLogger(FeedBackController.class);
	
	@Autowired
	private FeedBackService feedBackService;
	
	/**
	 * 
	 * reportSave:(提交举报). <br/> 
	 *
	 * @author panguixiang
	 * @param report
	 * @param binding
	 * @return
	 * @since JDK 1.7
	 */
	@ResponseBody
	@RequestMapping(value="save", method = RequestMethod.POST, produces = "application/json")
	public Map<String,Object> reportSave(@Valid Report feedBack, BindingResult binding) {
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			feedBackService.saveFeedBack(feedBack, binding, result);
		} catch (Exception e) {
			result.put(YcContext.CODE, 500);
			result.put(YcContext.MESSAGE, YcContext.SYS_ERROR_MSG);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			logger.error(e);
		}
		return result;
	}
}
