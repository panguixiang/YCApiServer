/**
 * Project Name:YCApiServer-dao
 * File Name:WorkComment.java
 * Package Name:com.yc.music.model.comment
 * Date:2016年5月8日下午5:49:08
 * Copyright (c) 2016 
 *
 */
package com.yc.music.model.comment;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

/**
 * 评论model
 * ClassName: YcComment <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月8日 下午5:49:08 <br/>
 *
 * @author panguixiang
 * @version 
 */
public class YcComment  implements Serializable{

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = -8324584473816062576L;

	private long id;
	
	@NotNull(message="{comment.comment.empty}")
	private String comment="";
	
	@NotNull(message="{comment.uid.empty}")
	private Long uid;
	
	private String headerurl="";
	
	private String nickname="";
	
	private String target_nickname="";
	
	@NotNull(message="{comment.uid.comment_type}")
	private Integer comment_type=1;//1=默认，2=跟帖
	
	@NotNull(message="{comment.itemid.empty}")
	private Long itemid;
	
	private long target_uid;//被评论的作者id
	
	private Date createdate;
	
	@NotNull(message="{comment.workid.type}")
	private Integer type;//1=歌曲，2=歌词
	
	private int isread=1;//1=未读，0=已读
	
	private String targetheaderurl="";

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getHeaderurl() {
		return headerurl;
	}

	public void setHeaderurl(String headerurl) {
		this.headerurl = headerurl;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getTarget_nickname() {
		return target_nickname;
	}

	public void setTarget_nickname(String target_nickname) {
		this.target_nickname = target_nickname;
	}

	public Integer getComment_type() {
		return comment_type;
	}

	public void setComment_type(Integer comment_type) {
		this.comment_type = comment_type;
	}

	public Long getItemid() {
		return itemid;
	}

	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}

	public long getTarget_uid() {
		return target_uid;
	}

	public void setTarget_uid(long target_uid) {
		this.target_uid = target_uid;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public int getIsread() {
		return isread;
	}

	public void setIsread(int isread) {
		this.isread = isread;
	}

	public String getTargetheaderurl() {
		return targetheaderurl;
	}

	public void setTargetheaderurl(String targetheaderurl) {
		this.targetheaderurl = targetheaderurl;
	}

}
