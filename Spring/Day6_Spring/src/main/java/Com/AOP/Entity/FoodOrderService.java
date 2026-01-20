package Com.AOP.Entity;

import org.springframework.stereotype.Component;

@Component
public class FoodOrderService {
	
	public void FoodDelivery() {
		System.out.println("Order Place ...!");
	}

}
