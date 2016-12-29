package com.ecan.param;

import com.ecan.model.VmanOrder;

public class VmanOrderParam extends VmanOrder{
	/** 
	 * 2016下午9:53:23 
	 * ecan-common
	 * asus
	 */ 
	private static final long serialVersionUID = 1L;
	
	private Integer limit;
	private Integer offset;
	private Integer firstItem;
	private Integer lastItem;
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Integer getFirstItem() {
		return firstItem;
	}
	public void setFirstItem(Integer firstItem) {
		this.firstItem = firstItem;
	}
	public Integer getLastItem() {
		return lastItem;
	}
	public void setLastItem(Integer lastItem) {
		this.lastItem = lastItem;
	}
	
}
