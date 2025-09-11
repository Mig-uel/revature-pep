# APIs and Testing - Day 3

## Authorization vs Authentication

The distinction between authorization and authentication is important in understanding how RESTful APIs work and why connection attempts are either accepted or denied.

- **Authentication** is the process of verifying the identity of a user or system. It answers the question, "Who are you?" Common methods of authentication include usernames and passwords, tokens, and biometric data. In the context of APIs, authentication ensures that the entity making a request is who they claim to be.
- **Authorization**, on the other hand, is the process of determining what an authenticated user or system is allowed to do. It answers the question, "What are you allowed to do?" Authorization typically occurs after authentication and involves checking permissions and access levels. In APIs, authorization ensures that the authenticated entity has the necessary rights to perform specific actions or access certain resources.

### Real World Application

There are several common ways to authenticate a user's credentials in a web application:

- **Username and Password**: The most basic common method where users provide a unique identifier (username) and a secret (password), which are then verified against stored credentials in a database. Passwords are typically hashed for security.
- **Token-Based Authentication**:
  - **JWT (JSON Web Tokens)**: After a user logs in with their credentials, the server generates a JWT, which is a compact, URL-safe token that contains claims about the user. The client stores this token (usually in local storage or cookies) and includes it in the Authorization header of subsequent requests. The server verifies the token to authenticate the user.
  - **OAuth 2.0**: Users authenticate using OAuth providers (like Google, Facebook), which issue access tokens that grant permissions to access protected resources without sharing credentials. OAuth 2.0 provides a flexible authentication framework for both web and mobile applications.
- **Two-Factor Authentication (2FA)**: Users authenticate using two different factors/methods, typically something they know (password) and something they have (a mobile device for receiving a code). This adds an extra layer of security by requiring additional verification beyond just a password.
- **Single Sign-On (SSO)**: Users authenticate once and gain access to multiple applications or services without needing to log in again. SSO is often implemented using protocols like SAML (Security Assertion Markup Language) or OpenID Connect, allowing users to use a single set of credentials across various platforms.

After authentication, there are several common ways to authorize a user's access to resources:

- **Role-Based Access Control (RBAC)**: Users are assigned roles (e.g., admin, user, guest), and each role has specific permissions associated with it. When a user attempts to access a resource, the system checks their role and determines if they have the necessary permissions to perform the requested action.
- **Claim-Based Authorization**: This method uses claims (attributes about the user) to determine access rights. Claims can include information such as user ID, email, or group membership. The system evaluates these claims against the resource's access policies to decide whether to grant or deny access.
- **Permission-Based Access Control**: Instead of assigning roles, users are granted specific permissions directly. Each resource has a set of permissions (e.g., read, write, delete), and the system checks if the user has the required permissions to access or modify the resource.
- **Attribute-Based Access Control (ABAC)**: This method uses a combination of user attributes, resource attributes, and environmental conditions to make authorization decisions. For example, access might be granted based on the user's department, the sensitivity of the data, and the time of day.
- **Policy-Based Access Control**: Access decisions are made based on predefined policies that specify who can access what resources under which conditions. Policies can be complex and may involve multiple factors, such as user roles, resource types, and contextual information.

Each authentication and authorization method has its own use cases, advantages, disadvantages, and security considerations. The choice of method depends on the specific requirements of the application, the sensitivity of the data being protected, and the user experience desired.

### Implementation

Let's consider an example of how authentication and authorization might be implemented fr a user trying to access a book website.

#### Authentication

- When a user visits the book website, they are prompted to log in with their username and password.
- The user enters their credentials, which are sent to the server for verification.
- The server checks the provided credentials against the stored user data in the database.
- If the credentials are valid, the server generates a JWT (JSON Web Token) that contains the user's ID and role (e.g., "user" or "admin").
- The JWT is sent back to the client and stored in local storage or a cookie for future requests.

#### Authorization

- Once authenticated, the user attempts to access various resources on the website, such as viewing books or adding a book to their reading list.
- Each time the user makes a request to access a resource, the server checks their authorization by examining the JWT included in the request headers.
- The server decodes the JWT to extract the user's role and permissions.
- Based on the user's role, the server determines what actions they are allowed to perform:
  - If the user has the "user" role, they can view books and add books to their reading list.
  - If the user has the "admin" role, they can also add new books to the website or manage user accounts.
- If the user tries to perform an action they are not authorized for (e.g., a "user" trying to add a new book), the server responds with a "403 Forbidden" status, indicating that they do not have permission to access that resource.

## Java Introduction to Logback

Logback is one of the most widely used logging frameworks in the Java ecosystem. It is designed to be a successor to the popular Log4j framework, offering improved performance, flexibility, and ease of use. Logback is part of the SLF4J (Simple Logging Facade for Java) project, which provides a simple abstraction for various logging frameworks.

#### Logback Architecture

The Logback architecture consists of three main classes:

