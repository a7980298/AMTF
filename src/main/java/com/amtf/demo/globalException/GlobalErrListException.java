package com.amtf.demo.globalException;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.exception.SuccessException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
@ResponseBody
public class GlobalErrListException {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ErrListException.class)
	public ModelAndView passwordMistake(ErrListException e) throws JSONException {
		log.error("错误信息：" + e.getMessage());
		ModelAndView mav = new ModelAndView();
		String IViewId = e.getIViewId();
		mav.addObject(IViewId + "Params", e.getEntity());
		if (IViewId.equals("f010001")) {
			IViewId="login";
		} else if (IViewId.equals("f010002")) {
			IViewId="main";
		}else if (IViewId.equals("f020001")) {
			IViewId="dashboard";
		}
		mav.setViewName(IViewId);
		mav.addObject("codemsg", e.getMessage());
		return mav;
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(SuccessException.class)
	public ModelAndView getSuccessException(SuccessException e) throws JSONException {
		log.error("错误信息：" + e.getMessage());
		ModelAndView mav = new ModelAndView();
		mav.addObject("success", e.getMessage());
		return mav;
	}
}
