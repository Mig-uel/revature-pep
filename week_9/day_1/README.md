# Spring and Spring Boot Basics - Day 1

## Introduction to Spring

The Spring Framework is a powerful, feature-rich framework for building Java applications. It provides comprehensive infrastructure support for developing Java applications, making it easier to manage your application's components and dependencies.

As a developer, handling business logic is your primary focus when compared to managing the underlying infrastructure. With Spring, a developer can focus on writing business logic while the framework takes care of the infrastructure.

Spring helps to build applications using plain old Java objects (POJOs) and provides a consistent way to manage business objects and encourages good design practices such as loose coupling through dependency injection and aspect-oriented programming.

#### Advantages of Spring Framework

- **Use of POJOs**: The Spring Framework helps developers develop enterprise applications using POJOs, which are simple Java objects not bound by any special restriction other than those forced by the Java Language Specification. An enterprise container like an application server is not required to run POJOs.
- **Flexibility for Configuration**: Spring provides both XML-based configuration and Java-based annotations for configuring application components.
- **No Need for a Server**: The Spring Framework provides a lightweight container that can be activated without any web server or application server.
- **No Need for Reinvention**: Spring uses technologies such as JDK timers, ORM frameworks, Java EE, etc. Developers do not need to reinvent the wheel.
- **Modular Architecture**: The Spring Framework provides a modular architecture that allows developers to use only the parts they need without having to bring in the entire framework. Developers can choose to use the entire Spring Framework or just a few modules.
- **Ease of Testing**: Spring Dependency Injection (DI) simplifies the injection of test data by using JavaBean objects. This makes it easier to test components in isolation.
- **Inversion of Control (IoC) and APIs**: The Spring Framework provides inversion of control (IoC) and various APIs to translate exceptions thrown by JDBC and Hibernate into unchecked and consistent exceptions.

#### Spring Modules

Features of the Spring Framework are organized into 20+ modules.

The Spring modules are grouped into the following categories:

- **Core Container**: This is the fundamental part of the Spring Framework. It provides the basic functionality of the framework, including the IoC and Dependency Injection (DI) features.
- **Data Access/Integration**: This category includes modules that provide support for data access and integration with various data sources, such as JDBC, ORM frameworks (like Hibernate), and transaction management.
- **Web**: This category includes modules that provide support for building web applications, including Spring MVC, WebSocket, and RESTful web services.
- **AOP (Aspect-Oriented Programming)**: This module provides support for aspect-oriented programming, allowing developers to separate cross-cutting concerns from business logic.
- **Testing**: This module provides support for testing Spring applications, including support for unit testing and integration testing.
- **Instrumentation**: This module provides support for class instrumentation and classloader implementations to be used in certain application servers.

#### Spring Core Module

The Spring Core module follows the principle of Inversion of Control (IoC), where the control of object creation and lifecycle management is transferred from the application code to the Spring container. This is achieved through Dependency Injection (DI), where dependencies are injected into objects rather than being created by the objects themselves. The Spring Core module provides the Inversion of Control (IoC) container, which manages the creation and configuration of objects (beans) in a Spring application. The Spring Container can be implemented in two ways: `BeanFactory` and `ApplicationContext`.

This module also provides the functionality for managing the lifecycle of a bean and for configuring your application using XML or annotations.

### Real World Example

Knowing the Spring Core is crucial for effectively using the Spring Framework to build enterprise applications. Here are some reasons why understanding Spring Core is important:

- **Dependency Injection (DI)**: Spring Core implements a powerful dependency injection container that manages the creation and wiring of objects. Understanding DI enables developers to write loosely coupled and easily maintainable code by decoupling dependencies and promoting modularity.
- **Inversion of Control (IoC)**: Spring Core follows the principle of Inversion of Control, which allows developers to delegate the responsibility of object creation and management to the Spring container. This leads to a more flexible and modular application architecture, making it easier to manage and extend the application.
- **Bean Lifecycle Management**: Spring Core provides mechanisms for managing the lifecycle of beans (aka objects), including initialization, destruction, and scope. Knowing how to configure bean lifecycle callbacks allows developers to perform custom initialization and cleanup tasks, ensuring proper resource management.
- **Annotations and XML Configuration**: Spring Core allows developers to configure beans and application contexts using annotations or XML-based configuration. Knowing how to use annotations and XML configuration provides flexibility and choice in configuring Spring applications according to project requirements and preferences.

### Implementation

The Spring Core, beans, and context dependencies can be added to your Maven `pom.xml` file as follows:

```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>5.3.27</version>
</dependency>
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-beans</artifactId>
    <version>5.3.27</version>
</dependency>
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-core</artifactId>
    <version>5.3.27</version>
</dependency>
```

An XML file can be created to for Spring configuration, which includes the bean definitions. The file can be named `beans.xml` and placed in the `src/main/resources` directory.

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Add your bean definitions here -->
    <bean id="helloWorld" class="com.example.HelloWorld">
        <property name="message" value="Hello, Spring!"/>
    </bean>
