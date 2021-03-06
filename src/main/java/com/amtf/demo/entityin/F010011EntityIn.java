package com.amtf.demo.entityin;

import com.amtf.demo.commonentity.AmtfUserEntity;
import com.amtf.demo.user.UserImpl;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class F010011EntityIn extends UserImpl {
	/**
	 * 页面id
	 */
	private String IViewId;

	/**
	 * 用户主页信息
	 */
	String user;

	/**
	 * 关注的用户id
	 */
	private String attention_id;

	/**
	 * 分页当前页数
	 */
	Integer pageNum;
}
