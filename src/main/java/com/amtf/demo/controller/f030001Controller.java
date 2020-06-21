package com.amtf.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amtf.demo.entityin.F030001entityIn;
import com.amtf.demo.entityout.F030001entityOut;
import com.amtf.demo.params.F030001Params;
import com.amtf.demo.service.f030001Service;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.ValiDationUtil;

@Controller
public class f030001Controller extends ValiDationUtil {

	@Autowired
	f030001Service f030001service;

	/**
	 * 初始化
	 * 
	 * @parameter F030001Params params
	 * @return String
	 */
	@RequestMapping("/f030001")
	public String f010001S001(F030001Params params, Model model) {

		model.addAttribute("f030001Params", params);

		return "f030001";
	}

	

}
