package com.amtf.demo.params;

import com.amtf.demo.user.UserImpl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
@Getter
@Setter
public class F020004Params extends UserImpl {
	/**
	 * 页面id
	 */
	private String IViewId;
}
