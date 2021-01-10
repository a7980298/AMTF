package com.amtf.demo.service;

import com.amtf.demo.entityin.F020001EntityIn;
import com.amtf.demo.entityout.F020001EntityOut;
import com.amtf.demo.exception.ErrListException;

public interface F020001Service {

	public F020001EntityOut service01(F020001EntityIn entityin) throws ErrListException;

	public F020001EntityOut service02(F020001EntityIn entityin) throws ErrListException;

	public F020001EntityOut service03(F020001EntityIn entityin) throws ErrListException;

	public F020001EntityOut service04(F020001EntityIn entityin) throws ErrListException;

	public F020001EntityOut service05(F020001EntityIn entityin) throws ErrListException;
	
	public F020001EntityOut service06(F020001EntityIn entityin) throws ErrListException;
	
	public F020001EntityOut service07(F020001EntityIn entityin) throws ErrListException;

	public F020001EntityOut service08(F020001EntityIn entityin) throws ErrListException;

}
