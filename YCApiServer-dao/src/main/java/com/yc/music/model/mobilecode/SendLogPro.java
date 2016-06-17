/**
 * Project Name:YCApiServer-dao
 * File Name:SendLogPro.java
 * Package Name:com.yc.music.model.mobilecode
 * Date:2016年6月3日下午5:43:14
 * Copyright (c) 2016 
 *
 */
package com.yc.music.model.mobilecode;

import java.util.Date;

/**
 * ClassName: SendLogPro <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年6月3日 下午5:43:14 <br/>
 *
 * @author panguixiang
 * @version 
 */
public class SendLogPro {

	private String ip;
	private String createdate ;
	private String mobile ;
	private String smscode  ;
    private Date sendtime ;
    private int smstype ;
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getSmscode() {
		return smscode;
	}
	public void setSmscode(String smscode) {
		this.smscode = smscode;
	}
	public Date getSendtime() {
		return sendtime;
	}
	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}
	public int getSmstype() {
		return smstype;
	}
	public void setSmstype(int smstype) {
		this.smstype = smstype;
	}
	
}
