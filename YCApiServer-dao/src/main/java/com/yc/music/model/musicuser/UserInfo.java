/**
 * Project Name:YCApiServer-dao
 * File Name:UserInfo.java
 * Package Name:com.yc.music.model.musicuser
 * Date:2016年5月13日上午9:19:44
 * Copyright (c) 2016 
 *
 */
package com.yc.music.model.musicuser;

/**
 * ClassName: UserInfo <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月13日 上午9:19:44 <br/>
 *
 * @author panguixiang
 * @version 
 */
public class UserInfo extends MusicUserVo{

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = 3399873356782594059L;
	private Integer sex;
	private String birthday;
	
	/**
	 * sex.
	 *
	 * @return  the sex
	 * @since   JDK 1.7
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * sex.
	 *
	 * @param   sex the sex to set 
	 * @since   JDK 1.7
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * birthday.
	 *
	 * @return  the birthday
	 * @since   JDK 1.7
	 */
	public String getBirthday() {
		return birthday;
	}
	/**
	 * birthday.
	 *
	 * @param   birthday the birthday to set 
	 * @since   JDK 1.7
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
}
