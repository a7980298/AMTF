package com.amtf.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.amtf.demo.dao")
@ComponentScan(basePackages = { "com.amtf.demo" })
public class MybootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybootApplication.class, args);
	}
	/*
	 * @Bean MultipartConfigElement multipartConfigElement() {
	 * MultipartConfigFactory factory = new MultipartConfigFactory();
	 * factory.setLocation("/app/tmp"); return factory.createMultipartConfig(); }
	 */
}
