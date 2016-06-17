/**
 * Project Name:YCApiServer-Api
 * File Name:AppResultConstant.java
 * Package Name:com.yc.music.context
 * Date:2016年5月5日下午2:17:44
 * Copyright (c) 2016 
 *
 */
package com.yc.music.context;

/**
 * ClassName: AppResultConstant <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月5日 下午2:17:44 <br/>
 *
 * @author panguixiang
 * @version 
 */
public class AppResultConstant {
	/**
	 * app index 接口
	 */
	public final static String bannerList="bannerList";
	public final static String mTuijianList="mTuijianList";
	public final static String recommendsonglist="recommendsonglist";
	public final static String yueshuoList="yueshuoList";
	
	public final static String RED_LIST="redList";
	
	public final static String NEW_LIST="newList";
	
	/**
	 * 歌单 歌曲列表 接口
	 */
	public final static String recommedSong="recommedSong";
	public final static String workList="workList";
	public final static String workCount="workCount";
	
	/**
	 * 七牛相关
	 * ClassName: WorkOpenModelEnum <br/>
	 * @author panguixiang
	 * @version AppResultConstant
	 */
	
	public final static String domain_qiliu="domain_qiliu";
	
	public static enum WorkOpenModelEnum{  
		tuijian,gedan,yueshuo,red,news,homepage,myfov,myzan;
	}
}
