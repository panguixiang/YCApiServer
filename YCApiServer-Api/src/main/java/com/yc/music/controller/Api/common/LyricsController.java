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
import com.yc.music.service.service103.LyricsService1003;

/**
 * 歌词 api
 * ClassName: LyricsController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月5日 下午3:51:05 <br/>
 *
 * @author panguixiang
 * @version 
 */
@Controller
@RequestMapping("/common/lyrics")
public class LyricsController {

	private static Logger logger = Logger.getLogger(LyricsController.class);
	
	@Autowired
	private LyricsService1003 lyricsService;
	
	/**
	 * 
	 * loginbymob:(根据歌词id获得歌词详情). <br/> 
	 *
	 * @author panguixiang
	 * @param id 歌词id
	 * @param uid 用户id，非必填
	 * @return
	 * @since JDK 1.7
	 */
	@ResponseBody
	@RequestMapping(value="detail", method = RequestMethod.GET, produces = "application/json")
	public Map<String,Object> lyricsDetail(@RequestParam("id") Long id,@RequestParam(value="uid",required=false) Long uid) {
		
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			lyricsService.getMusicLyricsById(id,uid,result);
		} catch (Exception e) {
			result.put(YcContext.CODE, 500);
			result.put(YcContext.MESSAGE, YcContext.SYS_ERROR_MSG);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			logger.error(e);
		}
		return result;
	}
	
	/**
	 * myLyrics:(获取用户歌词列表). <br/> 
	 *
	 * @author panguixiang
	 * @param uid
	 * @param page
	 * @return
	 * @since JDK 1.7
	 */
	@ResponseBody
	@RequestMapping(value="myLyrics", method = RequestMethod.GET, produces = "application/json")
	public Map<String,Object> myLyrics(@RequestParam("uid") Long uid, 
			@RequestParam(value="page",required=false) Integer page) {
		
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			lyricsService.getLyricImpList(uid,page,result);
		} catch (Exception e) {
			result.put(YcContext.CODE, 500);
			result.put(YcContext.MESSAGE, YcContext.SYS_ERROR_MSG);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			logger.error(e);
		}
		return result;
	}
}
