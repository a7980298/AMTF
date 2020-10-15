
package com.amtf.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amtf.demo.entityin.F010005EntityIn;
import com.amtf.demo.entityout.F010005EntityOut;
import com.amtf.demo.params.F010005Params;
import com.amtf.demo.service.F010005Service;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.ValiDationUtil;

@Controller
public class F010005Controller extends ValiDationUtil {

	@Autowired
	F010005Service f010005service;

	/**
	 * 初始化
	 * 
	 * @parameter F010005Params params
	 * @return String
	 */
	@RequestMapping("/f010005")
	public String f010005S001(F010005Params params, Model model) {

		F010005EntityIn entityin = new F010005EntityIn();

		ParameterUtil.copyParameter(entityin, params);

		F010005EntityOut entityOut = f010005service.service01(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f010005Params", params);

		return "activity";
	}

	/**
	 * 参加活动
	 * 
	 * @parameter F010005Params params
	 * @return String
	 */
	@RequestMapping("/f010005/T001")
	@ResponseBody
	public Map<String, Object> f010005T006(@RequestParam("id") String id, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		F010005EntityIn entityin = new F010005EntityIn();

		entityin.setActiyity_id(id);

		F010005EntityOut entityOut = f010005service.service02(entityin);
		map.put("isuseractivity", entityOut.getInsert10());
		return map;
	}
}
