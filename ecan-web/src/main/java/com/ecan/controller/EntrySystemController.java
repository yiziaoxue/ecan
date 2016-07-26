package com.ecan.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecan.annotation.RequestLimit;
import com.ecan.model.VmanUser;
import com.ecan.service.VmanUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
* @author zhenhua.chun 
* @version 2016年7月25日 下午3:10:23
* @Description
*/

@RestController
@RequestMapping("/entrysystem")
@Api(description="系统入口API")
public class EntrySystemController {

	@Autowired
	private VmanUserService vmanUserService;
	
	@RequestLimit(count=3,time=60000)
	@RequestMapping(value="entry",method=RequestMethod.GET)
	@ApiOperation(value="系统入口", notes="getCount更多说明")
	public String entry(HttpServletRequest request) {
		System.out.println("进入系统");
	    return "login";
	 }
	
	@RequestLimit(count=3,time=60000)
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ApiOperation(value="登录接口", notes="vmanUser")
	@ApiImplicitParam(name = "vmanUser", value = "用户详细实体user", required=true, paramType="body", dataType="VmanUser")
	public String login(@ApiParam(required = true, value = "vmanUser data")VmanUser vmanUser,HttpServletRequest request) {
		System.out.println("登录成功");
	    return "login";
	 }
	
	@RequestLimit(count=3,time=60000)
	@RequestMapping(value="/regist",method=RequestMethod.POST)
	@ApiOperation(value="注册接口", notes="getCount更多说明")
	public String regist(ModelMap map,HttpServletRequest request) {
//	    map.addAttribute("host", name);
		System.out.println("注册成功");
	    return "login";
	}
}
