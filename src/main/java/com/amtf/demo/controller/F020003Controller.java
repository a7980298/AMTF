
package com.amtf.demo.controller;

import com.amtf.demo.entityin.F020001EntityIn;
import com.amtf.demo.entityin.F020003EntityIn;
import com.amtf.demo.entityout.F020001EntityOut;
import com.amtf.demo.entityout.F020003EntityOut;
import com.amtf.demo.params.F020001Params;
import com.amtf.demo.params.F020003Params;
import com.amtf.demo.service.F020001Service;
import com.amtf.demo.service.F020003Service;
import com.amtf.demo.util.Constant;
import com.amtf.demo.util.ImgUtil;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.ValiDationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class F020003Controller extends ValiDationUtil {

	@Autowired
	F020003Service f020003service;

	/**
	 * 初始化
	 * 
	 * @parameter F020003Params params
	 * @return String
	 */
	@RequestMapping("/f020003")
	public String f020003S001(F020003Params params, Model model) {

		F020003EntityIn entityin = new F020003EntityIn();

		ParameterUtil.copyParameter(entityin, params);

		F020003EntityOut entityOut = f020003service.service01(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f020003Params", params);

		return "admin_user";
	}

	/**
	 * 生成Excel
	 *
	 * @parameter F020003Params params
	 * @return String
	 */
	@RequestMapping("/f020003/T001")
	@ResponseBody
	public void f020003T001(F020003Params params, Model model) {

		F020003EntityIn entityin = new F020003EntityIn();

		ParameterUtil.copyParameter(entityin, params);

		f020003service.service02(entityin);

		return;

	}

	/**
	 * 刪除
	 *
	 * @parameter F020003Params params
	 * @return String
	 */
	@PostMapping("/f020003/T002")
	public String f020003T002(@RequestParam("userid") String userid, Model model) {
		F020003Params params = new F020003Params();

		F020003EntityIn entityin = new F020003EntityIn();

		entityin.setUserid(userid);

		F020003EntityOut entityOut = f020003service.service03(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f020003Params", params);

		return "admin_user :: select1";
	}
}
