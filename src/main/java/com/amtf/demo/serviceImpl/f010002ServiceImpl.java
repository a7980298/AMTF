package com.amtf.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amtf.demo.dao.f010001Dao;
import com.amtf.demo.dao.f010002Dao;
import com.amtf.demo.entityin.F010002entityIn;
import com.amtf.demo.entityout.F010002entityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.f010001entity.f010001_select2entity;
import com.amtf.demo.f010001entity.f010001_select3entity;
import com.amtf.demo.service.f010002Service;
import com.amtf.demo.user.LogInFo;
import com.amtf.demo.util.FenYe;
import com.amtf.demo.util.StringUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class f010002ServiceImpl implements f010002Service {

	@Autowired
	HttpServletRequest request;

	@Autowired
	private final f010001Dao f010001dao;

	@Autowired
	private final f010002Dao f010002dao;

	public F010002entityOut service01(F010002entityIn entityIn) throws ErrListException {

		F010002entityOut entityout = new F010002entityOut();

		LogInFo loginfo = new LogInFo();
		loginfo = (LogInFo) request.getSession().getAttribute("loginfo");
		// 根据权限获取导航栏
		List<f010001_select2entity> select2 = f010001dao.f010001_Select2(loginfo.getUser_power());

		// 将导航栏数据整合成map
		Map<String, List<f010001_select2entity>> navigation_bar = select2.stream()
				.collect(Collectors.toMap(f010001_select2entity::getPower_type, s -> {
					List<f010001_select2entity> studentNameList = new ArrayList<>();
					studentNameList.add(s);
					return studentNameList;
				},
						// 重复时将现在的值全部加入到之前的值内
						(List<f010001_select2entity> value1, List<f010001_select2entity> value2) -> {
							value1.addAll(value2);
							return value1;
						}));
		// 账户
		entityout.setUser_Account(loginfo.getUser_Account());
		// 密码
		entityout.setUser_Password(loginfo.getUser_Password());
		// 导航栏
		entityout.setNavigation_bar(navigation_bar);

		f010001_select3entity select4 = f010001dao.f010001_Select3();

		entityout.setSelect4(select4);
		return entityout;
	}

	@Override
	public F010002entityOut service02(F010002entityIn entityin) throws ErrListException {
		F010002entityOut entityout = new F010002entityOut();
		// TODO Auto-generated method stub
		FenYe fenYe = new FenYe();
		fenYe.setFrequency(3);
		fenYe.setCount(f010002dao.f010002_Select1Count());
		fenYe.setFenyeList(f010002dao.f010002_Select1(StringUtil.toStr(fenYe.getCurrent() * fenYe.getFrequency()),
				StringUtil.toStr((fenYe.getCurrent() + 1) * fenYe.getFrequency())));
		fenYe.setPages(fenYe.getCount() / fenYe.getFrequency());
		entityout.setFenye(fenYe);
		return entityout;
	}
}
