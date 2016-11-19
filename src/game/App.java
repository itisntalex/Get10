package game;

import game.models.Game;
import game.views.GameView;

public class App {
	public static void main(String[] args) {
		Game model = new Game();
		GameView view = new GameView(model);
	}
}
