package com.amtf.demo.entityout;

import java.util.List;

import com.amtf.demo.f010002entity.F010002_Select9Entity;
import com.amtf.demo.f010005entity.F010005_Select1Entity;
import com.amtf.demo.user.UserImpl;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class F010005EntityOut extends UserImpl {

	/**
	 * 参加活动添加成功?
	 */
	public String insert10;

	/**
	 * 所有活动
	 */
	List<F010002_Select9Entity> select9;

	/**
	 * 我的活动
	 */
	List<F010005_Select1Entity> select1;
}
