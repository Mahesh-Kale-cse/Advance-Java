package Com.Controller;

import Com.Service.EmployeeService;

public class EmployeeController {

	public static void main(String[] args) {
		EmployeeService service = new EmployeeService();
//		service.insertData();
//		service.deleteData();
//		service.updateData();
//		service.showData();
		service.showSingleEmployee();
//		service.showSingleEmployee(2);
		
	}
}
