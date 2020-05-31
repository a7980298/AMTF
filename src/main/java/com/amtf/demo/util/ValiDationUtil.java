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
		List<String> messageList = validate(t);
		if (messageList.size() != FixedNumberUtil.INT_0) {
			model.addAttribute("errMessageList", messageList);
			model.addAttribute(t.getClass().getSimpleName(), t);
			return false;
		}
		return true;
	}

	public static <T> List<String> validate(T t) {
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<T>> constraintViolations = validator.validate(t);

		List<String> messageList = new ArrayList<>();
		for (ConstraintViolation<T> constraintViolation : constraintViolations) {
			messageList.add("{name:" + constraintViolation.getPropertyPath() + "}{err:"
					+ constraintViolation.getMessage() + "+}");

		}
		return messageList;
	}
}
