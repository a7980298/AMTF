package com.amtf.demo.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.amtf.demo.HandlerInterceptorUtil.IfGeiSession;
import com.amtf.demo.HandlerInterceptorUtil.getAdmin;

@Configuration
public class MyConfig implements WebMvcConfigurer {

	// 拦截器排除路径
	final String[] notLoginInterceptPaths = { "/", "/f010001", "/dashboard", "/main", "/register", "/login",
			"/f010001/T001", "/f010001/T002", "/f010001/T003", "/error", "/js/**", "/css/**", "/imgs/**", "/img/**" };
	final String[] getAdminPaths = { "/", "/err", "/js/**", "/css/**", "/imgs/**" };

	@Autowired
	private IfGeiSession ifgeisession;

	@Autowired
	private getAdmin getadmin;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		// 和页面有关的静态目录都放在项目的static目录下
		registry.addResourceHandler("/imgs/**").addResourceLocations("classpath:/static/imgs/");
		registry.addResourceHandler("/img/**").addResourceLocations("classpath:/static/img/");
		registry.addResourceHandler("/demo/**").addResourceLocations("classpath:/static/demo/");
		registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
		registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
		registry.addResourceHandler("/istatic/**").addResourceLocations("file:C:/imgs/");
		registry.addResourceHandler("/activityimg/**").addResourceLocations("file:C:/activity_imgs/");
		registry.addResourceHandler("/temp-rainy/**").addResourceLocations("file:D:/temp-rainy/");
	}

	/**
	 * 注册拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 注册拦截器
		// 拦截路径 排除路径
		registry.addInterceptor(ifgeisession).addPathPatterns("/**").excludePathPatterns(notLoginInterceptPaths);
		registry.addInterceptor(getadmin).addPathPatterns("/amtf/f010001").excludePathPatterns(getAdminPaths);
	}

	MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		factory.setLocation("/app/pttms/tmp");
		return factory.createMultipartConfig();
	}
}
