package Com.Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Com.Entity.Company;
import Com.Entity.Employee;

public class MainClass {

	public static void main(String args[]) {

		
		ApplicationContext context = new ClassPathXmlApplicationContext("springbeans.xml");
		Employee e1 = context.getBean("e",Employee.class);   // only call the Employee
		System.out.println(e1);                         
		Company c = context.getBean("Com",Company.class);    // call both company and Employee
		System.out.println(c); 

	}
}
