package com.amtf.demo.commonentity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class AmtfVideoEntity {

	/**
	 * id
	 */
	private Integer video_id ;

	/**
	 * 用户id
	 */
	private String user_id;

	/**
	 * 标题
	 */
	private String video_head ;

	/**
	 * 简介
	 */
	private String video_text ;

	/**
	 * 视频路径
	 */
	private String video_path;

	/**
	 * 封面路径
	 */
	private String video_img;

	/**
	 * 标签
	 */
	private String video_class;

	/**
	 * 发布时间
	 */
	private Date video_time;

	/**
	 * 标签分类
	 */
	private String video_class_name;
}
