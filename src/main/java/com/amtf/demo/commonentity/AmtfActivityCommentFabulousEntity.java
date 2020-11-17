package com.amtf.demo.commonentity;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AmtfActivityCommentFabulousEntity {

	/**
	 * id
	 */
	private Integer activity_comment_fabulous_id;

	/**
	 * 活动id
	 */
	private Integer activity_id;

	/**
	 *评论id
	 */
	private Integer activity_comment_id;

	/**
	 *用户id
	 */
	private String user_id;

	/**
	 *点赞时间
	 */
	private String activity_comment_fabulous_time;
}
