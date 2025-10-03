# Spring and Spring Boot Basics - Day 2

## Overview of Inversion of Control

Inversion of Control (IoC) is a fundamental principle in software engineering that reverses the traditional flow of control in a program. Instead of the programmer controlling the flow of the application, the control is inverted and handed over to a framework or container. This promotes loose coupling and enhances modularity.

Key points about IoC:

- **Decoupling Dependencies**: IoC aims to decouple components and reduce their direct dependencies, allowing for easier maintenance, testing, and scalability.
- **Dependency Injection (DI)**: IoC relies on Dependency Injection, where the dependencies of a component are provided externally rather than being created within the component itself, typically through constructor injection, setter injection, or interface injection.
- **Loose Coupling**: By removing the responsibility of creating and managing dependencies from the components, IoC promotes loose coupling between components, making it easier to change or replace them without affecting the overall system.
- **Inversion of Control Containers**: IoC containers, such as the Spring Framework or .NET Core's built-in DI container, facilitates IoC by managing the lifecycle of objects, performing dependency injection, and handling other aspects of object creation and configuration.
- **Dependency Inversion Principle**: IoC aligns with the Dependency Inversion Principle, which states that high-level modules should not depend on low-level modules but rather on abstractions. This principle encourages the use of interfaces or abstract classes to define dependencies, allowing for greater flexibility and easier testing.
- **Frameworks and Libraries**: IoC is commonly used in frameworks and libraries to provide a structured way of managing dependencies and promoting modular design. Examples include Spring Framework, Angular, and ASP.NET Core.
- **Benfits**: Inversion of Control offers several benefits, including improved testability, easier maintenance, enhanced flexibility, and better separation of concerns. It allows developers to focus on the business logic of their applications rather than the intricacies of managing dependencies.
- **Application Design Flexibility**: IoC provides flexibility in designing applications, as it allows developers to focus on implementing business logic without being concerned about the instantiation and management of dependencies. This leads to cleaner and more maintainable code.

In summary, Inversion of Control is a powerful design principle that promotes loose coupling, modularity, and flexibility in software development. By leveraging IoC containers and frameworks, developers can create more maintainable and testable applications while adhering to best practices in software design.

### Real World Example

Inversion of Control (IoC) is beneficial in a wide range of real-world applications and scenarios, especially in complex software systems that require modularity, flexibility, and maintainability. Here are some examples of where IoC is commonly applied:

