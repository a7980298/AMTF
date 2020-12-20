package com.amtf.demo.controller;

import com.amtf.demo.entityin.F050001EntityIn;
import com.amtf.demo.entityin.F060001EntityIn;
import com.amtf.demo.entityout.F050001EntityOut;
import com.amtf.demo.entityout.F060001EntityOut;
import com.amtf.demo.params.F050001Params;
import com.amtf.demo.service.F050001Service;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.ValiDationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class F050001Controller extends ValiDationUtil{
	
	@Autowired
	F050001Service f050001service;
	
	/**
	 * 初始化
	 * 
	 * @parameter F050001Params params
	 * @return String
	 */
	@RequestMapping("/f050001")
	public String f050001S001(F050001Params params, Model model) {
		// 新建一个实体类entityin
		F050001EntityIn entityin = new F050001EntityIn();
		// 将画面上的数据给实体类entityin
		ParameterUtil.copyParameter(entityin, params);
		// 将传给实体类的数据传给service,进行数据操作，并返回给实体类entityOut
		F050001EntityOut entityOut = f050001service.service01(entityin);
		// 然后将返回的实体类赋值给params
		ParameterUtil.copyParameter(params, entityOut);
		// 将params里的数据传给f050001Params
		model.addAttribute("f050001Params", params);

		return "news";
	}
	/**
	 * 关键字检索新闻
	 *
	 * @parameter F050001Params params
	 * @return String
	 */
	@RequestMapping(value ="/f050001/T001", method = RequestMethod.POST)
	@ResponseBody
	public String f050001T001(F050001Params params, Model model) {
		//新建一个entityin来接收前台传给后台的值
	    F050001EntityIn entityIn = new F050001EntityIn();
	    //将画面上的param值全部给entityin
		ParameterUtil.copyParameter(entityIn,params);
		//新建一个entityout来接收后台传给前台的值
		F050001EntityOut entityOut = f050001service.service02(entityIn);
		//将画面上的entityOut值全部给param
		ParameterUtil.copyParameter(params,entityOut);
		model.addAttribute("f050001Params", params);

		return "news";

	}

	/**
	 * 添加新闻
	 *
	 * @parameter F050001Params params
	 * @return String
	 */

	@RequestMapping(value ="/f050001/T002", method = RequestMethod.POST)
	@ResponseBody
	public String f050001T002(F050001Params params, Model model) {
		//新建一个entityin来接收前台传给后台的值
		F050001EntityIn entityIn = new F050001EntityIn();
		//将画面上的param值全部给entityin
		ParameterUtil.copyParameter(entityIn,params);
		//新建一个entityout来接收后台传给前台的值
		F050001EntityOut entityOut = f050001service.service03(entityIn);
		//将画面上的entityOut值全部给param
		ParameterUtil.copyParameter(params,entityOut);
		model.addAttribute("f050001Params", params);

		return "news";

	}

}
