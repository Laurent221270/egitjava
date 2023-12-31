package com.arv.cardgame.model;


/**
 * pattern FACTORY
 */
public class DeckFactory {
	
	public enum DeckType {
		Normal, Small, Test
	};

	public static Deck makeDeck(DeckType type) {
		switch (type) {
			case Normal:
				return (new NormalDeck());
			case Small:
				return (new SmallDeck());
			case Test:
				return (new TestDeck());
		}
		
		//default return
		return new NormalDeck();
	}

}
