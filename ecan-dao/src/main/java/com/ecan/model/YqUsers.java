package com.ecan.model;

/**
 * model文件，系统自动生成
 * @author: TaneRoom
 * @date: 2016-07-07 00:08:49
 */
public class YqUsers{
	private Integer usid;	//用户ID
	private String email;	//注册邮箱
	private String password;	//用户密码
	private String flag;	//标志列（关联属性表）


	public Integer getUsid() {
		return usid;
	}

	public void setUsid(Integer usid) {
		this.usid = usid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

}