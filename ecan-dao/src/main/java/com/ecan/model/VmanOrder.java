package com.ecan.model;
import java.util.Date;
import java.util.Date;
import java.util.Date;

/**
 * model文件，系统自动生成
 * @author: TaneRoom
 * @since: 2017-01-08 21:34:38
 */
public class VmanOrder{
	private Integer usid;	//主键
	private String orderCode;	//订单号
	private String orderName;	//订单名
	private String orderRate;	//订单价格
	private String orderRemark;	//订单备注
	private String orderClient;	//下单人
	private String orderFollow;	//订单负责任
	private Date createTime;	//创建时间
	private Date updateTime;	//更新时间
	private String remarks;	//备注
	private Integer orderType;	//订单类型
	private Date orderTime;	//
	private Integer orderState;	//
	private String orderOwner;	//
	private Integer payState;	//
	private Short flag;	//通用状态
	private Integer orderBalance;	//


	public Integer getUsid() {
		return usid;
	}

	public void setUsid(Integer usid) {
		this.usid = usid;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getOrderRate() {
		return orderRate;
	}

	public void setOrderRate(String orderRate) {
		this.orderRate = orderRate;
	}

	public String getOrderRemark() {
		return orderRemark;
	}

	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}

	public String getOrderClient() {
		return orderClient;
	}

	public void setOrderClient(String orderClient) {
		this.orderClient = orderClient;
	}

	public String getOrderFollow() {
		return orderFollow;
	}

	public void setOrderFollow(String orderFollow) {
		this.orderFollow = orderFollow;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Integer getOrderState() {
		return orderState;
	}

	public void setOrderState(Integer orderState) {
		this.orderState = orderState;
	}

	public String getOrderOwner() {
		return orderOwner;
	}

	public void setOrderOwner(String orderOwner) {
		this.orderOwner = orderOwner;
	}

	public Integer getPayState() {
		return payState;
	}

	public void setPayState(Integer payState) {
		this.payState = payState;
	}

	public Short getFlag() {
		return flag;
	}

	public void setFlag(Short flag) {
		this.flag = flag;
	}

	public Integer getOrderBalance() {
		return orderBalance;
	}

	public void setOrderBalance(Integer orderBalance) {
		this.orderBalance = orderBalance;
	}

}