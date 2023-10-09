package com.arv.arrayeater.controller;

import com.arv.arrayeater.games.GameEvaluator;
import com.arv.arrayeater.model.ArrayEater;
import com.arv.arrayeater.model.ArrayEaterFactory;
import com.arv.arrayeater.view.GameViewable;

public class GameController {

	enum GameState {
		AskForArrayDim, ArrayDimOk, NumberOfMovesOk, ArrayEaten;
	}

	ArrayEater arrayEater;

	GameViewable view;

	GameState gameState;
	GameEvaluator evaluator;

	public GameController(GameViewable view, GameEvaluator evaluator) {
		super();
		this.view = view;

		this.gameState = GameState.AskForArrayDim;
		view.setController(this);
		this.evaluator = evaluator;

	}

	public void run() {

		switch (gameState) {
			case AskForArrayDim:
				view.promptForArrayDim();
				break;
			case ArrayDimOk:
				view.promptForNumberOfMoves();
				break;
			case NumberOfMovesOk:
				startToEat();
				break;
			case ArrayEaten:
				view.promptForNewGame();
				break;
			default:
				break;
		}
	}

	/**
	 * me
	 */
	public void startGame() {
		if (gameState == GameState.ArrayEaten || gameState == GameState.NumberOfMovesOk) {
			//view.displayMessage("\n Donner le nombre de Moves...");
			arrayEater.initialize();
			view.reset(arrayEater.getTableau());
			//gameState = GameState.ArrayDimOk;
		}
		this.run();
	}

	public void setArrayDim(int dim) {
		if (dim > 100) {
			dim = 100;
			System.out.println("ARRAY DIMENSION LIMITED TO " + dim);
		}
		this.arrayEater = ArrayEaterFactory.makeArray(dim);
		gameState = GameState.ArrayDimOk;
	}

	public void setNumberOfMoves(int number) {
		this.arrayEater.setNbEat(number);
		gameState = GameState.NumberOfMovesOk;
	}

	public void startToEat() {

		while (arrayEater.eatNext()) {
			if (!view.isCellUpdatable() || !arrayEater.isInprogress()) {
				// view non updatable ou 1 seule celulle a été mangée (initialisation de la vue
				// à faire)
				view.updateArray(arrayEater.getTableau());
			} else {
				view.updateCell(arrayEater.getLastUpdatedCell());
			}
		}
		// findWinner();
		// winner = GameEvaluator.evaluateWinner(players);
		// evaluateWinner();
		// displayWinner();
		// rebuildDeck();
		gameState = GameState.ArrayEaten;
		view.displayMessage("Eat process COMPLETED !\n");
		view.displayStatistics(arrayEater.getStatistics());
		this.run();
	}

	public void nextAction(String nextChoice) {
		if ("q".equals(nextChoice)) {
			//do Nothing - game control passed to GUI (txtFields + buttons)
			//exitGame();
		} else {
			startGame();
		}
	}

	public void exitGame() {
		System.out.println("***********");
		System.out.println("END of GAME");
		System.out.println("***********");
		System.exit(0);
	}

}
