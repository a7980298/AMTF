package com.amtf.demo.webMvcConfigurer;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.amtf.demo.HandlerInterceptorUtil.IfGeiSession;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

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
		registry.addInterceptor(new IfGeiSession()).addPathPatterns("/**").excludePathPatterns("/a.do");
	}
}
