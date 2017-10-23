package com.hfax.openplatform.listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.MDC;

import com.hfax.openplatform.common.RequestHolder;

@WebListener
public class RequestListener implements ServletRequestListener {

	private final String userFlagKey = "userFlagKey";

	/**
	 * 在请求监听中,向日志中加入用户ip和sessionId
	 */
	@Override
	public void requestInitialized(ServletRequestEvent requestEvent) {
		HttpServletRequest request = (HttpServletRequest) requestEvent.getServletRequest();
		RequestHolder.setRequest(request);
		String address = getRequestIp(request);// 放ip地址
		HttpSession hs = request.getSession();
		// hs.setAttribute("_requestURI", request.getRequestURI());
		String sessionId = hs.getId();// 放SessionId
		String userFlag = "[" + address + ":" + sessionId + "]";
		MDC.put(userFlagKey, userFlag);
	}

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		MDC.remove(userFlagKey);
		RequestHolder.removeRequest();
	}

	/**
	 * 获取客户端请求的IP地址
	 * 
	 * @param request
	 */
	public String getRequestIp(HttpServletRequest request) {
		String ip = request.getHeader("X-Real-IP");

		if ((ip == null) || (ip.length() == 0) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("x-forwarded-for");
		}
		if ((ip == null) || (ip.length() == 0) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if ((ip == null) || (ip.length() == 0) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if ((ip == null) || (ip.length() == 0) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
	}

}
