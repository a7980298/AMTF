package com.amtf.demo.f010005entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class F010005_Select1Entity {
	
	/**
	 * id
	 */
	private String activity_id;

	/**
	 * 发布人
	 */
	private String activity_name;
	
	/**
	 * 标题
	 */
	private String activity_head;
	
	/**
	 * 参与级别
	 */
	private String activity_check;
	
	/**
	 * 开始日期
	 */
	private String activity_sttymd;
	
	/**
	 * 结束日期
	 */
	private String activity_endymd;

	/**
	 * 内容
	 */
	private String activity_text;
	
	/**
	 * img1
	 */
	private String activity_img1;
	
	/**
	 * img2
	 */
	private String activity_img2;
	
	/**
	 * img3
	 */
	private String activity_img3;
	
	/**
	 * img4
	 */
	private String activity_img4;
	
	/**
	 * img5
	 */
	private String activity_img5;

	/**
	 * 发布时间
	 */
	private String activity_time;
	
	/**
	 * 参加人数
	 */
	private int count;
}
