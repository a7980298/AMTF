package com.amtf.demo.service;

import com.amtf.demo.entityin.F020004EntityIn;
import com.amtf.demo.entityout.F020004EntityOut;
import com.amtf.demo.exception.ErrListException;

public interface F020004Service {

	public F020004EntityOut service01(F020004EntityIn entityin) throws ErrListException;

	public F020004EntityOut service02(F020004EntityIn entityin) throws ErrListException;

}
