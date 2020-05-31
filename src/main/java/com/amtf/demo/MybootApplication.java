package com.amtf.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.amtf.demo.dao")
//@ComponentScan({ "com.amtf.demo.serviceImpl", "com.amtf.demo.controller" })
public class MybootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybootApplication.class, args);
	}
}
