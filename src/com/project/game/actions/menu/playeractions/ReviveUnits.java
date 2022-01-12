package com.project.game.actions.menu.playeractions;

import com.project.game.app.ApplicationSession;
import com.project.game.menus.MenuItem;
import com.project.game.model.Army;
import com.project.game.model.Database;
import com.project.game.model.Player;
import com.project.game.model.UnitType;

public class ReviveUnits extends MenuItem {

	public ReviveUnits(String option, String key) {
		super(option, key);
	}

	@Override
	public void doAction() {
		Database db = ApplicationSession.getInstance().getDatabase();
		Player selectedPlayer = ApplicationSession.getInstance().getSelectedPlayer();

		for (UnitType type : UnitType.values()) {
			Army army = selectedPlayer.getArmyByType(type);
			if (army != null) {

				db.retriveArmy(army);
			}

		}
		System.out.println("Units retrived.");
	}

}
