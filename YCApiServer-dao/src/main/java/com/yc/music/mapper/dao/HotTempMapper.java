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

/**
 * ClassName: HotTempMapper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月5日 下午8:30:42 <br/>
 *
 * @author panguixiang
 * @version 
 */
public interface HotTempMapper {

	public void addHotUseNum(@Param("id") long id) throws Exception;
}
