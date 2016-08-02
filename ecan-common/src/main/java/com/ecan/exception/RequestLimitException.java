package com.ecan.exception;
/**
* @author zhenhua.chun 
* @version createtime：2016年6月13日 下午4:58:29
* @Description
* 类说明
*/
public class RequestLimitException extends Exception{
	  private static final long serialVersionUID = 1364225358754654702L;
	  public RequestLimitException() {
	    super("HTTP请求超出设定的限制");
	  }
	  public RequestLimitException(String message) {
	    super(message);
	  }
}
