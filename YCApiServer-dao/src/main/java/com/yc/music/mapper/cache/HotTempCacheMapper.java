/**
 * Project Name:YCApiServer-dao
 * File Name:HotTempCacheMapper.java
 * Package Name:com.yc.music.mapper.cache
 * Date:2016年5月5日下午8:30:42
 * Copyright (c) 2016 
 *
 */
package com.yc.music.mapper.cache;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yc.music.model.accompaniment.HotVo;
import com.yc.music.model.accompaniment.TempHotVo;

/**
 * ClassName: HotTempCacheMapper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月5日 下午8:30:42 <br/>
 *
 * @author panguixiang
 * @version 
 */
public interface HotTempCacheMapper {

	public HotVo getHoVoById(@Param("id") Long id);
	
	public List<TempHotVo> redTempHotListPage(@Param("name") String name, 
			@Param("start") int start, @Param("size") int size);
	
	public List<TempHotVo> newTempHotListPage(@Param("name") String name, 
			@Param("start") int start, @Param("size") int size);
}
