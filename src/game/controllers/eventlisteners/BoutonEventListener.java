package game.controllers.eventlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.controllers.Bouton;
import game.views.GameView;

public class BoutonEventListener implements ActionListener {
	private GameView view;
	
	public BoutonEventListener(GameView view) {
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Getting the numerical value associated to the source of the event.
		Bouton source = (Bouton) e.getSource();
		int value = this.view.getModel().getButtonValue(source.getRow(), source.getColumn());
		
		this.view.getModel().incrementClickCounter();
		
		System.out.println(String.format("Le boutton sur lequel vous avez appuyé avait pour valeur: %d", value));
	}

}
