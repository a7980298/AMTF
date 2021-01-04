package com.amtf.demo.entityout;

import com.amtf.demo.commonentity.AmtfPowerEntity;
import com.amtf.demo.f020001entity.F020001_Select1Entity;
import com.amtf.demo.user.UserImpl;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class F020006EntityOut extends UserImpl {
	/**
	 * 页面id
	 */
	private String IViewId;

	/**
	 * 客户端总页面
	 */
	private List<AmtfPowerEntity> totalClientPage;

	/**
	 * 客户端显示的页面
	 */
	private List<AmtfPowerEntity> clientPageDisplayed;

	/**
	 * 修改页面显示成功条数
	 */
	private Integer pageCount;
}
