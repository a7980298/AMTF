package com.amtf.demo.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrListException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Object entity;

	String iViewId;

	public ErrListException(Object entityIn, String iViewId, String message) {
		super(message);
		this.entity = entityIn;
		this.iViewId = iViewId;
	}

}