</beans>
```

## Overview of Dependency Injection (DI)

Dependency Injection (DI) is a design pattern used to implement Inversion of Control (IoC), allowing the creation of dependent objects outside of a class and providing those objects to a class in various ways. This helps to decouple the creation of an object from its usage, leading to more modular and testable code.

- DI addresses issues like tight coupled code, code duplication, and challenges in unit testing. It promotes the creation of loosely coupled and maintainable code, which leads to efficient and scalable applications.
- Within frameworks such as Spring, DI is a central principle, advocating for modular and testable code. It enables building building systems where components can be independently replaced and tested, resulting in a highly modular and maintainable codebase.
- In practice, dependencies are injected into classes via constructors (Constructor Injection), setter methods (Setter Injection), or directly into fields (Field Injection). Various DI containers and frameworks, such as Spring, facilitate the management and injection of dependencies.

In essence, Dependency Injection is a key tool in modern software development, promoting best practices in code organization, maintainability, and testability.

### Real World Example

Dependency Injection (DI) has a wide range of applications in real world software development. It aids in managing and controlling complex codebases, improving testability, and enhancing modularity. Here are some real world examples of dependency injection:

- **Spring Framework**: The Spring Framework is a prime example of dependency injection in action. In Spring, dependencies are injected into beans (objects) either through constructor injection, setter injection, or field injection. For example, in a Spring-based web application, dependencies such as data access objects (DAOs), service components, and controllers are injected into each other using annotations or XML configuration.
- **Java EE (Enterprise Edition)**: Java EE also supports dependency injection through its Contexts and Dependency Injection (CDI) specification. CDI enables managed beans to be injected into each other using annotations like `@Inject`. For instance, in a Java EE web application, managed beans representing components like servlets, EJBs (Enterprise JavaBeans), and CDI beans can have their dependencies injected at runtime. So what does this all mumbo jumbo mean? It means that you can create a web application where components can be easily replaced or tested in isolation, leading to a more modular and maintainable codebase.
- **Google Guice**: Google Guice is a lightweight dependency injection framework for Java. It enables developers to define dependencies and their bindings using Java code. With Guice, dependencies are injected into objects by declaring them as constructor parameters or fields. Guice is commonly used in various Java applications, including web applications, desktop applications, and command-line tools.
- **AngularJS and Angular**: Front-end frameworks like AngularJS (Angular 1.x) and Angular (Angular 2+) also utilize dependency injection to manage components and services. In Angular, dependencies are injected into components and services using TypeScript annotations or Angular's built-in dependency injection system. This allows developers to create modular and reusable components that can be easily tested and maintained.
- **JUnit and Mockito**: Dependency injection is also prevalent in testing frameworks like JUnit and Mockito. In JUnit, dependencies such as mocks and stubs are injected into test classes to isolate the code under test. Mockito, a popular mocking framework, uses dependency injection to inject mock objects into classes being tested, enabling developers to simulate different scenarios and behaviors during unit testing.
- **Android Development**: In Android development, dependency injection frameworks like Dagger 2 are commonly used to manage dependencies between Android components such as activities, fragments, and services. Dagger 2 generates code to handle the injection of dependencies, making it easier to manage complex dependency graphs in Android applications.
- **Node.js and JavaScript**: Dependency injection is not limited to Java-based frameworks. In Node.js and JavaScript applications, libraries like InversifyJS and Awilix provide dependency injection capabilities. These libraries allow developers to define and manage dependencies in a modular way, promoting code reusability and testability in JavaScript applications.

These examples illustrate how dependency injection is used across different platforms and frameworks to facilitate modular, maintainable, and testable code. By decoupling components and promoting inversion of control, dependency injection enables flexible and scalable software architectures.

### Implementation

Let's dive into a simple yet effective example to understand how Dependency Injection (DI) works in practice using the Spring Framework.

Imagine we are creating an online bookstore application. We have a `BookStore` class, and it depends on a `BookService` class to get a list of books.

Without DI, the `BookStore` class would create an instance of `BookService` directly, leading to tight coupling:

```java
public class BookStore {
  private BookService bookService;

  public BookStore() {
    this.bookService = new BookService(); // Tight coupling
  }

  public List<Book> getBooks() {
    return bookService.getBooks();
  }
}
```

In the above example, `BookStore` is tightly coupled to `BookService`, making it difficult to test or change the implementation of `BookService`. It directly instantiates `BookService`, which means we cannot easily replace it with a mock or a different implementation. This setup also violates the Single Responsibility Principle, as `BookStore` is responsible for both managing books and creating the `BookService` instance. Any changes in the `BookService` class can directly impact the `BookStore` class, leading to potential bugs and maintenance challenges.

Now, let's implement this with Dependency Injection. The following steps provide a basic guide on how to get started with DI in your project:

#### Step 1: Identify Dependencies

The first step in implementing DI is to identify the dependencies in your application. Dependencies are instances of classes that your class needs to function, such as services, repositories, or utilities. In our example, `BookStore` needs an instance of `BookService` to operate, so `BookService` is a dependency of `BookStore`.

#### Step 2: Provide Injection Points

Once you have identified the dependencies, the next step is to provide a way for these dependencies to be injected into your class. This is typically done through constructor injection, setter injection, or field injection. Constructor injection is the most common and recommended approach as it ensures that the dependency is provided at the time of object creation. The method you choose will depend on your specific use case and design preferences.

For example, if we choose constructor injection, we would modify the `BookStore` class as follows:

```java
public class BookStore {
  private BookService bookService;

  // Constructor Injection
  public BookStore(BookService bookService) {
    this.bookService = bookService;
  }

