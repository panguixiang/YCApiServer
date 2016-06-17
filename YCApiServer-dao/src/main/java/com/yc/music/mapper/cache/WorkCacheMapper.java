/**
 * Project Name:YCApiServer-dao
 * File Name:WorkCacheMapper.java
 * Package Name:com.yc.music.mapper.cache
 * Date:2016年5月3日下午4:45:32
 * Copyright (c) 2016 
 *
 */
package com.yc.music.mapper.cache;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yc.music.model.NumModel;
import com.yc.music.model.musicWork.MusicWork;
import com.yc.music.model.musicWork.MusicWorkVo;
import com.yc.music.model.musicWork.WorkOpenDetail;

/**
 * ClassName: WorkCacheMapper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月3日 下午4:45:32 <br/>
 *
 * @author panguixiang
 * @version 
 */
public interface WorkCacheMapper {
	
	public WorkOpenDetail getWorOpenDetailById(@Param("id") Long id);
	
	public NumModel getLookNumCacheById(@Param("id") Long id);
	
	public Map<String,Integer> nextOrderMusic(@Param("model") Integer model,@Param("orderSql") String orderSql,@Param("id") Long id);
	
	public Map<String,Integer> prevOrderMusic(@Param("model") Integer model,@Param("orderSql") String orderSql,@Param("id") Long id);

	public Map<String,Integer> getHomepageMuNext(@Param("model") Integer model, @Param("id") Long id, @Param("uid") Long uid);
	
	public Map<String,Integer> getHomepageMuPrev(@Param("model") Integer model, @Param("id") Long id, @Param("uid") Long uid);
	
	public Map<String,Integer> nextMusic(@Param("model") Integer model,@Param("id") Long id);
	
	public Map<String,Integer> prevMusic(@Param("model") Integer model,@Param("id") Long id);
	
	public List<MusicWork> musicList(@Param("ordersql") String ordersql, @Param("name") String name,
			@Param("start") int start, @Param("size") int size);
	
	public List<MusicWorkVo> musicVoList(@Param("ordersql") String ordersql, @Param("name") String name,
			@Param("start") int start, @Param("size") int size);
	
}
