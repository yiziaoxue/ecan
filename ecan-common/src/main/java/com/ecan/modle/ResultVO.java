package com.ecan.modle;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;

/**
 * @author user
 *
 */
public class ResultVO<T> implements Serializable {

	private static Logger log = Logger.getLogger(ResultVO.class);

	private String resultCode = "0"; // 返回代码

	private String resultMsg = ""; // 返回信息

	private T data;

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setResult(String resultCode,String resultMsg){
		this.resultMsg = resultMsg;
		this.resultCode = resultCode;
	}
	
	public void setResult(String resultCode,T data){
		this.data = data;
		this.resultCode = resultCode;
	}
}
