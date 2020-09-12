package com.amtf.demo.service;

import com.amtf.demo.entityin.F010001entityIn;
import com.amtf.demo.entityout.F010001entityOut;
import com.amtf.demo.exception.ErrListException;

public interface f010001Service {

	public F010001entityOut service01(F010001entityIn entityin) throws ErrListException;

	public F010001entityOut service02(F010001entityIn entityin) throws ErrListException;

	public F010001entityOut service03(F010001entityIn entityin) throws ErrListException;

}
