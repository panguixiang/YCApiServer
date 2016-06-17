/**
 * Project Name:YCApiServer-Api
 * File Name:FindService.java
 * Package Name:com.yc.music.service.service103
 * Date:2016年5月9日上午10:43:17
 * Copyright (c) 2016 
 *
 */
package com.yc.music.service.service103;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.yc.music.common.context.YcContext;
import com.yc.music.common.util.RoomUtil;
import com.yc.music.context.AppResultConstant;
import com.yc.music.context.YtConstant;
import com.yc.music.mapper.cache.EventCacheMapper;
import com.yc.music.mapper.cache.LyricsCacheMapper;
import com.yc.music.mapper.cache.OrderConfigCacheMapper;
import com.yc.music.mapper.cache.WorkCacheMapper;
import com.yc.music.model.musicEvent.MusicEvent;
import com.yc.music.model.musicLyrics.Lyrics;
import com.yc.music.model.musicLyrics.LyricsRank;
import com.yc.music.model.musicWork.MusicWork;
import com.yc.music.model.musicWork.MusicWorkVo;
import com.yc.music.model.orderConfig.OrderConfig;

/**
 * ClassName: FindService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月9日 上午10:43:17 <br/>
 *
 * @author panguixiang
 * @version
 */
@Service
public class FindService {

	@Autowired
	private OrderConfigCacheMapper orderConfigMapper;

	@Autowired
	private WorkCacheMapper workCacheMapper;

	@Autowired
	private EventCacheMapper eventCacheMapper;

	@Autowired
	private LyricsCacheMapper lyricsCacheMapper;

	@Value("${Pic_QiLiu}")
	private String pIC_QiLiu;

	/**
	 * 
	 * findIndexMusic:(发现首页-歌曲). <br/>
	 *
	 * @author panguixiang
	 * @param name
	 * @param result
	 * @since JDK 1.7
	 */
	public void findIndexMusic(String name, Map<String, Object> result) throws Exception {
		result.put(YcContext.CODE, 200);
		result.put(YcContext.MESSAGE, YcContext.EMPTY_STRING);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		/**
		 * 最热歌曲
		 */
		OrderConfig redConfig = orderConfigMapper.getOrderConfigByKey(YtConstant.MUSIC_ORDER_RED_KEY);
		List<MusicWork> redMusicList = workCacheMapper
				.musicList(redConfig != null ? redConfig.getOrdersql() : YtConstant.DEFAULT_ORDER_RED, name, 0, 6);
		if(redMusicList!=null) {
			for (MusicWork work : redMusicList) {
				work.setPic(RoomUtil.jointDomain(work.getPic(),pIC_QiLiu));
			}
		}
		dataMap.put(AppResultConstant.RED_LIST, redMusicList);
		/**
		 * 最新歌曲
		 */
		OrderConfig newConfig = orderConfigMapper.getOrderConfigByKey(YtConstant.MUSIC_ORDER_NEW_KEY);
		List<MusicWork> newMusicList = workCacheMapper
				.musicList(newConfig != null ? newConfig.getOrdersql() : YtConstant.DEFAULT_ORDER_NEW, name, 0, 6);
		if(newMusicList!=null) {
			for (MusicWork work : newMusicList) {
				work.setPic(RoomUtil.jointDomain(work.getPic(),pIC_QiLiu));
			}
		}
		dataMap.put(AppResultConstant.NEW_LIST, newMusicList);
		result.put(YcContext.DATA, dataMap);
	}
	
	/**
	 * 
	 * 更多歌曲:(发现首页-更多 热门歌曲，最新歌曲). <br/>
	 *
	 * @author panguixiang
	 * @param name
	 * @param result
	 * @param orderType
	 *            1=最新，2=最热
	 * @since JDK 1.7
	 */
	public void moreMusic(String name, Map<String, Object> result, Integer orderType, Integer page) throws Exception {
		result.put(YcContext.CODE, 200);
		result.put(YcContext.MESSAGE, YcContext.EMPTY_STRING);
		int start = 0;
		if (page == null || page < 2) {
			start = 0;
		} else {
			start = (page - 1) * 20;
		}
		List<MusicWorkVo> musicList = null;
		OrderConfig config = null;
		if (orderType == null || orderType < 2) {// 不传递或者1都为查询最新
			config = orderConfigMapper.getOrderConfigByKey(YtConstant.MUSIC_ORDER_NEW_KEY);
			musicList = workCacheMapper
					.musicVoList(config != null ? config.getOrdersql() : YtConstant.DEFAULT_ORDER_NEW, name, start, 20);
		} else {//最热
			config = orderConfigMapper.getOrderConfigByKey(YtConstant.MUSIC_ORDER_RED_KEY);
			musicList = workCacheMapper
					.musicVoList(config != null ? config.getOrdersql() : YtConstant.DEFAULT_ORDER_RED, name, start, 20);
		}
		if(musicList!=null){
			for (MusicWorkVo work : musicList) {
				work.setPic(RoomUtil.jointDomain(work.getPic(),pIC_QiLiu));
			}
		}
		result.put(YcContext.DATA, musicList);
	}

