package com.amtf.demo.commonentity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class AmtfClassImgEntity {

	/**
	 * id
	 */
	private Integer class_img_id  ;

	/**
	 * 分类
	 */
	private String img_class;

	/**
	 * Oss路径
	 */
	private String imgOss_path;

	/**
	 * 路径
	 */
	private String img_path;

	/**
	 * 发布时间
	 */
	private Date img_time;
}