  // Other methods
}
```

In this updated version, the `BookStore` class no longer creates an instance of `BookService` directly. Instead, it receives an instance of `BookService` through its constructor. It does not need to know which implementation of `BookService` it is using, just that it has one. This promotes loose coupling and makes it easier to test `BookStore` by providing a mock or stub implementation of `BookService` during testing. We could easily substitute the real `BookService` with a mock implementation for unit testing, allowing us to isolate the `BookStore` class and test its behavior without relying on the actual `BookService` implementation.

#### Step 3: Create Instances of Dependencies

The third step is to create instances of the dependencies that will be injected into your class. The way these instances are created will depend on the DI framework you are using. For a small project, you might just create instances manually. For larger projects, you would typically use a DI container or framework like Spring, Guice, or Dagger to manage the creation and lifecycle of your dependencies.

In the `App.java` file, instantiate a `BookService`, as well as a `BookStore`, which you pass the `BookService` instance via the constructor in order to fulfill the dependency.

```java
public class App {
  public static void main(String[] args) {
    // Instantiate the dependency
    BookService bookService = new BookService();
  }
}
```

#### Step 4: Inject Dependencies

The final step is to inject the dependencies into your class. This is typically done by passing the dependency instances to the constructor, setter methods, or fields of your class. The DI framework you are using will handle the actual injection process. If you are doing it manually, you would simply pass the dependency instances to the appropriate injection points in your class.

```java
public class App {
  public static void main(String[] args) {
    // Instantiate the dependency
    BookService bookService = new BookService();

    // Instantiate a BookStore and inject the BookService dependency
    BookStore bookStore = new BookStore(bookService); // Dependency Injection
  }
}
```

In this example, we manually create an instance of `BookService` and inject it into the `BookStore` constructor. In a real-world application, you would typically use a DI framework to manage the creation and injection of dependencies automatically.

#### Step 5: Use the Injected Dependencies

Now you can use your dependencies as if they were created within your class. The key benefit is that your class is not responsible for creating or managing the lifecycle of its dependencies, leading to more modular and testable code.

Remember, while you can implement DI manually as shown in this example, many projects use a DI container or framework. These tools manage the lifecycle of your dependencies, making it easier to configure and maintain your application. Spring is a popular choice in the Java ecosystem, but other languages and frameworks have their own DI solutions.

## Types of Dependency Injection

Dependency Injection (DI) can be implemented in several ways, each with its own advantages and use cases. The three main types of Dependency Injection are:

1. **Constructor Injection**: In this type of DI, dependencies are provided through a class constructor
2. **Setter Injection**: In this type of DI, dependencies are provided through setter methods after the object is constructed
3. **Field Injection**: In this type of DI, dependencies are injected directly into the fields of a class, typically using reflection

#### Constructor Injection

**What it is**: This form of DI is achieved when a class receives its dependencies through its constructor during the instantiation process. This means that all required dependencies must be provided at the time of object creation, ensuring that the object is always in a valid state.
**Advantages**: It allows for the creation of immutable objects, as dependencies are set only once during construction. this type of injection is also less prone to null pointer exceptions since all dependencies are guaranteed to be provided when the object is created.
**Disadvantages**: It can lead to constructors with many parameters if a class has multiple dependencies, which can make the code harder to read and maintain. Additionally, it may not be suitable for optional dependencies, as they must be provided at construction time.
**Best Use Cases**: Constructor injection is best suited for mandatory dependencies that are essential for the object's functionality. It is ideal for scenarios where you want to ensure that an object is always fully initialized with all its required dependencies.

#### Setter Injection

**What it is**: This form of DI is achieved when a class receives its dependencies through setter methods after the object has been constructed. This allows for more flexibility in providing dependencies, as they can be set or changed at any time after the object is created.
**Advantages**: It allows for optional dependencies, as they can be set or left unset based on the application's needs. It also provides more flexibility in changing dependencies at runtime, as they can be modified through setter methods.
**Disadvantages**: It can lead to objects being in an invalid state if required dependencies are not set before use. This type of injection can also make it harder to enforce immutability, as dependencies can be changed after object creation.
**Best Use Cases**: Setter injection is best suited for optional dependencies that may not be required for the object's core functionality. It is ideal for scenarios where dependencies may need to be changed or updated after the object has been created.

#### Field Injection

**What it is**: This form of DI is achieved when dependencies are injected directly into the fields of a class, typically using reflection. This allows for a more concise and less boilerplate code, as there is no need for constructors or setter methods.
**Advantages**: It reduces boilerplate code, as there is no need for constructors or setter methods. It also allows for easy injection of dependencies without modifying the class's constructor or methods.
**Disadvantages**: It can make the code harder to read and understand, as dependencies are not explicitly defined in the class's constructor or methods. This type of injection can also make it harder to enforce immutability, as dependencies can be changed after object creation. Additionally, it can lead to issues with testing, as dependencies may not be easily mockable or replaceable.
**Best Use Cases**: Field injection is best suited for scenarios where you want to reduce boilerplate code and do not require strict control over the object's dependencies. It is ideal for simple classes with few dependencies or when using frameworks that support field injection, such as Spring.

### Real World Example

Let's explore the real-world applications of each type of Dependency Injection (DI) in Spring Framework:

#### Constructor Injection

- Large-scale enterprise applications: In large applications where various services are interacting with each other, constructor injection ensures that all required dependencies are provided at the time of object creation. This is particularly useful for services that have multiple dependencies, as it guarantees that the service is always in a valid state.
- Immutable objects: Constructor injection is useful in scenarios where you want your injected dependencies to be immutable (i.e., they cannot be changed after the object is created). This is helpful in ensuring that the object's state remains consistent throughout its lifecycle.
- Mandatory dependencies: Whenever an object has mandatory dependencies (i.e., dependencies that are essential for its functionality), constructor injection is the preferred choice. This ensures that the object cannot be created without providing all its required dependencies.

#### Setter Injection

- Configurable components: Setter injection is useful in scenarios where you want to provide the option for dependencies to be reconfigured or changed after the object has been created. This is common in applications that have pluggable or interchangeable components.
- Optional dependencies: In cases where an object can function without certain dependencies, or where default dependencies can be overridden, setter injection is a good choice. This allows for more flexibility in configuring the object's dependencies based on the application's needs.

#### Field Injection

- Simple components with Spring Annotations: Field injection is commonly used in scenarios where you want to reduce boilerplate code. By directly injecting dependencies into fields with Spring's `@Autowired` annotation, the need for explicit constructors or setter methods is eliminated, leading to cleaner and more concise code.
- Rapid Prototyping and Development: Field injection can speed up development time as it requires less code. This makes it a good choice for prototyping or when the speed of development is a priority over other considerations such as testability or immutability.

### Implementation

Understanding the theoretical concepts of Dependency Injection (DI) is essential, but seeing them in action can solidify your grasp. Below, we will implement each type of DI using a simple example in Java with the Spring Framework.

#### Constructor Injection

Constructor injection is the most common and recommended way to implement DI. It ensures that all required dependencies are provided at the time of object creation, leading to more robust and maintainable code.

```java
@Service // Annotation to indicate that this class is a Spring service component
public class PaymentService {
  private final BankService bankService;

