package com.amtf.demo.service;

import com.amtf.demo.entityin.F010010EntityIn;
import com.amtf.demo.entityin.F010011EntityIn;
import com.amtf.demo.entityout.F010010EntityOut;
import com.amtf.demo.entityout.F010011EntityOut;
import com.amtf.demo.exception.ErrListException;

public interface F010011Service {

	public F010011EntityOut service01(F010011EntityIn entityin) throws ErrListException;

}
