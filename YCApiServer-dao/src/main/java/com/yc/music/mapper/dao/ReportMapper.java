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
 * ClassName: ReportMapper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月19日 上午11:41:37 <br/>
 *
 * @author panguixiang
 * @version 
 */
public interface ReportMapper {

	/**
	 * 
	 * saveReport:(提交举报). <br/> 
	 *
	 * @author panguixiang
	 * @param report
	 * @throws Exception
	 * @since JDK 1.7
	 */
	public void saveReport(@Param("obj") Report report) throws Exception;
}
