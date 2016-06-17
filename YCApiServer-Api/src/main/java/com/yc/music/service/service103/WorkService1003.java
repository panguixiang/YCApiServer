/**
 * Project Name:YCApiServer-Api
 * File Name:WorkService.java
 * Package Name:com.yc.music.service.service103
 * Date:2016年5月5日下午1:36:59
 * Copyright (c) 2016 
 *
 */
package com.yc.music.service.service103;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.yc.music.common.context.YcContext;
import com.yc.music.common.util.RoomUtil;
import com.yc.music.context.AppResultConstant;
import com.yc.music.context.YtConstant;
import com.yc.music.mapper.cache.WorkFovCacheMapper;
import com.yc.music.mapper.cache.HtmlConfigCacheMapper;
import com.yc.music.mapper.cache.MusicZanCacheMapper;
import com.yc.music.mapper.cache.OrderConfigCacheMapper;
import com.yc.music.mapper.cache.ReCommedSongCacheMapper;
import com.yc.music.mapper.cache.UserCacheMapper;
import com.yc.music.mapper.cache.WorkCacheMapper;
import com.yc.music.mapper.cache.WorkListCacheMapper;
import com.yc.music.mapper.cache.WorkTuiJianCacheMapper;
import com.yc.music.mapper.cache.YueShuoCacheMapper;
import com.yc.music.mapper.dao.WorkFovMapper;
import com.yc.music.mapper.dao.WorkMapper;
import com.yc.music.mapper.dao.WorkZanMapper;
import com.yc.music.model.htmlconfig.HtmlConfig;
import com.yc.music.model.musRecomSongs.RecommedSong;
import com.yc.music.model.musicWork.WorkOpenDetail;
import com.yc.music.model.musicWorkList.MusicWorkListVo;
import com.yc.music.model.musicuser.MusicUserVo;
import com.yc.music.model.orderConfig.OrderConfig;

/**
 * 歌曲處理service
 * ClassName: WorkService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月5日 下午1:36:59 <br/>
 *
 * @author panguixiang
 * @version 
 */
@Service
public class WorkService1003 {

	@Value("${Audio_QiLiu}")
	private String audio_QiLiu;
	
	@Autowired
	private WorkListCacheMapper workListCacheMapper;
	
	@Autowired
	private ReCommedSongCacheMapper reCommedSongCacheMapper;
	
	@Autowired
	private WorkCacheMapper workCacheMapper;
	
	@Autowired
	private HtmlConfigCacheMapper htmlConfigCacheMapper;
	
	@Value("${Pic_QiLiu}")
	private String pIC_QiLiu;
	
	@Autowired
	private WorkFovMapper workFovMapper;
	
	@Autowired
	private WorkFovCacheMapper fovCacheMapper;
	
	@Autowired
	private WorkZanMapper workZanMapper;
	
	@Autowired
	private WorkTuiJianCacheMapper wTuiJianCacheMapper;
	
	@Autowired
	private WorkListCacheMapper wListCacheMapper;
	
	@Autowired
	private YueShuoCacheMapper yueShuoCacheMapper;
	
	@Autowired
	private WorkMapper workMapper;
	
	@Autowired
	private OrderConfigCacheMapper orderConfigMapper;
	
	@Autowired
	private MusicZanCacheMapper musicZanCacheMapper;
	
	@Autowired
	private UserCacheMapper userCacheMapper;
	
	/**
	 * 
	 * songList:(获得歌单列表). <br/> 
	 *
	 * @author panguixiang
	 * @param gedanId
	 * @param page
	 * @param result
	 * @return
	 * @since JDK 1.7
	 */
	public Map<String,Object> songList(Integer page,Map<String,Object> result) {
		int start=0,size=12;
		if(page!=null && page>1) {
			start=(page-1)*size;
		}
		List<RecommedSong> recommedSongList = reCommedSongCacheMapper.recommedSongPage(null,1,start,size);//获得歌单信息
		if(recommedSongList!=null){
			for(RecommedSong obj : recommedSongList) {
				obj.setPic(RoomUtil.jointDomain(obj.getPic(),pIC_QiLiu));
			}
		}
		result.put(YcContext.CODE, 200);
		result.put(YcContext.MESSAGE, YcContext.EMPTY_STRING);
		result.put(YcContext.DATA,recommedSongList);
		return result;
	}
	
