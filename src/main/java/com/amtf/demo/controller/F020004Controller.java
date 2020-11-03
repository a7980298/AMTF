
package com.amtf.demo.controller;

import com.amtf.demo.entityin.F020004EntityIn;
import com.amtf.demo.entityin.F020004EntityIn;
import com.amtf.demo.entityout.F020004EntityOut;
import com.amtf.demo.params.F020004Params;
import com.amtf.demo.service.F020004Service;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.ValiDationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class F020004Controller extends ValiDationUtil {

	@Autowired
	F020004Service f020004service;

	/**
	 * 初始化
	 * 
	 * @parameter F020004Params params
	 * @return String
	 */
	@RequestMapping("/f020004")
	public String f020004S001(F020004Params params, Model model) {

		F020004EntityIn entityin = new F020004EntityIn();

		ParameterUtil.copyParameter(entityin, params);

		F020004EntityOut entityOut = f020004service.service01(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f020004Params", params);

		return "admin_allnotices";
	}

	/**
	 * 发布更新通知
	 *
	 * @parameter F020004Params params
	 * @return String
	 */
	@RequestMapping("/f020004/T001")
	@ResponseBody
	public Map<String, Object> f020004T003(@RequestParam("release_name") String release_name,
										   @RequestParam("release_head") String release_head, Model model) {

		F020004EntityIn entityin = new F020004EntityIn();
		entityin.setRelease_head(release_head);
		entityin.setRelease_name(release_name);

		f020004service.service02(entityin);
		Map<String, Object> map = new HashMap<String, Object>();
		String name = "1";
		map.put("updonticey", name);

		return map;
	}
}
