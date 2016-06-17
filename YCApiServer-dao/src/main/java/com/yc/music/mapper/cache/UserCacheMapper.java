package com.yc.music.mapper.cache;

import org.apache.ibatis.annotations.Param;

import com.yc.music.model.musicuser.MusicUserVo;

public interface UserCacheMapper {

	
	public MusicUserVo getCacheUservo(@Param("id") Long id);
	
}
