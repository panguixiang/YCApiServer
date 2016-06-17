package com.yc.music.service.service103;

import java.util.Map;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.alibaba.fastjson.JSONObject;
import com.yc.music.common.context.YcContext;
import com.yc.music.common.util.BindingResultUtil;
import com.yc.music.common.util.DateUtil;
import com.yc.music.common.util.RedisUtil;
import com.yc.music.common.util.RoomUtil;
import com.yc.music.context.YtConstant;
import com.yc.music.mapper.dao.MobileCodeMapper;
import com.yc.music.mapper.dao.UserLoginLogMapper;
import com.yc.music.mapper.dao.UserMapper;
import com.yc.music.model.MobileCode;
import com.yc.music.model.User;
import com.yc.music.model.UserLoginVo;
import com.yc.music.model.musicuser.UserInfo;
import com.yc.music.model.musicuser.UserLoginLog;
/**
 * 
  * @ClassName: UserService1003
  * @Description: TODO
  * @author Comsys-panguixiang
  * @date 2016年4月8日 上午9:36:36
  *
 */
@Service
public class UserService1003 {

	private static Logger logger = Logger.getLogger(UserService1003.class);
	
	@Value("${Pic_QiLiu}")
	private String pIC_QiLiu;
	
	@Value("${LOGIN_EXPIRE_TIME}")
	private Integer login_EXPIRE_TIME;
	
	@Autowired
	private MobileCodeMapper mCodeMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserLoginLogMapper userLoginLogMapper;
	
	/**
	 * 注册
	 * @param user
	 * @return
	 */
	public Map<String,Object> saveMobileUser(User user,BindingResult binding,Map<String,Object> result) throws Exception{
		
		String valiterMsg = BindingResultUtil.getBindErrorMsg(binding);
		if(StringUtils.isNotBlank(valiterMsg)) {
			result.put(YcContext.CODE, 400);
			result.put(YcContext.MESSAGE, valiterMsg);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			return result;
		}
		if(!StringUtils.equals(user.getPassword(), user.getRepassword())) {
			result.put(YcContext.CODE, 400);
			result.put(YcContext.MESSAGE, YtConstant.REGISTER_PASSWORD_REPASSWORD_MSG);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			return result;
		}
		MobileCode codeObj = mCodeMapper.getMobileCode(user.getPhone(), user.getCode());
		if(codeObj==null) {
			result.put(YcContext.CODE, 400);
			result.put(YcContext.MESSAGE, YtConstant.CODE_NOT_FIND_MSG);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			return result;
		}
		if(codeObj.getStatus()==2) {
			result.put(YcContext.CODE, 400);
			result.put(YcContext.MESSAGE, YtConstant.CODE_IS_USED_MSG);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			return result;
		}
		if(!DateUtil.compareCodeDateTime(codeObj.getSendTime())) {
			codeObj.setStatus(2);
			mCodeMapper.updateCode(codeObj);
			result.put(YcContext.CODE, 400);
			result.put(YcContext.MESSAGE, YtConstant.CODE_IS_TIMEOUT);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			return result;
		}else {
			codeObj.setStatus(2);
			mCodeMapper.updateCode(codeObj);
		}
        if(userMapper.getUserByPhoneCount(user.getPhone())>0) {
			result.put(YcContext.CODE, 400);
			result.put(YcContext.MESSAGE, YtConstant.MOBILE_IS_USED);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			mCodeMapper.updateCode(codeObj);
			return result;
        }
        user.setHeadurl(YcContext.USER_DEFAULT_HEADER);//默认头像
        user.setRegtype("phone");
        user.setBgpic(YcContext.EMPTY_STRING);
        userMapper.save(user);
        /**
         * 免登录数据
         */
        UserLoginVo loginVo = new UserLoginVo();
        loginVo.setUserid(user.getUserid());
        loginVo.setName(user.getName());
        loginVo.setHeadurl(RoomUtil.jointDomain(user.getHeadurl(),pIC_QiLiu));
    	String loginToken = DigestUtils.md5Hex(UUID.randomUUID().toString());
    	RedisUtil.saveString(loginToken,JSONObject.toJSONString(loginVo),login_EXPIRE_TIME);
		loginVo.setLoginToken(loginToken);
		result.put(YcContext.CODE, 200);
		result.put(YcContext.MESSAGE, YcContext.EMPTY_STRING);
		result.put(YcContext.DATA,loginVo);
        return result;
	}
	
