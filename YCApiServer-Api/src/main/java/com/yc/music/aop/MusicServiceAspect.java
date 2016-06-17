package com.yc.music.aop;

import java.util.Date;
import java.util.Map;

import org.apache.commons.httpclient.util.DateUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

import com.alibaba.fastjson.JSONObject;
import com.yc.music.common.context.YcContext;
import com.yc.music.model.aop.ServiceAopLog;

/**
 * 定义一个service 的aop,异常，log处理
 * 
 * @ClassName: MusicServiceAspect
 * @Description: TODO
 * @author Comsys-lx
 * @date 2016年4月21日 下午9:11:41
 *
 */
/*@Component
@Aspect*/
public class MusicServiceAspect {

	// 配置切入点,该方法无方法体,主要为方便同类中其他方法使用此处配置的切入点
//	@Pointcut("execution(* com.yc.music.service..*Aoplog(..))")
	public void aspect() {
	}

	/**
	 * 
	 * afterReturn:(需要AOP的service action执行完后，将此记录计入redis订阅). <br/>
	 *
	 * @author panguixiang
	 * @param joinPoint
	 * @param result
	 * @since JDK 1.7
	 */
	//@AfterReturning(value = "aspect()", returning = "result")
	public void afterReturn(JoinPoint joinPoint, Map<String, Object> result) {
	//	ServiceAopLog log = createLog(joinPoint, result, "", 200);
	//	RedisUtil.publishJsonStr(RedisKeyContext.REDIS_PUB_LOG_CHANNEL, JSONObject.toJSON(log).toString());
	}
	/**
	 * 
	 * doThrow:(需要AOP的service action执行运行抛出异常，将此记录计入redis订阅). <br/> 
	 * @author panguixiang
	 * @param joinPoint
	 * @param ex
	 * @since JDK 1.7
	 */
/*	@AfterThrowing(value = "aspect()", throwing = "ex")
	public void doThrow(JoinPoint joinPoint, Exception ex) {
		ServiceAopLog log = createLog(joinPoint, null, ex.getMessage() + ex.fillInStackTrace(), 500);
		RedisUtil.publishJsonStr(RedisKeyContext.REDIS_PUB_LOG_CHANNEL, JSONObject.toJSON(log).toString());
	}*/

	private ServiceAopLog createLog(JoinPoint joinPoint, Map<String, Object> map, String exceptionMsg, int code) {
		Object[] paramArr = joinPoint.getArgs();// 入参列表
		StringBuffer paramStr = new StringBuffer("");
		int i = 1;
		for (Object obj : paramArr) {
			paramStr.append("参数").append(i).append("=").append(String.valueOf(obj)).append(",");
			i++;
		}
		Signature signature = joinPoint.getSignature();
		ServiceAopLog log = new ServiceAopLog();
		log.setActionFullName(signature.getDeclaringTypeName() + "." + signature.getName());
		log.setParams(paramStr.toString());
		if (map != null) {
			log.setReturnData(JSONObject.toJSONString(map));
		}
		log.setCreateDate(DateUtil.formatDate(new Date(), YcContext.DATE_STR_PATTERN));
		log.setExceptionMsg(exceptionMsg);
		log.setCode(code);
		return log;
	}

}
