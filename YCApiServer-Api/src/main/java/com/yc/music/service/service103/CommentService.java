/**
 * Project Name:YCApiServer-Api
 * File Name:WorkCommentService.java
 * Package Name:com.yc.music.service.service103
 * Date:2016年5月8日下午5:47:11
 * Copyright (c) 2016 
 *
 */
package com.yc.music.service.service103;

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
import com.yc.music.context.YtConstant;
import com.yc.music.mapper.cache.UserCacheMapper;
import com.yc.music.mapper.dao.LyricsMapper;
import com.yc.music.mapper.dao.WorkCommentMapper;
import com.yc.music.mapper.dao.WorkMapper;
import com.yc.music.model.comment.YcComment;
import com.yc.music.model.musicuser.MusicUserVo;

/**
 * 评论 service ClassName: CommentService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月8日 下午5:47:11 <br/>
 *
 * @author panguixiang
 * @version
 */
@Service
public class CommentService {

	@Autowired
	private WorkCommentMapper workCommentMapper;
	
	@Autowired
	private UserCacheMapper userCacheMapper;
	
	@Autowired
	private LyricsMapper lyricsMapper;
	
	@Autowired
	private WorkMapper workMapper;
	
	@Value("${Pic_QiLiu}")
	private String pIC_QiLiu;
	
	/**
	 * 
	 * commentList:(分页获得歌曲/歌词评论列表). <br/>
	 *
	 * @author panguixiang
	 * @param itemid
	 * @param type 1=歌曲评论，2=歌词评论
	 * @param page
	 * @return
	 * @since JDK 1.7
	 */
	public void commentList(Long itemid, Integer page, Map<String, Object> result,Integer type) throws Exception {
		result.put(YcContext.CODE, 200);
		result.put(YcContext.MESSAGE, YcContext.EMPTY_STRING);
		int start = 0, size = 20;
		if (page!=null && page > 1) {
			start = (page - 1) * 20;
		}
		List<YcComment> list = workCommentMapper.workCommentList(itemid,type, start, size);
		MusicUserVo user = null;
		if(list!=null) {
			for(YcComment comment:list) {
				user=userCacheMapper.getCacheUservo(comment.getUid());
				if(user!=null){
					comment.setHeaderurl(RoomUtil.jointDomain(user.getHeadurl(),pIC_QiLiu));
					comment.setNickname(user.getNickname());
				}
				if(comment.getTarget_uid()!=0){
					user=userCacheMapper.getCacheUservo(comment.getTarget_uid());
					if(user!=null){
						comment.setTargetheaderurl(RoomUtil.jointDomain(user.getHeadurl(),pIC_QiLiu));
						comment.setTarget_nickname(user.getNickname());
					}
				}
			}
		}
		result.put(YcContext.DATA, list);
	}
	
	/**
	 * 
	 * saveComment:(发布歌曲、歌词 评论). <br/> 
	 *
	 * @author panguixiang
	 * @param YcComment
	 * @param binding
	 * @param type 1=歌曲评论，2=歌词评论
	 * @param result
	 * @return
	 * @throws Exception
	 * @since JDK 1.7
	 */
	public Map<String, Object> saveComment(YcComment comment, BindingResult binding,
			Map<String, Object> result)
			throws Exception {

		String valiterMsg = BindingResultUtil.getBindErrorMsg(binding);
		if (StringUtils.isNotBlank(valiterMsg)) {
			result.put(YcContext.CODE, 400);
			result.put(YcContext.MESSAGE, valiterMsg);
			result.put(YcContext.DATA, YcContext.EMPTY_STRING);
			return result;
		}
		if(comment.getComment_type()==2 && comment.getTarget_uid()==0l) {//1=默认，2=跟帖
			result.put(YcContext.CODE, 400);
			result.put(YcContext.MESSAGE, YtConstant.COMMENT_TARGET_USERID_NULL);
			result.put(YcContext.DATA, YcContext.EMPTY_STRING);
			return result;
		}
		workCommentMapper.saveWorkComment(comment);
		if(comment.getType()==1) {
			workMapper.addCommentNum(comment.getItemid(),1);//加1
		} else {
			lyricsMapper.addLrycCommentNum(comment.getItemid(),1);//加1
		}
		result.put(YcContext.CODE, 200);
		result.put(YcContext.MESSAGE, YcContext.EMPTY_STRING);
		result.put(YcContext.DATA, comment.getId());
		return result;
	}
	
	/**
	 * 
	 * delete:(删除评论). <br/> 
	 *
	 * @author panguixiang
	 * @param id
	 * @param type 1=歌曲，2=歌词
	 * @param itemid 作品id
	 * @param result
	 * @throws Exception
	 * @since JDK 1.7
	 */
	public void delete(Long id,Integer type,Long itemid,Map<String, Object> result)
			throws Exception {
		workCommentMapper.deleteById(id);
		if(type==1){
			workMapper.addCommentNum(itemid,-1);//减去1
		}else if(type==2){
			lyricsMapper.addLrycCommentNum(itemid,-1);//减去1
		}
		result.put(YcContext.CODE, 200);
		result.put(YcContext.MESSAGE, YcContext.EMPTY_STRING);
		result.put(YcContext.DATA, YtConstant.SYS_SUCCSS_MSG);
	}
	
}
