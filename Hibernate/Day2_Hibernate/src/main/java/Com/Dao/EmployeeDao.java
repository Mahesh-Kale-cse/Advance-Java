package Com.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Com.Entity.Employee;

public class EmployeeDao {
	
	public void insertData() {
		
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Employee.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		Employee e = new Employee();
		e.setEmpName("Krishna");
		e.setCity("Mathura");
		e.setSalary("35 LPA");
		e.setEmail("Krishna@gmail.com");
		
		ss.persist(e);
		
		tr.commit();
		ss.close();
		
		System.out.println("Data is inserted ... ! ");
	}
	
	public void deleteData() {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		int id = 126;
		Employee e = ss.get(Employee.class, id);

//		ss.delete(e);
		ss.remove(e);

		tr.commit();
		ss.close();

		System.out.println("Data is Deleted... ! ");

	}

	public void updateData() {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		int id = 124;
		Employee e = ss.load(Employee.class, id);

		e.setCity("nagpur");
		e.setEmpName("raj");
		e.setSalary("48LPA");

//		ss.update(e);
		ss.merge(e);
		System.out.println("Data is updated..");
		tr.commit();
		ss.close();

	}

	public void showSingleEmployee() {
		
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Employee.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		int id = 2;
		Employee e = ss.get(Employee.class, id);
		
		ss.merge(e);
		System.out.println("Show Data..");
		System.out.println(e);
		tr.commit();
		ss.close();
		
	}
	
	public void showSingleEmployee(int empId) {

	    Configuration cfg = new Configuration();
	    cfg.configure();
	    cfg.addAnnotatedClass(Employee.class);

	    SessionFactory sf = cfg.buildSessionFactory();
	    Session ss = sf.openSession();
	    Transaction tr = ss.beginTransaction();

	    Employee e = ss.get(Employee.class, empId);

	    if (e != null) {
	        System.out.println(e);
	    } else {
	        System.out.println("Employee with ID " + empId + " not found.");
	    }

	    tr.commit();
	    ss.close();
	    
	}
	
	
    public void showData() {
		
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Employee.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
        Session ss = sf.openSession();
        List<Employee> employees = ss.createQuery("from Employee", Employee.class).list();
        if (employees.isEmpty()) {
            System.out.println("No records found.");
        } else {
            for (Employee e : employees) {
                System.out.println(e);
            }
        }
        ss.close();
    }
}
