/**
 * Project Name:YCApiServer-Api
 * File Name:FindController.java
 * Package Name:com.yc.music.controller.Api.common
 * Date:2016年5月9日上午10:41:48
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
import com.yc.music.service.service103.AccompanimentService;

/**
 * 伴奏api ClassName: AccompanimentController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月12日 下午10:41:48 <br/>
 *
 * @author panguixiang
 * @version
 */
@Controller
@RequestMapping("/common/accompaniment")
public class AccompanimentController {

	private static Logger logger = Logger.getLogger(AccompanimentController.class);

	@Autowired
	private AccompanimentService accompanimentService;

	/**
	 * 
	 * findIndexMusic:(伴奏列表-作曲选择伴奏). <br/>
	 *
	 * @author panguixiang
	 * @param title
	 *            伴奏名称标题
	 * @param type
	 *            1=最新伴奏列表 2=最热伴奏列表
	 * @param page
	 * @return
	 * @since JDK 1.7
	 */
	@ResponseBody
	@RequestMapping(value = "list", method = RequestMethod.GET, produces = "application/json")
	public Map<String, Object> findIndexMusic(@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "type", required = false) Integer type,
			@RequestParam(value = "page", required = false) Integer page) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			accompanimentService.commentList(title, page, type, resultMap);
		} catch (Exception e) {
			resultMap.put(YcContext.CODE, 500);
			resultMap.put(YcContext.MESSAGE, YcContext.SYS_ERROR_MSG);
			resultMap.put(YcContext.DATA, YcContext.EMPTY_STRING);
			logger.error(e);
		}
		return resultMap;
	}
}
