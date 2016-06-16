package com.ecan.bean;
/**
* @author zhenhua.chun 
* @version createtime：2016年6月13日 下午5:14:41
* @Description
* 类说明
*/
public class User {
	private String username;
	private String password;
	
	public User(){}
	public User(String username,String password){
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
