package com.amtf.demo.iInterface;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import com.amtf.demo.iInterface.iSize.SizeValidator;
import com.amtf.demo.util.CommonUtil;

//表明该注解标记的元素可以被Javadoc 或类似的工具文档化
@Documented
@Constraint(validatedBy = SizeValidator.class)
//应用于类、接口（包括注解类型）、枚举,应用于属性（包括枚举中的常量）
@Target({ ElementType.FIELD })
//表明该注解的生命周期
//由JVM加载，包含在类文件中，在运行时可以被获取到
@Retention(RetentionPolicy.RUNTIME)
public @interface iSize {

	String message() default "";

	int min();

	int max();

	String name();

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	public class SizeValidator implements ConstraintValidator<iSize, String> {

		public static final String message = "必须在";

		// 错误信息
		private String msg;
		// 约束大小
		private int min, max;

		private String name;

		public void initialize(iSize constraintAnnotation) {
			// 获取注解中的值
			msg = message;
			min = CommonUtil.isEmpty(constraintAnnotation.min()) ? 0 : constraintAnnotation.min();
			max = constraintAnnotation.max();
			name = constraintAnnotation.name();
		}

		@Override
		public boolean isValid(String value, ConstraintValidatorContext context) {
			if (CommonUtil.isEmpty(value)) {
				return true;
			}
			// 如果最小值不是0
			if (min != 0) {
				// 判断是否大于规定范围
				if (value.length() < min || value.length() > max) {
					// 创建约束信息
					String mes = name + msg + min + "~" + max + "之间";
					context.disableDefaultConstraintViolation();
					context.buildConstraintViolationWithTemplate(mes).addConstraintViolation();
					return false;
				}
			} else {
				// 判断是否大于规定范围
				if (value.length() > max) {
					// 创建约束信息
					String mes = name + msg + max + "之内";
					context.disableDefaultConstraintViolation();
					context.buildConstraintViolationWithTemplate(mes).addConstraintViolation();
					return false;
				}
			}
			return false;
		}
	}
}
