# OOP, Maven, and Developer Practices - Day 1

## SOLID Design Principles

The **SOLID** principles are a set of five design principles that help software developers design maintainable, understandable, and flexible software systems. The principles are:

1. **Single Responsibility Principle (SRP)**
2. **Open/Closed Principle (OCP)**
3. **Liskov Substitution Principle (LSP)**
4. **Interface Segregation Principle (ISP)**
5. **Dependency Inversion Principle (DIP)**

By following these principles, developers can create systems that are easier to manage and extend over time.

**Single Responsibility Principle (SRP)**
SRP states that a class should have only one reason to change, meaning it should only have one job or responsibility. This principle helps to reduce the complexity of the code and makes it easier to maintain and understand.

- To apply SRP in Java, aim to create classes that have a clear and single responsibility, and avoid adding unrelated functionalities to them.
- If a class has multiple responsibilities, consider refactoring it into smaller, more focused classes, each with its own responsibility.

**Open/Closed Principle (OCP)**
OCP states that software entities (classes, modules, functions, etc.) should be open for extension but closed for modification. This means that you should be able to add new functionality to a class without changing its existing code. To achieve this, you can use techniques such as inheritance, interfaces, and composition.

- To apply OCP in Java, aim to design classes that can be extended without modifying their existing code. Use abstract classes or interfaces to define contracts that can be implemented by other classes.
- This can be achieved by using interfaces, abstract classes, composition, and polymorphism.

**Liskov Substitution Principle (LSP)**
LSP states that subtypes should be substitutable for their base types without affecting the correctness of the program. This means that if a class is a subtype of another class, it should be able to replace the base class without altering the desirable properties of the program.

- To apply LSP in Java, ensure that subclasses can be used interchangeably with their parent classes without causing unexpected behavior.

**Interface Segregation Principle (ISP)**
ISP states that clients should not be forced to depend on interfaces they do not use. This means that you should create smaller, more specific interfaces rather than large, general-purpose ones.

- To apply ISP in Java, design interfaces that are focused on specific functionalities and avoid creating "fat" interfaces that include methods not needed by all implementing classes.

**Dependency Inversion Principle (DIP)**
DIP states that high-level modules should not depend on low-level modules; both should depend on abstractions. This principle encourages the use of interfaces or abstract classes to decouple high-level and low-level components.

- To apply DIP in Java, use dependency injection to provide dependencies to classes rather than hardcoding them. This allows for greater flexibility and easier testing.
- Abstractions should not depend on details, but details should depend on abstractions.
- You should use interfaces or abstract classes to define the behavior of your classes, and then use dependency injection to provide specific implementations.

By following these principles, you can create a well-structured and maintainable codebase that is easier to understand and extend over time.

### Real World Application

We will describe how each **SOLID** principle can be used in real world applications:

**Single Responsibility Principle (SRP)**

In a web application, a User class should handle user-specific functionalities like user authentication and user authorization, while a separate EmailService class should handle email-related functionalities like sending and receiving emails. SRP ensures that each class should be responsible for specific functionalities, making the codebase easier to maintain and extend. This separation also ensures that changes to the email functionality do not impact the user-related functionality and vice versa.

**Open-Closed Principle (OCP)**

Consider a payment system where new payment methods can be added. By leveraging OCP, rather than modifying the existing payment processing code, you can create new classes that extend the payment functionality. For example, you can define an interface called PaymentProcessor and have multiple classes implement it, such as CreditCardProcessor, PayPalProcessor, and BankTransferProcessor. This allows you to add new payment methods without changing the existing code, adhering to the OCP principle.

**Liskov Substitution Principle (LSP)**
In a banking application with different account types like SavingsAccount and CheckingAccount inheriting from the base class Account, LSP ensures that code expecting an Account object can seamlessly work with any subclass without knowing the details of the specific account type. This means that methods using the Account type can operate on any derived class, promoting code reusability and flexibility.

**Interface Segregation Principle (ISP)**

If we apply ISP to to a messaging system, instead of having a single IMessage interface with multiple methods like SendMessage, ReceiveMessage, and DeleteMessage, separate interfaces like ISender and IReceiver can be created. This way, classes that only need to send messages can implement ISender without being forced to implement methods they do not use. This leads to cleaner and more maintainable code.

**Dependency Inversion Principle (DIP)**
In an e-commerce application, instead of the OrderProcessor class depending directly on a specific payment gateway implementation, it can depend on an IPaymentGateway interface. This allows the OrderProcessor to work with any payment gateway that implements the interface, promoting flexibility and easier testing. By using dependency injection, the specific payment gateway implementation can be provided at runtime, adhering to the DIP principle.

