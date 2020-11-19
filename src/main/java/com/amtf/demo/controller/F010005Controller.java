
package com.amtf.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.amtf.demo.entityin.F010002EntityIn;
import com.amtf.demo.entityout.F010002EntityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.f010002entity.F010002_Select9Entity;
import com.amtf.demo.params.F010002Params;
import com.amtf.demo.user.LogInFo;
import com.amtf.demo.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amtf.demo.entityin.F010005EntityIn;
import com.amtf.demo.entityout.F010005EntityOut;
import com.amtf.demo.params.F010005Params;
import com.amtf.demo.service.F010005Service;

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
	public Map<String, Object> f010005T001(@RequestParam("id") String id, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		F010005EntityIn entityin = new F010005EntityIn();

		entityin.setActivity_id(id);

		F010005EntityOut entityOut = f010005service.service02(entityin);
		map.put("isuseractivity", entityOut.getInsert10());
		map.put("useractivity_count", entityOut.getUseractivity_count());
		return map;
	}


	/**
	 * 详细活动
	 *
	 * @parameter F010005Params params
	 * @return String
	 */
	@RequestMapping("/f010005/T002")
	public String f010005T002(F010005Params params, Model model) {

		F010005EntityIn entityin = new F010005EntityIn();

		ParameterUtil.copyParameter(entityin, params);

		F010005EntityOut entityOut = f010005service.service03(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f010005Params", params);

		return "activity_view";
	}

	/**
	 * 发表评论
	 *
	 * @parameter F010005Params params
	 * @return String
	 */
	@RequestMapping("/f010005/T003")
	@ResponseBody
	public Map<String, Object> f010005T003(@RequestParam("id") String id, @RequestParam("text") String text,HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		F010005EntityIn entityin = new F010005EntityIn();

		entityin.setActivity_id(id);
		entityin.setActivity_text(text);

		F010005EntityOut entityOut = f010005service.service04(entityin);

		map.put("iscomment", entityOut.getInsert6());

		return map;
	}

	/**
	 * 刷新评论
	 *
	 * @parameter F010005Params params
	 * @return String
	 */
	@PostMapping("/f010005/T004")
	public String f010005T004(@RequestParam(value="id",required=true) String id,@RequestParam(defaultValue = "1") Integer pageNum, Model model) {
		F010005Params params = new F010005Params();

		F010005EntityIn entityin = new F010005EntityIn();
		entityin.setActivity_id(id);
		entityin.setPageNum(pageNum);
		F010005EntityOut entityOut = f010005service.service05(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f010005Params", params);

		return "activity_view :: commentselect5";
	}

	/**
	 * 发表二级评论
	 *
	 * @parameter F010005Params params
	 * @return String
	 */
	@RequestMapping("/f010005/T005")
	@ResponseBody
	public Map<String, Object> f010005T005(@RequestParam("id") String id, @RequestParam("text") String text,HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		F010005EntityIn entityin = new F010005EntityIn();

		entityin.setActivity_id(id);
		entityin.setActivity_text(text);

		F010005EntityOut entityOut = f010005service.service06(entityin);

		map.put("isreply", entityOut.getInsert8());

		return map;
	}

	/**
	 * 活动点赞
	 *
	 * @parameter F010005Params params
	 * @return String
	 */
	@RequestMapping("/f010005/T006")
	@ResponseBody
	public Map<String, Object> f010005T006(@RequestParam("id") String id,HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		F010005EntityIn entityin = new F010005EntityIn();

		entityin.setActivity_id(id);

		F010005EntityOut entityOut = f010005service.service07(entityin);

		map.put("fabulous", entityOut.getFabulous());

		return map;
	}

	/**
	 * 删除评论
	 *
	 * @parameter F010005Params params
	 * @return String
	 */
	@RequestMapping("/f010005/T007")
	@ResponseBody
	public Map<String, Object> f010005T007(@RequestParam("id") String id,
										   @RequestParam("comment_id") String comment_id,
										   @RequestParam("level") String level,
										   HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		F010005EntityIn entityin = new F010005EntityIn();
		//活动id
		entityin.setActivity_id(id);
		//评论id
		entityin.setComment_id(comment_id);
		//评论级别
		entityin.setLevel(level);

		F010005EntityOut entityOut = f010005service.service08(entityin);

		map.put("comment_delete", entityOut.getDelect13());

		return map;
	}

	/**
	 * 删除评论
	 *
	 * @parameter F010005Params params
	 * @return String
	 */
	@RequestMapping("/f010005/T008")
	@ResponseBody
	public Map<String, Object> f010005T008(@RequestParam("id") String id,
										   @RequestParam("comment_id") String comment_id,
										   HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		F010005EntityIn entityin = new F010005EntityIn();
		//活动id
		entityin.setActivity_id(id);
		//评论id
		entityin.setComment_id(comment_id);

		F010005EntityOut entityOut = f010005service.service09(entityin);

		map.put("comment_fabulous", entityOut.getComment_fabulous());

		return map;
	}

	/**
	 * 关注发布人
	 *
	 * @parameter F010005Params params
	 * @return String
	 */
	@RequestMapping("/f010005/T009")
	@ResponseBody
	public Map<String, Object> f010005T009(@RequestParam("id") String id, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		F010005EntityIn entityin = new F010005EntityIn();
		//用户id
		entityin.setActivity_id(id);

		F010005EntityOut entityOut = f010005service.service10(entityin);

		map.put("attention", entityOut.getIsattention());

		return map;
	}

	/**
	 * 活动一栏
	 *
	 * @parameter F010005Params params
	 * @return String
	 */
	@PostMapping("/f010005/T010")
	public String f010005T010(@RequestParam(defaultValue = "1") Integer pageNum, Model model) {
		F010005Params params = new F010005Params();

		F010005EntityIn entityin = new F010005EntityIn();
		entityin.setPageNum(pageNum);
		F010005EntityOut entityOut = f010005service.service11(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f010005Params", params);

		return "activity :: activitylists";
	}

	/**
	 * 我参加的活动一栏
	 *
	 * @parameter F010005Params params
	 * @return String
	 */
	@PostMapping("/f010005/T011")
	public String f010005T011(@RequestParam(defaultValue = "1") Integer pageNum, Model model) {
		F010005Params params = new F010005Params();
		F010005EntityIn entityin = new F010005EntityIn();
		entityin.setPageNum(pageNum);
		F010005EntityOut entityOut = f010005service.service12(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f010005Params", params);

		return "activity :: activitylists_i";
	}

	/**
	 * 我发布的活动一栏
	 *
	 * @parameter F010005Params params
	 * @return String
	 */
	@PostMapping("/f010005/T012")
	public String f010005T012(@RequestParam(defaultValue = "1") Integer pageNum, Model model) {
		F010005Params params = new F010005Params();
		F010005EntityIn entityin = new F010005EntityIn();
		entityin.setPageNum(pageNum);
		F010005EntityOut entityOut = f010005service.service13(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f010005Params", params);

		return "activity :: activitylists_s";
	}
}
