package com.amtf.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amtf.demo.dao.f010002Dao;
import com.amtf.demo.entityin.F010002entityIn;
import com.amtf.demo.entityout.F010002entityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.service.f010002Service;
import com.amtf.demo.util.FenYe;
import com.amtf.demo.util.StringUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class f010002ServiceImpl implements f010002Service {

	@Autowired
	private final f010002Dao f010002dao;

	public F010002entityOut service01(F010002entityIn entityIn) throws ErrListException {

		F010002entityOut entityout = new F010002entityOut();

		entityout.setUser_Account(entityIn.getUser_Account());

		entityout.setUser_Password(entityIn.getUser_Password());

		return entityout;
	}

	@Override
	public F010002entityOut service02(F010002entityIn entityin) throws ErrListException {
		F010002entityOut entityout = new F010002entityOut();
		// TODO Auto-generated method stub
		FenYe fenYe = new FenYe();
		fenYe.setFrequency(3);
		fenYe.setCount(f010002dao.f010002_Select1Count());
		fenYe.setFenyeList(f010002dao.f010002_Select1(StringUtil.toStr(fenYe.getCurrent() * fenYe.getFrequency()),
				StringUtil.toStr((fenYe.getCurrent() + 1) * fenYe.getFrequency())));
		fenYe.setPages(fenYe.getCount() / fenYe.getFrequency());
		entityout.setFenye(fenYe);
		return entityout;
	}
}
