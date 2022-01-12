package com.project.game.actions.menu.playeractions;

import com.project.game.app.ApplicationSession;
import com.project.game.menus.MenuItem;
import com.project.game.model.Database;

public class DeleteAcount extends MenuItem {

	public DeleteAcount(String option, String key) {
		super(option, key);
	}

	@Override
	public void doAction() {
		Database db = ApplicationSession.getInstance().getDatabase();

		db.removePlayer(ApplicationSession.getInstance().getSelectedPlayer());
	}

}
