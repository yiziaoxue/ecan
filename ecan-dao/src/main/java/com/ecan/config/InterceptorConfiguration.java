package com.ecan.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ecan.interceptor.AuthorityInterceptor;

public class InterceptorConfiguration extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 多个拦截器组成一个拦截器链
		// addPathPatterns 用于添加拦截规则
		// excludePathPatterns 用户排除拦截
		registry.addInterceptor((HandlerInterceptor) new AuthorityInterceptor()).addPathPatterns("*Service");
		//registry.addInterceptor((HandlerInterceptor) new AuthorityInterceptor()).addPathPatterns("/**");
		super.addInterceptors(registry);
	}

}
