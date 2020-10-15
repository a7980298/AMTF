package com.amtf.demo.service;

import com.amtf.demo.entityin.F010008EntityIn;
import com.amtf.demo.entityout.F010008EntityOut;
import com.amtf.demo.exception.ErrListException;

public interface F010008Service {

	public F010008EntityOut service01(F010008EntityIn entityin) throws ErrListException;

}
