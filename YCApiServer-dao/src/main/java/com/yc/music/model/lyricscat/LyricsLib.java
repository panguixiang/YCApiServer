/**
 * Project Name:YCApiServer-dao
 * File Name:LyricsLib.java
 * Package Name:com.yc.music.model.lyricscat
 * Date:2016年5月18日下午7:52:40
 * Copyright (c) 2016 
 *
 */
package com.yc.music.model.lyricscat;

import java.io.Serializable;

/**
 * ClassName: LyricsLib <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月18日 下午7:52:40 <br/>
 *
 * @author panguixiang
 * @version 
 */
public class LyricsLib  implements Serializable{

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = -4339162267381653520L;
	private int lid;
	private int catid;
	private String lyrics;
	
	/**
	 * id.
	 *
	 * @return  the id
	 * @since   JDK 1.7
	 */
	public int getLid() {
		return lid;
	}
	/**
	 * id.
	 *
	 * @param   id the id to set 
	 * @since   JDK 1.7
	 */
	public void setLid(int lid) {
		this.lid = lid;
	}
	/**
	 * catid.
	 *
	 * @return  the catid
	 * @since   JDK 1.7
	 */
	public int getCatid() {
		return catid;
	}
	/**
	 * catid.
	 *
	 * @param   catid the catid to set 
	 * @since   JDK 1.7
	 */
	public void setCatid(int catid) {
		this.catid = catid;
	}
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
