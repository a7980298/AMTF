package com.amtf.demo.service;

import javax.servlet.http.HttpServletRequest;

import com.amtf.demo.entityin.ExperimentEntityIn;
import com.amtf.demo.entityout.ExperimentEntityOut;
import com.amtf.demo.exception.ErrListException;

public interface ExperimentService {

	public ExperimentEntityOut service01(ExperimentEntityIn entityin, HttpServletRequest request)
			throws ErrListException;

	public ExperimentEntityOut service02(ExperimentEntityIn entityin) throws ErrListException;

}
