package com.yc.music.model;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 平台用户注册表
 * 
 * @author panguixiang
 *
 */
public class User extends UserBase{

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = -5357344017412195223L;


	@NotBlank(message="{user.nickname.empty}")
	private String name="";
	
	
	private String bgpic;
	private String email="";
	private String descr="";
	private String qqopenid="";
	private String weixinopenid="";
	private String weiboopenid="";
	private Date regtime;
	
	private String regtype="";

	private String headurl="";
	
	private Integer sex;
	private String birthday="";
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBgpic() {
		return bgpic;
	}

	public void setBgpic(String bgpic) {
		this.bgpic = bgpic;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getQqopenid() {
		return qqopenid;
	}

	public void setQqopenid(String qqopenid) {
		this.qqopenid = qqopenid;
	}

	public String getWeixinopenid() {
		return weixinopenid;
	}

	public void setWeixinopenid(String weixinopenid) {
		this.weixinopenid = weixinopenid;
	}

	public String getWeiboopenid() {
		return weiboopenid;
	}

	public void setWeiboopenid(String weiboopenid) {
		this.weiboopenid = weiboopenid;
	}

	public Date getRegtime() {
		return regtime;
	}

	public void setRegtime(Date regtime) {
		this.regtime = regtime;
	}

	public String getRegtype() {
		return regtype;
	}

	public void setRegtype(String regtype) {
		this.regtype = regtype;
	}

	public String getHeadurl() {
		return headurl;
	}

	public void setHeadurl(String headurl) {
		this.headurl = headurl;
	}

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
