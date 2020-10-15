
package com.amtf.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amtf.demo.entityin.F010007EntityIn;
import com.amtf.demo.entityout.F010007EntityOut;
import com.amtf.demo.params.F010007Params;
import com.amtf.demo.service.F010007Service;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.ValiDationUtil;

@Controller
public class F010007Controller extends ValiDationUtil {

	@Autowired
	F010007Service f010007service;

	/**
	 * 初始化
	 * 
	 * @parameter F010007Params params
	 * @return String
	 */
	@RequestMapping("/f010007")
	public String f010007S001(F010007Params params, Model model) {

		F010007EntityIn entityin = new F010007EntityIn();

		ParameterUtil.copyParameter(entityin, params);

		F010007EntityOut entityOut = f010007service.service01(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f010007Params", params);

		return "setup";
	}
}
