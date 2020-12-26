package com.amtf.demo.controller;

import com.amtf.demo.entityin.F040001EntityIn;
import com.amtf.demo.entityin.F060001EntityIn;
import com.amtf.demo.entityout.F040001EntityOut;
import com.amtf.demo.entityout.F060001EntityOut;
import com.amtf.demo.params.F060001Params;
import com.amtf.demo.util.ParameterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amtf.demo.params.F040001Params;
import com.amtf.demo.service.F040001Service;
import com.amtf.demo.util.ValiDationUtil;
import org.springframework.web.bind.annotation.RequestParam;
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

	/**
	 * 刷新评论
	 * @parameter F060001params
	 * @return String
	 */
	@PostMapping("/f040001/T006")
	public String f040001T006(@RequestParam("video_id") String video_id, Model model) {
		F040001Params params = new F040001Params();

		F040001EntityIn entityin = new F040001EntityIn();

		entityin.setVideo_id(video_id);

		F040001EntityOut entityOut = f040001service.service07(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f040001Params", params);

		return "video_view :: commentList";
	}

	/**
	 * 添加回复评论
	 *
	 * @parameter F040001Params params
	 * @return String
	 */
	@RequestMapping("/f040001/T007")
	@ResponseBody
	public Map<String,Object> f040001T007(F040001Params params, Model model) {
		F040001EntityIn entityin = new F040001EntityIn();

		ParameterUtil.copyParameter(entityin, params);

		F040001EntityOut entityOut = f040001service.service08(entityin);
		Map<String,Object> maps = new HashMap<String,Object>();

		maps.put("isrcommentreply",entityOut.getInsert13());
		return maps;
	}

	/**
	 * 展开回复
	 *
	 * @parameter F040001Params params
	 * @return String
	 */
	@RequestMapping("/f040001/T008")
	@ResponseBody
	public Map<String,Object> f040001T008(F040001Params params, Model model) {
		F040001EntityIn entityin = new F040001EntityIn();

		ParameterUtil.copyParameter(entityin, params);

		F040001EntityOut entityOut = f040001service.service09(entityin);
		Map<String,Object> maps = new HashMap<String,Object>();

		maps.put("replylist",entityOut.getReplylist());
		return maps;
	}

	/**
	 * 评论点赞
	 *
	 * @parameter F040001Params params
	 * @return String
	 */
	@RequestMapping("/f040001/T009")
	@ResponseBody
	public Map<String,Object> f040001T009(F040001Params params, Model model) {
		F040001EntityIn entityin = new F040001EntityIn();

		ParameterUtil.copyParameter(entityin, params);

		F040001EntityOut entityOut = f040001service.service10(entityin);
		Map<String,Object> maps = new HashMap<String,Object>();

		maps.put("ispraise",entityOut.getSelect15());
		return maps;
	}

	/**
	 * 评论点赞
	 *
	 * @parameter F040001Params params
	 * @return String
	 */
	@RequestMapping("/f040001/T010")
	@ResponseBody
	public Map<String,Object> f040001T010(F040001Params params, Model model) {
		F040001EntityIn entityin = new F040001EntityIn();

		ParameterUtil.copyParameter(entityin, params);

		F040001EntityOut entityOut = f040001service.service11(entityin);
		Map<String,Object> maps = new HashMap<String,Object>();

		maps.put("searchlist",entityOut.getSearch_headlist());
		return maps;
	}
}
