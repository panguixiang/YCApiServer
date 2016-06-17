/**
 * Project Name:YCApiServer-dao
 * File Name:ZanCenterVo.java
 * Package Name:com.yc.music.model.workzan
 * Date:2016年5月13日下午5:39:58
 * Copyright (c) 2016 
 *
 */
package com.yc.music.model.workzan;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName: ZanCenterVo <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月13日 下午5:39:58 <br/>
 *
 * @author panguixiang
 * @version 
 */
public class ZanCenterVo  implements Serializable{
	 /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = -3746391582570901472L;
	private long id;//点赞记录id
	 private long itemid;//作品id
	 private int type;//1=歌曲，2=歌词
	 private Date add_time;
	 private long user_id;//点赞者的用户id
	 private long target_uid;//被点赞者的用户id
	 private String pic="";//作品封面
	 private String title="";//作品标题
	 private String author=""; //作品作者名称
	 private String nickname="";//点赞者用户名称
	 private String headerurl="";//点赞者用户头像地址
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Date getAdd_time() {
		return add_time;
	}
	public void setAdd_time(Date add_time) {
		this.add_time = add_time;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
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
}
