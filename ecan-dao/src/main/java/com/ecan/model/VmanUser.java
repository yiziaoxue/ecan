package com.ecan.model;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * model文件，系统自动生成
 * @author: TaneRoom
 * @date: 2016-07-21 18:06:52
 */
@ApiModel
public class VmanUser implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2108554703801688485L;
	
	@ApiModelProperty(value = "id", required = false)
	private Integer id;	
	@ApiModelProperty(value = "用户手机", required = false)	
	private String userPhone;
	@ApiModelProperty(value = "用户邮箱", required = false)
	private String userEmail;
	@ApiModelProperty(value = "用户密码", required = false)
	private String userPsd;	
	@ApiModelProperty(value = "名字", required = false)
	private String userName;
	@ApiModelProperty(value = "性别", required = false)
	private String userSex;	
	@ApiModelProperty(value = "年龄", required = false)
	private Integer userAge;
	@ApiModelProperty(value = "生日", required = false)
	private Date userBirth;
	@ApiModelProperty(value = "住址", required = false)
	private String userAddress;	
	@ApiModelProperty(value = "爱好", required = false)
	private String userHobby;
	@ApiModelProperty(value = "会员编码", required = false)
	private String memberCode;
	@ApiModelProperty(value = "会员类型", required = false)
	private Integer memberType;	
	@ApiModelProperty(value = "证件号码", required = false)
	private String cardCode;
	@ApiModelProperty(value = "证件类型", required = false)
	private Integer cardType;
	@ApiModelProperty(value = "创建时间", required = false)
	private Date createTime;
	@ApiModelProperty(value = "最后登录时间", required = false)
	private Date lastTime;
	@ApiModelProperty(value = "备注", required = false)
	private String remarks;	


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPsd() {
		return userPsd;
	}

	public void setUserPsd(String userPsd) {
		this.userPsd = userPsd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	public Date getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(Date userBirth) {
		this.userBirth = userBirth;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserHobby() {
		return userHobby;
	}

	public void setUserHobby(String userHobby) {
		this.userHobby = userHobby;
	}

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	public Integer getMemberType() {
		return memberType;
	}

	public void setMemberType(Integer memberType) {
		this.memberType = memberType;
	}

	public String getCardCode() {
		return cardCode;
	}

	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}

	public Integer getCardType() {
		return cardType;
	}

	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}