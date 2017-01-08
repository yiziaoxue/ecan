package com.ecan.service.business.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecan.constant.Constant;
import com.ecan.mapper.VmanOrderMapper;
import com.ecan.mapper.VmanPermMapper;
import com.ecan.mapper.VmanRoleMapper;
import com.ecan.mapper.VmanRolePermRelaMapper;
import com.ecan.mapper.VmanUserMapper;
import com.ecan.mapper.VmanUserRoleRelaMapper;
import com.ecan.model.VmanOrder;
import com.ecan.model.VmanPerm;
import com.ecan.model.VmanRole;
import com.ecan.model.VmanRolePermRela;
import com.ecan.model.VmanUser;
import com.ecan.model.VmanUserRoleRela;
import com.ecan.modle.ResultVO;
import com.ecan.param.VmanOrderParam;
import com.ecan.service.business.EntrySystemService;
import com.ecan.util.CodeHelp;
import com.ecan.util.MD5Util;
import com.ecan.util.RedisUtil;

/**
* @author zhenhua.chun 
* @version 2016年8月8日 下午2:23:17
* @Description
*/
@Service("entrySystemService")
public class EntrySystemServiceImpl implements EntrySystemService{
	
	private Logger log = Logger.getLogger(EntrySystemServiceImpl.class);
	
	@Autowired
	private VmanUserMapper vmanUserMapper;
	@Autowired
	private VmanUserRoleRelaMapper vmanUserRoleRelaMapper;
	@Autowired
	private VmanRoleMapper vmanRoleMapper;
	@Autowired
	private VmanRolePermRelaMapper vmanRolePermRelaMapper;
	@Autowired
	private VmanPermMapper vmanPermMapper;
	@Autowired
	private VmanOrderMapper vmanOrderMapper;
	@Autowired
	private CodeHelp codeHelp;
	@Autowired
	private RedisUtil redisUtil;
	
	/**
	 * 现在先这么做，后期可考虑时候mongoDB
	 */
	@Override
	public ResultVO<VmanUser> doLogin(String loginName,String loginPsd,HttpSession session) {
		ResultVO<VmanUser> result = new ResultVO<VmanUser>();
		if(session.getAttribute("loginName") != null && session.getAttribute("loginPsd") != null){
			log.info("缓存中查询"+session.getAttribute("loginName")+"--"+session.getAttribute("loginPsd"));
			if(session.getAttribute("loginName").equals(loginName) && session.getAttribute("loginPsd").equals(loginPsd))
				result.setResult("0",(VmanUser)redisUtil.get(loginName));
			else if(session.getAttribute("loginName").equals(loginName) && session.getAttribute("loginPsd").equals(MD5Util.getPassWord(loginPsd)))
				result.setResult("0",(VmanUser)redisUtil.get(loginName));
			else
				result.setResult("-1","登录失败，账号密码不匹配");
		}else{
			VmanUser vmanUser = new VmanUser();
			if(checkEmail(loginName))
				vmanUser.setUserEmail(loginName);
			else
				vmanUser.setUserPhone(loginName);
			vmanUser.setUserPsd(loginPsd);
			log.info("数据库查询");
			VmanUser vu = null;
			try {
				vu = vmanUserMapper.findEntity(vmanUser);
			} catch (Exception e) {
				log.error("数据库查询失败");
				e.printStackTrace();
			}
			if(vu == null){
				vmanUser.setUserPsd(MD5Util.getPassWord(loginPsd));
				vu = vmanUserMapper.findEntity(vmanUser);
			}
			if(vu != null){
				session.setAttribute("loginName", loginName);
				session.setAttribute("loginPsd", MD5Util.getPassWord(loginPsd));
				result.setResult("0",vu);
				redisUtil.set(loginName, vu);
			}else{
				result.setResult("-1","登录失败，账号密码不匹配");
			}
		}
		return result;
	}
	
	/**
	 * 根据用户信息获取用户权限<br/>
	 * 增加了事务处理，这里权限包括角色和操作权限，两者是密不可分的，所以需要事务控制
	 * @param vmanUser 用户信息
	 * @return 返回对应用户的前线
	 * @throws Exception 主动抛出异常
	 */
	@Transactional
	public List<Map<String,Object>> getAuth(VmanUser vmanUser) throws Exception {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		if(vmanUser != null){
			VmanUserRoleRela modelUserRoleRela = new VmanUserRoleRela();
			modelUserRoleRela.setUserid(vmanUser.getUsid());
			List<VmanUserRoleRela> listVmanUserRoleRela = vmanUserRoleRelaMapper.findEntityList(modelUserRoleRela);
			for(VmanUserRoleRela vmanUserRoleRela : listVmanUserRoleRela){
				VmanRole modelRole = new VmanRole();
				modelRole.setRoid(vmanUserRoleRela.getRoleid());
				VmanRole vmanRole = vmanRoleMapper.findEntity(modelRole);
				Map<String,Object> mapRole = new HashMap<String,Object>();
				mapRole.put("role", vmanRole);
				list.add(mapRole);
				
				VmanRolePermRela modelRolePermRela = new VmanRolePermRela();
				modelRolePermRela.setRoleid(vmanRole.getRoid());
				List<VmanRolePermRela> listVmanRolePermRela = vmanRolePermRelaMapper.findEntityList(modelRolePermRela);
				for(VmanRolePermRela vmanRolePermRela : listVmanRolePermRela){
					VmanPerm modelPerm = new VmanPerm();
					modelPerm.setPeid(vmanRolePermRela.getPermid());
					VmanPerm vmanPerm  = vmanPermMapper.findEntity(modelPerm);
					Map<String,Object> mapPerm = new HashMap<String,Object>();
					mapRole.put("perm", vmanPerm);
					list.add(mapPerm);
				}
			}
			
		}
		return list;
	}

