package com.amtf.demo.commonentity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class AmtfActivityCommentEntity {

	/**
	 * id
	 */
	private Integer activity_comment_id;

	/**
	 * 活动id
	 */
	private Integer activity_id;

	/**
	 *用户id
	 */
	private String user_id;

	/**
	 *用户名称
	 */
	private String user_name;

	/**
	 *评论
	 */
	private String user_text;

	/**
	 *头像路径
	 */
	private String imgpath;

	/**
	 *发布时间
	 */
	private String activity_comment_time;

	/**
	 * 评论点赞
	 */
	private int comment_fabulous_count;
}
