package com.yc.music.context;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import com.yc.music.common.context.YcContext;
import com.yc.music.common.util.RedisUtil;
/**
 * 初始化系统参数
 * ClassName: InitCacheServlet <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年4月26日 下午6:19:57 <br/>
 *
 * @author panguixiang
 * @version
 */
public class InitCacheServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4784389336338917419L;
	
	private static Logger logger = Logger.getLogger(InitCacheServlet.class);
	
	public void init() throws ServletException {
		logger.info("============初始化业务系统Redis 配置====开始==================");
		redisConfig();
		RedisUtil.createRedisPool();
		logger.info("============初始化业务系统Redis 配置====结束==================");
	}
	
	private void redisConfig() {
		String redisConfig = this.getInitParameter("redisConfig");
		String[] configArr = redisConfig.split(",");
 		YcContext.redis_ip=configArr[0];
		YcContext.redis_port=Integer.parseInt(configArr[1]);
		YcContext.redis_timeout=Integer.parseInt(configArr[2]);
		YcContext.redis_MaxIdle=Integer.parseInt(configArr[3]);
		YcContext.redis_MaxWaitMillis=Long.parseLong(configArr[4]);
	}
	
} 
