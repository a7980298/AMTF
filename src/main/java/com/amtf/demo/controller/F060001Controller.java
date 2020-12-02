package com.amtf.demo.controller;

import com.amtf.demo.f020005entity.WangEditor;
import com.amtf.demo.util.Constant;
import com.amtf.demo.util.ImgUtil;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.amtf.demo.entityin.F060001EntityIn;
import com.amtf.demo.entityout.F060001EntityOut;
import com.amtf.demo.params.F060001Params;
import com.amtf.demo.service.F060001Service;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.ValiDationUtil;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class F060001Controller extends ValiDationUtil {

	@Autowired
	F060001Service f060001service;

	/**
	 * 初始化
	 * 
	 * @parameter F060001Params params
	 * @return String
	 */
	@RequestMapping("/f060001")
	public String f060001S001(F060001Params params, Model model) {

		F060001EntityIn entityin = new F060001EntityIn();

		ParameterUtil.copyParameter(entityin, params);

		F060001EntityOut entityOut = f060001service.service01(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f060001Params", params);

		return "qa";
	}
	/**
	 * 发布问题
	 *
	 * @parameter F060001Params params
	 * @return String
	 */
	@RequestMapping(value = "/f060001/T001", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> f060001T001(@RequestBody JSONObject data,
							HttpServletRequest request) {
		F060001EntityIn entityin = new F060001EntityIn();
		entityin.setSubmitjson(JSONObject.fromObject(data));
		F060001EntityOut entityOut = f060001service.service02(entityin);

		Map<String,Object> maps = new HashMap<String,Object>();

		maps.put("insert1",entityOut.getInsert1());
		return maps;
	}
	/**
	 * wangeditor上传图片
	 *
	 * @parameter F060001Params params
	 * @return String
	 */
	@RequestMapping(value = "/f060001/T002", method = RequestMethod.POST)
	@ResponseBody
	public WangEditor f060001T002(@RequestParam("myFile") MultipartFile multipartFile,
								  HttpServletRequest request) {
		try {
			String[] str = { ImgUtil.wangEdito_CommitImg(multipartFile, Constant.PATH_WANGEDITO_QAIMG) };
			WangEditor we = new WangEditor();
			we.setData(str);
			return we;
		} catch (Exception e) {
			System.out.println("上传文件失败"+ e);
		}
		return null;
	}

	/**
	 * 回答问题
	 *
	 * @parameter F060001Params params
	 * @return String
	 */
	@RequestMapping(value = "/f060001/T003", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> f060001T003(@RequestBody JSONObject data, HttpServletRequest request) {
		F060001EntityIn entityin = new F060001EntityIn();
		entityin.setSubmitjson(JSONObject.fromObject(data));
		F060001EntityOut entityOut = f060001service.service03(entityin);

		Map<String,Object> maps = new HashMap<String,Object>();

		maps.put("insert4",entityOut.getInsert4());
		return maps;
	}
}
