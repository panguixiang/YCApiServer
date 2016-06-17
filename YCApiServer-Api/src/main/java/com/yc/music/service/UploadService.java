package com.yc.music.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yc.music.common.context.YcContext;
import com.yc.music.common.util.FilesUtil;
import com.yc.music.common.util.QiNiuUpload;
import com.yc.music.common.util.RoomUtil;
import com.yc.music.context.AppResultConstant;
import com.yc.music.context.YtConstant;


/**
 * 服务器文件上传操作service
  * @ClassName: UploadService
  * @Description: TODO
  * @author Comsys-panguixiang
  * @date 2016年4月11日 下午7:17:34
  *
 */
@Service
public class UploadService {
	
	@Value("${Pic_QiLiu}")
	private String pIC_QiLiu;
	
	@Value("${Audio_QiLiu}")
	private String audio_QiLiu;
	
	@Value("${pic_buckname}")
	private String pic_buckname;
	
	@Value("${audio_buckname}")
	private String audio_buckname;
	
	@Value("${SERVER_FILE_PATH}")
	private String SERVER_FILE_PATH;

	/**
	 * 
	  * createUploadToken(获得上传的token和生成唯一文件名)
	  *
	  * @Title: createUploadToken
	  * @Description: TODO
	  * @param  type    1=图片，2=音频
	  * @param  fixx 文件类型空间前缀标示
	  * @return Map<String,Object>    返回类型
	  * @throws
	 */
	public Map<String,Object> createUploadToken(Integer type,String fixx, Map<String,Object> result) throws Exception{
		String auth=YcContext.EMPTY_STRING,buckName=YcContext.EMPTY_STRING;
		Map<String,Object> dataMap = new HashMap<String,Object>();
		if(type==null || type<2) {
			buckName=pic_buckname;
			dataMap.put(AppResultConstant.domain_qiliu, pIC_QiLiu);//七牛域名
		} else if(type==2) {
			buckName=audio_buckname;
			dataMap.put(AppResultConstant.domain_qiliu, audio_QiLiu);//七牛域名
		}
		auth = QiNiuUpload.getUpToken(buckName);
		String filename=fixx.concat(YcContext.Slash).concat(RoomUtil.findNextVal(YcContext.EMPTY_STRING));//没有后缀的七牛文件名
		dataMap.put(YcContext.token, auth);
		dataMap.put(YtConstant.filenamekey, filename);
		result.put(YcContext.CODE, 200);
		result.put(YcContext.MESSAGE, YcContext.EMPTY_STRING);
		result.put(YcContext.DATA, dataMap);
		return result;
	}
	/**
	 * 
	 * uploadAudio:(上传mp3文件). <br/> 
	 *
	 * @author panguixiang
	 * @param file
	 * @param result
	 * @return
	 * @throws Exception
	 * @since JDK 1.7
	 */
	public Map<String,Object> uploadAudio(MultipartFile file, Map<String,Object> result) throws Exception{
		if (file.isEmpty()) {
			result.put(YcContext.CODE, 400);
			result.put(YcContext.MESSAGE, YtConstant.upload_mp3_null);
			result.put(YcContext.DATA, YcContext.EMPTY_STRING);
			return result;
		}
		String suffix = (FilenameUtils.getExtension(file
				.getOriginalFilename())).toLowerCase();
		if(!suffix.equals("mp3")) {
			result.put(YcContext.CODE, 400);
			result.put(YcContext.MESSAGE, YtConstant.upload_mp3_suffix_error);
			result.put(YcContext.DATA, YcContext.EMPTY_STRING);
			return result;
		}
		String mp3Path = FilesUtil.saveAudioFile(file.getBytes(),SERVER_FILE_PATH);
		result.put(YcContext.CODE, 200);
		result.put(YcContext.MESSAGE, YcContext.EMPTY_STRING);
		result.put(YcContext.DATA, mp3Path);
		return result;
	}
	
}
