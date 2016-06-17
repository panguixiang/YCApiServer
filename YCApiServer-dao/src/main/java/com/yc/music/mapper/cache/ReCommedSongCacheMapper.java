/**
 * Project Name:YCApiServer-dao
 * File Name:ReCommedSongCacheMapper.java
 * Package Name:com.yc.music.mapper.cache
 * Date:2016年5月3日下午6:45:51
 * Copyright (c) 2016 
 *
 */
package com.yc.music.mapper.cache;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yc.music.model.musRecomSongs.RecommedSong;

/**
 * 歌单 缓存cache mapper
 * ClassName: ReCommedSongCacheMapper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月3日 下午6:45:51 <br/>
 *
 * @author panguixiang
 * @version 
 */
public interface ReCommedSongCacheMapper {

	/**
	 * 
	 * recommedSongPage:(获取歌单列表). <br/> 
	 *
	 * @author panguixiang
	 * @param isindex 是否首页显示，默认0不在首页显示，1设置为首页显示
	 * @param status  0默认下架，1=上架
	 * @param end
	 * @return
	 * @since JDK 1.7
	 */
	public List<RecommedSong> recommedSongPage(@Param("isindex") Integer isindex,
			@Param("status") int status,@Param("start") int start,@Param("size") int size);
	
	/**
	 * 
	 * getRecommedSong:(根据歌单ID获取歌单明细). <br/> 
	 * @author panguixiang
	 * @param id
	 * @return
	 * @since JDK 1.7
	 */
	public RecommedSong getRecommedSong(@Param("id") Long id);
	
}
