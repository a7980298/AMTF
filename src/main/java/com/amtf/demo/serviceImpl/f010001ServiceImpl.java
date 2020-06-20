package com.amtf.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.amtf.demo.dao.f010001Dao;
import com.amtf.demo.entityin.F010001entityIn;
import com.amtf.demo.entityout.F010001entityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.f010001entity.f010001_select1entity;
import com.amtf.demo.f010001entity.f010001_select2entity;
import com.amtf.demo.service.f010001Service;
import com.amtf.demo.util.CommonUtil;
import com.amtf.demo.util.ParameterUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class f010001ServiceImpl implements f010001Service {

	@Autowired
	private final f010001Dao f010001dao;

	public F010001entityOut service01(F010001entityIn entityIn) throws ErrListException {

		F010001entityOut entityout = new F010001entityOut();

		f010001_select1entity select1entity = new f010001_select1entity();
		if (!CommonUtil.isEmpty(entityIn.getUser_Password())) {
			// MD5加密
			String md5pwd = DigestUtils.md5DigestAsHex(entityIn.getUser_Password().getBytes());

			// 用户是否正确
			select1entity = f010001dao.f010001_Select1(entityIn.getUser_Account(), md5pwd);

			// 判断用户密码是否正确
			if (CommonUtil.isEmpty(select1entity)) {
				// entityout.setPwdbol(FixedNumberUtil.STR_0);
				throw new ErrListException(entityIn, entityIn.getIViewId(), "账户密码输入不正确!");
			}
		} else {
			throw new ErrListException(entityIn, entityIn.getIViewId(), "账户密码输入不能是空!");
		}
		// 根据权限获取导航栏
		List<f010001_select2entity> select2 = f010001dao.f010001_Select2(select1entity.getUser_power());

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
		entityout.setUser_Account(entityIn.getUser_Account());
		// 密码
		entityout.setUser_Password(entityIn.getUser_Password());
		// 导航栏
		entityout.setNavigation_bar(navigation_bar);
		// 用户信息存入Session
		ParameterUtil.setSession(select1entity);

		return entityout;
	}

	public F010001entityOut service02(F010001entityIn entityIn) throws ErrListException {
		F010001entityOut entityout = new F010001entityOut();

		return entityout;
	}
}
