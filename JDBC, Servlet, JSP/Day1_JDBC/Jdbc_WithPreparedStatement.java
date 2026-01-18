package Com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Jdbc_WithPreparedStatement {

    // DATABASE DETAILS
    String url = "jdbc:mysql://localhost:3306/jdbc_db";
    String user = "root";
    String password = "Devil69&69";

    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        Jdbc_WithPreparedStatement obj = new Jdbc_WithPreparedStatement();

        // CREATE (Insert Record)
//        obj.insertData();

        // READ (Fetch All Records)
        obj.getAllRecords();

        // UPDATE (Update Record)
        obj.updateData();

        // DELETE (Delete Record)
        obj.deleteData();
    }

    // --------------------------------------------------
    // 1. CREATE OPERATION - INSERT DATA USING USER INPUT
    // --------------------------------------------------
    public void insertData() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, password);
        
        PreparedStatement ps = con.prepareStatement(("INSERT INTO Student(id, name, age, city) VALUES (?, ?, ?, ?)"));
//      OR
//      String query = "INSERT INTO Student(id, name, age, city) VALUES (?, ?, ?, ?)";
//      PreparedStatement ps = con.prepareStatement(query);

// ------------------------------------------------------       
//      ps.setInt(1, 24);
//		ps.setString(2, "sahil");
//		ps.setString(3, "bhopal");
//        --------OR--------       
        System.out.print("Enter Student ID: ");
        ps.setInt(1, sc.nextInt());

        System.out.print("Enter Student Name: ");
        ps.setString(2, sc.nextLine());

        System.out.print("Enter Student Age: ");
        ps.setInt(3, sc.nextInt());

        System.out.print("Enter Student City: ");
        ps.setString(4, sc.nextLine());
// ------------------------------------------------------       

        int check = ps.executeUpdate();

        if (check > 0) {
            System.out.println("INSERT: Data inserted successfully\n");
        } else {
            System.out.println("INSERT: Data not inserted\n");
        }

        con.close();
    }

    // --------------------------------------------------
    // 2. READ OPERATION - FETCH ALL RECORDS
    // --------------------------------------------------
    public void getAllRecords() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, password);
        
        PreparedStatement ps = con.prepareStatement("SELECT * FROM Student");
        ResultSet rs = ps.executeQuery();

        System.out.println("READ: Student Records");
        System.out.println("----------------------");

        while (rs.next()) {
            System.out.println(
                    "ID: " + rs.getInt("id") +
                    " | Name: " + rs.getString("name") +
                    " | Age: " + rs.getInt("age") +
                    " | City: " + rs.getString("city")
            );
        }

        System.out.println();
        con.close();
    }

    // --------------------------------------------------
    // 3. UPDATE OPERATION - UPDATE STUDENT CITY BY ID
    // --------------------------------------------------
    public void updateData() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, password);
     
        PreparedStatement ps = con.prepareStatement("UPDATE Student SET city=? WHERE id=?");

        System.out.print("Enter Student ID to Update: ");
        ps.setInt(2, sc.nextInt());

        System.out.print("Enter New City: ");
        ps.setString(1, sc.next());

        int check = ps.executeUpdate();

        if (check > 0) {
            System.out.println("UPDATE: Data updated successfully\n");
        } else {
            System.out.println("UPDATE: No record found\n");
        }

        con.close();
    }

    // --------------------------------------------------
    // 4. DELETE OPERATION - DELETE STUDENT BY ID
    // --------------------------------------------------
    public void deleteData() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, password);

        PreparedStatement ps = con.prepareStatement("DELETE FROM Student WHERE id=?");

        System.out.print("Enter Student ID to Delete: ");
        ps.setInt(1, sc.nextInt());

        int check = ps.executeUpdate();

        if (check > 0) {
            System.out.println("DELETE: Data deleted successfully");
        } else {
            System.out.println("DELETE: No record found");
        }

        con.close();
    }
}
