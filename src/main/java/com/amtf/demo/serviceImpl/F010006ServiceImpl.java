package com.amtf.demo.serviceImpl;

import org.springframework.stereotype.Service;

import com.amtf.demo.entityin.F010006EntityIn;
import com.amtf.demo.entityout.F010006EntityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.service.F010006Service;
import com.amtf.demo.user.LogInFo;
import com.amtf.demo.util.ParameterUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class F010006ServiceImpl implements F010006Service {

	/**
	 * 初期化
	 */
	public F010006EntityOut service01(F010006EntityIn entityIn) throws ErrListException {

		F010006EntityOut entityout = new F010006EntityOut();
		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();
		// 用户信息
		entityout.setLogInFo(loginfo);

		return entityout;
	}
}
