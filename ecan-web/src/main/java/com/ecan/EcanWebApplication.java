package com.ecan;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class EcanWebApplication  extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer{

	private static Logger logger = Logger.getLogger(EcanWebApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(EcanWebApplication.class, args);
		logger.info("==========服务启动，开始记录==========");
	}

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(8181);  
	}
}
