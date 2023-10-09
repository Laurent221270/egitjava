package com.arv.arrayeater.view;

import java.util.ArrayList;
import java.util.List;

import com.arv.arrayeater.controller.GameController;

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
	public void promptForArrayDim() {
		for (GameViewable view : views) {
			view.promptForArrayDim();
		}
	}

	@Override
	public void promptForNumberOfMoves() {
		for (GameViewable view : views) {
			view.promptForNumberOfMoves();
		}
	}

	@Override
	public void promptForNewGame() {
		for (GameViewable view : views) {
			view.promptForNewGame();
		}
	}


	@Override
	public void displayMessage(String string) {
		for (GameViewable view : views) {
			view.displayMessage(string);
		}
	}

	@Override
	public void displayStatistics(String[] statistics) {
		for (GameViewable view : views) {
			view.displayStatistics(statistics);
		}		
	}

	@Override
	public void updateArray(int[][] tab) {
		for (GameViewable view : views) {
			view.updateArray(tab);
		}
	}

	@Override
	public boolean isCellUpdatable() {
		boolean updtbl= true;
		//on ne peut pas gérer les diférentes view de façon différente
		// si une seule view non CellUpdatable=> on déclare qu'aucune ne l'est !  
		for (GameViewable view : views) {
			if(!view.isCellUpdatable()) {
				updtbl= false;
			}
		}		
		return updtbl;
	}

	@Override
	public void updateCell(int[] tab) {
		for (GameViewable view : views) {
			view.updateCell(tab);
		}	
	}

	@Override
	public void reset(int[][] tab) {
		for (GameViewable view : views) {
			view.reset(tab);
		}	
	}

}
