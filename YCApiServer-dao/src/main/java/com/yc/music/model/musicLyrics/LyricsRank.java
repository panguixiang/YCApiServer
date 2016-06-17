/**
 * Project Name:YCApiServer-dao
 * File Name:LyricsVo.java
 * Package Name:com.yc.music.model.musicLyrics
 * Date:2016年5月9日下午2:21:42
 * Copyright (c) 2016 
 *
 */
package com.yc.music.model.musicLyrics;

import java.util.Date;

/**
 * 歌词排行榜
 * ClassName: LyricsVo <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月9日 下午2:21:42 <br/>
 *
 * @author panguixiang
 * @version 
 */
public class LyricsRank extends Lyrics{

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = 1194082066302494007L;
	private int fovnum;//收藏量
	private int zannum;//点赞量
	private Date createDate;
	/**
	 * fovnum.
	 *
	 * @return  the fovnum
	 * @since   JDK 1.7
	 */
	public int getFovnum() {
		return fovnum;
	}
	/**
	 * fovnum.
	 *
	 * @param   fovnum the fovnum to set 
	 * @since   JDK 1.7
	 */
	public void setFovnum(int fovnum) {
		this.fovnum = fovnum;
	}
	/**
	 * zannum.
	 *
	 * @return  the zannum
	 * @since   JDK 1.7
	 */
	public int getZannum() {
		return zannum;
	}
	/**
	 * zannum.
	 *
	 * @param   zannum the zannum to set 
	 * @since   JDK 1.7
	 */
	public void setZannum(int zannum) {
		this.zannum = zannum;
	}
	/**
	 * createDate.
	 *
	 * @return  the createDate
	 * @since   JDK 1.7
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * createDate.
	 *
	 * @param   createDate the createDate to set 
	 * @since   JDK 1.7
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
