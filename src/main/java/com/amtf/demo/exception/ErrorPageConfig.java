package com.amtf.demo.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amtf.demo.util.CommonUtil;

@Controller
public class ErrorPageConfig implements ErrorController {
	@Autowired
	HttpServletRequest request;

	@Override
	@RequestMapping("/error")
	public String getErrorPath() {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		if (!CommonUtil.isEmpty(statusCode)) {
			switch (statusCode) {
			case 404:
				return "/error";
			case 400:
				return "/error";
			default:
				return "/error";
			}
		} else {
			return "/error";
		}
	}

}
