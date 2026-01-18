package Com.Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Com.Config.ConfigClass;
import Com.Entity.Company;
import Com.Entity.Employee;

public class MainClass {

	public static void main(String args[]) {

		
		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);
		Company c = context.getBean(Company.class);    
		System.out.println(c); 
		
	

	}
}
