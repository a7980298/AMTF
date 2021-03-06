
package com.amtf.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amtf.demo.agora.RtcTokenBuilderSample;
import com.amtf.demo.entityin.F010010EntityIn;
import com.amtf.demo.entityout.F010010EntityOut;
import com.amtf.demo.params.F010010Params;
import com.amtf.demo.service.F010010Service;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.ValiDationUtil;

@Controller
public class F010010Controller extends ValiDationUtil {

	@Autowired
	F010010Service f010010service;

	/**
	 * 初始化
	 * 
	 * @parameter F010010Params params
	 * @return String
	 */
	@RequestMapping("/f010010")
	public String f010010S001(F010010Params params, Model model) {

		F010010EntityIn entityin = new F010010EntityIn();

		ParameterUtil.copyParameter(entityin, params);

		F010010EntityOut entityOut = f010010service.service01(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);
		RtcTokenBuilderSample rtctokenbuildersample = new RtcTokenBuilderSample();
		params.setToken(rtctokenbuildersample.getToken());
		model.addAttribute("f010010Params", params);

		return "live";
	}

	/**
	 * 获取Token
	 * 
	 * @parameter F010004Params params
	 * @return String
	 */
	@RequestMapping("/f010010/T001")
	@ResponseBody()
	public Object f010004T001(F010010Params params, Model model) {
		RtcTokenBuilderSample rtctokenbuildersample = new RtcTokenBuilderSample();
		Map<String, String> map = new HashMap<String, String>();
		map.put("token", rtctokenbuildersample.getToken());
		return map;
	}
}
