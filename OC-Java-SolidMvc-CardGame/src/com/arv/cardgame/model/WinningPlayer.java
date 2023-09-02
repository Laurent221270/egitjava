package com.arv.cardgame.model;

public class WinningPlayer implements IPlayer {

	
	IPlayer winner;
	
	
	public WinningPlayer(IPlayer player) {
		this.winner = player;
	}

	@Override
	public void addCardToHand(PlayingCard pc) {
		winner.addCardToHand(pc);
	}

	@Override
	public String getName() {
		return "******" + winner.getName() + "******" ;
	}

	@Override
	public PlayingCard getCard(int index) {
		// TODO Auto-generated method stub
		return winner.getCard(index);
	}

	@Override
	public PlayingCard removeCard() {
		// TODO Auto-generated method stub
		return winner.removeCard();
	}

}
