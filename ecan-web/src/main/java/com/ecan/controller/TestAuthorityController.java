package com.ecan.controller;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecan.annotation.contract.AuthorityContract;
import com.ecan.service.TestService;

@Controller
public class TestAuthorityController {
	
	@Autowired
	TestService testService;
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping("test")
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