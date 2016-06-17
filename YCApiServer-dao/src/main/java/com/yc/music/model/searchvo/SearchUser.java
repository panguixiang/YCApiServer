/**
 * Project Name:YCApiServer-dao
 * File Name:SearchUser.java
 * Package Name:com.yc.music.model.searchvo
 * Date:2016年5月22日下午5:24:37
 * Copyright (c) 2016 
 *
 */
package com.yc.music.model.searchvo;

/**
 * 搜索用户
 * ClassName: SearchUser <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月22日 下午5:24:37 <br/>
 *
 * @author panguixiang
 * @version 
 */
public class SearchUser {

	private long uid;
	private String nickname="";
	private String headurl="";
	private int isFans=0;//1=已关注，0=未关注
	private long fansid;//关注者id
	private String iscancel="";//不是给app用的
	private int type=3;
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getHeadurl() {
		return headurl;
	}
	public void setHeadurl(String headurl) {
		this.headurl = headurl;
	}
	public int getIsFans() {
		return isFans;
	}
	public void setIsFans(int isFans) {
		this.isFans = isFans;
	}
	public long getFansid() {
		return fansid;
	}
	public void setFansid(long fansid) {
		this.fansid = fansid;
	}
	public String getIscancel() {
		return iscancel;
	}
	public void setIscancel(String iscancel) {
		this.iscancel = iscancel;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
}
