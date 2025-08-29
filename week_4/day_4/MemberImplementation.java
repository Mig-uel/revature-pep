package week_4.day_4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class MemberImplementation implements MemberDAO{
  @Override
  public Member createMember(Member newMember) {
    /**
     * Here, we use a try-with-resources statement, which will close the
     * connection automatically. This is useful if we want to create
     * a new connection every time we query the database.
     * 
     * Another strategy would be to create a static connection
     * that is not closed.
     */
    try (Connection conn = DriverManager.getConnection("", "", "")) {
      String sql = "INSERT INTO members (email, password, full_name, experience_months, registration_date) VALUES (?,?,?,?,?)";

      // The prepareStatement method will allow for setting the values
      // of the placeholders ('?')
      PreparedStatement ps = conn.prepareStatement(sql);

      /**
       * Here, we set the values of the placeholders ('?')
       * The first argument is the index of the placeholder, starting at 1
       * The second argument is the value of the placeholder
       * Although this example sets the values in order, 1 - 5, we can
       * set them in any order.
       */
      ps.setString(1, newMember.getEmail());
      ps.setString(2, newMember.getPassword());
      ps.setString(3, newMember.getFull_name());
      ps.setInt(4, newMember.getExperience_months());
      ps.setDate(5, newMember.getRegistration_date());

      // The executeUpdate method runs the query on the database and returns
      // an int equal to the number of records affected.
      int checkInsert = ps.executeUpdate();

      // Here, we check if the record was inserted or not.
      if (checkInsert == 0) {
        // This error communicates with the rest of our code that the insertion
        // was not successful
        throw new SQLException("Member was not entered into database.");
      }

      // If the insertion was successful, we will return the newMember
      return newMember;
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return null;
  }
  
  @Override
  public List<Member> findAllMembers() {
    try (Connection conn = DriverManager.getConnection("", "", "")) {
      List<Member> members = new LinkedList<Member>();

      // the query to execute
      String sql = "SELECT * FROM members";

      /*
       * Here, we use a simple statement instead of a prepared statement.
       * We have no fear of SQL injection because the query does not
       * take input from user.
       */
      Statement st = conn.createStatement();

      /*
       * The executeQuery will return a ResultSet with data from the 
       * database. 
       */
      ResultSet rs = st.executeQuery(sql);

      while (rs.next()) {
        // For each record in the result set, we will create a Member
        // object and add it to a list which we will return.
        Member member = new Member();

        /*
         * We are using the setter methods on the member object to set values
         * to instance fields.
         * Using the ResultSet, we can get the value of each column.
         * Note that the column index can be used as well.
         */
        member.setEmail(rs.getString("email"));
        member.setFull_name(rs.getString("full_name"));
        member.setExperience_months(rs.getInt("experience_months"));
        member.setRegistration_date(rs.getDate("registration_date"));
        member.setPassword(rs.getString("password"));

        // Add the newly created member to the list
        members.add(member);
      }

      return members;
    } catch (SQLException e) {
      e.printStackTrace();
    }

    // Return null if no records are found, or if something went wrong
    return null;
  }

  @Override
  public Member findMemberByEmail(String email) {
    try (Connection conn = DriverManager.getConnection("", "", "")) {
      String sql = "SELECT * FROM members WHERE email = ?";

      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, email);

      ResultSet rs = ps.executeQuery();

      // Check is there is a result. If it next() returns false, no record was found
      if (!rs.next()) {
        throw new SQLException("User not found. Try again.");
      }
      
      // Create member object
      Member member = new Member();

      // Here, we use the column index instead of the column name.
      // This indexing starts at 1 instead of 0.
      member.setEmail(rs.getString(1)); // Column 1 is email
      member.setPassword(rs.getString(2)); // Column 2 is password
      member.setFull_name(rs.getString(3)); // Column 3 is full_name
      member.setExperience_months(rs.getInt(4)); // Column 4 is experience_months
      member.setRegistration_date(rs.getDate(5)); // Column 5 is registration_date

      // Return populated object from database
      return member;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
    return null;
  }
  
  @Override
  public boolean updateMember(Member updatedMember) {
    try (Connection conn = DriverManager.getConnection("", "", "")) {
      String sql = "UPDATE members SET password = ?, full_name = ?, experience_months = ?, registration_date = ? WHERE email = ?";

      PreparedStatement ps = conn.prepareStatement(sql);

      ps.setString(1, updatedMember.getPassword());
      ps.setString(2, updatedMember.getFull_name());
      ps.setInt(3, updatedMember.getExperience_months());
      ps.setDate(4, updatedMember.getRegistration_date());

      /*
       * Remember that we set the value of the placeholders for the
       * PreparedStatement query.
       * Here, we are setting the email for the search condition
       * 'WHERE email = ?'
       */
      ps.setString(5, updatedMember.getEmail());

      int checkInsert = ps.executeUpdate();

      if (checkInsert == 0)
        throw new SQLException("Member was not updated.");

      // If member was updated, return true
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public boolean deleteMemberById(String email) {
    try (Connection conn = DriverManager.getConnection("", "", "")) {
      String sql = "DELETE FROM members WHERE email = ?";

      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, email);

      int checkDelete = ps.executeUpdate();

      if (checkDelete == 0)
        throw new SQLException("Member was not deleted.");

      // If deletion successful, return true
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;  
    }
  }
}
