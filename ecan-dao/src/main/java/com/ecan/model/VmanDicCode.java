package com.ecan.model;
import java.util.Date;
import java.util.Date;

/**
 * model文件，系统自动生成
 * @author: TaneRoom
 * @since: 2016-11-29 22:20:32
 */
public class VmanDicCode{
	private Integer dcid;	//主键
	private String code;	//标识代码组
	private String dicKey;	//键
	private String dicValue;	//值
	private String dicDesc;	//描述
	private Date createTime;	//创建时间
	private String createOprt;	//创建人
	private Date updateTime;	//修改时间
	private String updateOprt;	//修改人


	public Integer getDcid() {
		return dcid;
	}

	public void setDcid(Integer dcid) {
		this.dcid = dcid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDicKey() {
		return dicKey;
	}

	public void setDicKey(String dicKey) {
		this.dicKey = dicKey;
	}

	public String getDicValue() {
		return dicValue;
	}

	public void setDicValue(String dicValue) {
		this.dicValue = dicValue;
	}

	public String getDicDesc() {
		return dicDesc;
	}

	public void setDicDesc(String dicDesc) {
		this.dicDesc = dicDesc;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateOprt() {
		return createOprt;
	}

	public void setCreateOprt(String createOprt) {
		this.createOprt = createOprt;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateOprt() {
		return updateOprt;
	}

	public void setUpdateOprt(String updateOprt) {
		this.updateOprt = updateOprt;
	}

}