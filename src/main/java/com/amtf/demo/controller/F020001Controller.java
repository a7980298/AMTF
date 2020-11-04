
package com.amtf.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.amtf.demo.entityin.F020001EntityIn;
import com.amtf.demo.entityout.F020001EntityOut;
import com.amtf.demo.params.F020001Params;
import com.amtf.demo.service.F020001Service;
import com.amtf.demo.util.Constant;
import com.amtf.demo.util.ImgUtil;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.ValiDationUtil;

@Controller
public class F020001Controller extends ValiDationUtil {

	@Autowired
	F020001Service f020001service;

	/**
	 * 初始化
	 * 
	 * @parameter F020001Params params
	 * @return String
	 */
	@RequestMapping("/f020001")
	public String f020001S001(F020001Params params, Model model) {

		F020001EntityIn entityin = new F020001EntityIn();

		ParameterUtil.copyParameter(entityin, params);

		F020001EntityOut entityOut = f020001service.service01(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f020001Params", params);

		return "admin_main";
	}

	/**
	 * 登录
	 * 
	 * @parameter F020001Params params
	 * @return String
	 */
	@RequestMapping("/f020001/T001")
	public String f020001T001(F020001Params params, Model model) {

		F020001EntityIn entityin = new F020001EntityIn();

		ParameterUtil.copyParameter(entityin, params);

		F020001EntityOut entityOut = f020001service.service01(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f020001Params", params);

		return "dashboard";
	}

	/**
	 * 搜索
	 * 
	 * @parameter F020001Params params
	 * @return String
	 */
	@PostMapping("/f020001/T002")
	public String f020001T002(@RequestParam("search_name") String search_name,
			@RequestParam("select_state") String select_state, @RequestParam("search_account") String search_account,
			@RequestParam("search_phone") String search_phone, Model model) {
		F020001Params params = new F020001Params();

		F020001EntityIn entityin = new F020001EntityIn();

		entityin.setSearch_name(search_name);

		entityin.setSearch_account(search_account);

		entityin.setSearch_phone(search_phone);

		entityin.setSelect_state(select_state);

		F020001EntityOut entityOut = f020001service.service03(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f020001Params", params);

		return "dashboard :: select1";
	}

	/**
	 * 上传图片
	 * 
	 * @parameter F020001Params params
	 * @return String
	 */
	@RequestMapping("/f020001/T004")
	@ResponseBody
	public Map<String, Object> f020001T004(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		ImgUtil.CommitImg(file, Constant.STR_0);
		Map<String, Object> map = new HashMap<String, Object>();
		String name = "ok";
		map.put("成功了", name);
		return map;
	}

	/**
	 * 活动发布
	 * 
	 * @parameter F020001Params params
	 * @return String
	 */
	@RequestMapping("/f020001/T007")
	@ResponseBody
	public Map<String, Object> f020001T007(@RequestParam("activity_head") String activity_head,
			@RequestParam("activity_position") String activity_position,
			@RequestParam("activity_check") String activity_check,
			@RequestParam("activity_sttymd") String activity_sttymd,
			@RequestParam("activity_endymd") String activity_endymd,
			@RequestParam("activity_img1") MultipartFile activity_img1,
			@RequestParam("activity_img2") MultipartFile activity_img2,
			@RequestParam("activity_img3") MultipartFile activity_img3,
			@RequestParam("activity_img4") MultipartFile activity_img4,
			@RequestParam("activity_img5") MultipartFile activity_img5,
			@RequestParam("activity_editor") String activity_editor, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		F020001EntityIn entityin = new F020001EntityIn();

		F020001EntityOut entityOut = f020001service.service07(entityin);
		return map;
	}

}
