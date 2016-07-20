package com.ecan.controller;
/** 
 * 抽象通用类 -> 控制层
 * @author TaneRoom
 * @date 2016年6月24日 下午4:43:35 
 * @version v1.0 
 */
public abstract class AbstractController {

	/**
	 * 内部转发
	 * @param url 转发地址
	 * @return 返回转发地址
	 */
	public String forward(String url) {
        return "forward:" + url;
    }

	/**
	 * 重定向
	 * @param url 重定向地址
	 * @return 返回重定向地址
	 */
    public String redirect(String url) {
        return "redirect:" + url;
    }
    
}
