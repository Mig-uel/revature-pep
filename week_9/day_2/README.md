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
