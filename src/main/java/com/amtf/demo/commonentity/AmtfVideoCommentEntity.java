package com.amtf.demo.commonentity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class AmtfVideoCommentEntity {

	/**
	 * id
	 */
	private Integer video_comment_id;

	/**
	 * 视频id
	 */
	private String video_id;

	/**
	 * 用户id
	 */
	private String user_id;

	/**
	 * 用户名
	 */
	private String user_name;

	/**
	 * 用户头像
	 */
	private String user_img;

	/**
	 * 内容
	 */
	private String video_comment_text;

	/**
	 * 发布时间
	 */
	private Date video_comment_time;

	/**
	 * 发布时间
	 */
	private String nowtime;

	/**
	 * 点赞数量
	 */
	private String sumpraise;

	/**
	 * 本用户是否点赞
	 */
	private String ispraise;
}
