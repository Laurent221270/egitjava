package com.arv.arrayeater.view;

import com.arv.arrayeater.controller.GameController;

public interface GameViewable {

	public void setController(GameController gc);

	public void promptForArrayDim();

	public void promptForNumberOfMoves();

	public void promptForNewGame();

	public void displayMessage(String string);

	public void displayStatistics(String[] statistics);

	public void updateArray(int[][] tab);

	public boolean isCellUpdatable();

	public void updateCell(int[] tabCell);
	
	public void reset(int[][] tab);
	
}
