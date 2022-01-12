package com.project.game.app;

import com.project.game.menus.Menu;
import com.project.game.menus.generators.LogMenu;

public class Application {
	public static void main(String[] args) {
		Application app = new Application();

		ApplicationSession.getInstance().init();
		app.run();
	}

	private void run() {
		LogMenu menu = new LogMenu();
		Menu logMenu = menu.generateMenu();
		logMenu.run();
	}
}