### Implementation

**Single Responsibility Principle (SRP)**

Let's say we have a User entity that we want to be able to authenticate. In the example below, we have persistence and authentication logic within the same class.

```java
// Incorrect
class User {
  public boolean authenticateUser() {
    // authentication logic here
  }
  public void createUser() {
    // user persistence logic here
  }
}
```

This violates the Single Responsibility Principle because the User class has two responsibilities: authentication and persistence. To apply SRP, we can refactor the code into separate classes: `UserAuthenticator` and `UserDAO` (DAO stands for Data Access Object).

```java
// Correct
class UserAuthenticator {
  public boolean authenticateUser() {
    // authentication logic here
  }
  // other methods that handle user authentication
}

class UserDAO {
  public void createUser() {
    // user persistence logic here
  }
  // other methods that handle user persistence
}
```

**Open-Closed Principle (OCP)**
In the example below, we have a `Vehicle` class that has a speed instance variable and an `accelerate()` method.

```java
// Incorrect
class Vehicle {
  int speed;
  public double accelerate(Vehicle v) {
    if (v instanceof Car) {
      return v.speed + 10; // specific logic for Car
    }
    if (v instanceof Truck) {
      return v.speed += 5;
    }
  }
}
```

The logic above does NOT follow the Open-Closed Principle because it requires modifying the `Vehicle` class to add new vehicle types. To apply OCP, we can create a new class that implements the same interface and provides the new functionality:

```java
// Correct
interface Vehicle {
  public double accelerate();
}
class Car implements Vehicle {
  int speed;

  @Override
  public double accelerate() {
    this.speed += 10;
    return this.speed;
  }
}

class Truck implements Vehicle {
  int speed;

  @Override
  public double accelerate() {
    this.speed += 5;
    return this.speed;
  }
}
```

**Liskov Substitution Principle (LSP)**

In the example below, we have a `Bird` class and a `Penguin` subclass.

```java
// Incorrect
class Bird {
  public void fly() {}
}
class Penguin extends Bird {
  public void fly() {
    // implements walking logic since penguins can not fly
  }
}
```

The code above violates LSP because the subclass `Penguin` changes the intent of the `fly()` method. Instead of flying, it provides an implementation that does not fulfill the expected behavior of a `Bird`. To adhere to LSP, we could redesign the class hierarchy or the method to ensure that all subclasses maintain the expected behavior.

We can instead expand the inheritance hierarchy to have `Flying` and `Flightless` subtypes or use an interface that defines the `fly()` behavior:

```java
// Correct
class Bird {}

interface Flyable {
  public void fly();
}

class Penguin extends Bird {}

class Albatross extends Bird implements Flyable {
  @Override
  public void fly() {
    // flying logic here
  }
}
```

**Interface Segregation Principle (ISP)**

In the example below, we have a `Vehicle` interface that defines several behaviors. The `Bike` class can implement some of these behaviors, but not all of them.

```java
// Incorrect
interface Vehicle {
  public void accelerate();
  public void brake();
  public void openDoors();
}

class Bike implements Vehicle {
  @Override
  public void accelerate() {
    // bike-specific acceleration logic
  }

  @Override
  public void brake() {
    // bike-specific braking logic
  }

  @Override
  public void openDoors() {
    // bikes do not have doors, so this method is irrelevant
  }
}
```

The code above violates ISP because the `Bike` class is forced to implement a method (`openDoors()`) that it does not use. To apply ISP, we can create smaller, more specific interfaces:

```java
class Vehicle {
  public void accelerate();
  public void brake();
}

interface Enterable {
  public void openDoors();
}

class Bike implements Vehicle {
  @Override
  public void accelerate() {
    // bike-specific acceleration logic
  }

  @Override
  public void brake() {
    // bike-specific braking logic
  }
}

class Truck extends Vehicle implements Enterable {
  @Override
  public void accelerate() {
    // truck-specific acceleration logic
  }

  @Override
  public void brake() {
    // truck-specific braking logic
  }

  @Override
  public void openDoors() {
    // truck-specific door opening logic
  }
}
```

**Dependency Inversion Principle (DIP)**

In the example below, we have a `NotificationService` class that uses an `EmailSender` object to send a notification.

```java
// Incorrect
class NotificationService {
  EmailSender emailSender = new EmailSender();

  sendNotification() {
    emailSender.send();
  }
}

class EmailSender {
  send() {
    // email sending logic
  }
}
```

