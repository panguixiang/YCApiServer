/**
 * Project Name:YCApiServer-dao
 * File Name:ServiceAopLog.java
 * Package Name:com.yc.music.model.aop
 * Date:2016年4月26日下午2:04:46
 * Copyright (c) 2016 
 *
 */
package com.yc.music.model.aop;

/**
 * ClassName: ServiceAopLog <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年4月26日 下午2:04:46 <br/>
 *
 * @author panguixiang
 * @version 
 */
public class ServiceAopLog {
	
	private long id;

	private String actionFullName="";//action全名
	
	private  String params="";//action请求参数,字符串集合格式
	
	private  String returnData="";//action返回参数，json字符串格式，可为空字符串
	
	private String exceptionMsg="";//异常信息
	
	private String createDate="";
	
	private int code=200;//200正常执行，500异常执行

	/**
	 * actionFullName.
	 *
	 * @return  the actionFullName
	 * @since   JDK 1.7
	 */
	public String getActionFullName() {
		return actionFullName;
	}

	/**
	 * actionFullName.
	 *
	 * @param   actionFullName the actionFullName to set 
	 * @since   JDK 1.7
	 */
	public void setActionFullName(String actionFullName) {
		this.actionFullName = actionFullName;
	}

	/**
	 * params.
	 *
	 * @return  the params
	 * @since   JDK 1.7
	 */
	public String getParams() {
		return params;
	}

	/**
	 * params.
	 *
	 * @param   params the params to set 
	 * @since   JDK 1.7
	 */
	public void setParams(String params) {
		this.params = params;
	}

	/**
	 * returnData.
	 *
	 * @return  the returnData
	 * @since   JDK 1.7
	 */
	public String getReturnData() {
		return returnData;
	}

	/**
	 * returnData.
	 *
	 * @param   returnData the returnData to set 
	 * @since   JDK 1.7
	 */
	public void setReturnData(String returnData) {
		this.returnData = returnData;
	}

	/**
	 * exceptionMsg.
	 *
	 * @return  the exceptionMsg
	 * @since   JDK 1.7
	 */
	public String getExceptionMsg() {
		return exceptionMsg;
	}

	/**
	 * exceptionMsg.
	 *
	 * @param   exceptionMsg the exceptionMsg to set 
	 * @since   JDK 1.7
	 */
	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

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
	 * createDate.
	 *
	 * @return  the createDate
	 * @since   JDK 1.7
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * createDate.
	 *
	 * @param   createDate the createDate to set 
	 * @since   JDK 1.7
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	/**
	 * code.
	 *
	 * @return  the code
	 * @since   JDK 1.7
	 */
	public int getCode() {
		return code;
	}

	/**
	 * code.
	 *
	 * @param   code the code to set 
	 * @since   JDK 1.7
	 */
	public void setCode(int code) {
		this.code = code;
	}
	
}
