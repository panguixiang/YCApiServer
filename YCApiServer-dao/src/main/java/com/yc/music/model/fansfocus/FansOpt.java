/**
 * Project Name:YCApiServer-dao
 * File Name:FansOpt.java
 * Package Name:com.yc.music.model.fansfocus
 * Date:2016年5月19日上午11:21:37
 * Copyright (c) 2016 
 *
 */
package com.yc.music.model.fansfocus;

import javax.validation.constraints.NotNull;

/**
 * 粉丝 关注 model
 * ClassName: FansOpt <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月19日 上午11:21:37 <br/>
 *
 * @author panguixiang
 * @version 
 */
public class FansOpt {

	@NotNull(message = "{FansOpt.userid.empty}")
	private Long userid;//用户id(被关注)
	
	@NotNull(message = "{FansOpt.fansid.empty}")
	private Long fansid;//粉丝id(关注者)
	
	private String result="";
	
	/**
	 * userid.
	 *
	 * @return  the userid
	 * @since   JDK 1.7
	 */
	public Long getUserid() {
		return userid;
	}
	/**
	 * userid.
	 *
	 * @param   userid the userid to set 
	 * @since   JDK 1.7
	 */
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	/**
	 * fansid.
	 *
	 * @return  the fansid
	 * @since   JDK 1.7
	 */
	public Long getFansid() {
		return fansid;
	}
	/**
	 * fansid.
	 *
	 * @param   fansid the fansid to set 
	 * @since   JDK 1.7
	 */
	public void setFansid(Long fansid) {
		this.fansid = fansid;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
}
