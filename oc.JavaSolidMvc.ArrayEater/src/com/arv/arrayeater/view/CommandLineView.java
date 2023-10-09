package com.arv.arrayeater.view;

import java.util.Scanner;


import com.arv.arrayeater.controller.GameController;

public class CommandLineView implements GameViewable {
	

	GameController controller;
	Scanner keyboard = new Scanner(System.in);
	
	public void setController(GameController gc) {
		this.controller= gc;
	}

	@Override
	public void promptForArrayDim() {
		System.out.println("Enter Array Dimension (ex : 15) :");

		boolean sizeOk=false;
		while(!sizeOk) {
		
			String result= keyboard.nextLine();

			int size=0;
			try {
				size= Integer.parseInt(result); 
				if(size>0) {
					sizeOk= true;
					controller.setArrayDim(size);
					controller.startGame();
				}
			}
			catch (NumberFormatException nfe) {
				// TODO: handle exception
			}
		}		
	}

	@Override
	public void promptForNumberOfMoves() {
		System.out.println("Number of Moves (ex : 200) :");

		boolean nbOk=false;
		while(!nbOk) {
		
			String result= keyboard.nextLine();

			int nbMoves=0;
			try {
				nbMoves= Integer.parseInt(result);
				if(nbMoves>0) {
					nbOk= true;
					controller.setNumberOfMoves(nbMoves);
					controller.startGame();
				}
			}
			catch (NumberFormatException nfe) {
				// TODO: handle exception
			}
		}
	}

	@Override
	public void promptForNewGame() {
		System.out.println("New eat ? Enter / (q)uit");
		controller.nextAction(keyboard.nextLine());		
	}


		

	@Override
	public void displayMessage(String string) {
		System.out.println(string);
	}

	@Override
	public void displayStatistics(String[] statistics) {
		System.out.println("----------------------------------------- STATS");
		for (int i = 0; i < statistics.length; i++) {
			System.out.println(statistics[i]);
		}
		System.out.println("----------------------------------------- /STATS");
		System.out.println("");

	}

	@Override
	public void updateArray(int[][] tab) {
		String lineTab = "";
		System.out.println("----------------------------------------------------------------------------------");
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab.length; j++) {
				lineTab += (tab[i][j]==0 ? "_" : tab[i][j]) + (j == tab.length - 1 ? "" : " ");
				if (j == tab.length - 1) {
					System.out.println(lineTab);
					lineTab = "";
				}
			}
		}
		
	}
	@Override

	public boolean isCellUpdatable() {
		return false;
	}

	@Override
	public void updateCell(int[] tab) {
		// NOT an UPDATABLE View
	}

	@Override
	public void reset(int[][] tab) {
		// TODO Auto-generated method stub
		
	}
	
}
