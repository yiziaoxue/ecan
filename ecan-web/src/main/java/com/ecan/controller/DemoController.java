package com.ecan.controller;

import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecan.annotation.RequestLimit;
import com.ecan.bean.User;
import com.ecan.config.MineInfoAutoConfiguration;
import com.ecan.service.UserService;


/**
* @author zhenhua.chun 
* @version createtime：2016年6月13日 下午5:12:58
* @Description 测试controller
* 类说明
*/
@Controller
@RequestMapping("/user")
public class DemoController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private MineInfoAutoConfiguration mineInfoAutoConfiguration;
	
//	@Autowired  
//	RedisUtil redisUtil;  
//	
//	@Autowired  
//	MongoTemplate mongoTemplate;
//	
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
	
    @RequestLimit(count=3,time=60000)
    @RequestMapping("/view/{name}")
//    @Cacheable(value="user")
	public String home(ModelMap map,HttpServletRequest request,@PathVariable("name") String name) throws UnknownHostException {
    	userService.sys();
    	User user = mineInfoAutoConfiguration.getMineInfo();
    	System.out.println(user.getPassword());
    	System.out.println("name:"+name);
//    	redisUtil.set(name, user.getUsername());
//    	mongoTemplate.insert(user,"user");
    	map.addAttribute("host", name);
//    	System.out.println("Mysql_Name: "+jdbcTemplate.getDataSource());
    	return "login";
	 }
    
}
