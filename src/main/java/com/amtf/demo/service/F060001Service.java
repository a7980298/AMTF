package com.amtf.demo.service;

import com.amtf.demo.entityin.F060001entityIn;
import com.amtf.demo.entityout.F060001entityOut;
import com.amtf.demo.exception.ErrListException;

public interface F060001Service {

	public F060001entityOut service01(F060001entityIn entityin) throws ErrListException;
}
