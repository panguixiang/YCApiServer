/**
 * Project Name:YCApiServer-dao
 * File Name:WorkCommentMapper.java
 * Package Name:com.yc.music.mapper.dao
 * Date:2016年5月13日下午2:48:07
 * Copyright (c) 2016 
 *
 */
package com.yc.music.mapper.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yc.music.model.comment.MyCommentCenter;
import com.yc.music.model.comment.YcComment;

/**
 * ClassName: WorkCommentMapper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月13日 下午2:48:07 <br/>
 *
 * @author panguixiang
 * @version 
 */
public interface WorkCommentMapper {

	public List<YcComment> workCommentList(@Param("workid") Long workid, @Param("type") Integer type,
			@Param("start") int start, @Param("size") int size) throws Exception;
	
	public int getNewCommentCountBytuid(@Param("targetuid") Long uid,@Param("isread") int isread);
	
	public void setCommentIsRead(@Param("uid") Long uid,@Param("isread") int isread) throws Exception;
	
	public long saveWorkComment(YcComment obj) throws Exception;
	
	public List<MyCommentCenter> myCommentCenterList(@Param("uid") Long uid, @Param("start") int start,
			@Param("size") int size);
	
	public void deleteById(@Param("id") Long id) throws Exception;
	
}
