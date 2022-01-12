package com.project.game.actions.menu.playeractions;

import com.project.game.menus.Menu;
import com.project.game.menus.MenuItem;
import com.project.game.menus.generators.SettingsMenu;

public class Settings extends MenuItem {
	private Menu menu;

	public Settings(String option, String key) {
		super(option, key);
		SettingsMenu settingsMenu = new SettingsMenu();
		menu = settingsMenu.generateMenu();
	}

	@Override
	public void doAction() {
		menu.run();
	}

}
