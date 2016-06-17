/**
 * Project Name:YCApiServer-Api
 * File Name:LyricsOptController.java
 * Package Name:com.yc.music.controller.Api.auth
 * Date:2016年5月18日下午7:34:08
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
import com.yc.music.model.musicLyrics.SaveLyrics;
import com.yc.music.service.service103.LyricsService1003;

/**
 * 歌词处理api
 * ClassName: LyricsOptController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月18日 下午7:34:08 <br/>
 *
 * @author panguixiang
 * @version 
 */
@Controller
@RequestMapping("/lyricsopt")
public class LyricsOptController {

	private static Logger logger = Logger.getLogger(LyricsOptController.class);
	
	@Autowired
	private LyricsService1003 lyricsService1003;
	
	/**
	 * 
	 * getLyricsCat:(获得词库). <br/> 
	 *
	 * @author panguixiang
	 * @param keyword
	 * @return
	 * @since JDK 1.7
	 */
	
	@ResponseBody
	@RequestMapping(value="getLyriCats", method = RequestMethod.GET, produces = "application/json")
	public Map<String,Object> getLyricsCat(@RequestParam(value="keyword", required=false) String keyword) {
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			lyricsService1003.getLyricsCats(keyword, result);
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
	 * optLyrics:(保存，修改 歌词). <br/> 
	 *
	 * @author panguixiang
	 * @param saveMusic
	 * @param binding
	 * @return
	 * @since JDK 1.7
	 */
	@ResponseBody
	@RequestMapping(value="optLyrics", method = RequestMethod.POST, produces = "application/json")
	public Map<String,Object> optLyrics(@Valid SaveLyrics lyrics,BindingResult binding) {
		
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			lyricsService1003.optLyrics(lyrics, binding,result);
		} catch (Exception e) {
			result.put(YcContext.CODE, 500);
			result.put(YcContext.MESSAGE, YcContext.SYS_ERROR_MSG);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			logger.error(e);
		}
		return result;
	}
	
}
