package com.project.game.model;

import java.util.List;

public abstract interface Database {

	void addPlayer(String name);

	List<Player> getPlayers();

	Player getPlayerByName(String name);

	void removePlayer(Player player);

	void addUnit(Player selectedPlayer, Unit unit);

	void resetUnits(Player selectedPlayer);

	void addArmy(Player selPlayer, UnitType unitType);

	void fight(Player selectedPlayer, Player attackedPlayer);

	void setPlayerName(String name);

	void battleSimulation();

	void retriveArmy(Army army);

}
