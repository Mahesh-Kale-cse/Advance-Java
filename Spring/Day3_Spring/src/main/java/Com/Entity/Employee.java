package Com.Entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	
	@Value("123")
	int Id;
	@Value("Mahesh")
	String Name;
	@Value("Pune")
	String City;
	
	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", Name=" + Name + ", City=" + City + "]";
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public Employee(int id, String name, String city) {
		super();
		Id = id;
		Name = name;
		City = city;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	 public void display() {
	        System.out.println("Employee ID: " + Id);
	        System.out.println("Employee Name: " + Name);
	    }

}
