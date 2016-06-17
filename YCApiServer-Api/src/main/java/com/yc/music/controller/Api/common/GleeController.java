/**
 * Project Name:YCApiServer-Api
 * File Name:SongListController.java
 * Package Name:com.yc.music.controller.Api.common
 * Date:2016年5月5日下午1:36:03
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
import com.yc.music.service.service103.WorkService1003;

/**
 * 歌单api接口
 * ClassName: GleeController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月5日 下午1:36:03 <br/>
 *
 * @author panguixiang
 * @version 
 */
@Controller
@RequestMapping("/common/glee")
public class GleeController {
	
	private static Logger logger = Logger.getLogger(GleeController.class);
	
	@Autowired
	private WorkService1003 workService1003;
	
	/**
	 * 
	 * detail:(歌单详情 api ). <br/> 
	 *
	 * @author panguixiang
	 * @param gedanId
	 * @param page
	 * @return
	 * @since JDK 1.7
	 */
	@ResponseBody
	@RequestMapping(value="detail", method = RequestMethod.GET, produces = "application/json")
	public Map<String,Object> detail(@RequestParam("id") Long gedanId,
			@RequestParam(value="page",required=false) Integer page) {
		Map<String,Object> result  = new HashMap<String,Object>();
		try {
			workService1003.songDetail(gedanId, page, result);
		} catch (Exception e) {
			result.put(YcContext.CODE, 500);
			result.put(YcContext.MESSAGE, YcContext.SYS_ERROR_MSG);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			logger.error(e);
		}
		return result;
	}
	
	/**
	 * list:(歌单列表 分页显示). <br/> 
	 * @author panguixiang
	 * @param page
	 * @return
	 * @since JDK 1.7
	 */
	@ResponseBody
	@RequestMapping(value="list", method = RequestMethod.GET, produces = "application/json")
	public Map<String,Object> list(
			@RequestParam(value="page",required=false) Integer page) {
		Map<String,Object> result  = new HashMap<String,Object>();
		try {
			workService1003.songList(page, result);
		} catch (Exception e) {
			result.put(YcContext.CODE, 500);
			result.put(YcContext.MESSAGE, YcContext.SYS_ERROR_MSG);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			logger.error(e);
		}
		return result;
	}
	
	
	
}
