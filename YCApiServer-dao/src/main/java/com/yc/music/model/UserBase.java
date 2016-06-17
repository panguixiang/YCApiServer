package com.yc.music.model;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.yc.music.common.context.YcContext;
/**
 * 密码重置model
 * @author panguixiang
 *
 */
public class UserBase implements Serializable{

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = 7307107376149954526L;

	private Long userid;
	
	@NotBlank(message = "{user.phone.empty}")
	@Pattern(regexp = YcContext.Mobile_PARTTEN, message = "{user.phone.regexp}")
	private String phone;
	
	@NotBlank(message = "{user.password.empty}")
	private String password;
	
	@NotBlank(message = "{user.code.empty}")
	private String code;
	
	@NotBlank(message = "{user.repassword.empty}")
	private String repassword;

	
	
	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	
	public static void main(String args[]) {
		
	}
}
