package game.models;

import java.util.Observable;
import java.util.concurrent.ThreadLocalRandom;

public class Game extends Observable {
	private int tab[][];		// Numerical value of each button of the grid.
	private int clickCounter;	// Click counter.

	public Game() {
		tab = new int[5][5];
		clickCounter = 0;
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				tab[i][j] = ThreadLocalRandom.current().nextInt(1, 5);
			}
		}
	}
	
	public int getButtonValue(int row, int column) {
		return tab[row][column];
	}
	
	public void setButtonValue(int row, int column, int value) {
		tab[row][column] = value;
		
		setChanged();
		notifyObservers();
	}
	
	public void incrementClickCounter() {
		clickCounter++;
		
		// Notifications de tous les observeurs.
		setChanged();
		notifyObservers();
	}
	
	public void resetClickCounter() {
		clickCounter = 0;
		
		setChanged();
		notifyObservers();
	}
	
	public int getClickCounter() {
		return this.clickCounter;
	}
}
