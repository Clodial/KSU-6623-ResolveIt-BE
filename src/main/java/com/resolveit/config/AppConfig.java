package com.resolveit.config;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class AppConfig {

	@Documented
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.TYPE)
	@Import(LocalConfiguration.class)
	public @interface EnableAppMicroservice {
		
	}
	
	@Configuration
	public static class LocalConfiguration {
		
	}
	
}
