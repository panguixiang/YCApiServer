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
import com.yc.music.mapper.cache.HtmlConfigCacheMapper;
import com.yc.music.mapper.cache.LyricsCatCacheMapper;
import com.yc.music.mapper.cache.UserCacheMapper;
import com.yc.music.mapper.dao.LyricsMapper;
import com.yc.music.mapper.dao.WorkFovMapper;
import com.yc.music.mapper.dao.WorkZanMapper;
import com.yc.music.model.ShareModel;
import com.yc.music.model.htmlconfig.HtmlConfig;
import com.yc.music.model.lyricscat.LyricsCat;
import com.yc.music.model.musicLyrics.LyricImp;
import com.yc.music.model.musicLyrics.MusicLyrics;
import com.yc.music.model.musicLyrics.SaveLyrics;
import com.yc.music.model.musicuser.MusicUserVo;

/**
 * 歌词 service ClassName: LyricsService1003 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月5日 下午4:42:48 <br/>
 *
 * @author panguixiang
 * @version
 */
@Service
public class LyricsService1003 {

	@Autowired
	private LyricsMapper lyricsMapper;
	
	@Autowired
	private WorkZanMapper workZanMapper;

	@Autowired
	private WorkFovMapper workFovMapper;

	@Autowired
	private LyricsCatCacheMapper lyricsCatCacheMapper;

	@Autowired
	private HtmlConfigCacheMapper htmlConfigCacheMapper;
	
	@Autowired
	private UserCacheMapper userCacheMapper;
	
	@Value("${Pic_QiLiu}")
	private String pIC_QiLiu;

	/**
	 * 
	 * getMusicLyricsById:(查看歌词). <br/>
	 *
	 * @author panguixiang
	 * @param lyricsid
	 * @param result
	 * @return
	 * @since JDK 1.7
	 */
	public Map<String, Object> getMusicLyricsById(Long lyricsid, Long uid, Map<String, Object> result) {
		MusicUserVo user=null;
		MusicLyrics lyrics = lyricsMapper.getMusicLyricsById(lyricsid);// 根据歌词id获取歌词信息
		if (lyrics != null) {
			lyrics.setPic(RoomUtil.jointDomain(lyrics.getPic(),pIC_QiLiu));
			if (uid != null) {
				lyrics.setIsCollect(workFovMapper.getWorkFovCountByUidAndWId(lyricsid, uid, 2));// 是否收藏
																								// 1=歌曲，2=歌词
				lyrics.setIsZan(workZanMapper.getMusicZanCountByUidAndWId(lyricsid, uid, 2));// 是否已赞
			}
			user=userCacheMapper.getCacheUservo(lyrics.getUid());
			if(user!=null) {
				lyrics.setAuthor(user.getNickname());
				lyrics.setHeadurl(RoomUtil.jointDomain(user.getHeadurl(),pIC_QiLiu));
			}
		}
		HtmlConfig config = htmlConfigCacheMapper.getHtmlConfig(YtConstant.lyricsShare);//歌词分享页
		if(config!=null) {
			lyrics.setShareurl(config.getUrl());
		}
		result.put(YcContext.CODE, 200);
		result.put(YcContext.MESSAGE, YcContext.EMPTY_STRING);
		result.put(YcContext.DATA, lyrics);
		return result;
	}

	/**
	 * 
	 * getLyricImpList:(获取用户歌词列表). <br/>
	 *
	 * @author panguixiang
	 * @param uid
	 * @param page
	 * @param result
	 * @return
	 * @since JDK 1.7
	 */
	public Map<String, Object> getLyricImpList(Long uid, Integer page, Map<String, Object> result) throws Exception {

		int start = 0, size = 15;
		if (page != null && page > 1) {
			start = (page - 1) * 15;
		}
		MusicUserVo user=userCacheMapper.getCacheUservo(uid);
		if(user==null){
			result.put(YcContext.CODE, 400);
			result.put(YcContext.MESSAGE, YtConstant.USER_IS_NOT_EXIST);
			result.put(YcContext.DATA, YcContext.EMPTY_STRING);
			return result;
		}
		List<LyricImp> lyricImpList = lyricsMapper.getLyricImpList(uid, start, size);// 根据歌词uid获取歌词信息
		if(lyricImpList!=null){
			for (LyricImp imp : lyricImpList) {
				imp.setPic(RoomUtil.jointDomain(imp.getPic(),pIC_QiLiu));
				imp.setAuthor(user.getNickname());
			}
		}
		result.put(YcContext.CODE, 200);
		result.put(YcContext.MESSAGE, YcContext.EMPTY_STRING);
		result.put(YcContext.DATA, lyricImpList);
		return result;
	}

	/**
	 * 
	 * getLyricsCats:(获得歌词库). <br/>
	 *
	 * @author panguixiang
	 * @param keywords
	 * @param result
	 * @return
	 * @throws Exception
	 * @since JDK 1.7
	 */
	public Map<String, Object> getLyricsCats(String keywords, Map<String, Object> result) throws Exception {
		List<LyricsCat> list = lyricsCatCacheMapper.getLyricsCatList(keywords);
		result.put(YcContext.CODE, 200);
		result.put(YcContext.MESSAGE, YcContext.EMPTY_STRING);
		result.put(YcContext.DATA, list);
		return result;
	}
	/**
	 * 
	 * optLyrics:(保存，修改  歌词). <br/> 
	 *
	 * @author panguixiang
	 * @param obj
	 * @param binding
	 * @param result
	 * @return
	 * @throws Exception
	 * @since JDK 1.7
	 */
	public Map<String,Object> optLyrics(SaveLyrics obj,BindingResult binding, 
			Map<String, Object> result)  throws Exception{
		String valiterMsg = BindingResultUtil.getBindErrorMsg(binding);
		if(StringUtils.isNotBlank(valiterMsg)) {
			result.put(YcContext.CODE, 400);
			result.put(YcContext.MESSAGE, valiterMsg);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			return result;
		}
			obj.setPic(RoomUtil.jointDomain(obj.getPic(),pIC_QiLiu));
		if(obj.getId()!=null) {
			lyricsMapper.updateLyrics(obj);
		} else {
			lyricsMapper.saveLyrics(obj);
		}
		HtmlConfig config = htmlConfigCacheMapper.getHtmlConfig(YtConstant.lyricsShare);//歌词分享页
		ShareModel share = new ShareModel();
		if(config!=null) {
			share.setShareurl(config.getUrl());
			share.setItemid(obj.getId());
		}
		result.put(YcContext.CODE, 200);
		result.put(YcContext.MESSAGE, YtConstant.SYS_SUCCSS_MSG);
		result.put(YcContext.DATA, share);
		return result;
	}
	
	/**
	 * 
	 * getShareLyricById:(根据id获得歌词详情，分享页用). <br/> 
	 *
	 * @author panguixiang
	 * @param lyricsid
	 * @return
	 * @since JDK 1.7
	 */
	public MusicLyrics getShareLyricById(Long lyricsid)  throws Exception{
		MusicUserVo user=null;
		MusicLyrics lyrics = lyricsMapper.getShareLyricById(lyricsid);// 根据歌词id获取歌词信息
		if(lyrics==null){
			return lyrics;
		}
		lyrics.setPic(RoomUtil.jointDomain(lyrics.getPic(),pIC_QiLiu));
		user=userCacheMapper.getCacheUservo(lyrics.getUid());
		if(user!=null) {
			lyrics.setAuthor(user.getNickname());
			lyrics.setHeadurl(RoomUtil.jointDomain(user.getHeadurl(),pIC_QiLiu));
		}
		return lyrics;
	}
}
