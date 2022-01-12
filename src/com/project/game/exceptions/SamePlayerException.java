package com.project.game.exceptions;

public class SamePlayerException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	// private String message;

	public SamePlayerException() {
		super("You can not attack yourself!");
		// message = "You can not attack yourself!";
	}

//	@Override
//	public String getMessage() {
//		return message;
//
//	}
}
