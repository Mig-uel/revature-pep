package week_4.day_4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
  /**
   * Credentials for the database.
   * These are typically store in a separate class, config file, or
   * as an environment variable.
   */
  String db_url = "<your_db_url>";
  String db_user = "<your_db_user>";
  String db_pass = "<your_db_pass>";

  public Employee selectEmployeeByName(String name) {
    // open and close connection
    try (Connection conn = DriverManager.getConnection(db_url, db_user, db_pass)) {
      // query to execute
      String query = "SELECT * FROM employees WHERE empName = ?";

      PreparedStatement ps = conn.prepareStatement(query); // prepare the query
      ps.setString(1, name); // set placeholder (?) for our query

      ResultSet rs = ps.executeQuery(); // execute the query

      // if we found a matching employee
      if (rs.next()) {
        // Create an Employee populated with data from the ResultSet
        // Here we use each column's name, but we could also use their index
        return new Employee(
            rs.getInt("empId"),
            rs.getString("empName"),
            rs.getString("empTitle"));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return null;
  }

  // Retrieve all employees
  public List<Employee> selectAllEmployees() {
    ArrayList<Employee> eList = new ArrayList<Employee>(); // list to hold employees

    // open and close connection
    try (Connection conn = DriverManager.getConnection(db_url, db_user, db_pass)) {
      String query = "SELECT * FROM employees"; // query to execute
      Statement st = conn.createStatement(); // create a statement

      ResultSet rs = st.executeQuery(query); // execute the query

      // iterate through the ResultSet
      while (rs.next()) {
        // add a new Employee to the list for each row in the ResultSet
        eList.add(new Employee(
          rs.getInt(1),
          rs.getString(2),
          rs.getString(3)
        ));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return eList;
  }
}