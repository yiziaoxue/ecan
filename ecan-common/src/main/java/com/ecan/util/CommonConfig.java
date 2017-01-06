package com.ecan.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
* @author zhenhua.chun 
* @version 2017年1月6日 下午7:50:37
* @Description
*/
@Configuration
public class CommonConfig {
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Bean
	public RedisUtil redisUtil(){
		RedisSerializer stringSerializer = new StringRedisSerializer();
	    redisTemplate.setKeySerializer(stringSerializer);
	    return new RedisUtil(redisTemplate);
	}
}
