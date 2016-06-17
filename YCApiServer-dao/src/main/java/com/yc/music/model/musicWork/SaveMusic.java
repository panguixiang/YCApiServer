/**
 * Project Name:YCApiServer-dao
 * File Name:SaveMusic.java
 * Package Name:com.yc.music.model.musicWork
 * Date:2016年5月18日下午6:25:47
 * Copyright (c) 2016 
 *
 */
package com.yc.music.model.musicWork;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/**
 * ClassName: SaveMusic <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月18日 下午6:25:47 <br/>
 *
 * @author panguixiang
 * @version 
 */
public class SaveMusic {
	private Long id;
	
	@NotNull(message = "{user.uid.empty}")
    private Long uid;//作者id
    
    @NotBlank(message = "{work.title.empty}")
	private String title;//标题
    
	private String author="";//作者
	
	private String lyrics="";//歌词可为空
	
	private String createtype="HOT";//标识是由热门录制而来还是由DIY而来。 取值为：HOT/DIY
	
	private int useheadset;//是否使用耳机，1：是，0：否
	
	@NotNull(message = "{work.hotid.empty}")
	private Long hotid;//伴奏的ID
	
	@NotBlank(message = "{work.pic.empty}")
	private String pic;//封面地址
	
	private int is_issue=1;//是否为发布，0：不发布，1为发布
	
	@NotBlank(message = "{SaveMusic.mp3.empty}")
	private String mp3;//最终的mp3地址
	
	private int mp3times;//mp3时长 
	private String diyids="";//描述
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
	 * createtype.
	 *
	 * @return  the createtype
	 * @since   JDK 1.7
	 */
	public String getCreatetype() {
		return createtype;
	}
	/**
	 * createtype.
	 *
	 * @param   createtype the createtype to set 
	 * @since   JDK 1.7
	 */
	public void setCreatetype(String createtype) {
		this.createtype = createtype;
	}
	/**
	 * useheadset.
	 *
	 * @return  the useheadset
	 * @since   JDK 1.7
	 */
	public int getUseheadset() {
		return useheadset;
	}
	/**
	 * useheadset.
	 *
	 * @param   useheadset the useheadset to set 
	 * @since   JDK 1.7
	 */
	public void setUseheadset(int useheadset) {
		this.useheadset = useheadset;
	}
	/**
	 * hotid.
	 *
	 * @return  the hotid
	 * @since   JDK 1.7
	 */
	public Long getHotid() {
		return hotid;
	}
	/**
	 * hotid.
	 *
	 * @param   hotid the hotid to set 
	 * @since   JDK 1.7
	 */
	public void setHotid(Long hotid) {
		this.hotid = hotid;
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
	 * is_issue.
	 *
	 * @return  the is_issue
	 * @since   JDK 1.7
	 */
	public int getIs_issue() {
		return is_issue;
	}
	/**
	 * is_issue.
	 *
	 * @param   is_issue the is_issue to set 
	 * @since   JDK 1.7
	 */
	public void setIs_issue(int is_issue) {
		this.is_issue = is_issue;
	}
	/**
	 * mp3.
	 *
	 * @return  the mp3
	 * @since   JDK 1.7
	 */
	public String getMp3() {
		return mp3;
	}
	/**
	 * mp3.
	 *
	 * @param   mp3 the mp3 to set 
	 * @since   JDK 1.7
	 */
	public void setMp3(String mp3) {
		this.mp3 = mp3;
	}
	/**
	 * mp3times.
	 *
	 * @return  the mp3times
	 * @since   JDK 1.7
	 */
	public int getMp3times() {
		return mp3times;
	}
	/**
	 * mp3times.
	 *
	 * @param   mp3times the mp3times to set 
	 * @since   JDK 1.7
	 */
	public void setMp3times(int mp3times) {
		this.mp3times = mp3times;
	}
	public String getDiyids() {
		return diyids;
	}
	public void setDiyids(String diyids) {
		this.diyids = diyids;
	}
	
	
}
