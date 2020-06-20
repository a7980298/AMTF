package com.amtf.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amtf.demo.params.F020001Params;
import com.amtf.demo.service.f010001Service;
import com.amtf.demo.util.ValiDationUtil;

@Controller
public class f020001Controller extends ValiDationUtil {

	@Autowired
	f010001Service f010001service;

	/**
	 * 初始化
	 * 
	 * @parameter F010001Params params
	 * @return String
	 */
	@RequestMapping("/f020001")
	public String f010001S001(F020001Params params, Model model) {

		model.addAttribute("f020001Params", params);

		return "f020001";
	}

}
