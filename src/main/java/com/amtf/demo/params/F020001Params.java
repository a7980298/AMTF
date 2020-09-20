package com.amtf.demo.params;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.multipart.MultipartFile;

import com.amtf.demo.f010001entity.f010001_select3entity;
import com.amtf.demo.f020001entity.f020001_select1entity;
import com.amtf.demo.f020001entity.f020001_select5entity;
import com.amtf.demo.user.UserImpl;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties
@Getter
@Setter
public class F020001Params extends UserImpl {
	/**
	 * 姓名
	 */
	private String user_name;

	/**
	 * 用户图片
	 */
	private String imgPath;

	/**
	 * 可操作的用户信息
	 */
	private List<f020001_select1entity> select1;

	/**
	 * 用户搜索的名字
	 */
	public String search_name;

	/**
	 * 最新发布的通知
	 */
	f010001_select3entity select4;

	/**
	 * 上传图片
	 */
	public String input_file_commit;
	
	/**
	 * 通知信息
	 */
	List<f020001_select5entity> select5;
	
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
	public MultipartFile activity_editor;
}
