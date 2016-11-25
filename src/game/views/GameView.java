package game.views;

import java.util.ArrayList;
import java.util.List;

import java.util.Observer;
import java.util.Observable;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import game.controllers.Bouton;
import game.controllers.eventlisteners.BoutonEventListener;
import game.controllers.eventlisteners.ResetClickCounterListener;
import game.models.Game;

public class GameView extends JFrame implements Observer {
	private Game model;	// The model of the application (MVC pattern).
	
	// Graphic components.
	private GridLayout layout;
	private Bouton buttons[][];
	private JLabel clickCounter;
	private JMenuBar menuBar;
	private JMenu menuClickCounter;
	private JMenuItem clickCounterReset;
	private BoutonEventListener boutonEventListener;
	private ResetClickCounterListener resetClickCounterListener;

	public GameView(Game model) {
		// Saving the model in the instance.
		this.model = model;
		
		// As GameView is the observer of Game, we should call 'this.model.addObserver(this)'
		this.model.addObserver(this);
		
		// Setting up the GUI.
		setTitle("Get10");
		
		layout = new GridLayout(6, 5);
		setLayout(layout);
		
		boutonEventListener = new BoutonEventListener(this);
		
		buttons = new Bouton[5][5];
		
		Bouton current_button;
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				current_button = new Bouton("" + this.model.getButtonValue(i, j), i, j);
				current_button.addActionListener(this.boutonEventListener);
				
				buttons[i][j] = current_button;
				
				add(current_button);
			}
		}
		
		this.clickCounter = new JLabel(Integer.toString(this.model.getClickCounter()));
		add(this.clickCounter);
		
		this.menuBar = new JMenuBar();
		
		this.menuClickCounter = new JMenu("Compteur de clic");
		
		this.clickCounterReset = new JMenuItem("Réinitialiser");
		this.menuClickCounter.add(this.clickCounterReset);
		
		this.resetClickCounterListener = new ResetClickCounterListener(this);
		
		this.clickCounterReset.addActionListener(this.resetClickCounterListener);
		
		this.menuBar.add(this.menuClickCounter);
		
		this.setJMenuBar(this.menuBar);
		
		pack();
		setVisible(true);
	}
	
	public Game getModel() {
		return this.model;
	}
	
	public Bouton getBouton(int row, int column) {
		return this.buttons[row][column];
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Game) {
			this.clickCounter.setText(Integer.toString(this.model.getClickCounter()));
		}
	}
}
