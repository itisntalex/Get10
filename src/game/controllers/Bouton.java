package game.controllers;

import javax.swing.JButton;

public class Bouton extends JButton {
	private int row;
	private int column;
	
	public Bouton(String text, int row, int column) {
		super(text);
		
		this.row = row;
		this.column = column;
	}
	
	public int getColumn() {
		return this.column;
	}
	
	public int getRow() {
		return this.row;
	}
}
