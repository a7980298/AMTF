package com.amtf.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amtf.demo.entityin.F010001entityIn;
import com.amtf.demo.entityout.F01001entityOut;
import com.amtf.demo.params.F010001Params;
import com.amtf.demo.service.f010001Service;
import com.amtf.demo.util.FixedNumberUtil;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.ValiDationUtil;

@Controller
public class f010001Controller extends ValiDationUtil {

	@Autowired
	f010001Service f010001service;

	/**
	 * 初始化
	 * 
	 * @parameter F010001Params params
	 * @return String
	 */
	@RequestMapping("/f010001")
	public String f01000001S001(F010001Params params, Model model) {

		model.addAttribute("F010001Params", params);

		return "f010001";
	}

	/**
	 * 登录按钮压下
	 * 
	 * @parameter F010001Params params
	 * @return String
	 */
	@RequestMapping("/f010001/T001")
	public String f010001T001(F010001Params params, Model model, HttpServletRequest request) {

		if (!ValiDateParams(params, model)) {
			return "f010001";
		}

		F010001entityIn entityin = new F010001entityIn();

		ParameterUtil.copyParameter(entityin, params);

		F01001entityOut entityOut = f010001service.service01(entityin, request);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("F010001Params", params);
		// 用户密码是否正确
		if (FixedNumberUtil.STR_1.equals(params.getPwdbol())) {
			return "f010002";
		}

		return "f010001";
	}

	/**
	 * 注册按钮压下
	 * 
	 * @parameter F010001Params params
	 * @return String
	 */
	@RequestMapping("/f010001/T002")
	public String f010001T002() {

		return "f010001";
	}
}
