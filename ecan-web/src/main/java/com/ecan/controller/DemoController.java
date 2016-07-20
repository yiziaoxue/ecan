package com.ecan.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecan.annotation.RequestLimit;


/**
* @author zhenhua.chun 
* @version createtime：2016年6月13日 下午5:12:58
* @Description 测试controller
* 类说明
*/
@Controller
@RequestMapping("/user")
public class DemoController {
	
	
    @RequestLimit(count=3,time=60000)
    @RequestMapping("/view/{name}")
	public String home(ModelMap map,HttpServletRequest request,@PathVariable("name") String name) {
    	map.addAttribute("host", name);
    	return "login";
	 }
    
}
