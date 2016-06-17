package com.yc.music.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.yc.music.common.context.RedisKeyContext;
import com.yc.music.common.context.YcContext;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;
/**
 * jredis 业务工具
 * ClassName: RedisUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * date: 2016年4月26日 下午4:36:18 <br/>
 *
 * @author panguixiang
 * @version
 */
public class RedisUtil {
	
	private static Logger logger = Logger.getLogger(RedisUtil.class);
	// 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
	private static boolean TEST_ON_BORROW = true;

	private static JedisPool jedisPool = null;

	/**
	 * 初始化Redis连接池
	 */
	public static void createRedisPool() {
		try {
			GenericObjectPoolConfig genConfig = new GenericObjectPoolConfig();
			genConfig.setMaxIdle(YcContext.redis_MaxIdle);///最大空闲连接数
			genConfig.setMaxWaitMillis(YcContext.redis_MaxWaitMillis);//获取连接时的最大等待毫秒数
			genConfig.setTestOnBorrow(TEST_ON_BORROW);///在获取连接的时候检查有效性, 默认false
			genConfig.setTestWhileIdle(TEST_ON_BORROW);//在空闲时检查有效性, 默认false
			jedisPool = new JedisPool(genConfig, YcContext.redis_ip, YcContext.redis_port, YcContext.redis_timeout,YcContext.redis_auth);
		} catch (Exception e) {
			logger.error("===RedisUtil实例化redis连接池异常===",e.fillInStackTrace());
		}
	}

	/**
	 * 获取Jedis实例
	 * 
	 * @return
	 */
	public static Jedis getJedis() {
		Jedis redis = null;
		if (jedisPool != null) {
			redis=jedisPool.getResource();
		} else {
			createRedisPool();
			redis=jedisPool.getResource();
		}
		return redis;
	}

	/**
	 * redis操作String
	 */
	@SuppressWarnings("deprecation")
	public static void saveString(String key,String value,int expireTime) {
		Jedis redis = getJedis();
		redis.setex(key, expireTime, value);
		// -----添加数据----------
		jedisPool.returnResource(redis);
	}
	
	/*
	 * 根据key,field获得hash对应的value
	 */
	@SuppressWarnings("deprecation")
	public static String getHashValueByKey(String key,String field) {
		Jedis redis = getJedis();
		String value = redis.hget(key, field);
		jedisPool.returnResource(redis);
		return value;
	}
	/**
	 * redis操作String
	 */
	@SuppressWarnings("deprecation")
	public static String getString(String key,int expireTime) {
		Jedis redis = getJedis();
		String result = redis.get(key);
		if(StringUtils.isNotBlank(result)) {
			redis.expire(key, expireTime);//expireTime秒过期
		}
		jedisPool.returnResource(redis);
		return result;
	}
	
	/**
	 * redis拼接String
	 */
	@SuppressWarnings("deprecation")
	public void appendString(String key,String value,int expireTime) {
		Jedis redis = getJedis();
		// -----添加数据----------
		redis.append(key, value);
		redis.expire(key, expireTime);//expireTime秒过期
		jedisPool.returnResource(redis);
	}
	/**
	 * 删除元素
	  * deleteReids(这里用一句话描述这个方法的作用)
	  * @Title: deleteReids
	  * @Description: TODO
	  * @param @param key
	  * @param @throws Exception    设定文件
	  * @return void    返回类型
	  * @throws
	 */
	@SuppressWarnings("deprecation")
	public static void deleteReids(String key) {
		Jedis redis = getJedis();
		redis.del(key);
		jedisPool.returnResource(redis);
	}
	/**
	 * 
	 * setValueInc:(key的值自增1). <br/> 
	 *
	 * @author panguixiang
	 * @param key
	 * @since JDK 1.7
	 */
	@SuppressWarnings("deprecation")
	public void setValueInc(String key) {
		Jedis redis = getJedis();
		redis.incr(key);//key的值自增1
		jedisPool.returnResource(redis);
	}
	
	/**
	 * redis操作Map
	 */
	@SuppressWarnings("deprecation")
	public void saveRedisMap(String key,Map<String,String> map,int expireTime) {
		Jedis redis = getJedis();
		redis.del(key);
		// -----添加数据----------
		redis.hmset(key, map);
		redis.expire(key, expireTime);//expireTime秒过期
		jedisPool.returnResource(redis);
	}

