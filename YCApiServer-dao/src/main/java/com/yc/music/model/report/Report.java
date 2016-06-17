/**
 * Project Name:YCApiServer-dao
 * File Name:Report.java
 * Package Name:com.yc.music.model.report
 * Date:2016年5月19日上午11:37:10
 * Copyright (c) 2016 
 *
 */
package com.yc.music.model.report;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 举报 model
 * ClassName: Report <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月19日 上午11:37:10 <br/>
 *
 * @author panguixiang
 * @version 
 */
public class Report {

	private Long id;
	
	@NotNull(message = "{user.uid.empty}")
	private Long userid;
	
	@NotBlank(message = "{Report.text.empty}")
	private String text;
	
	@NotBlank(message = "{user.phone.empty}")
	@Pattern(regexp = "^((13[0-9])|(15[^4,\\D])|(18[0-9])|(17[0-9])|(147))\\d{8}$", message = "{user.phone.regexp}")
	private String phone;

	/**
	 * id.
	 *
	 * @return  the id
	 * @since   JDK 1.7
	 */
	public Long getId() {
		return id;
	}

	/**
	 * id.
	 *
	 * @param   id the id to set 
	 * @since   JDK 1.7
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * userid.
	 *
	 * @return  the userid
	 * @since   JDK 1.7
	 */
	public Long getUserid() {
		return userid;
	}

	/**
	 * userid.
	 *
	 * @param   userid the userid to set 
	 * @since   JDK 1.7
	 */
	public void setUserid(Long userid) {
		this.userid = userid;
	}

	/**
	 * text.
	 *
	 * @return  the text
	 * @since   JDK 1.7
	 */
	public String getText() {
		return text;
	}

	/**
	 * text.
	 *
	 * @param   text the text to set 
	 * @since   JDK 1.7
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * phone.
	 *
	 * @return  the phone
	 * @since   JDK 1.7
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * phone.
	 *
	 * @param   phone the phone to set 
	 * @since   JDK 1.7
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
