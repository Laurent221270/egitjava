package org.arv.order;
import java.util.ArrayList;
import java.util.List;

import org.arv.orderable.Orderable;

public class Order {

	private OrderStatus status;
	private int numOrder;
	private float totalPrice;
	private List<Orderable> contentOrder;

	public Order() {
		this.numOrder= getNewOrderNum();
		contentOrder= new ArrayList<Orderable>();
		this.status= OrderStatus.CREATED; 
	}
	
	/**
	 * Obtain a new Order number
	 */
	private int getNewOrderNum() {
		NumOrderGenerator generator = NumOrderGenerator.getInstance();
		return generator.getNewNumOrder();
	}

	
	
	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public int getNumorder() {
		return numOrder;
	}	
	public float getTotalPrice() {
		totalPrice=0;
		for(Orderable elem : contentOrder) {
			totalPrice += elem.getPrice();
		}
		return totalPrice;
	}
	
	
	
	
	
	public boolean addOrerables(List<Orderable> list) {
		contentOrder.addAll(list);
		return true;
	}
	public List<Orderable> getOrerables() {
		return contentOrder;
	}

}
