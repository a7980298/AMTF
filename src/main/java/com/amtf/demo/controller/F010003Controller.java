
package com.amtf.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amtf.demo.entityin.F010003EntityIn;
import com.amtf.demo.entityout.F010003EntityOut;
import com.amtf.demo.params.F010003Params;
import com.amtf.demo.service.F010003Service;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.ValiDationUtil;

@Controller
public class F010003Controller extends ValiDationUtil {

	@Autowired
	F010003Service f010003service;

	/**
	 * 初始化
	 * 
	 * @parameter F010003Params params
	 * @return String
	 */
	@RequestMapping("/f010003")
	public String f010003S001(F010003Params params, Model model) {

		F010003EntityIn entityin = new F010003EntityIn();

		ParameterUtil.copyParameter(entityin, params);

		F010003EntityOut entityOut = f010003service.service01(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f010003Params", params);

		return "userinfo";
	}

	/**
	 * 修改用户信息
	 * 
	 * @parameter F010003Params params
	 * @return String
	 */
	@RequestMapping("/f010003/T001")
	public String f010003T002(F010003Params params, Model model) {

		F010003EntityIn entityin = new F010003EntityIn();

		ParameterUtil.copyParameter(entityin, params);

		F010003EntityOut entityOut = f010003service.service02(entityin);

		String isUpdatUserOk = entityOut.getIsUpdatUserOk();

		entityOut = f010003service.service01(entityin);

		entityOut.setIsUpdatUserOk(isUpdatUserOk);

		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f010003Params", params);

		return "userinfo";
	}
}
