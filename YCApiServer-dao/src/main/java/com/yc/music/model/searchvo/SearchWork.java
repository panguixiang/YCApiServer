/**
 * Project Name:YCApiServer-dao
 * File Name:SearchMusic.java
 * Package Name:com.yc.music.model.searchvo
 * Date:2016年5月22日下午4:44:44
 * Copyright (c) 2016 
 *
 */
package com.yc.music.model.searchvo;

/**
 * 搜索 music
 * ClassName: SearchWork <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月22日 下午4:44:44 <br/>
 *
 * @author panguixiang
 * @version 
 */
public class SearchWork {

	private long itemid;//歌曲id
	private int looknum;//观看数
	private long uid;//作者id
	private String title="";//标题
	private String author="";//作者名称
	private String pic="";//封面
	private int fovnum;//收藏量
	private int zannum;//点赞量
	private int type=1;//1=歌曲，2=歌词，3=用户
	
	public long getItemid() {
		return itemid;
	}
	public void setItemid(long itemid) {
		this.itemid = itemid;
	}
	public int getLooknum() {
		return looknum;
	}
	public void setLooknum(int looknum) {
		this.looknum = looknum;
	}
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
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
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public int getFovnum() {
		return fovnum;
	}
	public void setFovnum(int fovnum) {
		this.fovnum = fovnum;
	}
	public int getZannum() {
		return zannum;
	}
	public void setZannum(int zannum) {
		this.zannum = zannum;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
}
