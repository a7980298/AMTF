package com.amtf.demo.HandlerInterceptorUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class IfGeiSession implements HandlerInterceptor {
	// 在请求处理之前进行调用（Controller方法调用之前
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

		return true;
	}

	// 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o,
			ModelAndView modelAndView) throws Exception {
		// 获取当前请求路径
		String urlString = request.getRequestURI();
		// 获取session中的user账户是否存在
		Object account = request.getSession().getAttribute("userAccount");
		// 不存在的情况
		if (account == null) {
			// 判断是否是登录页面
			if (!urlString.endsWith("/amtf/f010001")) {
				// 重定向到登陆页面
				response.sendRedirect("/amtf/f010001");
			}
		}
	}

	// 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e)
			throws Exception {

	}
}
