
package com.amtf.demo.controller;

import com.amtf.demo.entityin.F020007EntityIn;
import com.amtf.demo.entityout.F020007EntityOut;
import com.amtf.demo.params.F020007Params;
import com.amtf.demo.service.F020007Service;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.StringUtil;
import com.amtf.demo.util.ValiDationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 管理页面-背景图片管理
 */
@RestController
public class F020007ControllerVue extends ValiDationUtil {

	@Autowired
	F020007Service f020007service;

	/**
	 * 初始化
	 * 
	 * @parameter F020007Params params
	 * @return String
	 */
	@PostMapping("/Vf020007")
	@ResponseBody
	public Object f020007S001(F020007Params params, Model model) {

		F020007EntityIn entityin = new F020007EntityIn();

		ParameterUtil.copyParameter(entityin, params);

		F020007EntityOut entityOut = f020007service.service01(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		return params;
	}
}
