package game.views;

import java.util.Observer;
import java.util.Observable;

import javax.swing.JFrame;

import game.models.Game;

public class GameView extends JFrame implements Observer {
	private Game model;	// The model of the application (MVC pattern).
	
	public GameView(Game model) {
		// Saving the model in the instance.
		this.model = model;
		
		// As GameView is the observer of Game, we should call 'this.model.addObserver(this)'
		this.model.addObserver(this);
	}
	
	@Override
	public void update(Observable o, Object arg) {
	}
}
