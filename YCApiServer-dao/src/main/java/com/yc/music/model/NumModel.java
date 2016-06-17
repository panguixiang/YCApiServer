/**
 * Project Name:YCApiServer-dao
 * File Name:NumModel.java
 * Package Name:com.yc.music.model
 * Date:2016年5月19日下午1:02:01
 * Copyright (c) 2016 
 *
 */
package com.yc.music.model;

import java.io.Serializable;

/**
 * ClassName: NumModel <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月19日 下午1:02:01 <br/>
 *
 * @author panguixiang
 * @version 
 */
public class NumModel  implements Serializable{

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = -259341782224049972L;
	private long id;//对象id
	private int num;//点赞量，收藏量，评论量等
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
	 * num.
	 *
	 * @return  the num
	 * @since   JDK 1.7
	 */
	public int getNum() {
		return num;
	}
	/**
	 * num.
	 *
	 * @param   num the num to set 
	 * @since   JDK 1.7
	 */
	public void setNum(int num) {
		this.num = num;
	}

	
}
