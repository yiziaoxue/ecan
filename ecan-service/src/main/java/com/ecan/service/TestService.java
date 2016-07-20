package com.ecan.service;

import com.ecan.annotation.Authority;

@Authority(role = { "ROLE_ADMIN", "ROLE_MANAGER" })
public interface TestService {
	
	public String getServiceName();

	@Authority(perm = { "PERM_CREATE" })
	public void createService(String service);

	@Authority(perm = { "PERM_READ" })
	public String getService();
	
}