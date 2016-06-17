/**
 * Project Name:YCApiServer-dao
 * File Name:MusicFovCacheMapper.java
 * Package Name:com.yc.music.mapper.cache
 * Date:2016年5月8日下午3:48:53
 * Copyright (c) 2016 
 *
 */
package com.yc.music.mapper.cache;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * 歌曲，歌词  点赞
 * ClassName: MusicZanCacheMapper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月8日 下午3:48:53 <br/>
 *
 * @author panguixiang
 * @version 
 */
public interface MusicZanCacheMapper {

	public Map<String,Integer> nextMusic(@Param("model") Integer model,@Param("uid") Long uid,@Param("id") Long id,@Param("type") Integer type);
	
	public Map<String,Integer> prevMusic(@Param("model") Integer model,@Param("uid") Long uid,@Param("id") Long id,@Param("type") Integer type);
	
}