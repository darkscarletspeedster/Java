package Test7JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.Result;

public class JDBCDemo {
    final private static String USERNAME = "Kshitij";
    final private static String PASSWORD = "Kshwolf12@";

    public static void main(String[] args) {
        // url for connnection
        String url = "jdbc:mysql://127.0.0.1:3306/practicedatabase";
        try {
            // establishing a connnection
            Connection conn = DriverManager.getConnection(url, USERNAME, PASSWORD);

            // create a statement object to send to the database
            Statement statement = conn.createStatement();

            // executing the statement
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Employee");

            int totalSalary = 0;

            // iterating through result
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String dept = resultSet.getString("dept");
                int salary = resultSet.getInt("salary");

                System.out.println(id + " " + name
                    + " " + dept + " " + salary);

                totalSalary += salary;
            }

            System.out.println("Total Salary: " + totalSalary);

            // executeUdpdate() is used for DML queries like insert, delete and update
            // deleting a record
            int id = 600;
            int deletedRows = statement.executeUpdate("DELETE FROM Employee WHERE id = " + 600);
            System.out.println("Deleted " + deletedRows + " rows!!!");

            // inserting a record
            String name = "Alexa";
            String dept = "Legal";
            int salary = 5000;
            int insertRows = statement.executeUpdate("INSERT INTO Employee VALUES("
                + id + ", '"
                + name + "', '"
                + dept + "', "
                + salary + ")");
            System.out.println("Inserted " + insertRows + " rows!!!!");

            // updating a record
            int updatedSalary = 6000;
            // we can decide to avoid taking in return value
            /* int updatedRows =  */statement.executeUpdate("UPDATE Employee SET salary=" + updatedSalary + " WHERE id=" + id);
            System.out.println("Rows Updated "/*  + updatedRows */ + " rows!!!!");

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}