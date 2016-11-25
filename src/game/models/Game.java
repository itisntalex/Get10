package game.models;

import java.util.Observable;
import java.util.concurrent.ThreadLocalRandom;

public class Game extends Observable {
	private int boutonValue[][];		// Numerical value of each button of the grid.
	private boolean boutonState[][];	// Is the button clicked or not.
	private int clickCounter;			// Click counter.

	public Game() {
		boutonValue = new int[5][5];
		boutonState = new boolean[5][5];
		clickCounter = 0;
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				boutonValue[i][j] = ThreadLocalRandom.current().nextInt(1, 5);
			}
		}
	}
	
	public int getButtonValue(int row, int column) {
		return boutonValue[row][column];
	}
	
	public void setButtonValue(int row, int column, int value) {
		boutonValue[row][column] = value;
		
		setChanged();
		notifyObservers();
	}
	
	public boolean getButtonState(int row, int column) {
		return boutonState[row][column];
	}
	
	public void setButtonState(int row, int column, boolean value) {
		boutonState[row][column] = value;
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
