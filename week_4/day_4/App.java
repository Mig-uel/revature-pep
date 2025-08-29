package week_4.day_4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
  // database URL + credentials
  String url = "jdbc:mysql://localhost:3306/example";
  String username = "root";
  String password = "pass";

  // method to addNote to database
  public Note addNote(String content, String priority) {
    // step 1  & 5: open connection to db and close when done
    // try-with-resources: this will auto-close the connection when done
    try (Connection conn = DriverManager.getConnection(url, username, password)) {
      // step 2: create your statement
      PreparedStatement ps = conn.prepareStatement("INSERT INTO notes(content, priority) VALUES (?, ?)");

      // assign any parameters their values
      ps.setString(1, content); // set content parameter
      ps.setString(2, priority); // set priority parameter

      // step 3: execute statement
      ps.executeUpdate();

      // get the generated keys (ids): this will return the id of the newly inserted note
      ResultSet rs = ps.getGeneratedKeys(); // returns a ResultSet

      // step 4: process results:
      while (rs.next()) { // iterate through the ResultSet
        long resultId = rs.getLong(1); // get the id (first column)

        // ... and return a Note with the generated id in its state, as
        // well as the other values
        return new Note(resultId, content, priority);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return null; // return null if something went wrong
  }
  
  public Note getNoteById(long id) {
    // step 1 & 5: open connection to db and close when done
    try (Connection conn = DriverManager.getConnection(url, username, password)) {
      // step 2: create your statement
      PreparedStatement ps = conn.prepareStatement("SELECT * FROM notes WHERE id = ?");

      // assign any parameters their value
      ps.setLong(1, id);

      // step 3: execute the statement
      ResultSet rs = ps.executeQuery();

      // step 4: process results:
      while (rs.next()) {
        // get the values from their respective columns...
        long resultId = rs.getLong("id");
        String content = rs.getString("content");
        String priority = rs.getString("priority");

        // ...and returns a Note with hose values as its state
        return new Note(resultId, content, priority);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return null;
  }
}
