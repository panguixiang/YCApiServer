/**
 * Project Name:YCApiServer-dao
 * File Name:LyrcisZanMapper.java
 * Package Name:com.yc.music.mapper.dao
 * Date:2016年5月5日下午6:04:27
 * Copyright (c) 2016 
 *
 */
package com.yc.music.mapper.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yc.music.model.OptWork;
import com.yc.music.model.workzan.ZanCenterVo;

/**
 * ClassName: WorkZanMapper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月5日 下午6:04:27 <br/>
 *
 * @author panguixiang
 * @version 
 */
public interface WorkZanMapper {

	public int getMusicZanCountByUidAndWId(@Param("workid") Long workid,
			@Param("uid") Long uid,@Param("type") int type);
	
	public int getWorkZanCountByTUid(
			@Param("targetuid") Long uid, @Param("isread") int isread);
	
	public void setZanIsRead(@Param("uid") Long uid,@Param("isread") int isread) throws Exception;
	
	public void proWorkZan(OptWork opt) throws Exception;
	
	public List<ZanCenterVo> getZanCenterList(@Param("uid") Long uid, @Param("start") int start,
			@Param("size") int size);
	
}
