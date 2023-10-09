package com.arv.arrayeater.model;

import com.arv.arrayeater.util.UtilRandom;

public class ArrayEater {

	
	enum ArrayEaterState {
		INITIALIZED, FIRST_CELL_EATEN, IN_PROGRESS, ALL_EATEN
	}
	
	private ArrayEaterState arrayEaterState;
	private int  nbEat = 50;
	private int dimTab = 15;
	private int[][] tab;
	
	char orientation= 'V';
	int direction= +1; // sens de déplacement positif(index  augmente OU négatif index diminue)
	
	private int curNbOrientationChange;
	private int curNbDirectionChange;
	
	
	private int hMoves;
	private int vMoves;
	private int curNbMoves;

	// (0 < pivot <11) : pivot grand= augmente fréquence de changement de Mode de déplacement (H, V, positif, négatif)
	private final int pivotOrientation = 3; //(valeur milieu 6 => fréquence changment moyenne )
	private final int pivotDirection = 3;
	
	//coordonnées de la cellule mangée
	private int curX;
	private int curY;
	//nouvele valeur de cette celulle
	private int curValue;
	
	/**
	 * Constructeur
	 * @param dim
	 */
	public ArrayEater(int dim) {
		this.dimTab= dim;
		tab = new int[dimTab][dimTab];
		initialize();
	}

	/**
	 * ************************  main *************************
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayEater test = new ArrayEater(10);
		while(test.eatNext()) {
			test.debugAfficheTableau();
		}
	}
	
	
	public void setNbEat(int nbEat) {
		this.nbEat = nbEat;
	}

	public int[][] getTableau() {
		return tab;
	}

	/**
	 * Méthode à appeler dpeuis le controller
	 */
	public boolean eatNext() {

		if(arrayEaterState != ArrayEaterState.INITIALIZED) {
			// détermine prochaines coordonnées courantes
			evaluateMovePatternChange();
			if (orientation == 'V') {
				curY = moveToNext(curY);
				hMoves += 1;
			} else {
				curX = moveToNext(curX);
				vMoves += 1;
			}
			curNbMoves= hMoves + vMoves;			
		}
		
		eatCurrent();
		
		switch(arrayEaterState) {
			case INITIALIZED:
				arrayEaterState = ArrayEaterState.FIRST_CELL_EATEN;
				break;
			case FIRST_CELL_EATEN:
				arrayEaterState = ArrayEaterState.IN_PROGRESS;
				break;
			default:
				break;				
		}
		
		
		return(arrayEaterState != ArrayEaterState.ALL_EATEN);
	}


	private void eatCurrent() {

		tab[curY][curX] += 1;
		curValue= tab[curY][curX];
		
		if(curNbMoves >= nbEat) {
			arrayEaterState = ArrayEaterState.ALL_EATEN;
		}
	}

	public int[] getLastUpdatedCell() {
		return (new int[] { curY, curX, curValue});
	}
	
	private void evaluateMovePatternChange() {
		// changement Orientation ?
		if(UtilRandom.changeMoveType(pivotOrientation)) {
			switch(orientation) {
				case 'V' :
					orientation= 'H';
					break;
				case 'H' :
					orientation= 'V';
					break;
			}
			curNbOrientationChange += 1;
			// changement Direction ?
			if(UtilRandom.changeMoveType(pivotDirection)) {
				direction = -direction;
				curNbDirectionChange += 1;
			}
		}		
	}
	
	/**
	 * définit la prochaine valeur de la coordonnée
	 */
	private int moveToNext(int coord) {

		coord = coord + direction;
		// si déborde vers négatif
		if (coord == -1) {
			// revient par l'autre côté (à droite ou en bas)
			coord = dimTab - 1;
		} else if (coord == dimTab) {
			// revient par l'autre côté (à gauche ou en haut)
			coord = 0;
		}
		return coord;
	}

	/**
	 * Affichage Console du Tableau (Debug)
	 */
	private void debugAfficheTableau() {
		String lineTab = "";
		System.out.println("-----------------------------------------");
		for (int i = 0; i < dimTab; i++) {
			for (int j = 0; j < dimTab; j++) {
				lineTab += tab[i][j] + (j == dimTab - 1 ? "" : " ");
				if (j == dimTab - 1) {
					System.out.println(lineTab);
					lineTab = "";
				}
			}
		}
	}

	/**
	 * initialisation Valeurs départ Et tableau (remplit avec des 0)
	 */
	public void initialize() {
		
		hMoves = 0;
		vMoves = 0;
		curNbMoves=0;
		curNbOrientationChange=0;
		curNbDirectionChange=0;
		//coordonnées cellule de départ
		curX= (int)(dimTab/2);
		curY= (int)(dimTab/2);
		orientation = UtilRandom.getRandomInitialOrientation();						
		
		for (int y = 0; y < dimTab; y++) {
			for (int x = 0; x < dimTab; x++) {
				tab[y][x] = 0;
			}
		}
		arrayEaterState= ArrayEaterState.INITIALIZED;
	}
	
	
	/**
	 * STATISTIQUES DU JEU
	 * @return
	 */
	public String[] getStatistics() {
		String [] stats = new String[7];
		
		stats[0] = "dimTab \t\t=" + dimTab + "x" + dimTab;
		stats[1] = "nb cells Eaten \t\t=" + nbEat;
		stats[2] = "Nb OrientationChange \t=" + curNbOrientationChange;
		stats[3] = "Nb DirectionChange \t=" + curNbDirectionChange;
		stats[4] = "Nb Moves \t\t=" + curNbMoves;
		stats[5] = "H-Moves \t\t=" + hMoves;
		stats[6] = "V-Moves \t\t=" + vMoves;
		
		return stats;
	}

	public boolean isInprogress() {
		return (arrayEaterState == ArrayEaterState.IN_PROGRESS);
	}

	

}
