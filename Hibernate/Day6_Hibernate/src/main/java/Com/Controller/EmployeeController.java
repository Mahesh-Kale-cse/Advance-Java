package Com.Controller;

import java.util.Scanner;
import Com.Service.EmployeeService;

public class EmployeeController {

    public static void main(String[] args) {

        EmployeeService service = new EmployeeService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== EMPLOYEE CRUD OPERATIONS =====");
            System.out.println("1. Insert Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Get All Employees");
            System.out.println("5. Get Single Employee");
            System.out.println("6. Exit");
            System.out.print("Select Operation: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    service.insertData();
                    break;

                case 2:
                    service.deleteData();
                    break;

                case 3:
                    service.updateData();
                    break;

                case 4:
                    service.getAllData();
                    break;

                case 5:
                    service.getSingleRecord();
                    break;

                case 6:
                    System.out.println("Application Closed");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice! Please select again.");
            }
        }
    }
}
