/**
 * Project Name:YCApiServer-Api
 * File Name:TuningMusicService.java
 * Package Name:com.yc.music.service.service103
 * Date:2016年5月18日下午3:04:13
 * Copyright (c) 2016 
 *
 */
package com.yc.music.service.service103;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.yc.music.common.context.YcContext;
import com.yc.music.common.util.AudioUtil;
import com.yc.music.common.util.BindingResultUtil;
import com.yc.music.common.util.QiNiuUpload;
import com.yc.music.common.util.RoomUtil;
import com.yc.music.context.YtConstant;
import com.yc.music.mapper.cache.HotTempCacheMapper;
import com.yc.music.mapper.cache.HtmlConfigCacheMapper;
import com.yc.music.mapper.dao.HotTempMapper;
import com.yc.music.mapper.dao.TunningLogMapper;
import com.yc.music.mapper.dao.WorkMapper;
import com.yc.music.model.ShareModel;
import com.yc.music.model.accompaniment.HotVo;
import com.yc.music.model.htmlconfig.HtmlConfig;
import com.yc.music.model.musicWork.SaveMusic;
import com.yc.music.model.tunning.TunningLog;
import com.yc.music.model.tunningmusic.TunningMusic;

/**
 * 调音，合成 service
 * ClassName: TuningMusicService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月18日 下午3:04:13 <br/>
 *
 * @author panguixiang
 * @version 
 */
@Service
public class TuningMusicService {
	
	@Autowired
	private HotTempCacheMapper hotTempCacheMapper;
	
	@Autowired
	private HotTempMapper hotTempMapper;
	
	@Autowired
	private WorkMapper workMapper;
	
	@Autowired
	private TunningLogMapper tunningLogMapper;
	
	@Value("${SERVER_FILE_PATH}")
	private String SERVER_FILE_PATH;
	
	@Value("${audio_buckname}")
	private String audio_buckname;
	
	@Value("${linux_ffmpeg}")
	private String linux_ffmpeg;
	
	@Autowired
	private HtmlConfigCacheMapper htmlConfigCacheMapper;

	public Map<String,Object> tunningMusic(Map<String,Object> result,
			TunningMusic tunningMusic,BindingResult binding) throws Exception{
		Map<String,Object> tunningUrlMap = new HashMap<String,Object>();
		String valiterMsg = BindingResultUtil.getBindErrorMsg(binding);
		if(StringUtils.isNotBlank(valiterMsg)) {
			result.put(YcContext.CODE, 400);
			result.put(YcContext.MESSAGE, valiterMsg);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			return result;
		}
		tunningUrlMap.put(YtConstant.oldPath, tunningMusic.getMusicurl());//原音频文件mp3地址
		HotVo hotVo = hotTempCacheMapper.getHoVoById(tunningMusic.getHotid());
		if(hotVo==null || StringUtils.isBlank((hotVo.getMp3()).trim())) {
			result.put(YcContext.CODE, 400);
			result.put(YcContext.MESSAGE, YtConstant.HOT_TEMP_NULL);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			return result;
		}
		String outmp3path = doTunning(tunningMusic,hotVo.getMp3(),tunningMusic.getUid());
		tunningUrlMap.put(YtConstant.newPath, outmp3path);//合成，调音后的mp3地址
		result.put(YcContext.CODE, 200);
		result.put(YcContext.MESSAGE,  YcContext.EMPTY_STRING);
		result.put(YcContext.DATA,tunningUrlMap);
		return result;
	}
	
