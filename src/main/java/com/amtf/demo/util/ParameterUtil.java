package com.amtf.demo.util;

import java.lang.reflect.Field;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.amtf.demo.f010001entity.f010001_select1entity;
import com.amtf.demo.user.Admin;
import com.amtf.demo.user.LogInFo;

public class ParameterUtil {

	// 赋值
	public static Object copyParameter(Object obj1, Object obj2) {
		// 创建Field数组接收反射的所有属性
		Field[] fieldobj1 = obj1.getClass().getDeclaredFields();
		Field[] fieldobj2 = obj2.getClass().getDeclaredFields();

		if (!CommonUtil.isEmpty(fieldobj2)) {
			for (int i = 0; i < fieldobj2.length; i++) {
				for (int j = 0; j < fieldobj1.length; j++) {
					// 判断两个反射Class中的属性是否一致
					if (fieldobj1[j].getName().equals(fieldobj2[i].getName())) {
						try {
							// 开启权限
							fieldobj1[j].setAccessible(true);
							fieldobj2[i].setAccessible(true);
							if (CommonUtil.isEmpty(fieldobj2[i].get(obj2))) {
								fieldobj1[j].set(obj1, null);
							} else {
								fieldobj1[j].set(obj1, fieldobj2[i].get(obj2));
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
			setSuperClass(obj1, obj2);
		}
		return obj1;
	}

	// 给User用户表进行赋值
	public static Object setSuperClass(Object obj1, Object obj2) {
		// 创建Field数组接收反射的所有属性
		Field[] fieldobj1 = obj1.getClass().getSuperclass().getDeclaredFields();
		Field[] fieldobj2 = obj2.getClass().getSuperclass().getDeclaredFields();

		if (!CommonUtil.isEmpty(fieldobj2)) {
			for (int i = 0; i < fieldobj2.length; i++) {
				for (int j = 0; j < fieldobj1.length; j++) {
					// 判断两个反射Class中的属性是否一致
					if (fieldobj1[j].getName().equals(fieldobj2[i].getName())) {
						try {
							// 开启权限
							fieldobj1[j].setAccessible(true);
							fieldobj2[i].setAccessible(true);

							fieldobj1[j].set(obj1, fieldobj2[i].get(obj2));
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		return obj1;
	}

	// 将用户信息存入进入Session
	public static void setSession(f010001_select1entity user) {
		// 创建requesst请求
		HttpServletRequest httpRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		// 创建session
		HttpSession session = httpRequest.getSession();

		LogInFo loginfo = new LogInFo();

		if (!CommonUtil.isEmpty(user)) {
			// 用户id
			loginfo.setUser_id(!CommonUtil.isEmpty(user.getUser_id()) ? user.getUser_id() : Constant.INT_0);
			// Email
			loginfo.setUser_email(!CommonUtil.isEmpty(user.getUser_email()) ? user.getUser_email() : Constant.EMPTY);
			// 账户
			loginfo.setUser_account(
					!CommonUtil.isEmpty(user.getUser_account()) ? user.getUser_account() : Constant.EMPTY);
			// 密码
			loginfo.setUser_password(
					!CommonUtil.isEmpty(user.getUser_password()) ? user.getUser_password() : Constant.EMPTY);
			// 姓名
			loginfo.setUser_name(!CommonUtil.isEmpty(user.getUser_name()) ? user.getUser_name() : Constant.EMPTY);
			// 国家
			loginfo.setUser_country(
					!CommonUtil.isEmpty(user.getUser_country()) ? user.getUser_country() : Constant.EMPTY);
			// 省
			loginfo.setUser_province(
					!CommonUtil.isEmpty(user.getUser_province()) ? user.getUser_province() : Constant.EMPTY);
			// 市
			loginfo.setUser_city(!CommonUtil.isEmpty(user.getUser_city()) ? user.getUser_city() : Constant.EMPTY);
			// 邮编
			loginfo.setUser_postcode(
					!CommonUtil.isEmpty(user.getUser_postcode()) ? user.getUser_postcode() : Constant.EMPTY);
			// 电话
			loginfo.setUser_phone(!CommonUtil.isEmpty(user.getUser_phone()) ? user.getUser_phone() : Constant.EMPTY);
			// 介绍
			loginfo.setUser_introduce(
					!CommonUtil.isEmpty(user.getUser_introduce()) ? user.getUser_introduce() : Constant.EMPTY);
			// 认证
			loginfo.setUser_attestation(
					!CommonUtil.isEmpty(user.getUser_attestation()) ? NumberUtil.toInt(user.getUser_attestation()) : 0);
			// 权限
			loginfo.setUser_power(!CommonUtil.isEmpty(user.getUser_power()) ? user.getUser_power() : 0);
			// 设置存在时长10分钟
			session.setMaxInactiveInterval(10 * 60);
			// 存入session
			session.setAttribute("loginfo", loginfo);

		}
	}

	// 将用户信息从Session中取出
	public static LogInFo getSession() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		LogInFo loginfo = new LogInFo();
		loginfo = (LogInFo) request.getSession().getAttribute("loginfo");
		return loginfo;
	}

	// 清楚session
	public static void closeSession() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		request.getSession().invalidate();
		request.getSession().removeAttribute("loginfo");
	}

	// 将用户信息存入Cookie中
	public static void setCookie(LogInFo loginfo) {
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getResponse();
		response.addCookie(new Cookie("user_account", loginfo.getUser_account()));
		response.addCookie(new Cookie("user_pwd", loginfo.getUser_password()));

	}

	// 将用户信息Cookie中取出
	public static LogInFo getCookie() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		LogInFo loginfo = new LogInFo();
		Cookie[] cookies = request.getCookies();
		if (!CommonUtil.isEmpty(cookies)) {
			for (Cookie cookie : cookies) {
				if ("user_account".equals(cookie.getName())) {
					loginfo.setUser_account(cookie.getValue());
				} else if ("user_pwd".equals(cookie.getName())) {
					loginfo.setUser_password(cookie.getValue());
				}
			}
		}
		return loginfo;
	}

	// 将管理信息从Session中取出
	public static Admin getAdmin() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		Admin admin = new Admin();
		admin.setUsercount(StringUtil.toStr(NumberUtil.toInt(request.getSession().getAttribute("admin"))));
		return admin;
	}

}
