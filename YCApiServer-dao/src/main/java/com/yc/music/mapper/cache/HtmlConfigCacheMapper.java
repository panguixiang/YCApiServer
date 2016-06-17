/**
 * Project Name:YCApiServer-dao
 * File Name:AppIndexNewCacheMapper.java
 * Package Name:com.yc.music.mapper.cache
 * Date:2016年5月19日下午5:31:43
 * Copyright (c) 2016 
 *
 */
package com.yc.music.mapper.cache;

import org.apache.ibatis.annotations.Param;

import com.yc.music.model.htmlconfig.HtmlConfig;

/**
 * ClassName: HtmlConfigCacheMapper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月21日 下午20:31:43 <br/>
 *
 * @author panguixiang
 * @version 
 */
public interface HtmlConfigCacheMapper {

	public HtmlConfig getHtmlConfig(@Param("type") String type);
}