	/**
	 * 手机登录
	 * @param mobile
	 * @param password
	 * @return
	 */
	public Map<String,Object> loginMobile(String mobile, String password,
			Map<String,Object> result,String clientIp) throws Exception{
		
		if(StringUtils.isBlank(mobile)) {
			result.put(YcContext.CODE, 400);
			result.put(YcContext.MESSAGE, YtConstant.MOBILE_IS_NOTEMPYT);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			return result;
		} 
		if(StringUtils.isBlank(password)) {
			result.put(YcContext.CODE, 400);
			result.put(YcContext.MESSAGE, YtConstant.MESSAGE_IS_NOTEMPTY);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			return result;
		} 
		UserLoginVo loginVo = userMapper.loginByMobile(mobile.trim(),password.trim());
		if(loginVo==null) {
			result.put(YcContext.CODE, 400);
			result.put(YcContext.MESSAGE, YtConstant.LOGIN_MESSAGE_ERROR);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			return result;
		} 
		/**
		 * 添加redis登录token
		 */ 
		String loginToken = DigestUtils.md5Hex(UUID.randomUUID().toString());
		loginVo.setHeadurl(RoomUtil.jointDomain(loginVo.getHeadurl(),pIC_QiLiu));
		RedisUtil.saveString(loginToken,JSONObject.toJSONString(loginVo),login_EXPIRE_TIME);
		loginVo.setLoginToken(loginToken);
		result.put(YcContext.CODE, 200);
		result.put(YcContext.MESSAGE, YcContext.EMPTY_STRING);
		result.put(YcContext.DATA,loginVo);
		try {
			setLoginLog(loginVo,clientIp,mobile);
		} catch(Exception e) {
			logger.error("登录日志记录异常=="+e);
		}
		return result;
	}
	/**
	 * 
	 * setLoginLog:(业务处理，操作登录日志). <br/> 
	 *
	 * @author panguixiang
	 * @param loginVo
	 * @param clientIp
	 * @param loginAcc
	 * @throws Exception
	 * @since JDK 1.7
	 */
	private void setLoginLog(UserLoginVo loginVo,String clientIp,String loginAcc) throws Exception{
		userMapper.setUserLoginLog(clientIp, loginVo.getUserid());
		UserLoginLog log = new UserLoginLog();
		log.setLoginacc(loginAcc);
		log.setLoginip(clientIp);
		log.setUid(loginVo.getUserid());
		userLoginLogMapper.saveLoginLog(log);
	}
	
	/**
	 * 校验token
	 * @param user
	 * @return
	 */
	public Map<String,Object> checkToken(String token,Map<String,Object> result) throws Exception{
		String userCache = RedisUtil.getString(token.trim(),2);//设置2秒钟后过期
		if(StringUtils.isBlank(userCache)) {
			result.put(YcContext.CODE, 300);
			result.put(YcContext.MESSAGE, YtConstant.USER_TOKEN_EXPIRED);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			return result;
		}
		String loginToken = DigestUtils.md5Hex(UUID.randomUUID().toString());
		RedisUtil.saveString(loginToken,userCache,login_EXPIRE_TIME);
		UserLoginVo loginVo =JSONObject.parseObject(userCache, UserLoginVo.class); 
		loginVo.setLoginToken(loginToken);
		result.put(YcContext.CODE, 200);
		result.put(YcContext.MESSAGE, YcContext.EMPTY_STRING);
		result.put(YcContext.DATA,loginVo);
		return result;
	}
	
