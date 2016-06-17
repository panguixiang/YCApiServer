/**
 * Project Name:YCApiServer-dao
 * File Name:WorkCenter.java
 * Package Name:com.yc.music.model.musicWork
 * Date:2016年5月10日下午2:06:30
 * Copyright (c) 2016 
 *
 */
package com.yc.music.model.musicWork;

import java.io.Serializable;
import java.util.Date;

/**
 * 个人中心 歌曲，歌词
 * ClassName: WorkCenter <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月10日 下午2:06:30 <br/>
 *
 * @author panguixiang
 * @version 
 */
public class WorkCenter  implements Serializable{
	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = -5082644239552210011L;
	private long itemid;
	private String pic="";
	private String title="";
	private int looknum;
	private int fovnum;//收藏量
	private int zannum;//点赞量
	private Date createDate;
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
	 * createDate.
	 *
	 * @return  the createDate
	 * @since   JDK 1.7
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * createDate.
	 *
	 * @param   createDate the createDate to set 
	 * @since   JDK 1.7
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
