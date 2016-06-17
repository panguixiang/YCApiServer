package com.yc.music.common.secret;

import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.ArrayUtils;

import com.alibaba.fastjson.JSONObject;
import com.yc.music.common.context.YcContext;

/**
 * RSA加密解密工具，模拟客户端发送http请求使用
 * ClassName: RSATools <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月5日 下午1:27:10 <br/>
 *
 * @author panguixiang
 * @version
 */
public class RSAToolsClient {

	public static RSAPublicKey publicKey; 
	private static String publicKeyStr = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDEIGwePp63orI08aZ+vWKgUJJcN7HDrgVpX9pja2465tzrbdWLif26RhiIn2lVz6QuEWhJwlM7cTMYYH1bacy4Z7e1eOIH6hlp3/TKiZMhjNJbyafuQjBkvs4sQVOaW/G4iKu5W+SFcYdCOiTo6vZe6KD9IbBXaL1P3BkaMHq2kQIDAQAB";
	static {
		  try {  
			  Base64 base64Decoder= new Base64();  
	            @SuppressWarnings("static-access")
				byte[] buffer= base64Decoder.decodeBase64(publicKeyStr);  
	            KeyFactory keyFactory= KeyFactory.getInstance("RSA");  
	            X509EncodedKeySpec keySpec= new X509EncodedKeySpec(buffer);  
	            publicKey= (RSAPublicKey) keyFactory.generatePublic(keySpec);  
	        } catch (Exception e) {  
	        } 
	}

	/**
	 * 加密字符串=RSA(报文体)
	 * 
	 * @param Key
	 *            RSA公钥，私钥 对象
	 * @param data
	 *            报文体
	 * @return
	 * @throws NoSuchPaddingException
	 * @throws Exception
	 */
	public static String RSAENcode(String dataStr) throws Exception {
		byte[] data;
			data = dataStr.getBytes(YcContext.ENCODE_UTF8);
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			byte[] dataReturn = null;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < data.length; i += 100) {
				byte[] doFinal = cipher.doFinal(ArrayUtils.subarray(data, i, i + 100));
				sb.append(new String(doFinal));
				dataReturn = ArrayUtils.addAll(dataReturn, doFinal);
			}
			Base64 base64 = new Base64();
			return base64.encodeAsString(dataReturn);
	}

	/**
	 * 解密字符串=RSA(报文体)
	 * 
	 * @param Key
	 *            RSA公钥，私钥 对象
	 * @param data
	 *            报文体
	 * @param encrypt
	 *            1 加密 0解密
	 * @return
	 * @throws NoSuchPaddingException
	 * @throws Exception
	 */
	public static String RSADecode(String dataStr) throws Exception {
		byte[] data;
			data = dataStr.getBytes(YcContext.ENCODE_UTF8);
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			Base64 base64 = new Base64();
			cipher.init(Cipher.DECRYPT_MODE, publicKey);
			data = base64.decode(data);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < data.length; i += 128) {
				byte[] doFinal = cipher.doFinal(ArrayUtils.subarray(data, i, i + 128));
				sb.append(new String(doFinal));
			}
			return sb.toString();
	}

	public static String encodeStr(String plainText) throws Exception{
		byte[] b = plainText.getBytes("UTF-8");
		Base64 base64 = new Base64();
		b = base64.encode(b);
		String s = new String(b);
		return s;
	}

	public static String decodeStr(String encodeStr)  throws Exception{
		byte[] b = encodeStr.getBytes("UTF-8");
		Base64 base64 = new Base64();
		b = base64.decode(b);
		String s = new String(b);
		return s;
	}

	public static void main(String args[]) {
	/*	String entr ="WGpUVEFYWU1QK3BhNExLWWorRHlFakNyN2JqODJhWm1ySlFvRlArRCtZQWhBRUZNbnM4dDQ2cW9Oa2VRdkVvR1JYVzJHbG92aFR3STlFT2lxb2NCY1ZoTjVhcU1hbmlEcDZzSUJDSEJraU5iZGVGZlh2Z0RXY1dvOTc0VTk1WFBDd0pOVXZKRUN4Yll5TkdEMGFkRW1vSVlPN0RVd0dFT2s3TXJIaGlWbFEwNEZYSy9CMENDak5SMGt6R2ZhRmQ1Q0JQOWlDcFM4d1ZoQWRFeWg4ZDlsbkg1Tjlrelk1emtwTFBUbEpjMG85SFA2a0VTQkZ0TGZab3BxbWduTE14NFBOWVBCeVhCTXF3cjBoYjRFalhKeS81cm1vQnhyZGN6aVMzZUNnc3N3RW1uZmh1N1d6YWc5VjlXUXgrLzBXdW90Qmk0TlpqOTF2N1JLWStRc1czaU1HalkzYStWWTZrVURwWndZbldPNW9sZjNvNllIVG1MajRMMkF4Sk1LRldjMnRhTzBjNXpYaElKTVRQN1pJbHUzaG52WVJlN2Yzd3AzQkdXZUZFbzZCN0lOSDNlMDIwdWxpeTN6Y1lkNGtwNUtMMEFuS0ZqcG1VNzB0eXRJZHRlcDFleGFVdlQ2aDRHUFd6eS9TY2dCMDhhVlBnWFh2ZGdWZ0FjRW9FS0tzdHE=";
		try {
			String tr = RSADecode(decodeStr(entr));
			System.out.println(tr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		Map<String,String> data = new HashMap<String,String>();
		data.put("token", "323223");
		try {
			String dd= encodeStr(RSAENcode(JSONObject.toJSONString(data)));
			System.out.println(dd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
