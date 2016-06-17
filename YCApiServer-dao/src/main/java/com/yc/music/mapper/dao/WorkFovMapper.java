/**
 * Project Name:YCApiServer-dao
 * File Name:LyricsFovCacheMapper.java
 * Package Name:com.yc.music.mapper.cache
 * Date:2016年5月5日下午5:51:12
 * Copyright (c) 2016 
 *
 */
package com.yc.music.mapper.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yc.music.model.OptWork;
import com.yc.music.model.musicFov.MyFovCenter;
import com.yc.music.model.musicFov.UserFovCenter;

/**
 * 歌曲收藏，取消收藏，查询是否对其收藏
 * ClassName: LyricsFovMapper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月5日 下午5:51:12 <br/>
 *
 * @author panguixiang
 * @version 
 */
public interface WorkFovMapper {

	/**
	 * 
	 * getWorkFovCountByUidAndWId:(是否已经收藏 此  歌词/歌曲). <br/> 
	 *
	 * @author panguixiang
	 * @param workid
	 * @param uid
	 * @param type 1=歌曲，2=歌词
	 * @return
	 * @since JDK 1.7
	 */
	public int getWorkFovCountByUidAndWId(@Param("workid") Long workid,
			@Param("uid") Long uid,@Param("type") int type);
	
	public int getWorkFovCountByTUid(
			@Param("targetuid") Long uid,@Param("isread") int isread);
	
	public void setFovIsRead(@Param("uid") Long uid, @Param("isread") int isread) throws Exception;
	/**
	 * 
	 * proWorkFov:(收藏，取消收藏). <br/> 
	 *
	 * @author panguixiang
	 * @param opt
	 * @return
	 * @throws Exception
	 * @since JDK 1.7
	 */
	public void proWorkFov(OptWork opt) throws Exception;
	
	
	public List<MyFovCenter> fovMyCenterList(@Param("uid") Long uid, @Param("start") int start,
			@Param("size") int size);
	
	
	/**
	 * 
	 * userFovCenterList:(查询用户关联的歌词，歌曲收藏列表，按照收藏时间排序). <br/> 
	 *
	 * @author panguixiang
	 * @param uid 用户id
	 * @param start
	 * @param size
	 * @return
	 * @since JDK 1.7
	 */
	public List<UserFovCenter> userFovCenterList(@Param("uid") Long uid,
			@Param("start") int start, @Param("size") int size);
}
