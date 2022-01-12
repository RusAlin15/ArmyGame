package com.project.game.actions.menu.logactions;

import com.project.game.app.ApplicationSession;
import com.project.game.menus.MenuItem;
import com.project.game.model.Database;

public class ViewPlayersTemp extends MenuItem {

	public ViewPlayersTemp(String key, String option) {
		super(key, option);
	}

	@Override
	public void doAction() {

		Database db = ApplicationSession.getInstance().getDatabase();
		System.out.println(db);
	}

}
