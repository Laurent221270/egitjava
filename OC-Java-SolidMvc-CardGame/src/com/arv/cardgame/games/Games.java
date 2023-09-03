package com.arv.cardgame.games;

import com.arv.cardgame.controller.GameController;
import com.arv.cardgame.model.DeckFactory;
import com.arv.cardgame.model.DeckFactory.DeckType;
import com.arv.cardgame.view.CommandLineView;
import com.arv.cardgame.view.GameSwingPassiveView;
import com.arv.cardgame.view.GameSwingView;
import com.arv.cardgame.view.GameViewables;

public class Games {

	public static void main(String[] args) {
		
		GameViewables views = new GameViewables();
		
		// Game Main Swing view
		GameSwingView gsv= new GameSwingView();
		gsv.createAndShowGUI();
		
		views.addViewable(gsv);
		
		// add passive Swing views (Consoles)
		for (int i = 0; i < 3; i++) {
			GameSwingPassiveView passiveView= new GameSwingPassiveView();
			passiveView.createAndShowGUI();
			
			views.addViewable(passiveView);
			
			// sleep to let user move new Swing frame on window
			try {
				Thread.sleep(2500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		GameController gc= null;
		
		//GameController gc= new GameController(new Deck(), new CommandLineView(), new HighCardGameEvaluator());
		
		/*
		gc= new GameController(DeckFactory.makeDeck(DeckType.Normal), gsv, new HighCardGameEvaluator());
		gc.run();
		*/
		/*
		gc= new GameController(DeckFactory.makeDeck(DeckType.Small), gsv, new LowCardGameEvaluator());
		gc.run();
		 */
				
		gc= new GameController(DeckFactory.makeDeck(DeckType.Test), views, new HighCardGameEvaluator());
		gc.run();
			
		//Jeu en Mode Console
		/*
		gc= new GameController(DeckFactory.makeDeck(DeckType.Test), new CommandLineView(), new HighCardGameEvaluator());
		gc.run();
		*/
	}

}
