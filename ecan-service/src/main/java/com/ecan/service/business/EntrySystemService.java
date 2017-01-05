package com.ecan.service.business;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.ecan.model.VmanOrder;
import com.ecan.model.VmanUser;
import com.ecan.modle.ResultVO;
import com.ecan.param.VmanOrderParam;

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

	/**
	 * 下单操作
	 * @param vmanOrder
	 * @return
	 */
	ResultVO<VmanOrder> doAddOrder(VmanOrder vmanOrder);
	
	/**
	 * 查询操作
	 * @param vmanOrder
	 * @return
	 */
	ResultVO<List<VmanOrder>> doGetOrder(VmanOrderParam param,HttpSession session);

	/**
	 * 修改订单
	 * @param vmanOrder
	 * @param session
	 * @return
	 */
	ResultVO<VmanOrder> doUpdateOrder(VmanOrder vmanOrder,HttpSession session);
}
