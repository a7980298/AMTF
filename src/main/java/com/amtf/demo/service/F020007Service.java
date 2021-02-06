package com.amtf.demo.service;

import com.amtf.demo.entityin.F020007EntityIn;
import com.amtf.demo.entityout.F020007EntityOut;
import com.amtf.demo.exception.ErrListException;

public interface F020007Service {

	public F020007EntityOut service01(F020007EntityIn entityin) throws ErrListException;

	public F020007EntityOut service02(F020007EntityIn entityin) throws ErrListException;
}
