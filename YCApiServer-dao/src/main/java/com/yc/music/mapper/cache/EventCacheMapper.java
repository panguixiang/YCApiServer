/**
 * Project Name:YCApiServer-dao
 * File Name:EventCacheMapper.java
 * Package Name:com.yc.music.mapper.cache
 * Date:2016年5月9日上午11:42:32
 * Copyright (c) 2016 
 *
 */
package com.yc.music.mapper.cache;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yc.music.model.musicEvent.MusicEvent;

/**
 * 活动 cache dao
 * ClassName: EventCacheMapper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月9日 上午11:42:32 <br/>
 *
 * @author panguixiang
 * @version 
 */
public interface EventCacheMapper {

	public List<MusicEvent> getEventList(@Param("name") String name,
			@Param("start") int start, @Param("size") int size);
}
