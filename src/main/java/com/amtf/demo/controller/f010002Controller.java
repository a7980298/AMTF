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

import com.amtf.demo.entityin.F010002entityIn;
import com.amtf.demo.entityout.F010002entityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.params.F010001Params;
import com.amtf.demo.params.F010002Params;
import com.amtf.demo.service.f010002Service;
import com.amtf.demo.user.LogInFo;
import com.amtf.demo.util.Constant;
import com.amtf.demo.util.ImgUtil;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.ValiDationUtil;

@Controller
public class f010002Controller extends ValiDationUtil {

	@Autowired
	f010002Service f010002service;

	/**
	 * 初始化
	 * 
	 * @parameter F010002Params params
	 * @return String
	 */
	@RequestMapping("/f010002")
	public String f010002S001(F010002Params params, Model model) {

		F010002entityIn entityin = new F010002entityIn();

		ParameterUtil.copyParameter(entityin, params);

		F010002entityOut entityOut = f010002service.service01(entityin);

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

		ParameterUtil.closeSession();
		F010001Params f01params = new F010001Params();

		model.addAttribute("f010001Params", f01params);

		return "login";
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

		F010002entityIn entityin = new F010002entityIn();

		F010002entityOut entityOut = f010002service.service02(entityin);
		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);
		model.addAttribute("f010002Params", params);
		return "f010002";
	}

	/**
	 * 修改用户信息
	 * 
	 * @parameter F010002Params params
	 * @return String
	 */
	@RequestMapping("/f010002/T002")
	public String f010002T002(F010002Params params, Model model) {

		F010002entityIn entityin = new F010002entityIn();

		ParameterUtil.copyParameter(entityin, params);

		F010002entityOut entityOut = f010002service.service03(entityin);

		String isUpdatUserOk = entityOut.getIsUpdatUserOk();

		entityOut = f010002service.service01(entityin);

		entityOut.setIsUpdatUserOk(isUpdatUserOk);

		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f010002Params", params);

		return "main";
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
		F010001Params f010001params=new F010001Params();
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

		F010002entityIn entityin = new F010002entityIn();

		entityin.setUpdnotice_id(id);

		F010002entityOut entityOut = f010002service.service04(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f010002Params", params);

		return "main :: select5";
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

		F010002entityIn entityin = new F010002entityIn();

		entityin.setUpdnotice_id(id);

		F010002entityOut entityOut = f010002service.service05(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f010002Params", params);

		return "main :: select7";
	}
	
	/**
	 * 参加活动
	 * 
	 * @parameter F020001Params params
	 * @return String
	 */
	@RequestMapping("/f010002/T006")
	@ResponseBody
	public Map<String, Object> f010002T006(@RequestParam("id") String id, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		F010002entityIn entityin = new F010002entityIn();

		entityin.setActiyity_id(id);

		F010002entityOut entityOut = f010002service.service06(entityin);
		map.put("isuseractivity", entityOut.getInsert10());
		return map;
	}
}
