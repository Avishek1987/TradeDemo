package com.eaxple.tradedemo.exception;

public class CustomException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomException(String message) throws CustomException {
		super();
		throw new CustomException(message);
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
