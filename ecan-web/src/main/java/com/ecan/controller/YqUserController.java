package com.ecan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecan.model.YqUsers;
import com.ecan.service.YqUsersService;

@Controller
public class YqUserController {

	@Autowired
	private YqUsersService yqUsersService;
	
	@RequestMapping("users/{usid}")
	@ResponseBody
	public YqUsers getYqUser(@PathVariable(value="usid") int usid){
		try {
			YqUsers model = new YqUsers();
			model.setUsid(usid);
			return yqUsersService.findEntity(model);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