	@Override
	public ResultVO<VmanUser> doRegist(String loginName,String loginPsd) {
		//首先先对密码进行加密处理，利用双层混淆加密
		loginPsd = MD5Util.getPassWord(loginPsd);
		
		ResultVO<VmanUser> result = new ResultVO<VmanUser>();
		VmanUser vmanUser = new VmanUser();
		if(checkEmail(loginName))
			vmanUser.setUserEmail(loginName);
		else
			vmanUser.setUserPhone(loginName);
		vmanUser.setUserPsd(loginPsd);
		try {
			List<VmanUser> vmanList = vmanUserMapper.findEntityList(vmanUser);
			if(vmanList.size() > 0)
				result.setResult("-1", "用户名已存在，请重新输入");
			else{
				vmanUserMapper.addEntity(vmanUser);
				result.setResultCode("0");
			}
		} catch (Exception e) {
			log.error("数据库查询失败");
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public ResultVO<VmanOrder> doAddOrder(VmanOrder vmanOrder){
		ResultVO<VmanOrder> result = new ResultVO<VmanOrder>();
		try {
			List<VmanOrder> vmanList = vmanOrderMapper.findEntityList(vmanOrder);
			if(vmanList.size() > 0)
				result.setResult("-1", "订单已存在，请重新输入");
			else{
				vmanOrder.setOrderState(codeHelp.getIntValue(Constant.DIC_CODE_ORDER_STATE, Constant.ORDER_STATE_NEW_ORDER));
				vmanOrder.setOrderType(codeHelp.getIntValue(Constant.DIC_CODE_ORDER_TYPE, Constant.ORDER_TYPE_CHOOSE_TOPIC));
				vmanOrder.setPayState(codeHelp.getIntValue(Constant.DIC_CODE_PAY_STATE, Constant.PAY_STATE_NO_PAY));
				vmanOrder.setOrderCode(Getnum());
				vmanOrder.setCreateTime(new Date());
				vmanOrderMapper.addEntity(vmanOrder);
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
	
	/** 
     * 获取现在时间 
     * @return返回字符串格式yyyyMMddHHmmss 
     */  
      public static String getStringDate() {  
             Date currentTime = new Date();  
             SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");  
             String dateString = formatter.format(currentTime);  
             return dateString;  
          }  
      /** 
       * 由年月日时分秒+3位随机数 
       * 生成流水号 
       * @return 
       */  
      public static String Getnum(){  
          String t = getStringDate();  
          int x=(int)(Math.random()*900)+100;  
          String serial = t + x;  
          return serial;  
      }

	@Override
	public ResultVO<List<VmanOrder>> doGetOrder(VmanOrderParam vmanOrder,HttpSession session) {
		ResultVO<List<VmanOrder>> result = new ResultVO<List<VmanOrder>>();
		VmanUser vmanUser = CheckVmanUserInfo(session);
		VmanOrderParam param = new VmanOrderParam();
		if(vmanOrder.getOrderCode() != null && !vmanOrder.getOrderCode().equals(""))
			param.setOrderCode(vmanOrder.getOrderCode());
		if(vmanOrder.getOrderClient() != null && !vmanOrder.getOrderClient().equals(""))
			param.setOrderClient(vmanOrder.getOrderClient());
		param.setFirstItem(vmanOrder.getLimit()*vmanOrder.getOffset());
		param.setFlag(Constant.POP_STATE_TREU);
		param.setOrderOwner(String.valueOf(vmanUser.getUsid()));
		param.setLastItem(vmanOrder.getLimit()*vmanOrder.getOffset()+vmanOrder.getLimit());
		try {
			List<VmanOrder> vmanList = vmanOrderMapper.findEntityList(param);
			if(vmanList.size() <= 0){
				result.setResult("-1", "订单不存在，请重新查询");
			}else{
				result.setResultCode("0");
				result.setData(vmanList);
			}
		} catch (Exception e) {
			log.error("数据库查询失败");
			e.printStackTrace();
		}
		return result;
	}
	
	public VmanUser CheckVmanUserInfo(HttpSession session){
		VmanUser vmanUser = (VmanUser)redisUtil.get(String.valueOf(session.getAttribute("loginName")));
		if(vmanUser == null){
			vmanUser = new VmanUser();
			String userName = String.valueOf(session.getAttribute("loginName"));
			if(checkEmail(userName))
				vmanUser.setUserEmail(userName);
			else
				vmanUser.setUserPhone(userName);
			vmanUser = vmanUserMapper.findEntity(vmanUser);
			redisUtil.set(userName, userName);
		}
		return vmanUser;
	}

	@Override
	public ResultVO<VmanOrder> doUpdateOrder(VmanOrder vmanOrder, HttpSession session) {
		ResultVO<VmanOrder> result = new ResultVO<VmanOrder>();
		try {
			int resultCode = vmanOrderMapper.updateEntity(vmanOrder);
			if(resultCode <= 0)
				result.setResult("-1", "订单修改失败");
			else{
				vmanOrderMapper.updateEntity(vmanOrder);
				result.setResultCode("0");
			}
		} catch (Exception e) {
			log.error("数据库操作失败");
			e.printStackTrace();
		}
		return result;
	}
}
