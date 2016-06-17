/**
 * Project Name:YCApiServer-common
 * File Name:CopyFilesExample.java
 * Package Name:com.yc.music.common
 * Date:2016年5月18日下午4:12:42
 * Copyright (c) 2016 
 *
 */
package com.yc.music.common.util;

/**
 * ClassName: CopyFiles <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月18日 下午4:12:42 <br/>
 *
 * @author panguixiang
 * @version 
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import com.yc.music.common.context.YcContext;

/**
 * 文件处理工具
 * ClassName: FilesUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月18日 下午4:25:09 <br/>
 *
 * @author panguixiang
 * @version
 */
public class FilesUtil {
	
	private static final String yyyy="yyyy";
	private static final String mm="MM";
	private static final String dd="dd";
	
	/**
	 * 使用 FileChannel方式拷贝文件，效率高于apache commons的
	 * copyFileUsingFileChannels:(这里用一句话描述这个方法的作用). <br/> 
	 *
	 * @author panguixiang
	 * @param sourcestr
	 * @param deststr
	 * @throws IOException
	 * @since JDK 1.7
	 */
	@SuppressWarnings("resource")
	public static void copyFileUsingFileChannels(String fatherPath,String sourcestr, String deststr) throws IOException {
		FileChannel inputChannel = null;
		FileChannel outputChannel = null;
		File source = new File(fatherPath+sourcestr);
	    File dest = new File(fatherPath+deststr);
	    if(!dest.getParentFile().exists()) {//创建文件目录
	    	dest.getParentFile().mkdirs();
	    }
		try {
			inputChannel = new FileInputStream(source).getChannel();
			outputChannel = new FileOutputStream(dest).getChannel();
			outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
		} finally {
			inputChannel.close();
			outputChannel.close();
		}
	}
	
	
	/**
	 * 
	 * getDatePath:(创建文件夹目录，年月日). <br/> 
	 *
	 * @author panguixiang
	 * @return
	 * @since JDK 1.7
	 */
	public static String getDatePath() {
		Date date = new Date();
		StringBuffer buffer = new StringBuffer();
		SimpleDateFormat dateFormat = new SimpleDateFormat(yyyy);
		buffer.append(dateFormat.format(date)).append(File.separator);
		dateFormat = new SimpleDateFormat(mm);
		dateFormat.format(date);
		buffer.append(dateFormat.format(date)).append(File.separator);
		dateFormat = new SimpleDateFormat(dd);
		dateFormat.format(date);
		buffer.append(dateFormat.format(date)).append(File.separator);
		dateFormat = new SimpleDateFormat(YcContext.nextVal);
		dateFormat.format(date);
		buffer.append(dateFormat.format(date));
		return buffer.toString();
	}
	
	
	/**
	 * 上传文件
	 * 
	 * @param fileRealPath
	 * @param uploadFile
	 * @return
	 */
	public static String saveAudioFile(byte[] multFilebyte, String basePath) throws IOException {
		
		String tmpPath = getDatePath().concat(".mp3");
		basePath=basePath.concat("/uploadfiles2");
		String filePath = FilenameUtils.concat(basePath, tmpPath);
		/**
		 * 上传原图
		 */
		File audioFile = new File(filePath);
		FileOutputStream bigfs = FileUtils.openOutputStream(audioFile);
		bigfs.write(multFilebyte);
		bigfs.close();
		return "/uploadfiles2"+YcContext.Slash.concat(tmpPath);
	}
	
}