- **Enterprise Applications**: IoC is widely used in enterprise applications, such as customer relationship management (CRM) systems, enterprise resource planning (ERP) systems, and human resource management (HRM) systems. These applications often have complex business logic and require integration with various services and databases. IoC helps manage dependencies and promotes a modular architecture, making it easier to maintain and extend the application over time.
- **Web Applications**: Web applications, ranging from simple websites to large-scale web platforms, benefit from IoC by facilitating the management of various components, such as controllers, services, and repositories. Frameworks like Spring (Java), ASP.NET Core (C#), and Angular (JavaScript) utilize IoC to handle dependency injection and promote a clean separation of concerns.
- **Microservices Architecture**: In a microservices architecture, where applications are composed of small, independent services, IoC helps manage the dependencies between services. Each microservice can be developed, deployed, and scaled independently, and IoC ensures that the services can interact with each other without tight coupling.
- **Test-Driven Development (TDD)**: IoC plays a crucial role in test-driven development by enabling easy substitution of dependencies with mock objects or stubs during testing. By decoupling dependencies, developers can isolate and test individual components without relying on the actual implementations of their dependencies.
- **Plugin and Extension Systems**: IoC is highly valuable in applications that support plugin or extension systems. By employing IoC, the core application can remain agnostic to the specific implementations of plugins, allowing for dynamic loading and management of extensions without modifying the core codebase.
- **GUI Applications**: Graphical User Interface (GUI) applications, such as desktop applications or mobile apps, can benefit from IoC by managing the dependencies between UI components, services, and data models. This promotes a clean separation of concerns and enhances the maintainability of the application.

In summary, Inversion of Control is widely applicable in various real-world scenarios, particularly in complex software systems that require modularity, flexibility, and maintainability. By leveraging IoC principles and frameworks, developers can create robust and scalable applications that are easier to maintain and extend over time.

### Implementation

Below is an example of using Inversion of Control (IoC) and Dependency Injection (DI) in Spring Framework with Java.

- Identify Dependencies: Identify the dependencies within your application that need to be managed and injected, such as services, repositories, or configuration classes.
- Define Interfaces: Create interfaces that represent the contracts for your dependencies. This allows for loose coupling and easier substitution of implementations.

```java
// Example interface
public interface MyDependency {
    void performAction();
}
```

- Implement Interfaces: Create concrete implementations of the interfaces defined in the previous step. These concrete implementations will encapsulate the functionality of the dependencies.

```java
// Example implementation of the dependency/interface
public class MyDependencyImpl implements MyDependency {
  @Override
  public void performAction() {
    System.out.println("Action performed by MyDependencyImpl");
  }
}
```

- Define Injection Points: Identify the points in your application where dependencies need to be injected. Annotate these points accordingly.

```java
// Example injection point in a class constructor
public class MyClass {
  private final MyDependency myDependency;

  public MyClass(MyDependency myDependency) {
    this.myDependency = myDependency;
  }

  // Use the injected dependency within the class
}
```

- Configure IoC Container: Configure the IoC container or framework to manage the lifecycle of your dependencies and perform dependency injection. This can be done either through XML configuration or annotations, depending on the framework you are using.

> Java-based configuration using Spring Framework:

```java
// Example configuration class
@Configuration
public class AppConfig {
  @Bean // Define a bean for MyDependency
  public MyDependency myDependency() {
    return new MyDependencyImpl();
  }
}
```

> XML-based configuration using Spring Framework:

```xml
<!-- Example XML configuration -->
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">
        <!-- Define a bean for MyClass with constructor injection -->
       <bean id="myClass" class="com.example.MyClass">
           <constructor-arg ref="myDependency"/>
        </bean>

        <!-- Define a bean for MyDependency -->
        <bean id="myDependency" class="com.example.MyDependencyImpl"/>
</beans>
```

- Initialize IoC Container: Initialize the IoC container or framework to create and manage the instances of your classes and their dependencies.

```java
public class App {
  public static void main(String[] args) {
    // Initialize the Spring IoC container
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    // Retrieve the MyClass bean from the container
    MyClass myClass = context.getBean(MyClass.class);
  }
}
```

By following these steps, you can implement Inversion of Control and Dependency Injection in your application using the Spring Framework. This approach promotes loose coupling, modularity, and testability, making it easier to manage dependencies and maintain your codebase over time.

## Spring IoC Container

#### Dependency Injection (DI)

Injecting objects into other objects, rather than creating them directly is called Dependency Injection (DI).

#### IoC

In a Spring application, the process of adding dependencies and calling the objects of classes is done in the Spring IoC container, which was traditionally done explicitly by the programmer.

The transfer of control of objects or portions of a program to a container or framework is called Inversion of Control (IoC).

#### Advantages of IoC

- Decoupling the task execution from the implementation.
- Easy switching between different implementations.
- Greater modularity of a program.
- Easy testing of a program by isolating the component or mocking the dependencies.

#### Spring IoC Container

The IoC container is the core container in the Spring Framework that uses Dependency Injection or the IoC principle to implicitly provide an object reference in a class during runtime.

`org.springframework.beans.factory.BeanFactory` is the root interface for accessing the Spring IoC container.

The `BeanFactory` interface is responsible for instantiating, configuring, and assembling the dependencies between these objects.

#### Bean Factory vs Application Context

The `org.springframework.beans` and `org.springframework.context` packages are the basis for the Spring IoC container.

The `ApplicationContext` interface is a sub-interface of the `BeanFactory` interface.

The `BeanFactory` interface provides the configuration framework and basic functionality for managing beans, while the `ApplicationContext` interface adds additional functionality like easy integration with Spring's AOP features, message resource handling (for internationalization), event propagation, and application-layer specific contexts such as the `WebApplicationContext` for web applications.

#### Bean

The object that is instantiated, assembled, and managed by a Spring IoC container is called a Bean. Beans form the backbone of any Spring application.

#### Initializing a Spring IoC Container

The Spring IoC container can be initialized either by the `BeanFactory` or the `ApplicationContext` interface.

> BeanFactory

```java
Resource resource = new FileSystemResource("beans.xml");
BeanFactory factory = new XmlBeanFactory(resource);
MyBean myBean = (MyBean) factory.getBean("myBean");
```

> ApplicationContext

```java
ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml", "applicationContext2.xml"});
```

### Real World Application

The Spring IoC container is used to initialize, assemble, and manage the lifecycle of beans in a Spring application.

Consider classes, `Car` and `Bike`, that implement the `Vehicle` interface. The objects for these classes are initialized, assembled, and managed as Spring beans.

These objects can be injected as dependencies into other classes, such as `Person`, using the Spring IoC container.

Another example, if an HP laptop is a class, the hard drive is an interface. Classes like `SanDisk` and `Toshiba` implement the `HardDrive` interface. `SanDisk` and `Toshiba` are Spring beans that can be injected into the `HP` class using the Spring IoC container.

### Implementation

#### Spring XML Configuration

> The following boilerplate code is added to the `spring.xml` file and can be acquired from the [Spring Documentation](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans).

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">
    <!-- Bean definitions go here -->
</beans>
```

#### Dependency Injection and Bean Definition

> Consider an interface `Vehicle` with an abstract method `drive()` and two classes, `Car` and `Bike`, that implement the `Vehicle` interface.
> The class `App` has the main method that initializes the Spring IoC container and uses dependency injection.
> As both `Car` and `Bike` are vehicles, any of them can be used as a dependency for the `App` class.

```xml
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:context="http://www.springframework.org/schema/context"
    xmlns:aop="http://www.springframework.org/schema/aop"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context-3.0.xsd
    http://www.springframework.org/schema/aop
    http://www.springframework.org/schema/aop/spring-aop-3.0.xsd
    ">
    <bean id="vehicle" class="Revature.Bike"></bean>
</beans>
```

> `App.java` - Main class to initialize the Spring IoC container and retrieve the `Vehicle` bean.

```java
public class App {
    public static void main(String[] args) {
      // Initialize the Spring IoC container
      ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

      // Retrieve the Vehicle bean from the container
      Vehicle obj = (Vehicle) context.getBean("vehicle");
      obj.drive();
    }
}
```

> `Car.java` - Implementation of the `Vehicle` interface.

```java
public class Car implements Vehicle {
  @Override
  public void drive() {
    System.out.println("Driving a car");
  }

  public static void main(String[] args) {
    System.out.println("Car class");
  }
}
```

> `Bike.java` - Implementation of the `Vehicle` interface.

```java
public class Bike implements Vehicle {
  @Override
  public void drive() {
    System.out.println("Riding a bike");
  }
}
```

> `Vehicle.java` - Interface defining the contract for vehicles.

```java
public interface Vehicle {
  void drive();
}
```

#### Output

```
Riding a bike
```

> If the bean definition in the `spring.xml` file is changed to use the `Car` class instead of the `Bike` class, the output will be:

```
Driving a car
```

## Bean Definition and Instantiation

Bean definition and instantiation are core concepts in the Spring Framework, governing the creation, configuration, and lifecycle management of objects known as beans.

Here is a brief overview of bean definition and instantiation in Spring:

- **Bean Definition**: In Spring, a bean is an object that is managed by the Spring IoC container. A bean definition serves as a blueprint for creating and configuring a bean. It specifies the configuration of the bean, including its class type, properties, constructor arguments, and scope.
- **Instantiation**: Bean instantiation refers to the process of creating an instance of a bean based on its bean definition. The Spring IoC container is responsible for instantiating beans when they are requested or when the application context is initialized. Spring provides various ways to instantiate beans such as constructor injection, setter injection, and factory methods.
- **Configuration Options**: Spring offers multiple ways to define and configure beans, including XML configuration files, Java-based configuration using annotations, and programmatic configuration using the `BeanDefinition` API.
- **Bean Scopes**: Beans can have different scopes, which determine their lifecycle and visibility. Common bean scopes include singleton (one instance per container), prototype (a new instance for each request), request (one instance per HTTP request), session (one instance per HTTP session), and application (one instance per application context).
- **Lifecycle Callbacks**: Spring provides lifecycle callbacks that allow developers to define custom initialization and destruction methods for beans. These methods can be specified in the bean definition and are invoked by the container at appropriate times during the bean's lifecycle.
- **Dependencies**: Beans often depend on other beans to fulfill their functionality. Spring facilitates dependency injection, allowing beans to declare their dependencies, which are then automatically resolved and injected by the IoC container.
- **Lazy Initialization**: Beans can be configured for lazy initialization, meaning they are not instantiated until they are first requested. This can help improve application startup time and resource utilization.
- **Advanced Features**: Spring provides advanced features for bean definition and instantiation, such as conditional bean creation, profile-based configuration, and support for custom scopes.
- **Bean Naming and Aliases**: Each bean can be assigned a unique name or identifier, which is used to reference the bean within the application context. Additionally, beans can have aliases, allowing multiple names to refer to the same bean instance.

By understanding bean definition and instantiation in Spring, developers can effectively manage the lifecycle of their application components, promote loose coupling, and leverage the powerful features provided by the Spring Framework for building robust and maintainable applications.

#### Bean Definition

The `BeanDefinition` objects contain the following metadata about a bean:

> **Class**: The name of the class that instantiates the bean.

```xml
<bean id="bean1" class="com.example.MyClass"/>
```

This will create an instance of `MyClass` when the bean is requested.

> **Name**: The unique identifier for the bean within the Spring IoC container. The name should start with a lowercase letter and be followed by camel case.

- **id**: The `id` attribute is a unique identifier for the bean within the Spring IoC container.
- **name**: The `name` attribute is used to provide multiple aliases for the bean. It can contain multiple names separated by commas, semicolons, or spaces.

```xml
<bean id="bean1" class="com.example.MyClass" name="myClassBean"/>
```

> **Alias**: An alternative name for the bean, allowing it to be referenced by multiple names.

```xml
<alias name="myClassBean" alias="myAlias"/>
```

> **Scope**: The scope of the bean defines its lifecycle and visibility. Common scopes include: singleton, prototype, request, session, and application.

```xml
<bean id="bean1" class="com.example.MyClass" scope="singleton"/>
```

### Real World Example

The concept of bean definition and instantiation in Spring finds practical application in various real-world scenarios, providing flexibility and modularity to software development. Here are some examples of how bean definition and instantiation are used in real-world applications:

- **Enterprise Applications**: Bean definition and instantiation are commonly used in enterprise applications to define and configure various components, such as services, repositories, data access objects, and business logic beans. This approach allows for easy management of dependencies and promotes a modular architecture, making it easier to maintain and extend the application over time.
- **Web Applications**: Web applications leverage bean definition and instantiation for configuring controllers, services, and repositories. THis enables separation of concerns and facilitates the integration of different layers withing the application.
- **Microservices Architecture**: In a microservices architecture, bean definition and instantiation are used to define and configure individual microservices as independent components. Each microservice can have its own set of beans, allowing for independent development, deployment, and scaling.
- **Testing and Mocking**: By defining beans for mock or stub implementations, developers can easily swap real dependencies with test doubles, enabling comprehensive unit testing and promoting test-driven development (TDD).
- **Dynamic Plugin Systems**: Applications that support dynamic plugin systems can use bean definition and instantiation to load and manage plugins at runtime. This allows for extensibility and customization without modifying the core application code.
- **Command-Line Tools**: Command-line tools and utilities can utilize bean definition and instantiation to configure various components, such as parsers, processors, and output handlers, allowing for flexible and reusable code.
- **Integration with External Systems**: Bean definition and instantiation are often used in integration with external systems, such as databases, messaging systems, and third-party APIs. By defining beans for these integrations, developers can easily manage connections and configurations.
- **Desktop Applications**: Bean definition and instantiation are also applicable in desktop applications, where components such as UI controllers, services, and data models can be defined as beans, promoting a clean separation of concerns and enhancing maintainability.

These are just a few examples of how bean definition and instantiation in Spring are applied in real-world scenarios. By leveraging these concepts, developers can create flexible, modular, and maintainable applications that are easier to manage and extend over time.

### Implementation

- Create a Java Project: Set up a new Java project using your preferred IDE (e.g., Eclipse, IntelliJ) or build tool (e.g., Maven, Gradle).
- Add Spring Dependencies: Include the necessary Spring Framework dependencies in your project. If you're using Maven, add the following dependencies to your `pom.xml` file:

```xml
<!-- Maven dependency example -->
<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.3.10</version>
    </dependency>
    <!-- Include other dependencies as required -->
</dependencies>
```

- Define a Bean: Create a class that you want to manage as a bean. Add the appropriate annotations to mark it as a Spring bean, such as `@Component`, `@Service`, or `@Repository`.

```java
@Component
public class MyBean {
  // Bean implementation code
}
```

- Configure Component Scanning: Enable component scanning in your Spring configuration to automatically detect and register beans. This can be done using Java-based configuration or XML configuration.

> Java-based configuration using annotations:

```java
@Configuration
@ComponentScan(basePackages = "com.example")
public class AppConfig {
  // Additional configuration code
}
```

- Create an Application Context: Initialize the Spring IoC container by creating an application context. This can be done using `AnnotationConfigApplicationContext` for Java-based configuration or `ClassPathXmlApplicationContext` for XML configuration.

```java
public class App {
  public static void main(String[] args) {
    // Initialize the Spring IoC container
    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    // Application logic
  }
}
```

- Retrieve and Use Beans: Use the application context to retrieve and use the defined beans in your application.

```java
MyBean myBean = context.getBean(MyBean.class);
myBean.performAction();
```

By following these steps, you can define and instantiate beans in a Spring application, leveraging the powerful features of the Spring Framework for managing dependencies and promoting modular design.

## Video - Spring Beans - Wiring

### General Information

- To create a Spring Bean, we create a method annotated with `@Bean` inside a class annotated with `@Configuration`.
- The method name is the bean name, and the return type is the bean type.
- It should return an instance of the object to be managed as a bean.
- By default the name of the bean is the method name, but we can specify a different name using the `name` attribute of the `@Bean` annotation.

```java
@Bean(name="myBeanName")
public MyBean myBean() {
    return new MyBean();
}
```

### Bean Scope

- The scope of a bean defines its lifecycle and visibility.
- The scope of the beans determines the number of instances created by the container and how long they are retained.
  - Whenever you need a bean from the container, it checks the scope of the bean to decide whether to create a new instance or return an existing one.
- The default scope of a bean is `singleton`, which means that only one instance of the bean is created and shared across the application.
- A bean can have 1 of 5 scopes, three of which are only available in a web-aware Spring ApplicationContext:
  - `singleton`: A single instance of the bean is created, shared, and returns the same instance every time it is requested.
  - `prototype`: A new instance of the bean is created each time it is requested.
  - `request`: A new instance is created for each HTTP request (web-aware scope).
  - `session`: A new instance is created for each HTTP session (web-aware scope).
  - `application`: A single instance is created for the entire application (web-aware scope).
- The scope of a bean can be specified using the `@Scope` annotation.

```java
@Bean
@Scope("prototype")
public MyBean myBean() {
    return new MyBean();
}
```

### Initialization and Destruction Methods

- The initialization method is called after the bean is created and all its properties are set.
- The destruction method is called before the bean is destroyed.
- Use the `initMethod` and `destroyMethod` attributes of the `@Bean` annotation to specify the initialization and destruction methods that the container should call.

```java
@Bean(initMethod = "init", destroyMethod = "cleanup")
public MyBean myBean() {
    return new MyBean();
}
```

- The name you provide for the `initMethod` and `destroyMethod` attributes should match the method names in the bean class.

```java
public class MyBean {
    public void init() {
        // Initialization logic
    }
    public void cleanup() {
        // Cleanup logic
    }
}
```

- These methods must be public, take no arguments, and return void.
- Note: only singleton-scoped beans have their destruction methods called by the container. For prototype-scoped beans, the container does not manage their lifecycle beyond instantiation and dependency injection.

## Bean Lifecycle

The lifecycle of a Spring bean refers to the various stages that a bean goes through from its creation to its destruction within the Spring IoC container.

The lifecycle of a Spring bean typically includes the following stages:

- Spring IoC Container starts
- Bean instance is created
- Dependencies are injected (Dependency Injection)
- Internal Spring processing (e.g., AOP proxies, lifecycle callbacks)
- Custom initialization methods are called
- Container shuts down
- Custom destruction methods are called

#### Custom Init Method

In any Spring application, for most classes, some methods should be implemented before the main logic of the class is executed. For example, in a database connection class, a method to establish a connection to the database should be executed before any other method.

Method calls for these methods are grouped in the custom `init` method.

With the help of Spring, the `init` method can be invoked automatically after the bean is instantiated and dependencies are injected.

#### Custom Destroy Method

After executing the `init` method and the main logic of the class, before shutdown of the container, the custom `destroy` method is invoked to release resources or perform cleanup tasks.

Similar to the `init` method, the destroy methods of the beans are grouped in the custom `destroy` method.

With the help of Spring, the `destroy` method can be invoked automatically before the bean is destroyed.

#### Configuration

The configuration for the custom `init` and `destroy` methods can be done in three ways:

- XML Configuration
- Annotations
- Interface configuration

Note: The interface configuration method is not recommended or commonly used.

### Real World Example

An object for a class that is instantiated, assembled, and managed by the Spring IoC container is called a Spring Bean.

Consider a DAO (Data Access Object) class with a JDBC connection to a database. In the bean lifecycle, the first process is bean initialization. The second step is dependency injection, where the JDBC connection is injected into the DAO class. The third step is the custom `init` method, which establishes the connection to the database. Creating the connection is a common and repeated step when using JDBC; this can be added to the custom `init` method.
The next step is bean execution, where the main logic of the DAO class is executed. Operations like fetching and manipulating data from the database are performed in this step. The next step is container shutdown, where the Spring IoC container is shut down. Before the container is shut down, the custom `destroy` method is invoked to close the database connection and release resources. Finally, the container is completely shut down.

### Implementation

In this example, we will be working with a `Student` entity and database. We have a `StudentDAO` class allows the application to connect to the database and perform operations related to the `Student` entity. We also have an XML file for configuring our Spring beans.

#### Setting Up Our Files

> `Student.java` - Entity class representing a student.

```java
public class Student {
  private int id;
  private String firstName;
  private String lastName;
  private String major;

  // ...other methods omitted for brevity
}
```

> `StudentDAO.java` - Data Access Object class for managing student data.

```java
package studentdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import javax.annotation.PostConstruct; // For custom init method
import javax.annotation.PreDestroy; // For custom destroy method

public class StudentDAO {
  static String driver;
  static Connection conn;
  static String url;
  static String username;
  static String password;

  static void createConnection() throws ClassNotFoundException, SQLException {
    Class.forName(driver); // Load the JDBC driver using the driver class name
    conn = DriverManager.getConnection(url, username, password); // Establish the connection
    System.out.println("Connection established successfully");
  }

  static void closeConnection() throws SQLException {
    if (conn != null && !conn.isClosed()) {
      conn.close(); // Close the connection
      System.out.println("Connection closed successfully");
    }
  }

  void getAllRecords() throws SQLException {
    String sql = SELECT * FROM students;
    PreparedStatement ps = conn.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();

    while (rs.next()) {
      System.out.println("ID: " + rs.getInt(1) + ", Name: " + rs.getString(2) + " " + rs.getString(3) + ", Major: " + rs.getString(4));
    }
  }
}
```

The bean configuration for the `StudentDAO` class is done in the `beans.xml` file.

> `beans.xml` - Spring bean configuration file.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:context="http://www.springframework.org/schema/context"
    xmlns:aop="http://www.springframework.org/schema/aop"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context-3.0.xsd
    http://www.springframework.org/schema/aop
    http://www.springframework.org/schema/aop/spring-aop-3.0.xsd">
    <bean id="StudentDAO" class="StudentData.StudentDAO"></bean>
</beans>
```

#### Setting Up Injection

Fields like driver name, URL, username, and password can be considered properties to be injected into the `StudentDAO` class. To do this, setter and getter methods are created for each property in the `StudentDAO` class. A print statement is added in every setter method to confirm that the property has been injected.

```java
public void setDriver(String driver) {
    this.driver = driver;
    System.out.println("Driver property injected: " + driver);
}
public String getDriver() {
    return driver;
}
public void setUrl(String url) {
    this.url = url;
    System.out.println("URL property injected: " + url);
}
public String getUrl() {
    return url;
}
public void setUsername(String username) {
    this.username = username;
    System.out.println("Username property injected: " + username);
}
public String getUsername() {
    return username;
}
public void setPassword(String password) {
    this.password = password;
    System.out.println("Password property injected: " + password);
}
public String getPassword() {
    return password;
}
```

In the `beans.xml` file, the properties are injected using the `<property>` tag inside the `<bean>` tag. We add the value for each property which will be injected into the `StudentDAO` class.

```xml
<bean id="StudentDAO" class="StudentData.StudentDAO">
    <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
    <property name="url" value="jdbc:mysql://localhost:3306/school"/>
    <property name="username" value="root"/>
    <property name="password" value="password"/>
</bean>
```

So now, when the `StudentDAO` bean is created, the properties will be injected, and the print statements in the setter methods will confirm that the properties have been injected successfully. Being that is injected, the properties will not change unless explicitly modified.

#### Setting Up Custom Init and Destroy Methods

The process of creating a connection to the database is common and repeated for every method that interacts with the database. If new methods like `getRecordById()` or `deleteRecord()` are added to the `StudentDAO` class, the connection creation code would need to be repeated in each of those methods. To avoid this redundancy, a new method for connection is created and named `init()`. This method will be called automatically after the bean is instantiated and all properties are injected.

```java
// Inside StudentDAO class
void init() throws ClassNotFoundException, SQLException {
    createConnection(); // Call the method to create the connection
    System.out.println("Custom init method called - Connection created");
}
```

The process of closing the connection to the database is also common and repeated. To avoid this redundancy, a new method for closing the connection is created and named `destroy()`. This method will be called automatically before the bean is destroyed.

```java
// Inside StudentDAO class
void destroy() throws SQLException {
    closeConnection(); // Call the method to close the connection
    System.out.println("Custom destroy method called - Connection closed");
}
```

#### Using Annotations Configuration

##### Configuring the Custom Init Method

`@PostConstruct` is an annotation used to specify a method that should be executed after the bean's properties have been set and the bean has been fully initialized. This annotation is part of the `javax.annotation` package.

Before using annotations, `<context:annotation-config/>` or `<bean class="org.springframework.context.annotation.CommonAnnotationBeanPostProcessor"/> ` must be added to the `beans.xml` file to enable support for common annotations like `@PostConstruct` and `@PreDestroy`.

> `StudentDAO.java` - Updated with `@PostConstruct` annotation.

```java
@PostConstruct
void init() throws ClassNotFoundException, SQLException {
    createConnection(); // Call the method to create the connection
    System.out.println("Custom init method called - Connection created");
}
```

##### Configuring the Custom Destroy Method

`@PreDestroy` is an annotation used to specify a method that should be executed before the bean is destroyed. In a web application, the application context is closed implicitly, but in a desktop application, the application context must be closed explicitly to ensure that the `@PreDestroy` method is called.
This annotation is also part of the `javax.annotation` package.

> `StudentDAO.java` - Updated with `@PreDestroy` annotation.

```java
@PreDestroy
void destroy() throws SQLException {
    closeConnection(); // Call the method to close the connection
    System.out.println("Custom destroy method called - Connection closed");
}
```

---

By using the below Java code, the application context is closed:

```java
((AbstractApplicationContext) context).close();
```

What this does is cast the `ApplicationContext` to an `AbstractApplicationContext`, which has the `close()` method. This ensures that the `@PreDestroy` method is called before the application context is closed.

A lifecycle hook `registerShutdownHook()` can also be used to destroy the beans when the JVM shuts down. `registerShutdownHook()` is preferred over `context.close()` because it is called once the main thread ends and closes the container. So irrespective of the line where `registerShutdownHook()` is placed, a new `getBean()` can be called anywhere in the main method, and the bean will be destroyed when the main thread ends.

> `registerShutdownHook()` - Using the lifecycle hook to destroy beans.

```java
((AbstractApplicationContext) context).registerShutdownHook();
```

What this does is register a shutdown hook with the JVM runtime, which ensures that the `close()` method of the `AbstractApplicationContext` is called when the JVM shuts down. This will trigger the destruction of all singleton beans in the application context, including calling any `@PreDestroy` methods.

#### XML Configuration

For XML-based configuration, rather than using `@PostConstruct` and `@PreDestroy` annotations, the `init-method` and `destroy-method` attributes are added to the `<bean>` tag in the `beans.xml` file to specify the custom initialization and destruction methods.

```xml
<bean id="studentDAO" class="com.example.StudentDAO" init-method="init" destroy-method="destroy"/>
```

If there are multiple classes, the init and destroy methods are standardized to `init` and `destroy` respectively, and `default-init-method` and `default-destroy-method` attributes are added to the `<beans>` tag in the `beans.xml` file.

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans.xsd"
    default-init-method="init" default-destroy-method="destroy">
    <!-- Bean definitions go here -->
</beans>
```

#### Interface Configuration

The `InitializingBean` and `DisposableBean` interfaces can be implemented in the bean class to define custom initialization and destruction methods. The `afterPropertiesSet()` method of the `InitializingBean` interface and the `destroy()` method of the `DisposableBean` interface are overridden to provide the custom logic.

> `StudentDAO.java` - Implementing `InitializingBean` and `DisposableBean` interfaces.

```java
public class StudentDAO implements InitializingBean, DisposableBean {
  static String driver;
  static Connection conn;
  static String url;
  static String username;
  static String password;

  public static void setDriver(String driver) {
    this.driver = driver;
    System.out.println("Driver property injected: " + driver);
  }
  public static String getDriver() {
    return driver;
  }
  public static void setUrl(String url) {
    this.url = url;
    System.out.println("URL property injected: " + url);
  }
  public static String getUrl() {
    return url;
  }
  public static void setUsername(String username) {
    this.username = username;
    System.out.println("Username property injected: " + username);
  }
  public static String getUsername() {
    return username;
  }
  public static void setPassword(String password) {
    this.password = password;
    System.out.println("Password property injected: " + password);
  }
  public static String getPassword() {
    return password;
  }

  static void createConnection() throws ClassNotFoundException, SQLException {
    Class.forName(driver); // Load the JDBC driver using the driver class name
    conn = DriverManager.getConnection(url, username, password); // Establish the connection
    System.out.println("Connection established successfully");
  }

  // Custom initialization method
  void init() throws ClassNotFoundException, SQLException {
      createConnection(); // Call the method to create the connection
      System.out.println("Custom init method called - Connection created");
  }

  static void closeConnection() throws SQLException {
    if (conn != null && !conn.isClosed()) {
      conn.close(); // Close the connection
      System.out.println("Connection closed successfully");
    }
  }

  // Custom destruction method
  void destroy() throws SQLException {
    closeConnection(); // Call the method to close the connection
    System.out.println("Custom destroy method called - Connection closed");
  }

  void getAllRecords() throws SQLException {
    String sql = "SELECT * FROM students";
    PreparedStatement ps = conn.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();

    while (rs.next()) {
      System.out.println("ID: " + rs.getInt(1) + ", Name: " + rs.getString(2) + " " + rs.getString(3) + ", Major: " + rs.getString(4));
    }
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    init(); // Call the custom init method
    System.out.println("Custom afterPropertiesSet method called");
  }

  @Override
  public void destroy() throws Exception {
    destroy(); // Call the custom destroy method
    System.out.println("Custom destroy method called from DisposableBean");
  }
}
```

The output of the above code will be:

```
Driver property injected: com.mysql.cj.jdbc.Driver
URL property injected: jdbc:mysql://localhost:3306/school
Username property injected: root
Password property injected: password
Connection established successfully
Custom init method called - Connection created
Custom afterPropertiesSet method called
ID: 1, Name: John Doe, Major: Computer Science
ID: 2, Name: Jane Smith, Major: Mathematics
Connection closed successfully
Custom destroy method called - Connection closed
Custom destroy method called from DisposableBean
```

## Scopes of Spring Beans

The scope of a bean defines its lifecycle and visibility within the Spring IoC container. The scope determines how many instances of a bean are created and how long they are retained.

#### Bean Scopes

Spring provides several built-in scopes for beans, each with its own characteristics and use cases:

- **Singleton**
  - This is the default scope of a bean in Spring.
  - In this scope, only one instance of the bean is created and shared across the entire application context.
  - It is defined explicitly by using the `@Scope("singleton")` annotation or the enum value `ConfigurableBeanFactory.SCOPE_SINGLETON`, or by setting the `scope` attribute to `singleton` in the XML configuration.
  - All requests for that bean name will return the same instance, which is cached by the container.
  - Any modifications made to that bean will be reflected in all references to that bean.
- **Prototype**
  - In this scope, a new instance of the bean is created each time it is requested from the container.
  - It is defined explicitly by using the `@Scope("prototype")` annotation or the enum value `ConfigurableBeanFactory.SCOPE_PROTOTYPE`, or by setting the `scope` attribute to `prototype` in the XML configuration.
  - A prototype-scoped bean is not initialized by Spring IoC container until it is requested.
  - If a singleton class has a dependency on a prototype bean, the prototype bean will be created only once when the singleton is created, and the same instance will be shared across all requests to the singleton. This can be avoided by using an `AOP` proxy and `@Lookup` annotation or `ObjectFactory` or `Provider` injection.

##### Web-Aware Scopes

These scopes are only available in a web-aware Spring ApplicationContext, such as `WebApplicationContext`.

- **Request**
  - In this scope, a new instance of the bean is created for each HTTP request.
  - It is defined explicitly by using the `@Scope("request")` annotation or the enum value `WebApplicationContext.SCOPE_REQUEST`, or by setting the `scope` attribute to `request` in the XML configuration.
  - The bean is only valid for the duration of the HTTP request and is destroyed once the request is completed.
- **Session**
  - In this scope, a new instance of the bean is created for each HTTP session.
  - It is defined explicitly by using the `@Scope("session")` annotation or the enum value `WebApplicationContext.SCOPE_SESSION`, or by setting the `scope` attribute to `session` in the XML configuration.
  - The bean is valid for the duration of the HTTP session and is destroyed once the session is invalidated or expires.
- **Application**
  - In this scope, a single instance of the bean is created for the entire application.
  - It is defined explicitly by using the `@Scope("application")` annotation or the enum value `WebApplicationContext.SCOPE_APPLICATION`, or by setting the `scope` attribute to `application` in the XML configuration.
  - The bean is shared across all requests and sessions within the application context and is destroyed when the application context is closed.
- **WebSocket**
  - In this scope, a new instance of the bean is created for each WebSocket session.
  - It is defined explicitly by using the `@Scope("websocket")` annotation or the enum value `WebSocketScope.SCOPE_WEBSOCKET`, or by setting the `scope` attribute to `websocket` in the XML configuration.
  - The bean is valid for the duration of the WebSocket session and is destroyed once the session is closed.

### Real World Example

Singleton scope is used for stateless beans (business logic), and prototype scope is used for stateful beans (business logic and state).

Request scope is used for web applications where a new instance of the bean is required for each HTTP request.

Session scope is used for web applications where a new instance of the bean is required for each HTTP session.

Application scope is used for web applications where a single instance of the bean is required for the entire application.

WebSocket scope is used for web applications that use WebSocket communication, where a new instance of the bean is required for each WebSocket session.

### Implementation

#### Singleton Scope

A class named `Singleton` is created with singleton scope:

> `Singleton.java`

```java
package com.bean.app;

@Component
public class Singleton {
  Singleton() {
    System.out.println("Singleton instance created");
  }
}
```

> `App.java`

```java
package com.bean.app;

public class App {
  public static void main(String[] args) {
    // Assuming we specified our bean configuration in an XML file named "spring.xml"
    ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    Singleton s1 = (Singleton) context.getBean("singleton");
    Singleton s2 = (Singleton) context.getBean("singleton");

    System.out.println(s1 == s2); // true
  }
}
```

#### Prototype Scope

A class named `Prototype` is created with prototype scope:

> `Prototype.java`

```java
package com.bean.app;

@Component
@Scope("prototype")
public class Prototype {
  Prototype() {
    System.out.println("Prototype instance created");
  }

  void printMessage() {
    System.out.println("Hello from Prototype bean");
  }
}
```

> `App.java`

```java
package com.bean.app;

public class App {
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    Prototype p1 = (Prototype) context.getBean("prototype");
    Prototype p2 = (Prototype) context.getBean("prototype");

    System.out.println(p1 == p2); // false
  }
}
```

#### Injecting Prototype Dependency into Singleton

When a singleton bean has a dependency on a prototype bean, the prototype bean will be created only once when the singleton is created, and the same instance will be shared across all requests to the singleton.

> `SingletonWithPrototype.java`

```java
package com.bean.app;

