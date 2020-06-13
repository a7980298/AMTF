package com.amtf.demo.labelDialect;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import com.amtf.demo.label.iFormLabel;
import com.amtf.demo.label.iSelectLabel;

@Component
public class iLabelDialect extends AbstractProcessorDialect {

	private final static String NAME = "i";
	private final static int PRECEDENCE = 10000;

	public iLabelDialect() {
		super(NAME, NAME, StandardDialect.PROCESSOR_PRECEDENCE);
	}

	@Override
	public Set<IProcessor> getProcessors(String dialectPrefix) {
		return createStandardProcessorsSet(dialectPrefix);
	}

	/**
	 * 添加方言
	 * 
	 * @param dialectPrefix
	 * @return
	 */
	private Set<IProcessor> createStandardProcessorsSet(String dialectPrefix) {
		LinkedHashSet<IProcessor> processors = new LinkedHashSet<IProcessor>();
		// 添加自定义标签处理器，可添加多个
		// processors.add(new iFneyeLabel(dialectPrefix, "fenye", PRECEDENCE));
		processors.add(new iFormLabel(dialectPrefix, "form", PRECEDENCE));
		processors.add(new iSelectLabel(dialectPrefix, "select", PRECEDENCE));
		return processors;
	}

}
