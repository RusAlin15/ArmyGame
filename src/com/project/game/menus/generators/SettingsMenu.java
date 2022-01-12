package com.project.game.menus.generators;

import com.project.game.actions.menu.playeractions.ChangeName;
import com.project.game.actions.menu.playeractions.ChangePassword;
import com.project.game.actions.menu.playeractions.DeleteAcount;
import com.project.game.menus.BackMenu;
import com.project.game.menus.Menu;
import com.project.game.menus.MenuGenerator;
import com.project.game.menus.MenuItem;

public class SettingsMenu extends MenuGenerator {

	@Override
	public Menu generateMenu() {
		Menu menu = new Menu("", "");

		MenuItem changeName = new ChangeName("1", "Change Name");
		MenuItem changePassword = new ChangePassword("2", "Change Password");
		MenuItem deleteAccount = new DeleteAcount("3", "Delete Account");
		BackMenu back = new BackMenu("0", "Back");

		menu.addMenuItem(changeName);
		menu.addMenuItem(changePassword);
		menu.addMenuItem(deleteAccount);
		menu.addMenuItem(back);
		menu.setBackAction(back);
		return menu;
	}

}
