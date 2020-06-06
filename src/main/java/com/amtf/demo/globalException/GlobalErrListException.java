package com.amtf.demo.globalException;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.amtf.demo.exception.ErrListException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
@ResponseBody
public class GlobalErrListException {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ErrListException.class)
	public ModelAndView passwordMistake(ErrListException e) throws JSONException {
		log.error("错误信息：" + e.getMessage());
		/*
		 * JSONObject result = new JSONObject(); result.put("codemsg", e.getMessage());
		 */
		ModelAndView mav = new ModelAndView();
		mav.setViewName(e.getEntity().getIViewId());
		mav.addObject(e.getEntity().getIViewId() + "Params", e.getEntity());
		mav.addObject("codemsg", e.getMessage());
		return mav;
	}
}
