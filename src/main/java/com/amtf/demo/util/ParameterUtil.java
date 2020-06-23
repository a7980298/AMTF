package com.amtf.demo.util;

import java.lang.reflect.Field;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.amtf.demo.f010001entity.f010001_select1entity;
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
								fieldobj1[j].set(obj1, FixedNumberUtil.EMPTY);
							} else {
								fieldobj1[j].set(obj1, fieldobj2[i].get(obj2));
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
			// setUser(obj1, obj2);
		}
		return obj1;
	}

	// 给User用户表进行赋值
	public static Object setUser(Object obj1, Object obj2) {

		// UserImpl user1 = (UserImpl) obj1;

		// UserImpl user2 = (UserImpl) obj2;

//		user1.setIViewId(user2.getIViewId());
//		user1.setUser_Account(user2.getUser_Account());
//		user1.setUser_id(user2.getUser_id());
//		user1.setUser_Password(user2.getUser_Password());
//		user1.setUser_Name(user2.getUser_Name());
//		user1.setUser_FH(user2.getUser_FH());
//		user1.setUser_HomeAddress(user2.getUser_HomeAddress());
//		user1.setUser_Phone(user2.getUser_Phone());
//		user1.setUser_Attestation(user2.getUser_Attestation());

		// user1.setLogInFo(loginfo);

		// setSession(user2);
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
			loginfo.setUser_id(!CommonUtil.isEmpty(user.getUser_id()) ? user.getUser_id() : FixedNumberUtil.INT_0);
			// 账户
			loginfo.setUser_Account(
					!CommonUtil.isEmpty(user.getUser_Account()) ? user.getUser_Account() : FixedNumberUtil.EMPTY);
			// 密码
			loginfo.setUser_Password(
					!CommonUtil.isEmpty(user.getUser_Password()) ? user.getUser_Password() : FixedNumberUtil.EMPTY);
			// 别名
			loginfo.setUser_FH(!CommonUtil.isEmpty(user.getUser_FH()) ? user.getUser_FH() : FixedNumberUtil.EMPTY);
			// 地址
			loginfo.setUser_HomeAddress(!CommonUtil.isEmpty(user.getUser_HomeAddress()) ? user.getUser_HomeAddress()
					: FixedNumberUtil.EMPTY);
			// 认证
			loginfo.setUser_Attestation(!CommonUtil.isEmpty(user.getUser_Attestation()) ? user.getUser_Attestation()
					: FixedNumberUtil.EMPTY);
			// 电话
			loginfo.setUser_Phone(
					!CommonUtil.isEmpty(user.getUser_Phone()) ? user.getUser_Phone() : FixedNumberUtil.EMPTY);
			// 姓名
			loginfo.setUser_Name(
					!CommonUtil.isEmpty(user.getUser_Name()) ? user.getUser_Name() : FixedNumberUtil.EMPTY);
			// 权限
			loginfo.setUser_power(
					!CommonUtil.isEmpty(user.getUser_power()) ? user.getUser_power() : FixedNumberUtil.EMPTY);
			// 存入session
			session.setAttribute("loginfo", loginfo);

		}
	}

	// 将用户信息存入进入Session
	public static LogInFo getSession() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		LogInFo loginfo = new LogInFo();
		loginfo = (LogInFo) request.getSession().getAttribute("loginfo");
		return loginfo;
	}
}
