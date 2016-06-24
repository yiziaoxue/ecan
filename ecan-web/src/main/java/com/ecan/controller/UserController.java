package com.ecan.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecan.model.User;
import com.ecan.service.UserService;

/**
 * 测试一下，测试控制器
 * @author TaneRoom
 * @date 2016年6月21日 下午2:44:25 
 * @version v1.0
 */
@Controller
public class UserController extends AbstractController {

	private Logger logger = Logger.getLogger(UserController.class);
	 
    @Autowired
    private UserService userService;
 
    /**
     *  http://localhost:8080/getUserInfo
     */
    @RequestMapping("/getUserInfo")
    @ResponseBody
    public List<User> getUserInfo() {
    	List<User> users = userService.getUserInfo();
        if(users!=null){
        	for(User u : users){
        		System.out.println("user.getEmail():"+u.getEmail());
                logger.info("user.getFlag():"+u.getFlag());
        	}
            
        }
        return users;
    }
	
}
