package com.testsystem.exception;

public class FindTestException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FindTestException(String message) {
        super(message);
    }
	
	public FindTestException(String message, Throwable cause) {
	        super(message, cause);
	}
}