	/**
	 * 
	 * findIndexMusic:(发现首页-歌词). <br/>
	 *
	 * @author panguixiang
	 * @param name
	 * @param result
	 * @since JDK 1.7
	 */
	public void findIndexLyrics(String name, Map<String, Object> result) throws Exception {
		result.put(YcContext.CODE, 200);
		result.put(YcContext.MESSAGE, YcContext.EMPTY_STRING);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		/**
		 * 最热歌词
		 */
		OrderConfig redConfig = orderConfigMapper.getOrderConfigByKey(YtConstant.Lyrics_ORDER_RED_KEY);
		List<Lyrics> redMusicList = lyricsCacheMapper
				.lyricsList(redConfig != null ? redConfig.getOrdersql() : YtConstant.DEFAULT_ORDER_RED, name, 0, 6);
		if(redMusicList!=null){
			for (Lyrics obj : redMusicList) {
				obj.setPic(RoomUtil.jointDomain(obj.getPic(),pIC_QiLiu));
			}
		}
		dataMap.put(AppResultConstant.RED_LIST, redMusicList);
		/**
		 * 最新歌词
		 */
		OrderConfig newConfig = orderConfigMapper.getOrderConfigByKey(YtConstant.Lyrics_ORDER_NEW_KEY);
		List<Lyrics> newMusicList = lyricsCacheMapper
				.lyricsList(newConfig != null ? newConfig.getOrdersql() : YtConstant.DEFAULT_ORDER_updatetime, name, 0, 6);
		if(newMusicList!=null){
			for (Lyrics obj : newMusicList) {
				obj.setPic(RoomUtil.jointDomain(obj.getPic(),pIC_QiLiu));
			}
		}
		dataMap.put(AppResultConstant.NEW_LIST, newMusicList);
		result.put(YcContext.DATA, dataMap);
	}
	
	/**
	 * 
	 * 更多歌曲:(发现首页-更多 热门歌词，最新歌词). <br/>
	 *
	 * @author panguixiang
	 * @param name
	 * @param result
	 * @param orderType
	 *            1=最新，2=最热
	 * @since JDK 1.7
	 */
	public void moreLyrics(String name, Map<String, Object> result, Integer orderType, Integer page) throws Exception {
		result.put(YcContext.CODE, 200);
		result.put(YcContext.MESSAGE, YcContext.EMPTY_STRING);
		int start = 0;
		if (page == null || page < 2) {
			start = 0;
		} else {
			start = (page - 1) * 20;
		}
		List<LyricsRank> lrycisList = null;
		OrderConfig config = null;
		if (orderType == null || orderType < 2) {// 不传递或者1都为查询最新
			config = orderConfigMapper.getOrderConfigByKey(YtConstant.MUSIC_ORDER_NEW_KEY);
			lrycisList = lyricsCacheMapper.lyricsRankList(
					config != null ? config.getOrdersql() : YtConstant.DEFAULT_ORDER_updatetime, name, start, 20);
		} else {
			config = orderConfigMapper.getOrderConfigByKey(YtConstant.MUSIC_ORDER_RED_KEY);
			lrycisList = lyricsCacheMapper.lyricsRankList(
					config != null ? config.getOrdersql() : YtConstant.DEFAULT_ORDER_RED, name, start, 20);
		}
		if(lrycisList!=null){
			for (LyricsRank obj : lrycisList) {
				obj.setPic(RoomUtil.jointDomain(obj.getPic(),pIC_QiLiu));
			}
		}
		result.put(YcContext.DATA, lrycisList);
	}

	
	/**
	 * 
	 * findIndexMusic:(发现首页-活动). <br/>
	 *
	 * @author panguixiang
	 * @param name
	 * @param result
	 * @since JDK 1.7
	 */
	public void findActivList(String name, Map<String, Object> result, Integer page) throws Exception {
		int start = 0;
		if (page == null || page < 2) {
			start = 0;
		} else {
			start = (page - 1) * 20;
		}
		result.put(YcContext.CODE, 200);
		result.put(YcContext.MESSAGE, YcContext.EMPTY_STRING);
		List<MusicEvent> redMusicList = eventCacheMapper.getEventList(name, start, 10);
		if(redMusicList!=null){
			for (MusicEvent event : redMusicList) {
				event.setPic(RoomUtil.jointDomain(event.getPic(),pIC_QiLiu));
			}
		}
		result.put(YcContext.DATA, redMusicList);
	}
	
	
	/**
	 * 
	 * 排行榜:(发现首页-排行榜 歌词 歌曲). <br/>
	 *
	 * @author panguixiang
	 * @param name
	 * @param result
	 * @param modelType
	 *            1=歌曲，2=歌词
	 * @since JDK 1.7
	 */
	public void rankList(String name, Map<String, Object> result, Integer modelType, Integer page) throws Exception {
		result.put(YcContext.CODE, 200);
		result.put(YcContext.MESSAGE, YcContext.EMPTY_STRING);
		int start = 0;
		if (page == null || page < 2) {
			start = 0;
		} else {
			start = (page - 1) * 25;
		}
		OrderConfig config = null;
		if (modelType == null || modelType < 2) {// 歌曲排行榜 （不传递或者1都为查询歌曲排行榜）
			config = orderConfigMapper.getOrderConfigByKey(YtConstant.MUSIC_RANK_ORDER_KEY);
			List<MusicWorkVo> musicList = workCacheMapper
					.musicVoList(config != null ? config.getOrdersql() : YtConstant.DEFAULT_ORDER_RED, name, start, 6);
			if(musicList!=null){
				for (MusicWorkVo work : musicList) {
					work.setPic(RoomUtil.jointDomain(work.getPic(),pIC_QiLiu));
				}
			}
			result.put(YcContext.DATA, musicList);
		} else {// 歌词排行榜
			config = orderConfigMapper.getOrderConfigByKey(YtConstant.Lyrics_RANK_ORDER_KEY);
			List<LyricsRank> lyricsList = lyricsCacheMapper.lyricsRankList(
					config != null ? config.getOrdersql() : YtConstant.DEFAULT_ORDER_RED, name, start, 6);
			if(lyricsList!=null){
				for (LyricsRank obj : lyricsList) {
					obj.setPic(RoomUtil.jointDomain(obj.getPic(),pIC_QiLiu));
				}
			}
			result.put(YcContext.DATA, lyricsList);
		}
	}
}
