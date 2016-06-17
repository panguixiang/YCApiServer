package com.yc.music.model.musicWorkList;

import java.io.Serializable;

/**
 * 歌單列表數據
 * ClassName: MusicWorkListVo <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月5日 下午1:38:50 <br/>
 *
 * @author panguixiang
 * @version
 */
public class MusicWorkListVo  implements Serializable{

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = 7629641270626480457L;
	private long itemid;
	private String title="";
	private String author="";
	private String playurl="";
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
	 * playurl.
	 *
	 * @return  the playurl
	 * @since   JDK 1.7
	 */
	public String getPlayurl() {
		return playurl;
	}
	/**
	 * playurl.
	 *
	 * @param   playurl the playurl to set 
	 * @since   JDK 1.7
	 */
	public void setPlayurl(String playurl) {
		this.playurl = playurl;
	}
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
}
