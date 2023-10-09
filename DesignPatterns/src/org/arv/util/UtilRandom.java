package org.arv.util;

import java.util.Random;

public class UtilRandom {

	
	public static int makeRandomIntBetween(int min, int max) {
		Random random = new Random();
		int rnd= (int)(min + (max - min) * random.nextFloat()); 
		return rnd;
	}
	
}
