package com.project.game.exceptions;

public class NullInputException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;

	public NullInputException() {
		super();
		this.message = "Please use your keyboard!";
	}

	@Override
	public String getMessage() {
		return message;
	}
}
