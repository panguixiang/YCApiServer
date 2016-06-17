package com.yc.music.model.musicLyrics;

import java.util.Date;

public class MusicLyricDetail extends MusicLyrics{

	private long uid;
	private Date createday;
	private String lyrics;
	
	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public Date getCreateday() {
		return createday;
	}

	public void setCreateday(Date createday) {
		this.createday = createday;
	}
	
	public String getLyrics() {
		return lyrics;
	}

	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}
	
	
}
