/**
 * Project Name:YCApiServer-dao
 * File Name:UserLoginLog.java
 * Package Name:com.yc.music.model.musicuser
 * Date:2016年5月31日上午10:24:01
 * Copyright (c) 2016 
 *
 */
package com.yc.music.model.musicuser;

/**
 * ClassName: UserLoginLog <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月31日 上午10:24:01 <br/>
 *
 * @author panguixiang
 * @version 
 */
public class UserLoginLog {

	private String loginip;
	private String loginacc;
	private long uid;
	
	public String getLoginip() {
		return loginip;
	}
	public void setLoginip(String loginip) {
		this.loginip = loginip;
	}
	public String getLoginacc() {
		return loginacc;
	}
	public void setLoginacc(String loginacc) {
		this.loginacc = loginacc;
	}
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	
}
