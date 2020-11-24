package com.amtf.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amtf.demo.dao.F060001Dao;
import com.amtf.demo.entityin.F060001EntityIn;
import com.amtf.demo.entityout.F060001EntityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.f060001entity.F060001_Select1Entity;
import com.amtf.demo.service.F060001Service;
import com.amtf.demo.util.DateUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class F060001ServiceImpl implements F060001Service {

	@Autowired
	private final F060001Dao f060001dao;

	@Override
	public F060001EntityOut service01(F060001EntityIn entityin) throws ErrListException {
		F060001EntityOut entityout = new F060001EntityOut();



		return entityout;
	}
}
