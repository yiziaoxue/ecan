//package com.ecan.job;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import com.alibaba.fastjson.JSONObject;
//import com.ecan.model.VmanDicCode;
//import com.ecan.service.VmanDicCodeService;
//import com.ecan.util.RedisUtil;
//
//@Component
//@Order(value=2)
//public class RedisStartupRunner implements CommandLineRunner {
//
//	@Autowireddouo
//	private RedisUtil redisUtil;
//	@Autowired
//	private VmanDicCodeService vmanDicCodeService;
//	
//    @Override
//    public void run(String... args) throws Exception {
//    	List<VmanDicCode> dicCodeLst = vmanDicCodeService.findEntityList(new VmanDicCode());
//    	for(VmanDicCode vm : dicCodeLst){
//    		redisUtil.set(vm.getCode(), vm);
//    	}
//    }
//
//}
