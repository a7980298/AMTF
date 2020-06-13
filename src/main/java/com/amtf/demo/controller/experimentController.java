package com.amtf.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amtf.demo.entityin.experimententityIn;
import com.amtf.demo.entityout.experimententityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.params.experimentParams;
import com.amtf.demo.service.experimentService;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.ValiDationUtil;

@Controller
public class experimentController extends ValiDationUtil {

	@Autowired
	experimentService experimentservice;

	/**
	 * 初始化
	 * 
	 * @parameter F010002Params params
	 * @return String
	 */
	@RequestMapping("/experiment")
	public String experimentS001(experimentParams params, Model model) {
		List<String> list1 = new ArrayList<String>();
		list1.add("用户1");
		list1.add("用户2");
		list1.add("用户3");
		list1.add("用户4");
		list1.add("用户5");
		params.setSelect1(list1);
		model.addAttribute("experimentParams", params);

		return "experiment";
	}

	/**
	 * 
	 * 
	 * @parameter experimentParams params
	 * @return String
	 * @throws ErrListException
	 */
	@RequestMapping("/experiment/F001")
	public String experimentF001(experimentParams params, Model model) throws ErrListException {

		experimententityIn entityin = new experimententityIn();

		experimententityOut entityOut = experimentservice.service02(entityin);
		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);
		model.addAttribute("experimentParams", params);
		return "experiment";
	}

}
