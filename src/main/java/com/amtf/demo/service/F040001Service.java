package com.amtf.demo.service;

import com.amtf.demo.entityin.F040001entityIn;
import com.amtf.demo.entityout.F040001entityOut;
import com.amtf.demo.exception.ErrListException;

public interface F040001Service {

	public F040001entityOut service01(F040001entityIn entityin) throws ErrListException;
	public F040001entityOut service02(F040001entityIn entityin) throws ErrListException;
}
