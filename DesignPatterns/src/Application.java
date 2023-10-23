import java.util.ArrayList;
import java.util.List;

import org.arv.order.Order;
import org.arv.orderable.Fillable;
import org.arv.orderable.Orderable;
import org.arv.stock.StockBox;
import org.arv.stock.StockProduct;
import org.arv.util.UtilRandom;

/**
 * une appli de mise en oauvre de principes SOLID
 * 
 * Avec l'utilisation d'Interfaces (surtout)
 */
public class Application {
	
	ArrayList<Order> orders;
	
	
	public Application() {
		orders = new ArrayList<Order>();
	}
	
	
	public static void main(String[] args) {
		
		Application appli= new Application();		
		appli.start();
	}

	public void start() {
		//createOrders(1,1); //test (petit Order)
		createOrders(3,-1);//cas général appli
		float totalOrderPrice= calculateOrdersTotalPrice();
		displayOrders();
		System.out.println("\ntotalOrderPrice="+totalOrderPrice);
	}


	
	
	/**
	 * 
	 * @param nbOrders
	 * @param nbPicked_FORCED nbre de Product ou Box ajoutés : 	-1 pour Nbre aléatoire de Product et box ajoutés 
	 * 															valeur >= 0 => Nbre fixe de Product ou Box à ajouter
	 */
	private void createOrders(int nbOrders, int nbPicked_FORCED) {
		for(int i=0; i<nbOrders; i++) {
			Order order= new Order();
			int nbPicked= (nbPicked_FORCED >= 0) ? nbPicked_FORCED : 0;

			if(nbPicked_FORCED < 0) {
				nbPicked= UtilRandom.makeRandomIntBetween(1, 5);				
			}
			order.addOrerables(StockProduct.getInstance().pickProductsFromStock(nbPicked_FORCED));

			if(nbPicked_FORCED < 0) {
				nbPicked= UtilRandom.makeRandomIntBetween(1, 5);				
			}
			List<Orderable> boxesFromStock = StockBox.getInstance().pickBoxesFromStock(nbPicked);
			
			for(Orderable elem : boxesFromStock) {
				if(nbPicked_FORCED < 0) {
					nbPicked= UtilRandom.makeRandomIntBetween(0, 3);
				}
				Fillable flb= (Fillable)elem;
				flb.fillBoxWithOrderables(StockBox.getInstance().pickBoxesFromStock(nbPicked));
				if(nbPicked_FORCED < 0) {
					nbPicked= UtilRandom.makeRandomIntBetween(0, 3);
				}
				flb.fillBoxWithOrderables(StockProduct.getInstance().pickProductsFromStock(nbPicked));
			}
			order.addOrerables(boxesFromStock);
			orders.add(order);
		}
	}
	
		
	private float calculateOrdersTotalPrice() {
		float totalPrice=0;
		for(Order order : orders) {
			float tot= order.getTotalPrice();
			totalPrice += tot;
		}
		return totalPrice;
	}
	

	
	/** DEBUG -------------------------------------------------------------------**/
	
	private void displayOrders() {
		for(Order order : orders) {
			System.out.println("_______________\ncommande #"+ order.getNumorder()+" (TOTAL="+order.getTotalPrice()+")");
			List<Orderable> listOrdb= order.getOrerables();
			for(Orderable ordrb : listOrdb) {
				ordrb.displayInfos("");
			}
			
		}
	}
	public void testRandom() {
			System.out.println("");
			for(int j=0; j<20; j++) {
				System.out.println("\t random = "+ UtilRandom.makeRandomIntBetween(3, 22));
			}
	}

}
