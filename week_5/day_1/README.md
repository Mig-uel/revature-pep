# JDBC/SQL Intermediate - Day 1

## Simple and Prepared Statements

In Java, `Statement` and `PreparedStatement` are two types of objects used for executing SQL queries and statements against a database. They are part of the JDBC (Java Database Connectivity) API, which provides a standard way to interact with relational databases.

#### `Statement`

A `Statement` object allows you to execute SQL queries directly, while a `PreparedStatement` object provides a precompiled SQL statement that can be executed multiple times with different parameters. Both can be used for executing SQL queries and updates, but `PreparedStatement` is generally preferred for its performance and security benefits.

Once we have the `Connection` object, we can write our SQL and execute it:

```java
Statement stmt = conn.createStatement();
String sql = "SELECT * FROM employees";
ResultSet rs = stmt.executeQuery(sql);
```

#### `PreparedStatement`

Alternatively, a `PreparedStatement` can be used. This interface gives us the flexibility of specifying parameters with the `?` placeholder. It also protects against SQL injection attacks.

```java
String sql = "SELECT * FROM employees WHERE age > ? AND location = ?";
PreparedStatement ps = conn.prepareStatement(sql);
ps.setInt(1,40);
ps.setString(2,"New York");
ResultSet rs = ps.executeQuery();
```

The `Statement` and `PreparedStatement` interfaces also have additional methods for sending SQL, including:

- `execute()`: Used for executing any SQL statement. It returns a boolean indicating whether the result is a `ResultSet` (true) or an update count (false).
- `executeUpdate()`: Used for executing SQL statements that modify the database (DML) (e.g., `INSERT`, `UPDATE`, `DELETE`). It returns an integer representing the number of rows affected by the operation.
- `executeQuery()`: Used for executing SQL `SELECT` statements (DQL). It returns a `ResultSet` object containing the data retrieved from the database.

In addition, the `CallableStatement` interface, created by calling the `prepareCall()` method on a `Connection` object, is used for executing stored procedures in the database.

A stored procedure is a precompiled collection of SQL statements and optional control-of-flow statements that are stored under a name and processed as a unit. Stored procedures can accept input parameters, return output parameters, and return result sets.

A `CallableStatement` can return one or more `ResultSet` objects, as well as output parameters. It provides methods for setting input parameters and registering output parameters.

### Real World Application

`Statement` and `PreparedStatement` are widely used in Java applications for various database related tasks, including:

- **Data Retrieval**: Fetching data from the database using `SELECT` queries.
- **Data Manipulation**: Inserting, updating, or deleting records in the database.
- **Batch Processing**: Executing multiple SQL statements in a single batch for improved performance.
- **Dynamic Queries**: Building SQL queries dynamically at runtime using `PreparedStatement`.

### Implementation

To create and execute a statement, we follow these steps:

1. Establish a connection to the database using the `DriverManager.getConnection()` method.
2. Create a `String` object to represent the desired query you want to execute.

- For `PreparedStatement`, the query should include '?' in place of values to be set later.

3. Create a `Statement` or `PreparedStatement` object using the `Connection` object (call the `createStatement()` or `prepareStatement()` method).

- For `PreparedStatement`, set the values for the placeholders using the appropriate setter methods (e.g., `setInt()`, `setString()`, etc.).

4. Execute the query using the appropriate method (`executeQuery()`, `executeUpdate()`, or `execute()`).

As a prerequisite, you should have a database established. For clarity, the following examples will assume an established database schema as follows:

```sql
CREATE SCHEMA JDBCDemo;

CREATE TABLE JDBCDemo.EMPLOYEE (
  ID INT PRIMARY KEY,
  FIRST_NAME VARCHAR(50) NOT NULL,
  LAST_NAME VARCHAR(50) NOT NULL,
  STAT_CD TINYINT NOT NULL DEFAULT 0
);
```

Let's implement the above steps in code.

#### Step 1: Establish a Connection

```java
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDemo", "username", "password");
```

#### Step 2: Create a SQL Query

```java
String sql = "INSERT INTO EMPLOYEE (ID, FIRST_NAME, LAST_NAME, STAT_CD) VALUES (?, ?, ?, ?)";
```

#### Create Your Statement

Create a `PreparedStatement` object using the `Connection` object:

```java
PreparedStatement ps = conn.prepareStatement(sql);
```

