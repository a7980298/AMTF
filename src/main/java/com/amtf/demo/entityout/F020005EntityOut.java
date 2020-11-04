package com.amtf.demo.entityout;

import com.amtf.demo.user.UserImpl;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class F020005EntityOut extends UserImpl {
	/**
	 * 页面id
	 */
	private String IViewId;

	/**
	 * 活动是否发布成功
	 */
	public String isactivity;
}
