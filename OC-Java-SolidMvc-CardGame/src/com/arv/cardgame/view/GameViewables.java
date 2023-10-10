package com.arv.cardgame.view;

import java.util.ArrayList;
import java.util.List;

import com.arv.cardgame.controller.GameController;

/**
 * pattern COMPOSITE
 */
public class GameViewables implements GameViewable {

	List<GameViewable> views;

	public GameViewables() {
		views = new ArrayList<GameViewable>();
	}

	public void addViewable(GameViewable view) {
		views.add(view);
	}

	@Override
	public void setController(GameController gc) {
		for (GameViewable view : views) {
			view.setController(gc);
		}
	}

	@Override
	public void promptForPlayerName() {
		for (GameViewable view : views) {
			view.promptForPlayerName();
		}
	}

	@Override
	public void promptForFlip() {
		for (GameViewable view : views) {
			view.promptForFlip();
		}
	}

	@Override
	public void promptForNewGame() {
		for (GameViewable view : views) {
			view.promptForNewGame();
		}
	}

	@Override
	public void showWinner(String playerName) {
		for (GameViewable view : views) {
			view.showWinner(playerName);
		}
	}

	@Override
	public void showPlayerName(int numPlayer, String playerName) {
		for (GameViewable view : views) {
			view.showPlayerName(numPlayer, playerName);
		}
	}

	@Override
	public void showFaceDownCardForPlayer(int playerIndex, String name) {
		for (GameViewable view : views) {
			view.showFaceDownCardForPlayer(playerIndex, name);
		}
	}

	@Override
	public void showCardForPlayer(int playerIndex, String name, String rank, String suit) {
		for (GameViewable view : views) {
			view.showCardForPlayer(playerIndex, name, rank, suit);
		}
	}

	@Override
	public void displayMessage(String string) {
		for (GameViewable view : views) {
			view.displayMessage(string);
		}
	}

}
