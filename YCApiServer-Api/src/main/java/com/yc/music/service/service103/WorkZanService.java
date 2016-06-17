/**
 * Project Name:YCApiServer-Api
 * File Name:WorkZanService.java
 * Package Name:com.yc.music.service.service103
 * Date:2016年5月19日上午10:44:23
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
import com.yc.music.mapper.dao.WorkZanMapper;
import com.yc.music.model.OptWork;

/**
 * ClassName: WorkZanService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月19日 上午10:44:23 <br/>
 *
 * @author panguixiang
 * @version 
 */
@Service
public class WorkZanService {

	@Autowired
	private WorkZanMapper workZanMapper;
	
	/**
	 * 
	 * optWorkZan:(歌词，歌曲， 点赞). <br/> 
	 *
	 * @author panguixiang
	 * @param opt
	 * @param binding
	 * @param result
	 * @return
	 * @throws Exception
	 * @since JDK 1.7
	 */
	public Map<String,Object> optWorkZan(OptWork opt, BindingResult binding, Map<String,Object> result) throws Exception {
		String valiterMsg = BindingResultUtil.getBindErrorMsg(binding);
		if(StringUtils.isNotBlank(valiterMsg)) {
			result.put(YcContext.CODE, 400);
			result.put(YcContext.MESSAGE, valiterMsg);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			return result;
		}
		workZanMapper.proWorkZan(opt);
		result.put(YcContext.CODE, 200);
		result.put(YcContext.MESSAGE, YcContext.EMPTY_STRING);
		result.put(YcContext.DATA,opt.getResult());
		return result;
	}
}
