/**
 * Project Name:YCApiServer-common
 * File Name:TestAudio.java
 * Package Name:com.yc.music.common
 * Date:2016年5月8日上午9:02:16
 * Copyright (c) 2016 
 *
 */
package com.yc.music.common;

import java.io.IOException;

/**
 * ClassName: TestAudio <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月8日 上午9:02:16 <br/>
 *
 * @author panguixiang
 * @version 
 */
public class TestAudio {

	public static void main(String args[]) {
//		Runtime runtime = Runtime.getRuntime();
//		String str ="E:\\ffmpeg\\bin\\ffmpeg.exe -i F:\\www\\mp3\\qc.mp3 -vcodec copy -an F:\\www\\mp3\\qc2.mp3";//过滤杂音
//		try {
//			runtime.exec(str);
//		} catch (IOException e) {
//			e.printStackTrace();ffmpeg 
//		}ffmpeg 
		String str2 = "E:\\ffmpeg\\bin\\ffmpeg.exe -i F:\\www\\mp3\\mo.mp3 -i F:\\www\\bz.mp3 -filter_complex amix=inputs=2:duration=first:dropout_transition=2 -f mp3 F:\\www\\mp3\\mo_3.mp3 -vol 512";
		Runtime runtime2 = Runtime.getRuntime();
		try {
			runtime2.exec(str2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
