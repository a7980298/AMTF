package com.amtf.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.params.experimentParams;
import com.amtf.demo.util.ValiDationUtil;

@Controller
public class errController extends ValiDationUtil {

	/**
	 * 
	 * 
	 * @parameter
	 * @return String
	 * @throws ErrListException
	 */
	@RequestMapping("/err")
	public String err(experimentParams params, Model model) throws ErrListException {
		return "err";
	}

}
