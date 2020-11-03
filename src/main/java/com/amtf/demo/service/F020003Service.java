package com.amtf.demo.service;

import com.amtf.demo.entityin.F020001EntityIn;
import com.amtf.demo.entityin.F020003EntityIn;
import com.amtf.demo.entityout.F020001EntityOut;
import com.amtf.demo.entityout.F020003EntityOut;
import com.amtf.demo.exception.ErrListException;

public interface F020003Service {

	public F020003EntityOut service01(F020003EntityIn entityin) throws ErrListException;

	public F020003EntityOut service02(F020003EntityIn entityin) throws ErrListException;

	public F020003EntityOut service03(F020003EntityIn entityin) throws ErrListException;

}
