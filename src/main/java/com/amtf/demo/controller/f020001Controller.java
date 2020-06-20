package com.amtf.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amtf.demo.entityin.F020001entityIn;
import com.amtf.demo.entityout.F020001entityOut;
import com.amtf.demo.params.F020001Params;
import com.amtf.demo.service.f020001Service;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.ValiDationUtil;

@Controller
public class f020001Controller extends ValiDationUtil {

	@Autowired
	f020001Service f020001service;

	/**
	 * 初始化
	 * 
	 * @parameter F020001Params params
	 * @return String
	 */
	@RequestMapping("/f020001")
	public String f010001S001(F020001Params params, Model model) {

		F020001entityIn entityin = new F020001entityIn();

		ParameterUtil.copyParameter(entityin, params);

		F020001entityOut entityOut = f020001service.service01(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f020001Params", params);

		return "f020001";
	}

}