package com.yc.music.model.musicEvent;

import java.io.Serializable;
import java.util.Date;

/**
 * 活动
 * ClassName: MusicEvent <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月9日 上午11:40:22 <br/>
 *
 * @author panguixiang
 * @version
 */
public class MusicEvent  implements Serializable{

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = 7405326791682493860L;
	private long id;
	private String pic="";
	private String name="";
	private String detail="";
	private int status=1;//1-正在进行，2-已结束,3=未开始
	private String url="";
	private Date begindate;
	private Date enddate;
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
	/**
	 * status.
	 *
	 * @return  the status
	 * @since   JDK 1.7
	 */
	public int getStatus() {
		Date date = new Date();
		if(this.getBegindate()==null) {//1-正在进行，2-已结束,3=未开始
			return 3;
		} else if(this.getEnddate()==null) {
			return 2;
		} else if(this.getBegindate().after(date)) {
			return 3;
		} else if(this.getEnddate().before(date)) {
			return 2;
		}
		else if(this.getBegindate().before(date) && this.getEnddate().after(date)) {
			return 1;
		}
		return this.status;
	}
	/**
	 * status.
	 *
	 * @param   status the status to set 
	 * @since   JDK 1.7
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * url.
	 *
	 * @return  the url
	 * @since   JDK 1.7
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * url.
	 *
	 * @param   url the url to set 
	 * @since   JDK 1.7
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * begindate.
	 *
	 * @return  the begindate
	 * @since   JDK 1.7
	 */
	public Date getBegindate() {
		return begindate;
	}
	/**
	 * begindate.
	 *
	 * @param   begindate the begindate to set 
	 * @since   JDK 1.7
	 */
	public void setBegindate(Date begindate) {
		this.begindate = begindate;
	}
	/**
	 * enddate.
	 *
	 * @return  the enddate
	 * @since   JDK 1.7
	 */
	public Date getEnddate() {
		return enddate;
	}
	/**
	 * enddate.
	 *
	 * @param   enddate the enddate to set 
	 * @since   JDK 1.7
	 */
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	
	
}
