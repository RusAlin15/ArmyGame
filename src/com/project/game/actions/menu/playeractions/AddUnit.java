package com.project.game.actions.menu.playeractions;

import com.project.game.menus.Menu;
import com.project.game.menus.MenuItem;
import com.project.game.menus.generators.UnitsMenu;

public class AddUnit extends MenuItem {
	private Menu menu;

	public AddUnit(String option, String key) {
		super(option, key);
		UnitsMenu addArmyMenu = new UnitsMenu();
		menu = addArmyMenu.generateMenu();
	}

	@Override
	public void doAction() {
		menu.run();
	}

}
