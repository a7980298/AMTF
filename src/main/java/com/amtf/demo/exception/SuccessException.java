package com.amtf.demo.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SuccessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Object entity;

	public SuccessException(Object entityIn, String message) {
		super(message);
		this.entity = entityIn;
	}

}
