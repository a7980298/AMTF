package com.amtf.demo.controller;

import com.amtf.demo.params.F050001Params;
import com.amtf.demo.service.F050001Service;
import com.amtf.demo.util.ValiDationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class F050001Controller extends ValiDationUtil{
	
	@Autowired
	F050001Service f050001service;
	
	/**
	 * 初始化
	 * 
	 * @parameter F050001Params params
	 * @return String
	 */
	@RequestMapping("/f050001")
	public String f050001S001(F050001Params params, Model model) {

		model.addAttribute("f050001Params", params);

		return "news";
	}

}
