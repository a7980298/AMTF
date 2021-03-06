package com.amtf.demo.serviceImpl;

import org.springframework.stereotype.Service;

import com.amtf.demo.entityin.F010007EntityIn;
import com.amtf.demo.entityout.F010007EntityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.service.F010007Service;
import com.amtf.demo.user.LogInFo;
import com.amtf.demo.util.ParameterUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class F010007ServiceImpl implements F010007Service {

	/**
	 * 初期化
	 */
	@Override
	public F010007EntityOut service01(F010007EntityIn entityIn) throws ErrListException {

		F010007EntityOut entityout = new F010007EntityOut();
		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();
		// 用户信息
		entityout.setLogInFo(loginfo);

		return entityout;
	}
}
