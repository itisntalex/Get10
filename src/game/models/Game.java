package game.models;

import java.util.Observable;
import java.util.concurrent.ThreadLocalRandom;

public class Game extends Observable {
	private int tab[][];
	private int clickCounter;

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

	public static void main(String[] args) {
		Game g = new Game();
	}
}
