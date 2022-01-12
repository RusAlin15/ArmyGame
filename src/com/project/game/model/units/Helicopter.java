package com.project.game.model.units;

import com.project.game.model.Unit;
import com.project.game.model.UnitType;

public class Helicopter extends Unit {
	private static final long serialVersionUID = 1L;
	private int bombs;
	private int rockets;
	private boolean antiRadar;

	public Helicopter() {
		super(UnitType.AIR_FORCE);
		setAntiRadar();
		setBombs();
		setRockets();
		setFirePower();
		setHealth();
	}

	private void setBombs() {
		this.bombs = (int) (Math.random() * (60 - 30)) + 1;
	}

	private void setRockets() {
		this.rockets = (int) (Math.random() * (45 - 25)) + 1;
	}

	private void setAntiRadar() {
		this.antiRadar = Math.random() < 0.5;
	}

	@Override
	protected void setFirePower() {
		firePower = (100 + bombs + rockets);
	}

	@Override
	protected void setHealth() {
		health = 387 + 2 * (antiRadar ? 50 : 0);
	}

}