	/**
	 * 密码重置
	 * @param user
	 * @return
	 */
	public Map<String,Object> resetpassword(String mobile, String code, String password,
			Map<String,Object> result) throws Exception{
		
		result.put(YcContext.CODE, 400);
		result.put(YcContext.MESSAGE, YcContext.EMPTY_STRING);
		result.put(YcContext.DATA,YcContext.EMPTY_STRING);

		UserLoginVo userVo = userMapper.getUserByPhone(mobile);
        if(userVo==null) {
        	result.put(YcContext.MESSAGE, YtConstant.USER_IS_NOT_EXIST);
        	return result;
        }
		MobileCode codeObj = mCodeMapper.getMobileCode(mobile, code);
		if(codeObj==null) {
			result.put(YcContext.MESSAGE, YtConstant.CODE_NOT_FIND_MSG);
			return result;
		}
		if(codeObj.getStatus()==2) {
			result.put(YcContext.MESSAGE, YtConstant.CODE_IS_USED_MSG);
			return result;
		}
		if(!DateUtil.compareCodeDateTime(codeObj.getSendTime())) {
			codeObj.setStatus(2);
			mCodeMapper.updateCode(codeObj);
			result.put(YcContext.MESSAGE, YtConstant.CODE_IS_TIMEOUT);
			return result;
		}else {
			codeObj.setStatus(2);
			mCodeMapper.updateCode(codeObj);
		}
		
        try {
			userMapper.updatePaswd(mobile,password);
		} catch (Exception e) {
			result.put(YcContext.MESSAGE, YcContext.SYS_ERROR_MSG);
			return result;
		}
        userVo.setHeadurl(RoomUtil.jointDomain(userVo.getHeadurl(),pIC_QiLiu));
    	/**
		 * 添加redis登录token
		 */ 
		String loginToken = DigestUtils.md5Hex(UUID.randomUUID().toString());
        RedisUtil.saveString(loginToken,JSONObject.toJSONString(userVo),login_EXPIRE_TIME);
        userVo.setLoginToken(loginToken);
        result.put(YcContext.CODE, 200);
		result.put(YcContext.MESSAGE, YcContext.EMPTY_STRING);
		result.put(YcContext.DATA,userVo);
        return result;
	}
	
	
	/**
	 * 
	 * updateUserInfo:(修改个人信息). <br/> 
	 *
	 * @author panguixiang
	 * @param info
	 * @param result
	 * @return
	 * @throws Exception
	 * @since JDK 1.7
	 */
	public Map<String,Object> updateUserInfo(UserInfo info, Map<String,Object> result) throws Exception {
		if(info.getUid()==null) {
			result.put(YcContext.CODE, 400);
			result.put(YcContext.MESSAGE, YtConstant.USER_IS_NOT_EXIST);
			result.put(YcContext.DATA, YcContext.EMPTY_STRING);
			return result;
		}
		if(StringUtils.isNotBlank(info.getHeadurl())) {
			info.setHeadurl(RoomUtil.replaceAllDomain(info.getHeadurl()));
			if((info.getHeadurl()).charAt(0)!=YcContext.Slashchar) {
				info.setHeadurl(YcContext.Slash.concat(info.getHeadurl()));
			}
		}
		userMapper.updateInfo(info);
		result.put(YcContext.CODE, 200);
		result.put(YcContext.MESSAGE, YcContext.EMPTY_STRING);
		result.put(YcContext.DATA, YtConstant.SYS_SUCCSS_MSG);
		return result;
	}
	
	/**
	 * 退出登录
	 * @param token
	 * @return
	 */
	public Map<String,Object> loginOut(String token,Map<String,Object> result) throws Exception{
		RedisUtil.deleteReids(token.trim());
		result.put(YcContext.CODE, 200);
		result.put(YcContext.MESSAGE, YtConstant.SYS_SUCCSS_MSG);
		result.put(YcContext.DATA,YcContext.EMPTY_STRING);
		return result;
	}
}
