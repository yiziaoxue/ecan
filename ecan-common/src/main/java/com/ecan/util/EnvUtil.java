package com.ecan.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取web环境相关信息
 * @author TaneRoom
 * @since 2016-07-30 21:54:00
 */
public class EnvUtil {

	private EnvUtil(){}
	
	private static EnvUtil instance;
	
	public static EnvUtil getInstance(){
		if(instance == null){
			synchronized (instance) {
				if(instance == null){
					instance = new EnvUtil();
				}
			}
		}
		return instance;
	}
	
	private HttpServletRequest request;
	private HttpServletResponse response;

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	
	
}
