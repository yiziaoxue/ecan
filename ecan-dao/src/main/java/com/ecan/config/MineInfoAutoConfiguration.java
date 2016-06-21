package com.ecan.config;

import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ecan.bean.User;
import com.ecan.config.param.MineInfoConfigParam;


/**
* @author zhenhua.chun 
* @version createtime：2016年6月13日 下午5:26:33
* @Description
* 类说明
*/
@Configuration
@EnableConfigurationProperties(MineInfoConfigParam.class)
public class MineInfoAutoConfiguration {
	@Autowired
    private MineInfoConfigParam mineInfo;
	
	@Bean
	@ConditionalOnMissingBean
	public User getMineInfo() throws UnknownHostException {
		User u = new User();
		u.setPassword(mineInfo.getPassword());
		return u;
	}
}
