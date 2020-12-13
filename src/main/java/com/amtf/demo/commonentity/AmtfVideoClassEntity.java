package com.amtf.demo.commonentity;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AmtfVideoClassEntity {

	/**
	 * id
	 */
	private Integer video_class_id;

	/**
	 * 标签名
	 */
	private String video_class_name;

	/**
	 * 标签样式
	 */
	private String video_class_img;
}
