package com.yc.music.model.musicTuijian;

import java.io.Serializable;

/**
 * 首页推荐model vo
  * @ClassName: MusicTuiJianVo
  * @Description: TODO
  * @author Comsys-panguixiang
  * @date 2016年4月7日 下午6:09:17
  *
 */
public class MusicTuiJianVo implements Serializable{
	
	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = 8901518272459322972L;
	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private long itemid;
	private String status="";//1-歌曲，2-歌词
	private String pic="";
	private String name="";
	private String author="";
	private int looknum;
	private long uid;
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
	 * status.
	 *
	 * @return  the status
	 * @since   JDK 1.7
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * status.
	 *
	 * @param   status the status to set 
	 * @since   JDK 1.7
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * author.
	 *
	 * @return  the author
	 * @since   JDK 1.7
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * author.
	 *
	 * @param   author the author to set 
	 * @since   JDK 1.7
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * looknum.
	 *
	 * @return  the looknum
	 * @since   JDK 1.7
	 */
	public int getLooknum() {
		return looknum;
	}
	/**
	 * looknum.
	 *
	 * @param   looknum the looknum to set 
	 * @since   JDK 1.7
	 */
	public void setLooknum(int looknum) {
		this.looknum = looknum;
	}
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
}
