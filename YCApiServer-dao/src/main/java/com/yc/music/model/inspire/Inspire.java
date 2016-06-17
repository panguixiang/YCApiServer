/**
 * Project Name:YCApiServer-dao
 * File Name:Inspire.java
 * Package Name:com.yc.music.model.inspire
 * Date:2016年5月12日上午11:34:48
 * Copyright (c) 2016 
 *
 */
package com.yc.music.model.inspire;

import java.util.Date;

import javax.validation.constraints.NotNull;

/**
 * ClassName: Inspire <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月12日 上午11:34:48 <br/>
 *
 * @author panguixiang
 * @version 
 */
public class Inspire {

	private long itemid;
	
	@NotNull(message="{Inspire.uid.empty}")
	private Long uid;
	
	private String spirecontent="";
	
	private String pics="";
	
	private String audio="";
	
	private Date createdate;

	private String audiodomain="";//不做数据库字段
	private String picdomain="";//不做数据库字段
	
	public long getItemid() {
		return itemid;
	}

	public void setItemid(long itemid) {
		this.itemid = itemid;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getSpirecontent() {
		return spirecontent;
	}

	public void setSpirecontent(String spirecontent) {
		this.spirecontent = spirecontent;
	}

	public String getPics() {
		return pics;
	}

	public void setPics(String pics) {
		this.pics = pics;
	}

	public String getAudio() {
		return audio;
	}

	public void setAudio(String audio) {
		this.audio = audio;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getAudiodomain() {
		return audiodomain;
	}

	public void setAudiodomain(String audiodomain) {
		this.audiodomain = audiodomain;
	}

	public String getPicdomain() {
		return picdomain;
	}

	public void setPicdomain(String picdomain) {
		this.picdomain = picdomain;
	}
}
