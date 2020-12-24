package com.amtf.demo.commonentity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class AmtfVideoBarrageViewEntity {

	/**
	 * 发言的内容
	 */
	private String text;

	/**
	 * 颜色
	 */
	private String color;

	/**
	 * 字体大小
	 */
	private String size;

	/**
	 * 弹幕位置
	 */
	private String position;

	/**
	 * 弹幕时间
	 */
	private String time;
}
