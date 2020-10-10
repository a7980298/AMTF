package com.amtf.demo;

import java.net.InetSocketAddress;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

import com.amtf.demo.nettyclient.NettyClient;
import com.amtf.demo.nettyserver.NettyServer;

@SpringBootApplication
@MapperScan("com.amtf.demo.dao")
@ComponentScan(basePackages = { "com.amtf.demo" })
@ServletComponentScan
public class MybootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybootApplication.class, args);
		// 启动netty服务端
		NettyServer nettyServer = new NettyServer();
		nettyServer.start(new InetSocketAddress("127.0.0.1", 8090));
		// 启动netty客户端
		NettyClient nettyClient = new NettyClient();
		nettyClient.start();
	}
}
