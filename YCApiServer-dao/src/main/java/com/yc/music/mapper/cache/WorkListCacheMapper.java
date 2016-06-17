/**
 * Project Name:YCApiServer-dao
 * File Name:WorkListCacheMapper.java
 * Package Name:com.yc.music.mapper.cache
 * Date:2016年5月5日下午1:39:32
 * Copyright (c) 2016 
 *
 */
package com.yc.music.mapper.cache;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yc.music.model.musicWorkList.MusicWorkListVo;

/**
 * 歌单 关联的歌曲信息
 * ClassName: WorkListCacheMapper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月5日 下午1:39:32 <br/>
 *
 * @author panguixiang
 * @version 
 */
public interface WorkListCacheMapper {

	/**
	 * 
	 * getWorkListPage:(根据歌单ID查询歌单歌曲列表信息). <br/> 
	 *
	 * @author panguixiang
	 * @param gedanId 歌单的ID
	 * @param isUsed 0=未使用，1=上架
	 * @param start
	 * @param end
	 * @return
	 * @since JDK 1.7
	 */
	public List<MusicWorkListVo> getWorkListPage(@Param("gedanId") Long gedanId,
			@Param("isUsed") int isUsed,@Param("start") int start,@Param("size") int size);
	/**
	 * 
	 * getWorkListCount:(满足条件的歌单 歌曲数量). <br/> 
	 *
	 * @author panguixiang
	 * @param gedanId
	 * @param isUsed
	 * @return
	 * @since JDK 1.7
	 */
	public int getWorkListCount(@Param("gedanId") Long gedanId,
			@Param("isUsed") int isUsed);
	
	public Map<String,Integer> getMusicNext(@Param("model") Integer model, @Param("gedanid") Long gedanid,@Param("workid") Long workid);
	
	public Map<String,Integer> getMusicPrev(@Param("model") Integer model, @Param("gedanid") Long gedanid,@Param("workid") Long workid);
	
	
}
