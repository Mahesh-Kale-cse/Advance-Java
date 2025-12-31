package Com.Controller;

import java.util.Scanner;

import Com.Entities.Student;
import Com.Service.StudentService;

public class StudentController {

	    // ===== INSERT =====
	    public void insertData(Student s) throws Exception {
	    	StudentService ss = new StudentService();
	    	ss.insertData(s);
	    }

		// ===== READ ALL =====
		public void getAllStudents() throws Exception {
			StudentService ss = new StudentService();
			ss.getAllStudents();
		}

		// ===== UPDATE =====
		public void updateStudent(Student s) throws Exception {
			StudentService ss = new StudentService();
			ss.updateStudent(s);
		}

		// ===== DELETE =====
		public void deleteStudent(int id) throws Exception {
			StudentService ss = new StudentService();
			ss.deleteStudent(id);
		}
		
		

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter ur ID here..!");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.println("Enter ur Name here..!");
		String name = sc.nextLine();

		System.out.println("Enter ur City here..!");
		String city = sc.nextLine();

		Student s = new Student(id, name, city);
		StudentController ss = new StudentController();
		ss.insertData(s);
		ss.getAllStudents();
//		ss.updateStudent(new Student(1, "NewName", "NewCity"));
//		ss.deleteStudent(1);

	}
	
//	-----------------OR------------------------
	
	/*
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		StudentController ss = new StudentController();

		System.out.println("Choose Operation:");
		System.out.println("1. Insert");
		System.out.println("2. View All");
		System.out.println("3. Update");
		System.out.println("4. Delete");

		int choice = sc.nextInt();
		sc.nextLine();

		switch (choice) {

		case 1:
			System.out.println("Enter ur ID here..!");
			int id = sc.nextInt();
			sc.nextLine();

			System.out.println("Enter ur Name here..!");
			String name = sc.nextLine();

			System.out.println("Enter ur City here..!");
			String city = sc.nextLine();

			Student s = new Student(id, name, city);
			ss.insertData(s);
			break;

		case 2:
			ss.getAllStudents();
			break;

		case 3:
			System.out.println("Enter ID to update:");
			int uid = sc.nextInt();
			sc.nextLine();

			System.out.println("Enter New Name:");
			String uname = sc.nextLine();

			System.out.println("Enter New City:");
			String ucity = sc.nextLine();

			ss.updateStudent(new Student(uid, uname, ucity));
			break;

		case 4:
			System.out.println("Enter ID to delete:");
			int did = sc.nextInt();
			ss.deleteStudent(did);
			break;

		default:
			System.out.println("Invalid Choice!");
		}

		sc.close();
	}
    */     

}