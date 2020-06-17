package com.amtf.demo.iInterface;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//表明该注解标记的元素可以被Javadoc 或类似的工具文档化
@Documented
//应用于类、接口（包括注解类型）、枚举,应用于属性（包括枚举中的常量）
@Target({ ElementType.FIELD })
//表明该注解的生命周期
//由JVM加载，包含在类文件中，在运行时可以被获取到
@Retention(RetentionPolicy.RUNTIME)
public @interface iName {

	String value();
}
