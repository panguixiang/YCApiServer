package com.yc.music.model.musicLyrics;

import java.io.Serializable;

public class Lyrics  implements Serializable{

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = 5800918850530892870L;
	private long itemid;
	private String pic="";
	private String title="";
	private String author="";
	private int looknum;
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
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	
	
}
