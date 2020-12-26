package com.amtf.demo.commonentity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class AmtfVideoHistoryEntity {

	/**
	 * id
	 */
	private Integer video_history_id  ;

	/**
	 * 视频id
	 */
	private Integer video_id ;

	/**
	 * 用户id
	 */
	private String user_id;

	/**
	 * 视频标题
	 */
	private String video_head;

	/**
	 * 视频封面
	 */
	private String video_img;

	/**
	 * 发布时间
	 */
	private Date video_history_time ;
}
