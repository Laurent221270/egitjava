package org.arv.stock;
import java.util.ArrayList;
import java.util.List;

import org.arv.orderable.Box;
import org.arv.orderable.Orderable;
import org.arv.util.UtilRandom;

public class StockBox {

	ArrayList<Box> stockBoxes;
	
	static StockBox instance = null;
	
	
	private StockBox() {
		
		stockBoxes= new ArrayList<Box> ();
		stockBoxes.add(new Box("petite BOITE", 0.50f));		
		stockBoxes.add(new Box("petite BOITE", 0.50f));		
		stockBoxes.add(new Box("petite BOITE", 0.50f));		
		stockBoxes.add(new Box("petite BOITE", 0.50f));		
		stockBoxes.add(new Box("petite BOITE", 0.50f));		
		stockBoxes.add(new Box("petite BOITE", 0.50f));		
		stockBoxes.add(new Box("petite BOITE", 0.50f));		
		stockBoxes.add(new Box("petite BOITE", 0.50f));		
		stockBoxes.add(new Box("petite BOITE", 0.50f));		
		stockBoxes.add(new Box("petite BOITE", 0.50f));		
		stockBoxes.add(new Box("moyenne BOITE", 0.60f));
		stockBoxes.add(new Box("moyenne BOITE", 0.60f));
		stockBoxes.add(new Box("moyenne BOITE", 0.60f));
		stockBoxes.add(new Box("moyenne BOITE", 0.60f));
		stockBoxes.add(new Box("moyenne BOITE", 0.60f));
		stockBoxes.add(new Box("moyenne BOITE", 0.60f));
		stockBoxes.add(new Box("moyenne BOITE", 0.60f));
		stockBoxes.add(new Box("moyenne BOITE", 0.60f));
		stockBoxes.add(new Box("moyenne BOITE", 0.60f));
		stockBoxes.add(new Box("moyenne BOITE", 0.60f));
		stockBoxes.add(new Box("grande BOITE", 0.80f));
		stockBoxes.add(new Box("grande BOITE", 0.80f));
		stockBoxes.add(new Box("grande BOITE", 0.80f));
		stockBoxes.add(new Box("grande BOITE", 0.80f));
		stockBoxes.add(new Box("grande BOITE", 0.80f));
		stockBoxes.add(new Box("grande BOITE", 0.80f));
		stockBoxes.add(new Box("grande BOITE", 0.80f));
		stockBoxes.add(new Box("grande BOITE", 0.80f));
		stockBoxes.add(new Box("grande BOITE", 0.80f));
		stockBoxes.add(new Box("grande BOITE", 0.80f));

	}


	public static StockBox getInstance() {
		if(instance==null) {
			instance= new StockBox();
		}
		return instance;
	}
	
	public List<Orderable> pickBoxesFromStock(int nbBoxes){
		ArrayList<Orderable> pickedBoxes = new ArrayList<Orderable>();
		for(int i=0; i<nbBoxes; i++) {
			int indexPick= UtilRandom.makeRandomIntBetween(0, stockBoxes.size());
			pickedBoxes.add(stockBoxes.remove(indexPick));
		}
		return pickedBoxes;
	}
	
	
}
