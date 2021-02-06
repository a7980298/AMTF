package com.amtf.demo.entityout;

import com.amtf.demo.commonentity.AmtfClassImgEntity;
import com.amtf.demo.commonentity.AmtfPowerEntity;
import com.amtf.demo.user.UserImpl;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class F020007EntityOut extends UserImpl {
	/**
	 * 页面id
	 */
	private String IViewId;

	/**
	 * 背景图片
	 */
	private List<AmtfClassImgEntity> backgroundPictureList;
}
