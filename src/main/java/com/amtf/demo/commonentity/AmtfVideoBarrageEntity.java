package com.amtf.demo.commonentity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class AmtfVideoBarrageEntity {

	/**
	 * id
	 */
	private Integer video_barrage_id;

	/**
	 * 视频id
	 */
	private Integer video_id;

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
	 * 发言的内容
	 */
	private String video_barrage_text;

	/**
	 * 颜色
	 */
	private String video_barrage_color;

	/**
	 * 字体大小
	 */
	private String video_barrage_size;

	/**
	 * 弹幕位置
	 */
	private String video_barrage_position;

	/**
	 * 弹幕时间
	 */
	private String video_barrage_time;

	/**
	 * 发布时间
	 */
	private Date video_barrage_newtime;

	/**
	 * 发布时间
	 */
	private String nowtime;
}
