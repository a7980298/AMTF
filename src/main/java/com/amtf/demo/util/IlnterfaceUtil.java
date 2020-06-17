package com.amtf.demo.util;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import com.amtf.demo.iInterface.iName;

public class IlnterfaceUtil {

	// 赋值
	public static String getIlnterface(ProceedingJoinPoint pjp) {
		MethodSignature ms = (MethodSignature) pjp.getSignature();
		Method method = ms.getMethod();

		iName myAnnotation = method.getAnnotation(iName.class);
		System.out.println(myAnnotation.value());// 参数p0的值
		return myAnnotation.value();

	}

}
