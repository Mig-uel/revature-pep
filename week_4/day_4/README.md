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
