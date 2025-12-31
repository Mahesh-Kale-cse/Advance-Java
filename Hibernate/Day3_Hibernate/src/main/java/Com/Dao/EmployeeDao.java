package Com.Dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import Com.Entity.Employee;

public class EmployeeDao {
	
	

	public void insertData() {
	    Scanner sc = new Scanner(System.in);

	    System.out.print("Enter Employee address: ");
	    String address = sc.next();

	    System.out.print("Enter Employee email: ");
	    String email = sc.next();

	    System.out.print("Enter Employee Name: ");
	    String empName = sc.next();

	    System.out.print("Enter Employee Salary: ");
	    String salary = sc.next();

	    Configuration cfg = new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    cfg.addAnnotatedClass(Employee.class);

	    SessionFactory sf = cfg.buildSessionFactory();
	    Session ss = sf.openSession();
	    Transaction tr = ss.beginTransaction();

	    Employee e = new Employee();
	    e.setEmpName(empName);
	    e.setCity(address);
	    e.setEmail(email);
	    e.setSalary(salary);

	    ss.persist(e); 

	    tr.commit();
	    ss.close();

	    System.out.println("1 record inserted successfully!");
	}


	public void deleteData() {
	    Scanner sc = new Scanner(System.in);
	    System.out.print("Enter Employee ID to delete: ");
	    int empId = sc.nextInt();

	    Configuration cfg = new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    cfg.addAnnotatedClass(Employee.class);

	    SessionFactory sf = cfg.buildSessionFactory();
	    Session ss = sf.openSession();
	    Transaction tr = ss.beginTransaction();

	    // Correct HQL delete
	    String hql = "delete from Employee where empId = :id";
	    Query<?> query = ss.createQuery(hql); // ✅ no type parameter
	    query.setParameter("id", empId);

	    int result = query.executeUpdate(); // returns number of rows deleted

	    tr.commit();
	    ss.close();

	    System.out.println(result + " record(s) deleted successfully!");
	}


	public void updateData() {
	    Scanner sc = new Scanner(System.in);

	    System.out.print("Enter Employee ID to update: ");
	    int id = sc.nextInt();

	    System.out.print("Enter new Employee Name: ");
	    String name = sc.next();

	    System.out.print("Enter new City: ");
	    String city = sc.next();

	    System.out.print("Enter new Salary: ");
	    String salary = sc.next();

	    Configuration cfg = new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    cfg.addAnnotatedClass(Employee.class);

	    SessionFactory sf = cfg.buildSessionFactory();
	    Session ss = sf.openSession();
	    Transaction tr = ss.beginTransaction();

	    // Correct HQL Update Query
	    String hql = "update Employee set empName = :name, city = :city, salary = :salary " +
	                 "where empId = :id";

	    Query<?> query = ss.createQuery(hql);  // ✅ No result type
	    query.setParameter("name", name);
	    query.setParameter("city", city);
	    query.setParameter("salary", salary);
	    query.setParameter("id", id);

	    int result = query.executeUpdate();  // returns number of rows updated

	    tr.commit();
	    ss.close();

	    System.out.println(result + " record(s) updated successfully!");
	}


	public void getAllData() {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		// sql query for fetch all data - select * from empdata;

		// hql Query -> from Employee

		String hqlQuery = "from Employee";

		Query<Employee> query = ss.createQuery(hqlQuery, Employee.class);
		List<Employee> list = query.list();

		for (Employee employee : list) {
			System.out.println(employee);
		}

		tr.commit();
		ss.close();

	}
	
	public void getSingleRecord() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Employee ID to fetch: ");
		int empId =sc.nextInt();
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		String hqlQuery = "from Employee where empId = :id";
		
		Query<Employee> query = ss.createQuery(hqlQuery,Employee.class);
		query.setParameter("id", empId);

		Employee e = query.uniqueResult();
		System.out.println(e);
		
		tr.commit();
		ss.close();
		
	}
	
}