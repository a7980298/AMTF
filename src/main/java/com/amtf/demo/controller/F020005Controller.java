
package com.amtf.demo.controller;

import com.amtf.demo.entityin.F020005EntityIn;
import com.amtf.demo.entityin.F020005EntityIn;
import com.amtf.demo.entityout.F020005EntityOut;
import com.amtf.demo.entityout.F020005EntityOut;
import com.amtf.demo.params.F020005Params;
import com.amtf.demo.service.F020005Service;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.ValiDationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

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
	public Map<String, Object> f020005T007(@RequestParam("activity_head") String activity_head,
										   @RequestParam("activity_position") String activity_position,
										   @RequestParam("activity_check") String activity_check,
										   @RequestParam("activity_sttymd") String activity_sttymd,
										   @RequestParam("activity_endymd") String activity_endymd,
										   @RequestParam("activity_img1") MultipartFile activity_img1,
										   @RequestParam("activity_img2") MultipartFile activity_img2,
										   @RequestParam("activity_img3") MultipartFile activity_img3,
										   @RequestParam("activity_img4") MultipartFile activity_img4,
										   @RequestParam("activity_img5") MultipartFile activity_img5,
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
		// igm1
		entityin.setActivity_img1(activity_img1);
		// igm2
		entityin.setActivity_img2(activity_img2);
		// igm3
		entityin.setActivity_img3(activity_img3);
		// igm4
		entityin.setActivity_img4(activity_img4);
		// igm5
		entityin.setActivity_img5(activity_img5);
		// 活动内容
		entityin.setActivity_editor(activity_editor);
		F020005EntityOut entityOut = f020005service.service02(entityin);
		map.put("isactivity", entityOut.getIsactivity());
		return map;
	}
}
