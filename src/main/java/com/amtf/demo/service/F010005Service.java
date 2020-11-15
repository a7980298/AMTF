package com.amtf.demo.service;

import com.amtf.demo.entityin.F010005EntityIn;
import com.amtf.demo.entityout.F010005EntityOut;
import com.amtf.demo.exception.ErrListException;

public interface F010005Service {

	public F010005EntityOut service01(F010005EntityIn entityin) throws ErrListException;

	public F010005EntityOut service02(F010005EntityIn entityin) throws ErrListException;

	public F010005EntityOut service03(F010005EntityIn entityin) throws ErrListException;

	public F010005EntityOut service04(F010005EntityIn entityin) throws ErrListException;

	public F010005EntityOut service05(F010005EntityIn entityin) throws ErrListException;

	public F010005EntityOut service06(F010005EntityIn entityin) throws ErrListException;

	public F010005EntityOut service07(F010005EntityIn entityin) throws ErrListException;

}