  // Constructor Injection
  public PaymentService(BankService bankService) {
    this.bankService = bankService;
  }

  // Business logic methods
  public void makePayment(double amount) {
    bankService.processPayment(amount);
  }
}
```

Here, the `PaymentService` class depends on the `BankService` class. The dependency is injected through the constructor, ensuring that `PaymentService` cannot be instantiated without a `BankService` instance.

#### Setter Injection

Setter injection allows for more flexibility in providing dependencies, as they can be set or changed at any time after the object is created.

```java
@Service // Annotation to indicate that this class is a Spring service component
public class NotificationService {
  private EmailService emailService;

  // Setter Injection
  public void setEmailService(EmailService emailService) {
    this.emailService = emailService;
  }

  // Business logic methods
  public void sendNotification(String message) {
    if (emailService != null) {
      emailService.sendEmail(message);
    } else {
      System.out.println("Email service is not configured.");
    }
  }
}
```

In this example, the `NotificationService` class has a dependency on the `EmailService` class. The dependency is injected through a setter method, allowing for optional configuration of the `EmailService`.

#### Field Injection

Field injection is typically used in scenarios where you want to reduce boilerplate code. By directly injecting dependencies into fields, you can eliminate the need for explicit constructors or setter methods.
An example of this is when using Spring's `@Autowired` annotation to inject dependencies directly into fields.

```java
@Service // Annotation to indicate that this class is a Spring
public class ProductService {
  @Autowired // Field Injection
  private ProductRepository productRepository;

  // Business logic methods
  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }
}
```

In this example, the `ProductService` class has a dependency on the `ProductRepository` class. The dependency is injected directly into the field using the `@Autowired` annotation, reducing boilerplate code. However, this method of injection can make the code harder to read, understand, and test, as dependencies are not explicitly defined in the class's constructor or methods.

## Injection Using XML Based Configuration

In addition to using annotations, Spring also supports XML-based configuration for Dependency Injection (DI). This approach allows you to define your beans and their dependencies in an XML file, providing a clear separation between configuration and code.

In Spring, the beans and their dependencies can be defined and configured in an XML file, typically named `beans.xml` or `applicationContext.xml`. This file is placed in the `src/main/resources` directory of your project. This file serves as the centerpiece for configuring your Spring application.

In the XML configuration file, each bean is defined using the `<bean>` element, where you specify the class of the bean and its properties. Dependencies can be injected using constructor arguments or property elements.

The `id` attribute is used to uniquely identify each bean, while the `class` attribute specifies the fully qualified class name of the bean.

```xml
<bean id="bookService" class="com.example.BookService"/>
```

Constructor injection can be achieved using the `<constructor-arg>` element, where you specify the index or name of the constructor parameter and the reference to the bean to be injected. The `ref` attribute is used to reference another bean defined in the XML configuration.

```xml
<bean id="bookStore" class="com.example.BookStore">
    <!-- Constructor Injection -->
    <constructor-arg ref="bookService"/>
</bean>
```

Setter injection can be achieved using the `<property>` element, where you specify the name of the property (matching the setter method) and the reference, `ref`, to the bean to be injected.

```xml
<bean id="notificationService" class="com.example.NotificationService">
    <!-- Setter Injection -->
    <property name="emailService" ref="emailService"/>
</bean>
```

Spring XML configuration also supports the injection of complex data types such as lists, sets, maps, and properties using specific XML elements like `<list>`, `<set>`, `<map>`, and `<props>`.

```xml
<bean id="productService" class="com.example.ProductService">
    <!-- Setter Injection -->
    <property name="productRepository" ref="productRepository"/>
    <!-- Injecting a list of supported currencies -->
    <property name="supportedCurrencies">
        <list>
            <value>USD</value>
            <value>EUR</value>
            <value>GBP</value>
        </list>
    </property>
</bean>
```

XML configuration also allows setting bean scopes (singleton, prototype, request, session) using the `scope` attribute in the `<bean>` element.

```xml
<bean id="sessionBean" class="com.example.SessionBean" scope="session"/>
```

Spring provides a set of XML namespaces to simplify the configuration process. For instance, the context namespace can be used to enable component scanning, allowing Spring to automatically detect and register beans based on annotations and property placeholder configuration.

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context.xsd">

    <!-- Enable component scanning -->
    <context:component-scan base-package="com.example"/>

    <!-- Bean definitions go here -->
</beans>
```

