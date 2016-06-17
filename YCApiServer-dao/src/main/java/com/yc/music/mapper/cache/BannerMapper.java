/**
 * Project Name:YCApiServer-dao
 * File Name:BannerMapper.java
 * Package Name:com.yc.music.mapper.cache
 * Date:2016年5月3日下午5:14:02
 * Copyright (c) 2016 
 *
 */
package com.yc.music.mapper.cache;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yc.music.model.musicBanner.Banner;

/**
 * ClassName: BannerMapper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月3日 下午5:14:02 <br/>
 *
 * @author panguixiang
 * @version 
 */
public interface BannerMapper {

	public List<Banner> bannerList(@Param("status") int status);
}
