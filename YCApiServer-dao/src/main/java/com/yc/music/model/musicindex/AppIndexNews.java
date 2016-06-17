/**
 * Project Name:YCApiServer-dao
 * File Name:AppIndexNews.java
 * Package Name:com.yc.music.model.musicindex
 * Date:2016年5月19日下午5:29:38
 * Copyright (c) 2016 
 *
 */
package com.yc.music.model.musicindex;

import java.io.Serializable;

/**
 * ClassName: AppIndexNews <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月19日 下午5:29:38 <br/>
 *
 * @author panguixiang
 * @version 
 */
public class AppIndexNews implements Serializable{

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = 7533807859528501421L;
	private long itemid;
	private int status;
	private String author="";
	private int looknum;
	private String name="";
	private String pic="";
	private long uid;//作者id
	
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
	 * name.
	 *
	 * @return  the name
	 * @since   JDK 1.7
	 */
	public String getName() {
		return name;
	}
	/**
	 * name.
	 *
	 * @param   name the name to set 
	 * @since   JDK 1.7
	 */
	public void setName(String name) {
		this.name = name;
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
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	
}
