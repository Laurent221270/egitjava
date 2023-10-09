package org.arv.orderable;

public class Product implements Orderable {

	static final OrderableType orderableType= OrderableType.TYPE_PRODUCT;
	String name;
	float price;
	
	public Product(String name, float price) {
		this.name= name;
		this.price= price;
	}
	
	@Override
	public OrderableType getOrderableType() {
		return orderableType;
	}	
	@Override
	public String getName() {
		return name;
	}
	@Override
	public float getPrice() {
		return price;
	}

	@Override
	public void displayInfos(String indent) {
		System.out.println( indent + "\t prod : " + this.getName() + " - " + this.getPrice()); //+ " (displayInfos())"
		//displayOrderableInterfaces();
	}

	
	
}
