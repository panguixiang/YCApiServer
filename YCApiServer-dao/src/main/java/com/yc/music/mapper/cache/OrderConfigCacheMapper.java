/**
 * Project Name:YCApiServer-dao
 * File Name:OrderConfigMapper.java
 * Package Name:com.yc.music.mapper.cache
 * Date:2016年5月8日下午3:09:07
 * Copyright (c) 2016 
 *
 */
package com.yc.music.mapper.cache;

import org.apache.ibatis.annotations.Param;

import com.yc.music.model.orderConfig.OrderConfig;

/**
 * ClassName: OrderConfigMapper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月8日 下午3:09:07 <br/>
 *
 * @author panguixiang
 * @version 
 */
public interface OrderConfigCacheMapper {

	public OrderConfig getOrderConfigByKey(@Param("key") String key);
}
