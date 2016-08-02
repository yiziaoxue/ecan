package com.ecan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecan.mapper.UserMapper;
import com.ecan.model.User;
import com.ecan.service.UserService;

/**
* @author zhenhua.chun 
* @version createtime：2016年6月13日 下午5:18:22
* @Description
* 类说明
*/
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	public void sys(){
		System.out.println("hello world");
	}

	@Override
	public List<User> getUserInfo() {
		return userMapper.findUserInfo();
	}
}
