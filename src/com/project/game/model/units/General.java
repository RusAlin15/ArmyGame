package com.project.game.model.units;

import java.io.Serializable;

public class General implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private double bonus;

	public General(String name) {
		super();
		this.name = name;
		this.bonus = 0;
	}

	public String getName() {
		return name;
	}

	public double getBonus() {
		return bonus;
	}

	public void increseBonus() {
		if (bonus < 25) {
			bonus++;
		}
	}

	public void decreaseBonus() {
		if (bonus > 0) {
			bonus--;
		}
	}

	@Override
	public String toString() {
		return "General " + name + " (" + bonus + "%)";
	}

	public double applyBonus(double fire) {
		return (fire * bonus) / 100;
	}

	public void resetBonus() {
		bonus = 0;
	}
}
