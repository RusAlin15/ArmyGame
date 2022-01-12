package com.project.game.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.project.game.actions.BattleSimulator;
import com.project.game.app.ApplicationSession;
import com.project.game.exceptions.NullInputException;
import com.project.game.exceptions.PlayerExistException;
import com.project.game.exceptions.PlayerNotExistException;

public class FileDatabase implements Database, Serializable {
	private static final long serialVersionUID = 1L;
	private List<Player> players = new ArrayList<>();

	@Override
	public void addPlayer(String name) {
		if (name.equals("")) {
			throw new NullInputException();
		}
		if (existPlayerByName(name)) {
			throw new PlayerExistException();
		}
		players.add(new Player(name));
		ApplicationSession.getInstance().getSerializer().save(this);
	}

	@Override
	public List<Player> getPlayers() {
		return players;
	}

	@Override
	public void removePlayer(Player player) {
		players.remove(player);
		ApplicationSession.getInstance().getSerializer().save(this);
	}

	private boolean existPlayerByName(String name) {
		try {
			getPlayerByName(name);
			return true;
		} catch (RuntimeException e) {
			return false;
		}
	}

	@Override
	public Player getPlayerByName(String name) {

		Iterator<Player> iterator = players.iterator();
		while (iterator.hasNext()) {
			Player p = iterator.next();
			if (p.getName().toLowerCase().contentEquals(name.toLowerCase())) {
				return p;
			}
		}
		throw new PlayerNotExistException();
	}

	@Override
	public void addUnit(Player selectedPlayer, Unit unit) {
		Army army = selectedPlayer.getArmyByType(unit.getType());

		if (army == null) {
			this.addArmy(selectedPlayer, unit.getType());
			army = selectedPlayer.getArmyByType(unit.getType());
		}

		army.addUint(unit);

		ApplicationSession.getInstance().getSerializer().save(this);
	}

	@Override
	public void addArmy(Player selPlayer, UnitType unitType) {
		selPlayer.addArmy(unitType);
		ApplicationSession.getInstance().getSerializer().save(this);
	}

	@Override
	public void resetUnits(Player selectedPlayer) {
		selectedPlayer.resetunits();
		ApplicationSession.getInstance().getSerializer().save(this);
	}

	@Override
	public String toString() {
		String str = System.lineSeparator();
		for (Player player : players) {
			str += player.toString();
		}
		return str;
	}

	@Override
	public void fight(Player selectedPlayer, Player attackedPlayer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPlayerName(String name) {
		if (name.equals("")) {
			throw new NullInputException();
		}
		if (existPlayerByName(name)) {
			throw new PlayerExistException();
		}
		Player player = ApplicationSession.getInstance().getSelectedPlayer();
		player.setName(name);
		ApplicationSession.getInstance().getSerializer().save(this);
	}

	@Override
	public void battleSimulation() {

		for (UnitType type : UnitType.values()) {
			Army attacker = ApplicationSession.getInstance().getSelectedPlayer().getArmyByType(type);
			Army enemy = ApplicationSession.getInstance().getAttackedPlayer().getArmyByType(type);

			if (battleCondition(attacker, enemy)) {
				BattleSimulator bs = new BattleSimulator(attacker, enemy);
				bs.battle();
			}
		}

		ApplicationSession.getInstance().getSerializer().save(this);
	}

	private boolean battleCondition(Army attacker, Army enemy) {
		return (attacker != null && enemy != null && !attacker.isEmpty() && !enemy.isEmpty());
	}

	@Override
	public void retriveArmy(Army army) {
		for (Unit unit : army.getUnits()) {
			if (!unit.isAlive()) {
				unit.retrive();
			}
		}
		army.getGeneral().resetBonus();
		army.recalculateAttributes();
		ApplicationSession.getInstance().getSerializer().save(this);
	}

}
