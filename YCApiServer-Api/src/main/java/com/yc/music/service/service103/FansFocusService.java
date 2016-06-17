/**
 * Project Name:YCApiServer-Api
 * File Name:WorkZanService.java
 * Package Name:com.yc.music.service.service103
 * Date:2016年5月19日上午10:44:23
 * Copyright (c) 2016 
 *
 */
package com.yc.music.service.service103;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.yc.music.common.context.YcContext;
import com.yc.music.common.util.BindingResultUtil;
import com.yc.music.common.util.RoomUtil;
import com.yc.music.mapper.cache.UserCacheMapper;
import com.yc.music.mapper.dao.FocusFansMapper;
import com.yc.music.model.fansfocus.FansList;
import com.yc.music.model.fansfocus.FansOpt;
import com.yc.music.model.fansfocus.FansUid;
import com.yc.music.model.musicuser.MusicUserVo;

/**
 * 粉丝 关注 service
 * ClassName: FansFocusService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月19日 上午10:44:23 <br/>
 *
 * @author panguixiang
 * @version 
 */
@Service
public class FansFocusService {

	@Autowired
	private FocusFansMapper focusFansMapper;
	

	@Autowired
	private UserCacheMapper userCacheMapper;
	
	@Value("${Pic_QiLiu}")
	private String pIC_QiLiu;
	
	/**
	 * 
	 * optWorkFov:(粉丝 关注  取消关注). <br/> 
	 *
	 * @author panguixiang
	 * @param opt
	 * @param binding
	 * @param result
	 * @return
	 * @throws Exception
	 * @since JDK 1.7
	 */
	public Map<String,Object> optFansFocus(FansOpt opt, BindingResult binding, Map<String,Object> result) throws Exception {
		String valiterMsg = BindingResultUtil.getBindErrorMsg(binding);
		if(StringUtils.isNotBlank(valiterMsg)) {
			result.put(YcContext.CODE, 400);
			result.put(YcContext.MESSAGE, valiterMsg);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			return result;
		}
		focusFansMapper.proFansfocus(opt);
		result.put(YcContext.CODE, 200);
		result.put(YcContext.MESSAGE, YcContext.EMPTY_STRING);
		result.put(YcContext.DATA,opt.getResult());
		return result;
	}
	
