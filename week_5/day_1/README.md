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

## Preventing SQL Injection

We will explore common coding mistakes in Java that lead to a vulnerable application and how to avoid them using the APIs available in the JVM's standard runtime library.

#### How Do Applications Become Vulnerable to SQL Injection?

SQL injection attacks occur when an attacker is able to manipulate the SQL queries that an application sends to its database. This can happen when user input is not properly sanitized or validated before being included in SQL statements.

For many applications, the only way to execute a given computation is to dynamically generate code that is in turn run by another system or component. If, in the process of generating this code, we use untrusted user input without proper sanitization, we open ourselves up to code injection attacks.

This statement may sound a bit abstract, so let's look at a concrete example in the context of SQL injection.

```java
public List<AccountDTO> unsafeFindAccountByCustomerId(String customerId) throws SQLException {
  // THIS IS UNSAFE - DO NOT DO THIS BECAUSE IT IS VULNERABLE TO SQL INJECTION
  String sql = "SELECT " + "customer_id, acc_number, branch_id, balance " +
     "FROM Accounts where customer_id = '" + customerId + "'";

  Connection conn = dataSource.getConnection();
  ResultSet rs = conn.createStatement().executeQuery(sql);
  // ...
}
```

The problem with the code above is obvious: we directly concatenate user input into our SQL statement. If an attacker were to provide a specially crafted `customerId` value, they could manipulate the SQL query to execute arbitrary commands on the database. Nothing bad will happen if we are sure that this `customerId` value will only come from trusted sources, but can we really be sure of that?

Let's imagine that this function is used in a REST API implementation for an account resource. Exploiting this code is trivial: all we have to do is send a value that, when concatenated with the fixed part of the query, changes its intended behavior.

```bash
curl -X GET "http://localhost:8080/accounts?customerId=abc%27%20OR%20%271%27=%271" \
```

The value of the `customerId` sent by the request is:

```
abc' OR '1'='1
```

When we join this value with the fixed part, we get the final SQL statement that will be executed:

```sql
SELECT customer_id, acc_number, branch_id, balance FROM Accounts where customer_id = 'abc' OR '1'='1'
```

The expression `1 = 1` will always evaluate to true, and as a result, the query will return all accounts in the database, not just those belonging to customer `abc`.

