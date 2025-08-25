# SQL Basic and JDBC - Day 1

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
