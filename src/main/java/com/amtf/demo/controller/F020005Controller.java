
package com.amtf.demo.controller;

import com.amtf.demo.entityin.F020005EntityIn;
import com.amtf.demo.entityin.F020005EntityIn;
import com.amtf.demo.entityout.F020005EntityOut;
import com.amtf.demo.entityout.F020005EntityOut;
import com.amtf.demo.f020005entity.WangEditor;
import com.amtf.demo.params.F020005Params;
import com.amtf.demo.service.F020005Service;
import com.amtf.demo.util.Constant;
import com.amtf.demo.util.ImgUtil;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.ValiDationUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.ErrorManager;

@Controller
public class F020005Controller extends ValiDationUtil {

	@Autowired
	F020005Service f020005service;

	/**
	 * 初始化
	 * 
	 * @parameter F020005Params params
	 * @return String
	 */
	@RequestMapping("/f020005")
	public String f020005S001(F020005Params params, Model model) {

		F020005EntityIn entityin = new F020005EntityIn();

		ParameterUtil.copyParameter(entityin, params);

		F020005EntityOut entityOut = f020005service.service01(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f020005Params", params);

		return "admin_avtivity";
	}

	/**
	 * 活动发布
	 *
	 * @parameter F020005Params params
	 * @return String
	 */
	@RequestMapping("/f020005/T001")
	@ResponseBody
	public Map<String, Object> f020005T001(@RequestParam("activity_head") String activity_head,
										   @RequestParam("activity_position") String activity_position,
										   @RequestParam("activity_check") String activity_check,
										   @RequestParam("activity_sttymd") String activity_sttymd,
										   @RequestParam("activity_endymd") String activity_endymd,
										   @RequestParam("activity_editor") String activity_editor, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		F020005EntityIn entityin = new F020005EntityIn();
		// 活动标题
		entityin.setActivity_head(activity_head);
		// 活动地址
		entityin.setActivity_position(activity_position);
		// 参与级别
		entityin.setActivity_check(activity_check);
		// 开始日期
		entityin.setActivity_sttymd(activity_sttymd);
		// 结束日期
		entityin.setActivity_endymd(activity_endymd);
		// 活动内容
		entityin.setActivity_editor(activity_editor);
		F020005EntityOut entityOut = f020005service.service02(entityin);
		map.put("isactivity", entityOut.getIsactivity());
		return map;
	}

	/**
	 * wangeditor上传图片
	 *
	 * @parameter F020005Params params
	 * @return String
	 */
	@RequestMapping(value = "/f020005/T002", method = RequestMethod.POST)
	@ResponseBody
	public WangEditor f020005T002(@RequestParam("myFile") MultipartFile multipartFile,
							  HttpServletRequest request) {
		try {
			String[] str = { ImgUtil.wangEdito_CommitImg(multipartFile, Constant.PATH_WANGEDITO_ACTIVITYIMG) };
			WangEditor we = new WangEditor();
			we.setData(str);
			return we;
		} catch (Exception e) {
			System.out.println("上传文件失败"+ e);
		}
		return null;
	}
}
