package com.amtf.demo.lnterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.amtf.demo.serviceImpl.CommonServie;
import com.amtf.demo.user.LogInFo;
import com.amtf.demo.util.CommonUtil;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.RedisUtils;

@Component
public class IfGeiSession implements HandlerInterceptor {

	@Resource
	private RedisUtils redisUtils;

	@Resource
	private CommonServie commonservie;

	private static final String ADMINVIEWID ="f020";

	/**
	 * 在请求处理之前进行调用（Controller方法调用之前
	 * @param request
	 * @param response
	 * @param o
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
		// 获取session中的user账户是否存在
		Object account = request.getSession().getAttribute("loginfo");
		// 不存在的情况
		String url = request.getRequestURI();
		if(!url.contains("f010001")){
			if (account == null) {
				// 重定向到登陆页面
				response.sendRedirect("/amtf/error");
				return false;
			} else {
				// 获取访问路径
				String servletpath = request.getServletPath();
				// 判断访问路径是否是管理页面
				if (servletpath.contains("/f020001")) {
					LogInFo logInFo = (LogInFo) account;
					// 获取该用户的访问权限
					String navigation_bar = redisUtils.get(logInFo.getUser_email() + "navigation_bar");
					if (!CommonUtil.isEmpty(navigation_bar)) {
						boolean b = false;
						String[] navigation_bars = navigation_bar.split(",");
						for (String string : navigation_bars) {
							if (string.equals(servletpath.split("/")[1])) {
								b = true;
							}
						}
						// 没有访问权限返回错误页面
						if (!b) {
							response.sendRedirect("/amtf/error");
						}
					}
				}
			}
		}
		return true;
	}

	/**
	 * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
	 * @param request
	 * @param response
	 * @param o
	 * @param modelAndView
	 * @throws Exception
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o,
			ModelAndView modelAndView) throws Exception {
		// 更新头部和导航栏
		if (!CommonUtil.isEmpty(ParameterUtil.getSession())) {
			if(request.getRequestURI().contains(ADMINVIEWID)){
				commonservie.CommonServie2();
			} else {
				commonservie.CommonServie1();
			}
		}
	}

	/**
	 * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
	 * @param request
	 * @param response
	 * @param o
	 * @param e
	 * @throws Exception
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e)
			throws Exception {

	}
}
