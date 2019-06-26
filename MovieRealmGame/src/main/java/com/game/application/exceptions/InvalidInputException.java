package com.game.application.exceptions;

public class InvalidInputException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4212005487179375673L;
	private String msg;

	public InvalidInputException(String msg) {
		super(msg);
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "InvalidInputException [msg=" + msg + "]";
	}
	
	
	
	
	

}
