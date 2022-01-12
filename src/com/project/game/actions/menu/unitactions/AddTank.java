package com.project.game.actions.menu.unitactions;

import com.project.game.app.ApplicationSession;
import com.project.game.menus.MenuItem;
import com.project.game.model.Database;
import com.project.game.model.Player;
import com.project.game.model.units.Tank;

public class AddTank extends MenuItem {

	public AddTank(String option, String key) {
		super(option, key);
	}

	@Override
	public void doAction() {
		Player selectedPlayer = ApplicationSession.getInstance().getSelectedPlayer();
		Database db = ApplicationSession.getInstance().getDatabase();

		Tank unit = new Tank();

		db.addUnit(selectedPlayer, unit);
		System.out.println(unit.toString() + " added successfully");

	}

}
