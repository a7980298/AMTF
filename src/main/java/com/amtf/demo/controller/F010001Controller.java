package com.amtf.demo.controller;

import com.amtf.demo.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amtf.demo.entityin.F010001EntityIn;
import com.amtf.demo.entityout.F010001EntityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.params.F010001Params;
import com.amtf.demo.service.F010001Service;
import com.amtf.demo.user.LogInFo;
import com.amtf.demo.util.CommonUtil;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.ValiDationUtil;

@Controller
public class F010001Controller extends ValiDationUtil {

	@Autowired
	F010001Service f010001service;

	/**
	 * 初始化
	 * 
	 * @parameter F010001Params params
	 * @return String
	 */
	@RequestMapping(value = { "/f010001", "/" })
	public String f010001S001(F010001Params params, Model model) {

		/*
		 * LogInFo logInFo = ParameterUtil.getCookie(); if
		 * (!CommonUtil.isEmpty(logInFo.getUser_account()) &&
		 * !CommonUtil.isEmpty(logInFo.getUser_password())) {
		 * params.setUser_account(logInFo.getUser_account());
		 * params.setUser_password(logInFo.getUser_password());
		 * params.setRemember(Constant.STR_1); }
		 */
		// 获取当前浏览器是否有用户登录了
		LogInFo getsession = ParameterUtil.getSession();
		// 如果有就直接登录
		if (!CommonUtil.isEmpty(getsession)) {
			return "redirect:/f010002";
		}

		model.addAttribute("f010001Params", params);

		return "login";
	}

	/**
	 * 登录按钮压下
	 * 
	 * @parameter F010001Params params
	 * @return String
	 * @throws ErrListException
	 */
	@RequestMapping("/f010001/T001")
	public String f010001T001(F010001Params params, Model model) throws ErrListException {

		if (!ValiDateParams(params, model)) {
			return "login";
		}

		F010001EntityIn entityin = new F010001EntityIn();

		ParameterUtil.copyParameter(entityin, params);

		F010001EntityOut entityOut = f010001service.service01(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		// 判断账户密码是否通过
		if (!CommonUtil.isEmpty(params.getBol02())) {
			// 重定向到f010002
			return "redirect:/f010002";
		}

		model.addAttribute("f010001Params", params);

		return "login";
	}

	/**
	 * 注册按钮压下
	 * 
	 * @parameter F010001Params params
	 * @return String
	 */
	@RequestMapping("/f010001/T002")
	public String f010001T002(F010001Params params, Model model) throws ErrListException {
		if (!ValiDateParams(params, model)) {
			return "f010001";
		}
		F010001EntityIn entityin = new F010001EntityIn();

		ParameterUtil.copyParameter(entityin, params);

		F010001EntityOut entityOut = f010001service.service02(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f010001Params", params);
		return "login";
	}

	/**
	 * 验证码
	 * 
	 * @parameter F010001Params params
	 * @return String
	 */
	@PostMapping("/f010001/T003")
	@ResponseBody
	public String f010001T003(@RequestParam("phone_number") String phone_number) throws ErrListException {
		F010001EntityIn entityin = new F010001EntityIn();
		entityin.setPhone_number(phone_number);

		F010001EntityOut entityOut = f010001service.service03(entityin);

		return entityOut.getVerifyCode();
	}

	/**
	 * 跳转画面
	 *
	 * @parameter F010001Params params
	 * @return String
	 */
	@PostMapping("/going")
	public String f010001T004(F010001Params params, Model model) throws ErrListException {
		model.addAttribute("going", params);
		return params.getLogin_html();
	}

	/**
	 * 跳转画面-管理页面
	 *
	 * @parameter F010001Params params
	 * @return String
	 */
	@PostMapping("/going/admin")
	public String f010001T005(F010001Params params, Model model) throws ErrListException {
		if(params.getLogin_html().contains("f020001")){
			params.setLogin_html(params.getLogin_html().replaceAll("f020001", Constant.EMPTY));
		}
		return params.getLogin_html();
	}
}
