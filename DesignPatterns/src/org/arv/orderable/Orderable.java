package org.arv.orderable;

public interface Orderable {
	
	public OrderableType getOrderableType();
	public String getName();
	public float getPrice();
	public void displayInfos(String indent);
	
	
	/**
	 * default methods in interfaces 
	 * @since java 8
	 */
	default void displayOrderableInterfaces() {
		String interfaces="";
		Class<?>[] intf= this.getClass().getInterfaces();
		for (int j = 0; j < intf.length; j++) {
			if(j>0) {
				interfaces+=",";
			}
			interfaces+= intf[j].toString();
		} 	
		System.out.println("\t "+interfaces);
	}
		
	
	
}
