package com.project.game.app;

import java.util.Scanner;

public class Keyboard {
	private Scanner keyboard = new Scanner(System.in);

	public String getMessage(String message) {
		System.out.print(message + ">>");
		String s = keyboard.nextLine();
		return s;
	}

}
