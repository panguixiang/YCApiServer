package com.yc.music.plug;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.apache.log4j.Logger;

import com.yc.music.common.util.RedisUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

/**
 * 讲mybatis缓存层，重写为redis ClassName: RedisMybatisCache <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年4月26日 上午11:27:42 <br/>
 *
 * @author panguixiang
 * @version
 */
public class RedisMybatisCache implements Cache {

	private static Logger logger = Logger.getLogger(RedisMybatisCache.class);

	/** The ReadWriteLock. */
	private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

	private String id;

	public RedisMybatisCache(final String id) {
		if (id == null) {
			throw new IllegalArgumentException("必须传入ID");
		}
		this.id = id;
	}

	@Override
	public String getId() {
		return this.id;
	}

	@SuppressWarnings("deprecation")
	@Override
	public int getSize() {
		Jedis jedis = null;
		JedisPool jedisPool = null;
		int result = 0;
		boolean borrowOrOprSuccess = true;
		try {
			jedis = CachePool.getInstance().getJedis();
			jedisPool = CachePool.getInstance().getJedisPool();
			if(jedis!=null && jedisPool!=null){
				result = Integer.valueOf(jedis.dbSize().toString());
			}
		} catch (JedisConnectionException e) {
			borrowOrOprSuccess = false;
			if (jedis != null) {
				jedisPool.returnBrokenResource(jedis);
			}
			logger.error(e.fillInStackTrace());
		} finally {
			if (borrowOrOprSuccess&& jedis!=null) {
				jedisPool.returnResource(jedis);
			}
		}
		return result;

	}

	@SuppressWarnings("deprecation")
	@Override
	public void putObject(Object key, Object value) {
		Jedis jedis = null;
		JedisPool jedisPool = null;
		boolean borrowOrOprSuccess = true;
		byte[] keyByte = SerializeUtil.serialize(key.hashCode());
		try {
			jedis = CachePool.getInstance().getJedis();
			jedisPool = CachePool.getInstance().getJedisPool();
			if(jedis!=null && jedisPool!=null && value !=null){
				jedis.setex(keyByte, 900, SerializeUtil.serialize(value));// 15分钟有效
			}
		} catch (JedisConnectionException e) {
			borrowOrOprSuccess = false;
			if (jedis != null) {
				jedisPool.returnBrokenResource(jedis);
			}
			logger.error(e.fillInStackTrace());
		} finally {
			if (borrowOrOprSuccess&& jedis!=null) {
				jedisPool.returnResource(jedis);
			}
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public Object getObject(Object key) {
		Jedis jedis = null;
		JedisPool jedisPool = null;
		Object value = null;
		boolean borrowOrOprSuccess = true;
		byte[] keyByte = SerializeUtil.serialize(key.hashCode());
		try {
			jedis = CachePool.getInstance().getJedis();
			jedisPool = CachePool.getInstance().getJedisPool();
			if(jedis!=null && jedisPool!=null){
				value = SerializeUtil.unserialize(jedis.get(keyByte));
			}
		} catch (JedisConnectionException e) {
			borrowOrOprSuccess = false;
			if (jedis != null) {
				jedisPool.returnBrokenResource(jedis);
			}
			logger.error(e.fillInStackTrace());
		} finally {
			if (borrowOrOprSuccess && jedis!=null) {
				jedisPool.returnResource(jedis);
			}
		}
		return value;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Object removeObject(Object key) {
		Jedis jedis = null;
		JedisPool jedisPool = null;
		Object value = null;
		boolean borrowOrOprSuccess = true;
		try {
			jedis = CachePool.getInstance().getJedis();
			jedisPool = CachePool.getInstance().getJedisPool();
			if(jedis!=null && jedisPool!=null){
				value = jedis.expire(SerializeUtil.serialize(key.hashCode()), 0);
			}
		} catch (JedisConnectionException e) {
			borrowOrOprSuccess = false;
			if (jedis != null) {
				jedisPool.returnBrokenResource(jedis);
			}
			logger.error(e.fillInStackTrace());
		} finally {
			if (borrowOrOprSuccess&& jedis!=null) {
				jedisPool.returnResource(jedis);
			}
		}
		return value;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void clear() {
		Jedis jedis = null;
		JedisPool jedisPool = null;
		boolean borrowOrOprSuccess = true;
		try {
			jedis = CachePool.getInstance().getJedis();
			jedisPool = CachePool.getInstance().getJedisPool();
			if(jedis!=null && jedisPool!=null){
				jedis.flushDB();
				jedis.flushAll();
			}
		} catch (JedisConnectionException e) {
			borrowOrOprSuccess = false;
			if (jedis != null) {
				jedisPool.returnBrokenResource(jedis);
			}
			logger.error(e.fillInStackTrace());
		} finally {
			if (borrowOrOprSuccess&& jedis!=null) {
				jedisPool.returnResource(jedis);
			}
		}
	}

	@Override
	public ReadWriteLock getReadWriteLock() {
		return readWriteLock;
	}

	/**
	 * 
	 * @ClassName: CachePool
	 * @Description: TODO(单例Cache池)
	 * @author LiuYi
	 * @date 2014年6月17日 上午10:50:52
	 *
	 */
	public static class CachePool {
		JedisPool pool;
		private static final CachePool cachePool = new CachePool();

		public static CachePool getInstance() {
			return cachePool;
		}

		private CachePool() {
			pool = RedisUtil.getRedisPool();
		}

		@SuppressWarnings("deprecation")
		public Jedis getJedis() {
			Jedis jedis = null;
			try {
				jedis = pool.getResource();
			} catch (JedisConnectionException e) {
				if (jedis != null) {
					pool.returnBrokenResource(jedis);
				}
				logger.error(e.fillInStackTrace());
			} 
			return jedis;
		}

		public JedisPool getJedisPool() {
			return this.pool;
		}

	}

	public static class SerializeUtil {
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
}
