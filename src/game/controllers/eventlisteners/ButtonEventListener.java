package game.controllers.eventlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.controllers.Button;
import game.views.GameView;

public class ButtonEventListener implements ActionListener {
	private GameView view;
	
	public ButtonEventListener(GameView view) {
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Getting the numerical value associated to the source of the event.
		Button source = (Button) e.getSource();
		int value = this.view.getModel().getButtonValue(source.getRow(), source.getColumn());
		
		System.out.println(String.format("Le boutton sur lequel vous avez appuyé avait pour valeur: %d", value));
	}

}
