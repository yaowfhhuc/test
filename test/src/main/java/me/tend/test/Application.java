package me.tend.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import me.tend.test.interceptor.SessionInterceptor;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {

	public void addInterceptors(InterceptorRegistry registry){
		registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/**");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
