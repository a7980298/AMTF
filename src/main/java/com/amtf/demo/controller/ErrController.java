package com.amtf.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.params.ExperimentParams;
import com.amtf.demo.util.ValiDationUtil;

@Controller
public class ErrController extends ValiDationUtil {

	/**
	 * 
	 * 
	 * @parameter
	 * @return String
	 * @throws ErrListException
	 */
	@RequestMapping("/err")
	public String err(ExperimentParams params, Model model) throws ErrListException {
		return "err";
	}

}
