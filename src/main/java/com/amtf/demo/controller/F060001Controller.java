package com.amtf.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amtf.demo.params.F060001Params;
import com.amtf.demo.service.F060001Service;
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

		model.addAttribute("f060001Params", params);

		return "f060001";
	}

}
