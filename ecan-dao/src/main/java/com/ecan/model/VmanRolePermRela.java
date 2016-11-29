package com.ecan.model;
import java.util.Date;

/**
 * model文件，系统自动生成
 * @author: TaneRoom
 * @since: 2016-11-29 22:20:41
 */
public class VmanRolePermRela{
	private Integer rprid;	//权限角色动作关系ID
	private Integer permid;	//权限动作ID
	private Integer roleid;	//权限角色ID
	private Integer createrid;	//创建者ID
	private String creatername;	//创建者名称
	private Date createdate;	//创建时间


	public Integer getRprid() {
		return rprid;
	}

	public void setRprid(Integer rprid) {
		this.rprid = rprid;
	}

	public Integer getPermid() {
		return permid;
	}

	public void setPermid(Integer permid) {
		this.permid = permid;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public Integer getCreaterid() {
		return createrid;
	}

	public void setCreaterid(Integer createrid) {
		this.createrid = createrid;
	}

	public String getCreatername() {
		return creatername;
	}

	public void setCreatername(String creatername) {
		this.creatername = creatername;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

}