- **Logger**: The Logger class is responsible for logging messages. It provides methods for logging at different levels (e.g., DEBUG, INFO, WARN, ERROR). Loggers are typically named according to the class or package they are associated with, allowing for fine-grained control over logging output.
- **Appender**: Appenders are responsible for directing log messages to various output destinations, such as the console, files, or remote servers. Logback provides several built-in appenders, including `ConsoleAppender`, `FileAppender`, and `RollingFileAppender`. Custom appenders can also be created to meet specific requirements.
- **Layout**: Layouts define the format of log messages. They determine how log messages are structured and presented. Logback provides several built-in layouts, such as `PatternLayout`, which allows for customizable log message formats using conversion patterns.

### Real World Application

#### Reasons to Prefer Logback Over Log4j 1.x

- **Faster Implementation**: Logback's internals have been rewritten to perform about 10 times faster than Log4j 1.x, making it more efficient for high-throughput applications. Not only are Logback components faster, but they also use less memory.
- **Extensive Battery of Tests**: Logback comes with a comprehensive suite of unit tests, ensuring reliability and stability. This extensive testing helps catch bugs and issues early in the development process.
- **Automatic Reloading of Configuration Files**: Logback can automatically reload its configuration files when they are modified, allowing for dynamic changes to logging behavior without restarting the application. This feature is particularly useful in production environments where downtime needs to be minimized.
- **Graceful Recovery from I/O Failures**: Logback's `FileAppender` and all of its subclasses, including `RollingFileAppender`, can gracefully recover from I/O failures. Thus, if a file server fails temporarily, you no longer need to restart your application to resume logging. As soon as the file server comes back online, Logback will automatically resume logging to the file.
- **Automatic Removal of Old Log Files**: Logback provides built-in support for automatically removing old log files based on time or size constraints. This feature helps manage disk space and ensures that log files do not accumulate indefinitely.
- **Automatic Compression of Old Log Files**: Logback can automatically compress old log files (e.g., using GZIP) to save disk space. This feature is particularly useful for applications that generate large volumes of log data. This is performed asynchronously, so it does not impact the performance of the application.

### Implementation

#### Setting Up Logback in a Java Project

##### Maven Dependency

Logback uses the Simple Logging Facade for Java (SLF4J) as its native interface. Before we can start logging messages, we need to add Logback and SLF4J dependencies to our Maven `pom.xml` file:

```xml
<dependency>
    <groupId>ch.qos.logback</groupId>
    <artifactId>logback-core</artifactId>
    <version>1.2.6</version>
</dependency>
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-api</artifactId>
    <version>1.7.30</version>
</dependency>
```

Maven Central has the latest versions of these dependencies, so be sure to check for updates.

##### Classpath Configuration

Logback also requires `logback-classic` to be on the classpath for runtime logging. Add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>ch.qos.logback</groupId>
    <artifactId>logback-classic</artifactId>
    <version>1.2.6</version>
</dependency>
```

##### Basic Example and Configuration

First, we need a configuration file for Logback. Create a file named `logback.xml` in the `src/main/resources` directory of your project:

```xml
<!-- Configuration file for Logback -->
<configuration>

  <!-- Console appender to print logs to the console -->
  <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
    <encoder>
      <pattern>%date %level [%thread] %logger{10} [%file:%line] - %msg%n</pattern>
    </encoder>
  </appender>

  <!-- File appender to write logs to a file -->
  <appender name="FILE" class="ch.qos.logback.core.FileAppender">
    <file>app.log</file>
    <encoder>
      <pattern>%date %level [%thread] %logger{10} [%file:%line] - %msg%n</pattern>
    </encoder>
  </appender>

  <!-- Set the root level to DEBUG and attach both appenders -->
  <root level="debug">
    <appender-ref ref="CONSOLE" />
    <appender-ref ref="FILE" />
  </root>

</configuration>
```

This configuration sets up two appenders: one for console output and another for writing logs to a file named `app.log`. The log messages will include the date, log level, thread name, logger name, file name, line number, and the actual log message.

Example of a log file output:

```plaintext
2024-06-01 12:00:00,123 INFO [main] MyApp [MyApp.java:10] - Application started
2024-06-01 12:00:01,456 DEBUG [main] MyApp [MyApp.java:20] - Debugging information
2024-06-01 12:00:02,789 ERROR [main] MyApp [MyApp.java:30] - An error occurred
```

##### Using Logback in Java Code

Next, to use our logger, we need to create a simple Java class:

```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Example {
  private static final Logger logger = LoggerFactory.getLogger(Example.class);

  public static void main(String[] args) {
    // Logger.* methods accept two parameters: the message and the class name


    // Log message at INFO level
    logger.info("This is an info message", Example.class.getSimpleName());

    // Log message at DEBUG level
    logger.debug("This is a debug message", Example.class.getSimpleName());

    // Log message at ERROR level
    logger.error("This is an error message", Example.class.getSimpleName());
  }
}
```

This code initializes a logger for the `Example` class and logs messages at different levels (INFO, DEBUG, ERROR). When you run this application, you should see the log messages printed to the console and written to the `app.log` file as specified in the `logback.xml` configuration.
