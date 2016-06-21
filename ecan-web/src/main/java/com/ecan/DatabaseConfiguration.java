package com.ecan;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
 
/** 
 * @Description TODO
 * @author TaneRoom
 * @date 2016年6月21日 下午3:02:20 
 * @version v1.0 
 */
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
@MapperScan("com.ecan.mapper")
public class DatabaseConfiguration {
 
	private static Logger logger = Logger.getLogger(DatabaseConfiguration.class);
	
    //DataSource配置
    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource dataSource() {
        return new org.apache.tomcat.jdbc.pool.DataSource();
    }
 
    //提供SqlSeesion
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
 
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
 
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }
 
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
    
    public static void main(String[] args) {
	    SpringApplication.run(DatabaseConfiguration.class, args);
	    logger.info("============= SpringBoot Start Success =============");
	}
 
}