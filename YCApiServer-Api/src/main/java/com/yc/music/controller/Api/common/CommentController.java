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
import com.yc.music.service.service103.CommentService;

/**
 * 评论controller
 * ClassName: CommentController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月8日 下午5:44:19 <br/>
 *
 * @author panguixiang
 * @version
 */
@Controller
@RequestMapping("/common/comment")
public class CommentController {
	
	private static Logger logger = Logger.getLogger(CommentController.class);


	@Autowired
	private CommentService commentService;
	
	/**
	 * 
	 * workCommentList:(歌曲评论列表). <br/> 
	 *
	 * @author panguixiang
	 * @param workid 歌曲id
	 * @param page  分页 可以为null
	 * @param type 1=歌曲，2=歌词
	 * @return
	 * @since JDK 1.7
	 */
	@ResponseBody
	@RequestMapping(value="list", method = RequestMethod.GET, produces = "application/json")
	public Map<String,Object> workCommentList(
			@RequestParam("itemid") Long itemid,
			@RequestParam("type") Integer type,
			@RequestParam(value="page",required=false) Integer page) {
		
		Map<String,Object> result  = new HashMap<String,Object>();
		try {
			commentService.commentList(itemid,page,result,type);
		} catch (Exception e) {
			result.put(YcContext.CODE, 500);
			result.put(YcContext.MESSAGE, YcContext.SYS_ERROR_MSG);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			logger.error(e);
		}
		return result;
	}
	
}
