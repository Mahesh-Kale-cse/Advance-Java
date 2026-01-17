package Com.Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Com.Entity.Employee;

public class MainClass {

	public static void main(String args[]) {

		
		ApplicationContext context = new ClassPathXmlApplicationContext("springbeans.xml");
		Employee e1 = context.getBean(Employee.class);
		System.out.println(e1);

	}
}
