/**
 * Project Name:YCApiServer-Api
 * File Name:SendCodeService.java
 * Package Name:com.yc.music.service.service103
 * Date:2016年5月11日上午10:07:22
 * Copyright (c) 2016 
 *
 */
package com.yc.music.service.service103;

import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.yc.music.common.context.YcContext;
import com.yc.music.common.sms.SendSmsUtils;
import com.yc.music.common.util.DateUtil;
import com.yc.music.common.util.RoomUtil;
import com.yc.music.context.YtConstant;
import com.yc.music.mapper.dao.MobileCodeLogMapper;
import com.yc.music.mapper.dao.MobileCodeMapper;
import com.yc.music.mapper.dao.UserMapper;
import com.yc.music.model.MobileCode;
import com.yc.music.model.mobilecode.SendLogPro;

/**
 * ClassName: SendCodeService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月11日 上午10:07:22 <br/>
 *
 * @author panguixiang
 * @version 
 */
@Service
public class SendCodeService {
	
	@Autowired
	private MobileCodeMapper mCodeMapper;
	
	@Autowired
	private MobileCodeLogMapper mobileCodeLogMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Value("${secret}")
	private String secret;
	
	@Value("${send_max_ip}")
	private String send_max_ip;
	
	
	public Map<String,Object> sendRegisterCode(String mobile,String type,String ip,Map<String,Object> result) throws Exception {
		mobile=mobile.trim();
		Pattern p = Pattern.compile(YcContext.Mobile_PARTTEN);  
		Matcher m = p.matcher(mobile);  
		if(!m.matches()) {//校验手机号码格式
			result.put(YcContext.CODE, 400);
			result.put(YcContext.MESSAGE,YtConstant.mobile_pattern_error);
			result.put(YcContext.DATA, YcContext.EMPTY_STRING);
			return result;
		}
		MobileCode codeObj = mCodeMapper.getMobileCodeByPhone(mobile.trim());
		if(codeObj!=null) {//校验是否存在1分钟之类的验证码
			if(DateUtil.checkSendSmsCodeTime(codeObj.getSendTime())) {//依然还在1秒钟内
				result.put(YcContext.CODE, 400);
				result.put(YcContext.MESSAGE,YtConstant.mobile_sendCode_error);
				result.put(YcContext.DATA, YcContext.EMPTY_STRING);
				return result;
			}
		}
		String dym=DateUtil.patternDateToStr(new Date(),YcContext.DATE_STR_YMD);
		int count =mobileCodeLogMapper.getCountByIpDate(ip, dym);
		if(count>Integer.parseInt(send_max_ip)) {//校验同一个ip一天最多请求30次
			result.put(YcContext.CODE, 400);
			result.put(YcContext.MESSAGE,YtConstant.send_code_numout);
			result.put(YcContext.DATA, YcContext.EMPTY_STRING);
			return result;
		}
		if(StringUtils.equals(type, "1")) {//注册验证码
			if(userMapper.getUserByPhoneCount(mobile)>0) {//手机号码是否已经注册过
				result.put(YcContext.CODE, 400);
				result.put(YcContext.MESSAGE,YtConstant.MOBILE_IS_USED);
				result.put(YcContext.DATA, YcContext.EMPTY_STRING);
				return result;
			}
		} else {//密码重置
			if(userMapper.getUserByPhoneCount(mobile)==0) {//手机号码是否已经注册过
				result.put(YcContext.CODE, 400);
				result.put(YcContext.MESSAGE,YtConstant.MOBILE_IS_NOT_REGISTER);
				result.put(YcContext.DATA, YcContext.EMPTY_STRING);
				return result;
			}
		}
		/**
		 * 调用发送验证码接口
		 */
		String code=RoomUtil.createRandomVcode();
		SendSmsUtils.sendSmSCode(290902781L,mobile,secret,code);
		/**
		 * 持久化发送日志到数据库
		 */
		SendLogPro pro = new SendLogPro();
		pro.setCreatedate(dym);
		pro.setIp(ip);
		pro.setMobile(mobile);
		pro.setSendtime(new Date());
		pro.setSmscode(code);
		pro.setSmstype(Integer.parseInt(type));
		mobileCodeLogMapper.proSndSMSLog(pro);
		
		result.put(YcContext.CODE, 200);
		result.put(YcContext.MESSAGE, YtConstant.CODE_SUCCSS_MSG);
		result.put(YcContext.DATA, YcContext.EMPTY_STRING);
		return result;
	}
	
}
