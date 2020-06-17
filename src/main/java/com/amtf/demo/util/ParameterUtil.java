package com.amtf.demo.util;

import java.lang.reflect.Field;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.amtf.demo.user.UserImpl;

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
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			setUser(obj1, obj2);
		}

		return obj1;
	}

	// 给User用户表进行赋值
	public static Object setUser(Object obj1, Object obj2) {

		UserImpl user1 = (UserImpl) obj1;

		UserImpl user2 = (UserImpl) obj2;

		// user1.setIViewId(user2.getIViewId());
		user1.setUser_Account(user2.getUser_Account());
		user1.setUser_id(user2.getUser_id());
		user1.setUser_Password(user2.getUser_Password());
		user1.setUser_Name(user2.getUser_Name());
		user1.setUser_FH(user2.getUser_FH());
		user1.setUser_HomeAddress(user2.getUser_HomeAddress());
		user1.setUser_Phone(user2.getUser_Phone());
		user1.setUser_Attestation(user2.getUser_Attestation());
		setSession(user2);
		return obj1;
	}

	// 给Session赋值
	public static void setSession(UserImpl user) {
		HttpServletRequest httpRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		HttpSession session = httpRequest.getSession();

		session.setAttribute("userId",
				!CommonUtil.isEmpty(user.getUser_id()) ? user.getUser_id() : FixedNumberUtil.EMPTY);
		session.setAttribute("userAccount",
				!CommonUtil.isEmpty(user.getUser_Account()) ? user.getUser_Account() : FixedNumberUtil.EMPTY);
		session.setAttribute("userPassword",
				!CommonUtil.isEmpty(user.getUser_Password()) ? user.getUser_Password() : FixedNumberUtil.EMPTY);
		session.setAttribute("userFH",
				!CommonUtil.isEmpty(user.getUser_FH()) ? user.getUser_FH() : FixedNumberUtil.EMPTY);
		session.setAttribute("userHomeAddress",
				!CommonUtil.isEmpty(user.getUser_HomeAddress()) ? user.getUser_HomeAddress() : FixedNumberUtil.EMPTY);
		session.setAttribute("userAttestation",
				!CommonUtil.isEmpty(user.getUser_Attestation()) ? user.getUser_Attestation() : FixedNumberUtil.EMPTY);
		session.setAttribute("userUser_Phone",
				!CommonUtil.isEmpty(user.getUser_Phone()) ? user.getUser_Phone() : FixedNumberUtil.EMPTY);
		session.setAttribute("userName",
				!CommonUtil.isEmpty(user.getUser_Name()) ? user.getUser_Name() : FixedNumberUtil.EMPTY);
	}
}
