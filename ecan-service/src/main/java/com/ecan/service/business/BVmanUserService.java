package com.ecan.service.business;

import java.util.List;
import java.util.Map;

import com.ecan.model.VmanUser;

public interface BVmanUserService {

	/**
	 * 登陆操作
	 * @param vmanUser 登录信息
	 * @return 返回是否登陆成功
	 */
	public List<Map<String, Object>> doLogin(VmanUser vmanUser) throws Exception;
	
}
