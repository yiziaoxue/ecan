package com.ecan.model;

/**
 * model文件，系统自动生成
 * @author: TaneRoom
 * @since: 2016-11-29 22:20:37
 */
public class VmanPerm{
	private Integer peid;	//权限动作ID
	private String permname;	//权限动作名称
	private String perm;	//权限动作字符串
	private String url;	//URL
	private Integer funcid;	//功能
	private Integer permcolumnid;	//动作分栏id(关联permcolumn表)
	private Integer viewmode;	//是否可见


	public Integer getPeid() {
		return peid;
	}

	public void setPeid(Integer peid) {
		this.peid = peid;
	}

	public String getPermname() {
		return permname;
	}

	public void setPermname(String permname) {
		this.permname = permname;
	}

	public String getPerm() {
		return perm;
	}

	public void setPerm(String perm) {
		this.perm = perm;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getFuncid() {
		return funcid;
	}

	public void setFuncid(Integer funcid) {
		this.funcid = funcid;
	}

	public Integer getPermcolumnid() {
		return permcolumnid;
	}

	public void setPermcolumnid(Integer permcolumnid) {
		this.permcolumnid = permcolumnid;
	}

	public Integer getViewmode() {
		return viewmode;
	}

	public void setViewmode(Integer viewmode) {
		this.viewmode = viewmode;
	}

}