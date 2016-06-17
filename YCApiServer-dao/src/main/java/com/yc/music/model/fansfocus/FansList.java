/**
 * Project Name:YCApiServer-dao
 * File Name:FansList.java
 * Package Name:com.yc.music.model.fansfocus
 * Date:2016年5月27日下午3:14:24
 * Copyright (c) 2016 
 *
 */
package com.yc.music.model.fansfocus;

/**
 * ClassName: FansList <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月27日 下午3:14:24 <br/>
 *
 * @author panguixiang
 * @version 
 */
public class FansList {
	
	private long id;
	
	private long userid;//用户id(被关注)
	
	private long fansid;//粉丝id(关注者)
	
	private String fansname="";
	private String headurl="";
	private String fansign="";
	
	private int status=1;//1=已关注，2=互相关注
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public long getFansid() {
		return fansid;
	}
	public void setFansid(long fansid) {
		this.fansid = fansid;
	}
	public String getFansname() {
		return fansname;
	}
	public void setFansname(String fansname) {
		this.fansname = fansname;
	}
	public String getHeadurl() {
		return headurl;
	}
	public void setHeadurl(String headurl) {
		this.headurl = headurl;
	}
	public String getFansign() {
		return fansign;
	}
	public void setFansign(String fansign) {
		this.fansign = fansign;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
