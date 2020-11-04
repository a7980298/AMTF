package com.amtf.demo.entityin;

import com.amtf.demo.user.UserImpl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class F020005EntityIn extends UserImpl {

	/**
	 * 页面id
	 */
	private String IViewId;

	/**
	 * 活动主题
	 */
	public String activity_head;

	/**
	 * 活动举办地点
	 */
	public String activity_position;

	/**
	 * 参与级别
	 */
	public String activity_check;

	/**
	 * 开始日期
	 */
	public String activity_sttymd;

	/**
	 * 结束日期
	 */
	public String activity_endymd;

	/**
	 * 活动上传图片1
	 */
	public MultipartFile activity_img1;

	/**
	 * 活动上传图片2
	 */
	public MultipartFile activity_img2;

	/**
	 * 活动上传图片3
	 */
	public MultipartFile activity_img3;

	/**
	 * 活动上传图片4
	 */
	public MultipartFile activity_img4;

	/**
	 * 活动上传图片5
	 */
	public MultipartFile activity_img5;

	/**
	 * 活动内容
	 */
	public String activity_editor;
}