	/**
	 * 
	 * foucusList:(获得关注，粉丝 列表). <br/> 
	 *
	 * @author panguixiang
	 * @param userid  当前登录用户的id
	 * @param page  页码 
	 * @param type  1=我的粉丝列表 (别人关注我) 2=我的关注列表 （我关注别人）
	 * @param result
	 * @return
	 * @throws Exception
	 * @since JDK 1.7
	 */
	public Map<String,Object> foucusList(Long userid,Integer page,Integer type, 
			Map<String,Object> result) throws Exception {
		int start = 0;
		if (page == null || page < 2) {
			start = 0;
		} else {
			start = (page - 1) * 15;
		}
		List<FansList> list = null;
		MusicUserVo user=null;
		List<FansUid> userList=null;
		List<Long> userIdArr = new ArrayList<Long>();
		if(type==null || type==1) {//我的粉丝列表 (别人关注我)
			list = focusFansMapper.getMyFansList(userid,start,15);
			if(list!=null) {
				for(FansList obj:list) {
					userIdArr.add(obj.getFansid());//粉丝id
					user=userCacheMapper.getCacheUservo(obj.getFansid());
					if(user!=null) {
						obj.setFansname(user.getNickname());
						obj.setHeadurl(RoomUtil.jointDomain(user.getHeadurl(),pIC_QiLiu));
						obj.setFansign(user.getSignature());
					}
				}
			}
			if(userIdArr!=null && userIdArr.size()>0) {
				userList = focusFansMapper.getFocusIdsByIn(userid, userIdArr);
				if(userList!=null && list!=null){
					for(FansUid m: userList) {
						for(FansList obj:list) {
							if(m.getUid()==obj.getFansid()) {//粉丝id和查询的粉丝id是否一样
								obj.setStatus(2);//已经互相关注
							}
						}
					}
				}
			}
		} else {//我的关注列表 （我关注别人）
			list = focusFansMapper.getMyFocusList(userid,start,15);
			if(list!=null){
				for(FansList obj:list) {
					userIdArr.add(obj.getUserid());//被关注者id
					user=userCacheMapper.getCacheUservo(obj.getFansid());
					if(user!=null) {
						obj.setFansname(user.getNickname());
						obj.setHeadurl(RoomUtil.jointDomain(user.getHeadurl(),pIC_QiLiu));
						obj.setFansign(user.getSignature());
					}
				}
			}
			if(userIdArr!=null && userIdArr.size()>0) {
				userList = focusFansMapper.getFocusIdsOtherMeByIn(userid, userIdArr);
				if(userList!=null && list!=null){
					for(FansUid m: userList) {
						for(FansList obj:list) {
							if(m.getUid()==obj.getUserid()) {
								obj.setStatus(2);//已经互相关注
							}
						}
					}
				}
			}
		}
		result.put(YcContext.CODE, 200);
		result.put(YcContext.MESSAGE, YcContext.EMPTY_STRING);
		result.put(YcContext.DATA,list);
		return result;
	}
	
	
	
	
	/**
	 * 
	 * foucusList:(获得别人关注，粉丝 列表). <br/> 
	 *
	 * @author panguixiang
	 * @param userid  进入空间的用户id
	 * @param page  页码 
	 * @param type  1=别人的粉丝列表  2=别人的关注列表 
	 * @param result
	 * @return
	 * @throws Exception
	 * @since JDK 1.7
	 */
	public Map<String,Object> otherfoucusList(Long userid,Long myUId, Integer page,Integer type, 
			Map<String,Object> result) throws Exception {
		int start = 0;
		if (page == null || page < 2) {
			start = 0;
		} else {
			start = (page - 1) * 15;
		}
		List<FansList> list = null;
		MusicUserVo user=null;
		List<FansUid> userList=null;
		List<Long> userIdArr = new ArrayList<Long>();
		if(type==null || type==1) {//别人的粉丝列表  
			list = focusFansMapper.getMyFansList(userid,start,15);
			if(list!=null){
				for(FansList obj:list) {
					userIdArr.add(obj.getFansid());//粉丝id
					user=userCacheMapper.getCacheUservo(obj.getFansid());
					if(user!=null) {
						obj.setFansname(user.getNickname());
						obj.setHeadurl(RoomUtil.jointDomain(user.getHeadurl(),pIC_QiLiu));
						obj.setFansign(user.getSignature());
					}
				}
			}
			if(userIdArr!=null && userIdArr.size()>0) {
				userList = focusFansMapper.getFocusIdsByIn(myUId, userIdArr);
				if(list!=null && userList!=null){
					for(FansUid m: userList) {
						for(FansList obj:list) {
							if(m.getUid()==obj.getFansid()) {//粉丝id和查询的粉丝id是否一样
								obj.setStatus(1);//已经关注他的粉丝
							}else {
								obj.setStatus(0);//我未关注他的粉丝
							}
						}
					}
				}
			}
		} else {//别人的关注列表 
			list = focusFansMapper.getMyFocusList(userid,start,15);
			if(list!=null) {
				for(FansList obj:list) {
					userIdArr.add(obj.getUserid());//被关注者id
					user=userCacheMapper.getCacheUservo(obj.getFansid());
					if(user!=null) {
						obj.setFansname(user.getNickname());
						obj.setHeadurl(RoomUtil.jointDomain(user.getHeadurl(),pIC_QiLiu));
						obj.setFansign(user.getSignature());
					}
				}
			}
			if(userIdArr!=null && userIdArr.size()>0) {
				userList = focusFansMapper.getFocusIdsByIn(myUId, userIdArr);
				if(list!=null && userList!=null){
					for(FansUid m: userList) {
						for(FansList obj:list) {
							if(m.getUid()==obj.getFansid()) {//粉丝id和查询的粉丝id是否一样
								obj.setStatus(1);//已经关注他的粉丝
							}else {
								obj.setStatus(0);//我未关注他的粉丝
							}
						}
					}
				}
			}
		}
		result.put(YcContext.CODE, 200);
		result.put(YcContext.MESSAGE, YcContext.EMPTY_STRING);
		result.put(YcContext.DATA,list);
		return result;
	}
}
