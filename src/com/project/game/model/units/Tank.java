package com.project.game.model.units;

import com.project.game.model.Unit;
import com.project.game.model.UnitType;

public class Tank extends Unit {
	private static final long serialVersionUID = 1L;
	private int missile;
	private int antiMissile;

	public Tank() {
		super(UnitType.INFANTRY);
		setMissile();
		setAntiMissile();
		setFirePower();
		setHealth();
	}

	private void setMissile() {
		this.missile = (int) (Math.random() * (50 - 20)) + 1;
	}

	private void setAntiMissile() {
		this.antiMissile = (int) (Math.random() * (250 - 20)) + 1;
	}

	@Override
	protected void setFirePower() {

		firePower = 10 + 2 * missile;
	}

	@Override
	protected void setHealth() {
		health = 100 + antiMissile;
	}

}
