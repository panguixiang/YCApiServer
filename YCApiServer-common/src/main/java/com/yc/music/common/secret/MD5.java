package com.yc.music.common.secret;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5 {
	
	private final String md5_key="@384!y32iN892chao*7Y";

	public String entryMd5(String data) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(data).append(md5_key);
		return DigestUtils.md5Hex(buffer.toString());
	}
	
}
