package com.project.game.actions.menu.playeractions;

import com.project.game.app.ApplicationSession;
import com.project.game.menus.MenuItem;
import com.project.game.model.Database;
import com.project.game.model.Player;

public class DeleteUnits extends MenuItem {

	public DeleteUnits(String option, String key) {
		super(option, key);
	}

	@Override
	public void doAction() {
		Player selectedPlayer = ApplicationSession.getInstance().getSelectedPlayer();
		Database db = ApplicationSession.getInstance().getDatabase();
		
		db.resetUnits(selectedPlayer);
		System.out.println(selectedPlayer.getName() + " army deleted.");
	}

}