Set values for the `PreparedStatement:

```java
ps.setInt(1, 87); // Insert the value 87 into the first placeholder
ps.setString(2, "Lokesh"); // Insert the value "Lokesh" into the second placeholder
ps.setString(3, "Gupta"); // Insert the value "Gupta" into the third placeholder
ps.setInt(4, 5); // Insert the value 5 into the fourth placeholder
```

For these setter methods, the first argument is the index of the placeholder (starting from 1), and the second argument is the value to be set.

#### Step 4: Execute the Query

Finally, execute the query using the `executeUpdate()` method:

```java
int rowsAffected = ps.executeUpdate();
```

#### Complete Code Example

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PreparedStatementDemo
{
  public static void main(String[] args)
  {
    Connection connection = null;
    PreparedStatement pstmt = null;
    String sql = "INSERT INTO EMPLOYEE (ID,FIRST_NAME,LAST_NAME,STAT_CD) VALUES (?,?,?,?)";
    try
    {
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDemo", "root", "password");

      pstmt = connection.prepareStatement(sql);
      pstmt.setInt(1, 87);
      pstmt.setString(2, "Lokesh");
      pstmt.setString(3, "Gupta");
      pstmt.setInt(4, 5);
      int affectedRows = pstmt.executeUpdate();
      System.out.println(affectedRows + " row(s) affected !!");
    }
    catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        pstmt.close();
        connection.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
```

## Reading from a Properties File

#### JDBC Properties Files

When making a JDBC connection to a database, you may have noticed the code typically looks like this:

```java
DriverManager.getConnection(URL, USERNAME, PASSWORD);
```

But hardcoding the URL, username, and password in your code is not a good practice. To solve this problem, developers began to use properties files. Instead, you can store these values in a properties file and read them at runtime.

We need to implement the following steps to use a properties files to store our credentials:

- Create a properties file (e.g., `db.properties`) that contains key-value pairs, where the values are the database connection details.
- In our data access class, we can extract the credentials from the properties file using a `Properties` object and use them to establish the database connection.

To have our credential be even more secure, we can use our system's environment variables to store sensitive information like database passwords and have our properties file reference those environment variables. This will ensure that the credentials are not hardcoded in the source code.

We need to implement the following steps to use environment variables in our properties file:

- Create environment variables that contain the information our application will need to connect to the database (e.g., `DB_URL`, `DB_USERNAME`, `DB_PASSWORD`).
- Create a properties file that contain key-value pairs, where the values reference the environment variables (e.g., `DB_URL=${env:DB_URL}`).
- In our data access class, we can extract the credentials from the properties file using a `Properties` object and use them to establish the database connection.

### Real World Application

Knowing how to use a properties file for storing database credentials is important for several reasons:

- **Security**: Storing credentials in a properties file (especially when combined with environment variables) helps to keep sensitive information out of the source code, reducing the risk of accidental exposure. It prevents credentials from being hardcoded in the application, making it easier to change them without modifying the code.
- **Ease of Maintenance**: Using a properties file makes it easier to manage and update database credentials. Instead of searching through the codebase to find and change hardcoded values, developers can simply update the properties file. This is especially useful in large applications or when working with multiple environments (e.g., development, testing, production).
- **Flexibility**: Properties files allow for easy configuration changes without requiring code changes. This means that different configurations can be used for different environments (e.g., using a different database for testing vs. production) simply by changing the properties file.
- **Separation of Concerns**: Using a properties file helps to separate configuration from code. This makes the codebase cleaner and more focused on business logic, while configuration details are kept in a dedicated location.

Overall, knowing how to use a properties file for storing database credentials is crucial in application development for ensuring security, maintainability, and flexibility.

### Implementation

The following is an example of how we can use a properties file without using environment variables.

#### Step 1: Create a `.properties` File

A properties file stores information as key-value pairs, each on its own line, and has a `.properties` file extension. For instance, you might have the following content in a properties file named `application.properties`:

```
URL=jdbc:postgresql://localhost:5432/mydb
CONNECTION_USERNAME=user
CONNECTION_PASSWORD=password
```

#### Step 2: Extract Credentials from the Properties File

In our data access class, we can extract the credentials from the properties file using the `Properties` class and `FileInputStream` class to read the file.

```java
// create a stream from properties file so we can read from it
FileInputStream fileStream = new FileInputStream("path/to/application.properties");

// create a Properties object and get the information from it
Properties props = new Properties();
props.load(fileStream);

// extract values from the Properties object
String URL = props.getProperty("URL");
String CONNECTION_USERNAME = props.getProperty("CONNECTION_USERNAME");
String CONNECTION_PASSWORD = props.getProperty("CONNECTION_PASSWORD");
```

Great! Now we have successfully extracted the database connection details from the properties file. But, we are still saving our information as plain text.

**Aside**: If you are using this method to read properties for a web application that will be deployed on a server, you may need to use a different approach. When reading from a file, if you use a relative path, it will be relative to the working directory of the server, which may not be where your properties file is located. This can be unpredictable when it comes to servers, so instead we can use this method in those instances.

You can use the `ServletContext` to read the properties file as a resource stream.

```java
Properties props = new Properties();

try {
  InputStream dbProps = getServletContext().getResourceAsStream("/WEB-INF/application.properties");
  props.load(dbProps);
} catch (Exception e) {
  e.printStackTrace();
}
```

