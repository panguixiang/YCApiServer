package com.yc.music.model.musicuser;

import java.io.Serializable;

public class MusicUserVo  implements Serializable{

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = -1492117021324087396L;
	/**
	  * @Fields serialVersionUID : TODO（用一句话描述这个变量表示什么）
	  */
	
	private Long uid;
	private String headurl="";
	private String nickname="";
	private String signature="";//个性签名
	/**
	 * uid.
	 *
	 * @return  the uid
	 * @since   JDK 1.7
	 */
	public Long getUid() {
		return uid;
	}
	/**
	 * uid.
	 *
	 * @param   uid the uid to set 
	 * @since   JDK 1.7
	 */
	public void setUid(Long uid) {
		this.uid = uid;
	}
	/**
	 * headurl.
	 *
	 * @return  the headurl
	 * @since   JDK 1.7
	 */
	public String getHeadurl() {
		return headurl;
	}
	/**
	 * headurl.
	 *
	 * @param   headurl the headurl to set 
	 * @since   JDK 1.7
	 */
	public void setHeadurl(String headurl) {
		this.headurl = headurl;
	}
	/**
	 * nickname.
	 *
	 * @return  the nickname
	 * @since   JDK 1.7
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * nickname.
	 *
	 * @param   nickname the nickname to set 
	 * @since   JDK 1.7
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * signature.
	 *
	 * @return  the signature
	 * @since   JDK 1.7
	 */
	public String getSignature() {
		return signature;
	}
	/**
	 * signature.
	 *
	 * @param   signature the signature to set 
	 * @since   JDK 1.7
	 */
	public void setSignature(String signature) {
		this.signature = signature;
	}
	
}
