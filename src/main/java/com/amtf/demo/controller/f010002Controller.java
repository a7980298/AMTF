package com.amtf.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amtf.demo.entityin.F010002entityIn;
import com.amtf.demo.entityout.F010002entityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.params.F010002Params;
import com.amtf.demo.service.f010002Service;
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

		model.addAttribute("f010002Params", params);

		return "f010002";
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

		model.addAttribute("f010002Params", params);
		return "f010002";
	}

}
