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
import org.springframework.web.multipart.MultipartFile;

import com.yc.music.common.context.YcContext;
import com.yc.music.service.UploadService;

/**
 * 七牛上传获得，上传token
 * ClassName: UploadCallbackController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月8日 下午5:44:19 <br/>
 *
 * @author panguixiang
 * @version
 */
@Controller
@RequestMapping("/common/uploadcallback")
public class UploadCallbackController {

	private static Logger logger = Logger.getLogger(UploadCallbackController.class);
	
	@Autowired
	private UploadService uploadService;
	
	/**
	 * 
	 * qiniutoken:(客户端获得上传骑牛的token和文件名). <br/> 
	 *
	 * @author panguixiang
	 * @param type type   0/1=图片，2=音频
	 * @param fixx  文件类型空间前缀标示 ：inspire=灵感记录类，歌词封面=lyrcover,歌曲封面=muscover,头像=headport
	 * @return
	 * @since JDK 1.7
	 */
	@ResponseBody
	@RequestMapping(value="qiniutoken", method = RequestMethod.GET, produces = "application/json")
	public Map<String,Object> qiniutoken(
			@RequestParam("type") Integer type,
			@RequestParam("fixx") String fixx) {
		
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			uploadService.createUploadToken(type, fixx,result);
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
	 * upload:(mp3文件上传). <br/> 
	 *
	 * @author panguixiang
	 * @param tunningMusic
	 * @param binding
	 * @return
	 * @since JDK 1.7
	 */
	@ResponseBody
	@RequestMapping(value="uploadmp3", method = RequestMethod.POST, produces = "application/json")
	public Map<String,Object> uploadmp3(@RequestParam("file") MultipartFile file) {
		
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			uploadService.uploadAudio(file, result);
		} catch (Exception e) {
			result.put(YcContext.CODE, 500);
			result.put(YcContext.MESSAGE, YcContext.SYS_ERROR_MSG);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			logger.error(e);
		}
		return result;
	}
	
}
