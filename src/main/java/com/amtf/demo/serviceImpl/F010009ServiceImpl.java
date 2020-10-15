package com.amtf.demo.serviceImpl;

import org.springframework.stereotype.Service;

import com.amtf.demo.entityin.F010009EntityIn;
import com.amtf.demo.entityout.F010009EntityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.service.F010009Service;
import com.amtf.demo.user.LogInFo;
import com.amtf.demo.util.ParameterUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class F010009ServiceImpl implements F010009Service {

	/**
	 * 初期化
	 */
	public F010009EntityOut service01(F010009EntityIn entityIn) throws ErrListException {

		F010009EntityOut entityout = new F010009EntityOut();
		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();
		// 用户信息
		entityout.setLogInFo(loginfo);

		return entityout;
	}
}
