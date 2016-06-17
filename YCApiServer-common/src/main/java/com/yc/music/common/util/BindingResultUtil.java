package com.yc.music.common.util;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

public class BindingResultUtil {

	public static String getBindErrorMsg(BindingResult result) {
		List<ObjectError> list = result.getAllErrors();
		String errMsg="";
		for(ObjectError obj : list) {
			errMsg=obj.getDefaultMessage();
			if(StringUtils.isNotBlank(errMsg)) {
				break; 
			}
		}
		return errMsg;
		
	}
}
