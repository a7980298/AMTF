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
	private static Object getParamsRequestValue(Object obj, String name) {
		Field[] fieldobj1 = obj.getClass().getDeclaredFields();
		Object lists = null;
		for (int i = 0; i < fieldobj1.length; i++) {
			fieldobj1[i].setAccessible(true);
			if (fieldobj1[i].getName().equals(name)) {
				try {
					fieldobj1[i].setAccessible(true);
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