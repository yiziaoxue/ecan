package com.ecan.service.business.impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecan.model.VmanUser;
import com.ecan.modle.ResultVO;
import com.ecan.service.VmanUserService;
import com.ecan.service.business.EntrySystemService;

/**
* @author zhenhua.chun 
* @version 2016年8月8日 下午2:23:17
* @Description
*/
@Service("entrySystemService")
public class EntrySystemServiceImpl implements EntrySystemService{
	
	private Logger log = Logger.getLogger(EntrySystemServiceImpl.class);
	
	@Autowired
	private VmanUserService vmanUserService;
	
	/**
	 * 现在先这么做，后期可考虑时候mongoDB
	 */
	@Override
	public ResultVO<VmanUser> doLogin(String loginName,String loginPsd,HttpSession session) {
		ResultVO<VmanUser> result = new ResultVO<VmanUser>();
		VmanUser vmanUser = new VmanUser();
		if(checkEmail(loginName))
			vmanUser.setUserEmail(loginName);
		else
			vmanUser.setUserPhone(loginName);
		vmanUser.setUserPsd(loginPsd);
		
		if(session.getAttribute(loginName) != null){
			log.info("缓存中查询");
			if(session.getAttribute(loginName).equals(loginPsd))
				result.setResult("0",vmanUser);
			else
				result.setResult("-1","登录失败，账号密码不匹配");
		}else{
			log.info("数据库查询");
			List<VmanUser> vmanList = null;
			try {
				vmanList = vmanUserService.findEntityList(vmanUser);
			} catch (Exception e) {
				log.error("数据库查询失败");
				e.printStackTrace();
			}
			if(vmanList.size() == 0)
				result.setResult("-1","登录失败，账号密码不匹配");
			else{
				session.setAttribute(loginName, loginPsd);
				result.setResult("0",vmanUser);
			}
		}

		return result;
	}

	@Override
	public ResultVO<VmanUser> doRegist(String loginName,String loginPsd) {
		ResultVO<VmanUser> result = new ResultVO<VmanUser>();
		VmanUser vmanUser = new VmanUser();
		if(checkEmail(loginName))
			vmanUser.setUserEmail(loginName);
		else
			vmanUser.setUserPhone(loginName);
		vmanUser.setUserPsd(loginPsd);
		try {
			List<VmanUser> vmanList = vmanUserService.findEntityList(vmanUser);
			if(vmanList.size() > 0)
				result.setResult("-1", "用户名已存在，请重新输入");
			else{
				vmanUserService.addEntity(vmanUser);
				result.setResultCode("0");
			}
		} catch (Exception e) {
			log.error("数据库查询失败");
			e.printStackTrace();
		}
		return result;
	}

	private boolean checkEmail(String emailStr){
		 String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";    
		 Pattern regex = Pattern.compile(check);    
		 Matcher matcher = regex.matcher(emailStr);    
		 return matcher.matches();
	}
	
}
