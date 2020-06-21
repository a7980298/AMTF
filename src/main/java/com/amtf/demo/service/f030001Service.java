package com.amtf.demo.service;

import com.amtf.demo.entityin.F030001entityIn;
import com.amtf.demo.entityout.F030001entityOut;
import com.amtf.demo.exception.ErrListException;

public interface f030001Service {

	public F030001entityOut service01(F030001entityIn entityin) throws ErrListException;

	public F030001entityOut service02(F030001entityIn entityin) throws ErrListException;

	public F030001entityOut service03(F030001entityIn entityin) throws ErrListException;

	public F030001entityOut service04(F030001entityIn entityin) throws ErrListException;

}
