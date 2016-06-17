package com.yc.music.plug;

import org.apache.ibatis.cache.decorators.LoggingCache;

public class LoggingRedisCache extends LoggingCache {

    public LoggingRedisCache(String id) {
            super(new RedisMybatisCache(id));
    }
  
}
