package game.controllers.eventlisteners;

import java.awt.Color;
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
		
		// All buttons now have there text written in black.
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				this.view.getBouton(i, j).setForeground(Color.BLACK);
			}
		}
		
		// Getting the source button position.
		int row = source.getRow();
		int column = source.getColumn();
		boolean state = this.view.getModel().getButtonState(row, column);
		
		source.setForeground(Color.RED);
		
		if (this.view.getModel().getButtonValue(mod(row - 1, 5), column) == value) {
			this.view.getBouton(mod(row - 1, 5), column).setForeground(Color.RED);
		}
		
		if (this.view.getModel().getButtonValue(mod(row + 1, 5), column) == value) {
			this.view.getBouton(mod(row + 1, 5), column).setForeground(Color.RED);
		}
		
		if (this.view.getModel().getButtonValue(row, mod(column - 1, 5)) == value) {
			this.view.getBouton(row, mod(column - 1, 5)).setForeground(Color.RED);
		}
		
		if (this.view.getModel().getButtonValue(row, mod(column + 1, 5)) == value) {
			this.view.getBouton(row, mod(column + 1, 5)).setForeground(Color.RED);
		}
		
		if (state) {
			this.view.getModel().setButtonValue(row, column, value + 1);
			
			this.view.getModel().setButtonValue(row, mod(column - 1, 5), 0);
			this.view.getModel().setButtonValue(row, mod(column + 1, 5), 0);
			this.view.getModel().setButtonValue(mod(row - 1, 5), column, 0);
			this.view.getModel().setButtonValue(mod(row + 1, 5), column, 0);
		}
		
		this.view.getModel().setButtonState(row, column, !state);
		
		System.out.println(String.format("Le boutton sur lequel vous avez appuyé avait pour valeur: %d", value));
	}
	
	private int mod(int a, int b) {
		return (((a % b) + b) % b);
	}
}
