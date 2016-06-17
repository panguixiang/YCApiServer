package com.yc.music.service.service103;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.yc.music.common.context.YcContext;
import com.yc.music.common.util.RoomUtil;
import com.yc.music.context.YtConstant;
import com.yc.music.mapper.dao.LyricsMapper;
import com.yc.music.mapper.dao.UserMapper;
import com.yc.music.mapper.dao.WorkMapper;
import com.yc.music.model.searchvo.SearchUser;
import com.yc.music.model.searchvo.SearchWork;
/**
 * 
 * ClassName: SearchService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月22日 下午3:27:05 <br/>
 *
 * @author panguixiang
 * @version
 */
@Service
public class SearchService {

	@Value("${Pic_QiLiu}")
	private String pIC_QiLiu;
	
	@Autowired
	private WorkMapper WorkMapper;
	
	@Autowired
	private LyricsMapper lyricsMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 
	 * loginMobile:(搜索). <br/> 
	 *
	 * @author panguixiang
	 * @param fansid  登录用户id 
	 * @param name 关键词
	 * @param page  页码
	 * @param type  1=歌曲，2=歌词，3=用户
	 * @param result
	 * @return
	 * @throws Exception
	 * @since JDK 1.7
	 */
	public Map<String,Object> searchApp(Long fansid, String name, Integer page,Integer type,
			Map<String,Object> result) throws Exception{
		if(StringUtils.isBlank(name) || StringUtils.isBlank(name.trim())) {
			result.put(YcContext.CODE, 400);
			result.put(YcContext.MESSAGE, YtConstant.SEARCH_NAME_NULL);
			result.put(YcContext.DATA,YcContext.EMPTY_STRING);
			return result;
		}
		int start =0,size=10;
		if(page!=null && page>1) {
			start=(page-1)*size;
		}
		type=(type==null||type>3||type<1)?1:type;
		
		if(type==1) {//歌曲搜索
			List<SearchWork> musicList = WorkMapper.searchMusicList(name, start, size);
			if(musicList!=null){
				for(SearchWork obj:musicList){
					obj.setPic(RoomUtil.jointDomain(obj.getPic(),pIC_QiLiu));
					obj.setType(type);
				}
			}
			result.put(YcContext.DATA,musicList);
		}else if(type==2){//歌词搜索
			List<SearchWork> musicList = lyricsMapper.searchLyricsList(name, start, size);
			if(musicList!=null){
				for(SearchWork obj:musicList){
					obj.setPic(RoomUtil.jointDomain(obj.getPic(),pIC_QiLiu));
					obj.setType(type);
				}
			}
			result.put(YcContext.DATA,musicList);
		} else if(type==3) {
			List<SearchUser> userList = userMapper.searchUserList(name, start, size);
			if(userList!=null){
				for(SearchUser obj:userList){
					obj.setHeadurl(RoomUtil.jointDomain(obj.getHeadurl(),pIC_QiLiu));
					if(fansid!=null && obj.getFansid()==fansid) {
						if(obj.getIscancel()!=null && StringUtils.equals(obj.getIscancel(),"false")) {
							obj.setIsFans(1);//已关注
						}
					}
				}
			}
			result.put(YcContext.DATA,userList);
		}
		result.put(YcContext.CODE, 200);
		result.put(YcContext.MESSAGE, YcContext.EMPTY_STRING);
		return result;
	}
	
}
