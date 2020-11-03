package com.amtf.demo.entityout;

import com.amtf.demo.f020001entity.F020001_Select1Entity;
import com.amtf.demo.f020001entity.F020001_Select5Entity;
import com.amtf.demo.user.UserImpl;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class F020003EntityOut extends UserImpl {
	/**
	 * 页面id
	 */
	private String IViewId;

	/**
	 * 可操作的用户信息
	 */
	List<F020001_Select1Entity> select1;

}