A smart developer (aren't we all?) would now be thinking: "That's silly! I'd never use string concatenation to build SQL queries." Not so fast...This canonical example is silly indeed, but there are situations where we might still need to do it:

- Complex queries with dynamic search criteria: adding `UNION` clauses depending on user input.
- Dynamic grouping or ordering: REST APIs used as a backend to a data table UI component that allows users to choose which columns to sort by.

#### Prevention Techniques

Now that we know what SQL injection is, let us see how we can protect our code from this kind of attack. Here we are focusing on a couple of very effective techniques available in Java and other JVM languages, but similar concepts are available in other environments, such as PHP, .NET, Ruby, and so on.

#### Parameterized Queries

This technique consists of using prepared statement with the question mark placeholder ("?") in our queries whenever we need to insert a user supplied value. This is very effective and, unless there is a bug in the JDBC driver's implementation, it will protect us from SQL injection attacks.

Let's rewrite out example function using a parameterized query:

```java
public List<AccountDTO> safeFindAccountByCustomerId(String customerId) throws
SQLException {
  String sql = "SELECT customer_id, acc_number, branch_id, balance FROM Accounts WHERE customer_id = ?"

  Connection conn = dataSource.getConnection()
  PreparedStatement ps = conn.prepareStatement(sql);
  ps.setString(1, customerId);
  ResultSet rs = ps.executeQuery();
  // omitted - process rows and return list of AccountDTO
}
```

In the code above, we have used the `prepareStatement()` method available in the `Connection` interface to create a `PreparedStatement` object. This interface extends the regular `Statement` interface and adds methods for setting the values of the parameters in the query. These methods allow use to safely bind user input to the query, preventing SQL injection attacks.

As expected, the ORM (Object-Relational Mapping) layer creates a prepared statement using a placeholder ("?") for the user-supplied value. The actual value is then bound to the placeholder using the `setString()` method. This ensures that the value is properly escaped and treated as a literal value, rather than part of the SQL code.

As a bonus, this approach usually results in a better performance, as the database can cache the execution plan for the prepared statement and reuse it for subsequent calls with different parameter values.

Please note that this approach only works for placeholders used as values. For instance, we cannot use placeholders to dynamically change the name of a table or a column in the query

```java
// THIS WILL NOT WORK!
PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM ?");
ps.setString(1, tableName); // INVALID - will throw SQLException
```

#### User Data Sanitization

Data sanitization is a technique that consists of cleaning user input to remove potentially dangerous characters or patterns. This technique is less effective than parameterized queries, but it can be useful in certain situations, such as when we need to dynamically build parts of a query that cannot be parameterized (e.g., table or column names).

With data sanitization, you apply a filter to user supplied data so it can be sagely used by other parts of our application. A filter's implementation may vary, but we can generally classify them into two types: whitelists and blacklists.

Blacklists, which consist of a list of disallowed characters or patterns, are usually of little value in the context of SQL injection prevention - but not for detection!

Whitelists, on the other hand, work well when we can define exactly what is considered valid input. For instance, if we expect a username to be alphanumeric and between 3 and 20 characters long, we can use a regular expression to validate the input:

Let's enhance our `safeFindAccountsByCustomerId` method so now the caller can also specify the column to sort the result set. Since we know the set of possible columns, we can implement a whitelist using a simple set and use it to sanitize the received parameter:

```java
private static final Set<String> VALID_COLUMNS_FOR_ORDER_BY = Collections.unmodifiableSet(Stream.of("acc_number", "branch_id", "balance").collect(Collectors.toCollection(HashSet::new)));

public List<AccountDTO> safeFindAccountByCustomerId(String customerId, String orderBy) throws Exception {
  String sql = "SELECT customer_id, acc_number, branch_id, balance FROM Accounts WHERE customer_id = ?";

  if (VALID_COLUMNS_FOR_ORDER_BY.contains(orderBy)) {
    sql = sql + " ORDER BY " + orderBy;
  } else {
    throw new IllegalArgumentException("Nice try!")
  }

  Connection conn = dataSource.getConnection();
  PreparedStatement ps = conn.prepareStatement(sql);

  p.setString(1, customerId);
  // ... ResultSet processing omitted
}
```

In the above code, we are combining the prepared method approach and a whitelist to sanitize the `orderBy` argument. The final result is a safe string concatenation that cannot be exploited by an attacker. In this simple example, we are using a static set, but we could also have used the database metadata functions to create it.

#### Are We Safe Now?

Let's assume that we have used parameterized queries and/or whitelists everywhere. Can we now go to our manager and guarantee we are safe?

Well...not so fast; there are other aspects we must consider:

- **Stored Procedures**: These are also prone to SQL injection; whenever possible, please apply sanitization even to values that will be sent to the database via prepared statements.
- **Triggers**: These are also prone to SQL injection, but even more insidious because sometimes we have no idea they exist. If you are using a third-party database or a legacy system, please make sure you know what triggers are defined in the database.
- **Insecure Direct Object References**: Even if our application is SQL injection-free, there is still a risk associated with this vulnerability. The main point is that an attacker may be able to access data they should not be able to see, even if they cannot manipulate the SQL queries. For instance, if our application allows users to access their bank accounts by specifying the account number, an attacker could try to access other users' accounts by guessing or enumerating account numbers. To prevent this, we must always enforce proper authorization checks in our application. There is a good cheat sheet on this topic available at OWASP: https://cheatsheetseries.owasp.org/cheatsheets/Access_Control_Cheat_Sheet.html.

In short, our best option here is caution. Many organizations nowadays use a "red team" exactly for this purpose: to try to break into their systems and find vulnerabilities before the bad guys do. If your organization does not have a red team, you can hire external consultants to perform penetration testing on your applications.

#### Damage Control Techniques

As a good security practice, we should always implement multiple defense layers, a concept known as defense in depth. The main idea is that even if we are unable to find all possible vulnerabilities in our code (a common scenario when dealing with legacy systems), we can still mitigate the impact of any potential attacks. Some common damage control techniques include:

- **Least Privilege**: Ensure that the database user used by the application has only the necessary permissions. For instance, if the application only needs to read data, do not grant it write permissions. Restrict as much as possible.
- **Database-Specific Methods**: Some databases provide specific methods to sanitize user input. For instance, in PostgreSQL, we can use the `quote_literal()` function to safely escape string values. Please refer to your database documentation for more information.
- **Short-Lived Credentials**: If possible, use short-lived credentials for the database user. This way, even if an attacker manages to steal the credentials, they will only be valid for a limited time.
- **Monitoring and Logging**: Implement monitoring and logging to detect any suspicious activity. This can help us identify potential attacks and respond quickly.
- **Web Application Firewall (WAF)**: Consider using a WAF to filter out malicious traffic before it reaches your application. A WAF can help block common attack patterns and provide an additional layer of security. Some include in-JVM agents that can detect intrusions by applying instrumentation techniques.

### Real World Application

SQL injection is a serious security vulnerability that can have devastating consequences for organizations. SQL injection vulnerabilities can be found in various Java applications that use JDBC to interact with databases. Some real-world scenarios where SQL injection attacks can occur include:

- Web Applications
  - Web applications that accept user input for generating dynamic SQL queries, such as search forms, user authentication, or data filtering, are particularly vulnerable to SQL injection attacks. Attackers can exploit these vulnerabilities to gain unauthorized access to sensitive data or perform malicious actions on the database.
- E-commerce Systems
  - Online stores that handle customer data, process transactions, or manage inventory should carefully validate and sanitize user input to prevent SQL injection attacks that could compromise sensitive information.
- Content Management Systems
  - CMS platforms that allow users to create, edit, or delete content may be vulnerable to SQL injection if user input is not properly sanitized. Attackers could exploit these vulnerabilities to manipulate content or gain unauthorized access to the system.

#### Real World SQL Injection Examples

- In 2008, payment processor Heartland Payment Systems suffered a massive data breach due to a SQL injection attack. The attackers exploited a vulnerability in the company's web application to gain access to sensitive customer data, including credit card information. This resulted in one of the largest data breaches in history, affecting millions of customers and costing the company over $140 million in damages.
- In 2014, a hacker gang collected over 1.2 billion unique IDs and password combinations from over 420,000 websites across the internet. The Russian cybercriminals used SQL injection techniques to exploit vulnerabilities in various web applications, leading to one of the largest data breaches ever recorded.
- UK telecom giant TalkTalk suffered a significant data breach in 2015 due to a SQL injection attack. The attackers exploited a vulnerability in the company's website to gain access to sensitive customer information, including names, addresses, dates of birth, and financial details. The breach affected approximately 157,000 customers and resulted in a £400,000 fine for TalkTalk by the UK's Information Commissioner's Office (ICO) for failing to implement adequate security measures.
- Epic Games, the company behind the popular game Fortnite, experienced a data breach in 2016 due to a SQL injection attack. The attackers exploited a vulnerability in the company's website to gain access to sensitive user information, including usernames, email addresses, and encrypted passwords. The breach affected approximately 800,000 users and highlighted the importance of securing web applications against SQL injection attacks.

#### Breaches Enabled by SQL Injection

- GhostShell attack (2015): hackers from the APT group Team GhostShell targeted 53 universities and organizations, exploiting SQL injection vulnerabilities to gain access to sensitive data, including personal information of students and staff. They stole and published 36,000 personal records belonging to students and staff from various universities.
- Turkish government: another APT group, the RedHack collective, exploited SQL injection vulnerabilities in Turkish government websites to gain access to sensitive information. They leaked personal data of thousands of citizens, including names, addresses, and national identification numbers.
- 7-Eleven (2017): attackers used SQL injection techniques to exploit vulnerabilities in the 7-Eleven website, gaining access to customer data, including names, email addresses, and purchase history. The breach affected thousands of customers and raised concerns about the security of online retail platforms.
- HBGary (2018): a hacker group exploited SQL injection vulnerabilities in the HBGary website to gain access to sensitive information, including email addresses and hashed passwords of users. The breach highlighted the importance of securing web applications against SQL injection attacks, even for cybersecurity firms. This attack was a response to HBGary's involvement in tracking and exposing hacktivist groups.

#### Notable SQL Injection Vulnerabilities

- Tesla (2014): A security researcher discovered a SQL injection vulnerability in Tesla's website that allowed unauthorized access to customer data. The vulnerability was reported to Tesla, which promptly fixed the issue and rewarded the researcher with a bug bounty.
- Cisco (2018): A SQL injection vulnerability was discovered in Cisco Prime License Manager, which could allow attackers to execute arbitrary SQL commands and gain unauthorized access to sensitive data. Cisco released a security advisory and provided patches to address the vulnerability.
- Fortnite (2019): A SQL injection vulnerability was discovered in the Fortnite website, which could allow attackers to access sensitive user information. Epic Games, the company behind Fortnite, quickly addressed the issue and implemented additional security measures to protect user data.

#### Implementation

#### Overview of Prepared Statements

Prepared statements are a feature of JDBC that allows developers to create SQL statements with placeholders for parameters. These placeholders are represented by question marks ("?") in the SQL statement. When the prepared statement is executed, the parameters are bound to the placeholders, ensuring that user input is treated as data rather than executable code.

If you want to execute a `Statement` object many times, it is more efficient to use a `PreparedStatement` object. The database can optimize the execution plan for the prepared statement and reuse it for subsequent executions with different parameter values.

The main feature of a `PreparedStatement` is that, unlike a `Statement`, it is given a SQL statement when it is created. The advantage of this is that in most cases, this SQL statement is sent to the DBMS right away, where it is compiled. As a result, the `PreparedStatement` object contains not just a SQL statement but a SQL statement that has been precompiled. This means that when we execute a `PreparedStatement`, the DBMS does not have to compile the SQL statement again, which can save time, especially if we are executing the same statement multiple times.

Although you can use `PreparedStatement` objects to execute static SQL statements, you will probably use them primarily to execute dynamic SQL statements. The advantage of using `PreparedStatement` for dynamic SQL is that you can reuse the same prepared statement with different parameter values, without having to recompile the SQL statement each time.

However, the most important advantage of prepared statements is that they help prevent SQL injection attacks. By using placeholders for user input, we ensure that the input is properly escaped and treated as a literal value, rather than part of the SQL code. SQL injection techniques all exploit a single vulnerability in the application: incorrectly validated or non-validated string literals that are concatenated into SQL statements and interpreted by the SQL engine. Prepared statements always treat client-supplied data as content of a parameter, never as part of the SQL command.

The following method, CoffeesTable.updateCoffeeSales, stores the number of pounds of coffee sold in the current week in the SALES column for each type of coffee and updates the total number of pounds of coffee sold in the TOTAL column for each type of coffee:

```java
public void updateCoffeeSales(HashMap<String, Integer> salesForWeek) throws SQLException {
    String updateString =
      "update COFFEES set SALES = ? where COF_NAME = ?";
    String updateStatement =
      "update COFFEES set TOTAL = TOTAL + ? where COF_NAME = ?";

    try (PreparedStatement updateSales = con.prepareStatement(updateString);
         PreparedStatement updateTotal = con.prepareStatement(updateStatement))

    {
      con.setAutoCommit(false);
      for (Map.Entry<String, Integer> e : salesForWeek.entrySet()) {
        updateSales.setInt(1, e.getValue().intValue());
        updateSales.setString(2, e.getKey());
        updateSales.executeUpdate();

        updateTotal.setInt(1, e.getValue().intValue());
        updateTotal.setString(2, e.getKey());
        updateTotal.executeUpdate();
        con.commit();
      }
    } catch (SQLException e) {
      JDBCTutorialUtilities.printSQLException(e);
      if (con != null) {
        try {
          System.err.print("Transaction is being rolled back");
          con.rollback();
        } catch (SQLException excep) {
          JDBCTutorialUtilities.printSQLException(excep);
        }
      }
    }
  }
```

#### Creating a PreparedStatement Object

The following creates a `PreparedStatement` object that takes two parameters:

```java
String updateString =
  "update COFFEES set SALES = ? where COF_NAME = ?";
PreparedStatement updateSales = con.prepareStatement(updateString);
```

#### Supplying Values for Placeholders

You must supply values in place of the placeholders (if there are any) before you can execute a prepared statement. You supply values by using the appropriate setter methods of the `PreparedStatement` interface. The following code sets the two placeholders in the preceding `updateSales` prepared statement:

```java
updateSales.setInt(1, e.getValue().intValue());
updateSales.setString(2, e.getKey());
```

The first argument for each of these setter methods is the number of the placeholder to be set, which is not zero-based but one-based. This means that the first placeholder is represented by 1, the second by 2, and so on.

The second argument is the value to be set for the placeholder. The appropriate setter method must be used for the data type of the placeholder. For example, if the placeholder represents an integer value, you must use the `setInt` method; if it represents a string value, you must use the `setString` method.

After a placeholder has been set with a value, it retains that value until it is reset to another value or the method `clearParameters()` is called.

Using the `PreparedStatement` object `updateSales`, the following code illustrates reusing a prepared statement after resetting the value of its placeholders and keeping the other placeholder values unchanged:

```java
// changes SALES column of French Roast to 100
updateSales.setInt(1, 100);
updateSales.setString(2, "French Roast");
updateSales.executeUpdate();

// changes SALES column of Espresso row to 100
// the first placeholder unchanged
// updateSales.setInt(1, 100);
// second placeholder reset to 'Espresso'
updateSales.setString(2, "Espresso");
updateSales.executeUpdate();
```

#### Using Loops to Set Values

You can often make coding easier by using a for-loop or a while loop to set the values for the placeholders in a prepared statement.

The `CoffeesTable.updateCoffeeSales` method uses a for-each loop to repeatedly set the values for the two placeholders in the `updateSales` prepared statement and execute it.

```java
for (Map.Entry<String, Integer> e : salesForWeek.entrySet()) {
  updateSales.setInt(1, e.getValue().intValue());
  updateSales.setString(2, e.getKey());
  updateSales.executeUpdate();
}
```

The method `updateCoffeeSales()` takes one argument, a `HashMap`. Each element in the `HashMap` argument contains the name of one type of coffee and the number of pounds of that type of coffee sold during the current week. The for-each loop iterates through each element of the `HashMap` argument and sets the appropriate values for the placeholders in the `updateSales` prepared statement.

#### Executing `PreparedStatement` Objects

As with `Statement` objects, to execute a `PreparedStatement` object, call an execute statement method such as `executeQuery()`: if the query returns only one `ResultSet` object (such as a SELECT statement), `executeUpdate()`: if the query is an INSERT, UPDATE, or DELETE statement or an SQL statement that returns nothing (such as a DDL statement), or `execute()`: if the query may return multiple results.
Both `PreparedStatement` and `Statement` objects can be used to execute SQL queries, but `PreparedStatement` objects offer several advantages, including precompiled SQL statements, the ability to set parameter values, and improved performance for repeated executions. Both `PreparedStatement` objects in `CoffeesTable.updateCoffeeSales(HashMap<String, Integer>)` contain `UPDATE` SQL statements, so both are executed by `executeUpdate()`.

```java
updateSales.setInt(1, e.getValue().intValue());
updateSales.setString(2, e.getKey());
updateSales.executeUpdate();

updateTotal.setInt(1, e.getValue().intValue());
updateTotal.setString(2, e.getKey());
updateTotal.executeUpdate();

con.commit();
```

No arguments are supplied to `executeUpdate()`. The method returns an integer value that indicates the number of rows affected by the execution of the SQL statement. If the return value is 0, no rows were affected.

Note: At the beginning of `CoffeesTable.updateCoffeeSales(HashMap<String, Integer>)`, the connection is set to not auto-commit changes. This means that changes made by the `UPDATE` statements are not immediately saved to the database. Instead, the changes are held in a transaction until the `commit()` method is called on the connection object. If an error occurs during the execution of the `UPDATE` statements, the changes can be rolled back to maintain data integrity.

Return values for the `executeUpdate()` method whereas `executeQuery()` returns a `ResultSet` object containing the results of the query sent to the database, the return value for `executeUpdate()` is an integer indicating the number of rows affected by the SQL statement. This return value is useful for determining how many rows were inserted, updated, or deleted by the execution of the SQL statement.

The following code shows the return value of `executeUpdate()` being stored in an integer variable named `n`:

```java
updateSales.setInt(1, 50);
updateSales.setString(2, "Espresso");
int n = updateSales.executeUpdate(); // n is the number of rows affected
// n = 1; because one row was updated
```

When the method `executeUpdate()` is used to execute a DDL (Data Definition Language) statement, such as creating a table, it returns the `int` value of 0. For example, the following code creates a table named `COFFEES` and stores the return value of `executeUpdate()` in an integer variable named `n`:

```java
// n = 0
int n = executeUpdate(createTableCoffees);
```

NNote that when the return value for `executeUpdate()` is 0, it indicates one of two things:

- The statement was executed successfully, but it did not affect any rows. This can happen with `UPDATE` or `DELETE` statements that do not match any rows in the database.
- The statement executed was a DDL statement, such as `CREATE TABLE` or `DROP TABLE`, which does not affect any rows.