This XML-based configuration approach provides a clear, centralized, and structured way to manage your Spring application's beans and their dependencies, making the application easier to configure and maintain.

### Real World Example

In real-world applications, the use of XML configuration in Spring has become less common with the rise of annotation-based configuration. However, there are still scenarios where using XML configuration might be beneficial or necessary:

- **Legacy Systems**: Many older Spring applications were built using XML configuration, and updating them to annotation-based configuration may not be feasible due to time or resource constraints, or the risk of introducing bugs. Maintaining and extending such applications often requires knowledge of XML configuration.
- **Highly Configurable Applications**: XML configuration can be useful in applications where a high degree of configurability is required. With XML, it is easier to switch out implementations or change configurations without modifying the source code. This can be particularly useful in enterprise applications where different environments (development, testing, production) may require different configurations.
- **Fine-Grained Control**: XML configuration provides a more explicit and fine-grained control over bean definitions and their dependencies. This can be a good choice when precise control over the beans and their lifecycle is needed, such as in complex applications with intricate dependency graphs.
- **Sharing Configuration**: XML configuration files can be shared across multiple projects or modules, making it easier to maintain consistent configurations. This can be particularly useful in large organizations where multiple teams are working on different parts of a system.

Remember, the choice between XML and annotation-based configuration often depends on the specific needs and constraints of your project. While annotation-based configuration is more modern and widely used, XML configuration still has its place in certain scenarios.

### Implementation

Below is a simple example of using XML-based configuration for Dependency Injection (DI) in a Spring application.

#### Step 1: Setting Up the Project

We are going to use Maven as our build tool. We will need to set up a basic Maven project with the necessary Spring dependencies.

Here's a simple structure of the project:

```
/myapp
|-- pom.xml
|-- src
    |-- main
        |-- java
            |-- com
                |-- myapp
                    |-- App.java
                    |-- MyService.java
        |-- resources
            |-- applicationContext.xml
```

#### Step 2: Configuring `pom.xml`

The `pom.xml` file should include the Spring dependencies:

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.myapp</groupId>
  <artifactId>myapp</artifactId>
  <version>1.0-SNAPSHOT</version>
  <packaging>jar</packaging>

  <name>myapp</name>
  <url>http://maven.apache.org</url>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <spring.version>5.3.27</spring.version>
  </properties>

  <dependencies>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>${spring.version}</version>
    </dependency>
  </dependencies>
</project>
```

#### Step 3: Creating a Bean Class

We'll create a simple service class (`MyService`) that we will later define as a bean in our XML configuration.

```java
package com.myapp;

public class MyService {
  public void sayHello() {
    System.out.println("Hello, Spring with XML Configuration!");
  }
}
```

#### Step 4: Configuring Beans in XML

In the `applicationContext.xml` file, we will `MyService` as a bean.

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">
    <!-- Define MyService bean -->
    <bean id="myService" class="com.myapp.MyService"/>
</beans>
```

#### Step 5: Using the Bean in the Application

Finally, in our main application class (`MyApp`), we will load the Spring application context from the XML configuration file and retrieve our `MyService` bean to use it.

```java
package com.myapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
  public static void main(String[] args) {
    // Load the Spring context from the XML configuration file
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    // Retrieve the MyService bean from the context
    MyService myService = (MyService) context.getBean("myService");

    // Use the MyService bean
    myService.sayHello();
  }
}
```

Now, when you run the `MyApp` class, it will load the Spring context from the `applicationContext.xml` file, retrieve the `MyService` bean, and call its `sayHello` method, which will print "Hello, Spring with XML Configuration!" to the console.

## Injection Using Java Based Configuration

Java-based configuration is an alternative to XML-based configuration for Dependency Injection (DI) in Spring. It offers a type-safe and more flexible way to define beans and their dependencies using Java classes and annotations. Java-based configuration uses annotations to configure your beans.
With Java-based configuration, you create a configuration class that defines your beans using the `@Bean` annotation. This class is typically annotated with `@Configuration`, indicating that it contains bean definitions. These classes are similar to XML configuration files but are written in Java code.

- `@Configuration`: This annotation indicates that the class contains bean definitions and is a source of bean definitions for the Spring container.
- `@Bean`: This annotation is used to define a bean in the configuration class. The method annotated with `@Bean` returns an instance of the bean, and the method name serves as the bean ID.
- `@Qualifier`: This annotation is used to specify which bean should be injected when multiple beans of the same type are available. It helps to resolve ambiguity in dependency injection.
- `@Scope`: This annotation is used to define the scope of a bean, such as singleton, prototype, request, or session. It allows you to control the lifecycle of the bean.
- `@ComponentScan`: This annotation is used to specify the base packages to scan for annotated components (e.g., `@Component`, `@Service`, `@Repository`, `@Controller`). It enables automatic detection and registration of beans in the Spring context.
- `@Autowired`: This annotation is used to automatically wire dependencies into a bean. It can be applied to constructors, setter methods, or fields to indicate that the dependency should be injected by Spring.

#### Benefits of Java-Based Configuration

- Type Safety: As everything is defined in Java code, you get compile-time checking, reducing the chances of errors that might occur in XML configuration.
- Autocompletion and Debugging: IDEs can provide better autocompletion and debugging support for Java code compared to XML.
- Flexibility: Java-based configuration allows for more dynamic and complex configurations that might be cumbersome in XML.

