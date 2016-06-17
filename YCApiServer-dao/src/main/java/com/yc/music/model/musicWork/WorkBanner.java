/**
 * Project Name:YCApiServer-dao
 * File Name:WorkBanner.java
 * Package Name:com.yc.music.model.musicWork
 * Date:2016年5月3日下午4:54:02
 * Copyright (c) 2016 
 *
 */
package com.yc.music.model.musicWork;

/**
 * ClassName: WorkBanner <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月3日 下午4:54:02 <br/>
 *
 * @author panguixiang
 * @version 
 */
public class WorkBanner {

	private long itemid;
	private String pic="";
	private String playurl="";
	private String recommpic;
	private int type=0;//0歌曲，1=web
	
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
	 * playurl.
	 *
	 * @return  the playurl
	 * @since   JDK 1.7
	 */
	public String getPlayurl() {
		return playurl;
	}
	/**
	 * playurl.
	 *
	 * @param   playurl the playurl to set 
	 * @since   JDK 1.7
	 */
	public void setPlayurl(String playurl) {
		this.playurl = playurl;
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
	 * recommpic.
	 *
	 * @return  the recommpic
	 * @since   JDK 1.7
	 */
	public String getRecommpic() {
		return recommpic;
	}
	/**
	 * recommpic.
	 *
	 * @param   recommpic the recommpic to set 
	 * @since   JDK 1.7
	 */
	public void setRecommpic(String recommpic) {
		this.recommpic = recommpic;
	}
	
}