---

The following is an example of how we can use a properties file and environment variables to store our credentials.

#### Step 1: Create Your Environment Variables

We can create environment variables in different ways depending on the operating system you are using.

For Windows:

1. Open the Start Menu and search for "Environment Variables".
2. Click on "Edit the system environment variables".
3. In the System Properties window, click on the "Environment Variables" button.
4. In the Environment Variables window, you can add new user or system variables.

For macOS/Linux:

1. Open a terminal window.
2. You can set an environment variable using the `export` command. For example:
   ```bash
   export DB_URL=jdbc:postgresql://localhost:5432/mydb
   export DB_USERNAME=user
   export DB_PASSWORD=password
   ```
3. To make these changes permanent, you can add the export commands to your shell's configuration file (e.g., `.bashrc`, `.bash_profile`, or `.zshrc`).

We will name our environment variables as follows:

- `url`
- `connectionUsername`
- `connectionPassword`

#### Step 2: Reference Environment Variables in the Properties File

We can reference the environment variables in the properties file using the `${}` syntax. For example:

```
URL=${url}
CONNECTION_USERNAME=${connectionUsername}
CONNECTION_PASSWORD=${connectionPassword}
```

When the application starts, it will replace the placeholders with the actual values of the environment variables.

#### Step 3: Extract Credentials from the Properties File

Then, in our Java class, we will use our properties file and the `System.getenv()` method to extract the values of the environment variables.

For our `application.properties` file, we will instead store the names of the environment variables as the property values.

```
URL=url
CONNECTION_USERNAME=connectionUsername
CONNECTION_PASSWORD=connectionPassword
```

```java
// create a stream from properties file so we can read from it
FileInputStream fileStream = new FileInputStream("path/to/application.properties");

// create a Properties object and get the information from it
Properties props = new Properties();
props.load(fileStream);

// extract values from the Properties object and get the environment variable values
String url = props.getProperty("URL"); // url
String username = props.getProperty("CONNECTION_USERNAME"); // connectionUsername
String password = props.getProperty("CONNECTION_PASSWORD"); // connectionPassword

// now that we have the names of the environment variables, we can get their values
String URL = System.getenv(url);
String CONNECTION_USERNAME = System.getenv(username);
String CONNECTION_PASSWORD = System.getenv(password);
```

And there you have it! We have successfully extracted the database connection details from a properties file that references environment variables, and we are not storing any sensitive information in our source code or properties file.

## Setting Up the Utility Class

Within our Java application, we can leverage a Utility class to handle the distribution of `connectionFactory` objects to other classes that require connections and requests to our database. This approach promotes code reusability and simplifies the management of database connections.

- This allows for ease of use when establishing connections to the database by providing a centralized method for obtaining connections.
- Our `db.properties` file will be used to store our database connection details, which will be read by the Utility class to establish connections.
- This produces a single instance of the Utility class, also known as the Singleton pattern, which ensures that only one instance of the class is created and used throughout the application.

### Real World Application

Having a connection Utility class in a Java application offers several benefits:

- **Centralized Configuration**: A connection Utility class provides a centralized location for managing database connection settings, such as the database URL, username, and password. This makes it easier to update and maintain these settings in one place rather than scattering them throughout the codebase.
- **Abstraction of Connection Logic**: The Utility class abstracts the connection logic, allowing other parts of the application to obtain connections without needing to know the details of how they are created or managed. This simplifies the code and reduces the risk of errors. This abstraction shields the rest of the application from the complexities of connection management, making the codebase cleaner and more maintainable.
- **Facilitation of Testing**: The Utility class can be easily mocked or stubbed during unit testing, allowing for more straightforward testing of components that depend on database connections. This leads to more reliable tests and a better overall development experience.
- **Security**: By centralizing the connection logic and credentials management, the Utility class can help enforce security best practices, such as using secure connections and managing sensitive information more effectively. This reduces the risk of exposing sensitive data throughout the application.

Overall, a connection Utility provides a structured and efficient way to manage database connections in a Java application, leading to improved maintainability, testability, and security.

### Implementation

To set up a Utility class for managing database connections, we can follow these steps:

First, we must establish a `db.properties` file inside our `src/main/resources` directory. This file will contain our database connection details.

```
url=postgresql://localhost:5432/postgres
username=postgresql
password=password
```

Note: It is important to include this file in the `.gitignore` file to prevent it from being pushed to a public repository, as it contains sensitive information.

Next, we will create our Utility class, which we will name `ConnectionFactory`. This class will be responsible for reading the properties file and providing a method to obtain database connections.

```java
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
```

The code above defines a `ConnectionFactory` class that follows the Singleton design pattern to manage database connections. It loads database connection properties from a `db.properties` file and provides a method to obtain a `Connection` object for interacting with the database. This ensures that all database interactions are centralized and managed through a single instance of the `ConnectionFactory`.
