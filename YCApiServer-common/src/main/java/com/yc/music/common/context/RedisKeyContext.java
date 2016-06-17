/**
 * Project Name:YCApiServer-common
 * File Name:RedisKeyContext.java
 * Package Name:com.yc.music.common.context
 * Date:2016年5月6日下午4:56:32
 * Copyright (c) 2016 
 *
 */
package com.yc.music.common.context;

/**
 * redis key相关配置
 * ClassName: RedisKeyContext <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月6日 下午4:56:32 <br/>
 *
 * @author panguixiang
 * @version
 */
public class RedisKeyContext {


	public static final String INDEX_NEW_LIST_REDIS = "app_index_new_list"; //首页 最新作品（歌词，歌曲）的redis列表 key

	public static final String ZSET_LIST_ORDER_DESC = "desc";//查询zset有序集合里的对象排序方式
	
}
