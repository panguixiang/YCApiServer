/**
 * Project Name:YCApiServer-Api
 * File Name:MessageService.java
 * Package Name:com.yc.music.service.service103
 * Date:2016年5月13日下午2:10:01
 * Copyright (c) 2016 
 *
 */
package com.yc.music.service.service103;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.yc.music.common.context.YcContext;
import com.yc.music.common.util.RoomUtil;
import com.yc.music.mapper.cache.UserCacheMapper;
import com.yc.music.mapper.dao.WorkCommentMapper;
import com.yc.music.mapper.dao.WorkFovMapper;
import com.yc.music.mapper.dao.WorkZanMapper;
import com.yc.music.model.comment.MyCommentCenter;
import com.yc.music.model.messge.MeesageCenter;
import com.yc.music.model.musicFov.MyFovCenter;
import com.yc.music.model.musicuser.MusicUserVo;
import com.yc.music.model.workzan.ZanCenterVo;

/**
 * ClassName: MessageService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月13日 下午2:10:01 <br/>
 *
 * @author panguixiang
 * @version 
 */
@Service
public class MessageService {

	@Autowired
	private WorkCommentMapper workCommentMapper;
	
	@Autowired
	private WorkZanMapper workZanMapper;
	
	@Autowired
	private WorkFovMapper workFovMapper;
	
	@Autowired
	private UserCacheMapper userCacheMapper;
	
	@Value("${Pic_QiLiu}")
	private String pIC_QiLiu;
	
	/**
	 * 
	 * center:(消息中心页面，数据). <br/> 
	 *
	 * @author panguixiang
	 * @param targetuid 用户主键id
	 * @param result
	 * @return
	 * @since JDK 1.7
	 */
	public Map<String,Object> center(Long targetuid,Map<String,Object> result) {
		int targetUserCommentCount = workCommentMapper.getNewCommentCountBytuid(targetuid,1);//评论量,1=未读
		int targetUserZanCount = workZanMapper.getWorkZanCountByTUid(targetuid, 1);//点赞量,1=未读
		int targetUserFovCount = workFovMapper.getWorkFovCountByTUid(targetuid, 1);//收藏量,1=未读
		MeesageCenter center = new MeesageCenter();
		center.setCommentnum(targetUserCommentCount);//评论
		center.setFovnum(targetUserFovCount);//收藏
		center.setZannum(targetUserZanCount);//
		result.put(YcContext.CODE, 200);
		result.put(YcContext.MESSAGE, YcContext.EMPTY_STRING);
		result.put(YcContext.DATA,center);
		return result;
	}
	
	/**
	 * 
	 * commentCenterList:(消息中心-评论列表). <br/> 
	 *
	 * @author panguixiang
	 * @param uid 用户id
	 * @param page
	 * @return
	 * @since JDK 1.7
	 */
	public void commentCenterList(Long uid,Integer page,Map<String,Object> result) throws Exception{
		int start =0;
		if(page!=null && page>1) {
			start=(page-1)*10;
		}
		List<MyCommentCenter> list = workCommentMapper.myCommentCenterList(uid, start, 15);
		MusicUserVo user=null;
		if(list!=null){
			for(MyCommentCenter obj : list) {
				obj.setPic(RoomUtil.jointDomain(obj.getPic(),pIC_QiLiu));
				user=userCacheMapper.getCacheUservo(obj.getUid());
				if(user!=null){
					obj.setNickname(user.getNickname());
					obj.setHeaderurl(RoomUtil.jointDomain(user.getHeadurl(),pIC_QiLiu));
				}
				user=userCacheMapper.getCacheUservo(obj.getTarget_uid());
				if(user!=null) {
					obj.setTargetname(user.getNickname());
					obj.setTargetHeader(RoomUtil.jointDomain(user.getHeadurl(),pIC_QiLiu));
				}
				user=userCacheMapper.getCacheUservo(obj.getAuthorid());//作者id
				obj.setAuthor(user.getNickname());
			}
		}
		workCommentMapper.setCommentIsRead(uid,0);//1=未读，0=已读
		result.put(YcContext.CODE, 200);
		result.put(YcContext.MESSAGE, YcContext.EMPTY_STRING);
		result.put(YcContext.DATA,list);
	}
	
	
	/**
	 * 
	 * zanCenterList:(消息中心-点赞列表). <br/> 
	 *
	 * @author panguixiang
	 * @param uid
	 * @param page
	 * @param result
	 * @throws Exception
	 * @since JDK 1.7
	 */
	public void zanCenterList(Long uid,Integer page,Map<String,Object> result) throws Exception{
		int start =0;
		if(page!=null && page>1) {
			start=(page-1)*10;
		}
		List<ZanCenterVo> list = workZanMapper.getZanCenterList(uid, start, 15);
		MusicUserVo user=null;
		if(list!=null){
			for(ZanCenterVo obj : list) {
				obj.setPic(RoomUtil.jointDomain(obj.getPic(),pIC_QiLiu));
				user=userCacheMapper.getCacheUservo(obj.getUser_id());
				if(user!=null){
					obj.setNickname(user.getNickname());
					obj.setHeaderurl(RoomUtil.jointDomain(user.getHeadurl(),pIC_QiLiu));
				}
				user=userCacheMapper.getCacheUservo(obj.getTarget_uid());
				if(user!=null){
					obj.setAuthor(user.getNickname());
				}
			}
		}
		workZanMapper.setZanIsRead(uid,0);//1=未读，0=已读
		result.put(YcContext.CODE, 200);
		result.put(YcContext.MESSAGE, YcContext.EMPTY_STRING);
		result.put(YcContext.DATA,list);
	}
	
	/**
	 * 
	 * fovMyCenterList:(消息中心-收藏列表). <br/> 
	 *
	 * @author panguixiang
	 * @param uid
	 * @param page
	 * @param result
	 * @throws Exception
	 * @since JDK 1.7
	 */
	public void fovMyCenterList(Long uid,Integer page,Map<String,Object> result) throws Exception{
		int start =0;
		if(page!=null && page>1) {
			start=(page-1)*10;
		}
		List<MyFovCenter> list = workFovMapper.fovMyCenterList(uid, start, 15);
		MusicUserVo user=null;
		if(list!=null){
			for(MyFovCenter obj : list) {
				obj.setPic(RoomUtil.jointDomain(obj.getPic(),pIC_QiLiu));
				user=userCacheMapper.getCacheUservo(obj.getUser_id());
				if(user!=null){
					obj.setNickname(user.getNickname());
					obj.setHeaderurl(RoomUtil.jointDomain(user.getHeadurl(),pIC_QiLiu));
				}
				user=userCacheMapper.getCacheUservo(obj.getTarget_uid());//作品作者
				if(user!=null){
					obj.setAuthor(user.getNickname());
				}
			}
		}
		workFovMapper.setFovIsRead(uid,0);//1=未读，0=已读
		result.put(YcContext.CODE, 200);
		result.put(YcContext.MESSAGE, YcContext.EMPTY_STRING);
		result.put(YcContext.DATA,list);
	}
	
}
