package com.amtf.demo.service;

import com.amtf.demo.entityin.F020002EntityIn;
import com.amtf.demo.entityout.F020002EntityOut;
import com.amtf.demo.exception.ErrListException;

public interface F020002Service {

	public F020002EntityOut service01(F020002EntityIn entityin) throws ErrListException;

}
