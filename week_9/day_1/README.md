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
