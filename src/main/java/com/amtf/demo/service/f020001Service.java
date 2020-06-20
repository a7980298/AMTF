package com.amtf.demo.service;

import com.amtf.demo.entityin.F020001entityIn;
import com.amtf.demo.entityout.F020001entityOut;
import com.amtf.demo.exception.ErrListException;

public interface f020001Service {

	public F020001entityOut service01(F020001entityIn entityin) throws ErrListException;

	public F020001entityOut service02(F020001entityIn entityin) throws ErrListException;

	public F020001entityOut service03(F020001entityIn entityin) throws ErrListException;

	public F020001entityOut service04(F020001entityIn entityin) throws ErrListException;

}
