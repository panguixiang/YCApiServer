/**
 * Project Name:YCApiServer-dao
 * File Name:TunningLog.java
 * Package Name:com.yc.music.model.tunning
 * Date:2016年5月27日下午1:23:55
 * Copyright (c) 2016 
 *
 */
package com.yc.music.model.tunning;

/**
 * ClassName: TunningLog <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月27日 下午1:23:55 <br/>
 *
 * @author panguixiang
 * @version 
 */
public class TunningLog {

	 private long uid;
	 private String basemusic;//原声文件路径
	 private String hotempmusic;//伴奏文件路径
	 private String tunningmusic;//合成后的文件路径
	 
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	public String getBasemusic() {
		return basemusic;
	}
	public void setBasemusic(String basemusic) {
		this.basemusic = basemusic;
	}
	public String getHotempmusic() {
		return hotempmusic;
	}
	public void setHotempmusic(String hotempmusic) {
		this.hotempmusic = hotempmusic;
	}
	public String getTunningmusic() {
		return tunningmusic;
	}
	public void setTunningmusic(String tunningmusic) {
		this.tunningmusic = tunningmusic;
	}
	 
}
