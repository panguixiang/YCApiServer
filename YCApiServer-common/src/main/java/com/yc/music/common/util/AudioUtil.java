/**
 * Project Name:YCApiServer-common
 * File Name:AudioUtil.java
 * Package Name:com.yc.music.common.util
 * Date:2016年5月12日下午2:38:55
 * Copyright (c) 2016 
 *
 */
package com.yc.music.common.util;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.UnsupportedAudioFileException;

import javazoom.spi.mpeg.sampled.file.MpegAudioFileReader;

/**
 * 音频处理工具类
 * ClassName: AudioUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月12日 下午2:38:55 <br/>
 *
 * @author panguixiang
 * @version 
 */
public class AudioUtil {

	private static final String duration_key = "duration";
	
	/**
	 * 获得音频文件的时长，秒为单位
	 * getAudioTime:(这里用一句话描述这个方法的作用). <br/> 
	 * @author panguixiang
	 * @param filePaht
	 * @return
	 * @since JDK 1.7
	 */
	public static int getAudioTime(String filePaht) {
		File file = new File(filePaht);
		AudioFileFormat baseFileFormat;
		int duration=0;
		try {
			baseFileFormat = new MpegAudioFileReader().getAudioFileFormat(file);
			Map<?,?> properties = baseFileFormat.properties();
			long mil = (long) ((long)properties.get(duration_key) / 1000);
			int miao= (int) ((mil / 1000) % 60);
			int fen = (int) ((mil / 1000) / 60);
			duration = (fen*60)+miao;
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return duration;
	}
	
	/**
	 * 
	 * doAudioTuning:(调用java 命令行执行 音频处理命令). <br/> 
	 *
	 * @author panguixiang
	 * @param exec
	 * @throws Exception
	 * @since JDK 1.7
	 */
	public static void doAudioTuning(String exec) throws Exception{
		Runtime runtime2 = Runtime.getRuntime();
		runtime2.exec(exec);
	}
	
}