@Component
// @Scope("singleton")
// We don't need to specify scope here as singleton is the default scope
public class SingletonWithPrototype {
  @Autowired
  private Prototype prototype;

  public Prototype getPrototype() {
    return prototype;
  }

  public void setPrototype(Prototype prototype) {
    this.prototype = prototype;
  }

  SingletonWithPrototype() {
    System.out.println("SingletonWithPrototype instance created");
  }

  void printMessage() {
    System.out.println("Hello from SingletonWithPrototype bean");
  }
}
```

> `App.java`

```java
package com.bean.app;

public class App {
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    SingletonWithPrototype sp1 = (SingletonWithPrototype) context.getBean("singletonWithPrototype");
    SingletonWithPrototype sp2 = (SingletonWithPrototype) context.getBean("singletonWithPrototype");

    System.out.println(sp1 == sp2); // true
    System.out.println(sp1.getPrototype() == sp2.getPrototype()); // true
  }
}
```

#### Using AOP Proxy to Inject Prototype Bean into Singleton Bean

An AOP proxy is a design pattern used in Aspect-Oriented Programming (AOP) to create a proxy object that wraps around a target object. This proxy object intercepts method calls to the target object and allows additional behavior to be added before or after the method execution, such as logging, security checks, or transaction management.

When using an AOP proxy, the proxy object is created instead of the actual target object. The proxy object implements the same interface as the target object and delegates method calls to the target object while adding additional behavior.

> `PrototypeWithAOPProxy.java`

```java
package com.bean.app;

