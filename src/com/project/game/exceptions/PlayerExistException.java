package com.project.game.exceptions;

public class PlayerExistException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;

	public PlayerExistException() {
		message = "Player exist!";
	}

	@Override
	public String getMessage() {
		return message;

	}

}
