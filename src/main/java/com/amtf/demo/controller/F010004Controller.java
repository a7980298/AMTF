
package com.amtf.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amtf.demo.entityin.F010004EntityIn;
import com.amtf.demo.entityout.F010004EntityOut;
import com.amtf.demo.params.F010004Params;
import com.amtf.demo.service.F010004Service;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.ValiDationUtil;

@Controller
public class F010004Controller extends ValiDationUtil {

	@Autowired
	F010004Service f010004service;

	/**
	 * 初始化
	 * 
	 * @parameter F010004Params params
	 * @return String
	 */
	@RequestMapping("/f010004")
	public String f010004S001(F010004Params params, Model model) {

		F010004EntityIn entityin = new F010004EntityIn();

		ParameterUtil.copyParameter(entityin, params);

		F010004EntityOut entityOut = f010004service.service01(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f010004Params", params);

		return "updnotice";
	}
}
