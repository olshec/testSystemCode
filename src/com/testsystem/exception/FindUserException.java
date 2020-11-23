package com.testsystem.exception;

public class FindUserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FindUserException(String message) {
        super(message);
    }
	
	public FindUserException(String message, Throwable cause) {
	        super(message, cause);
	}
	
}
