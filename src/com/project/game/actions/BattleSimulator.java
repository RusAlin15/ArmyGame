package com.project.game.actions;

import com.project.game.model.Army;
import com.project.game.model.Unit;
import com.project.game.model.units.General;

public class BattleSimulator {
	Army attackerArmy;
	Army enemyArmy;
	General attackerGeneral;
	General enemyGeneral;

	public BattleSimulator(Army attackerArmy, Army enemyArmy) {
		this.attackerArmy = attackerArmy;
		this.enemyArmy = enemyArmy;
		this.attackerGeneral = attackerArmy.getGeneral();
		this.enemyGeneral = enemyArmy.getGeneral();
	}

	public void battle() {
		for (Unit attacker : attackerArmy.getUnits()) {
			fightEach(attacker);
		}

		award();
	}

	private void fightEach(Unit attacker) {
		for (Unit enemy : enemyArmy.getUnits()) {
			if (!attacker.isAlive()) { // possible errors
				break;
			}
			if (enemy.isAlive()) {
				simulateBattle(attacker, enemy);
			}
		}
	}

	private void award() {
		attackerArmy.recalculateAttributes();
		enemyArmy.recalculateAttributes();

		if (attackerArmy.getHealth() != 0) {
			attackerGeneral.increseBonus();
		} else {
			attackerGeneral.decreaseBonus();
		}
		if (enemyArmy.getHealth() != 0) {
			enemyGeneral.increseBonus();
		} else {
			enemyGeneral.decreaseBonus();
		}
	}

	private void simulateBattle(Unit attacker, Unit enemy) {
		while (true) {
			boolean flag = false;
			double attackerHP = attacker.getHealth();
			double enemyHP = enemy.getHealth();

			double attackerForce = attacker.getFirePower() + attackerGeneral.getBonus();
			double enemyForce = enemy.getFirePower() + enemyGeneral.getBonus();

			fight(attacker, attackerHP, enemyForce);
			fight(enemy, enemyHP, attackerForce);

			if (!attacker.isAlive()) {
				flag = true;
			}
			if (!enemy.isAlive()) {
				flag = true;
			}
			if (flag) {
				break;
			}
		}
	}

	private void fight(Unit unit, double hpForce, double attackForce) {
		if (hpForce < attackForce) {
			unit.kill();
		} else {
			unit.setHealth(hpForce - attackForce);
		}
	}
}