	/**
	 * 
	 * songDetail:(获得歌单详情). <br/> 
	 *
	 * @author panguixiang
	 * @param gedanId
	 * @param page
	 * @param result
	 * @return
	 * @since JDK 1.7
	 */
	public Map<String,Object> songDetail(Long gedanId,Integer page,Map<String,Object> result) {
		
		RecommedSong recommedSong = reCommedSongCacheMapper.getRecommedSong(gedanId);//获得歌单信息
		if(recommedSong==null) {
			result.put(YcContext.CODE, 400);
			result.put(YcContext.MESSAGE, YtConstant.Songlist_IS_NOT_DEFAULD);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			return result;
		}
		recommedSong.setPic(RoomUtil.jointDomain(recommedSong.getPic(),pIC_QiLiu));
		int start=0,size=20;
		if(page!=null && page>1) {
			start=(page-1)*20;
		}
		List<MusicWorkListVo> workList = workListCacheMapper.getWorkListPage(gedanId, 1, start, size);//分页查询歌单歌曲列表
		MusicUserVo uservo = null;
		if(workList!=null){
			for(MusicWorkListVo obj : workList) {
				obj.setPlayurl(RoomUtil.jointDomain(obj.getPlayurl(),audio_QiLiu));
				uservo=userCacheMapper.getCacheUservo(obj.getUid());
				obj.setAuthor(uservo.getNickname());
			}
		}
		int workCount = workListCacheMapper.getWorkListCount(gedanId, 1);//获得此歌单对应的歌曲数量
		Map<String,Object> dataMap = new HashMap<String,Object>();
		dataMap.put(AppResultConstant.workCount, workCount);
		dataMap.put(AppResultConstant.recommedSong, recommedSong);
		dataMap.put(AppResultConstant.workList, workList);
		result.put(YcContext.CODE, 200);
		result.put(YcContext.MESSAGE, YcContext.EMPTY_STRING);
		result.put(YcContext.DATA,dataMap);
		return result;
	}
	
