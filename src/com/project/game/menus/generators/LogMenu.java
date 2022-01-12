package com.project.game.menus.generators;

import com.project.game.actions.menu.logactions.SignIn;
import com.project.game.actions.menu.logactions.SignUp;
import com.project.game.actions.menu.logactions.ViewPlayersTemp;
import com.project.game.menus.BackMenu;
import com.project.game.menus.Menu;
import com.project.game.menus.MenuGenerator;
import com.project.game.menus.MenuItem;

public class LogMenu extends MenuGenerator {

	@Override
	public Menu generateMenu() {
		Menu menu = new Menu("", "");

		MenuItem selectPlayer = new SignIn("1", "Sign in");
		MenuItem addPlayer = new SignUp("2", "Sign up");
		BackMenu back = new BackMenu("0", "Exit");
		MenuItem viewPlayers = new ViewPlayersTemp("+", "View Players");

		menu.addMenuItem(selectPlayer);
		menu.addMenuItem(addPlayer);
		menu.addMenuItem(back);
		menu.addMenuItem(viewPlayers);
		menu.setBackAction(back);

		return menu;
	}

}
