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


/** 歌曲 、 歌词 的收藏 dao
 * ClassName: WorkFovCacheMapper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月8日 下午3:48:53 <br/>
 *
 * @author panguixiang
 * @version 
 */
public interface WorkFovCacheMapper {

	/**
	 * 
	 * nextMusic:(收藏的下一个 歌曲/歌词). <br/> 
	 *
	 * @author panguixiang
	 * @param model
	 * @param uid
	 * @param id
	 * @param type 1=歌曲，2=歌词
	 * @return
	 * @since JDK 1.7
	 */
	public Map<String,Integer> nextMusic(@Param("model") Integer model,@Param("uid") Long uid,
			@Param("id") Long id,@Param("type") Integer type);
	
	/**
	 * 
	 * prevMusic:(收藏的下上个 歌曲/歌词). <br/> 
	 *
	 * @author panguixiang
	 * @param model
	 * @param uid
	 * @param id
	 * @param type
	 * @return
	 * @since JDK 1.7
	 */
	public Map<String,Integer> prevMusic(@Param("model") Integer model,@Param("uid") Long uid,
			@Param("id") Long id,@Param("type") Integer type);
	
}
