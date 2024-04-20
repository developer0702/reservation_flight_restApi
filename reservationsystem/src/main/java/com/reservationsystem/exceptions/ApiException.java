package com.reservationsystem.exceptions;

public class ApiException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2199470458389152804L;

	public ApiException(String message) {
		super(message);

	}

	public ApiException() {
		super();

	}

}
