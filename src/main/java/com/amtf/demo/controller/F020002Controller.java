
package com.amtf.demo.controller;

import com.amtf.demo.entityin.F020002EntityIn;
import com.amtf.demo.entityout.F020002EntityOut;
import com.amtf.demo.params.F020002Params;
import com.amtf.demo.service.F020002Service;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.ValiDationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class F020002Controller extends ValiDationUtil {

	@Autowired
	F020002Service f020002service;

	/**
	 * 初始化
	 * 
	 * @parameter F020002Params params
	 * @return String
	 */
	@RequestMapping("/f020002")
	public String f020002S001(F020002Params params, Model model) {

		F020002EntityIn entityin = new F020002EntityIn();

		ParameterUtil.copyParameter(entityin, params);

		F020002EntityOut entityOut = f020002service.service01(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f020002Params", params);

		return "admin_calendar";
	}
}
