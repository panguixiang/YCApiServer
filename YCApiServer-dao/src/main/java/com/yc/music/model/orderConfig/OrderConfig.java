/**
 * Project Name:YCApiServer-dao
 * File Name:OrderConfig.java
 * Package Name:com.yc.music.model.orderConfig
 * Date:2016年5月8日下午3:08:11
 * Copyright (c) 2016 
 *
 */
package com.yc.music.model.orderConfig;

import java.io.Serializable;

/**
 * 排序 配置
 * ClassName: OrderConfig <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月8日 下午3:08:11 <br/>
 *
 * @author panguixiang
 * @version 
 */
public class OrderConfig  implements Serializable{
	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = -163795613042021424L;
	private long id;
	private String orderkey;
	private String ordersql;
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
	 * orderkey.
	 *
	 * @return  the orderkey
	 * @since   JDK 1.7
	 */
	public String getOrderkey() {
		return orderkey;
	}
	/**
	 * orderkey.
	 *
	 * @param   orderkey the orderkey to set 
	 * @since   JDK 1.7
	 */
	public void setOrderkey(String orderkey) {
		this.orderkey = orderkey;
	}
	/**
	 * ordersql.
	 *
	 * @return  the ordersql
	 * @since   JDK 1.7
	 */
	public String getOrdersql() {
		return ordersql;
	}
	/**
	 * ordersql.
	 *
	 * @param   ordersql the ordersql to set 
	 * @since   JDK 1.7
	 */
	public void setOrdersql(String ordersql) {
		this.ordersql = ordersql;
	}
	
}
