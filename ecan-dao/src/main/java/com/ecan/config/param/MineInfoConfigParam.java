package com.ecan.config.param;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
* @author zhenhua.chun 
* @version createtime：2016年6月13日 下午5:25:36
* @Description
* 类说明
*/
@ConfigurationProperties(prefix="my")
public class MineInfoConfigParam {
	private String name;
	private String password;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
