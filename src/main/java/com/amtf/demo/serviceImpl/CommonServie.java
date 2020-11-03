package com.amtf.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.amtf.demo.dao.F020001Dao;
import com.amtf.demo.entityout.F020001EntityOut;
import com.amtf.demo.f010001entity.F010001_Select1Entity;
import com.amtf.demo.f020001entity.F020001_Select1Entity;
import com.amtf.demo.f020001entity.F020001_Select5Entity;
import com.amtf.demo.f020001entity.F020001_Select7Entity;
import com.amtf.demo.params.AdminParams;
import com.amtf.demo.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amtf.demo.dao.F010001Dao;
import com.amtf.demo.dao.F010002Dao;
import com.amtf.demo.f010001entity.F010001_Select2Entity;
import com.amtf.demo.f010002entity.F010002_Select4Entity;
import com.amtf.demo.params.CommonParams;
import com.amtf.demo.user.LogInFo;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author wyx
 *
 */

@Service
@RequiredArgsConstructor
public class CommonServie {
	@Autowired
	private F010001Dao f010001dao;

	@Autowired
	private final F010002Dao f010002dao;

	@Autowired
	private final F020001Dao f020001dao;

	@Resource
	private RedisUtils redisUtils;

	@Resource
	private HttpServletRequest request;

	/**
	 * 主页面导航栏和头部信息
	 */
	public void CommonServie1() {
		CommonParams commonparams = new CommonParams();
		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();
		// 根据权限获取导航栏
		List<F010001_Select2Entity> select2 = f010001dao.f010001_Select2(NumberUtil.toInt(loginfo.getUser_power()));
		String navigation_bar_redis = "";
		for (F010001_Select2Entity f010001_select2entity2 : select2) {
			navigation_bar_redis += f010001_select2entity2.getPower_path() + ",";
		}
		redisUtils.set(loginfo.getUser_email() + "navigation_bar", navigation_bar_redis);

		// 将导航栏数据整合成map
		Map<String, List<F010001_Select2Entity>> navigation_bar = select2.stream()
				.collect(Collectors.toMap(F010001_Select2Entity::getPower_type, s -> {
					List<F010001_Select2Entity> studentNameList = new ArrayList<>();
					studentNameList.add(s);
					return studentNameList;
				},
						// 重复时将现在的值全部加入到之前的值内
						(List<F010001_Select2Entity> value1, List<F010001_Select2Entity> value2) -> {
							value1.addAll(value2);
							return value1;
						}));
		// 获取未读通知
		List<F010002_Select4Entity> select5 = f010002dao.f010002_Select5(loginfo.getUser_email());
		commonparams.setLogInFo(loginfo);
		commonparams.setNavigation_bar(navigation_bar);
		// 未读通知
		commonparams.setSelect5(select5);
		request.setAttribute("main_params", commonparams);
	}

	/**
	 * 管理页面导航栏和头部信息
	 */
	public void CommonServie2() {
		AdminParams adminparams=new AdminParams();
		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();

		String imgpath = ImgUtil.getImgPath(loginfo.getUser_email());

		loginfo.setImgpath(imgpath);
		//用户信息
		adminparams.setLogInFo(loginfo);
		//管理员信息
		adminparams.setAdmin(ParameterUtil.getAdmin());

		// 根据权限获取导航栏
		List<F020001_Select7Entity> select7 = f020001dao.f020001_Select7(NumberUtil.toInt(loginfo.getUser_power()));

		// 将导航栏数据整合成map
		Map<String, List<F020001_Select7Entity>> navigation_bar = select7.stream()
				.collect(Collectors.toMap(F020001_Select7Entity::getPower_type, s -> {
							List<F020001_Select7Entity> studentNameList = new ArrayList<>();
							studentNameList.add(s);
							return studentNameList;
						},
						// 重复时将现在的值全部加入到之前的值内
						(List<F020001_Select7Entity> value1, List<F020001_Select7Entity> value2) -> {
							value1.addAll(value2);
							return value1;
						}));
		adminparams.setNavigation_bar(navigation_bar);

		request.setAttribute("main_params", adminparams);
	}
}