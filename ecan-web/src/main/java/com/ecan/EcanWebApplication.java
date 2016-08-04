package com.ecan;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableRedisHttpSession
@EnableSwagger2
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
	
	@Bean
	public Docket createRestApi() {
	    return new Docket(DocumentationType.SWAGGER_2)
	            .apiInfo(apiInfo())
	            .select()
	            .apis(RequestHandlerSelectors.basePackage("com.ecan.controller"))
	            .paths(PathSelectors.any())
	            .build();
	  }

	private ApiInfo apiInfo() {
	    return new ApiInfoBuilder()
	            .title("VMAN API")
	            .description("更多咨询请查看:GIT：http://git.oschina.net/ecan/ecan")
	            .contact("vman")
	            .version("1.0")
	            .build();
	    }
	
	@Bean
	public RedisSerializer<Object> springSessionDefaultRedisSerializer() {		
		return new org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer();
	}
}
