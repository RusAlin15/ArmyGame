package com.project.game.menus;

public abstract class MenuItem {
	private String key;
	private String option;

	public MenuItem(String option, String key) {
		super();
		this.key = key;
		this.option = option;
	}

	@Override
	public String toString() {
		return option + ". " + key;
	}

	public abstract void doAction();

	public void run() {
		try {
			doAction();
		} catch (RuntimeException ex) {
			System.lineSeparator();
			System.out.println(System.lineSeparator() + ex.getMessage() + System.lineSeparator());
		}
	}

	public String getOption() {
		return option;
	}

}
