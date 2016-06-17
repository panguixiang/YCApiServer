package com.yc.music.common.secret;

import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.ArrayUtils;
import com.yc.music.common.context.YcContext;

/**
 * RSA加密解密工具，服务器端使用私钥加密解密，客户端使用公钥加密解密
 * ClassName: RSATools <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年5月5日 下午1:27:10 <br/>
 *
 * @author panguixiang
 * @version
 */
@SuppressWarnings("static-access")
public class RSATools {

	public static RSAPrivateKey privateKey;//私钥服务端用来加密，解密；公钥客户端用来加密解密
	public static RSAPublicKey publicKey; 
	private static String privateKeyStr ="MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAMQgbB4+nreisjTxpn69YqBQklw3scOuBWlf2mNrbjrm3Ott1YuJ/bpGGIifaVXPpC4RaEnCUztxMxhgfVtpzLhnt7V44gfqGWnf9MqJkyGM0lvJp+5CMGS+zixBU5pb8biIq7lb5IVxh0I6JOjq9l7ooP0hsFdovU/cGRoweraRAgMBAAECgYA7sxbWGf+cLFUMkqY4nBNic0Qp9/YPd3BERB4o9zGlklKbA2LmR8nJIr8jD0s0CLGUKE5TbWiChpGkEPL3mXvr+IoZosaVi09lDEDMwnRJJxWetYWbEEDh1dB3tv7Ny0it8vvVbDIo+2FX5Q9zgLJYM41ezl+7h6WVGtY0AHQiVQJBAP1/m9fuRUlnIbkmIexjkWCaCN59juhCAHOCN7832hdExTSc0AMeSv1BFH3Sft9lyovZ7YcF4aohprcvTFLDAy8CQQDGD+FOt588hmOrYlMbNyO3+KaMMwbsPOAlifgIAt8AYveEIeYS9PMzMfn2l0R0y4jNLAzFe1Oayly4TlZ5jnI/AkEArFAFmy23o0GbRsOI46p6s3OA+9vVPENBE0M8qZpJgO+aLT06mCQLTULjrvNakngayh2Eu/dfgcoGDRb1hnxQuQJATdgj96pX3ZP8THnirAmp8j66RtQvXl42wspNP+jQ+PfszHP+V2kKxQ5Zbj/Z2gW9CNbNVji4jVgHxTCU8EW6RQJBANqcjJOPoCNoNAmMiAfRhs/HCrofZZUA9Hwa1mEqFh3Xk0sr3h5QhchSRIj4Cl4HHgt6J/w7dFOSp1OUf4MKqLU=";
	private static String publicKeyStr = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDEIGwePp63orI08aZ+vWKgUJJcN7HDrgVpX9pja2465tzrbdWLif26RhiIn2lVz6QuEWhJwlM7cTMYYH1bacy4Z7e1eOIH6hlp3/TKiZMhjNJbyafuQjBkvs4sQVOaW/G4iKu5W+SFcYdCOiTo6vZe6KD9IbBXaL1P3BkaMHq2kQIDAQAB";
	static {
		  try {  
	            Base64 base64Decoder= new Base64();  
	            byte[] buffer= base64Decoder.decodeBase64(privateKeyStr);  
	            PKCS8EncodedKeySpec keySpec= new PKCS8EncodedKeySpec(buffer);  
	            KeyFactory keyFactory= KeyFactory.getInstance("RSA");  
	            privateKey= (RSAPrivateKey) keyFactory.generatePrivate(keySpec);  
	        } catch (Exception e) {  
	        	e.printStackTrace();
	        }
		  
		  try {  
			  Base64 base64Decoder= new Base64();  
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
			cipher.init(Cipher.ENCRYPT_MODE, privateKey);
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
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
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
		String ss ="QTk3Si8vZ3BxOEpVVG5RYVJubkFJM3ZoQzJ5UTlpWWZIR3NHUGRhRFF6aTVsTXdhMndEbUhTNldDR3I5T2g1Q1FHdDJtYWI3ZHRXY1lpQ04zUDZEZnlFZ3Q3VDNFcC8yTVhyZ3hQaEM0SmVzR1dXWUhydUFUaXRNR25ZcTltRVZ3VVhkY1pyaGxtWXYrVTVQbFpUNTJnV204clozVlpLTDNLYTlCQXdwYUJ4VUwzNXQzcG1xcFFRV1hmYmQ5S1pIOE1GTkk3eUVtcFZmSVUveFVJdnB5RFkya0NndVlndkxRVTQ2QTlaSHRQNXJ0WHhGWHljY054WGxsTGxkck45MFppc2dJck9wdlV1K01lMzNmS0Z3MnpqYUVzeW8wZUo0OTJkVXpvYUJibWpFTnVWSmhyUTR0TmhXcXEvc0lNU3h1Y0huQk1LOFFCbHFKL0t5VEFqY09nPT0=";
		try {
			System.out.println(RSADecode(decodeStr(ss)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
