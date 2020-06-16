package com.amtf.demo.serviceImpl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amtf.demo.dao.experimentDao;
import com.amtf.demo.entityin.experimententityIn;
import com.amtf.demo.entityout.experimententityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.service.experimentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class experimentServiceImpl implements experimentService {

	public experimententityOut service01(experimententityIn entityIn, HttpServletRequest request)
			throws ErrListException {

		experimententityOut entityout = new experimententityOut();

		// 账户
		entityout.setUser_Account(entityIn.getUser_Account());
		// 密码
		entityout.setUser_Password(entityIn.getUser_Password());

		return entityout;
	}

	@Override
	public experimententityOut service02(experimententityIn entityin) throws ErrListException {
		// TODO Auto-generated method stub
		return null;
	}
}
