package com.amtf.demo.service;

import com.amtf.demo.entityin.F010004EntityIn;
import com.amtf.demo.entityout.F010004EntityOut;
import com.amtf.demo.exception.ErrListException;

public interface F010004Service {

	public F010004EntityOut service01(F010004EntityIn entityin) throws ErrListException;

}
