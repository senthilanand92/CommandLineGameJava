package com.game.application.exceptions;

public class InvalidInputException extends Exception {
	
	private String msg;

	public InvalidInputException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	
	

}
