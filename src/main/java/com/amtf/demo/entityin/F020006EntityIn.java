package com.amtf.demo.entityin;

import com.amtf.demo.user.UserImpl;
import lombok.Getter;
import lombok.Setter;
import net.sf.json.JSONObject;

@Getter
@Setter
public class F020006EntityIn extends UserImpl {

	/**
	 * 页面id
	 */
	private String IViewId;

	/**
	 * 修改页面的id
	 */
	private String pagesShow;

}
