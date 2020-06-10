package com.amtf.demo.serviceImpl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amtf.demo.dao.f010001Dao;
import com.amtf.demo.entityin.F010002entityIn;
import com.amtf.demo.entityout.F010002entityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.service.f010002Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class f010002ServiceImpl implements f010002Service {

	@Autowired
	private final f010001Dao f010001dao;

	public F010002entityOut service01(F010002entityIn entityIn, HttpServletRequest request) throws ErrListException {

		F010002entityOut entityout = new F010002entityOut();

		entityout.setUser_Account(entityIn.getUser_Account());

		entityout.setUser_Password(entityIn.getUser_Password());

		return entityout;
	}

	@Override
	public F010002entityOut service02(F010002entityIn entityin) throws ErrListException {
		// TODO Auto-generated method stub
		return null;
	}
}
