package com.arv.cardgame.games;

import java.util.List;

import com.arv.cardgame.model.IPlayer;
import com.arv.cardgame.model.PlayingCard;

/**
 * LowCardGameEvaluator
 * carte Gagnante= Carte la plus faible
 * 
 */
public class LowCardGameEvaluator implements GameEvaluator {

	@Override
	public IPlayer evaluateWinner(List<IPlayer> players) {

		IPlayer bestPlayer = null;
		int bestRank = -1;
		int bestSuit = -1;

		for (IPlayer player : players) {
			boolean newBestPlayer = false;
			if (bestPlayer == null) {
				newBestPlayer = true;
			} else {
				PlayingCard pc = player.getCard(0);
				int thisRank = pc.getRank().value();
				if (thisRank <= bestRank) {
					if (thisRank < bestRank) {
						newBestPlayer = true;
					} else {
						if (pc.getSuit().value() < bestSuit) {
							newBestPlayer = true;
						}
					}
				}
			}

			if (newBestPlayer) {
				bestPlayer = player;
				PlayingCard pc = player.getCard(0);
				bestRank = pc.getRank().value();
				bestSuit = pc.getSuit().value();
			}
		}

		return bestPlayer;
	
	}

}
