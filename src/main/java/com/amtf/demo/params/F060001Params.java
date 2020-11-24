package com.amtf.demo.params;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.amtf.demo.f060001entity.F060001_Select1Entity;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties
@Getter
@Setter

public class F060001Params {
	/**
	 * 页面id
	 */
	private String IViewId;
}
