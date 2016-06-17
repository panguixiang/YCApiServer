/**
 * Project Name:YCApiServer-dao
 * File Name:FocusFansMapper.java
 * Package Name:com.yc.music.mapper.dao
 * Date:2016年5月10日下午1:44:14
 * Copyright (c) 2016 
 *
 */
package com.yc.music.mapper.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yc.music.model.fansfocus.FansList;
import com.yc.music.model.fansfocus.FansOpt;
import com.yc.music.model.fansfocus.FansUid;

/**
 * ClassName: FocusFansMapper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月10日 下午1:44:14 <br/>
 *
 * @author panguixiang
 * @version 
 */
public interface FocusFansMapper {
	
	/**
	 * 
	 * getFocusStatus:(获得关注状态，fansid是否关注过userid). <br/> 
	 *
	 * @author panguixiang
	 * @param userid
	 * @param fansid
	 * @return
	 * @since JDK 1.7
	 */
	public int getFocusStatus(@Param("userid") Long userid,@Param("fansid") Long fansid);
	/**
	 * 
	 * proFansfocus:(粉丝关注，取消关注). <br/> 
	 *
	 * @author panguixiang
	 * @param FansOpt opt
	 * @return
	 * @throws Exception
	 * @since JDK 1.7
	 */
	public void proFansfocus(FansOpt opt) throws Exception;
	
	/**
	 * 
	 * getMyFansCacheCount:(被关注数,粉丝数). <br/> 
	 *
	 * @author panguixiang
	 * @param userid
	 * @return
	 * @since JDK 1.7
	 */
	public long getMyFansCacheCount(@Param("userid") Long userid);
	
	
	/**
	 * 
	 * getFocusCacheCount:(关注别人数量). <br/> 
	 *
	 * @author panguixiang
	 * @param fansid
	 * @return
	 * @since JDK 1.7
	 */
	public long getFocusCacheCount(@Param("fansid") Long fansid);
	
	/**
	 * 
	 * getMyFansList:(分页获得我的粉丝列表). <br/> 
	 * 我的粉丝    （别人关注了我）
	 * @author panguixiang
	 * @param userid
	 * @param start
	 * @param size
	 * @return
	 * @since JDK 1.7
	 */
	public List<FansList> getMyFansList(@Param("userid") Long userid,
			@Param("start") int start,@Param("size") int size);
	
	/**
	 * 
	 * getMyFocusList:(分页获得我的关注列表). <br/> 
	 *  我的关注  （我关注了别人）
	 * @author panguixiang
	 * @param userid
	 * @param start
	 * @param size
	 * @return
	 * @since JDK 1.7
	 */
	public List<FansList> getMyFocusList(@Param("userid") Long userid,
			@Param("start") int start,@Param("size") int size);
	
	/**
	 * 
	 * getFocusIdsByIn:(根据userid集合获得我关注的用户id). <br/> 
	 *
	 * @author panguixiang
	 * @param userid 当前被关注者的id
	 * @param userIdsArr 当前关注被关注者的userid集合
	 * @return
	 * @since JDK 1.7
	 */
	public List<FansUid> getFocusIdsByIn(@Param("userid") Long userid,@Param("userIdsArr") List<Long> userIdsArr);
	
	/**
	 * 
	 * getFocusIdsOtherMeByIn:(根据userid集合获得关注我的用户id). <br/> 
	 *
	 * @author panguixiang
	 * @param userid
	 * @param userIdsArr
	 * @return
	 * @since JDK 1.7
	 */
	public List<FansUid> getFocusIdsOtherMeByIn(@Param("userid") Long userid,@Param("userIdsArr") List<Long> userIdsArr);
	
}
