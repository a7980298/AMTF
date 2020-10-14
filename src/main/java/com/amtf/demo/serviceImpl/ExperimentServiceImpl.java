package com.amtf.demo.serviceImpl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.amtf.demo.entityin.ExperimentEntityIn;
import com.amtf.demo.entityout.ExperimentEntityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.service.ExperimentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExperimentServiceImpl implements ExperimentService {

	public ExperimentEntityOut service01(ExperimentEntityIn entityIn, HttpServletRequest request)
			throws ErrListException {

		ExperimentEntityOut entityout = new ExperimentEntityOut();

		// 账户
		entityout.setUser_Account(entityIn.getUser_Account());
		// 密码
		entityout.setUser_Password(entityIn.getUser_Password());

		return entityout;
	}

	@Override
	public ExperimentEntityOut service02(ExperimentEntityIn entityin) throws ErrListException {
		// TODO Auto-generated method stub
		return null;
	}
}
