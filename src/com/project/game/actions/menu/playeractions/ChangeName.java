package com.project.game.actions.menu.playeractions;

import com.project.game.app.ApplicationSession;
import com.project.game.app.Keyboard;
import com.project.game.exceptions.NullInputException;
import com.project.game.exceptions.PlayerExistException;
import com.project.game.menus.MenuItem;
import com.project.game.model.Database;

public class ChangeName extends MenuItem {

	public ChangeName(String option, String key) {
		super(option, key);
	}

	@Override
	public void doAction() {
		Keyboard keyboard = ApplicationSession.getInstance().getKeboard();
		Database db = ApplicationSession.getInstance().getDatabase();
		String name = keyboard.getMessage("Insert new Name: ");

		try {
			db.setPlayerName(name);
		} catch (PlayerExistException e) {
			throw e;
		} catch (NullInputException e) {
			throw e;
		}
		System.out.println("Name changed to " + name);

	}

}
