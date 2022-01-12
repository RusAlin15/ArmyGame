package com.project.game.app;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.project.game.exceptions.NullInputException;
import com.project.game.exceptions.SamePlayerException;
import com.project.game.model.Database;
import com.project.game.model.FileDatabase;
import com.project.game.model.Player;

public class ApplicationSession {
	private Keyboard keyboard = new Keyboard();
	private Database database = new FileDatabase();
	private Serializer serializer = new Serializer();
	private Player selectedPlayer;
	private Player attackedPlayer;

	private static ApplicationSession instance = new ApplicationSession();

	public static ApplicationSession getInstance() {
		return instance;
	}

	public Keyboard getKeboard() {
		return keyboard;
	}

	public Database getDatabase() {
		return database;
	}

	public Serializer getSerializer() {
		return serializer;
	}

	public Player getSelectedPlayer() {
		return selectedPlayer;
	}

	public Player getAttackedPlayer() {
		return attackedPlayer;
	}

	public void setSelectedPlayer(String name) {
		if (name.equals("")) {
			throw new NullInputException();
		}
		try {
			selectedPlayer = ApplicationSession.getInstance().getDatabase().getPlayerByName(name);
		} catch (RuntimeException e) {
			throw e;
		}
	}

	public void setAttackedPlayer(String name) {
		if (name.equals("")) {
			throw new NullInputException();
		}
		if (name.toLowerCase().equals(selectedPlayer.getName().toLowerCase())) {
			throw new SamePlayerException();
		}
		attackedPlayer = ApplicationSession.getInstance().getDatabase().getPlayerByName(name);
	}

	public void init() {
		try {
			Database database = serializer.load();
			this.database = database;
		} catch (FileNotFoundException e) {
			System.out.println("You are the first player ... Please sign up");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
