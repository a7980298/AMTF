package com.amtf.demo.commonentity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AmtfPowerEntity {

	/**
     * 画面序号
	 */
	private Integer power_id;

	/**
	 * 画面名称
	 */
	private String power_name;

	/**
	 * 画面类型
	 */
	private String power_type;

	/**
	 * 权限
	 */
	private String power_pow;

	/**
	 * 画面路径
	 */
	private String power_path;

	/**
	 * class样式
	 */
	private String power_class;

	/**
	 * 缩写
	 */
	private String power_short;

	/**
	 * 是否显示
	 */
	private String power_show;
}
