package game.views;

import java.util.ArrayList;
import java.util.List;

import java.util.Observer;
import java.util.Observable;

import java.awt.GridLayout;

import javax.swing.JFrame;

import game.controllers.Button;
import game.controllers.eventlisteners.ButtonEventListener;
import game.models.Game;

public class GameView extends JFrame implements Observer {
	private Game model;	// The model of the application (MVC pattern).
	
	// Graphic components.
	private GridLayout layout;
	private Button buttons[][];
	private ButtonEventListener eventListener;

	public GameView(Game model) {
		// Saving the model in the instance.
		this.model = model;
		
		// As GameView is the observer of Game, we should call 'this.model.addObserver(this)'
		this.model.addObserver(this);
		
		// Setting up the GUI.
		setTitle("Get10");
		
		layout = new GridLayout(5, 5);
		setLayout(layout);
		
		eventListener = new ButtonEventListener(this);
		
		buttons = new Button[5][5];
		
		Button current_button;
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				current_button = new Button(String.valueOf(this.model.getButtonValue(i, j)), i, j);
				current_button.addActionListener(this.eventListener);
				
				buttons[i][j] = current_button;
				
				add(current_button);
			}
		}
		
		pack();
		setVisible(true);
	}
	
	public Game getModel() {
		return this.model;
	}
	
	@Override
	public void update(Observable o, Object arg) {
	}
}
