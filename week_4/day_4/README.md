# SQL Basic and JDBC - Day 4

## Intro to JDBC

JDBC (Java Database Connectivity) is an API that enables Java applications to interact with databases. It provides methods for querying and updating data in a database. It is relatively low-level API used to write Java code that interact with relational databases via SQL (Structured Query Language).

#### Steps for Using JDBC

1. **Obtain a JDBC Driver**: A JDBC driver is a software component that enables Java applications to interact with a specific database. Different databases require different JDBC drivers.
2. **Establish a Connection**: Use the `DriverManager` class to establish a connection to the database using the JDBC URL, username, and password.
3. **Create a Statement**: Once the connection is established, create a `Statement` object using the `Connection` object. This `Statement` object will be used to execute SQL queries against the database.

- You can use either `Statement`, `PreparedStatement`, or `CallableStatement` depending on your needs.

4. **Execute SQL Queries**: Use the `Statement` object to execute SQL queries against the database. You can execute different types of SQL statements such as `SELECT`, `INSERT`, `UPDATE`, and `DELETE`.
5. **Process the Results**: If the SQL query returns a result set (e.g., a `SELECT` statement), you can process the results using the `ResultSet` object returned by the `Statement` object. You can iterate through the result set to retrieve the data.
6. **Close the Connection**: After you are done with the database operations, it is important to close the connection to free up resources. You can use the `close()` method of the `Connection` object to close the connection.

#### Database JDBC

Because JDBC is a Java language API, it is database agnostic. However, each database vendor provides its own JDBC driver that implements the JDBC API for that specific database. Here are some common databases and their corresponding JDBC drivers:

- MySQL: `mysql-connector-java`
- PostgreSQL: `postgresql`
- Oracle: `ojdbc8`
- SQL Server: `mssql-jdbc`

Basically, it uses database drivers which implement the interfaces defined in the JDBC API for the given database. Many JDBC drivers are available through Maven's central repository and can be added as a dependency in the `pom.xml` file.

#### Creating a Connection

We can use the `DriverManager` class to get a `Connection` to the database by passing it the database URL, username, and password.

Generally these parameters should be stored in an external configuration file and not hardcoded in the source code. The configuration file can be loaded dynamically at runtime.

```java
try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
  // more code to interact with the database
} catch (SQLException e) {
  e.printStackTrace();
}
```

Alternatively, the `DataSource` interface could be used to make connections.

It is always a good idea to close your resources when you are done with them. The try-with-resources statement is a good way to ensure that resources are closed automatically.

#### Autocommit Mode

By default, when a connection is created, it is in autocommit mode. This means that every individual SQL statement is treated as a transaction and is automatically committed to the database when it is executed. If you want to manage transactions manually, you can disable autocommit mode by calling the `setAutoCommit(false)` method on the `Connection` object.

```java
try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
  conn.setAutoCommit(false);
  // more code to interact with the database
} catch (SQLException e) {
  e.printStackTrace();
}
```

In this example, autocommit mode is disabled, and you will need to call `commit()` or `rollback()` on the `Connection` object to manage transactions manually.

#### JDBC String

The database URL is an address pointing to the database to be used, also known as the JDBC String. The format of the JDBC URL varies depending on the database being used. Here are some examples of JDBC URLs for different databases:

| RDBMS      | JDBC Driver                                    | URL Format                                               |
| ---------- | ---------------------------------------------- | -------------------------------------------------------- |
| MySQL      | `com.mysql.jdbc.Driver`                        | `jdbc:mysql://<host>:<port>/<database>`                  |
| Oracle     | `oracle.jdbc.driver.OracleDriver`              | `jdbc:oracle:thin:@<host>:<port>:<database>`             |
| SQL Server | `com.microsoft.sqlserver.jdbc.SQLServerDriver` | `jdbc:sqlserver://<host>:<port>;databaseName=<database>` |
| PostgreSQL | `org.postgresql.Driver`                        | `jdbc:postgresql://<host>:<port>/<database>`             |

#### Executing SQL

Once we have the `Connection` object, we can write our SQL and execute it:

```java
Statement stmt = conn.createStatement();
String sql = "SELECT * FROM employees";
ResultSet rs = stmt.executeQuery(sql);
```

Alternatively, a `PreparedStatement` can be used to execute parameterized queries. This interface gives us the flexibility of specifying parameters at runtime, which helps prevent SQL injection attacks.

