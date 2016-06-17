package com.yc.music.mapper.dao;

import org.apache.ibatis.annotations.Param;

import com.yc.music.model.MobileCode;

public interface MobileCodeMapper {

	public MobileCode getMobileCode(@Param("mobile") String mobile,
			@Param("code") String code);
	
	public void updateCode(@Param("code") MobileCode code);
	
	public MobileCode getMobileCodeByPhone(@Param("mobile") String mobile);
}
