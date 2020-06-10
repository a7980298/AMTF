package com.amtf.demo.labelBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amtf.demo.labelDialect.iFneyeLabelDialect;

@Configuration
public class iFneyeLabelBean {

	@Bean
	public iFneyeLabelDialect getIFromLabelDialect() {
		return new iFneyeLabelDialect();
	}

}
