package com.ecan.service.business;

import javax.servlet.http.HttpSession;

import com.ecan.model.VmanUser;
import com.ecan.modle.ResultVO;

/**
* @author zhenhua.chun 
* @version 2016年8月8日 下午2:19:13
* @Description
*/
public interface EntrySystemService {
	
	/**
	 * 登录操作
	 * @param vmanUser
	 * @return
	 */
	public ResultVO<VmanUser> doLogin(String loginName,String loginPsd,HttpSession session);
	
	/**
	 * 注册操作
	 * @param vmanUser
	 * @return
	 */
	public ResultVO<VmanUser> doRegist(String loginName,String loginPsd);
}
