package com.amtf.demo.exception;

import com.amtf.demo.entityin.F010001entityIn;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrListException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private F010001entityIn entity;

	public ErrListException(F010001entityIn entityIn, String message) {
		super(message);
		this.entity = entityIn;
	}

}
