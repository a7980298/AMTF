package com.amtf.demo.serviceImpl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amtf.demo.dao.f030001Dao;
import com.amtf.demo.entityin.F030001entityIn;
import com.amtf.demo.entityin.F040001entityIn;
import com.amtf.demo.entityout.F030001entityOut;
import com.amtf.demo.entityout.F040001entityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.service.F040001Service;
import com.amtf.demo.service.f030001Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class F040001ServiceImpl implements F040001Service{
	@Autowired
	HttpServletRequest request;

	@Override
	public F040001entityOut service01(F040001entityIn entityin) throws ErrListException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public F040001entityOut service02(F040001entityIn entityin) throws ErrListException {
		// TODO Auto-generated method stub
		return null;
	}


}
