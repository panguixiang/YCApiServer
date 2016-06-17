package com.yc.music.interceptor;

import java.io.IOException;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.alibaba.fastjson.JSONObject;
import com.yc.music.common.context.YcContext;
import com.yc.music.common.enums.HttpCodeEnum;
import com.yc.music.common.secret.RSATools;
import com.yc.music.common.util.RedisUtil;
/**
 * 重写 spring mvc的编码过滤器，添加对请求的数据解密处理
  * @ClassName: MyCharacterFilter
  * @Description: TODO
  * @author Comsys-panguixiang
  * @date 2016年4月22日 下午2:21:32
  *
 */
public class MyCharacterFilter extends CharacterEncodingFilter {
	
	private static Logger logger = Logger.getLogger(MyCharacterFilter.class);
	
	/**
	 * 定义私有常量，节省 每次方法体创建
	 */
	private final static String URL_A="/java/common/redict/message";
	private final static String URL_B="/java/common/redict/message?code=";
	private final static String URL_C="/java/common";
	private final static String URL_UPLOAD="/java/common/uploadcallback/uploadmp3";
	private final static String PUB_URL="/java/pub";
	
	/**
	 * 1. 判断data是否为空，判断data是否为受信任的app发送
	 * 2.判断 签名 base64((RSA(报文体)))
	 * 3. 若为登录状态下访问的资源，则需要校验其token
	 * TODO 重写spring 字符编码处理filter，增加请求参数解密，合法性校验.
	 * @see org.springframework.web.filter.CharacterEncodingFilter#doFilterInternal(javax.servlet.http.HttpServletRequest, 
	 * javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	protected void doFilterInternal(
			HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		ParameterRequestWrapper requestWrapper = new ParameterRequestWrapper(request);
		String data = request.getParameter(YcContext.DATA);
		String url = request.getRequestURI();
		JSONObject json = null;
		String token = YcContext.EMPTY_STRING;
		String decodeData=YcContext.EMPTY_STRING;
		try{
			if(StringUtils.isBlank(url) || StringUtils.equals(url, YcContext.Slash)) {
				super.doFilterInternal(requestWrapper, response, filterChain);
			}
			else if(StringUtils.equals(url,URL_A) || StringUtils.equals(url,URL_UPLOAD) ) {
				super.doFilterInternal(requestWrapper, response, filterChain);
			}
			else if(url.indexOf(PUB_URL)>-1) {
				super.doFilterInternal(requestWrapper, response, filterChain);
			}
			else if(StringUtils.isBlank(data)) {//校验data是否为空
				response.sendRedirect(URL_B+HttpCodeEnum.DATE_NULL.getCode());
			} else if(!RedisUtil.filterOftenClient(data)) {//过滤同一data请求10分钟内不能重复请求
				response.sendRedirect(URL_B+HttpCodeEnum.REQUEST_OFTEN.getCode());
			}
			else {//校验解密及登录token权限
					decodeData = RSATools.RSADecode(RSATools.decodeStr(data));//解密 及 校验是否为受信任的app请求
					decodeData.replace("\\",YcContext.EMPTY_STRING);
					json =  JSONObject.parseObject(decodeData);
					createParamMap(json,requestWrapper);
					
					/**
					 * 需要校验token其合法性
					 */
					if(json.containsKey(YcContext.token)) {
						token = json.getString(YcContext.token);
					}
					if(StringUtils.contains(url, URL_C)) {//不需要登录状态下才可以访问的资源
						super.doFilterInternal(requestWrapper, response, filterChain);
					} else if(StringUtils.isBlank(token)) {
						response.sendRedirect(URL_B+HttpCodeEnum.TOKEN_NULL.getCode());
					}else if(!RedisUtil.checkLoginToken(token,YcContext.TOKEN_EXPRESSION_TIME)) {
						logger.info("==========token========"+token);
						response.sendRedirect(URL_B+HttpCodeEnum.TOKEN_ERROR.getCode());
					} else {
						super.doFilterInternal(requestWrapper, response, filterChain);
					}
				}
		} catch(Exception e) {
			response.sendRedirect(URL_B+HttpCodeEnum.DATE_SEC_ERROR.getCode());
			logger.error(e);
		}
	}
	/**
	 * 
	 * createParamMap:(对解密后的数据进行封装成controller里的请求参数). <br/> 
	 *
	 * @author panguixiang
	 * @param dataStr
	 * @param requestWrapper
	 * @throws Exception
	 * @since JDK 1.7
	 */
	private void createParamMap(JSONObject json,ParameterRequestWrapper requestWrapper) throws Exception{
		for (Map.Entry<String, Object> entry : json.entrySet()) {
			requestWrapper.addParameter(entry.getKey(), entry.getValue());
		}
	}
}
