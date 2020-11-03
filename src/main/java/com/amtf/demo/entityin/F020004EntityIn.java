package com.amtf.demo.entityin;

import com.amtf.demo.user.UserImpl;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class F020004EntityIn extends UserImpl {

	/**
	 * 页面id
	 */
	private String IViewId;

	/**
	 * 发布通知标题
	 */
	public String release_head;

	/**
	 * 发布通知
	 */
	public String release_name;
}
