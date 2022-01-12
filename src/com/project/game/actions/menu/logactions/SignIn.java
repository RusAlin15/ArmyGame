package com.project.game.actions.menu.logactions;

import com.project.game.app.ApplicationSession;
import com.project.game.app.Keyboard;
import com.project.game.menus.Menu;
import com.project.game.menus.MenuItem;
import com.project.game.menus.generators.PlayerMenu;

public class SignIn extends MenuItem {

	private Menu menu;

	public SignIn(String option, String key) {
		super(option, key);
		PlayerMenu playerMenu = new PlayerMenu();
		menu = playerMenu.generateMenu();
	}

	@Override
	public void doAction() {
		Keyboard keyboard = ApplicationSession.getInstance().getKeboard();

		String name = keyboard.getMessage("Select Player: ");

		try {
			ApplicationSession.getInstance().setSelectedPlayer(name);
		} catch (RuntimeException e) {
			throw e;
		}

		menu.run();
	}

}
