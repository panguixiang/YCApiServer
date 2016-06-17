/**
 * Project Name:YCApiServer-dao
 * File Name:RecommedSongIndex.java
 * Package Name:com.yc.music.model.musRecomSongs
 * Date:2016年5月3日下午6:48:24
 * Copyright (c) 2016 
 *
 */
package com.yc.music.model.musRecomSongs;

import java.io.Serializable;

/**
 * app 首页歌单列表使用
 * ClassName: RecommedSong <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月3日 下午6:48:24 <br/>
 *
 * @author panguixiang
 * @version 
 */
public class RecommedSong  implements Serializable{

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = -2345271615383422866L;
	private long id;
	private String name="";
	private String pic="";
	private String detail="";//歌单备注
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
	/**
	 * detail.
	 *
	 * @return  the detail
	 * @since   JDK 1.7
	 */
	public String getDetail() {
		return detail;
	}
	/**
	 * detail.
	 *
	 * @param   detail the detail to set 
	 * @since   JDK 1.7
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}
}
