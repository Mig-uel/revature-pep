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
