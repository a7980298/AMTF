package com.amtf.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amtf.demo.dao.f060001Dao;
import com.amtf.demo.entityin.F060001entityIn;
import com.amtf.demo.entityout.F060001entityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.f060001entity.f060001_select1entity;
import com.amtf.demo.service.F060001Service;
import com.amtf.demo.util.DateUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class F060001ServiceImpl implements F060001Service {

	@Autowired
	private final f060001Dao f060001dao;

	@Override
	public F060001entityOut service01(F060001entityIn entityin) throws ErrListException {
		F060001entityOut entityout = new F060001entityOut();

		List<f060001_select1entity> select1entity = f060001dao.f060001_Select1();

		DateUtil.strTostr(select1entity.get(0).getTask_date());

		// 最新任务
		entityout.setSelect1(select1entity);

		return entityout;
	}
}
