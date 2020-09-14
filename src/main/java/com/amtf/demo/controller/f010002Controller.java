package com.amtf.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amtf.demo.entityin.F010002entityIn;
import com.amtf.demo.entityout.F010002entityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.params.F010001Params;
import com.amtf.demo.params.F010002Params;
import com.amtf.demo.service.f010002Service;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.ValiDationUtil;

@Controller
public class f010002Controller extends ValiDationUtil {

	@Autowired
	f010002Service f010002service;

	/**
	 * 初始化
	 * 
	 * @parameter F010002Params params
	 * @return String
	 */
	@RequestMapping("/f010002")
	public String f010002S001(F010002Params params, Model model) {

		F010002entityIn entityin = new F010002entityIn();

		ParameterUtil.copyParameter(entityin, params);

		F010002entityOut entityOut = f010002service.service01(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f010002Params", params);

		return "main";
	}

	/**
	 * 退出登录按钮押下
	 * 
	 * @parameter F010002Params params
	 * @return String
	 * @throws ErrListException
	 */
	@PostMapping("/f010002/T001")
	public String f010002T001(F010002Params params, Model model) throws ErrListException {

		ParameterUtil.closeSession();
		F010001Params f01params = new F010001Params();

		model.addAttribute("f010001Params", f01params);

		return "login";
	}

	/**
	 * 分页
	 * 
	 * @parameter F010002Params params
	 * @return String
	 * @throws ErrListException
	 */
	@RequestMapping("/f010002/F001")
	public String f010002F001(F010002Params params, Model model) throws ErrListException {

		F010002entityIn entityin = new F010002entityIn();

		F010002entityOut entityOut = f010002service.service02(entityin);
		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);
		model.addAttribute("f010002Params", params);
		return "f010002";
	}

	/**
	 * 修改用户信息
	 * 
	 * @parameter F010002Params params
	 * @return String
	 */
	@RequestMapping("/f010002/T002")
	public String f010002T002(F010002Params params, Model model) {

		F010002entityIn entityin = new F010002entityIn();

		ParameterUtil.copyParameter(entityin, params);

		F010002entityOut entityOut = f010002service.service03(entityin);

		String isUpdatUserOk = entityOut.getIsUpdatUserOk();

		entityOut = f010002service.service01(entityin);

		entityOut.setIsUpdatUserOk(isUpdatUserOk);

		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f010002Params", params);

		return "main";
	}
}
