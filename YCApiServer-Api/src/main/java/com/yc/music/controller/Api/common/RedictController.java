package com.yc.music.controller.Api.common;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.music.common.context.YcContext;
import com.yc.music.common.enums.HttpCodeEnum;
/**
 * 处理所有错误请求，最终返回给app端报文
 * ClassName: RedictController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年4月26日 上午11:31:55 <br/>
 *
 * @author panguixiang
 * @version
 */
@Controller
@RequestMapping("/common/redict")
public class RedictController {
	

	
	@ResponseBody
	@RequestMapping(value="message", method = RequestMethod.GET, produces = "application/json")
	public Map<String,Object> getIndexActivty(@RequestParam("code") Integer code) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put(YcContext.CODE, code);
		resultMap.put(YcContext.MESSAGE, HttpCodeEnum.getName(code));
		resultMap.put(YcContext.DATA,YcContext.EMPTY_STRING);
		return resultMap;
	}
}
