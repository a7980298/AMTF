package com.amtf.demo.controller;

import com.amtf.demo.entityin.F040001EntityIn;
import com.amtf.demo.entityout.F040001EntityOut;
import com.amtf.demo.util.ParameterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amtf.demo.params.F040001Params;
import com.amtf.demo.service.F040001Service;
import com.amtf.demo.util.ValiDationUtil;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class F040001Controller extends ValiDationUtil{
	
	@Autowired
	F040001Service f040001service;
	
	/**
	 * 初始化
	 * 
	 * @parameter F040001Params params
	 * @return String
	 */
	@RequestMapping("/f040001")
	public String f040001S001(F040001Params params, Model model) {

		F040001EntityIn entityin = new F040001EntityIn();

		ParameterUtil.copyParameter(entityin, params);

		F040001EntityOut entityOut = f040001service.service01(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f040001Params", params);

		return "video";
	}

	/**
	 * 上传视频
	 *
	 * @parameter F040001Params params
	 * @return String
	 */
	@RequestMapping("/f040001/T001")
	@ResponseBody
	public Map<String,Object> f040001T001(F040001Params params, Model model) {
		F040001EntityIn entityin = new F040001EntityIn();

		ParameterUtil.copyParameter(entityin, params);

		F040001EntityOut entityOut = f040001service.service02(entityin);
		Map<String,Object> maps = new HashMap<String,Object>();

		maps.put("video_commit",entityOut.getInsert2());
		return maps;
	}

	/**
	 * 观看视频
	 *
	 * @parameter F040001Params params
	 * @return String
	 */
	@RequestMapping("/f040001/T002")
	public String f040001T002(F040001Params params, Model model) {

		F040001EntityIn entityin = new F040001EntityIn();

		ParameterUtil.copyParameter(entityin, params);

		F040001EntityOut entityOut = f040001service.service03(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f040001Params", params);

		return "video_view";
	}

	/**
	 * 发送弹幕
	 *
	 * @parameter F040001Params params
	 * @return String
	 */
	@RequestMapping("/f040001/T003")
	@ResponseBody
	public Map<String,Object> f040001T003(F040001Params params, Model model) {
		F040001EntityIn entityin = new F040001EntityIn();

		ParameterUtil.copyParameter(entityin, params);

		F040001EntityOut entityOut = f040001service.service04(entityin);
		Map<String,Object> maps = new HashMap<String,Object>();

		maps.put("isbarrage",entityOut.getInsert9());
		return maps;
	}

	/**
	 * 获取弹幕
	 *
	 * @parameter F040001Params params
	 * @return String
	 */
	@RequestMapping("/f040001/T004")
	@ResponseBody
	public Map<String,Object> f040001T004(F040001Params params, Model model) {
		F040001EntityIn entityin = new F040001EntityIn();

		ParameterUtil.copyParameter(entityin, params);

		F040001EntityOut entityOut = f040001service.service05(entityin);
		Map<String,Object> maps = new HashMap<String,Object>();

		maps.put("barrageList",entityOut.getBarrageList());
		return maps;
	}

	/**
	 * 发表评论
	 *
	 * @parameter F040001Params params
	 * @return String
	 */
	@RequestMapping("/f040001/T005")
	@ResponseBody
	public Map<String,Object> f040001T005(F040001Params params, Model model) {
		F040001EntityIn entityin = new F040001EntityIn();

		ParameterUtil.copyParameter(entityin, params);

		F040001EntityOut entityOut = f040001service.service06(entityin);
		Map<String,Object> maps = new HashMap<String,Object>();

		maps.put("iscomment",entityOut.getInsert11());
		return maps;
	}
}
