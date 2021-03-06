
package com.amtf.demo.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amtf.demo.entityin.F010002EntityIn;
import com.amtf.demo.entityout.F010002EntityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.params.F010001Params;
import com.amtf.demo.params.F010002Params;
import com.amtf.demo.service.F010002Service;
import com.amtf.demo.serviceImpl.LogInLimit;
import com.amtf.demo.user.LogInFo;
import com.amtf.demo.util.CommonUtil;
import com.amtf.demo.util.Constant;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.RedisUtils;
import com.amtf.demo.util.ValiDationUtil;

@Controller
public class F010002Controller extends ValiDationUtil {

	@Autowired
	F010002Service f010002service;

	@Autowired
	private LogInLimit commonserviceimpl;

	@Resource
	private RedisUtils redisUtils;

	/**
	 * 初始化
	 * 
	 * @parameter F010002Params params
	 * @return String
	 */
	@RequestMapping("/f010002")
	public String f010002S001(F010002Params params, Model model) {

		F010002EntityIn entityin = new F010002EntityIn();

		ParameterUtil.copyParameter(entityin, params);

		F010002EntityOut entityOut = f010002service.service01(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f010002Params", params);

		return "main";
	}

	/**
	 * 退出登录按钮押下
	 * 
	 * @parameter F010002Params params
	 * @return String
	 * @throws ErrListException
	 */
	@PostMapping("/f010002/T001")
	public String f010002T001(F010002Params params, Model model) throws ErrListException {

		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();
		// 删除登录信息
		if (!CommonUtil.isEmpty(redisUtils.get(loginfo.getUser_no() + "navigation_bar"))) {
			redisUtils.delete(loginfo.getUser_no() + "navigation_bar");
		}
		redisUtils.deleteUser("redis_key", loginfo.getUser_no());
		commonserviceimpl.users = CommonUtil.isEmpty(redisUtils.get("redis_key")) ? 0
				: redisUtils.get("redis_key").split(",").length;
		ParameterUtil.closeSession();

		return "redirect:/f010001";
	}

	/**
	 * 分页
	 * 
	 * @parameter F010002Params params
	 * @return String
	 * @throws ErrListException
	 */
	@RequestMapping("/f010002/F001")
	public String f010002F001(F010002Params params, Model model) throws ErrListException {

		F010002EntityIn entityin = new F010002EntityIn();

		F010002EntityOut entityOut = f010002service.service02(entityin);
		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);
		model.addAttribute("f010002Params", params);
		return "f010002";
	}

	/**
	 * 锁定页面
	 * 
	 * @parameter F010002Params params
	 * @return String
	 */
	@RequestMapping("/f010002/T003")
	public String f010002T003(F010002Params params, Model model) {
		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();
		F010001Params f010001params = new F010001Params();
		f010001params.setLocking(Constant.STR_1);
		f010001params.setLogInFo(loginfo);
		model.addAttribute("f010001Params", f010001params);
		return "login";
	}

	/**
	 * 标记查看过的通知
	 * 
	 * @parameter F020001Params params
	 * @return String
	 */
	@PostMapping("/f010002/T004")
	public String f010002T004(@RequestParam("id") String id, Model model) {
		F010002Params params = new F010002Params();

		F010002EntityIn entityin = new F010002EntityIn();

		entityin.setUpdnotice_id(id);

		F010002EntityOut entityOut = f010002service.service04(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f010002Params", params);

		return "head :: select5";
	}

	/**
	 * 打开选中的通知
	 * 
	 * @parameter F020001Params params
	 * @return String
	 */
	@PostMapping("/f010002/T005")
	public String f010002T005(@RequestParam("id") String id, Model model) {
		F010002Params params = new F010002Params();

		F010002EntityIn entityin = new F010002EntityIn();

		entityin.setUpdnotice_id(id);

		F010002EntityOut entityOut = f010002service.service05(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f010002Params", params);

		return "main :: select7";
	}
}
