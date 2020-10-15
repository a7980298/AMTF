
package com.amtf.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amtf.demo.entityin.F010008EntityIn;
import com.amtf.demo.entityout.F010008EntityOut;
import com.amtf.demo.params.F010008Params;
import com.amtf.demo.service.F010008Service;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.ValiDationUtil;

@Controller
public class F010008Controller extends ValiDationUtil {

	@Autowired
	F010008Service f010008service;

	/**
	 * 初始化
	 * 
	 * @parameter F010008Params params
	 * @return String
	 */
	@RequestMapping("/f010008")
	public String f010008S001(F010008Params params, Model model) {

		F010008EntityIn entityin = new F010008EntityIn();

		ParameterUtil.copyParameter(entityin, params);

		F010008EntityOut entityOut = f010008service.service01(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f010008Params", params);

		return "setup";
	}
}
