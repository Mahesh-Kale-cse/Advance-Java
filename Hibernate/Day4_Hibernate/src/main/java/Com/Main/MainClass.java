package Com.Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Com.Entity.Laptop;
import Com.Entity.Student;


public class MainClass {
	
	public static void main(String args[]) {
		
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Student.class);
		cfg.addAnnotatedClass(Laptop.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		Laptop l = new Laptop();
		l.setlName("Lenovo");
		
		ss.persist(l);
		
		Student s = new Student();
		s.setName("Apte");
		s.setStudId(102);
		s.setCity("Nagar");
		s.setL(l);
		
		ss.persist(s);
		
		System.out.println("Data is Inserted .. !");
		
		tr.commit();
		ss.close();
		
		
	}

}
