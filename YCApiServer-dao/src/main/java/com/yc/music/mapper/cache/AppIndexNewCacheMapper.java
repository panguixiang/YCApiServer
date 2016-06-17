/**
 * Project Name:YCApiServer-dao
 * File Name:AppIndexNewCacheMapper.java
 * Package Name:com.yc.music.mapper.cache
 * Date:2016年5月19日下午5:31:43
 * Copyright (c) 2016 
 *
 */
package com.yc.music.mapper.cache;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yc.music.model.musicindex.AppIndexNews;

/**
 * ClassName: AppIndexNewCacheMapper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月19日 下午5:31:43 <br/>
 *
 * @author panguixiang
 * @version 
 */
public interface AppIndexNewCacheMapper {

	public List<AppIndexNews> getAppIndexNewsList(@Param("start") int start,@Param("size") int size);
}
