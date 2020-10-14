package com.amtf.demo.serviceImpl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amtf.demo.entityin.F030001EntityIn;
import com.amtf.demo.entityout.F030001EntityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.service.F030001Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class F030001ServiceImpl implements F030001Service {

	@Autowired
	HttpServletRequest request;

	@Override
	public F030001EntityOut service01(F030001EntityIn entityin) throws ErrListException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public F030001EntityOut service02(F030001EntityIn entityin) throws ErrListException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public F030001EntityOut service03(F030001EntityIn entityin) throws ErrListException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public F030001EntityOut service04(F030001EntityIn entityin) throws ErrListException {
		// TODO Auto-generated method stub
		return null;
	}

}
