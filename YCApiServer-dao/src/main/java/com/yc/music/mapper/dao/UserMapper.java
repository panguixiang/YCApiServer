package com.yc.music.mapper.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yc.music.model.User;
import com.yc.music.model.UserLoginVo;
import com.yc.music.model.musicuser.MusicUserVo;
import com.yc.music.model.musicuser.UserInfo;
import com.yc.music.model.searchvo.SearchUser;

public interface UserMapper {

	public int getUserByPhoneCount(@Param("phone") String phone);
	
	public UserLoginVo getUserByPhone(@Param("phone") String phone);
	
	public UserLoginVo loginByMobile(@Param("phone") String phone,
			@Param("password") String password);
	
	public void updatePaswd(@Param("phone") String phone,
			@Param("password") String password) throws Exception;
	
	public long save(@Param("user") User user) throws Exception;
	
	public void updateHeadurl(@Param("headurl") String headurl,
			@Param("phone") String phone) throws Exception;
	
	public void updateInfo(@Param("info") UserInfo info) throws Exception;
	
	public List<SearchUser> searchUserList(@Param("name") String title, @Param("start") int start,
			@Param("size") int size);
	
	
	public void setUserLoginLog(@Param("lastloginip") String lastloginip,@Param("id") long id) throws Exception;
	
	public MusicUserVo getUservo(@Param("id") Long id);
}
