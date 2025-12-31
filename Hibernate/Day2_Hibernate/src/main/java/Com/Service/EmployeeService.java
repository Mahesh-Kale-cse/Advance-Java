package Com.Service;

import Com.Dao.EmployeeDao;

public class EmployeeService {
	
	public void insertData() {
		EmployeeDao dao = new EmployeeDao();
		dao.insertData();
	}

	public void deleteData() {
		EmployeeDao dao = new EmployeeDao();
		dao.deleteData();
	}

	public void updateData() {
		EmployeeDao dao = new EmployeeDao();
		dao.updateData();
		
	}

	public void showSingleEmployee() {
		EmployeeDao dao = new EmployeeDao();
		dao.showSingleEmployee();
		
	}

	public void showSingleEmployee(int i) {
		EmployeeDao dao = new EmployeeDao();
		dao.showSingleEmployee(i);
		
	}

	public void showData() {
		EmployeeDao dao = new EmployeeDao();
		dao.showData();
		
	}
}
