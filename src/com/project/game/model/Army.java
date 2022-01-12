package com.project.game.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.project.game.app.ApplicationSession;
import com.project.game.app.Keyboard;
import com.project.game.model.units.General;

public class Army implements Serializable {

	private static final long serialVersionUID = 1L;
	private int numberOfUnits;
	private List<Unit> units = new ArrayList<>();
	private General general;

	private int firePower;
	private int health;

	public Army() {
		super();
		setGeneral();
	}

	private void setGeneral() {
		Keyboard keyboard = ApplicationSession.getInstance().getKeboard();
		String name = keyboard.getMessage("New detachment is created. Give a name for detachment general: ");
		this.general = new General(name);
		System.out.println(general.toString());
	}

	public void addUint(Unit unit) {
		units.add(unit);
		firePower += unit.getFirePower();
		health += unit.getHealth();
		numberOfUnits++;
	}

	public double getFirePower() {
		return firePower;
	}

	public double getHealth() {
		return health;
	}

	public General getGeneral() {
		return general;
	}

	public List<Unit> getUnits() {
		return units;
	}

	public void recalculateAttributes() {
		firePower = 0;
		health = 0;

		for (Unit unit : units) {
			if (unit.isAlive()) {
				health += unit.getHealth();
				firePower += unit.getFirePower();
			}
		}
	}

	@Override
	public String toString() {
		return units.get(0).getType() + " : " + general.toString() + " : " + getAliveUnitsNumber()
				+ " alive units out of " + numberOfUnits + " { Fire Power = " + firePower + " ; Health = " + health
				+ "}";
	}

	private int getAliveUnitsNumber() {
		int aliveUnitsNumber = 0;
		for (Unit unit : units) {
			if (unit.isAlive()) {
				aliveUnitsNumber++;
			}
		}
		return aliveUnitsNumber;
	}

	public boolean isEmpty() {
		return getAliveUnitsNumber() == 0;
	}

}
