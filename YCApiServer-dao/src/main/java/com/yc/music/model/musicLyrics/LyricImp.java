/**
 * Project Name:YCApiServer-dao
 * File Name:LyricImp.java
 * Package Name:com.yc.music.model.musicLyrics
 * Date:2016年5月18日上午11:27:02
 * Copyright (c) 2016 
 *
 */
package com.yc.music.model.musicLyrics;

/**
 * ClassName: LyricImp <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月18日 上午11:27:02 <br/>
 *
 * @author panguixiang
 * @version 
 */
public class LyricImp extends Lyrics{

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = -4507047207803164061L;
	private String lyrics="";//歌词内容

	/**
	 * lyrics.
	 *
	 * @return  the lyrics
	 * @since   JDK 1.7
	 */
	public String getLyrics() {
		return lyrics;
	}

	/**
	 * lyrics.
	 *
	 * @param   lyrics the lyrics to set 
	 * @since   JDK 1.7
	 */
	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}
	
}
