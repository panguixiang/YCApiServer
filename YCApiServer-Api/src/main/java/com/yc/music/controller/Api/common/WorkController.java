/**
 * Project Name:YCApiServer-Api
 * File Name:WorkController.java
 * Package Name:com.yc.music.controller.Api.common
 * Date:2016年5月5日下午6:54:47
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
 * 作品（歌曲）controller
 * ClassName: WorkController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月5日 下午6:54:47 <br/>
 *
 * @author panguixiang
 * @version 
 */
@Controller
@RequestMapping("/common/music")
public class WorkController {

	private static Logger logger = Logger.getLogger(WorkController.class);
	
	@Autowired
	private WorkService1003 workService1003;
	
	/**
	 * 
	 * musicWork:(歌曲播放页面). <br/> 
	 *
	 * @author panguixiang
	 * @param musicId  当前需要播放的歌曲id
	 * @param openmodel 播放模式  1=顺序播放，2=随机播放，3=单曲循环
	 * @param gedanid 
	 * @param come
	 *  播放推荐歌曲列表=tuijian

		播放歌单歌曲列表=gedan 并需要提供歌单id
		
		播放最新作品里的歌曲列表=zuixin
		
		播放乐说歌曲列表=yueshuo
		
		播放热门歌曲列表 分两种情况=(red,allred)
		
		播放最新歌曲列表 分两种情况=(new,allnew)
		
		播放主页歌曲列表=homepage 需要提供uid
		
		播放我的收藏歌曲列表=mycollect
		
		播放我的点赞歌曲列表 =myzan
		
		其他播放都为全部歌曲顺序播放
	 * @return
	 * @since JDK 1.7
	 */
	@ResponseBody
	@RequestMapping(value="work", method = RequestMethod.GET, produces = "application/json")
	public Map<String,Object> musicWork(
			@RequestParam("id") Long musicId,
			@RequestParam(value="openmodel",required=false) Integer openmodel,
			@RequestParam(value="uid",required=false) Long uid,
			@RequestParam(value="gedanid",required=false) Long gedanid,
			@RequestParam(value="come",required=false) String come) {
		
		
		Map<String,Object> result  = new HashMap<String,Object>();
		try {
			workService1003.getMusicDetail(musicId, openmodel,uid,gedanid,come, result);
		} catch (Exception e) {
			result.put(YcContext.CODE, 500);
			result.put(YcContext.MESSAGE, YcContext.SYS_ERROR_MSG);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			logger.error(e);
		}
		return result;
	}
}
