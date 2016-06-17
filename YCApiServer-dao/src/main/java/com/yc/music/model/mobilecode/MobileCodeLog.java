/**
 * Project Name:YCApiServer-dao
 * File Name:MobileCodeLog.java
 * Package Name:com.yc.music.model.mobilecode
 * Date:2016年6月3日下午4:49:56
 * Copyright (c) 2016 
 *
 */
package com.yc.music.model.mobilecode;

/**
 * ClassName: MobileCodeLog <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年6月3日 下午4:49:56 <br/>
 *
 * @author panguixiang
 * @version 
 */
public class MobileCodeLog {

	private long id;
	private String ip;
	private String createdate;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	
}
