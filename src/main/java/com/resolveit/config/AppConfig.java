package com.resolveit.config;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.resolveit.impl.ResolveItMainImpl;
import com.resolveit.service.ResolveItMain;


public class AppConfig {

	@Documented
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.TYPE)
	@Import(LocalConfiguration.class)
	public @interface EnableAppMicroservice {
		
	}
	
	@Configuration
	public static class LocalConfiguration {
		
		@Bean
		public ResolveItMain resolveItDao() {
			return new ResolveItMainImpl();
		}
		
		@SuppressWarnings("rawtypes")
		@Bean
		public DataSource getDataSource() {
	        DataSourceBuilder dbBuilder = DataSourceBuilder.create();
	        dbBuilder.driverClassName("com.mysql.jdbc.Driver");
	        dbBuilder.url("jdbc:mysql://dt3bgg3gu6nqye5f.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/cjas9oq17rppptrg");
	        dbBuilder.username("rma8nhseno8qwsax");
	        dbBuilder.password("lbbquumogkldsbvh");
	        return dbBuilder.build();
		}
		
	}
	
}