	/**
	 * 
	 * getMusicDetail:(播放歌曲). <br/> 
	 *
	 * @author panguixiang
	 * @param musicId   当前需要播放的歌曲id
	 * @param openmodel 播放模式  1=顺序播放，2=随机播放，3=单曲循环
	 * @param uid
	 * @param gedanid
	 * @param come
	 *  播放推荐歌曲列表=tuijian

		播放歌单歌曲列表=gedan 并需要提供歌单id
		
		播放最新作品里的歌曲列表=zuixin
		
		播放乐说歌曲列表=yueshuo
		
		播放热门歌曲列表 分两种情况=(red,allred)
		
		播放最新歌曲列表 分两种情况=(new,allnew)
		
		播放主页歌曲列表=homepage 需要提供uid
		
		播放我的收藏歌曲列表=myfov
		
		播放我的点赞歌曲列表 =myzan
		
		其他播放都为全部歌曲顺序播放
	 * @param result
	 * @return
	 * @since JDK 1.7
	 */
	public Map<String,Object> getMusicDetail(Long musicId,Integer openmodel,Long uid,
			Long gedanid,String come,Map<String,Object> result) {
		
		WorkOpenDetail music = workCacheMapper.getWorOpenDetailById(musicId);
		if(music==null) {
			result.put(YcContext.CODE, 400);
			result.put(YcContext.MESSAGE, YtConstant.WORK_IS_NOT_DEFALD);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			return result;
		}
		HtmlConfig config = htmlConfigCacheMapper.getHtmlConfig(YtConstant.musicShare);//歌曲分享页
		if(config!=null) {
			music.setShareurl(config.getUrl());
		}
		if(StringUtils.isNotBlank(music.getHotmp3())) {
			music.setHotmp3(RoomUtil.jointDomain(music.getHotmp3(),audio_QiLiu));
		}
		music.setCome(come);
		music.setPic(RoomUtil.jointDomain(music.getPic(),pIC_QiLiu));
		music.setPlayurl(RoomUtil.jointDomain(music.getPlayurl(),audio_QiLiu));
		music.setHeadurl(RoomUtil.jointDomain(music.getHeadurl(),pIC_QiLiu));
		/**
		 * 判断此用户是否对此歌曲点赞，收藏过
		 */
		if(uid!=null) {
			music.setIscollect(workFovMapper.getWorkFovCountByUidAndWId(music.getItemid(), uid,1));//是否已收藏 不缓存   1=歌曲，2=歌词
			music.setIsZan(workZanMapper.getMusicZanCountByUidAndWId(music.getItemid(), uid,1));//是否已赞 不缓存
		}
		if(openmodel!=null && openmodel==3){//根据播放模式和音乐种类设置上一首，下一首歌曲
			music.setNext(music.getItemid());
			music.setPrev(music.getItemid());
		} else {
			getNextAndPreMusic(music,openmodel,gedanid,come,uid);
		}
		result.put(YcContext.CODE, 200);
		result.put(YcContext.MESSAGE, YcContext.EMPTY_STRING);
		result.put(YcContext.DATA,music);
		workMapper.addOneLookNum(musicId);//每次请求数据成功播放量都添加1
		return result;
	}
	/**
	 * 
	 * getNextAndPreMusic:(获得上一曲，下一曲). <br/> 
	 *
	 * @author panguixiang
	 * @param music
	 * @param model 播放模式  1=顺序播放，2=随机播放，3=单曲循环
	 * @param gedanid
	 * @param come
	 *  播放热门歌曲列表 (allred)
		
		播放最新歌曲列表 (allnew)
		
		播放主页歌曲列表=homepage 需要提供uid
		
		播放我的收藏歌曲列表=myfov 需要提供uid
		
		播放我的点赞歌曲列表 =myzan 需要提供uid
		
		其他播放都为全部歌曲顺序播放
		
	 * @since JDK 1.7
	 */
	private void getNextAndPreMusic(WorkOpenDetail music,Integer model,Long gedanid,String come,Long uid) {
		Map<String,Integer> map = null;
		Map<String,Integer> map2 = null;
		if(StringUtils.equals(come, AppResultConstant.WorkOpenModelEnum.tuijian.toString())) {
			map=wTuiJianCacheMapper.getMusicNext(model, music.getItemid());
			map2=wTuiJianCacheMapper.getMusicPrev(model, music.getItemid());
		}
		else if(StringUtils.equals(come, AppResultConstant.WorkOpenModelEnum.gedan.toString()) && gedanid!=null) {
			map=wListCacheMapper.getMusicNext(model, gedanid, music.getItemid());
			map2=wListCacheMapper.getMusicPrev(model, gedanid, music.getItemid());
		}
		else if(StringUtils.equals(come, AppResultConstant.WorkOpenModelEnum.yueshuo.toString())) {
			map=yueShuoCacheMapper.getMusicNext(model, music.getItemid());
			map2=yueShuoCacheMapper.getMusicPrev(model, music.getItemid());
		}
		else if(StringUtils.equals(come, AppResultConstant.WorkOpenModelEnum.red.toString())) {
			OrderConfig config = orderConfigMapper.getOrderConfigByKey(YtConstant.MUSIC_ORDER_RED_KEY);
			map=workCacheMapper.nextOrderMusic(model,config!=null?config.getOrdersql():YtConstant.DEFAULT_ORDER_RED,music.getItemid());
			map2=workCacheMapper.prevOrderMusic(model,config!=null?config.getOrdersql():YtConstant.DEFAULT_ORDER_RED, music.getItemid());
		}
		else if(StringUtils.equals(come, AppResultConstant.WorkOpenModelEnum.news.toString())) {
			OrderConfig config = orderConfigMapper.getOrderConfigByKey(YtConstant.MUSIC_ORDER_NEW_KEY);
			map=workCacheMapper.nextOrderMusic(model,config!=null?config.getOrdersql():YtConstant.DEFAULT_ORDER_NEW,music.getItemid());
			map2=workCacheMapper.prevOrderMusic(model,config!=null?config.getOrdersql():YtConstant.DEFAULT_ORDER_NEW, music.getItemid());
		}
		else if(StringUtils.equals(come, AppResultConstant.WorkOpenModelEnum.homepage.toString()) && uid!=null) {
			map=fovCacheMapper.nextMusic(model,uid, music.getItemid(),1);
			map2=fovCacheMapper.prevMusic(model, uid, music.getItemid(),1);
		}
		else if(StringUtils.equals(come, AppResultConstant.WorkOpenModelEnum.myfov.toString()) && uid!=null) {
			map=fovCacheMapper.nextMusic(model,uid, music.getItemid(),1);
			map2=fovCacheMapper.prevMusic(model, uid, music.getItemid(),1);
		}
		else if(StringUtils.equals(come, AppResultConstant.WorkOpenModelEnum.myzan.toString()) && uid!=null) {
			map=musicZanCacheMapper.nextMusic(model,uid, music.getItemid(),1);
			map2=musicZanCacheMapper.prevMusic(model, uid, music.getItemid(),1);
		} else {
			map=workCacheMapper.nextMusic(model,music.getItemid());
			map2=workCacheMapper.prevMusic(model,music.getItemid());
		}
		if(map!=null) {
			music.setNext(map.get(YtConstant.id_key));
		}
		if(map2!=null) {
			music.setPrev(map2.get(YtConstant.id_key));
		}
	}
	
	
	/**
	 * 
	 * getMusicById:(歌曲详情-分享页用). <br/> 
	 *
	 * @author panguixiang
	 * @param musicId
	 * @return
	 * @since JDK 1.7
	 */
	public WorkOpenDetail getMusicById(Long musicId) throws Exception{
		
		WorkOpenDetail music = workCacheMapper.getWorOpenDetailById(musicId);
		if(music==null) {
			return music;
		}
		if(StringUtils.isNotBlank(music.getHotmp3())) {
			music.setHotmp3(RoomUtil.jointDomain(music.getHotmp3(),audio_QiLiu));
		}
		music.setPic(RoomUtil.jointDomain(music.getPic(),pIC_QiLiu));
		music.setPlayurl(RoomUtil.jointDomain(music.getPlayurl(),audio_QiLiu));
		music.setHeadurl(RoomUtil.jointDomain(music.getHeadurl(),pIC_QiLiu));
		return music;
	}
}
