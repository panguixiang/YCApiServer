/**
 * Project Name:YCApiServer-dao
 * File Name:SaveLyrics.java
 * Package Name:com.yc.music.model.musicLyrics
 * Date:2016年5月18日下午8:08:59
 * Copyright (c) 2016 
 *
 */
package com.yc.music.model.musicLyrics;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/**
 * ClassName: SaveLyrics <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月18日 下午8:08:59 <br/>
 *
 * @author panguixiang
 * @version 
 */
public class SaveLyrics {
	
	private Long id;
	
	@NotNull(message="{user.uid.empty}")
	private Long uid;
	
	private String author="";
	
	@NotBlank(message="{work.title.empty}")
	private String title;
	
	@NotBlank(message="{work.lyrics.empty}")
	private String lyrics;
	
	@NotBlank(message="{work.pic.empty}")
	private String pic;
	
	private String detail="";
	private int status=1;//0-不公开，1-公开
	/**
	 * id.
	 *
	 * @return  the id
	 * @since   JDK 1.7
	 */
	public Long getId() {
		return id;
	}
	/**
	 * id.
	 *
	 * @param   id the id to set 
	 * @since   JDK 1.7
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * author.
	 *
	 * @return  the author
	 * @since   JDK 1.7
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * author.
	 *
	 * @param   author the author to set 
	 * @since   JDK 1.7
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * title.
	 *
	 * @return  the title
	 * @since   JDK 1.7
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * title.
	 *
	 * @param   title the title to set 
	 * @since   JDK 1.7
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * lyrics.
	 *
	 * @return  the lyrics
	 * @since   JDK 1.7
	 */
	public String getLyrics() {
		return lyrics;
	}
	/**
	 * lyrics.
	 *
	 * @param   lyrics the lyrics to set 
	 * @since   JDK 1.7
	 */
	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}
	/**
	 * pic.
	 *
	 * @return  the pic
	 * @since   JDK 1.7
	 */
	public String getPic() {
		return pic;
	}
	/**
	 * pic.
	 *
	 * @param   pic the pic to set 
	 * @since   JDK 1.7
	 */
	public void setPic(String pic) {
		this.pic = pic;
	}
	/**
	 * detail.
	 *
	 * @return  the detail
	 * @since   JDK 1.7
	 */
	public String getDetail() {
		return detail;
	}
	/**
	 * detail.
	 *
	 * @param   detail the detail to set 
	 * @since   JDK 1.7
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}
	/**
	 * status.
	 *
	 * @return  the status
	 * @since   JDK 1.7
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * status.
	 *
	 * @param   status the status to set 
	 * @since   JDK 1.7
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