	/**
	 * jedis操作List
	 */
	@SuppressWarnings("deprecation")
	public void saveRedisList(String key,List<Object> list,int expireTime) {
		Jedis redis = getJedis();
		redis.del(key);
		for(Object obj: list) {
			redis.lpush(key, String.valueOf(obj));
		}
		redis.expire(key, expireTime);//expireTime秒过期
		jedisPool.returnResource(redis);
	}

	/**
	 * jedis操作Set-
	 */
	@SuppressWarnings("deprecation")
	public void saveRedisSet(String key,Set<Object> set,int expireTime) {
		Jedis redis = getJedis();
		redis.del(key);
		for(Object obj : set) {
			redis.sadd(key, String.valueOf(obj));
		}
		redis.expire(key, expireTime);//expireTime秒过期
		jedisPool.returnResource(redis);
	}
	
	/**
	 * 
	 * checkLoginToken:(验证token合法性). <br/> 
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author panguixiang
	 * @param token
	 * @return
	 * @since JDK 1.7
	 */
	@SuppressWarnings("deprecation")
	public static boolean checkLoginToken(String token, int expre_time) {
		Jedis redis = getJedis();
		
		logger.info("-----------checkLoginToken--------tiexpre_timeme==="+expre_time);
		String str = redis.get(token);
		if(StringUtils.isBlank(str)) {
			jedisPool.returnResource(redis);
			return false;
		}
		if(expre_time>0){
			redis.setex(token, expre_time, str);
		}
		jedisPool.returnResource(redis);
		return true;
	}
	/**
	 * 
	 * filterOftenClient:(判断其请求参数是否在时间内). <br/> 
	 * 十分钟之内不可以重复请求同一个data
	 * @author panguixiang
	 * @param dataCode
	 * @return
	 * @since JDK 1.7
	 */
	@SuppressWarnings("deprecation")
	public static boolean filterOftenClient(String dataCode){
		StringBuffer buffer = new StringBuffer();
		try {
			Jedis redis = getJedis();
			buffer.append(dataCode.hashCode());
			if(StringUtils.isNotBlank(redis.get(buffer.toString()))) {//不可以重复请求，或者不是受信任的APP发送的qingqi防止拦截报文，重复请求数据库
				jedisPool.returnResource(redis);
				return false;
			} else {//第一次请求，则向redis里设置此值，失效时间为OFTEN_EXPRESSION_TIME分钟
				redis.setex(buffer.toString(), YcContext.OFTEN_EXPRESSION_TIME, buffer.toString());
				jedisPool.returnResource(redis);
				return true;
			}
		} catch(Exception e) {
			return true;
		}
	}
	/**
	 * 
	 * getRedisPool:(获得 私有 jedisPool对象). <br/> 
	 *
	 * @author panguixiang
	 * @return
	 * @since JDK 1.7
	 */
	public static JedisPool getRedisPool() {
		return jedisPool;
	}
	/**
	 * 
	 * publishJsonStr:(发布 jsonMsg字符串消息到 channel 通道). <br/> 
	 *
	 * @author panguixiang
	 * @param channel
	 * @param jsonMsg
	 * @since JDK 1.7
	 */
	@SuppressWarnings("deprecation")
	public static void publishJsonStr(String channel,String jsonMsg) {
		Jedis redis = getJedis();
		redis.publish(channel, jsonMsg);
		jedisPool.returnResource(redis);
	}
	
	/**
	 * 
	 * setListRedis:(向list里插入元素对象并返回list长度). <br/> 
	 *
	 * @author panguixiang
	 * @param key list key
	 * @param obj 需要存入list里的对象
	 * @param isRpop true 表示移除原来list末尾元素
	 * @since JDK 1.7
	 */
	@SuppressWarnings("deprecation")
	public static long setListRedis(String key,Object obj,boolean isRpop,int maxlength ) {
		Jedis redis = getJedis();
		if(isRpop && redis.llen(key)>=maxlength) {
			redis.rpop(key);
		}
		long size = redis.lpush(key, JSONObject.toJSONString(obj));
		jedisPool.returnResource(redis);
		return size;
	}
	
	/**
	 * 
	 * getListRedis:(根据key返回list 指定长度的value值). <br/> 
	 *
	 * @author panguixiang
	 * @param key list key
	 * @param start 长度开始位置 0表示头
	 * @param end end长度结束为止，-1表示全部
	 * @return
	 * @since JDK 1.7
	 */
	@SuppressWarnings("deprecation")
	public static List<String> getListRedis(String key,int start, int end) throws Exception{
		Jedis redis = getJedis();
		List<String> redisList = redis.lrange(key, start, end);
		jedisPool.returnResource(redis);
		return redisList;
	}
	
