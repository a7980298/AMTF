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

import com.amtf.demo.entityin.F020001entityIn;
import com.amtf.demo.entityout.F020001entityOut;
import com.amtf.demo.params.F020001Params;
import com.amtf.demo.service.f020001Service;
import com.amtf.demo.util.Constant;
import com.amtf.demo.util.ImgUtil;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.ValiDationUtil;

@Controller
public class f020001Controller extends ValiDationUtil {

	@Autowired
	f020001Service f020001service;

	/**
	 * 初始化
	 * 
	 * @parameter F020001Params params
	 * @return String
	 */
	@RequestMapping("/f020001")
	public String f010001S001(F020001Params params, Model model) {

		F020001entityIn entityin = new F020001entityIn();

		ParameterUtil.copyParameter(entityin, params);

		F020001entityOut entityOut = f020001service.service01(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f020001Params", params);

		return "dashboard";
	}

	/**
	 * 登录
	 * 
	 * @parameter F020001Params params
	 * @return String
	 */
	@RequestMapping("/f020001/T001")
	public String f010001T001(F020001Params params, Model model) {

		F020001entityIn entityin = new F020001entityIn();

		ParameterUtil.copyParameter(entityin, params);

		F020001entityOut entityOut = f020001service.service01(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f020001Params", params);

		return "f020001";
	}

	/**
	 * 搜索
	 * 
	 * @parameter F020001Params params
	 * @return String
	 */
	@PostMapping("/f020001/T002")
	public String f010001T002(@RequestParam("search_name") String search_name,
			@RequestParam("select_state") String select_state, @RequestParam("search_account") String search_account,
			@RequestParam("search_phone") String search_phone, Model model) {
		F020001Params params = new F020001Params();

		F020001entityIn entityin = new F020001entityIn();

		entityin.setSearch_name(search_name);

		entityin.setSearch_account(search_account);

		entityin.setSearch_phone(search_phone);

		entityin.setSelect_state(select_state);

		F020001entityOut entityOut = f020001service.service03(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f020001Params", params);

		return "f020001 :: select1";
	}

	/**
	 * 发布更新通知
	 * 
	 * @parameter F020001Params params
	 * @return String
	 */
	@PostMapping("/f020001/T003")
	public String f010001T003(@RequestParam("release_name") String release_name,@RequestParam("release_head") String release_head, Model model) {
		F020001Params params = new F020001Params();

		F020001entityIn entityin = new F020001entityIn();

		entityin.setRelease_head(release_head);
		entityin.setRelease_name(release_name);

		F020001entityOut entityOut = f020001service.service04(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f020001Params", params);

		return "f020001";
	}

	/**
	 * 上传图片
	 * 
	 * @parameter F020001Params params
	 * @return String
	 */
	@RequestMapping("/f020001/T004")
	@ResponseBody
	public Map<String, Object> f010001T004(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		ImgUtil.CommitImg(file, Constant.STR_0);
		Map<String, Object> map = new HashMap<String, Object>();
		String name = "ok";
		map.put("成功了", name);
		return map;
	}

	/**
	 * 生成PDF
	 * 
	 * @parameter F020001Params params
	 * @return String
	 */
	@RequestMapping("/f020001/T005")
	public String f010001T005(F020001Params params, Model model) {

		F020001entityIn entityin = new F020001entityIn();

		ParameterUtil.copyParameter(entityin, params);

		F020001entityOut entityOut = f020001service.service05(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f020001Params", params);

		return "f020001";
	}
	
	/**
	 * 刪除
	 * 
	 * @parameter F020001Params params
	 * @return String
	 */
	@PostMapping("/f020001/T006")
	public String f010001T006(@RequestParam("userid") String userid, Model model) {
		F020001Params params = new F020001Params();

		F020001entityIn entityin = new F020001entityIn();

		entityin.setUserid(userid);

		F020001entityOut entityOut = f020001service.service06(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f020001Params", params);

		return "f020001 :: selectuser";
	}


}
