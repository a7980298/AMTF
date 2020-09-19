package com.amtf.demo.service;

import com.amtf.demo.entityin.F010002entityIn;
import com.amtf.demo.entityout.F010002entityOut;
import com.amtf.demo.exception.ErrListException;

public interface f010002Service {

	public F010002entityOut service01(F010002entityIn entityin) throws ErrListException;

	public F010002entityOut service02(F010002entityIn entityin) throws ErrListException;

	public F010002entityOut service03(F010002entityIn entityin) throws ErrListException;
	
	public F010002entityOut service04(F010002entityIn entityin) throws ErrListException;
	
	public F010002entityOut service05(F010002entityIn entityin) throws ErrListException;

}
