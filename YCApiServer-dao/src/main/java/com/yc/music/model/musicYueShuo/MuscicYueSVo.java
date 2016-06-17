package com.yc.music.model.musicYueShuo;

import java.io.Serializable;

/**
 * 乐说
 * ClassName: MuscicYueSVo <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月5日 上午9:44:31 <br/>
 *
 * @author panguixiang
 * @version
 */
public class MuscicYueSVo  implements Serializable{

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = -7790579419219451409L;
	private long itemid;//如果为web则为0
	private String pic="";
	private String detail="";
	private String name="";
	private String url="";//mp3地址或web页面地址
	private int type;//1=mp3,2=web，wap页面
	/**
	 * itemid.
	 *
	 * @return  the itemid
	 * @since   JDK 1.7
	 */
	public long getItemid() {
		return itemid;
	}
	/**
	 * itemid.
	 *
	 * @param   itemid the itemid to set 
	 * @since   JDK 1.7
	 */
	public void setItemid(long itemid) {
		this.itemid = itemid;
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
	 * type.
	 *
	 * @return  the type
	 * @since   JDK 1.7
	 */
	public int getType() {
		return type;
	}
	/**
	 * type.
	 *
	 * @param   type the type to set 
	 * @since   JDK 1.7
	 */
	public void setType(int type) {
		this.type = type;
	}
	
	
	
	
	
}
