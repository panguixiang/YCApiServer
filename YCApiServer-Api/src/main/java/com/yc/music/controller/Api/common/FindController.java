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
import com.yc.music.service.service103.FindService;

/**
 * 发现api ClassName: FindController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月9日 上午10:41:48 <br/>
 *
 * @author panguixiang
 * @version
 */
@Controller
@RequestMapping("/common/find")
public class FindController {
	
	private static Logger logger = Logger.getLogger(FindController.class);

	@Autowired
	private FindService findService;

	/**
	 * 
	 * findIndexMusic:(发现首页-歌曲 api). <br/>
	 *
	 * @author panguixiang
	 * @param name
	 * @return
	 * @since JDK 1.7
	 */
	@ResponseBody
	@RequestMapping(value = "music", method = RequestMethod.GET, produces = "application/json")
	public Map<String, Object> findIndexMusic(@RequestParam(value = "name", required = false) String name) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			findService.findIndexMusic(name, resultMap);
		} catch (Exception e) {
			resultMap.put(YcContext.CODE, 500);
			resultMap.put(YcContext.MESSAGE, YcContext.SYS_ERROR_MSG);
			resultMap.put(YcContext.DATA, YcContext.EMPTY_STRING);
			logger.error(e);
		}
		return resultMap;
	}

	/**
	 * 
	 * moremusic:(发现首页-歌曲 更多API). <br/>
	 *
	 * @author panguixiang
	 * @return
	 * @since JDK 1.7
	 */
	@ResponseBody
	@RequestMapping(value = "moremusic", method = RequestMethod.GET, produces = "application/json")
	public Map<String, Object> moremusic(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "orderType", required = false) Integer orderType) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			findService.moreMusic(name, resultMap, orderType, page);
		} catch (Exception e) {
			resultMap.put(YcContext.CODE, 500);
			resultMap.put(YcContext.MESSAGE, YcContext.SYS_ERROR_MSG);
			resultMap.put(YcContext.DATA, YcContext.EMPTY_STRING);
			logger.error(e);
		}
		return resultMap;
	}

	/**
	 * 
	 * findIndexMusic:(发现首页-歌词 api). <br/>
	 *
	 * @author panguixiang
	 * @param name
	 * @return
	 * @since JDK 1.7
	 */
	@ResponseBody
	@RequestMapping(value = "lyrics", method = RequestMethod.GET, produces = "application/json")
	public Map<String, Object> findIndexLyrics(@RequestParam(value = "name", required = false) String name) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			findService.findIndexLyrics(name, resultMap);
		} catch (Exception e) {
			resultMap.put(YcContext.CODE, 500);
			resultMap.put(YcContext.MESSAGE, YcContext.SYS_ERROR_MSG);
			resultMap.put(YcContext.DATA, YcContext.EMPTY_STRING);
			logger.error(e);
		}
		return resultMap;
	}

	/**
	 * 
	 * moremusic:(发现首页-歌词 更多API). <br/>
	 *
	 * @author panguixiang
	 * @return
	 * @since JDK 1.7
	 */
	@ResponseBody
	@RequestMapping(value = "morelyrics", method = RequestMethod.GET, produces = "application/json")
	public Map<String, Object> morelyrics(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "orderType", required = false) Integer orderType) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			findService.moreLyrics(name, resultMap, orderType, page);
		} catch (Exception e) {
			resultMap.put(YcContext.CODE, 500);
			resultMap.put(YcContext.MESSAGE, YcContext.SYS_ERROR_MSG);
			resultMap.put(YcContext.DATA, YcContext.EMPTY_STRING);
			logger.error(e);
		}
		return resultMap;
	}

	/**
	 * 
	 * moremusic:(发现首页-活动列表 API). <br/>
	 *
	 * @author panguixiang
	 * @return
	 * @since JDK 1.7
	 */
	@ResponseBody
	@RequestMapping(value = "activelist", method = RequestMethod.GET, produces = "application/json")
	public Map<String, Object> activelist(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "page", required = false) Integer page) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			findService.findActivList(name, resultMap, page);
		} catch (Exception e) {
			resultMap.put(YcContext.CODE, 500);
			resultMap.put(YcContext.MESSAGE, YcContext.SYS_ERROR_MSG);
			resultMap.put(YcContext.DATA, YcContext.EMPTY_STRING);
			logger.error(e);
		}
		return resultMap;
	}

	/**
	 * 
	 * rankList:(发现首页-排行榜 歌词 歌曲 api). <br/>
	 *
	 * @author panguixiang
	 * @param name
	 * @param modelType
	 *            1=歌曲，2=歌词
	 * @param page
	 * @return
	 * @since JDK 1.7
	 */
	@ResponseBody
	@RequestMapping(value = "rankList", method = RequestMethod.GET, produces = "application/json")
	public Map<String, Object> rankList(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "modelType", required = false) Integer modelType,
			@RequestParam(value = "page", required = false) Integer page) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			findService.rankList(name, resultMap, modelType, page);
		} catch (Exception e) {
			resultMap.put(YcContext.CODE, 500);
			resultMap.put(YcContext.MESSAGE, YcContext.SYS_ERROR_MSG);
			resultMap.put(YcContext.DATA, YcContext.EMPTY_STRING);
			logger.error(e);
		}
		return resultMap;
	}

}
