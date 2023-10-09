package org.arv.orderable;
import java.util.ArrayList;
import java.util.List;

public class Box implements Orderable, Fillable {

	static final OrderableType orderableType= OrderableType.TYPE_BOX;
	private String name;
	private float price;
	private float totalContentPrice; // total du contenu de la boite (Contient des boites ET/OU des produits, des boites remplies de boites ET/OU de produits, Etc...)

	private List<Orderable> contentOrderables;
	
	public Box(String name, float price) {
		this.name= name;
		this.price= price;
		this.contentOrderables= new ArrayList<Orderable>();
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
		totalContentPrice= price;
		if(containsOrderables()) {
			for(Orderable elem : contentOrderables) {
				totalContentPrice += elem.getPrice();
			}
		}
		return totalContentPrice;
	}
	

	private boolean containsOrderables() {
		return (contentOrderables.size()>0);
	}

	public void fillBoxWithOrderables(List<Orderable> list) {
		contentOrderables.addAll(list);
		exploreContenu();
	}
	
	private void exploreContenu() {
		System.out.println("dans la boite on a Ajouté");
		for(Orderable elem : contentOrderables) {
			System.out.println("\t" + elem.getOrderableType().getLabelType());
		}
		
	}

	@Override
	public void displayInfos(String indent) {
		System.out.println( indent + "\t box  : " + this.getName() + " - " + this.getPrice()); //+ " (displayInfos())"
		for(Orderable ordrb : contentOrderables) {
			ordrb.displayInfos("\t");
		}
		
	}
	
	
	
}
