package Com.Service;

import Com.Dao.StudentDao;
import Com.Entities.Student;

public class StudentService {

	// ===== INSERT =====
	public void insertData(Student s) throws Exception {
		StudentDao sd = new StudentDao();
		sd.insertData(s);
	}
	// ===== READ ALL =====
	public void getAllStudents() throws Exception {
		StudentDao sd = new StudentDao();
		sd.getAllStudents();
	}

	// ===== UPDATE =====
	public void updateStudent(Student s) throws Exception {
		StudentDao sd = new StudentDao();
		sd.updateStudent(s);
	}

	// ===== DELETE =====
	public void deleteStudent(int id) throws Exception {
		StudentDao sd = new StudentDao();
		sd.deleteStudent(id);
	}

}
