package com.amtf.demo.serviceImpl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amtf.demo.dao.f030001Dao;
import com.amtf.demo.entityin.F030001entityIn;
import com.amtf.demo.entityout.F030001entityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.service.f030001Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class f030001ServiceImpl implements f030001Service {

	@Autowired
	private final f030001Dao f030001dao;

	@Autowired
	HttpServletRequest request;

	@Override
	public F030001entityOut service01(F030001entityIn entityin) throws ErrListException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public F030001entityOut service02(F030001entityIn entityin) throws ErrListException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public F030001entityOut service03(F030001entityIn entityin) throws ErrListException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public F030001entityOut service04(F030001entityIn entityin) throws ErrListException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
