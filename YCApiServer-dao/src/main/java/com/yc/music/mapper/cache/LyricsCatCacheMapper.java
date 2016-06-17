/**
 * Project Name:YCApiServer-dao
 * File Name:LyricsCatCacheMapper.java
 * Package Name:com.yc.music.mapper.cache
 * Date:2016年5月18日下午7:54:27
 * Copyright (c) 2016 
 *
 */
package com.yc.music.mapper.cache;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yc.music.model.lyricscat.LyricsCat;

/**
 * ClassName: LyricsCatCacheMapper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月18日 下午7:54:27 <br/>
 *
 * @author panguixiang
 * @version 
 */
public interface LyricsCatCacheMapper {

	public List<LyricsCat> getLyricsCatList(@Param("keywords") String keywords) throws Exception;
}
