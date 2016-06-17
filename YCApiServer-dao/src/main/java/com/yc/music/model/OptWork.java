/**
 * Project Name:YCApiServer-dao
 * File Name:OptZan.java
 * Package Name:com.yc.music.model.workzan
 * Date:2016年5月19日上午10:37:37
 * Copyright (c) 2016 
 *
 */
package com.yc.music.model;

import javax.validation.constraints.NotNull;

/**
 * 点赞，收藏 操作 model
 * ClassName: OptWork <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月19日 上午10:37:37 <br/>
 *
 * @author panguixiang
 * @version 
 */
public class OptWork {

	@NotNull(message = "{OptZan.work_id.empty}")
	private Long work_id;// 点赞，收藏操作的对象id
	
	@NotNull(message = "{user.uid.empty}")
	private Long target_uid;//被点赞，被收藏作品的作者id
	
	@NotNull(message = "{OptZan.user_id.empty}")
	private Long user_id;//点赞，收藏的用户id
	
	@NotNull(message = "{OptZan.wtype.empty}")
	private Integer wtype;//类型  1=歌曲，2=歌词
	
	private String result="";
	
	/**
	 * work_id.
	 *
	 * @return  the work_id
	 * @since   JDK 1.7
	 */
	public Long getWork_id() {
		return work_id;
	}
	/**
	 * work_id.
	 *
	 * @param   work_id the work_id to set 
	 * @since   JDK 1.7
	 */
	public void setWork_id(Long work_id) {
		this.work_id = work_id;
	}
	/**
	 * target_uid.
	 *
	 * @return  the target_uid
	 * @since   JDK 1.7
	 */
	public Long getTarget_uid() {
		return target_uid;
	}
	/**
	 * target_uid.
	 *
	 * @param   target_uid the target_uid to set 
	 * @since   JDK 1.7
	 */
	public void setTarget_uid(Long target_uid) {
		this.target_uid = target_uid;
	}
	/**
	 * user_id.
	 *
	 * @return  the user_id
	 * @since   JDK 1.7
	 */
	public Long getUser_id() {
		return user_id;
	}
	/**
	 * user_id.
	 *
	 * @param   user_id the user_id to set 
	 * @since   JDK 1.7
	 */
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	/**
	 * wtype.
	 *
	 * @return  the wtype
	 * @since   JDK 1.7
	 */
	public Integer getWtype() {
		return wtype;
	}
	/**
	 * wtype.
	 *
	 * @param   wtype the wtype to set 
	 * @since   JDK 1.7
	 */
	public void setWtype(Integer wtype) {
		this.wtype = wtype;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}
