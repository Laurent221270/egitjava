package com.arv.cardgame.games;

import java.util.List;

import com.arv.cardgame.model.IPlayer;

public interface GameEvaluator {
	public IPlayer evaluateWinner(List<IPlayer> players);
}