```java
String sql = "SELECT * FROM employees WHERE id = ?";
PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setInt(1, employeeId);
ResultSet rs = pstmt.executeQuery();
```

The `Statement` and `PreparedStatement` also have additional method for sending SQL, including:

- `.execute()`: Executes a SQL statement that may return multiple results.
- `.executeUpdate()`: Executes a SQL statement that changes the database (e.g., INSERT, UPDATE, DELETE) and returns the number of affected rows.
- `.executeQuery()`: Executes a SQL SELECT statement and returns the result set.

#### Retrieving Results

Results from an SQL query are returned as a `ResultSet`, which can be iterated over to extract the data:

```java
List<Employee> employees = new ArrayList<>();

while (rs.next()) {
  int id = rs.getInt("id");
  String name = rs.getString("name");
  employees.add(new Employee(id, name));
}
```

Further details about each of the steps for using JDBC are given in other lessons.

### Implementation

Java applications that need to communicate with the database have to be programmed using the JDBC API. A JDBC API that supports a data source, such as Oracle or SQL Server, has to be added in Java applications. This JDBC driver intelligently communicates with the respective data source. Below is an example of a small application that uses the JDBC API to perform some operations.

#### Creating a Simple JDBC Application

First, we will add in a Database Driver. We can search [Maven Central](https://central.search.maven.org/) for **MySQL** to find the appropriate JDBC driver dependency. For example, we might find a dependency like this:

```xml
<dependency>
  <groupId>mysql</groupId>
  <artifactId>mysql-connector-java</artifactId>
  <version>8.0.26</version>
</dependency>
```

We would then add this dependency to our `pom.xml` file if we are using Maven.

Now we can communicate with a MySQL database using JDBC. Let's create a class that connects to and uses a database. The database is named `example` and contains a table named `example_table` that has an `id` column of type `INT` and a column `value` of type `VARCHAR`.

Below is the class that uses the database:

```java
import java.sql.*;

public class JDBCDemo {
  public static void main(String args[] throws SQLException) {
    // database url + credentials
    String url = "jdbc:mysql://localhost:3306/example";
    String username = "root";
    String password = "pass";
    // obtain a connection using credentials
    Connection conn = DriverManager.getConnection(url, username, password);

    // create a Statement object
    Statement stmt = conn.createStatement();

    // Execute the query using the Statement object
    String query = "INSERT INTO example_table VALUES (1, 'Hello, World!')";
    int rowsAffected = stmt.executeUpdate(query);

    System.out.println("Rows affected: " + rowsAffected);

    // Close the resources
    stmt.close();
    conn.close();
  }
}
```

The above example demonstrates how to connect to a MySQL database, create a `Statement` object, execute an `INSERT` SQL statement, and close the resources.

## JDBC Interfaces Classes

The JDBC classes and interfaces are located in the `java.sql` and `javax.sql` packages. There are several key classes and interfaces commonly encountered when writing JDBC code:

- `DriverManager` class: Manages a list of database drivers and establishes a connection to a database.
  - Has the `getConnection(String url, String user, String password)` method to establish a connection.
- `DataSource` interface: Provides a more flexible way to obtain database connections, often used in enterprise applications (an alternative to `DriverManager`).
  - Implementing classes are provided by the vendors, not part of the standard library.
- `Connection` interface: Represents a connection to a specific database.
  - Can be used to create statements with the following methods:
    - `createStatement()`: Creates a `Statement` object for sending SQL statements to the database.
    - `prepareStatement(String sql)`: Creates a `PreparedStatement` object for sending parameterized SQL statements to the database.
    - `prepareCall(String sql)`: Creates a `CallableStatement` object for executing stored procedures.
  - Can be used to manage database transactions with the following methods:
    - `setAutoCommit(boolean autoCommit)`: Sets the auto-commit mode for the connection.
    - `rollback(Savepoint savepoint)`: Rolls back the current transaction to the specified savepoint.
    - `commit()`: Commits the current transaction.
    - `setSavepoint(String name)`: Creates a savepoint in the current transaction.
  - Needs to be closed after use with the `close()` method and can be checked if
    it is closed with the `isClosed()` method.
- `SQLException` class: Provides information on a database access error or other errors. A general exception thrown when something goes wrong while accessing the database.
- `Statement` interface: Represents a SQL statement to be executed against a database. It is used to send SQL queries to the database and retrieve results.
  - Defines a constant, `RETURN_GENERATED_KEYS`, which can be used to indicate that auto-generated keys should be returned when executing an `INSERT` statement.
    - Basically, if you want to retrieve the auto-generated keys (like primary key values) after executing an `INSERT` statement, you can use this constant when creating the `Statement` object.
  - Has the `execute(String sql, int autoGeneratedKeys)` method, which can be used to execute an `INSERT` statement and optionally takes a second parameter to indicate whether to return auto-generated keys.
  - Has the `executeQuery(String sql)` method, which is used to execute a SQL `SELECT` statement and returns a `ResultSet` object containing the results of the query.
  - Has the `executeUpdate(String sql)` method, which is used to execute SQL statements that modify the database (e.g., `INSERT`, `UPDATE`, `DELETE`) and returns the number of affected rows.
- `PreparedStatement` interface: Extends the `Statement` interface and represents a precompiled SQL statement that can be executed multiple times with different parameters. It is used to send parameterized SQL queries to the database.
  - Has the same methods as `Statement` for executing SQL statements, but also includes methods for setting parameters in the SQL statement, such as:
    - `setInt(int parameterIndex, int value)`: Sets an integer parameter in the SQL statement.
    - `setString(int parameterIndex, String value)`: Sets a string parameter in the SQL statement.
    - `setDouble(int parameterIndex, double value)`: Sets a double parameter in the SQL statement.
    - And many more for different data types.
- `CallableStatement` interface: Extends the `PreparedStatement` interface and represents a SQL stored procedure that can be executed in the database. It is used to call stored procedures and retrieve results.
  - A stored procedure is a precompiled collection of one or more SQL statements that can be executed as a single unit. It can accept input parameters, return output parameters, and provide a way to encapsulate complex business logic on the database server.
  - Has methods that interact with stored procedures, such as:
    - `registerOutParameter(int parameterIndex, int sqlType)`: Registers an output parameter in the stored procedure.
    - `getInt(int parameterIndex)`: Retrieves the value of an integer output parameter.
    - `getString(int parameterIndex)`: Retrieves the value of a string output parameter.
    - And many more for different data types.
- `ResultSet` interface: Represents the result set of a SQL query. It is used to retrieve data from the database after executing a `SELECT` statement.
  - Has methods for navigating and retrieving data from the result set, such as:
    - `next()`: Moves the cursor to the next row in the result set.
    - `getInt(String columnLabel)`: Retrieves the value of an integer column by its label.
    - `getString(String columnLabel)`: Retrieves the value of a string column by its label.
    - And many more for different data types.

These classes and interfaces form the core of the JDBC API and are essential for interacting with databases in Java applications.

### Real World Application

It's important to understand the JDBC (Java Database Connectivity) API's classes and interfaces for several reasons:

- **Database Operations**: JDBC classes and interfaces enable developers to perform various database operations, such as connecting to a database, executing SQL queries, and retrieving results. Understanding these classes and interfaces is essential for effectively interacting with databases in Java applications.
- **Transaction Management**: JDBC provides support for managing transactions, allowing developers to group multiple SQL statements into a single transaction or atomic units of work. Understanding how to use JDBC classes and interfaces for transaction management is crucial for ensuring data integrity and consistency in applications.
- **Error Handling**: JDBC provides mechanisms for handling database errors and exceptions gracefully. By understanding JDBC's exception handling classes and interfaces, developers can write robust error-handling code to deal with database related issues effectively.
- **Integration with Frameworks**: Many Java frameworks and libraries rely on JDBC for database access. Understanding JDBC classes and interfaces is essential for integrating with these frameworks and leveraging their features for database operations.
- **Security**: JDBC application may be vulnerable to security threats such as SQL injection attacks. Understanding JDBC classes and interfaces is crucial for implementing secure database access practices, such as using prepared statements to prevent SQL injection.

Overall, knowledge of JDBC classes and interfaces is essential for Java developers who work with databases, as it forms the foundation for building robust, scalable, and secure database driven applications.

### Implementation

The example below demonstrates the use of the JDBC API and its classes and interfaces to successfully interface with a relational database.

#### Context

Let's say we have a database with the following `Notes` table already created:

| id  | content                          | priority |
| --- | -------------------------------- | -------- |
| 1   | take out trash                   | high     |
| 2   | tues apt with dentist @ 10am     | medium   |
| 3   | remember to clean out the fridge | low      |
| 4   | call Sammy                       | low      |

In our Java application, we have a `Note` class:

```java
public class Note {
  // fields
  private long id;
  private String content;
  private String priority;

  // constructors, getters, and setters omitted
}
```

#### Processing SQL Statements with JDBC Classes and Interfaces

In general, to process and SQL statement with JDBC, you follow these steps:

- Establish a connection
- Create a statement
- Execute the statement/query
- Process the `ResultSet` object
- Close the resources/connections

With our database and `Note` class in place, let's write a class that defines some database operations where we follow these steps:

```java
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

```

#### Establishing Connections

First, we establish a connection with the data source we want to use. We used the statement `Connection conn = DriverManager.getConnection(url, username, password)` to create a `Connection` object. This object represents a connection to the database.

#### Creating Statements

A `Statement` is an **interface** that represents an SQL statement. You execute `Statement` objects, which generate `ResultSet` objects that represent a table of data returned by a database query. You need a `Connection` object to create a `Statement` object.

Our example created a `PreparedStatement` object, which is a subclass of `Statement`. `PreparedStatement` objects are precompiled and can be executed multiple times with different parameters.

```java
ResultSet rs = stmt.executeQuery(query);
```

and

```java
PreparedStatement ps = connection.prepareStatement("SELECT * FROM notes WHERE id = ?");
```

#### Executing Statements/Queries

To execute a query, call an execute method from the Statement interface.

Our example executed statements with the following code:

```java
ps.executeUpdate();
```

and

```java
ResultSet rs = ps.executeQuery();
```

#### Processing `ResultSet` Objects

You access the data in a `ResultSet` object through a cursor. Note that this cursor is not a database cursor; it is a pointer that points to one row of data in the `ResultSet` object. Initially, the cursor is positioned before the first row. You call the `next()` method to move the cursor to the next row. The `next()` method returns `true` if there is a next row; otherwise, it returns `false`.

In our example, we used the following code to process the `ResultSet` object:

```java
while (rs.next()) {
  // get the values from their respective columns...
  long resultId = rs.getLong("id");
  String content = rs.getString("content");
  String priority = rs.getString("priority");

  // ...and returns a Note with hose values as its state
  return new Note(resultId, content, priority);
}
```

#### Closing Resources/Connections

When you are finished using a `Connection`, `Statement`, or `ResultSet` object, call its `close()` method to release the resources that it holds, regardless whether an `SQLException` is thrown or not. This is typically done in a `finally` block or by using a try-with-resources statement, as shown in the examples above.

The JDBC throws an `SQLException` if a database access error occurs during the interaction with the database.

A `try-with-resources` statement is a try statement that declares one or more resources. A resource is an object that must be closed after the program is finished with it. The `try-with-resources` statement ensures that each resource is closed at the end of the statement. Any object that implements the `AutoCloseable` interface can be used as a resource.

In our code examples, we used the try-with-resources statement to automatically close the `Connection` object when we are done with it:

```java
try (Connection conn = DriverManager.getConnection(url, username, password)) {
  // use the connection
} catch (SQLException e) {
  e.printStackTrace();
}
```

## Result Set

In the JDBC (Java Database Connectivity) library, a `ResultSet` represents the result of a SQL query executed against a database. It is essentially a table of data that is generated by executing a `SELECT` statement.

It provides methods to navigate and access the data returned by the query, such as `next()`, `getString()`, and `getInt()`. `ResultSet` objects are typically created by executing a `Statement` or `PreparedStatement` object.

A `ResultSet` object contains a cursor that can move forward and backward through the result set of data, allowing access to individual rows and columns. With a `ResultSet`, you can retrieve data from `SELECT` queries, view and manipulate the current row, and retrieve metadata about the result set, such as column names and types. `ResultSet` provides a powerful and flexible way to handle query results in Java application.

When a `ResultSet` is first obtained from a query, the cursor is set just before the first row of data. Calling the method `next()` is necessary initially to obtain the first row of data. The `next()` method moves the cursor to the next row and returns `true` if there is a next row; otherwise, it returns `false`. The default `ResultSet` type may only be traversed in one direction, meaning that once you have advanced the cursor using `next()`, you cannot move it back to a previous row.

### Real World Application

`ResultSet` is commonly used in Java applications that interact with databases for a wide range of real-world scenarios, including:

- **Data Retrieval**: `ResultSet` is used to retrieve data from a database by executing `SELECT` queries. The data can then be processed and displayed in the application.
- **Report Generation**: `ResultSet` can be used to generate reports by retrieving data from a database and formatting it for presentation.
- **Data Analysis**: `ResultSet` can be utilized for performing data analysis and statistical calculations on query results. It enables developers to aggregate, summarize, or perform calculations on the retrieved data.
- **Data Validation**: `ResultSet` can be used to validate data against certain criteria or business rules by examining the contents of the result set. It allows developers to traverse the result set and apply custom validation logic.

### Implementation

The following code snipper showcases a simple `Employee` class that is used when retrieving data from our database. This `Employee` model class uses a similar structure and naming conventions to our `employees` table in the database.

```java
// Class to represent an Employee from the employees table
class Employee {
  private int empId;
  private String empName;
  private String empTitle;

  public Employee(int empId, String empName, String empTitle) {
    this.empId = empId;
    this.empName = empName;
    this.empTitle = empTitle;
  }

  // Getters and setters below...
}
```

In the example below, you can see that our Data Access Object (DAO) class, `EmployeeDAO`, creates a connection to the database and executes queries. In each method, a `ResultObject` is returned from the execution of query on the database, and we in turn populate one or more `Employee` object(s), as appropriate.

The method `next()` is used to advance the `ResultSet` cursor and obtain data from the `ResultSet`. Since this method returns a `boolean`, it can be used with an `if` statement (for a single result) or a `while` loop (for multiple results).

```java
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
```

## Data Access Object (DAO)

Data Access Objects (DAOs) are a design pattern that provides an abstract interface to a database or other persistence mechanism. The DAO pattern separates the data access logic from the business logic of an application, allowing for better organization and maintainability of code.

It is a design pattern commonly used in Java applications for managing the interactions between the application logic and the data persistence layer.

DAO's provide an abstraction layer that separates the business logic from the underlying data access mechanism, such as databases or APIs.

Key points:

- Allows data access mechanisms to change independently of the code that uses the data.
- Can provide access to a particular resource without coupling the code to the business logic.
- The interface allows for no direct relation to the data resource access mechanism.
- This is a form of abstraction from OOP (Object Oriented Programming) principles to hide the implementation details of our DAO class.
- Follows a clean and standardized interface for performing CRUD (Create, Read, Update, Delete) operations on data entities.

### Real World Application

In a real-world application, you might have a `UserDAO` class that handles all database operations related to users. This class would provide methods like `getUserById`, `createUser`, `updateUser`, and `deleteUser`. The rest of your application would interact with the `UserDAO` instead of directly using JDBC code, making it easier to change the underlying database implementation if needed.

DAO's are widely used in various types of Java applications including:

- Enterprise applications
  - DAOs are commonly used to manage data access in large-scale enterprise applications, providing a clear separation between business logic and data access code.
- Web Applications
  - In web applications, DAOs are essential for interacting with databases to perform CRUD operations on user data, product information, and other entities. They help abstract the database operations, provide a layer of security, and ensure maintainability of the codebase.

### Implementation

There are two primary steps to applying the DAO design pattern to an application:

- Create a DAO interface with the desired CRUD methods.
- Create subclasses that implement the DAO interface.

#### DAO Interface

The DAO interface defines the contract or API for accessing and manipulating data. It specifies the methods for CRUD operations and any additional operations specific to the data entity.

The DAO design pattern creates a basic interface to allow modularity, for instance, providing different implementations based on SQL systems (MySQL, PostgreSQL, etc.) or even different data sources (databases, files, etc.).

```java
public interface MemberDAO {
  // INSERT
  public Member createMember(Member member);

  // SELECT for all records
  public List<Member> findAllMembers();

  // SELECT for one record
  public Member findMemberByEmail(String email);

  // UPDATE
  public Member updateMember(Member member);

  // DELETE
  public boolean deleteMemberByEmail(String email);
}
```

#### DAO Implementation

The DAO implementation class provides the actual implementation of the methods defined in the DAO interface. It interacts with the underlying data storage mechanism such as a database or an API to perform the required operations.

```java
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
```

## Navigating `ResultSet` Rows

When working with JDBC (Java Database Connectivity) and retrieving data from a database using a `ResultSet`, it is essential to understand how to navigate through the rows of the result set. Navigating the result set rows allows you to access and process individual records returned by a SQL query.

The `ResultSet` provides methods to move the cursor within the result set, allowing for sequential traversal of rows in different directions. By understanding how to navigate the result set, you can effectively retrieve and manipulate data from your database queries.

#### Methods Available on `ResultSet` to Navigate Rows

- `next()`: Moves the cursor to the next row in the result set. Returns `true` if there is a next row, otherwise returns `false`. This method is typically used in a loop to iterate through all rows in the result set.
- `previous()`: Moves the cursor to the previous row in the result set. Returns `true` if there is a previous row, otherwise returns `false`. This method is useful for backward traversal of the result set.
- `first()`: Moves the cursor to the first row in the result set. Returns `true` if the result set is not empty, otherwise returns `false`. This method is useful for quickly accessing the first record.
- `last()`: Moves the cursor to the last row in the result set. Returns `true` if the result set is not empty, otherwise returns `false`. This method is useful for quickly accessing the last record.
- `absolute(int row)`: Moves the cursor to the specified row number in the result set. Returns `true` if the cursor is now positioned on a valid row, otherwise returns `false`. This method is useful for random access to specific rows.
- `relative(int rows)`: Moves the cursor a specified number of rows forward (positive value) or backward (negative value) in the result set. Returns `true` if the cursor is now positioned on a valid row, otherwise returns `false`. This method is useful for navigating to a row relative to the current position.
- `beforeFirst()`: Moves the cursor to a position before the first row in the result set. This method is useful for resetting the cursor to the beginning of the result set.
- `afterLast()`: Moves the cursor to a position after the last row in the result set. This method is useful for resetting the cursor to the end of the result set.
- `isFirst()`: Checks if the cursor is positioned on the first row of the result set. Returns `true` if it is, otherwise returns `false`.
- `isLast()`: Checks if the cursor is positioned on the last row of the result set. Returns `true` if it is, otherwise returns `false`.

### Real World Application

Navigating `ResultSet` rows is a common requirement in various Java applications that interact with databases. Some real world scenarios where navigating result set rows include:

- Data Display: In web applications, navigating result set rows is essential for displaying data in tables or lists. Users can navigate through pages of results, view details of individual records, and perform actions on specific rows.
- Data Processing: In data processing applications, navigating result set rows is crucial for performing operations on individual records. This includes tasks such as data transformation, aggregation, and analysis.
- Data Export: When exporting data from a database to external formats (e.g., CSV, Excel), navigating result set rows allows for iterating through records and writing them to the desired format.

### Implementation

```java
// ...
try(Connection conn = DriverManager.getConnection(db_url, db_user, db_pass)) {
  // Create Statement or PreparedStatement
  Statement stmt = conn.createStatement();

  // Execute SQL query
  ResultSet rs = stmt.executeQuery("SELECT * FROM employees");

  // Move the cursor to the next row
  while (rs.next()) {
    // Retrieve column values from the current row
    int id = rs.getInt("id");
    String name = rs.getString("name");
    int age = rs.getInt("age");

    // Process or display the retrieved data
    Member member = new Member(id, name, age);

    System.out.println(member);
    // Move to the next row
  }

  // Move the cursor to the previous row
  rs.afterLast(); // Move to after the last row

  while(rs.previous()) {
    // Retrieve column values from the current row
    // Process or display the retrieved data
    // Move to the previous row
  }

  // Move the cursor to the first row
  resultSet.first();
  if (!resultSet.isBeforeFirst()) {
        // Retrieve column values from the first row
        // Process or display the retrieved data
    }

  // Move the cursor to the last row
  resultSet.last();
  if (!resultSet.isAfterLast()) {
        // Retrieve column values from the last row
        // Process or display the retrieved data
  }

  // Move the cursor to a specific row
  resultSet.absolute(5); // Move to the 5th row
  if (resultSet.isBeforeFirst() || resultSet.isAfterLast()) {
        // The specified row is invalid
  } else {
        // Retrieve column values from the specified row
        // Process or display the retrieved data
  }
} catch (SQLException e) {
  e.printStackTrace();
}
```
