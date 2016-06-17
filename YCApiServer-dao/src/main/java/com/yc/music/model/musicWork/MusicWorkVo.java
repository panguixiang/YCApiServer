package com.yc.music.model.musicWork;

import java.util.Date;

public class MusicWorkVo extends MusicWork {

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = 5741713204040580299L;
	private int fovnum;//收藏量
	private int zannum;//点赞量
	private Date createDate;
	/**
	 * fovnum.
	 *
	 * @return  the fovnum
	 * @since   JDK 1.7
	 */
	public int getFovnum() {
		return fovnum;
	}
	/**
	 * fovnum.
	 *
	 * @param   fovnum the fovnum to set 
	 * @since   JDK 1.7
	 */
	public void setFovnum(int fovnum) {
		this.fovnum = fovnum;
	}
	/**
	 * zannum.
	 *
	 * @return  the zannum
	 * @since   JDK 1.7
	 */
	public int getZannum() {
		return zannum;
	}
	/**
	 * zannum.
	 *
	 * @param   zannum the zannum to set 
	 * @since   JDK 1.7
	 */
	public void setZannum(int zannum) {
		this.zannum = zannum;
	}
	/**
	 * createDate.
	 *
	 * @return  the createDate
	 * @since   JDK 1.7
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * createDate.
	 *
	 * @param   createDate the createDate to set 
	 * @since   JDK 1.7
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
