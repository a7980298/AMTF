package com.amtf.demo.service;

import com.amtf.demo.entityin.F050001EntityIn;
import com.amtf.demo.entityout.F050001EntityOut;
import com.amtf.demo.exception.ErrListException;

public interface F050001Service {

	public F050001EntityOut service01(F050001EntityIn entityin) throws ErrListException;
}
