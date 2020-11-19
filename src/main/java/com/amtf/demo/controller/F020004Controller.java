
package com.amtf.demo.controller;

import com.amtf.demo.entityin.F020004EntityIn;
import com.amtf.demo.entityin.F020004EntityIn;
import com.amtf.demo.entityout.F020004EntityOut;
import com.amtf.demo.f020005entity.WangEditor;
import com.amtf.demo.params.F020004Params;
import com.amtf.demo.service.F020004Service;
import com.amtf.demo.util.ImgUtil;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.ValiDationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class F020004Controller extends ValiDationUtil {

	@Autowired
	F020004Service f020004service;

	/**
	 * 初始化
	 * 
	 * @parameter F020004Params params
	 * @return String
	 */
	@RequestMapping("/f020004")
	public String f020004S001(F020004Params params, Model model) {

		F020004EntityIn entityin = new F020004EntityIn();

		ParameterUtil.copyParameter(entityin, params);

		F020004EntityOut entityOut = f020004service.service01(entityin);

		// 将值copy赋值
		ParameterUtil.copyParameter(params, entityOut);

		model.addAttribute("f020004Params", params);

		return "admin_allnotices";
	}

	/**
	 * 发布更新通知
	 *
	 * @parameter F020004Params params
	 * @return String
	 */
	@RequestMapping("/f020004/T001")
	@ResponseBody
	public Map<String, Object> f020004T001(@RequestParam("release_name") String release_name,
										   @RequestParam("release_head") String release_head, Model model) {

		F020004EntityIn entityin = new F020004EntityIn();
		entityin.setRelease_head(release_head);
		entityin.setRelease_name(release_name);

		f020004service.service02(entityin);
		Map<String, Object> map = new HashMap<String, Object>();
		String name = "1";
		map.put("updonticey", name);

		return map;
	}

	/**
	 * 初始化
	 *
	 * @parameter F020005Params params
	 * @return String
	 */
	@RequestMapping(value = "/f020004/T002", method = RequestMethod.POST)
	@ResponseBody
		public WangEditor f020004T002(@RequestParam("myFile") MultipartFile multipartFile,
								  HttpServletRequest request) {
		try {
			String[] str = { ImgUtil.wangEdito_CommitImg(multipartFile,"C:/wangEdito_AllnoticesImg/") };
			WangEditor we = new WangEditor();
			we.setData(str);
			return we;
		} catch (Exception e) {
			System.out.println("上传文件失败"+ e);
		}
		return null;
	}
}
