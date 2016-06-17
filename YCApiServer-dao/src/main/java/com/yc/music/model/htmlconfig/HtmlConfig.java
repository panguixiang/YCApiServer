package com.yc.music.model.htmlconfig;

import java.io.Serializable;
/**
 * html配置
 * @author panguixiang
 *
 */
public class HtmlConfig implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4842870024321429443L;
	
	private long id;
	private String url;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
