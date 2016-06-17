/**
 * Project Name:YCApiServer-dao
 * File Name:ShareModel.java
 * Package Name:com.yc.music.model
 * Date:2016年5月26日下午4:59:56
 * Copyright (c) 2016 
 *
 */
package com.yc.music.model;

/**
 * ClassName: ShareModel <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月26日 下午4:59:56 <br/>
 *
 * @author panguixiang
 * @version 
 */
public class ShareModel {

	private long itemid;
	private String shareurl="";
	
	public long getItemid() {
		return itemid;
	}
	public void setItemid(long itemid) {
		this.itemid = itemid;
	}
	public String getShareurl() {
		return shareurl;
	}
	public void setShareurl(String shareurl) {
		this.shareurl = shareurl;
	}
	
}
