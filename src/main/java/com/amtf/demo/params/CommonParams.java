package com.amtf.demo.params;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.amtf.demo.f010001entity.F010001_Select2Entity;
import com.amtf.demo.user.UserImpl;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties
@Getter
@Setter
public class CommonParams extends UserImpl {
	/**
	 * 导航栏
	 */
	public Map<String, List<F010001_Select2Entity>> navigation_bar;
}
