package Com.Entity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String args[]) {

		
		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);
		
		Student u = context.getBean(Student.class);
		System.out.println(u.getEnginnering().SelectCarrier());
		System.out.println(u.getDoctor().SelectCarrier());
		
	

	}
}
