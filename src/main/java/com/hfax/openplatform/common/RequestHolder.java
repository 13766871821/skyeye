package com.hfax.openplatform.common;

import javax.servlet.http.HttpServletRequest;

/**
 * request对象获取工具
 */
public class RequestHolder {

	private static ThreadLocal<HttpServletRequest> requestCache = new ThreadLocal<HttpServletRequest>();

	public static HttpServletRequest getRequest() {
		return RequestHolder.requestCache.get();
	}

	public static void setRequest(HttpServletRequest request) {
		RequestHolder.requestCache.set(request);
	}

	public static void removeRequest() {
		RequestHolder.requestCache.remove();
	}

}