@Component
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS) // Using AOP proxy
public class PrototypeWithAOPProxy {
  PrototypeWithAOPProxy() {
    System.out.println("PrototypeWithAOPProxy instance created");
  }

  void printMessage() {
    System.out.println("Hello from PrototypeWithAOPProxy bean");
  }
}
```

#### Using `@Lookup` Annotation to Inject Prototype Bean into Singleton Bean

The `@Lookup` annotation is used in Spring Framework to indicate that a method should be overridden by the Spring container to return a bean from the application context. This is particularly useful when you want to inject a prototype-scoped bean into a singleton-scoped bean.

When a method is annotated with `@Lookup`, Spring will create a proxy for that method, and when the method is called, it will look up the bean in the application context and return a new instance of the bean each time it is called.

> `SingletonWithLookup.java`

```java
package com.bean.app;

@Component
public class SingletonWithLookup {
  @Autowired
  private Prototype prototype;

  @Lookup
  public Prototype createPrototype() {
    // Spring will override this method to return a new instance of Prototype bean
    return null; // This implementation will be ignored by Spring
  }

  public Prototype getPrototype() {
    return prototype;
  }

  public void setPrototype(Prototype prototype) {
    this.prototype = prototype;
  }

  SingletonWithLookup() {
    System.out.println("SingletonWithLookup instance created");
  }

