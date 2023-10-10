package com.arv.cardgame.view;

import com.arv.cardgame.controller.GameController;

public interface GameViewable {

	public void setController(GameController gc);

	public void promptForPlayerName();

	public void promptForFlip();

	public void promptForNewGame();

	public void showWinner(String playerName);

	public void showPlayerName(int numPlayer, String playerName);

	public void showFaceDownCardForPlayer(int playerIndex, String name);

	public void showCardForPlayer(int playerIndex, String name, String rank, String suit);

	public void displayMessage(String string);

}
