package com.project.game.actions.menu.playeractions;

import com.project.game.app.ApplicationSession;
import com.project.game.app.Keyboard;
import com.project.game.menus.MenuItem;
import com.project.game.model.Database;

public class AttackPlayer extends MenuItem {
	private Database db;

	public AttackPlayer(String option, String key) {
		super(option, key);
		db = ApplicationSession.getInstance().getDatabase();
	}

	@Override
	public void doAction() {

		System.out.println(db);
		try {
			setAttackedPlayer();
		} catch (RuntimeException ex) {
			throw ex;
		}

		db.battleSimulation();

	}

	private void setAttackedPlayer() {
		Keyboard keyboard = ApplicationSession.getInstance().getKeboard();
		String name = keyboard.getMessage("Insert player name you want to attak.");

		try {
			ApplicationSession.getInstance().setAttackedPlayer(name);
		} catch (RuntimeException e) {
			throw e;
		}
	}

}
