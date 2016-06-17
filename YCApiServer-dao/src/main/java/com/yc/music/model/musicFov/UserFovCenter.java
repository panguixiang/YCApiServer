/**
 * Project Name:YCApiServer-dao
 * File Name:WorkFovCenter.java
 * Package Name:com.yc.music.model.musicFov
 * Date:2016年5月10日下午5:56:51
 * Copyright (c) 2016 
 *
 */
package com.yc.music.model.musicFov;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户收藏列表（歌词，歌曲）
 * ClassName: UserFovCenter <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月10日 下午5:56:51 <br/>
 *
 * @author panguixiang
 * @version 
 */
public class UserFovCenter  implements Serializable{

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = 4471569345624813093L;
	private long id;//收藏记录主键ID
	private long itemid;//作品ID
	private String pic="";
	private String title="";
	private int looknum;
	private int fovnum;//收藏量
	private int zannum;//点赞量
	private int type;//1=歌曲，2=歌词
	private Date intabletime;
	private long uid;
	private String author="";
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * looknum.
	 *
	 * @return  the looknum
	 * @since   JDK 1.7
	 */
	public int getLooknum() {
		return looknum;
	}
	/**
	 * looknum.
	 *
	 * @param   looknum the looknum to set 
	 * @since   JDK 1.7
	 */
	public void setLooknum(int looknum) {
		this.looknum = looknum;
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
	
	
}
