package com.ecan.service.business.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecan.annotation.contract.AuthorityContract;
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
import com.ecan.service.business.EntrySystemService;
import com.ecan.util.MD5Util;
import com.ecan.util.StringUtil;

/**
* @author zhenhua.chun 
* @version 2016年8月8日 下午2:23:17
* @Description
*/
@Service("entrySystemService")
public class EntrySystemServiceImpl implements EntrySystemService{
	
	private Logger log = Logger.getLogger(EntrySystemServiceImpl.class);
	private AuthorityContract authorityContract = new AuthorityContract();
	
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
	
	
	/**
	 * 现在先这么做，后期可考虑时候mongoDB
	 */
	@Override
	public ResultVO<VmanUser> doLogin(String loginName,String loginPsd,HttpSession session) {
		//首先先对密码进行加密处理，利用双层混淆加密
		loginPsd = MD5Util.getPassWord(loginPsd);
		
		ResultVO<VmanUser> result = new ResultVO<VmanUser>();
		VmanUser vmanUser = new VmanUser();
		if(checkEmail(loginName))
			vmanUser.setUserEmail(loginName);
		else
			vmanUser.setUserPhone(loginName);
		vmanUser.setUserPsd(loginPsd);
		
//		if(session.getAttribute(loginName) != null){
//			log.info("缓存中查询");
//			if(session.getAttribute(loginName).equals(loginPsd))
//				result.setResult("0",vmanUser);
//			else
//				result.setResult("-1","登录失败，账号密码不匹配");
//		}else{
			log.info("数据库查询");
//			List<VmanUser> vmanList = null;
//			try {
//				vmanList = vmanUserMapper.findEntityList(vmanUser);
//			} catch (Exception e) {
//				log.error("数据库查询失败");
//				e.printStackTrace();
//			}
//			if(vmanList.size() == 0)
//				result.setResult("-1","登录失败，账号密码不匹配");
//			else{
//				session.setAttribute(loginName, loginPsd);
//				result.setResult("0",vmanUser);
//			}
			VmanUser vu = null;
			try {
				vu = vmanUserMapper.findEntity(vmanUser);
				if(vu == null)
					result.setResult("-1","登录失败，账号密码不匹配");
				else{
					//根据登录信息，查询用户的权限信息
					List<Map<String,Object>> list = this.getAuth(vu);
					Set<String> rs = new HashSet<String>();
					Set<String> ps = new HashSet<String>();
					for(Map<String,Object> map : list){
						if(!map.isEmpty()){
							VmanRole vmanRole = (VmanRole) map.get("role");
							VmanPerm vmanPerm = (VmanPerm) map.get("perm");
							rs.add(StringUtil.isNullDefault(vmanRole.getRole(),""));
							ps.add(StringUtil.isNullDefault(vmanPerm.getPerm(),""));
						}
					}
					//将用户的权限设置到权限验证算法中
//					AuthorityContract.set(rs, ps);
					authorityContract.setSession(session);
					session.setAttribute(Constant.SOLES, rs);
					session.setAttribute(Constant.PERMS, ps);
//					session.setAttribute(loginName, loginPsd);
					result.setResult("0",vmanUser);
				}
			} catch (Exception e) {
				log.error("数据库查询失败");
				e.printStackTrace();
			}
//		}

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
				vmanOrder.setOrderCode(Getnum());
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
             System.out.println("TIME:::"+dateString);  
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
}
