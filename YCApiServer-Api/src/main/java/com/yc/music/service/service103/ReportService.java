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
import com.yc.music.mapper.dao.ReportMapper;
import com.yc.music.model.report.Report;

/**
 * 举报操作
 * ClassName: ReportService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月19日 上午11:44:07 <br/>
 *
 * @author panguixiang
 * @version 
 */
@Service
public class ReportService {

	@Autowired
	private ReportMapper reportMapper;
	
	/**
	 * 
	 * saveReport:(提交举报). <br/> 
	 *
	 * @author panguixiang
	 * @param report
	 * @param binding
	 * @param result
	 * @return
	 * @throws Exception
	 * @since JDK 1.7
	 */
	public Map<String,Object> saveReport(Report report, BindingResult binding, Map<String,Object> result) throws Exception{
		
		String valiterMsg = BindingResultUtil.getBindErrorMsg(binding);
		if(StringUtils.isNotBlank(valiterMsg)) {
			result.put(YcContext.CODE, 400);
			result.put(YcContext.MESSAGE, valiterMsg);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			return result;
		}
		reportMapper.saveReport(report);
		result.put(YcContext.CODE, 200);
		result.put(YcContext.MESSAGE, YtConstant.SYS_SUCCSS_MSG);
		result.put(YcContext.DATA, YcContext.EMPTY_STRING);
		return result;
	}
}
