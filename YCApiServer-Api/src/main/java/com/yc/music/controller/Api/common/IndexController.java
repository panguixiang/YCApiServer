package com.yc.music.controller.Api.common;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.music.common.context.YcContext;
import com.yc.music.service.service103.IndexService1003;

/**
 * 首页
 * ClassName: IndexController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月3日 下午4:24:46 <br/>
 *
 * @author panguixiang
 * @version
 */
@Controller
@RequestMapping("/common/index")
public class IndexController {

	private static Logger logger = Logger.getLogger(IndexController.class);
	
	@Autowired
	private IndexService1003 indexService;
	
	@ResponseBody
	@RequestMapping(value="app", method = RequestMethod.GET, produces = "application/json")
	public Map<String,Object> getindex() {
		Map<String,Object> resultMap  = new HashMap<String,Object>();
		try {
			resultMap = indexService.getIndexApp(resultMap);
		} catch (Exception e) {
			resultMap.put(YcContext.CODE, 500);
			resultMap.put(YcContext.MESSAGE, YcContext.SYS_ERROR_MSG);
			resultMap.put(YcContext.DATA,YcContext.EMPTY_STRING);
			logger.error(e);
		}
		return resultMap;
	}
	
}
