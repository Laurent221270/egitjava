package org.arv.order;

public enum OrderStatus {

	CREATED (5){
		@Override
		public boolean isReceived() {
			return true;
		}
	},
	COMPLETED (4){
		@Override
		public boolean isCompleted() {
			return true;
		}		
	},
	SHIPPED (3){
		@Override
		public boolean isShipped() {
			return true;
		}		
	},
	DELIVERED (0){
		@Override
		public boolean isDelivered() {
			return true;
		}		
	};
	
    private int timeToDelivery;
    public boolean isReceived() {return false;}
    public boolean isCompleted() {return false;}
    public boolean isShipped() {return false;}
    public boolean isDelivered() {return false;}
    
    public int getTimeToDelivery() {
    	return timeToDelivery;
    }
    
    OrderStatus(int timeToDelivery) {
		this.timeToDelivery= timeToDelivery;
	}

    
}
