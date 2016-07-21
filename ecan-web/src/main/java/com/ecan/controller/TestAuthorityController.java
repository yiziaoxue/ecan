package com.ecan.controller;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecan.annotation.Authority;
import com.ecan.annotation.contract.AuthorityContract;
import com.ecan.service.TestService;

import cn.ecan.constant.Perm;
import cn.ecan.constant.Role;

@Controller
public class TestAuthorityController {
	
	@Autowired
	TestService testService;
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Authority(role = {Role.ADMIN},perm = { Perm.CREATE })
	@RequestMapping("test")
	@ResponseBody
	public void test(){
		 Set<String> roles = new HashSet<String>();
		    roles.add("ROLE_ADMIN");
		    
		    Set<String> perms = new HashSet<String>();
		    perms.add("PERM_READ");
		    
		    AuthorityContract.set(roles, perms);
		    
		    logger.info(testService.getService());
		    logger.info(testService.getServiceName());
	}
}