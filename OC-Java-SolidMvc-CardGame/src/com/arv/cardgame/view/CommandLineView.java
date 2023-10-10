package com.arv.cardgame.view;

import java.util.Scanner;

import com.arv.cardgame.controller.GameController;

public class CommandLineView implements GameViewable {
	

	GameController controller;
	Scanner keyboard = new Scanner(System.in);
	
	public void setController(GameController gc) {
		this.controller= gc;
	}

	@Override
	public void promptForPlayerName() {
		System.out.println("Enter IPlayer Name:");
		String name= keyboard.nextLine();
		if(name.isEmpty()) {
			controller.startGame();
		} else {
			controller.addPlayer(name);
		}
	}

	@Override
	public void promptForFlip() {
		System.out.println("Press enter to Flip cards ?");
		keyboard.nextLine();
		controller.flipCards();
	}

	@Override
	public void promptForNewGame() {
		System.out.println("New game ?");
		controller.nextAction(keyboard.nextLine());		
	}

	@Override
	public void showWinner(String playerName) {
		System.out.println("The winner is:"+ playerName + "!");
	}

	@Override
	public void showPlayerName(int numPlayer, String playerName) {
		System.out.println("Player #"+numPlayer+":"+ playerName);
	}
	
	@Override
	public void showFaceDownCardForPlayer(int playerIndex, String name) {
		System.out.println("["+playerIndex+"]["+name+"][x][x]");
	}

	@Override
	public void showCardForPlayer(int playerIndex, String name, String rank, String suit) {
		System.out.println("["+playerIndex+"]["+name+"]["+rank+"]["+suit+"]");
	}

	@Override
	public void displayMessage(String string) {
		System.out.println(string);
	}
	
	
}
