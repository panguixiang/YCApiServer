/**
 * Project Name:YCApiServer-dao
 * File Name:MyFovCenter.java
 * Package Name:com.yc.music.model.musicFov
 * Date:2016年5月13日下午6:28:49
 * Copyright (c) 2016 
 *
 */
package com.yc.music.model.musicFov;

import java.io.Serializable;
import java.util.Date;

/**
 * 收藏
 * ClassName: MyFovCenter <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月13日 下午6:28:49 <br/>
 *
 * @author panguixiang
 * @version 
 */
public class MyFovCenter  implements Serializable{

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = 2835014800135671914L;
	private long id;
	private long itemid;//收藏的作品id
	private int type;//1=歌词，2=歌曲
	private Date intabletime;//
	private long user_id;//收藏者的ID
	private long target_uid;//发布作品的用户id
	private String pic="";//作品封面
	private String title="";//作品标题
	private String author="";//作者名称
	private String nickname="";//收藏者用户名称
	private String headerurl="";//收藏者头像
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
	
	public long getItemid() {
		return itemid;
	}
	public void setItemid(long itemid) {
		this.itemid = itemid;
	}
	/**
	 * type.
	 *
	 * @return  the type
	 * @since   JDK 1.7
	 */
	public int getType() {
		return type;
	}
	/**
	 * type.
	 *
	 * @param   type the type to set 
	 * @since   JDK 1.7
	 */
	public void setType(int type) {
		this.type = type;
	}
	/**
	 * intabletime.
	 *
	 * @return  the intabletime
	 * @since   JDK 1.7
	 */
	public Date getIntabletime() {
		return intabletime;
	}
	/**
	 * intabletime.
	 *
	 * @param   intabletime the intabletime to set 
	 * @since   JDK 1.7
	 */
	public void setIntabletime(Date intabletime) {
		this.intabletime = intabletime;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
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
	
}
