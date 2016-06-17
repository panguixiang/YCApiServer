/**
 * Project Name:YCApiServer-dao
 * File Name:HotVo.java
 * Package Name:com.yc.music.model.accompaniment
 * Date:2016年5月18日下午7:06:12
 * Copyright (c) 2016 
 *
 */
package com.yc.music.model.accompaniment;

import java.io.Serializable;

/**
 * ClassName: HotVo <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月18日 下午7:06:12 <br/>
 *
 * @author panguixiang
 * @version 
 */
public class HotVo  implements Serializable{
	
	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = 6511282881054485395L;
	private long id;
	private String mp3="";
	
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
	
}
