/**
 * Project Name:YCApiServer-Api
 * File Name:ReportService.java
 * Package Name:com.yc.music.service.service103
 * Date:2016年5月19日上午11:44:07
 * Copyright (c) 2016 
 *
 */
package com.yc.music.service.service103;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.yc.music.common.context.YcContext;
import com.yc.music.common.util.BindingResultUtil;
import com.yc.music.context.YtConstant;
import com.yc.music.mapper.dao.FeedBackMapper;
import com.yc.music.model.report.Report;

/**
 * 意见反馈操作
 * ClassName: FeedBackService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月19日 上午11:44:07 <br/>
 *
 * @author panguixiang
 * @version 
 */
@Service
public class FeedBackService {

	@Autowired
	private FeedBackMapper feedBackMapper;
	
	/**
	 * 
	 * saveFeedBack:(提交意见反馈). <br/> 
	 *
	 * @author panguixiang
	 * @param feedBack
	 * @param binding
	 * @param result
	 * @return
	 * @throws Exception
	 * @since JDK 1.7
	 */
	public Map<String,Object> saveFeedBack(Report feedBack, BindingResult binding, Map<String,Object> result) throws Exception{
		
		String valiterMsg = BindingResultUtil.getBindErrorMsg(binding);
		if(StringUtils.isNotBlank(valiterMsg)) {
			result.put(YcContext.CODE, 400);
			result.put(YcContext.MESSAGE, valiterMsg);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			return result;
		}
		feedBackMapper.saveFeedBack(feedBack);
		result.put(YcContext.CODE, 200);
		result.put(YcContext.MESSAGE, YtConstant.SYS_SUCCSS_MSG);
		result.put(YcContext.DATA, YcContext.EMPTY_STRING);
		return result;
	}
}
