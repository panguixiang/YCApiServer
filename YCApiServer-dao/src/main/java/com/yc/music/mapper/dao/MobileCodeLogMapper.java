/**
 * Project Name:YCApiServer-dao
 * File Name:HotTempCacheMapper.java
 * Package Name:com.yc.music.mapper.cache
 * Date:2016年5月5日下午8:30:42
 * Copyright (c) 2016 
 *
 */
package com.yc.music.mapper.dao;


import org.apache.ibatis.annotations.Param;
import com.yc.music.model.mobilecode.MobileCodeLog;
import com.yc.music.model.mobilecode.SendLogPro;
/**
 * 
 * ClassName: MobileCodeLogMapper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年6月3日 下午4:52:27 <br/>
 *
 * @author panguixiang
 * @version
 */
public interface MobileCodeLogMapper {

	public int getCountByIpDate(@Param("ip") String ip,@Param("createdate") String createdate) throws Exception;
	
	public void saveCodeLog(MobileCodeLog log) throws Exception;
	
	public String proSndSMSLog(SendLogPro sendLogPro) throws Exception;
}
