/**
 * Project Name:YCApiServer-dao
 * File Name:MyCommentCenter.java
 * Package Name:com.yc.music.model.musicComment
 * Date:2016年5月13日下午5:02:39
 * Copyright (c) 2016 
 *
 */
package com.yc.music.model.comment;

import java.io.Serializable;
import java.util.Date;
/**
 * 消息中心 消息列表
 * ClassName: MyCommentCenter <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月13日 下午5:02:39 <br/>
 *
 * @author panguixiang
 * @version 
 */
public class MyCommentCenter  implements Serializable{

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = -8799558651689854735L;
	private long id;//评论记录id
	private long itemid;//评论的作品id
	private long authorid;//作者id
	private int type;//1=歌曲，2=歌词
	private Date createdate;//评论记录创建时间
	private long uid;//发评论的用户id
	private long target_uid;//被评论的用户id
	private String pic="";//作品图片地址
	private String title="";//作品标题
	private String author="";//作者名称
	private int comment_type;//1=默认，2=跟帖
	private String comment="";//评论内容
	private String nickname="";//发评论者用户名称
	private String headerurl="";//发评论者用户头像地址
	private String targetname="";//被评论者用户名称
	private String targetHeader="";//被评论者用户头像地址
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getItemid() {
		return itemid;
	}
	public void setItemid(long itemid) {
		this.itemid = itemid;
	}
	public long getAuthorid() {
		return authorid;
	}
	public void setAuthorid(long authorid) {
		this.authorid = authorid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	public long getTarget_uid() {
		return target_uid;
	}
	public void setTarget_uid(long target_uid) {
		this.target_uid = target_uid;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getComment_type() {
		return comment_type;
	}
	public void setComment_type(int comment_type) {
		this.comment_type = comment_type;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getHeaderurl() {
		return headerurl;
	}
	public void setHeaderurl(String headerurl) {
		this.headerurl = headerurl;
	}
	public String getTargetname() {
		return targetname;
	}
	public void setTargetname(String targetname) {
		this.targetname = targetname;
	}
	public String getTargetHeader() {
		return targetHeader;
	}
	public void setTargetHeader(String targetHeader) {
		this.targetHeader = targetHeader;
	}
}
