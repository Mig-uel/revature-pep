package week_5.day_1.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
  /**
   * There are two class variables included within our ConnectionFactory
   * utility class.
   * 
   * First, the single connectionFactory object itself. This will be passed
   * along to any layer that will make requests to the database.
   * 
   * Second, the props object of the Properties class that will allow us
   * to access our db.properties and obtain our sensitive information.
   */
  private static final ConnectionFactory connectionFactory = new ConnectionFactory(); // Singleton instance
  private Properties props = new Properties(); // To hold db.properties info

  /**
   * We include a private constructor here to ensure that there is only
   * one instance that can be created ever. Along with this, during the
   * construction of our ConnectionFactory object, we make sure we can load
   * in our db.properties file, handling any potential exceptions thrown.
   */
  private ConnectionFactory() { // Private constructor for singleton
    try {
      props.load(new FileReader("src/main/resources/db.properties")); // Load properties file
    } catch (IOException e) {
      // Handle potential IOException
      e.printStackTrace();
    }
  }

  /**
   * Next, we must also include a static method to obtain the single instance
   * of our connectionFactory, allowing it to be accessible within other
   * classes. This way we can provide the connectionFactory which can
   * invoke the getConnection() method when we need to make requests to
   * our database.
   */
  public static ConnectionFactory getConnectionFactory() { // Static method to get the singleton instance
    return connectionFactory; // Return the singleton instance
  }

  /**
   * This method provides the ability for classes to utilize the
   * getConnection() method from our Utility class and establish a
   * connection with out database that be used to execute SQL
   * statements through the Statement or PreparedStatement interfaces.
   * This will also check for any SQLException in case the information
   * provided in the db.properties is incorrect.
   */
  public Connection getConnection() { // Method to establish and return a database connection
    try {
      return DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"),
          props.getProperty("password"));
    } catch (SQLException e) {
      e.printStackTrace();
      return null;  
    }
  }
}