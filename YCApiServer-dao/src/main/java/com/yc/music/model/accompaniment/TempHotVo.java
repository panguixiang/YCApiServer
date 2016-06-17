/**
 * Project Name:YCApiServer-dao
 * File Name:TempHotVo.java
 * Package Name:com.yc.music.model.accompaniment
 * Date:2016年5月12日下午4:31:20
 * Copyright (c) 2016 
 *
 */
package com.yc.music.model.accompaniment;

import java.io.Serializable;

/**
 * ClassName: TempHotVo <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月12日 下午4:31:20 <br/>
 *
 * @author panguixiang
 * @version 
 */
public class TempHotVo  implements Serializable{

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = 7125625804310810309L;
	private long id;
	private String pic="";
	private String title="";
	private String author="";
	private String mp3="";
	private int mp3times;
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
	 * mp3.
	 *
	 * @return  the mp3
	 * @since   JDK 1.7
	 */
	public String getMp3() {
		return mp3;
	}
	/**
	 * mp3.
	 *
	 * @param   mp3 the mp3 to set 
	 * @since   JDK 1.7
	 */
	public void setMp3(String mp3) {
		this.mp3 = mp3;
	}
	/**
	 * mp3times.
	 *
	 * @return  the mp3times
	 * @since   JDK 1.7
	 */
	public int getMp3times() {
		return mp3times;
	}
	/**
	 * mp3times.
	 *
	 * @param   mp3times the mp3times to set 
	 * @since   JDK 1.7
	 */
	public void setMp3times(int mp3times) {
		this.mp3times = mp3times;
	}
}
