package com.amtf.demo.serviceImpl;

import org.springframework.stereotype.Service;

import com.amtf.demo.entityin.F060001entityIn;
import com.amtf.demo.entityout.F060001entityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.service.F060001Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class F060001ServiceImpl implements F060001Service {
	@Override
	public F060001entityOut service01(F060001entityIn entityin) throws ErrListException {
		// TODO Auto-generated method stub
		return null;
	}
}
