/**
 * Project Name:YCApiServer-Api
 * File Name:LyricsController.java
 * Package Name:com.yc.music.controller.Api.common
 * Date:2016年5月5日下午3:51:05
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
import com.yc.music.service.service103.YueShuoService;

/**
 * 乐说 api
 * ClassName: LyricsController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月20日 下午3:51:05 <br/>
 *
 * @author panguixiang
 * @version 
 */
@Controller
@RequestMapping("/common/yueshuo")
public class YueShuoController {

	private static Logger logger = Logger.getLogger(YueShuoController.class);
	
	@Autowired
	private YueShuoService yueShuoService;
	
	/**
	 * 
	 * loginbymob:(乐说分页列表). <br/> 
	 *
	 * @author panguixiang
	 * @param page
	 * @return
	 * @since JDK 1.7
	 */
	@ResponseBody
	@RequestMapping(value="list", method = RequestMethod.GET, produces = "application/json")
	public Map<String,Object> loginbymob(@RequestParam(value="page",required=false) Integer page) {
		
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			yueShuoService.yueshuoListPage(page,result);
		} catch (Exception e) {
			result.put(YcContext.CODE, 500);
			result.put(YcContext.MESSAGE, YcContext.SYS_ERROR_MSG);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			logger.error(e);
		}
		return result;
	}
}
