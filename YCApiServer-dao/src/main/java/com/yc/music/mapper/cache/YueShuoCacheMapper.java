/**
 * Project Name:YCApiServer-dao
 * File Name:YueShuoMapper.java
 * Package Name:com.yc.music.mapper.cache
 * Date:2016年5月5日上午9:41:02
 * Copyright (c) 2016 
 *
 */
package com.yc.music.mapper.cache;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yc.music.model.musicYueShuo.MuscicYueSVo;

/**
 * ClassName: YueShuoMapper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月5日 上午9:41:02 <br/>
 *
 * @author panguixiang
 * @version 
 */
public interface YueShuoCacheMapper {

	/**
	 * 
	 * getYueShuoPages:(这里用一句话描述这个方法的作用). <br/> 
	 *
	 * @author panguixiang
	 * @param status 1=默认下架状态，2=上架状态
	 * @param type  1=mp3,2=web，wap页面
	 * @param isindex 1=不在首页，2=上首页
	 * @param start
	 * @param end
	 * @return
	 * @since JDK 1.7
	 */
	public List<MuscicYueSVo> getYueShuoPages(@Param("status") int status, @Param("type") Integer type,
			@Param("isindex") Integer isindex,@Param("start") int start, @Param("end") int end);
	
	public Map<String,Integer> getMusicNext(@Param("model") Integer model, @Param("workid") Long workid);
	
	public Map<String,Integer> getMusicPrev(@Param("model") Integer model, @Param("workid") Long workid);
	
}
