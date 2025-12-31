package Com.Dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Com.Entities.Student;

public class StudentDao {
	

	// --------------------------------------------------
    // 1. CREATE OPERATION - INSERT DATA USING USER INPUT
    // --------------------------------------------------
	public void insertData(Student s) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "Devil69&69");
		PreparedStatement ps = c.prepareStatement("insert into Student(id,name,city)values(?,?,?);");
		ps.setInt(1, s.getId());
		ps.setString(2, s.getName());
		ps.setString(3, s.getCity());

		int check = ps.executeUpdate();
		if (check > 0) {
			System.out.println("Data is inserted...");
		} else {
			System.err.println("Data is NOT inserted...");
		}

		c.close();
	}
	
	// ===== READ (Get All Students) =====
		public void getAllStudents() throws Exception {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jdbc_db", "root", "Devil69&69");

			PreparedStatement ps = c.prepareStatement(
					"select * from Student");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println(
					rs.getInt("id") + " | " +
					rs.getString("name") + " | " +
					rs.getString("city")
				);
			}

			c.close();
		}

		// ===== UPDATE =====
		public void updateStudent(Student s) throws Exception {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jdbc_db", "root", "Devil69&69");

			PreparedStatement ps = c.prepareStatement(
					"update Student set name=?, city=? where id=?");

			ps.setString(1, s.getName());
			ps.setString(2, s.getCity());
			ps.setInt(3, s.getId());

			int check = ps.executeUpdate();
			if (check > 0) {
				System.out.println("Data updated...");
			} else {
				System.err.println("Data NOT updated...");
			}

			c.close();
		}

		// ===== DELETE =====
		public void deleteStudent(int id) throws Exception {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jdbc_db", "root", "Devil69&69");

			PreparedStatement ps = c.prepareStatement(
					"delete from Student where id=?");
			ps.setInt(1, id);

			int check = ps.executeUpdate();
			if (check > 0) {
				System.out.println("Data deleted...");
			} else {
				System.err.println("Data NOT deleted...");
			}

			c.close();
		}
}

