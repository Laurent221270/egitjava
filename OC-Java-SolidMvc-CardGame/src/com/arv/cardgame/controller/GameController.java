package com.arv.cardgame.controller;

import java.util.ArrayList;
import java.util.List;

import com.arv.cardgame.games.GameEvaluator;
import com.arv.cardgame.model.Deck;
import com.arv.cardgame.model.IPlayer;
import com.arv.cardgame.model.Player;
import com.arv.cardgame.model.PlayingCard;
import com.arv.cardgame.model.WinningPlayer;
import com.arv.cardgame.view.GameViewable;

public class GameController {

	enum GameState {
		AddingPlayers, CardsDealt, WinnerRevealed;
	}

	Deck deck;
	List<IPlayer> players;
	IPlayer winner;
	GameViewable view;

	GameState gameState;

	GameEvaluator evaluator;
	
	public GameController(Deck deck, GameViewable view, GameEvaluator evaluator) {
		super();
		this.deck = deck;
		this.view = view;
		this.players = new ArrayList<IPlayer>();
		this.gameState = GameState.AddingPlayers;
		view.setController(this);
		this.evaluator= evaluator;
	}

	public void run() {

		while (gameState == GameState.AddingPlayers) {
			view.promptForPlayerName();
		}
		
		
		switch (gameState) {
			case CardsDealt:
				view.promptForFlip();
				break;
			case WinnerRevealed:
				view.promptForNewGame();
				break;
			default:
				break;
		}
	}

	public void addPlayer(String playerName) {
		if (gameState == GameState.AddingPlayers) {
			players.add(new Player(playerName));
			view.showPlayerName(players.size(), playerName);
		}
	}


	/**
	 * me
	 */
	public void startGame() {
		if (gameState != GameState.CardsDealt) {
			view.displayMessage("\n\t NOUVELLE PARTIE");
			deck.shuffle();
			int playerIndex = 1;
			for (IPlayer player : players) {
				player.addCardToHand(deck.removeTopCard());
				view.showFaceDownCardForPlayer(playerIndex++, player.getName());
			}
			gameState = GameState.CardsDealt;
		}
		this.run();
	}

	public void flipCards() {
		int playerIndex = 1;
		for (IPlayer player : players) {
			PlayingCard pc = player.getCard(0);
			pc.flip();
			view.showCardForPlayer(playerIndex++, player.getName(), pc.getRank().toString(), pc.getSuit().toString()+"("+pc.getSuit().value()+")");
		}

		//findWinner();
		//winner = GameEvaluator.evaluateWinner(players);
		evaluateWinner();
		displayWinner();
		rebuildDeck();
		gameState = GameState.WinnerRevealed;
		this.run();
	}

	/**
	 * 2EME PHASE (Open/Closed)
	 */
	private void evaluateWinner() {
		winner = new WinningPlayer(evaluator.evaluateWinner(players));
	}

	private void displayWinner() {
		view.showWinner(winner.getName());
	}

	
	private void rebuildDeck() {
		for (IPlayer player : players) {
			deck.returnCardToDeck(player.removeCard());
		}
	}

	public void nextAction(String nextChoice) {
		if("q".equals(nextChoice)) {
			exitGame();
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
