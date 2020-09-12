package com.amtf.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.amtf.demo.dao.f010001Dao;
import com.amtf.demo.entityin.F010001entityIn;
import com.amtf.demo.entityout.F010001entityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.f010001entity.f010001_select1entity;
import com.amtf.demo.service.f010001Service;
import com.amtf.demo.user.LogInFo;
import com.amtf.demo.util.CommonUtil;
import com.amtf.demo.util.FixedNumberUtil;
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
		LogInFo loginfo = new LogInFo();
		loginfo.setUser_Account(entityIn.getUser_Account());
		loginfo.setUser_Password(entityIn.getUser_Password());
		// 判断是否需要保存密码
		/*
		 * if (!CommonUtil.isEmpty(entityIn.getRemember())) { // 存入Cookie中
		 * ParameterUtil.setCookie(loginfo); }
		 */
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
		if (!CommonUtil.isEmpty(ParameterUtil.getSession())) {
			throw new ErrListException(entityIn, entityIn.getIViewId(), "该用户已登录!");
		}
		// 用户信息存入Session
		ParameterUtil.setSession(select1entity);

		entityout.setBol02(FixedNumberUtil.STR_1);
		return entityout;
	}

	public F010001entityOut service02(F010001entityIn entityIn) throws ErrListException {
		F010001entityOut entityout = new F010001entityOut();

		return entityout;
	}
}
