/**
 * Project Name:YCApiServer-Api
 * File Name:AccompanimentService.java
 * Package Name:com.yc.music.service.service103
 * Date:2016年5月12日下午3:25:24
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
import com.yc.music.mapper.cache.HotTempCacheMapper;
import com.yc.music.model.accompaniment.TempHotVo;

/**
 * 伴奏service
 * ClassName: AccompanimentService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月12日 下午3:25:24 <br/>
 *
 * @author panguixiang
 * @version 
 */
@Service
public class AccompanimentService {

	@Autowired
	private HotTempCacheMapper hotTempCacheMapper;
	
	@Value("${Pic_QiLiu}")
	private String pIC_QiLiu;
	
	@Value("${Audio_QiLiu}")
	private String audio_QiLiu;
	
	
	/**
	 * 
	 * commentList:(伴奏列表-作曲选择伴奏). <br/> 
	 *
	 * @author panguixiang
	 * @param title 伴奏名称标题
	 * @param page
	 * @param type 1=最新伴奏列表  2=最热伴奏列表
	 * @param result  
	 * @throws Exception
	 * @since JDK 1.7
	 */
	public void commentList(String title, Integer page,Integer type, Map<String, Object> result) throws Exception {
		result.put(YcContext.CODE, 200);
		result.put(YcContext.MESSAGE, YcContext.EMPTY_STRING);
		int start = 0, size = 20;
		if (page !=null && page > 1) {
			start = (page - 1) * 20;
		}
		if(type==null || type==0) {
			type=1;
		}
		List<TempHotVo> list = null;
		if(type==1) {//最新
			list = hotTempCacheMapper.newTempHotListPage(title, start, size);
		} else if(type==2) {//最热
			list = hotTempCacheMapper.redTempHotListPage(title, start, size);
		}
		if(list!=null) {
			for(TempHotVo vo:list) {
				vo.setPic(RoomUtil.jointDomain(vo.getPic(),pIC_QiLiu));
				vo.setMp3(RoomUtil.jointDomain(vo.getMp3(),audio_QiLiu));
			}
		}
		result.put(YcContext.DATA, list);
	}
	
}
