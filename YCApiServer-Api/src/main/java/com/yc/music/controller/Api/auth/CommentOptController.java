/**
 * Project Name:YCApiServer-Api
 * File Name:WorkController.java
 * Package Name:com.yc.music.controller.Api.common
 * Date:2016年5月5日下午6:54:47
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
import com.yc.music.model.comment.YcComment;
import com.yc.music.service.service103.CommentService;

/**
 * 评论controller
 * ClassName: CommentOptController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月8日 下午5:44:19 <br/>
 *
 * @author panguixiang
 * @version
 */
@Controller
@RequestMapping("/commentopt")
public class CommentOptController {
	
	private static Logger logger = Logger.getLogger(CommentOptController.class);


	@Autowired
	private CommentService commentService;
	
	/**
	 * 
	 * saveComment:(发布歌曲,歌词 评论). <br/> 
	 * @author panguixiang
	 * @param comment
	 * @param binding
	 * @return
	 * @since JDK 1.7
	 */
	@ResponseBody
	@RequestMapping(value="save", method = RequestMethod.POST, produces = "application/json")
	public Map<String,Object> saveComment(@Valid YcComment comment,BindingResult binding) {
		
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			commentService.saveComment(comment,binding,result);
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
	 * delete:(删除歌曲,歌词 评论接口). <br/> 
	 *
	 * @author panguixiang
	 * @param id
	 * @param type 1=歌曲，2=歌词
	 * @param itemid 作品id
	 * @return
	 * @since JDK 1.7
	 */
	@ResponseBody
	@RequestMapping(value="delete", method = RequestMethod.POST, produces = "application/json")
	public Map<String,Object> delete(@RequestParam("id") Long id,
			@RequestParam("itemid") Long itemid,@RequestParam("type") Integer type) {
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			commentService.delete(id,type,itemid,result);
		} catch (Exception e) {
			result.put(YcContext.CODE, 500);
			result.put(YcContext.MESSAGE, YcContext.SYS_ERROR_MSG);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			logger.error(e);
		}
		return result;
	}
	
}
