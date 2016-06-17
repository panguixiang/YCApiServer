/**
 * Project Name:YCApiServer-common
 * File Name:BCDXTest.java
 * Package Name:com.yc.music.common.sms
 * Date:2016年6月3日上午9:51:47
 * Copyright (c) 2016 
 *
 */
package com.yc.music.common.sms;

/**
 * ClassName: BCDXTest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年6月3日 上午9:51:47 <br/>
 *
 * @author panguixiang
 * @version 
 */
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.OpenSmsSendmsgRequest;
import com.taobao.api.request.OpenSmsSendvercodeRequest;
import com.taobao.api.request.OpenSmsSendvercodeRequest.SendVerCodeRequest;
import com.taobao.api.response.OpenSmsSendvercodeResponse;
import com.taobao.api.request.OpenSmsSendmsgRequest.SendMessageRequest;
import com.taobao.api.response.OpenSmsSendmsgResponse;

public class SendSmsUtils {
	private static String appkey = "23298847";
	private static String url = "http://gw.api.taobao.com/router/rest";// api请求地址

	/**
	 * 
	 * sendSmSCode:(发送短信验证码). <br/> 
	 *
	 * @author panguixiang
	 * @param templateId
	 * @param mobile
	 * @param code
	 * @return
	 * @throws ApiException
	 * @since JDK 1.7
	 */
	public static boolean sendSmSCode(Long templateId, String mobile,String secret, String code) throws Exception {
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		OpenSmsSendvercodeRequest req = new OpenSmsSendvercodeRequest();
		// 对象
		SendVerCodeRequest sendVerCodeRequest = new SendVerCodeRequest();
		sendVerCodeRequest.setTemplateId(templateId);// 填写自己的模板id 290902781L
		sendVerCodeRequest.setSignatureId(1323L);// 填写自己的签名id，注意于应用对应
		sendVerCodeRequest.setMobile(mobile);// 填写真实的手机号
		sendVerCodeRequest.setContextString("{\"code\":\"" + code + "\"}");// 模板中的参数赋值
		req.setSendVerCodeRequest(sendVerCodeRequest);
		OpenSmsSendvercodeResponse response = client.execute(req);
		System.out.println(response.getBody());
		if (response.isSuccess()) {// api请求成功
			response.getResult().getMessage();
			response.getResult().getSuccessful();
			return true;
		} else {
			response.getResult().getMessage();
			response.getResult().getSuccessful();
			return false;
		}
	}

	/**
	 * 
	 * sendSmSText:(发送自定义模板文本短信). <br/> 
	 *
	 * @author panguixiang
	 * @param templateId
	 * @param mobile
	 * @param contextJSONStr
	 * @return
	 * @throws ApiException
	 * @since JDK 1.7
	 */
	public static boolean sendSmSText(Long templateId, String mobile,String secret,String contextJSONStr) throws ApiException {
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		OpenSmsSendmsgRequest req = new OpenSmsSendmsgRequest();
		// 对象
		SendMessageRequest sendMessageRequest = new SendMessageRequest();
		sendMessageRequest.setTemplateId(templateId);// 模板ID
		sendMessageRequest.setSignatureId(1323L);// 签名id
		sendMessageRequest.setContextString(contextJSONStr); // 模板中的变量通过Context传递
		sendMessageRequest.setMobile(mobile);
		req.setSendMessageRequest(sendMessageRequest);
		OpenSmsSendmsgResponse response = client.execute(req);
		System.out.println(response.getBody());
		if (response.isSuccess()) {
			response.getResult().getMessage();
			response.getResult().getSuccessful();
		} else {
			response.getResult().getMessage();
			response.getResult().getSuccessful();
		}
		return true;
	}
}
