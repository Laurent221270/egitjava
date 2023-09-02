package com.arv.cardgame.model;

public interface IPlayer {

	public void addCardToHand(PlayingCard pc); 
	
	public String getName();

	public PlayingCard getCard(int index);
	
	public PlayingCard removeCard(); 
}
