package com.amtf.demo.entityin;

import com.amtf.demo.user.UserImpl;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class F010005EntityIn extends UserImpl {
	/**
	 * 页面id
	 */
	private String IViewId;

	/**
	 * 详细活动id
	 */
	private String activity_id;

	/**
	 * 评论
	 */
	private String activity_text;

	/**
	 * 评论id
	 */
	private String comment_id;

	/**
	 * 评论级别
	 */
	private String level;

}
