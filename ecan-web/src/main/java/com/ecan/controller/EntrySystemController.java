package com.ecan.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecan.annotation.RequestLimit;
import com.ecan.model.VmanOrder;
import com.ecan.model.VmanUser;
import com.ecan.modle.ResultVO;
import com.ecan.param.VmanOrderParam;
import com.ecan.service.business.EntrySystemService;
import com.ecan.service.business.impl.FileLoadServiceImple;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
	private EntrySystemService entrySystemService;
	@Autowired
	private FileLoadServiceImple fleLoadServiceImple;
	
	@RequestLimit(count=30,time=60000)
	@RequestMapping(value="entry",method=RequestMethod.GET)
	@ApiOperation(value="系统入口", notes="getCount更多说明")
	public String entry(HttpServletRequest request) {
		System.out.println("进入系统");
	    return "login";
	 }
	
	@RequestLimit(count=30,time=60000)
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ApiOperation(value="登录接口", notes="vmanUser")
	@ApiImplicitParams({
	    @ApiImplicitParam(name = "loginName", value = "User's phone", required = true, dataType = "string", paramType = "query"),
	    @ApiImplicitParam(name = "loginPsd", value = "User's password", required = true, dataType = "string", paramType = "query"),})
	public ResultVO<VmanUser> login(VmanUser vmanUser,HttpServletRequest request) throws Exception {
		ResultVO<VmanUser> vmLst = entrySystemService.doLogin(vmanUser.getUserPhone(),vmanUser.getUserPsd(),request.getSession());
		return vmLst;
	 }
	
	@RequestLimit(count=30,time=60000)
	@RequestMapping(value="/regist",method=RequestMethod.POST)
	@ApiOperation(value="注册接口", notes="getCount更多说明")
	@ApiImplicitParams({
	    @ApiImplicitParam(name = "loginName", value = "User's loginName", required = true, dataType = "string", paramType = "query"),
	    @ApiImplicitParam(name = "loginPsd", value = "User's loginPsd", required = true, dataType = "string", paramType = "query"),})
	public ResultVO<VmanUser> regist(String loginName,String loginPsd,HttpServletRequest request) throws Exception {
	    return entrySystemService.doRegist(loginName,loginPsd);
	}
	
	@RequestLimit(count=30,time=60000)
	@RequestMapping(value="/addOrder",method=RequestMethod.POST)
	@ApiOperation(value="下单接口", notes="getCount更多说明")
	@ApiImplicitParams({
	    @ApiImplicitParam(name = "orderName", value = "Order's name", required = true, dataType = "string", paramType = "query"),
	    @ApiImplicitParam(name = "orderClient", value = "Order's client", required = true, dataType = "string", paramType = "query")})
	public ResultVO<VmanOrder> addOrder(VmanOrder vmanOrder,HttpServletRequest request){
		return entrySystemService.doAddOrder(vmanOrder);
	}
	
	@RequestLimit(count=30,time=60000)
	@RequestMapping(value="/getOrderDetail",method=RequestMethod.POST)
	@ApiOperation(value="查询接口", notes="getCount更多说明")
	@ApiImplicitParams({
	    @ApiImplicitParam(name = "orderName", value = "Order's name", required = false, dataType = "string", paramType = "query"),
	    @ApiImplicitParam(name = "orderClient", value = "Order's client", required = false, dataType = "string", paramType = "query")})
	public List<VmanOrder> getOrderDetail(VmanOrderParam param,HttpServletRequest request){
		ResultVO<List<VmanOrder>> result = null;
		result = entrySystemService.doGetOrder(param,request.getSession());
		List<VmanOrder> vmanOrderLst = result.getData();
		return vmanOrderLst;
	}
	
	@RequestLimit(count=30,time=60000)
	@RequestMapping(value="/updateOrder",method=RequestMethod.POST)
	@ApiOperation(value="修改接口", notes="getCount更多说明")
	public ResultVO<VmanOrder> updateOrder(VmanOrder vmanOrder,HttpServletRequest request){
		return entrySystemService.doUpdateOrder(vmanOrder, request.getSession());
	}
	
	@RequestMapping(value="/downLoadFile",method=RequestMethod.GET)
	public void downLoadFile(HttpServletResponse response){
		fleLoadServiceImple.fileDownLoad(response);
	}
}