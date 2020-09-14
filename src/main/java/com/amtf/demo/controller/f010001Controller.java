package com.amtf.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amtf.demo.entityin.F010001entityIn;
import com.amtf.demo.entityout.F010001entityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.params.F010001Params;
import com.amtf.demo.service.f010001Service;
import com.amtf.demo.user.LogInFo;
import com.amtf.demo.util.CommonUtil;
import com.amtf.demo.util.Constant;
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
	public String f010001S001(F010001Params params, Model model) {

		LogInFo logInFo = ParameterUtil.getCookie();
		if (!CommonUtil.isEmpty(logInFo.getUser_account()) && !CommonUtil.isEmpty(logInFo.getUser_password())) {
			params.setUser_account(logInFo.getUser_account());
			params.setUser_password(logInFo.getUser_password());
			params.setRemember(Constant.STR_1);
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

		F010001entityIn entityin = new F010001entityIn();

		ParameterUtil.copyParameter(entityin, params);

		F010001entityOut entityOut = f010001service.service01(entityin);

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
		F010001entityIn entityin = new F010001entityIn();

		ParameterUtil.copyParameter(entityin, params);

		F010001entityOut entityOut = f010001service.service02(entityin);

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
		F010001entityIn entityin = new F010001entityIn();
		entityin.setPhone_number(phone_number);

		F010001entityOut entityOut = f010001service.service03(entityin);

		return entityOut.getVerifyCode();
	}
}
