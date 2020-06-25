package com.amtf.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amtf.demo.params.F040001Params;
import com.amtf.demo.service.F040001Service;
import com.amtf.demo.util.ValiDationUtil;

@Controller
public class F040001Controller extends ValiDationUtil{
	
	@Autowired
	F040001Service f040001service;
	
	/**
	 * 初始化
	 * 
	 * @parameter F040001Params params
	 * @return String
	 */
	@RequestMapping("/f040001")
	public String f040001S001(F040001Params params, Model model) {

		model.addAttribute("f040001Params", params);

		return "f040001";
	}

}
