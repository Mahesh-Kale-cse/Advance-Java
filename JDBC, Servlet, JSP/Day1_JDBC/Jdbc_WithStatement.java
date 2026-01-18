package Com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc_WithStatement {

    // DATABASE DETAILS
	String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/jdbc_db";
    String user = "root";
    String password = "Devil69&69";

    public static void main(String[] args) throws Exception {

        Jdbc_WithStatement obj = new Jdbc_WithStatement();

        // 1. CREATE - Insert Data
//        obj.insertData();

        // 2. READ - Fetch All Records
        obj.getAllRecords();

        // 3. UPDATE - Update Data
//        obj.updateData();

        // 4. DELETE - Delete Data
//        obj.deleteData();
    }

    // --------------------------------------------------
    // 1. CREATE OPERATION (INSERT DATA INTO DATABASE)
    // --------------------------------------------------
    public void insertData() throws Exception {

        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, user, password);
        Statement stmt = con.createStatement();

        int check = stmt.executeUpdate("INSERT INTO Student(id, name, age, city) VALUES (23, 'Amit', 23, 'Delhi')");
//      OR
//      String query = "INSERT INTO Student(id, name, age, city) VALUES (?, ?, ?, ?)";
//      PreparedStatement ps = con.prepareStatement(query);

        
        if (check > 0) {
            System.out.println("INSERT: Data inserted successfully");
        } else {
            System.out.println("INSERT: Data not inserted");
        }

        con.close();
    }

    // --------------------------------------------------
    // 2. READ OPERATION (FETCH DATA FROM DATABASE)
    // --------------------------------------------------
    public void getAllRecords() throws Exception {
    	
    	

//        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, password);
        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM Student");

        System.out.println("\nREAD: Student Records");
        while (rs.next()) {
            System.out.println(
                    "ID: " + rs.getInt("id") +
                    " | Name: " + rs.getString("name") +
                    " | Age: " + rs.getInt("age") +
                    " | City: " + rs.getString("city")
            );
        }

        con.close();
    }

    // --------------------------------------------------
    // 3. UPDATE OPERATION (UPDATE DATA IN DATABASE)
    // --------------------------------------------------
    public void updateData() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, password);
        Statement stmt = con.createStatement();

        int check = stmt.executeUpdate("UPDATE Student SET city='Mumbai' WHERE id=2");

        if (check > 0) {
            System.out.println("\nUPDATE: Data updated successfully");
        } else {
            System.out.println("\nUPDATE: Data not updated");
        }

        con.close();
    }

    // --------------------------------------------------
    // 4. DELETE OPERATION (DELETE DATA FROM DATABASE)
    // --------------------------------------------------
    public void deleteData() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, password);
        Statement stmt = con.createStatement();

        int check = stmt.executeUpdate("DELETE FROM Student WHERE id=23");

        if (check > 0) {
            System.out.println("\nDELETE: Data deleted successfully");
        } else {
            System.out.println("\nDELETE: Data not deleted");
        }

        con.close();
    }
}
