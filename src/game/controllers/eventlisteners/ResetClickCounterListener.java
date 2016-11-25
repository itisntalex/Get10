package game.controllers.eventlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.views.GameView;

public class ResetClickCounterListener implements ActionListener {
	private GameView view;
	
	public ResetClickCounterListener(GameView view) {
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.view.getModel().resetClickCounter();
	}
}
