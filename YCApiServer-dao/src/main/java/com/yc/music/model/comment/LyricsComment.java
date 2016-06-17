/**
 * Project Name:YCApiServer-dao
 * File Name:WorkComment.java
 * Package Name:com.yc.music.model.comment
 * Date:2016年5月8日下午5:49:08
 * Copyright (c) 2016 
 *
 */
package com.yc.music.model.comment;

import java.util.Date;

import javax.validation.constraints.NotNull;


/**
 * 歌词评论model
 * ClassName: WorkComment <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月8日 下午5:49:08 <br/>
 *
 * @author panguixiang
 * @version 
 */
public class LyricsComment {

	private long id;
	
	@NotNull(message="{WorkComment.comment.empty}")
	private String comment;
	
	@NotNull(message="{WorkComment.uid.empty}")
	private Long uid;
	
	private String headerurl="";
	
	private String nickname="";
	
	private String target_nickname="";
	
	private int comment_type=1;
	
	@NotNull(message="{LyricsComment.workid.empty}")
	private Long lyricsid;
	
	private long target_uid=0;
	
	private Date createdate;

	/**
	 * id.
	 *
	 * @return  the id
	 * @since   JDK 1.7
	 */
	public long getId() {
		return id;
	}

	/**
	 * id.
	 *
	 * @param   id the id to set 
	 * @since   JDK 1.7
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * comment.
	 *
	 * @return  the comment
	 * @since   JDK 1.7
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * comment.
	 *
	 * @param   comment the comment to set 
	 * @since   JDK 1.7
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * uid.
	 *
	 * @return  the uid
	 * @since   JDK 1.7
	 */
	public Long getUid() {
		return uid;
	}

	/**
	 * uid.
	 *
	 * @param   uid the uid to set 
	 * @since   JDK 1.7
	 */
	public void setUid(Long uid) {
		this.uid = uid;
	}

	/**
	 * headerurl.
	 *
	 * @return  the headerurl
	 * @since   JDK 1.7
	 */
	public String getHeaderurl() {
		return headerurl;
	}

	/**
	 * headerurl.
	 *
	 * @param   headerurl the headerurl to set 
	 * @since   JDK 1.7
	 */
	public void setHeaderurl(String headerurl) {
		this.headerurl = headerurl;
	}

	/**
	 * nickname.
	 *
	 * @return  the nickname
	 * @since   JDK 1.7
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * nickname.
	 *
	 * @param   nickname the nickname to set 
	 * @since   JDK 1.7
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * target_nickname.
	 *
	 * @return  the target_nickname
	 * @since   JDK 1.7
	 */
	public String getTarget_nickname() {
		return target_nickname;
	}

	/**
	 * target_nickname.
	 *
	 * @param   target_nickname the target_nickname to set 
	 * @since   JDK 1.7
	 */
	public void setTarget_nickname(String target_nickname) {
		this.target_nickname = target_nickname;
	}

	/**
	 * comment_type.
	 *
	 * @return  the comment_type
	 * @since   JDK 1.7
	 */
	public int getComment_type() {
		return comment_type;
	}

	/**
	 * comment_type.
	 *
	 * @param   comment_type the comment_type to set 
	 * @since   JDK 1.7
	 */
	public void setComment_type(int comment_type) {
		this.comment_type = comment_type;
	}

	/**
	 * lyricsid.
	 *
	 * @return  the lyricsid
	 * @since   JDK 1.7
	 */
	public Long getLyricsid() {
		return lyricsid;
	}

	/**
	 * lyricsid.
	 *
	 * @param   lyricsid the lyricsid to set 
	 * @since   JDK 1.7
	 */
	public void setLyricsid(Long lyricsid) {
		this.lyricsid = lyricsid;
	}

	/**
	 * target_uid.
	 *
	 * @return  the target_uid
	 * @since   JDK 1.7
	 */
	public long getTarget_uid() {
		return target_uid;
	}

	/**
	 * target_uid.
	 *
	 * @param   target_uid the target_uid to set 
	 * @since   JDK 1.7
	 */
	public void setTarget_uid(long target_uid) {
		this.target_uid = target_uid;
	}

	/**
	 * createdate.
	 *
	 * @return  the createdate
	 * @since   JDK 1.7
	 */
	public Date getCreatedate() {
		return createdate;
	}

	/**
	 * createdate.
	 *
	 * @param   createdate the createdate to set 
	 * @since   JDK 1.7
	 */
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

}
