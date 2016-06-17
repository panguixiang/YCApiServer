/**
 * Project Name:YCApiServer-dao
 * File Name:ReportMapper.java
 * Package Name:com.yc.music.mapper.dao
 * Date:2016年5月19日上午11:41:37
 * Copyright (c) 2016 
 *
 */
package com.yc.music.mapper.dao;

import org.apache.ibatis.annotations.Param;

import com.yc.music.model.report.Report;

/**
 * ClassName: FeedBackMapper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月19日 上午14:41:37 <br/>
 *
 * @author panguixiang
 * @version 
 */
public interface FeedBackMapper {

	/**
	 * 
	 * saveFeedBack:(提交意见反馈). <br/> 
	 *
	 * @author panguixiang
	 * @param feedBack
	 * @throws Exception
	 * @since JDK 1.7
	 */
	public void saveFeedBack(@Param("obj") Report feedBack) throws Exception;
}
