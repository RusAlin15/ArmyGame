package com.project.game.actions.menu.unitactions;

import com.project.game.app.ApplicationSession;
import com.project.game.menus.MenuItem;
import com.project.game.model.Database;
import com.project.game.model.Player;
import com.project.game.model.units.Soldier;

public class AddSoldier extends MenuItem {

	public AddSoldier(String option, String key) {
		super(option, key);
	}

	@Override
	public void doAction() {
		Player selectedPlayer = ApplicationSession.getInstance().getSelectedPlayer();
		Database db = ApplicationSession.getInstance().getDatabase();

		Soldier unit = new Soldier();

		db.addUnit(selectedPlayer, unit);
		System.out.println(unit.toString() + " added successfully");

	}

}