Despite these benefits, Java-based configuration might not be the best choice for all scenarios, such as when the configuration is shared among multiple projects or when there is a need to separate configuration from code for organizational purposes. It is always important to choose the appropriate configuration method based on the specific needs of your project.

### Real World Example

Java-based Dependency Injection (DI) and configuration is Spring offer several advantages over XML-based configuration, making it a popular choice for modern Spring applications. Here are some real-world examples of when and why you might choose Java-based DI and configuration:

- **Improved Readability and Maintainability**: Java-based configuration allows you to define your beans and their dependencies using Java code, which can be more readable and maintainable than XML. This is especially true for complex configurations where the relationships between beans can be more easily expressed in code.
- **Type Safety**: Java-based configuration provides type safety, meaning that the compiler can catch type-related errors at compile time rather than at runtime. This can help prevent issues that might arise from typos or incorrect bean definitions in XML.
- **Easier Refactoring**: With Java-based configuration, refactoring your code is often easier. You can use your IDE's refactoring tools to rename classes, methods, or variables, and the changes will be automatically reflected in your configuration code. This is not the case with XML, where you would need to manually update the configuration file.
- **Easy Integration with Java Libraries and Frameworks**: Java-based configuration seamlessly integrates with other Java libraries and frameworks. You can easily use Java features such as generics, lambdas, and streams in your configuration code, making it more powerful and expressive.
- **Dynamic and Conditional Configuration**: Java-based configuration allows you to use conditional logic to define beans based on certain conditions. For example, you can create beans only if a specific property is set or if a certain class is present on the classpath. This level of flexibility is harder to achieve with XML configuration.
- **Annotation-Driven Development**: Java-based configuration works well with Spring's annotation-driven development model. You can use annotations like `@Component`, `@Service`, and `@Repository` to automatically register beans in the Spring context, reducing the need for explicit bean definitions in XML.
- **Faster Development and Deployment**: Java-based configuration can lead to faster development and deployment cycles. Since the configuration is part of the codebase, you can leverage build tools and continuous integration pipelines to automate the deployment process, reducing the chances of configuration drift between environments.

It is important to note that both XML and Java-based configuration have their merits, and the choice between the two often depends on the specific needs and preferences of your project. In some cases, a hybrid approach that combines both XML and Java-based configuration may be appropriate. For modern Spring applications, Java-based configuration is often the preferred choice due to its advantages in readability, maintainability, and flexibility.

### Implementation

Below is a demonstration of defining a Dependency Injection (DI) using Java-based configuration with `@Configuration` and `@Bean` annotations in Spring.

We will have an `Employee` entity and a basic controller-service-repository architecture.

#### Step 1: Setting Up the Project

To begin, we can set up a project in Java by utilizing the build tool of our choice, such as Maven or Gradle. For this example, we will use Maven.

```xml
<dependencies>
  <!-- Other dependencies -->
  <dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>5.3.27</version> <!-- Replace with the desired Spring version -->
  </dependency>
</dependencies>
```

#### Step 2: Creating the Bean Classes

We need to identify the beans that need to be managed by the Spring container and create the corresponding classes. In this example, we will create an `Employee` class, a `EmployeeRepository` class, a `EmployeeService` class, and an `EmployeeController` class.

```java
public class Employee {
  private Integer id;
  private String firstName;
  private String lastName;

  // other fields, constructors, getters, and setters
}
```

```java
public class EmployeeController {
  private EmployeeService employeeService;

  // Constructor Injection
  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }
}
```

```java
public class EmployeeService {
  private EmployeeRepository employeeRepository;

  // Setter Injection
  public void setEmployeeRepository(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }
}
```

```java
public class EmployeeRepository {
  // Repository methods
}
```

#### Step 3: Creating the Configuration Class

Within the configuration class, we can define methods annotated with `@Bean` to create and configure our beans. We can also specify the scope of the beans using the `@Scope` annotation if needed.

```java
import org.springframework.context.annotation.*;

@Configuration // Indicates that this class contains Spring bean definitions
public class EmployeeConfig {
  // Uses constructor injection
  @Bean
  public EmployeeController employeeController(EmployeeService employeeService) {
    return new EmployeeController(employeeService);
  }

  // Uses setter injection
  @Bean
  public EmployeeService employeeService(EmployeeRepository employeeRepository) {
    EmployeeService bean = new EmployeeService();
    bean.setEmployeeRepository(employeeRepository);
    return bean;
  }

  @Bean
  public EmployeeRepository employeeRepository() {
    return new EmployeeRepository();
  }
}
```

In the above code, we define three beans: `EmployeeController`, `EmployeeService`, and `EmployeeRepository`. The `EmployeeController` bean is created using constructor injection, while the `EmployeeService` bean is created using setter injection. The `EmployeeRepository` bean is created without any dependencies.

#### Step 4: Applying the Configuration

In the main method of our application's entry point, we can create an instance of the `ApplicationContext` and use it to get and use the beans defined in our configuration class.

```java
package com.myapp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
  public static void main(String[] args) {
    // #1. Create the application context using the configuration class
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(EmployeeConfig.class);

    // #2. Get and use beans from the context
    String[] beansNames = ctx.getBeanDefinitionNames();

    System.out.println("Beans in the context:");
    for (String beanName : beansNames) {
      System.out.println(beanName);
    }

    // #3. Close the context
    ctx.close();
  }
}
```

By following these steps and customizing the code according to your specific requirements, you can effectively implement Dependency Injection using Java-based configuration in a Spring application. This approach provides a type-safe and flexible way to manage your beans and their dependencies, leading to more maintainable and testable code.

## Annotation Based Configuration

