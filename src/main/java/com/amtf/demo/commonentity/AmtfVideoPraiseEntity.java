package com.amtf.demo.commonentity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class AmtfVideoPraiseEntity {

	/**
	 * id
	 */
	private Integer video_comment_praise_id;

	/**
	 * 评论id
	 */
	private Integer video_comment_id;

	/**
	 * 视频id
	 */
	private Integer video_id;

	/**
	 * 用户id
	 */
	private String user_id;

	/**
	 * 发布时间
	 */
	private Date video_comment_praise_time;
}
