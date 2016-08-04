package com.ecan.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecan.annotation.RequestLimit;
import com.ecan.model.VmanUser;
import com.ecan.service.VmanUserService;
import com.ecan.util.RedisUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
* @author zhenhua.chun 
* @version 2016年7月25日 下午3:10:23
* @Description
*/

@RestController
@RequestMapping("/entrysystem")
@Api(description="系统入口API")
public class EntrySystemController {
	private Logger log = Logger.getLogger(EntrySystemController.class);
	@Autowired
	private VmanUserService vmanUserService;
	
	@Autowired
	private RedisUtil redisUtil;
	
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
	public VmanUser login(@RequestBody VmanUser vmanUser,HttpServletRequest request) throws Exception {
		String backstr = "";
		if(request.getSession().getAttribute(vmanUser.getUserPhone()) != null){
			if(request.getSession().getAttribute(vmanUser.getUserPhone()).equals(vmanUser.getUserPsd()))
				backstr = "登录成功";
			else
				backstr = "登录失败";
		}else{
			log.info("查询数据库");
			List<VmanUser> vmanList = vmanUserService.findEntityList(vmanUser);
			if(vmanList.size() == 0)
				backstr = "登录失败";
			else{
				VmanUser user = vmanList.get(0);
				backstr = "登录成功";
				request.getSession().setAttribute(user.getUserPhone(), user.getUserPsd());
			}
		}
		log.info(backstr);
	    return vmanUser;
	 }
	
	@RequestLimit(count=3,time=60000)
	@RequestMapping(value="/regist",method=RequestMethod.POST)
	@ApiOperation(value="注册接口", notes="getCount更多说明")
	@ApiImplicitParam(name = "vmanUser", value = "用户详细实体user", required=true, paramType="body", dataType="VmanUser")
	public String regist(@RequestBody VmanUser vmanUser,HttpServletRequest request) throws Exception {
		vmanUserService.addEntity(vmanUser);
		System.out.println("注册成功");
	    return "login";
	}
	
}
