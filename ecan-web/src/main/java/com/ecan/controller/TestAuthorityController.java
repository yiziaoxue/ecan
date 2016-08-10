package com.ecan.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecan.annotation.Authority;
import com.ecan.annotation.contract.AuthorityContract;
import com.ecan.constant.Perm;
import com.ecan.constant.Role;
import com.ecan.model.VmanPerm;
import com.ecan.model.VmanRole;
import com.ecan.model.VmanUser;
import com.ecan.service.TestService;
import com.ecan.service.business.BVmanUserService;
import com.ecan.util.JsonUtil;
import com.ecan.util.StringUtil;

@Controller
public class TestAuthorityController {
	
	@Autowired
	TestService testService;
	
	@Autowired
	BVmanUserService bVmanUserService;
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Authority(role = {Role.ADMIN},perm = { Perm.INIT })
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
	
	@ResponseBody
	@RequestMapping("/login")
	public void login(HttpServletResponse response) {
		String username = "TaneRoom";
		String password = "123456";
		VmanUser vmanUser = new VmanUser();
		vmanUser.setUserName(username);
		vmanUser.setUserPsd(password);
		try {
			List<Map<String,Object>> list = bVmanUserService.getAuth(vmanUser);
			Set<String> rs = new HashSet<String>();
			Set<String> ps = new HashSet<String>();
			for(Map<String,Object> map : list){
				if(!map.isEmpty()){
					VmanRole vmanRole = (VmanRole) map.get("role");
					VmanPerm vmanPerm = (VmanPerm) map.get("perm");
					rs.add(StringUtil.isNullDefault(vmanRole.getRole(),""));
					ps.add(StringUtil.isNullDefault(vmanPerm.getPerm(),""));
				}
			}
			//将用户的权限设置到权限验证算法中
			AuthorityContract.set(rs, ps);
			JsonUtil.writeJson(response, list);
		} catch (Exception e) {
			JsonUtil.writeJson(response, "[]");
			e.printStackTrace();
		}
	}
}