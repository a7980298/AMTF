package com.amtf.demo.service;

import com.amtf.demo.entityin.F010003EntityIn;
import com.amtf.demo.entityout.F010003EntityOut;
import com.amtf.demo.exception.ErrListException;

public interface F010003Service {

	public F010003EntityOut service01(F010003EntityIn entityin) throws ErrListException;

	public F010003EntityOut service02(F010003EntityIn entityin) throws ErrListException;

}
