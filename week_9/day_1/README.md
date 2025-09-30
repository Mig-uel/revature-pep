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
