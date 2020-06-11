package com.amtf.demo.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestUtils {

	public static Map<String, Object> getRequestValue(String params) {
		// 创建Requset域对象
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();

		request.getAttribute(params);
		return null;
	}
}