The Spring Framework is a robust and versatile framework that is widely used in the Java ecosystem for building enterprise-level applications. In Spring, the application configuration can be done either using XML files or using annotations. Annotation-based configuration is a more modern and convenient way to configure Spring applications, as it allows developers to define beans and their dependencies directly in the Java code using annotations.

Annotation-based configuration is another type of configuration that uses component annotations only, such as `@Component`, `@Service`, `@Repository`, and `@Controller`, to define beans and their dependencies. `@Autowired` is used to inject dependencies into the beans.

- `@Component`: This annotation is used to indicate that a class is a Spring component. It is a generic stereotype for any Spring-managed component and can be used on any class.
- `@Service`: This annotation is a specialization of `@Component` and is used to indicate that a class is a service component in the business layer.
- `@Repository`: This annotation is a specialization of `@Component` and is used to indicate that a class is a repository component in the data access layer.
- `@Controller`: This annotation is a specialization of `@Component` and is used to indicate that a class is a controller component in the presentation layer, typically in a web application.
- `@Autowired`: This annotation is used to automatically wire dependencies into a bean. It can be applied to constructors, setter methods, or fields to indicate that the dependency should be injected by Spring.
- `@Qualifier`: This annotation is used in conjunction with `@Autowired` to specify which bean should be injected when multiple beans of the same type are available. It helps to resolve ambiguity in dependency injection.
- `@Scope`: This annotation is used to define the scope of a bean, such as singleton, prototype, request, or session. It allows you to control the lifecycle of the bean.
- `@ComponentScan`: This annotation is used to specify the base packages to scan for annotated components (e.g., `@Component`, `@Service`, `@Repository`, `@Controller`). It enables automatic detection and registration of beans in the Spring context.

#### Benefits of Annotation-Based Configuration

- Simplicity: Using annotations often leads to cleaner and readable code as the metadata (annotations) are placed right next to the code they configure.
- Elimination of XML: Reduces the need for large XML configuration files, making the configuration more concise and easier to manage.
- Type Safety: Since the configuration is done in Java code, it benefits from compile-time checking, reducing the chances of errors that might occur in XML configuration.
- Better for Collaboration and Control: Annotations are part of the codebase, making it easier for teams to collaborate and manage configurations through version control systems.
- Contextual Configuration: Annotations allow for more contextual and dynamic configurations, as they can be applied directly to classes and methods.

### Real World Example

Here are some real-world applications types where annotation-based configuration in Spring is commonly used:

- **Web Applications**: In web applications, controllers are often annotated with `@Controller`, and services with `@Service`. This allows for a clear separation of concerns and makes it easy to manage the different layers of the application. For example, a RESTful API might have controllers handling HTTP requests, services containing business logic, and repositories managing data access.
- **Restful Services**: In the development of RESTful services using Spring Boot, annotation-based configuration is widely used. Controllers are annotated with `@RestController`, and services with `@Service`. This allows for a clean and organized structure, making it easy to manage the different components of the service.
- **Enterprise Applications**: Annotation-based configuration are extensively used in large-scale enterprise applications. Spring's `@Service`, `@Repository`, and `@Component` annotations are used to denote service classes, data access objects (DAOs), and other components, respectively. This helps in organizing the codebase and managing dependencies effectively.

#### Implementation

Below is a demonstration of defining Dependency Injection (DI) using annotation-based configuration with `@Controller`, `@Service`, `@Repository`, and `@Autowired` annotations in Spring.

We will have a `Gallery` entity and a basic controller-service-repository architecture.

#### Step 1: Setting Up the Project

To begin, we can set up a project in Java by utilizing the build tool of our choice, such as Maven or Gradle. For this example, we will use Maven.

```xml
<dependencies>
    <!-- Other dependencies -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.3.9</version> <!-- Replace with the desired version -->
    </dependency>
</dependencies>
```

#### Step 2: Creating the Bean Classes

We need to identify the beans that need to be managed by the Spring container and create the corresponding classes. In this example, we will create a `Gallery` class, a `GalleryRepository` class, a `GalleryService` class, and a `GalleryController` class.

```java
package com.example.annotationbased;

public class Gallery {
  private Integer id;
  private String name;
  private String description;

  // other fields, constructors, getters, and setters
}
```

```java
package com.example.annotationbased;

import org.springframework.stereotype.Controller;

@Controller // Indicates that this class is a Spring MVC controller
public class GalleryController {
  private final GalleryService galleryService;

  // Constructor Injection
  public GalleryController(GalleryService galleryService) {
    this.galleryService = galleryService;
  }
}
```

```java
package com.example.annotationbased;

import org.springframework.beans.factory.annotation.Service;

@Service // Indicates that this class is a Spring service component
public class GalleryService {
  private GalleryRepository galleryRepository;

  // Setter Injection
  public void setGalleryRepository(GalleryRepository galleryRepository) {
    this.galleryRepository = galleryRepository;
  }
}
```

```java
package com.example.annotationbased;

import org.springframework.stereotype.Repository;

@Repository // Indicates that this class is a Spring repository component
public class GalleryRepository {
  // Repository methods
}
```

#### Step 3: Application Entry Point

In the main method of our application's entry point, we can create an instance of the `ApplicationContext` and use it to get and use the beans defined in our annotated classes.

```java
package com.example.annotationbased;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationBasedApplication {
  public static void main(String[] args) {
    // #1. Create the container and configure it to scan the specified package for annotated components
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("com.example.annotationbased");

    // #2. Get and use beans from the context
    String[] beansNames = ctx.getBeanDefinitionNames();

    System.out.println("Beans in the context:");
    for (String beanName : beansNames) {
      System.out.println(beanName);
    }

    // #3. Close the context
    ctx.close();
  }
}
```

