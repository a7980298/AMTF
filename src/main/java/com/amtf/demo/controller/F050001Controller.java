package com.amtf.demo.controller;

import com.amtf.demo.entityin.F050001EntityIn;
import com.amtf.demo.entityin.F060001EntityIn;
import com.amtf.demo.entityout.F050001EntityOut;
import com.amtf.demo.entityout.F060001EntityOut;
import com.amtf.demo.params.F050001Params;
import com.amtf.demo.service.F050001Service;
import com.amtf.demo.util.ParameterUtil;
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
		// 新建一个实体类entityin
		F050001EntityIn entityin = new F050001EntityIn();
		// 将画面上的数据给实体类entityin
		ParameterUtil.copyParameter(entityin, params);
		// 将传给实体类的数据传给service,进行数据操作，并返回给实体类entityOut
		F050001EntityOut entityOut = f050001service.service01(entityin);
		// 然后将返回的实体类赋值给params
		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f050001Params", params);

		return "news";
	}

}