	/**
	 * 实例化一个私有的 静态 订阅者
	 */
	private static final JedisPubSub jedisPubSub = new JedisPubSub() {
	      @Override
	    public void onMessage(String channel, String message) {
	    	  System.out.println("===message===="+message);
	    }
	 };
	 
	 /**
	  * 
	  * subscribeJsonStr:(将订阅注册到订阅者). <br/> 
	  * TODO(这里描述这个方法适用条件 – 可选).<br/>
	  * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	  * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	  * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	  *
	  * @author panguixiang
	  * @param channel
	  * @since JDK 1.7
	  */
    @SuppressWarnings("deprecation")
	public static void subscribeJsonStr(String channel) {
		Jedis redis = getJedis();
		redis.subscribe(jedisPubSub, channel);
		jedisPool.returnResource(redis);
	}
    
    /**
     * 获得点赞量，评论量，关注量，收藏量等
     * getZScroe:(获得zadd对象的score值). <br/> 
     *
     * @author panguixiang
     * @param key
     * @param value
     * @since JDK 1.7
     */
    @SuppressWarnings("deprecation")
	public static double getZScroe(String key,String value) {
		Jedis redis = getJedis();
		Double scroe = redis.zscore(key, value);//若不存在则为空
		jedisPool.returnResource(redis);
		if(scroe==null) {
			scroe =0.0;
		}
		return scroe;
	}
    /**
     * 
     * updateSetZscore:(修改score). <br/> 
     * 用户修改/新增，点赞量，评论量，关注量，收藏量等
     * @author panguixiang
     * @param key   key
     * @param score  排序下标
     * @param value 一般指itemid
     * @return
     * @since JDK 1.7
     */
    @SuppressWarnings("deprecation")
	public static double updateSetZscore(String key,int scoreOpt,String value) {
    	Jedis redis = getJedis();
		Double score = redis.zscore(key, value);//若不存在则为空
		if(score==null) {
			score=(double) (0+scoreOpt);
		} else {
			score=(double) (score+scoreOpt);
		}
		redis.zadd(key,score, value);
		jedisPool.returnResource(redis);
		return score;
    }
    /**
     * 
     * getZsetValueList:(获取zset里面指定key的指定下标set集合，排序后的结果). <br/> 
     * 
     * @author panguixiang
     * @param key key
     * @param start 开始下标 下标从0开始
     * @param end  结束下标 -1为获取所有后面的元素
     * @param orderType  获得的集合排序方式 （可为空，表示从小到大获取）
     * @return
     * @since JDK 1.7
     */
    @SuppressWarnings("deprecation")
	public static Set<String> getZsetValueList(String key,int start,int end,String orderType) {
    	Jedis redis = getJedis();
    	Set<String> set = null;
    	if(StringUtils.equals(orderType, RedisKeyContext.ZSET_LIST_ORDER_DESC)) {//按score从大到小
    		set = redis.zrevrange(key, start, end);
    	} else {
    		set = redis.zrange(key, start, end);//按score从小到大
    	}
    	jedisPool.returnResource(redis);
    	return set;
    }
    
    
    public static byte[] serialize(Object object) {
		if (object == null) {
			return null;
		}
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		byte[] bytes = null;
		try {
			// // 序列化
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			bytes = baos.toByteArray();
		} catch (Exception e) {
			logger.error(e.fillInStackTrace());
		} finally {
			if(oos!=null) {
				try {
					oos.close();
				} catch (IOException e) {
					logger.error(e.fillInStackTrace());
				}
			}
			if(baos!=null) {
				try {
					baos.close();
				} catch (IOException e) {
					logger.error(e.fillInStackTrace());
				}
			}
			
		}
		// return JSONObject.toJSONString(object).getBytes();
		return bytes;
	}

	public static Object unserialize(byte[] bytes) {
		if (bytes == null) {
			return null;
		} /*
			 * return JSONObject.parse(bytes);
			 */
		ByteArrayInputStream bais = null;
		ObjectInputStream ois = null;
		try {
			// // 反序列化
			bais = new ByteArrayInputStream(bytes);
			ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (Exception e) {
			logger.error(e.fillInStackTrace());
		}  finally {
			if(ois!=null) {
				try {
					ois.close();
				} catch (IOException e) {
					logger.error(e.fillInStackTrace());
					e.printStackTrace();
				}
			}
			if(bais!=null) {
				try {
					bais.close();
				} catch (IOException e) {
					logger.error(e.fillInStackTrace());
				}
			}
			
		}
		return bais;
	}
}