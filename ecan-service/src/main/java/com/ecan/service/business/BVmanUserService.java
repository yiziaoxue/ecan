package com.ecan.service.business;

import java.util.List;
import java.util.Map;

import com.ecan.model.VmanUser;

public interface BVmanUserService {

	/**
	 * 根据登录信息获取权限，事务控制
	 * @param vmanUser 登录信息
	 * @return 返回权限信息
	 */
	public List<Map<String, Object>> getAuth(VmanUser vmanUser) throws Exception;
	
}
