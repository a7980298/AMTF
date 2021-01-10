
package com.amtf.demo.controller;

import com.amtf.demo.entityin.F020001EntityIn;
import com.amtf.demo.entityout.F020001EntityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.params.F020001Params;
import com.amtf.demo.service.F020001Service;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.StringUtil;
import com.amtf.demo.util.ValiDationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 人员管理画面
 */
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

	/**
	 * 查询用户信息
	 *
	 * @parameter F020001Params params
	 * @return String
	 */
	@PostMapping("/Vf020001/getUser")
	@ResponseBody
	public Object f020001T001(@RequestBody Map map, Model model) {
		F020001Params params = new F020001Params();
		params.setUserId(StringUtil.toStr(map.get("userId")));
		F020001EntityIn entityin = new F020001EntityIn();

		ParameterUtil.copyParameter(entityin, params);

		try {
			F020001EntityOut entityOut = f020001service.service02(entityin);
			// 将值copy赋值
			ParameterUtil.copyParameter(params, entityOut);
		}catch (ErrListException e){
			return e;
		}
		return params;
	}

	/**
	 * 修改认证状态
	 *
	 * @parameter F020001Params params
	 * @return String
	 */
	@PostMapping("/Vf020001/upAttestation")
	@ResponseBody
	public Object f020001T002(@RequestBody Map map, Model model) {
		F020001Params params = new F020001Params();
		//用户id
		params.setUserId(StringUtil.toStr(map.get("userId")));
		//认证状态
		params.setUserAttestation(StringUtil.toStr(map.get("userAttestation")));

		F020001EntityIn entityin = new F020001EntityIn();

		ParameterUtil.copyParameter(entityin, params);

		try {
			F020001EntityOut entityOut = f020001service.service04(entityin);
			// 将值copy赋值
			ParameterUtil.copyParameter(params, entityOut);
		}catch (ErrListException e){
			return e;
		}
		return params;
	}

	/**
	 * 修改用户的账户状态
	 *
	 * @parameter F020001Params params
	 * @return String
	 */
	@PostMapping("/Vf020001/upStatus")
	@ResponseBody
	public Object f020001T003(@RequestBody Map map, Model model) {
		F020001Params params = new F020001Params();
		//用户id
		params.setUserId(StringUtil.toStr(map.get("userId")));
		//认证状态
		params.setUserStatus(StringUtil.toStr(map.get("userStatus")));

		F020001EntityIn entityin = new F020001EntityIn();

		ParameterUtil.copyParameter(entityin, params);

		try {
			F020001EntityOut entityOut = f020001service.service07(entityin);
			// 将值copy赋值
			ParameterUtil.copyParameter(params, entityOut);
		}catch (ErrListException e){
			return e;
		}
		return params;
	}

	/**
	 * 修改用户的等级
	 *
	 * @parameter F020001Params params
	 * @return String
	 */
	@PostMapping("/Vf020001/modifyLevel")
	@ResponseBody
	public Object f020001T004(@RequestBody Map map, Model model) {
		F020001Params params = new F020001Params();
		//用户id
		params.setUserId(StringUtil.toStr(map.get("userId")));
		//等级
		params.setLevelOptionsValue(StringUtil.toStr(map.get("levelOptionsValue")));

		F020001EntityIn entityin = new F020001EntityIn();

		ParameterUtil.copyParameter(entityin, params);

		try {
			F020001EntityOut entityOut = f020001service.service08(entityin);
			// 将值copy赋值
			ParameterUtil.copyParameter(params, entityOut);
		}catch (ErrListException e){
			return e;
		}
		return params;
	}
}
