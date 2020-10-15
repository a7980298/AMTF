
package com.amtf.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amtf.demo.entityin.F010009EntityIn;
import com.amtf.demo.entityout.F010009EntityOut;
import com.amtf.demo.params.F010009Params;
import com.amtf.demo.service.F010009Service;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.ValiDationUtil;

@Controller
public class F010009Controller extends ValiDationUtil {

	@Autowired
	F010009Service f010009service;

	/**
	 * 初始化
	 * 
	 * @parameter F010009Params params
	 * @return String
	 */
	@RequestMapping("/f010009")
	public String f010009S001(F010009Params params, Model model) {

		F010009EntityIn entityin = new F010009EntityIn();

		ParameterUtil.copyParameter(entityin, params);

		F010009EntityOut entityOut = f010009service.service01(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f010009Params", params);

		return "music";
	}
}