	/**
	 * 
	 * saveMusic:(发布,修改 歌曲). <br/> 
	 *
	 * @author panguixiang
	 * @param result
	 * @param saveMusic
	 * @param binding
	 * @return
	 * @since JDK 1.7
	 */
	public Map<String,Object> optMusic(Map<String,Object> result, SaveMusic saveMusic,
			BindingResult binding) throws Exception{
		String valiterMsg = BindingResultUtil.getBindErrorMsg(binding);
		if(StringUtils.isNotBlank(valiterMsg)) {
			result.put(YcContext.CODE, 400);
			result.put(YcContext.MESSAGE, valiterMsg);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			return result;
		}
		HotVo hotVo = hotTempCacheMapper.getHoVoById(saveMusic.getHotid());
		if(hotVo==null || StringUtils.isBlank((hotVo.getMp3()).trim())) {
			result.put(YcContext.CODE, 400);
			result.put(YcContext.MESSAGE, YtConstant.HOT_TEMP_NULL);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			return result;
		}
		String mp3path=saveMusic.getMp3();
		mp3path=SERVER_FILE_PATH.concat(mp3path);
		saveMusic.setMp3times(AudioUtil.getAudioTime(mp3path));
		String mp3=saveMusic.getMp3();
		if(mp3.charAt(0)==YcContext.Slashchar){//先去掉'/'
			mp3=mp3.replaceFirst(YcContext.Slash, YcContext.EMPTY_STRING);
		}
		if((saveMusic.getPic()).charAt(0)!=YcContext.Slashchar) {
			saveMusic.setPic(YcContext.Slash.concat(saveMusic.getPic()));
		}
		QiNiuUpload.uploadQiNiu(mp3path, audio_buckname, mp3);
		//上传七牛后，需要持久化到数据库的路径需要'/'
		if(mp3.charAt(0)!=YcContext.Slashchar) {
			saveMusic.setMp3(YcContext.Slash.concat(mp3));
		}
		if(saveMusic.getId()==null) {
			workMapper.saveMusic(saveMusic);
			if(saveMusic.getHotid()!=null) {
				hotTempMapper.addHotUseNum(saveMusic.getHotid());
			}
		} else {
			workMapper.updateMusic(saveMusic);
		}
		
		HtmlConfig config = htmlConfigCacheMapper.getHtmlConfig(YtConstant.musicShare);//歌曲分享页
		ShareModel share = new ShareModel();
		if(config!=null) {
			share.setShareurl(config.getUrl());
			share.setItemid(saveMusic.getId());
		}
		result.put(YcContext.CODE, 200);
		result.put(YcContext.MESSAGE, YtConstant.SYS_SUCCSS_MSG);
		result.put(YcContext.DATA,share);
		return result;
	}
	
	/**
	 * 调音操作
	 * doTunning:(这里用一句话描述这个方法的作用). <br/> 
	 * @author panguixiang
	 * @param tunningMusic
	 * @param hotPath  伴奏的绝对路径
	 * @return
	 * @throws Exception
	 * @since JDK 1.7
	 */
	private String doTunning(TunningMusic tunningMusic, String hotPath,long uid) throws Exception{

		String musicUrl = tunningMusic.getMusicurl();
		musicUrl=RoomUtil.replaceAllDomain(musicUrl);//去掉域名
		String musicPaht = (musicUrl.replace(".mp3", "")).replace(".wav", "");
	
		String outMusicUrl = musicPaht.concat("_out.mp3");//合成最终的文件
		
		if(tunningMusic.getUseheadset()==1) {//戴耳机，需要合成操作
			
			StringBuffer buffer = new StringBuffer();
			buffer.append(linux_ffmpeg).append(" ").append(SERVER_FILE_PATH).
			append(musicUrl).append(" ").append(SERVER_FILE_PATH).append(hotPath).append(" ").
			append(SERVER_FILE_PATH).append(outMusicUrl);
			
			AudioUtil.doAudioTuning(buffer.toString());
			/**
			 * 持久化合成记录到数据库表
			 */
			TunningLog log = new TunningLog();//将本次合成操作记录放入调音日志表里
			log.setUid(uid);
			log.setBasemusic(musicUrl);
			log.setHotempmusic(hotPath);
			log.setTunningmusic(outMusicUrl);
			tunningLogMapper.saveTunningLog(log);
			return outMusicUrl;
		} else {
			return musicUrl;
		}
	}
}
