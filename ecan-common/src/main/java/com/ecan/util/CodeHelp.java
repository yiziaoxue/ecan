package com.ecan.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecan.mapper.VmanDicCodeMapper;
import com.ecan.model.VmanDicCode;

@Component
public class CodeHelp {
	@Autowired
	private RedisUtil redisUtil;
	
	@Autowired
	private VmanDicCodeMapper vmanDicCodeMapper;
	
	public String getStringValue(String code,String key){
		VmanDicCode dic = (VmanDicCode)redisUtil.get(code);
		if(dic == null){
			dic = new VmanDicCode();
			dic.setCode(code);
			dic.setDicKey(key);
			dic = vmanDicCodeMapper.findEntity(dic);
			redisUtil.set(code, dic);
		}
		return String.valueOf(dic.getDicValue());
	}
	
	public int getItValue(String code,String key){
		VmanDicCode dic = (VmanDicCode)redisUtil.get(code);
		if(dic == null){
			dic = new VmanDicCode();
			dic.setCode(code);
			dic.setDicKey(key);
			dic = vmanDicCodeMapper.findEntity(dic);
			redisUtil.set(code, dic);
		}
		return Integer.valueOf(dic.getDicValue());
	}
}
