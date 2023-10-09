package org.arv.orderable;

public enum OrderableType {

	TYPE_PRODUCT ("PRODUIT"), TYPE_BOX ("BOITE");

	
	String labelType; 
	
	OrderableType(String string) {
		this.labelType= string;
	}

	public String getLabelType() {
		return labelType;
	}
	
}
