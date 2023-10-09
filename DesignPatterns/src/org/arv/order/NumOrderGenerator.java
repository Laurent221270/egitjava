package org.arv.order;

/**
 * New Order number Generator
 * SINGLETON
 */
public class NumOrderGenerator {

	
	private int newNumOrder= -1;
	
	private static NumOrderGenerator instance= null;
	
	
	private NumOrderGenerator() {
		newNumOrder= 0;
	}
	
	public static NumOrderGenerator getInstance() {
		if(NumOrderGenerator.instance == null) {
			NumOrderGenerator.instance= new NumOrderGenerator();
		} 
		return NumOrderGenerator.instance;
	}
	
	public int getNewNumOrder() {
		this.newNumOrder= newNumOrder + 1;
		return this.newNumOrder;
	}
	
}
