package com.project.game.model;

import java.io.Serializable;

public abstract class Unit implements Serializable {
	private static final long serialVersionUID = 1L;
	private UnitType type;
	private boolean alive = true;
	protected double firePower;
	protected double health;

	public Unit(UnitType type) {
		super();
		this.type = type;
	}

	protected abstract void setFirePower();

	protected abstract void setHealth();

	public void setHealth(double health) {
		this.health = health;
	}

	public double getFirePower() {
		return firePower;
	}

	public double getHealth() {
		return health;
	}

	public UnitType getType() {
		return type;
	}

	public void kill() {
		alive = false;
	}

	public boolean isAlive() {
		return alive;
	}

	@Override
	public String toString() {
		return type.toString() + " Unit { Fire Power " + firePower + " ; Health " + health + "}";
	}

	public void retrive() {

		alive = true;
		switch (getType()) {
		case INFANTRY:
			setHealth(getHealth() + 50);
			break;
		case AIR_FORCE:
			setHealth(getHealth() + 250);
			break;
		case MARINE_FORCE:
			setHealth(getHealth() + 200);
			break;
		}
	}
}
