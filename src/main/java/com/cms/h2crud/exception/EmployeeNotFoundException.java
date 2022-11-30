package com.cms.h2crud.exception;

public class EmployeeNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9207290582725114277L;

	public EmployeeNotFoundException(String message) {
		super(message);
	}
}
