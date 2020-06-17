package com.amtf.demo.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.ui.Model;

public class ValiDationUtil {
	private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

	public static <T> boolean ValiDateParams(T t, Model model) {
		// 获取需要绑定错误信息的name和err
		List<String> messageList = validate(t);
		// 判断是否有错误信息
		if (messageList.size() != FixedNumberUtil.INT_0) {
			// 将错误信息放入Request域中
			model.addAttribute("errMessageList", messageList);
			// 将错误信息前的所有数据再次返回页面
			model.addAttribute(t.getClass().getSimpleName(), t);
			return false;
		}
		return true;
	}

	/**
	 * 获取输入的错误信息
	 * 
	 * @param <T>
	 * @param t
	 * @return
	 */
	public static <T> List<String> validate(T t) {
		// 获取Validator
		Validator validator = factory.getValidator();
		// 从Validator获取错误信息
		Set<ConstraintViolation<T>> constraintViolations = validator.validate(t);

		List<String> messageList = new ArrayList<>();
		// 遍历错误信息
		for (ConstraintViolation<T> constraintViolation : constraintViolations) {
			if (!CommonUtil.isEmpty(constraintViolation.getMessage())) {
				// name是页面上标签绑定的name值，err是错误信息
				messageList.add("{name:" + constraintViolation.getPropertyPath() + "}{err:"
						+ constraintViolation.getMessage() + "+}");
			}
		}
		return messageList;
	}
}
