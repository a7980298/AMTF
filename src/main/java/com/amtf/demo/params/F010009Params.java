package com.amtf.demo.params;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.amtf.demo.user.UserImpl;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties
@Getter
@Setter
public class F010009Params extends UserImpl {
	/**
	 * 页面id
	 */
	private String IViewId;
}
