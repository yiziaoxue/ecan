package com.ecan.service.impl;

import org.springframework.stereotype.Service;

import com.ecan.service.UserService;

/**
* @author zhenhua.chun 
* @version createtime：2016年6月13日 下午5:18:22
* @Description
* 类说明
*/
@Service
public class UserServiceImpl implements UserService{
	
	public void sys(){
		System.out.println("hello world");
	}
}
