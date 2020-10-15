package com.amtf.demo.service;

import com.amtf.demo.entityin.F010007EntityIn;
import com.amtf.demo.entityout.F010007EntityOut;
import com.amtf.demo.exception.ErrListException;

public interface F010007Service {

	public F010007EntityOut service01(F010007EntityIn entityin) throws ErrListException;

}
