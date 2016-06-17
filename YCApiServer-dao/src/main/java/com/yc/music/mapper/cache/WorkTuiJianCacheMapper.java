/**
 * Project Name:YCApiServer-dao
 * File Name:WorkTuiJianCacheMapper.java
 * Package Name:com.yc.music.mapper.cache
 * Date:2016年5月3日下午6:00:13
 * Copyright (c) 2016 
 *
 */
package com.yc.music.mapper.cache;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yc.music.model.musicTuijian.MusicTuiJianVo;

/**
 * ClassName: WorkTuiJianCacheMapper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月3日 下午6:00:13 <br/>
 *
 * @author panguixiang
 * @version 
 */
public interface WorkTuiJianCacheMapper {

	public List<MusicTuiJianVo> getWorkTuiJian();
	
	public List<MusicTuiJianVo> getLyicsTuiJian();
	
	public Map<String,Integer> getMusicNext(@Param("model") Integer model, @Param("itemid") Long itemid);
	
	public Map<String,Integer> getMusicPrev(@Param("model") Integer model, @Param("itemid") Long itemid);
	
}
