package com.amtf.demo.f020005entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WangEditor {
	/**
	 * 错误代码，0 表示没有错误。
	 */
	private Integer errno;
	/**
	 * 已上传的图片路径
	 */
	private String[] data;

}
