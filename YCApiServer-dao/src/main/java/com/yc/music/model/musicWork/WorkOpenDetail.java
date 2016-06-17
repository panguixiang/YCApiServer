/**
 * Project Name:YCApiServer-dao
 * File Name:WorkOpenDetail.java
 * Package Name:com.yc.music.model.musicWork
 * Date:2016年5月5日下午7:57:22
 * Copyright (c) 2016 
 *
 */
package com.yc.music.model.musicWork;

import java.io.Serializable;

/**
 * ClassName: WorkOpenDetail <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月5日 下午7:57:22 <br/>
 *
 * @author panguixiang
 * @version
 */
public class WorkOpenDetail implements Serializable {

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = 8916091884779559767L;
	private long itemid;
	private String title = "";// 歌曲标题
	private long uid;// 此歌曲作者id
	private String author = "";// 作者名称
	private String headurl = "";// 此歌曲作者头像地址
	private String lyrics = "";// 歌词
	private long hotid;// 伴奏id
	private String hotTitle = "";// 伴奏标题
	private String hotAuthor = "";// 伴奏作者
	private int zannum;// 歌曲点赞量
	private int fovnum;// 歌曲收藏量 fovnum
	private int commentnum;// 歌曲评论量
	private String playurl = "";// 歌曲mp3地址
	private int isZan;// 是否已对此歌曲点赞0=没有，1=已经点赞
	private int iscollect;// 是否已对此歌曲收藏0=没有，1=已收藏
	private String pic = "";// 歌曲封面地址
	private String come = "";// 进入播放器时的来源
	private long prev = 0;// 下一首歌曲id
	private long next = 0;// 上一首歌曲id
	private int mp3times;// 时长
	private String hotmp3="";//伴奏mp3地址
	private int hotmp3times;//伴奏时长
	private String shareurl="";
	private String diyids="";
	public long getItemid() {
		return itemid;
	}
	public void setItemid(long itemid) {
		this.itemid = itemid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getHeadurl() {
		return headurl;
	}
	public void setHeadurl(String headurl) {
		this.headurl = headurl;
	}
	public String getLyrics() {
		return lyrics;
	}
	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}
	public long getHotid() {
		return hotid;
	}
	public void setHotid(long hotid) {
		this.hotid = hotid;
	}
	public String getHotTitle() {
		return hotTitle;
	}
	public void setHotTitle(String hotTitle) {
		this.hotTitle = hotTitle;
	}
	public String getHotAuthor() {
		return hotAuthor;
	}
	public void setHotAuthor(String hotAuthor) {
		this.hotAuthor = hotAuthor;
	}
	public int getZannum() {
		return zannum;
	}
	public void setZannum(int zannum) {
		this.zannum = zannum;
	}
	public int getFovnum() {
		return fovnum;
	}
	public void setFovnum(int fovnum) {
		this.fovnum = fovnum;
	}
	public int getCommentnum() {
		return commentnum;
	}
	public void setCommentnum(int commentnum) {
		this.commentnum = commentnum;
	}
	public String getPlayurl() {
		return playurl;
	}
	public void setPlayurl(String playurl) {
		this.playurl = playurl;
	}
	public int getIsZan() {
		return isZan;
	}
	public void setIsZan(int isZan) {
		this.isZan = isZan;
	}
	public int getIscollect() {
		return iscollect;
	}
	public void setIscollect(int iscollect) {
		this.iscollect = iscollect;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getCome() {
		return come;
	}
	public void setCome(String come) {
		this.come = come;
	}
	public long getPrev() {
		return prev;
	}
	public void setPrev(long prev) {
		this.prev = prev;
	}
	public long getNext() {
		return next;
	}
	public void setNext(long next) {
		this.next = next;
	}
	public int getMp3times() {
		return mp3times;
	}
	public void setMp3times(int mp3times) {
		this.mp3times = mp3times;
	}
	public String getHotmp3() {
		return hotmp3;
	}
	public void setHotmp3(String hotmp3) {
		this.hotmp3 = hotmp3;
	}
	public int getHotmp3times() {
		return hotmp3times;
	}
	public void setHotmp3times(int hotmp3times) {
		this.hotmp3times = hotmp3times;
	}
	public String getShareurl() {
		return shareurl;
	}
	public void setShareurl(String shareurl) {
		this.shareurl = shareurl;
	}
	public String getDiyids() {
		return diyids;
	}
	public void setDiyids(String diyids) {
		this.diyids = diyids;
	}
}