  void printMessage() {
    System.out.println("Hello from SingletonWithLookup bean");
  }
}
```

> `App.java`

```java
package com.bean.app;

public class App {
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    SingletonWithLookup sl1 = (SingletonWithLookup) context.getBean("singletonWithLookup");
    SingletonWithLookup sl2 = (SingletonWithLookup) context.getBean("singletonWithLookup");

    System.out.println(sl1 == sl2); // true
    System.out.println(sl1.createPrototype() == sl2.createPrototype()); // false
  }
}
```

## Lombok Library

Lombok is a Java library that helps to reduce boilerplate code by generating commonly used methods and constructors at compile time using annotations. It simplifies the code and improves readability by eliminating the need to write repetitive code manually.

It provides a set of annotations that can be added to your Java classes to automatically generate code for common tasks such as:

- Getters and Setters
- Constructors
- `toString()`, `equals()`, and `hashCode()` methods
- Logging
- Builders
- And more

Lombok works by plugging into the build process and auto-generating Java bytecode into the `.class` files. This means that the generated code is not visible in the source code but is present in the compiled bytecode.

#### Features of Lombok

- **Getters, Setters, and Constructors**: In many IDEs, you can generate getters, setters, and constructors automatically. However, the code is present in the class, and if a new field is added, the getters and setters can be forgotten. Lombok provides annotations like `@Getter`, `@Setter`, and `@AllArgsConstructor` to automatically generate these methods, reducing the chances of human error.
  - `@Getter` and `@Setter`: Generates getter and setter methods for all fields in the class.
  - **Lazy Getters**: By default, Lombok generates getters for all fields. However, if you want to generate a getter for a specific field only when it is accessed, you can use the `@Getter(lazy=true)` annotation. This will create a lazy-initialized getter that initializes the field only when it is accessed for the first time. Why is this useful? It can help improve performance by avoiding unnecessary object creation and initialization until the field is actually needed.
  - `@AllArgsConstructor`: Generates a constructor with parameters for all fields in the class.
  - `@NoArgsConstructor`: Generates a no-argument constructor.
  - `@RequiredArgsConstructor`: Generates a constructor with parameters for all final fields and fields marked with `@NonNull`.
- **Core Java Methods**: Lombok provides annotations like `@ToString`, `@EqualsAndHashCode`, and `@Data` to automatically generate these commonly used methods.
- **Value Classes/DTOs**: In some situations, a data type is defined to represent complex values as Data Transfer Objects (DTOs). In most cases. these are immutable objects. Instead of adding the code for the constructor to take all the fields and check that they are not null, Lombok annotations like `@RequiredArgsConstructor` and `@NonNull` can be used to generate the constructor and null checks automatically.
- **Configuring API**: Instead of providing getters, setters, and constructors, Lombok provides a `@Builder` annotation to implement the Builder design pattern. This allows for more readable and maintainable code when creating complex objects with many fields.
- **Checked Exceptions**: Instead of using catch blocks or throws, Lombok provides the `@SneakyThrows` annotation to handle checked exceptions without explicitly declaring them in the method signature. This can help reduce boilerplate code and improve readability.
- **Logging**: Lombok provides annotations like `@Log`, `@Slf4j`, and others to automatically generate logging code for your classes. This can help reduce boilerplate code and improve readability.
- **Closing Resources**: The `@Cleanup` annotation can be used to automatically close resources like streams, readers, and writers. It is a good alternative for `try-with-resources` statements and the `close()` method of Spring's `DisposableBean` interface.
- **Thread Safety**: The `@Synchronized` annotation can be used to make methods thread-safe by synchronizing access to them. It us used to get an auto-generated, private, unexposed field to lock on, instead of locking on `this`, which can be a security risk.

### Real World Example

In any application, entities need setters, getters, or constructors to access or modify the fields of the class. Consider an entity class, `Student`, with fields like `id`, `firstName`, `lastName`, and `major`. All these fields need getters and setters to access and modify their values.

The process of generating getters and setters and maintaining those methods can be tedious and error-prone, especially when the class has many fields. Lombok can be used to automatically generate these methods, reducing boilerplate code and improving readability.

### Implementation

Below is an of using Lombok in a `Student` entity class.

#### Adding Lombok Dependency

The Lombok dependency can be added to the `pom.xml` file for Maven projects:

```xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.24</version>
    <scope>provided</scope>
