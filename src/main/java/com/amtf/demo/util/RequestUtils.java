package com.amtf.demo.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestUtils {

	/**
	 * 获取Requset域对象
	 * 
	 * @param params-Requset域名
	 * @param value-需要的字段名
	 * @return Map<String, Object>
	 */
	public static Map<String, Object> getRequestValue(String params, String value) {
		// 创建Requset对象
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		// 获取需要的Requser域对象
		Object obj = request.getAttribute(params);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(value, getParamsRequestValue(obj, value));
		return map;
	}

	/**
	 * 获取Requset域属性
	 * 
	 * @param obj-Requset域对象
	 * @param name-需要的字段名
	 * @return Object
	 */
	@SuppressWarnings("unused")
	public static Object getParamsRequestValue(Object obj, String name) {
		// 创建Field数组接收反射的Class的属性
		Field[] fieldobj1 = obj.getClass().getDeclaredFields();
		// 定义返回值
		Object lists = null;
		for (int i = 0; i < fieldobj1.length; i++) {
			// 开启权限
			fieldobj1[i].setAccessible(true);
			// 判断反射Class的属性是否等于name
			if (fieldobj1[i].getName().equals(name)) {
				try {
					// 开启权限
					fieldobj1[i].setAccessible(true);
					// 等于name将值赋给返回值
					lists = fieldobj1[i].get(obj);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return lists;
	}
}