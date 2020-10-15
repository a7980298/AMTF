
package com.amtf.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amtf.demo.entityin.F010006EntityIn;
import com.amtf.demo.entityout.F010006EntityOut;
import com.amtf.demo.params.F010006Params;
import com.amtf.demo.service.F010006Service;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.ValiDationUtil;

@Controller
public class F010006Controller extends ValiDationUtil {

	@Autowired
	F010006Service f010006service;

	/**
	 * 初始化
	 * 
	 * @parameter F010006Params params
	 * @return String
	 */
	@RequestMapping("/f010006")
	public String f010006S001(F010006Params params, Model model) {

		F010006EntityIn entityin = new F010006EntityIn();

		ParameterUtil.copyParameter(entityin, params);

		F010006EntityOut entityOut = f010006service.service01(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f010006Params", params);

		return "approval";
	}
}
