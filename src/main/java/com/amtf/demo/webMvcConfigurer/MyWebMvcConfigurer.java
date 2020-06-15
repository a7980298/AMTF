package com.amtf.demo.webMvcConfigurer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.amtf.demo.HandlerInterceptorUtil.IfGeiSession;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

	// 拦截器排除路径
	final String[] notLoginInterceptPaths = { "/", "/f010001", "/err" };

	@Autowired
	private IfGeiSession ifgeisession;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		// 和页面有关的静态目录都放在项目的static目录下
		registry.addResourceHandler("/imgs/**").addResourceLocations("classpath:/static/imgs/");
		registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
		registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");

	}

	/**
	 * 注册拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 注册拦截器
		// 拦截路径 排除路径
		registry.addInterceptor(ifgeisession).addPathPatterns("/**").excludePathPatterns(notLoginInterceptPaths);
	}
}
