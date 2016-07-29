package com.ecan;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
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
	            .description("更多咨询请查看GIT：http://git.oschina.net/ecan/ecan")
	            .termsOfServiceUrl("http://blog.didispace.com/")
	            .contact("vman")
	            .version("1.0")
	            .build();
	    }
}
