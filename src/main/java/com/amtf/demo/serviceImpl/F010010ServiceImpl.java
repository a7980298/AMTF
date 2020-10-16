package com.amtf.demo.serviceImpl;

import org.springframework.stereotype.Service;

import com.amtf.demo.entityin.F010010EntityIn;
import com.amtf.demo.entityout.F010010EntityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.service.F010010Service;
import com.amtf.demo.user.LogInFo;
import com.amtf.demo.util.ParameterUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class F010010ServiceImpl implements F010010Service {

	/**
	 * 初期化
	 */
	public F010010EntityOut service01(F010010EntityIn entityIn) throws ErrListException {

		F010010EntityOut entityout = new F010010EntityOut();
		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();
		// 用户信息
		entityout.setLogInFo(loginfo);

		return entityout;
	}
}
