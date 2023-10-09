package com.arv.arrayeater.util;

import java.util.Random;

public class UtilRandom {

	/**
	 * @return int -1 ou +1
	 * @deprecated
	 */
	public static int makeRandomMove() {
		Random random = new Random();
		int nb = random.nextInt(12);
		if (nb <= 5) {
			return -1;
		} else {
			return 1;
		}
	}

	/**
	 * détermine orientation initiale de déplacemment
	 * 
	 * @return 
	 * char 'H' pour Horizontale
	 * 		'V' pour Verticale
	 */
	public static char getRandomInitialOrientation() {
		Random random = new Random();
		int nb = random.nextInt(12);
		if (nb < 6) {
			return 'H';
		} else {
			return 'V';
		}
	}

	/**
	 * détermine aléatoirement si l'Orientation (déplact Horizontal ou Vertical) 
	 * ou la Direction (Positif ou Négatif)
	 * doit être modifiée 
	 * @return
	 */
	public static boolean changeMoveType(int pivot) {
		Random random = new Random();
		int nb = random.nextInt(12);
		if (nb < pivot) {
			return true;
		} else {
			return false;
		}
	}

}
