package Com.AOP.Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Com.AOP.Config.MyConfigClass;
import Com.AOP.Entity.FoodOrderService;

public class MainClass {
	
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfigClass.class);
		FoodOrderService FD = context.getBean(FoodOrderService.class);
		FD.FoodDelivery();
	}


}
