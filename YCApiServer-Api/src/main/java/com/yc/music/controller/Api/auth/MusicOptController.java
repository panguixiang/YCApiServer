/**
 * Project Name:YCApiServer-Api
 * File Name:MusicOptController.java
 * Package Name:com.yc.music.controller.Api.auth
 * Date:2016年5月18日下午2:50:19
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
import com.yc.music.model.musicWork.SaveMusic;
import com.yc.music.model.tunningmusic.TunningMusic;
import com.yc.music.service.service103.TuningMusicService;

/**
 * 音频处理api
 * ClassName: MusicOptController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月18日 下午2:50:19 <br/>
 *
 * @author panguixiang
 * @version 
 */
@Controller
@RequestMapping("/musiopt")
public class MusicOptController {

	private static Logger logger = Logger.getLogger(MusicOptController.class);
	@Autowired
	private TuningMusicService tuningMusicService;
	
	
	
	/**
	 * 
	 * tuningMusic:(声音美化，合成). <br/> 
	 *
	 * @author panguixiang
	 * @param tunningMusic
	 * @param binding
	 * @return
	 * @since JDK 1.7
	 */
	@ResponseBody
	@RequestMapping(value="tuningMusic", method = RequestMethod.POST, produces = "application/json")
	public Map<String,Object> tuningMusic(@Valid TunningMusic tunningMusic,BindingResult binding) {
		
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			tuningMusicService.tunningMusic(result, tunningMusic, binding);
		} catch (Exception e) {
			e.printStackTrace();
			result.put(YcContext.CODE, 500);
			result.put(YcContext.MESSAGE, YcContext.SYS_ERROR_MSG);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			logger.error(e);
		}
		return result;
	}
	
	/**
	 * 
	 * optMusic:(发布歌曲). <br/> 
	 *
	 * @author panguixiang
	 * @param saveMusic
	 * @param binding
	 * @return
	 * @since JDK 1.7
	 */
	@ResponseBody
	@RequestMapping(value="optMusic", method = RequestMethod.POST, produces = "application/json")
	public Map<String,Object> optMusic(@Valid SaveMusic saveMusic,BindingResult binding) {
		
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			tuningMusicService.optMusic(result, saveMusic, binding);
		} catch (Exception e) {
			result.put(YcContext.CODE, 500);
			result.put(YcContext.MESSAGE, YcContext.SYS_ERROR_MSG);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			logger.error(e);
		}
		return result;
	}
	
	
}
