/**
 * Project Name:YCApiServer-Api
 * File Name:YueShuoService.java
 * Package Name:com.yc.music.service.service103
 * Date:2016年5月20日上午11:36:04
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
import com.yc.music.context.YtConstant;
import com.yc.music.mapper.cache.YueShuoCacheMapper;
import com.yc.music.model.musicYueShuo.MuscicYueSVo;

/**
 * ClassName: YueShuoService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月20日 上午11:36:04 <br/>
 *
 * @author panguixiang
 * @version
 */
@Service
public class YueShuoService {

	@Autowired
	private YueShuoCacheMapper yueShuoCacheMapper;

	@Value("${Pic_QiLiu}")
	private String pIC_QiLiu;
	
	@Value("${Audio_QiLiu}")
	private String audio_QiLiu;
	
	/**
	 * 
	 * yueshuoListPage:(乐说列表). <br/> 
	 * @author panguixiang
	 * @param page
	 * @param result
	 * @return
	 * @throws Exception
	 * @since JDK 1.7
	 */
	public Map<String, Object> yueshuoListPage(Integer page, Map<String, Object> result) throws Exception {
		int start = 0, size = 10;
		if (page != null && page > 1) {
			start = (page - 1) * 10;
		}
		// 乐说列表
		List<MuscicYueSVo> yueshuoList = yueShuoCacheMapper.getYueShuoPages(2, null, 1, start, size);
		if(yueshuoList!=null){
			for(MuscicYueSVo vo : yueshuoList) {
				vo.setPic(RoomUtil.jointDomain(vo.getPic(),pIC_QiLiu));
				if(vo.getType()==1) {//1=mp3,2=web，wap页面
					vo.setUrl(RoomUtil.jointDomain(vo.getUrl(),audio_QiLiu));
				}
			}
		}
		result.put(YcContext.CODE, 200);
		result.put(YcContext.MESSAGE, YtConstant.SYS_SUCCSS_MSG);
		result.put(YcContext.DATA, yueshuoList);
		return result;
	}
	
}
