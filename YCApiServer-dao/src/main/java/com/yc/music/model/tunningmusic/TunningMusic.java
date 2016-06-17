/**
 * Project Name:YCApiServer-dao
 * File Name:TunningMusic.java
 * Package Name:com.yc.music.model.tunningmusic
 * Date:2016年5月18日下午3:14:13
 * Copyright (c) 2016 
 *
 */
package com.yc.music.model.tunningmusic;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/**
 * ClassName: TunningMusic <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月18日 下午3:14:13 <br/>
 *
 * @author panguixiang
 * @version 
 */
public class TunningMusic {

	@NotBlank(message="{TunningMusic.createtype.empty}")
	private String createtype;//录音类别：可能值：HOT/DIY
	
	@NotNull(message="{TunningMusic.hotid.empty}")
	private Long hotid;//伴奏的id
	
	private int recordingsize=1;//人声大小，默认1
	private int bgmsize=1;//伴奏大小，默认1
	private int useheadset;//是否使用耳机，1：是，0：否
	
	@NotBlank(message="{TunningMusic.musicurl.empty}")
	private String musicurl;//录制的声音url
	
	private int speed=1;
	
	private long uid;//操作者id
	
	/**
	 * createtype.
	 *
	 * @return  the createtype
	 * @since   JDK 1.7
	 */
	public String getCreatetype() {
		return createtype;
	}
	/**
	 * createtype.
	 *
	 * @param   createtype the createtype to set 
	 * @since   JDK 1.7
	 */
	public void setCreatetype(String createtype) {
		this.createtype = createtype;
	}
	/**
	 * hotid.
	 *
	 * @return  the hotid
	 * @since   JDK 1.7
	 */
	public Long getHotid() {
		return hotid;
	}
	/**
	 * hotid.
	 *
	 * @param   hotid the hotid to set 
	 * @since   JDK 1.7
	 */
	public void setHotid(Long hotid) {
		this.hotid = hotid;
	}
	/**
	 * recordingsize.
	 *
	 * @return  the recordingsize
	 * @since   JDK 1.7
	 */
	public int getRecordingsize() {
		return recordingsize;
	}
	/**
	 * recordingsize.
	 *
	 * @param   recordingsize the recordingsize to set 
	 * @since   JDK 1.7
	 */
	public void setRecordingsize(int recordingsize) {
		this.recordingsize = recordingsize;
	}
	/**
	 * bgmsize.
	 *
	 * @return  the bgmsize
	 * @since   JDK 1.7
	 */
	public int getBgmsize() {
		return bgmsize;
	}
	/**
	 * bgmsize.
	 *
	 * @param   bgmsize the bgmsize to set 
	 * @since   JDK 1.7
	 */
	public void setBgmsize(int bgmsize) {
		this.bgmsize = bgmsize;
	}
	/**
	 * useheadset.
	 *
	 * @return  the useheadset
	 * @since   JDK 1.7
	 */
	public int getUseheadset() {
		return useheadset;
	}
	/**
	 * useheadset.
	 *
	 * @param   useheadset the useheadset to set 
	 * @since   JDK 1.7
	 */
	public void setUseheadset(int useheadset) {
		this.useheadset = useheadset;
	}
	/**
	 * musicurl.
	 *
	 * @return  the musicurl
	 * @since   JDK 1.7
	 */
	public String getMusicurl() {
		return musicurl;
	}
	/**
	 * musicurl.
	 *
	 * @param   musicurl the musicurl to set 
	 * @since   JDK 1.7
	 */
	public void setMusicurl(String musicurl) {
		this.musicurl = musicurl;
	}
	/**
	 * speed.
	 *
	 * @return  the speed
	 * @since   JDK 1.7
	 */
	public int getSpeed() {
		return speed;
	}
	/**
	 * speed.
	 *
	 * @param   speed the speed to set 
	 * @since   JDK 1.7
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	
}