In this example, we define three beans: `GalleryController`, `GalleryService`, and `GalleryRepository`. The `GalleryController` bean is created using constructor injection, while the `GalleryService` bean is created using setter injection. The `GalleryRepository` bean is created without any dependencies.

Wait, so we did not have to create any configuration class? How does Spring know where to look for the beans?

Yes, in this example, we did not create a separate configuration class. Instead, we used the `AnnotationConfigApplicationContext` constructor that takes a base package name as an argument. This tells Spring to scan the specified package and its sub-packages for classes annotated with Spring stereotypes such as `@Component`, `@Service`, `@Repository`, and `@Controller`.

When you call `new AnnotationConfigApplicationContext("com.example.annotationbased")`, Spring performs component scanning in the `com.example.annotationbased` package. It automatically detects and registers all the classes annotated with the relevant annotations as beans in the application context.

## Component Scanning

In Spring, component scanning is a mechanism that allows the framework to automatically discover and register beans in the application context based on classpath scanning. This means that instead of manually defining each bean in a configuration file (XML or Java-based), you can use annotations to mark classes as components, and Spring will automatically detect and register them as beans.

This allows you to annotate your classes with stereotypes such as `@Component`, `@Service`, `@Repository`, and `@Controller`, and Spring will automatically detect and register them as beans in the application context.

When the application starts, Spring scans the specified packages and their sub-packages for classes annotated with these stereotypes. It then creates instances of these classes and manages their lifecycle, including dependency injection.

This automated process greatly simplifies the configuration of a Spring application by reducing the need for explicit bean definitions in XML or Java configuration files. It also encourages a convention-over-configuration approach, making it easier to develop and maintain Spring applications.

The `@ComponentScan` annotation or `<context:component-scan>` element in XML configuration is used to specify the base packages to scan for annotated components. If no specific packages are provided, Spring will scan the package of the class that declares the `@ComponentScan` annotation.

### Real World Example

Here are some real-world applications types where component scanning in Spring is commonly used:

- **Web Applications**: Component scanning is extensively used in web applications developed using Spring MVC or Spring Boot. Controllers, services, and repositories are often marked with stereotypes annotations (`@Controller`, `@Service`, `@Repository`), and are automatically detected and registered by Spring.
- **RESTful Services**: When developing RESTful services using Spring Boot, classes annotated with `@RestController` are automatically detected and registered as beans in the application context. This allows for a clean and organized structure, making it easy to manage the different components of the service.
- **Enterprise Applications**: Larger enterprise applications benefit from component scanning to help manage the complexity of numerous service and repository classes.
- **Microservices**: In a Spring Boot microservices architecture, component scanning is used to automatically detect and register beans, streamlining the development process and reducing boilerplate code.
- **Spring Data JPA Applications**: In applications that use Spring Data JPA, repositories are often defined as interfaces annotated with `@Repository`. Component scanning automatically detects these interfaces and creates proxy implementations for them, simplifying data access layer configuration.

### Implementation

Below is a step-by-step guide on how to implement component scanning in a Spring application. The guide assumes you have a basic understanding of Java and Maven, as well as an IDE like IntelliJ IDEA or Eclipse.

In the following example, we will outline the steps of using a Maven project with Spring context dependency and utilize Java-based configuration (`@Configuration` and `@ComponentScan` annotations) to illustrate component scanning. Note that Spring Boot makes this process even simpler, but for educational purposes, we will use plain Spring.

Let's assume we have a Maven project with the following Spring context dependency in the `pom.xml` file:

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.3.10</version> <!-- use the latest version available -->
    </dependency>
</dependencies>
```

#### Step 1: Create a Service Class

In `src/main/java/com/example`, under the root package, create a new package named `service` and create a class named `GreetingService` inside it.

```java
com.example.service;

import org.springframework.stereotype.Service;

@Service // Marks this class as a Spring service component
public class GreetingService {
  public String greet() {
    return "Hello, World!";
  }
}
```

The `@Service` annotation indicates that this class is a service component, and Spring will automatically detect and register it as a bean during component scanning.

#### Step 2: Create a Configuration Class

In `src/main/java/com/example`, under the root package, create a new package named `config` and create a class named `AppConfig` inside it.

```java
package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // Indicates that this class contains Spring bean definitions
@ComponentScan(basePackages = "com.example") // Specifies the base package to scan for components
public class AppConfig {
}
```

The `@Configuration` annotation indicates that this class contains bean definitions, and the `@ComponentScan` annotation specifies the base package to scan for annotated components. The `basePackages` attribute can be set to the root package or any specific package you want to scan.

#### Step 3: Create the Application Entry Point

Create a `Main` class with a `main` method to bootstrap the Spring application context and retrieve the `GreetingService` bean.

```java
package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.example.config.AppConfig;
import com.example.service.GreetingService;

public class Main {
  public static void main(String[] args) {
    // Create the application context using the configuration class
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    // Retrieve the GreetingService bean from the context
    GreetingService greetingService = (GreetingService) context.getBean(GreetingService.class);

    // Use the GreetingService bean
    System.out.println(greetingService.greet()); // Output: Hello, World!
  }
}
```

When you run the `Main` class, it will create the Spring application context, scan the specified package for components, and automatically register the `GreetingService` bean. The `greet` method of the `GreetingService` bean is then called to print "Hello, World!" to the console.
