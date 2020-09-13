package com.amtf.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amtf.demo.params.F010001Params;
import com.amtf.demo.util.ValiDationUtil;

@Controller
public class RegisterController extends ValiDationUtil {

	/**
	 * 初始化
	 * 
	 * @parameter F010001Params params
	 * @return String
	 */
	@RequestMapping("/register")
	public String f010001S001(F010001Params params, Model model) {

		return "register";
	}
}