The code above violates DIP because the `NotificationService` class depends directly on the `EmailSender` class. To apply DIP, we can introduce an interface for sending notifications and use dependency injection to provide the specific implementation.

We can instead have a general supertype, `Sendable`. This allows our `NotificationService` class the flexibility of swapping between different implementations of the `Sendable` object:

```java
// Correct
class NotificationService {
  Sendable sender = new EmailSender();

  sendNotification() {
    sender.send();
  }
}

interface Sendable {
  send();
}

class EmailSender implements Sendable {
  @Override
  public void send() {
    // email sending logic
  }
}

class SmsSender implements Sendable {
  @Override
  public void send() {
    // SMS sending logic
  }
}
```

## Intro to Maven `pom` and `xml` Files

**Introduction to Maven**

[**Maven**](https://maven.apache.org/) is a build automation tool used primarily for Java projects. It simplifies the process of managing project dependencies, building projects, and deploying applications. Maven uses a Project Object Model (POM) file (`pom.xml`) to define project structure, dependencies, and build configurations.

In simple terms, Maven is a tool that is used for building and managing any Java-based project. It provides a consistent way to manage project dependencies, build processes, and project structure.

Maven helps in the following ways:

- Simplifies the build process
- Manages project dependencies and adding jar files
- Provides a standardized project structure
- Facilitates easy integration with other tools and frameworks
- Documenting project information with change logs and reports
- Integration with source control systems like Git

Features of Maven that we will go over:

- Project Object Model (POM)
- Maven lifecycle

Maven project configuration and dependencies are handled via the Project Object Model (POM) file, which is an XML file named `pom.xml`. This file contains essential project information such as project name, version, dependencies, build settings, and plugins required for building and managing the project.

**POM - Project Object Model**

Maven identifies projects through **project coordinates** defined in the `pom.xml` file. These coordinates consist of the following elements:

- `<groupId>`: The unique identifier for the group or organization that is responsible for the project (e.g., `com.example`).
- `<artifactId>`: The unique identifier for the project itself (e.g., `my-app`).
- `<version>`: The version of the project (e.g., `1.0.0`).

Together, these uniquely identify a project in the Maven repository and a specific version of that project.

Some other important tags within the `pom.xml` file include:

- `<project>`: The root element of the POM file, which contains all other configuration elements.
- `<modelVersion>`: The version of the POM model being used (e.g., `4.0.0`).
- `<name>`: The name of the project (e.g., `My Application`).
- `<properties>`: A section for defining project properties, such as the Java version or encoding.
- `<dependencies>`: A section for defining project dependencies, which are external libraries or modules required by the project.
  - Each dependency has its own `<dependency>` element, which includes `<groupId>`, `<artifactId>`, and `<version>` tags.
- `<plugins>`: A section for defining Maven plugins, which are used to extend Maven's functionality.
  - Each plugin has its own `<plugin>` element, which includes `<groupId>`, `<artifactId>`, and `<version>` tags.

Example of a `pom.xml` file:

```xml
<project>
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.example</groupId>
  <artifactId>my-app</artifactId>
  <version>1.0.0</version>

  <properties>
    <java.version>11</java.version>
  </properties>

  <name>My Application</name>

  <dependencies>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter</artifactId>
      <version>2.5.4</version>
    </dependency>
    <dependency>
      <groupId>org.apache.maven</groupId>
      <artifactId>maven-core</artifactId>
      <version>${mavenVersion}</version>
    </dependency>
  </dependencies>
</project>
```

**Maven Build Lifecycle**

When Maven builds your project, it goes through several steps called **phases**.

The default maven build lifecycle goes through the following phases:

1. **validate**: Validate the project is correct and all necessary information is available.
2. **compile**: Compile the source code of the project.
3. **test**: Run tests using a suitable testing framework.
4. **package**: Package the compiled code into a distributable format, such as a JAR or WAR file.
5. **integration**: Run integration tests.
6. **verify**: Run any checks to verify the package is valid and meets quality standards.
7. **install**: Install the package into the local Maven repository.
8. **deploy**: Copy the final package to the remote repository for sharing with other developers and projects.

Each phase is responsible for a specific task in the build process, and they are executed in order. You can also bind custom tasks to specific phases using plugins, allowing for greater flexibility in the build process.

Each phase in turn is composed of plugin goals that are bound to zero or more build phases. A plugin goal is a specific task that the plugin can perform, such as compiling code, running tests, or packaging the application.

**What are WAR and JAR files?**

Java ARchive (JAR) files are used to package Java classes, metadata, and resources into a single file for distribution. JAR files are typically used for libraries or applications that can be executed by the Java Virtual Machine (JVM).
Java applications are typically packaged and distributed as JAR files for easy deployment, which are basically ZIP files with a `.jar` extension.

Web applications are distributed as Web Application ARchive (WAR) files, which are similar to JAR files but include additional metadata and resources required for web applications. WAR files contain not only Java classes but also HTML, CSS, JavaScript, and other web-related resources.

Maven projects can be deployed to servlet containers (such as Apache Tomcat) by packaging them as WAR files.

Depending on your project configuration in the `pom.xml` file, Maven will either create a WAR file or a JAR file based on the packaging type specified in the `<packaging>` element during the build process.

**Using the `mvn` Command**

To use the Maven CLI (command-line interface), first test that you have Maven installed:

```
mvn -v
```

Now, once you are in your project directory, you can run any phase in the default build lifecycle using the `mvn` command followed by the phase name. For example, to compile your project, you would run:

```
mvn compile
```

Maven will look for the `pom.xml` file in the current directory and execute the specified phase along with all preceding phases in the build lifecycle.

To execute a specific Maven goal, use the `plugin:goal` syntax. For example, to run the `clean` goal of the `maven-clean-plugin`, you would use the following command:

```
mvn dependency:copy-dependencies
```

```
mvn org.apache.maven.plugins:maven-clean-plugin:clean
```

Multiple phases or goals can be run sequentially by specifying them in the command:

```
mvn clean install
```

**Code Coverage**

One significant feature of Maven is its integration with various plugins that extend its functionality. These plugins enable tasks such as generating documentation, deploying artifacts to repositories, and performing code analysis.

Code coverage is a metric used to measure the percentage of code that is executed during automated testing. It helps assess the effectiveness of test suites by identifying areas of code that are not adequately tested. Higher code coverage generally indicates a more thoroughly tested codebase, which can lead to improved software quality and reliability.
Code coverage tools analyze the relationship between the executed code and the source code to generate reports that highlight which parts of the code were executed during tests and which parts were not.

Maven integrates seamlessly with code coverage tools like JaCoCo (Java Code Coverage) and Cobertura. These tools can be configured as Maven plugins in the `pom.xml` file to automatically generate code coverage reports during the build process.

By adding code coverage plugins to the Maven project configuration, developers can automatically generate detailed code coverage reports that provide insights into the effectiveness of their test suites.

### Real World Application

**The Need for Maven**

Maven is widely used in Java projects to manage dependencies, build processes, and project configurations. Its standardized approach simplifies the development workflow, making it easier for teams to collaborate and maintain their codebases. By leveraging Maven's powerful features, developers can focus on writing high-quality code while ensuring that their projects remain organized and manageable.

Maven helps to download dependencies, which refers to the libraries or JAR files. The tool helps get the right JAR files for each project as there may be different versions of the same library.

After Maven, downloading dependencies does not require visiting the official websites of each library. Instead, Maven automatically resolves and downloads the required dependencies from a central repository, streamlining the process and saving developers time. You can visit mvnrepository.com to find libraries in different languages.

Maven also helps to create the right project structure, servlets, and other boilerplate code. This is especially useful for beginners who may not be familiar with the standard conventions of Java projects. By using Maven, developers can ensure that their projects follow best practices and are organized in a way that is easy to understand and maintain.

**Who is Using Maven?**

There are over 4,000 companies using Maven today. Maven is also used in industries other than computer science, like information technology, financial services, banking, hospitals, and more.

Some of the largest corporations using Maven include:

- Google
- Microsoft
- Amazon
- Netflix
- LinkedIn

### Implementation

Here we will describe the process for installing Maven and take a look at a sample `pom.xml` file.

**Maven `pom.xml` File**

POM (Project Object Model) is the fundamental unit of work in Maven. Maven reads the `pom.xml` file to understand the project structure, dependencies, and build configurations.

Sample `pom.xml` File:

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>my-app</artifactId>
    <version>1.0-SNAPSHOT</version>

    <!-- Add typical dependencies for a web application -->
    <dependencies>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-core</artifactId>
            <version>5.3.8</version>
        </dependency>
    </dependencies>
</project>
```

`pom.xml` tags in detail:

- `<project>`: The root element of the POM file.
- `<modelVersion>`: The version of the POM model being used.
- `<groupId>`: The unique identifier for the project's group.
- `<artifactId>`: The unique identifier for the project.
- `<version>`: The version of the project.
- `<dependencies>`: The section where project dependencies are defined.
- `<dependency>`: A single project dependency.
- `<name>`: The name of the project.
- `<scope>`: The scope of the dependency (e.g., compile, test, provided).
- `<packaging>`: The type of artifact being produced (e.g., jar, war).

**Code Coverage**
Code coverage is a software metric used to measure how many lines of our code are executed during automated tests.

Here we are going to stroll through some practical aspects of using JaCoCo, a code coverage reports generator for Java projects.

**Maven Configuration**

In order to generate code coverage reports using JaCoCo, we need to add the JaCoCo plugin to our `pom.xml` file. Here is an example configuration:

```xml
<plugin>
    <groupId>org.jacoco</groupId>
    <artifactId>jacoco-maven-plugin</artifactId>
    <version>0.8.7</version>
    <executions>
        <execution>
            <goals>
                <goal>prepare-agent</goal>
            </goals>
        </execution>
        <execution>
            <id>report</id>
            <phase>test</phase>
            <goals>
                <goal>report</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

**Code Coverage Reports**
Before we start looking at JaCoCo's code coverage capabilities, we need to a code sample.

Here's a simple Java function that checks whether a string reads the same backward and forward:

```java
public boolean isPalindrome(String str) {
  if (str.length() <= 1) {
    return true;
  }

  char firstChar = str.charAt(0);
  char lastChar = str.charAt(str.length() - 1);

  String mid = str.substring(1, str.length() - 1);

  return (firstChar == lastChar) && isPalindrome(mid);
}
```

Now all we need is a simple JUnit test:

```java
@Test
public void whenEmptyString_thenAccept() {
  Palindrome palindromeTester = new Palindrome();
  assertTrue(palindromeTester.isPalindrome(""));
}
```

Running the test using JUnit will automatically set in motion JaCoCo agent. It will create a coverage report in binary format in the target directory.

Obviously, we cannot interpret the output single-handedly, but other tools and plugins can, e.g. SonarQube.

The good news is that we can use the `jacoco:report` goal to generate a human-readable report in HTML format.

**Report Analysis**

JaCoCo reports help us visually analyze code coverage by using diamonds with colors for branches, and background colors for lines.

- Red diamond: Indicates a branch that was not executed.
- Yellow diamond: Indicates a branch that was partially executed.
- Green diamond: Indicates a branch that was fully executed.
- The same color code applies to the background color, but for lines coverage.

JaCoCo mainly provides three important metrics:

- Lines coverage: the amount of code lines executed by tests based on the number of Java bytecode instructions called.
- Branches coverage: the percentage of branches (e.g., if-else statements) executed by tests.
- Cyclomatic complexity: a software metric used to measure the complexity of a program. It is calculated based on the control flow of the program, specifically the number of linearly independent paths through the code.

Generally, the lower the cyclomatic complexity, the easier the code is to understand and maintain. It also usually reflects the number of test cases we need to implement in order to cover the codebase.

**Concept Breakdown**

JaCoCo runs as a Java agent. It's responsible for instrumenting the bytecode of the classes being tested. JaCoCo drills into each instruction, and shows which lines are executed and which are not during each test.

To gather coverage data, JaCoCo uses ASM (a Java bytecode manipulation framework) for bytecode instrumentation and analysis on the fly, receiving events from the JVM Tool Interface in the process.

It is also possible to run the JaCoCo agent in server mode, which allows it to collect coverage data from multiple JVMs.

**Code Coverage Score**

In a real world project, as developments progresses, we need to keep track of the code coverage score.

JaCoCo offers a simple way of declaring minimum requirements that should be met, otherwise the build fails.

We can to that by adding the following check goal in our `pom.xml` file:

```xml
<execution>
    <id>jacoco-check</id>
    <goals>
        <goal>check</goal>
    </goals>
    <configuration>
      <rules>
        <rule>
          <element>PACKAGE</element>
          <limits>
            <limit>
              <counter>LINE</counter>
              <value>COVEREDRATIO</value>
              <minimum>0.80</minimum>
            </limit>
          </limits>
        </rule>
      </rules>
    </configuration>
</execution>
```

As we can see, we are limiting the minimum score for lines coverage to 80% at the package level.

The `jacoco:check` goal is bound to the `validate` phase of the Maven build lifecycle, so we can run the Maven command `mvn validate` to check if our code coverage meets the specified requirements.
