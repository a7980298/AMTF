package com.amtf.demo.service;

import com.amtf.demo.entityin.F010002EntityIn;
import com.amtf.demo.entityout.F010002EntityOut;
import com.amtf.demo.exception.ErrListException;

public interface F010002Service {

	public F010002EntityOut service01(F010002EntityIn entityin) throws ErrListException;

	public F010002EntityOut service02(F010002EntityIn entityin) throws ErrListException;

	public F010002EntityOut service03(F010002EntityIn entityin) throws ErrListException;
	
	public F010002EntityOut service04(F010002EntityIn entityin) throws ErrListException;
	
	public F010002EntityOut service05(F010002EntityIn entityin) throws ErrListException;
	
	public F010002EntityOut service06(F010002EntityIn entityin) throws ErrListException;

}
