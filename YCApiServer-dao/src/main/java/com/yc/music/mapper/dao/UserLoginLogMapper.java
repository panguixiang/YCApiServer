package com.yc.music.mapper.dao;

import com.yc.music.model.musicuser.UserLoginLog;

public interface UserLoginLogMapper {

	
	public void saveLoginLog(UserLoginLog log) throws Exception;
	
}