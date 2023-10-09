package org.arv.stock;
import java.util.ArrayList;
import java.util.List;

import org.arv.orderable.Orderable;
import org.arv.orderable.Product;
import org.arv.util.UtilRandom;

public class StockProduct {

	ArrayList<Product> stockProducts;
	
	static StockProduct instance = null;
	
	
	private StockProduct() {
		
		stockProducts= new ArrayList<Product> ();
		stockProducts.add(new Product("crayon", 0.50f));
		stockProducts.add(new Product("crayon", 0.50f));
		stockProducts.add(new Product("crayon", 0.50f));
		stockProducts.add(new Product("stylo", 0.60f));
		stockProducts.add(new Product("stylo", 0.60f));
		stockProducts.add(new Product("stylo", 0.60f));
		stockProducts.add(new Product("papier", 0.50f));
		stockProducts.add(new Product("papier", 0.50f));
		stockProducts.add(new Product("papier", 0.50f));
		stockProducts.add(new Product("papier", 0.50f));
		stockProducts.add(new Product("marteau", 9.50f));
		stockProducts.add(new Product("marteau", 9.50f));
		stockProducts.add(new Product("marteau", 9.50f));
		stockProducts.add(new Product("marteau", 9.50f));
		stockProducts.add(new Product("caillou", 3.50f));
		stockProducts.add(new Product("tenaille", 7.50f));
		stockProducts.add(new Product("tenaille", 7.50f));
		stockProducts.add(new Product("tenaille", 7.50f));
		stockProducts.add(new Product("tenaille", 7.50f));
		stockProducts.add(new Product("cutter", 6.40f));
		stockProducts.add(new Product("cutter", 6.40f));
		stockProducts.add(new Product("cutter", 6.40f));
		stockProducts.add(new Product("scie", 5.25f));
		stockProducts.add(new Product("sachet de clous", 3.00f));
		stockProducts.add(new Product("sachet de clous", 3.00f));
		stockProducts.add(new Product("sachet de clous", 3.00f));
		stockProducts.add(new Product("sachet de clous", 3.00f));
		stockProducts.add(new Product("sachet de clous", 3.00f));
		stockProducts.add(new Product("sachet de vis", 4.60f));
		stockProducts.add(new Product("sachet de vis", 4.60f));
		stockProducts.add(new Product("sachet de vis", 4.60f));
		stockProducts.add(new Product("enclume", 120.00f));
		stockProducts.add(new Product("pince", 12.50f));
		stockProducts.add(new Product("pince", 12.50f));
		stockProducts.add(new Product("rabot", 23.00f));
	}


	public static StockProduct getInstance() {
		if(instance==null) {
			instance= new StockProduct();
		}
		return instance;
	}
	
	public List<Orderable> pickProductsFromStock(int nbProducts){
		ArrayList<Orderable> pickedProduct = new ArrayList<Orderable>();
		for(int i=0; i<nbProducts; i++) {
			int indexPick= UtilRandom.makeRandomIntBetween(0, stockProducts.size());
			pickedProduct.add(stockProducts.remove(indexPick));
		}
		return pickedProduct;
	}
	
	
}
