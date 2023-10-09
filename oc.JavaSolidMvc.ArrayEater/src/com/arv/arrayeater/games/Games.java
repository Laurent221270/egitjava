package com.arv.arrayeater.games;

import com.arv.arrayeater.controller.GameController;
import com.arv.arrayeater.view.CommandLineView;
import com.arv.arrayeater.view.GameSwingView;
import com.arv.arrayeater.view.GameViewables;

public class Games {

	public static void main(String[] args) {
		
		GameViewables views = new GameViewables();
		
		// Game Main Swing view
		GameSwingView gsv= new GameSwingView();
		gsv.createAndShowGUI();
		
		views.addViewable(gsv);
		
		/*
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
		*/
		
		GameController gc= null;
		
		
		//Jeu en mode Swing 
		
		gc= new GameController(views, new HighCardGameEvaluator());
		gc.run();
		
		/*
		//Jeu en Mode Console
		gc= new GameController( new CommandLineView(), new HighCardGameEvaluator());
		gc.run();
		*/
	}

}
