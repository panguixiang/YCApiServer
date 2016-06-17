/**
 * Project Name:YCApiServer-dao
 * File Name:LyricsCat.java
 * Package Name:com.yc.music.model.lyricscat
 * Date:2016年5月18日下午7:51:59
 * Copyright (c) 2016 
 *
 */
package com.yc.music.model.lyricscat;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName: LyricsCat <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月18日 下午7:51:59 <br/>
 *
 * @author panguixiang
 * @version 
 */
public class LyricsCat  implements Serializable{

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = 7656028301056709784L;
	private int id;
	private String title="";
	private List<LyricsLib> libArr;
	/**
	 * id.
	 *
	 * @return  the id
	 * @since   JDK 1.7
	 */
	public int getId() {
		return id;
	}
	/**
	 * id.
	 *
	 * @param   id the id to set 
	 * @since   JDK 1.7
	 */
	public void setId(int id) {
		this.id = id;
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
	 * libArr.
	 *
	 * @return  the libArr
	 * @since   JDK 1.7
	 */
	public List<LyricsLib> getLibArr() {
		return libArr;
	}
	/**
	 * libArr.
	 *
	 * @param   libArr the libArr to set 
	 * @since   JDK 1.7
	 */
	public void setLibArr(List<LyricsLib> libArr) {
		this.libArr = libArr;
	}
}
