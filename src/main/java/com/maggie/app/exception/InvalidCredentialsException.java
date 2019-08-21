package com.maggie.app.exception;

/**
 * 
 * @author Sushil
 *
 */
public class InvalidCredentialsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * @param message
	 */
	public InvalidCredentialsException(String message)
	{
		super(message);
	}

}
