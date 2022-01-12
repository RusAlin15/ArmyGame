package com.project.game.menus.generators;

import com.project.game.actions.menu.playeractions.AddUnit;
import com.project.game.actions.menu.playeractions.AttackPlayer;
import com.project.game.actions.menu.playeractions.DeleteUnits;
import com.project.game.actions.menu.playeractions.ReviveUnits;
import com.project.game.actions.menu.playeractions.Settings;
import com.project.game.actions.menu.playeractions.ViewArmy;
import com.project.game.menus.BackMenu;
import com.project.game.menus.Menu;
import com.project.game.menus.MenuGenerator;
import com.project.game.menus.MenuItem;

public class PlayerMenu extends MenuGenerator {

	@Override
	public Menu generateMenu() {
		Menu menu = new Menu("", "");

		MenuItem attackPlayer = new AttackPlayer("1", "Attack Player");
		MenuItem viewArmy = new ViewArmy("2", "View Army");
		MenuItem addUnit = new AddUnit("3", "Add Unit");
		MenuItem deleteUnits = new DeleteUnits("4", "Delete Units");
		MenuItem reviveUnits = new ReviveUnits("5", "Revive Units");
		MenuItem settings = new Settings("6", "Settings");
		BackMenu back = new BackMenu("0", "Log Off");

		menu.addMenuItem(attackPlayer);
		menu.addMenuItem(viewArmy);
		menu.addMenuItem(addUnit);
		menu.addMenuItem(deleteUnits);
		menu.addMenuItem(reviveUnits);
		menu.addMenuItem(settings);
		menu.addMenuItem(back);
		menu.setBackAction(back);
		return menu;
	}

}
