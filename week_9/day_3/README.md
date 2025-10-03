# Spring and Spring Boot Basics - Day 3

## Overview of Spring Boot

Spring Boot is an extension of the Spring framework that simplifies the setup and development of new Spring applications. It makes developing web applications and microservices with the Spring framework faster and easier through three core features:

- Auto-configuration: Automatically configures Spring applications based on the dependencies present in the project.
- An opinionated approach: Provides default configurations and setups to reduce boilerplate code and configuration.
- Additional tools: Includes embedded servers (like Tomcat, Jetty) and production-ready features (like metrics, health checks).

#### Auto-Configuration

One of the key features of Spring Boot is its auto-configuration mechanism, which automatically configures beans and components based on the dependencies present in the classpath. This means that if you include a dependency for a database, Spring Boot will automatically configure a DataSource bean for you. We no longer need to write XML configuration files or Java configuration classes to set up common components because Spring Boot analyzes the environment and classpath to configure beans, reducing the need for manual configuration and improving developer productivity.

#### Opinionated Approach

Spring Boot takes an opinionated approach to configuration, providing sensible defaults and conventions for various aspects of application development. This means that developers can get started quickly without having to make many decisions about configuration. For example, Spring Boot provides default configurations for web applications, data access, and security, allowing developers to focus on writing business logic rather than boilerplate code.

#### Additional Tools

Spring Boot comes with built-in support for embedded servers, such as Tomcat and Jetty, and it also provides a set of starter packs, which are curated sets of dependencies for specific use cases such as web development, data access, and security. Starter packs include all the necessary dependencies and configurations to get started quickly.

Spring Boot also seamlessly integrates with other components of the Spring ecosystem, such as Spring Data, Spring Security, and Spring Cloud, making it easy to build robust and scalable applications. This allows developers to leverage the full power of Spring ecosystem technologies and frameworks to build robust and feature-rich applications.

Its simplicity, ease of use, and focus on convention over configuration have made it a popular choice for building modern Java applications, especially in the context of microservices and cloud-native development.

#### Comparison of Spring and Spring Boot

| Spring                                                                                                   | Spring Boot                                                                                                                                                                                                                                                    |
| -------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| It is a comprehensive and modular framework for building enterprise Java applications.                   | It is an opinionated framework that extends the Spring framework to simplify the setup and development of new Spring applications. It provides opinionated defaults and started packs to reduce boilerplate code and reduce the need for manual configuration. |
| It provides a wide range of features and functionalities for various aspects of application development. | It includes embedded servers and seamless integration with other Spring ecosystem components, making it easy to build robust and scalable applications.                                                                                                        |
| It requires manual configuration and setup for various components and features.                          | It offers auto-configuration, which automatically configures beans and components based on the dependencies present in the classpath, reducing the need for manual configuration.                                                                              |

#### The Spring Boot Flow

1. **Project Setup**: Create a new Spring Boot project using Spring Initializer or your preferred IDE. Choose the necessary dependencies based on your application requirements.
2. **Application Configuration**: Configure your application using the `application.properties` or `application.yml` file. This file allows you to set various properties such as database connection details, server port, logging levels, etc.
3. **Define Beans and Components**: Create your application components, such as controllers, services, and repositories, using Spring annotations like `@RestController`, `@Service`, and `@Repository`. Spring Boot will automatically detect and register these components as beans in the application context.
4. **Run the Application**: Use the `@SpringBootApplication` annotation on your main application class to enable auto-configuration and component scanning. Run the application using the `main` method, which starts the embedded server and initializes the application context.
5. **Access the Application**: Once the application is running, you can access it through the configured server port (default is 8080). You can test your REST endpoints using tools like Postman or curl.
6. **Monitor and Manage**: Spring Boot provides built-in support for monitoring and managing your application through Actuator endpoints. You can access these endpoints to check the health, metrics, and other information about your application.

![Spring Boot Architecture](./spring-boot-architecture.png)

### Real World Example

Understanding Spring Boot is essential for modern Java developers for several reasons:

- **Rapid Application Development**: Spring Boot simplifies the process of building Spring applications by providing a set of opinionated defaults and auto-configuration. Developers can quickly bootstrap new projects and focus on writing business logic rather than boilerplate code.
- **Microservices Architecture**: Spring Boot is widely used for building microservices, where applications are broken down into smaller, independent services. Its lightweight nature, embedded servers, and seamless integration with Spring Cloud, enable developers to create scalable and resilient microservices architectures.
- **Embedded Servers**: Spring Boot comes with embedded servers like Tomcat and Jetty, eliminating the need for external server setup and configuration. This makes it easier to deploy and run applications in various environments, including cloud platforms.
- **Auto-Configuration**: Spring Boot's auto-configuration feature automatically configures beans and components based on the dependencies present in the classpath. This reduces the need for manual configuration and improves developer productivity.
- **Dependency Management**: Spring Boot simplifies dependency management by providing starter packs, which are curated sets of dependencies for specific use cases. This helps developers avoid version conflicts and ensures compatibility between different libraries.

In summary, understanding Spring Boot is crucial for modern Java developers as it enables rapid application development, supports microservices architecture, simplifies deployment with embedded servers, and enhances productivity through auto-configuration and dependency management.

### Implementation

Below in an example that demonstrates how quickly you can set up a Spring Boot application.

> Create a Maven project and add the `spring-boot-starter` dependency to your `pom.xml` file:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
    <version>2.5.4</version>
</dependency>
```

> Set up the main application class with the `@SpringBootApplication` annotation:

```java
@SpringBootApplication // Combines @Configuration, @EnableAutoConfiguration, and @ComponentScan
// Marks this class as the entry point for the Spring Boot application
public class App {
  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }

  @Bean // Indicates that this method produces a bean to be managed by the Spring container
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    // CommandLineRunner is a functional interface that can be used to run code at application startup
    return args -> {
      System.out.println("Let's inspect the beans provided by Spring Boot:");

      String[] beanNames = ctx.getBeanDefinitionNames(); // Retrieve all bean names from the application context
      Arrays.sort(beanNames);
      for (String beanName : beanNames) {
        System.out.println(beanName); // Print each bean name to the console
      }
    };
  }
}
```

We can see the `@SpringBootApplication` annotation, which is a convenience annotation that tags the class as a source of bean definitions for the application context, enabling auto-configuration and component scanning.

The `main` method uses `SpringApplication.run()` to launch the application, which starts the embedded server and initializes the Spring context.

There is also a `CommandLineRunner` method defined as a bean, which runs on application startup and prints out all the beans that Spring Boot has configured.
