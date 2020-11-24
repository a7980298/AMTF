package com.amtf.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amtf.demo.entityin.F060001EntityIn;
import com.amtf.demo.entityout.F060001EntityOut;
import com.amtf.demo.params.F060001Params;
import com.amtf.demo.service.F060001Service;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.ValiDationUtil;

@Controller
public class F060001Controller extends ValiDationUtil {

	@Autowired
	F060001Service f060001service;

	/**
	 * 初始化
	 * 
	 * @parameter F060001Params params
	 * @return String
	 */
	@RequestMapping("/f060001")
	public String f060001S001(F060001Params params, Model model) {

		F060001EntityIn entityin = new F060001EntityIn();

		ParameterUtil.copyParameter(entityin, params);

		F060001EntityOut entityOut = f060001service.service01(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f060001Params", params);

		return "qa";
	}

}