</dependency>
```

#### Using Lombok

> `Student.java` - Using Lombok annotations.

```java
package com.student.entity;

import lombok.*;

@Entity // JPA annotation to mark this class as a database entity
@Getter // Lombok annotation to generate getters for all fields
@Setter // Lombok annotation to generate setters for all fields
@NoArgsConstructor // Lombok annotation to generate a no-argument constructor
public class Student {
  @Id // JPA annotation to mark this field as the primary key
  public String studentId;
  public String firstName;
  public String lastName;
  public String major;

  public Student(String studentId, String firstName, String lastName, String major) {
    this.studentId = studentId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.major = major;
  } // This can be replaced with @AllArgsConstructor
}
```

The getters, setters, and no-argument constructor will be automatically generated by Lombok at compile time.

The `@Id` and `@Entity` annotations are from JPA (Java Persistence API) and are used to mark the class as a database entity and the `studentId` field as the primary key. Is it necessary to add `@Id` and `@Entity` annotations? Yes, if you are using JPA to map the `Student` class to a database table, these annotations are necessary. The `@Entity` annotation tells JPA that this class should be treated as a database entity, and the `@Id` annotation specifies which field is the primary key for the entity.

#### Lazy Getters

> `StudentWithLazyGetter.java` - Using Lombok lazy getter.

```java
package com.student.entity;

import lombok.*;

@Entity // JPA annotation to mark this class as a database entity
@Getter(lazy=true) // Lombok annotation to generate lazy getters for all fields
@Setter // Lombok annotation to generate setters for all fields
@NoArgsConstructor // Lombok annotation to generate a no-argument constructor
@AllArgsConstructor // Lombok annotation to generate an all-argument constructor
public class StudentWithLazyGetter {
  @Id // JPA annotation to mark this field as the primary key
  public String studentId;
  public String firstName;
  public String lastName;
  public String major;
}
```

The getters will be generated as lazy-initialized getters, which means that the fields will only be initialized when they are accessed for the first time. This can help improve performance by avoiding unnecessary object creation and initialization until the field is actually needed.
