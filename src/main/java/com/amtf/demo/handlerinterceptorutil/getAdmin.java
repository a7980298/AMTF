package com.amtf.demo.handlerinterceptorutil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.amtf.demo.util.NumberUtil;
import com.amtf.demo.util.StringUtil;

@Component
public class getAdmin implements HandlerInterceptor {
	// 在请求处理之前进行调用（Controller方法调用之前
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
		Object usercount = request.getSession().getAttribute("admin");
		if (usercount == null) {
			request.getSession().setAttribute("admin", "1");
		} else {
			request.getSession().setAttribute("admin",
					StringUtil.toStr(NumberUtil.toInt(request.getSession().getAttribute("admin")) + 1));
		}

		return true;
	}

	// 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o,
			ModelAndView modelAndView) throws Exception {

	}

	// 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e)
			throws Exception {

	}
}
