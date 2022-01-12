package com.project.game.model.units;

import com.project.game.model.Unit;
import com.project.game.model.UnitType;

public class Soldier extends Unit {

	private static final long serialVersionUID = 1L;

	private int grenades;
	private int shield;

	public Soldier() {
		super(UnitType.INFANTRY);
		setGrenades();
		setShield();
		setFirePower();
		setHealth();
	}

	private void setGrenades() {
		this.grenades = (int) (Math.random() * (10 - 1)) + 1;
	}

	private void setShield() {
		this.shield = (int) (Math.random() * (28 - 1)) + 1;
	}

	@Override
	protected void setFirePower() {
		firePower = (1 + 1.5 * grenades);
	}

	@Override
	protected void setHealth() {
		health = 50 + shield;
	}

}
