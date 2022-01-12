package com.project.game.exceptions;

public class PlayerNotExistException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;

	public PlayerNotExistException() {
		message = "Player not exist!";
	}

	@Override
	public String getMessage() {
		return message;

	}
}
