
package com.amtf.demo.controller;

import com.amtf.demo.agora.RtcTokenBuilderSample;
import com.amtf.demo.entityin.F010011EntityIn;
import com.amtf.demo.entityout.F010011EntityOut;
import com.amtf.demo.params.F010011Params;
import com.amtf.demo.service.F010011Service;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.ValiDationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class F010011Controller extends ValiDationUtil {

	@Autowired
	F010011Service f010011service;

	/**
	 * 初始化
	 * 
	 * @parameter F010011Params params
	 * @return String
	 */
	@RequestMapping("/f010011")
	public String f010011S001(F010011Params params, Model model) {

		F010011EntityIn entityin = new F010011EntityIn();

		ParameterUtil.copyParameter(entityin, params);

		F010011EntityOut entityOut = f010011service.service01(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f010011Params", params);

		return "activity_userinfo";
	}
}
