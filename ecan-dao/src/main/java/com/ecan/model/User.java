package com.ecan.model;
/** 
 * 测试一下，数据库对应的模型
 * @author :TaneRoom
 * @date 创建时间：2016年6月21日 下午2:22:31 
 * @version 1.0 
 */
public class User {

	private Integer usid;
	private String email;
	private String password;
	private String flag;

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
