
package com.amtf.demo.controller;

import com.amtf.demo.entityin.F020006EntityIn;
import com.amtf.demo.entityout.F020006EntityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.params.F020001Params;
import com.amtf.demo.params.F020006Params;
import com.amtf.demo.service.F020006Service;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.StringUtil;
import com.amtf.demo.util.ValiDationUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 管理页面-功能管理
 */
@RestController
public class F020006ControllerVue extends ValiDationUtil {

	@Autowired
	F020006Service f020006service;

	/**
	 * 初始化
	 * 
	 * @parameter F020006Params params
	 * @return String
	 */
	@PostMapping("/Vf020006")
	@ResponseBody
	public Object f020006S001(F020006Params params, Model model) {

		F020006EntityIn entityin = new F020006EntityIn();

		ParameterUtil.copyParameter(entityin, params);

		F020006EntityOut entityOut = f020006service.service01(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		return params;
	}

	/**
	 * 保存
	 *
	 * @parameter F020006Params params
	 * @return String
	 */
	@PostMapping("/Vf020006/upPage")
	@ResponseBody
	public Object f020006T001(@RequestBody Map map, Model model) {

		F020006Params params = new F020006Params();

		params.setPagesShow(StringUtil.toStr(map.get("pagesShow")));

		F020006EntityIn entityin = new F020006EntityIn();

		ParameterUtil.copyParameter(entityin, params);

		F020006EntityOut entityOut = f020006service.service02(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		return params;
	}
}
