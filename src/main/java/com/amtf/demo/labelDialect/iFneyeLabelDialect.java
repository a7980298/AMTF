package com.amtf.demo.labelDialect;

import java.util.LinkedHashSet;
import java.util.Set;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import com.amtf.demo.label.iFneyeLabel;

public class iFneyeLabelDialect extends AbstractProcessorDialect {

	private final static String NAME = "ifneyelabel";

	public iFneyeLabelDialect() {
		super(NAME, null, StandardDialect.PROCESSOR_PRECEDENCE);
	}

	@Override
	public Set<IProcessor> getProcessors(String dialectPrefix) {
		return createStandardProcessorsSet(dialectPrefix);
	}

	private Set<IProcessor> createStandardProcessorsSet(String dialectPrefix) {
		LinkedHashSet<IProcessor> processors = new LinkedHashSet<IProcessor>();
		// 添加自定义标签处理器，可添加多个
		processors.add(new iFneyeLabel(dialectPrefix));
		return processors;
	}

}
