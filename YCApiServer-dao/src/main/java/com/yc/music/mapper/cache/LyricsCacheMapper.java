/**
 * Project Name:YCApiServer-dao
 * File Name:LyricsCacheMapper.java
 * Package Name:com.yc.music.mapper.cache
 * Date:2016年5月5日下午3:03:35
 * Copyright (c) 2016 
 *
 */
package com.yc.music.mapper.cache;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yc.music.model.NumModel;
import com.yc.music.model.musicLyrics.Lyrics;
import com.yc.music.model.musicLyrics.LyricsRank;

/**
 * ClassName: LyricsCacheMapper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月5日 下午3:03:35 <br/>
 *
 * @author panguixiang
 * @version 
 */
public interface LyricsCacheMapper {

	public NumModel getLookNumCacheById(@Param("id") Long id);
	
	public List<Lyrics> lyricsList(@Param("ordersql") String ordersql, @Param("name") String name,
			@Param("start") int start, @Param("size") int size);
	
	public List<LyricsRank> lyricsRankList(@Param("ordersql") String ordersql, @Param("name") String name,
			@Param("start") int start, @Param("size") int size);
}
