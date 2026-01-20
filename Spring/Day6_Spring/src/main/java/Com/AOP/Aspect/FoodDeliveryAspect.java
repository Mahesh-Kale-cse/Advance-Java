package Com.AOP.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FoodDeliveryAspect {

//	@Before("execution (* com.tka.entity.Recharge.*(..))")
//	public void beforeMain() {
//		System.err.println("Validating Order ... !");
//	}

//	@Before("execution( public void myRecharge())")
//	public void beforeMain() {
//		System.err.println("Validating Order ... !");
//	}

//	@After("execution (* com.tka.entity.Recharge.*(..))")
//	public void afterMain() {
//		System.err.println("Delivery Plcae Successfully... !");
//	}

	@Around("execution (* Com.AOP.Entity.FoodOrderService.*(..))")
	public void afterMain(ProceedingJoinPoint p) {

		System.err.println("Validating Order ... !");
		try {
			p.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println("Delivery Plcae Successfully... !");
	}

}
