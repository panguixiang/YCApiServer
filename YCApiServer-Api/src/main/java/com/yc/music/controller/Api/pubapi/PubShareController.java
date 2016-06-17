package com.yc.music.controller.Api.pubapi;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.music.model.musicLyrics.MusicLyrics;
import com.yc.music.model.musicWork.WorkOpenDetail;
import com.yc.music.service.service103.LyricsService1003;
import com.yc.music.service.service103.WorkService1003;

/**
 * 无需加密，解密 和token的接口
 * ClassName: PubMusicController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月3日 下午4:24:46 <br/>
 *
 * @author panguixiang
 * @version
 */
@Controller
@RequestMapping("/pub/share")
public class PubShareController {

	private static Logger logger = Logger.getLogger(PubShareController.class);
	
	@Autowired
	private WorkService1003 workService1003;
	
	@Autowired
	private LyricsService1003 lyricsService1003;
	
	/**
	 * 
	 * music:(根据歌曲id获得歌曲详情，无需加密，解密和token验证). <br/> 
	 *
	 * @author panguixiang
	 * @param id
	 * @return
	 * @since JDK 1.7
	 */
	@ResponseBody
	@RequestMapping(value="music", method = RequestMethod.GET, produces = "application/json")
	public Map<String,Object> music(@RequestParam("id") Long id,HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "http://html.yinchao.cn");
		Map<String,Object> resultMap  = new HashMap<String,Object>();
		WorkOpenDetail music = null;
		try {
			music = workService1003.getMusicById(id);
		} catch (Exception e) {
			logger.error(e);
		}
		resultMap.put("music", music);
		return resultMap;
	}
	
	/**
	 * 
	 * lrycis:(根据歌词id获得歌曲详情，无需加密，解密和token验证). <br/> 
	 *
	 * @author panguixiang
	 * @param id
	 * @return
	 * @since JDK 1.7
	 */
	@ResponseBody
	@RequestMapping(value="lrycis", method = RequestMethod.GET, produces = "application/json")
	public Map<String,Object> lrycis(@RequestParam("id") Long id,HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "http://html.yinchao.cn");
		Map<String,Object> resultMap  = new HashMap<String,Object>();
		MusicLyrics lrycis = null;
		try {
			lrycis = lyricsService1003.getShareLyricById(id);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		resultMap.put("lrycis", lrycis);
		return resultMap;
	}
	
}
