package com.hfax.openplatform.common;

import com.hfax.openplatform.config.SpringContextHolder;

/**
 * 常量类：初始化配置文件信息
 */
public class Constants {

	public static final String PASS_KEY = SpringContextHolder.getProperties("passKey");

	public static final String ISAUTHIDENTITY = SpringContextHolder.getProperties("ISAUTHIDENTITY");

	public static final String SUPPORTBANKCARD = SpringContextHolder.getProperties("SUPPORTBANKCARD");

	/**
	 * 默认值
	 */
	public static class DefaultValue {
		public static final String STR_DV = "";
		public static final String CHANNELKEY = "channelId";
		public static final String RETCODE = "retCode";
		public static final String RETMSG = "retMsg";

	}

	public class ServiceCode {
		public static final String S_CODE = "0000";
	}


}
