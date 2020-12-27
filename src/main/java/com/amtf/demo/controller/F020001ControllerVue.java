
package com.amtf.demo.controller;

import com.amtf.demo.entityin.F020001EntityIn;
import com.amtf.demo.entityout.F020001EntityOut;
import com.amtf.demo.params.F020001Params;
import com.amtf.demo.service.F020001Service;
import com.amtf.demo.util.Constant;
import com.amtf.demo.util.ImgUtil;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.ValiDationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class F020001ControllerVue extends ValiDationUtil {

	@Autowired
	F020001Service f020001service;

	/**
	 * 初始化
	 * 
	 * @parameter F020001Params params
	 * @return String
	 */
	@PostMapping("/Vf020001")
	@ResponseBody
	public Object f020001S001(F020001Params params, Model model) {

		F020001EntityIn entityin = new F020001EntityIn();

		ParameterUtil.copyParameter(entityin, params);

		F020001EntityOut entityOut = f020001service.service01(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		return params;
	}
}
