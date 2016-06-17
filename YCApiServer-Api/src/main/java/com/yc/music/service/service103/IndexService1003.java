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
import com.yc.music.mapper.cache.AppIndexNewCacheMapper;
import com.yc.music.mapper.cache.BannerMapper;
import com.yc.music.mapper.cache.ReCommedSongCacheMapper;
import com.yc.music.mapper.cache.UserCacheMapper;
import com.yc.music.mapper.cache.WorkTuiJianCacheMapper;
import com.yc.music.mapper.cache.YueShuoCacheMapper;
import com.yc.music.model.musRecomSongs.RecommedSong;
import com.yc.music.model.musicBanner.Banner;
import com.yc.music.model.musicTuijian.MusicTuiJianVo;
import com.yc.music.model.musicYueShuo.MuscicYueSVo;
import com.yc.music.model.musicindex.AppIndexNews;
import com.yc.music.model.musicuser.MusicUserVo;
/**
 * 
  * @ClassName: IndexService
  * @Description: TODO
  * @author Comsys-panguixiang
  * @date 2016年4月7日 下午7:29:17
  *
 */
@Service
public class IndexService1003 {

	@Autowired
	private BannerMapper bannerMapper;
	
	@Autowired
	private WorkTuiJianCacheMapper workTuiJianCacheMapper;
	
	@Autowired
	private ReCommedSongCacheMapper recommedSongCacheMapper;
	
	@Autowired
	private YueShuoCacheMapper yueShuoCacheMapper;
	
	@Autowired
	private UserCacheMapper userCacheMapper;
	
	@Value("${Pic_QiLiu}")
	private String pIC_QiLiu;
	
	@Value("${Audio_QiLiu}")
	private String audio_QiLiu;
	
	@Autowired
	private AppIndexNewCacheMapper appIndexNewCacheMapper;
	
	/**
	 * getIndexApp:(获得app index页面). <br/> 
	 *
	 * @author panguixiang
	 * @param resultMap
	 * @return
	 * @throws Exception
	 * @since JDK 1.7
	 */
	public Map<String,Object> getIndexApp(Map<String,Object> resultMap) throws Exception{
		
		Map<String,Object> dataMap = new HashMap<String,Object>();
		
		//banner数据
		List<Banner> bannerList = bannerMapper.bannerList(2);//是否发布，1=默认不发布，2=发布
		for(Banner obj:bannerList) {
			obj.setPic(RoomUtil.jointDomain(obj.getPic(),pIC_QiLiu));
			if(obj.getType()==0) {//歌曲
				obj.setPlayurl(RoomUtil.jointDomain(obj.getPlayurl(),audio_QiLiu));
			}
		}
		dataMap.put(AppResultConstant.bannerList, bannerList);
		//推荐音乐数据
		List<MusicTuiJianVo> wTuijianList = workTuiJianCacheMapper.getWorkTuiJian();
		List<MusicTuiJianVo> tuijianList = workTuiJianCacheMapper.getLyicsTuiJian();
		wTuijianList.addAll(tuijianList);
		MusicUserVo user=null;
		if(wTuijianList!=null) {
			for(MusicTuiJianVo obj : wTuijianList) {
				obj.setPic(RoomUtil.jointDomain(obj.getPic(),pIC_QiLiu));
				user=userCacheMapper.getCacheUservo(obj.getUid());
				if(user!=null) {
					obj.setAuthor(user.getNickname());
				}
			}
		}
		dataMap.put(AppResultConstant.mTuijianList, wTuijianList);
		//推荐歌单
		List<RecommedSong> recommendsonglist=
				recommedSongCacheMapper.recommedSongPage(1,1,0,4);
		if(recommendsonglist!=null){
			for(RecommedSong obj:recommendsonglist) {
				obj.setPic(RoomUtil.jointDomain(obj.getPic(),pIC_QiLiu));
			}
		}
		dataMap.put(AppResultConstant.recommendsonglist, recommendsonglist);
		/**
		 * 最新列表
		 */
		List<AppIndexNews> newWorkLists = appIndexNewCacheMapper.getAppIndexNewsList(0, 6);
		if(newWorkLists!=null){
			for(AppIndexNews obj:newWorkLists){
				obj.setPic(RoomUtil.jointDomain(obj.getPic(),pIC_QiLiu));
				user=userCacheMapper.getCacheUservo(obj.getUid());
				if(user!=null) {
					obj.setAuthor(user.getNickname());
				}
			}
		}
		dataMap.put(AppResultConstant.NEW_LIST, newWorkLists);
		//乐说列表
		List<MuscicYueSVo> yueshuoList = yueShuoCacheMapper.getYueShuoPages(2, null,2, 0, 4);
		if(yueshuoList!=null){
			for(MuscicYueSVo obj:yueshuoList) {
				if(obj.getType()==1) {
					obj.setUrl(RoomUtil.jointDomain(obj.getUrl(),audio_QiLiu));
				}
				obj.setPic(RoomUtil.jointDomain(obj.getPic(),pIC_QiLiu));
			}
		}
		dataMap.put(AppResultConstant.yueshuoList, yueshuoList);
		resultMap.put(YcContext.CODE, 200);
		resultMap.put(YcContext.MESSAGE, YcContext.EMPTY_STRING);
		resultMap.put(YcContext.DATA,dataMap);
		return resultMap;
	}

}
