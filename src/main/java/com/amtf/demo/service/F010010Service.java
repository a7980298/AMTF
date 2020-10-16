package com.amtf.demo.service;

import com.amtf.demo.entityin.F010010EntityIn;
import com.amtf.demo.entityout.F010010EntityOut;
import com.amtf.demo.exception.ErrListException;

public interface F010010Service {

	public F010010EntityOut service01(F010010EntityIn entityin) throws ErrListException;

}
