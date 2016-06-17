package com.yc.music.model.musicLyrics;

import java.util.Date;


/**
 * 歌词显示页详细信息
  * @ClassName: MusicLyrics
  * @Description: TODO
  * @author Comsys-panguixiang
  * @date 2016年4月7日 下午6:39:09
  *
 */
public class MusicLyrics {

	private long itemid;
	private String pic="";
	private String title="";
	private String author="";
	private String lyrics="";
	private long uid;
	private int commentnum;//评论量
	private int zannum;//点赞量
	private int fovnum;//收藏量
	private int isCollect;//1=已收藏，0=未收藏
	private int isZan;//1=已点赞，0=未点赞
	private int status;//0-不公开，1-公开
	private int sampleid=0;//0未使用模板，1使用了模板
	private Date createdate;
	private String shareurl="";
	private String headurl="";
	private String detail="";
	/**
	 * itemid.
	 *
	 * @return  the itemid
	 * @since   JDK 1.7
	 */
	public long getItemid() {
		return itemid;
	}
	/**
	 * itemid.
	 *
	 * @param   itemid the itemid to set 
	 * @since   JDK 1.7
	 */
	public void setItemid(long itemid) {
		this.itemid = itemid;
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
	 * uid.
	 *
	 * @return  the uid
	 * @since   JDK 1.7
	 */
	public long getUid() {
		return uid;
	}
	/**
	 * uid.
	 *
	 * @param   uid the uid to set 
	 * @since   JDK 1.7
	 */
	public void setUid(long uid) {
		this.uid = uid;
	}
	/**
	 * commentnum.
	 *
	 * @return  the commentnum
	 * @since   JDK 1.7
	 */
	public int getCommentnum() {
		return commentnum;
	}
	/**
	 * commentnum.
	 *
	 * @param   commentnum the commentnum to set 
	 * @since   JDK 1.7
	 */
	public void setCommentnum(int commentnum) {
		this.commentnum = commentnum;
	}
	/**
	 * zannum.
	 *
	 * @return  the zannum
	 * @since   JDK 1.7
	 */
	public int getZannum() {
		return zannum;
	}
	/**
	 * zannum.
	 *
	 * @param   zannum the zannum to set 
	 * @since   JDK 1.7
	 */
	public void setZannum(int zannum) {
		this.zannum = zannum;
	}

	/**
	 * fovnum.
	 *
	 * @return  the fovnum
	 * @since   JDK 1.7
	 */
	public int getFovnum() {
		return fovnum;
	}
	/**
	 * fovnum.
	 *
	 * @param   fovnum the fovnum to set 
	 * @since   JDK 1.7
	 */
	public void setFovnum(int fovnum) {
		this.fovnum = fovnum;
	}
	/**
	 * isCollect.
	 *
	 * @return  the isCollect
	 * @since   JDK 1.7
	 */
	public int getIsCollect() {
		return isCollect;
	}
	/**
	 * isCollect.
	 *
	 * @param   isCollect the isCollect to set 
	 * @since   JDK 1.7
	 */
	public void setIsCollect(int isCollect) {
		this.isCollect = isCollect;
	}
	/**
	 * isZan.
	 *
	 * @return  the isZan
	 * @since   JDK 1.7
	 */
	public int getIsZan() {
		return isZan;
	}
	/**
	 * isZan.
	 *
	 * @param   isZan the isZan to set 
	 * @since   JDK 1.7
	 */
	public void setIsZan(int isZan) {
		this.isZan = isZan;
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
	/**
	 * sampleid.
	 *
	 * @return  the sampleid
	 * @since   JDK 1.7
	 */
	public int getSampleid() {
		return sampleid;
	}
	/**
	 * sampleid.
	 *
	 * @param   sampleid the sampleid to set 
	 * @since   JDK 1.7
	 */
	public void setSampleid(int sampleid) {
		this.sampleid = sampleid;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public String getShareurl() {
		return shareurl;
	}
	public void setShareurl(String shareurl) {
		this.shareurl = shareurl;
	}
	public String getHeadurl() {
		return headurl;
	}
	public void setHeadurl(String headurl) {
		this.headurl = headurl;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
}
