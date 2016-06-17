package com.yc.music.common.enums;
/**
 * 枚举
 * ClassName: HttpCodeEnum <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年4月26日 上午11:04:49 <br/>
 *
 * @author panguixiang
 * @version
 */
public enum HttpCodeEnum {
	
	DATE_NULL(50001,"请求参数为空"),
	TOKEN_NULL(53000,"token不能为空"),
	REQUEST_OFTEN(53002,"请求过于频繁"),
	TOKEN_ERROR(53001,"token错误,或已失效"),
	SYS_ERROR(50000,"系统繁忙"),
	DATE_SEC_ERROR(53003,"解密失败");
	
    // 成员变量
    private String name;
    private int code;

    // 构造方法
    private HttpCodeEnum(int code,String name) {
        this.name = name;
        this.code = code;
    }

	public static String getName(int code) {
		for (HttpCodeEnum c : HttpCodeEnum.values()) {
            if (c.getCode() == code) {
                return c.name;
            }
        }
		return "";
	}

	public String getName() {
		return name;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
    
}
