package com.amtf.demo.service;

import com.amtf.demo.entityin.F010009EntityIn;
import com.amtf.demo.entityout.F010009EntityOut;
import com.amtf.demo.exception.ErrListException;

public interface F010009Service {

	public F010009EntityOut service01(F010009EntityIn entityin) throws ErrListException;

}
