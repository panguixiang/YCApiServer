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
import com.yc.music.service.service103.SearchService;

/**
 * 搜索api ClassName: SearchController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月22日 上午12:31:33 <br/>
 *
 * @author panguixiang
 * @version
 */
@Controller
@RequestMapping("/common/search")
public class SearchController {
	
	private static Logger logger = Logger.getLogger(SearchController.class);

	@Autowired
	private SearchService searchService;

	/**
	 * 
	 * searchApp:(搜索). <br/>
	 *
	 * @author panguixiang
	 * @param fansid  登录用户id 
	 * @param name 关键词
	 * @param page  页码
	 * @param type  1=歌曲，2=歌词，3=用户
	 * @return
	 * @since JDK 1.7
	 */
	@ResponseBody
	@RequestMapping(value = "search", method = RequestMethod.GET, produces = "application/json")
	public Map<String, Object> searchApp(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value="type",required=false) Integer type,
			@RequestParam(value="page",required=false) Integer page,
			@RequestParam(value="fansid",required=false) Long fansid) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			searchService.searchApp(fansid, name, page, type, resultMap);
		} catch (Exception e) {
			resultMap.put(YcContext.CODE, 500);
			resultMap.put(YcContext.MESSAGE, YcContext.SYS_ERROR_MSG);
			resultMap.put(YcContext.DATA, YcContext.EMPTY_STRING);
			logger.error(e);
		}
		return resultMap;
	}
}
