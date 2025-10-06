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

## Using Spring Initializr

[Spring Initializr](https://start.spring.io/) is a web-based tool provided by the Spring team that allows developers to quickly generate a Spring Boot project with the necessary dependencies and configurations. It sets up an application following best practices and conventions of Spring Boot, enabling you to focus more on your business logic and less on project setup.

### Features of Spring Initializr

- **Dependency Selection**: With Spring Initializr, you do not have to manually search for and add dependencies to your project. You can select the required dependencies from a list of commonly used libraries and frameworks, and Spring Initializr will automatically include them in your project.
- **Easy Project Setup**: Spring Initializr simplifies the process of setting up a new Spring project by generating a basic project structure and configuration files. This saves time and effort, especially for developers who are new to Spring Boot.
- **Customizable Options**: You can customize your Spring Boot project according to your requirements. You can choose the project type (Maven or Gradle), language (Java, Kotlin, or Groovy), Spring Boot version, and other options such as packaging type (JAR or WAR) and Java version.
- **IDE Integration**: Spring Initializr can be integrated with popular IDEs like IntelliJ IDEA, Eclipse, and Visual Studio Code. This allows you to create a new Spring Boot project directly from your IDE without having to visit the Spring Initializr website.
- **Command-Line Interface**: For those who prefer to work from the command line, Spring Initializr also provides a CLI tool that allows you to generate Spring Boot projects using terminal commands. Spring Initializr also provides a REST API that can be accessed using tools like `curl`, HTTPie, or Spring Boot's CLI tool.
- **Community Support**: Spring Initializr is part of the larger Spring ecosystem, which has a vibrant community of developers. This means that you can find plenty of resources, tutorials, and examples to help you get started with Spring Boot.

## Real World Example

[Spring Initializr](https://start.spring.io/) is extensively used in the industry fo`r several reasons:

- **Project Bootstrapping**: Developers use Spring Initializr when starting a new Spring Boot project. It provides a quick and easy way to set up the project structure, dependencies, and configurations, allowing developers to focus on writing business logic rather than spending time on project setup.
- **Learning and Experimentation**: For learners and developers trying out new features or libraries, Spring Initializr is a handy tool. It allows them to quickly generate a project with the desired dependencies and configurations, enabling them to experiment and learn without the hassle of manual setup.
- **Microservices Development**: In microservices architecture, where applications are composed of multiple small services, Spring Initializr is often used to create individual microservices. It helps in quickly generating the necessary boilerplate code and configurations for each microservice, making it easier to develop and deploy them independently.
- **Workshops and Training**: In workshops and training sessions, instructors often use Spring Initializr to demonstrate how to create Spring Boot applications. It provides a consistent and standardized way to set up projects, making it easier for participants to follow along and focus on learning the concepts being taught.
- **Prototyping and Proof of Concepts**: When developers need to create a quick prototype or proof of concept, Spring Initializr is a valuable tool. It allows them to rapidly generate a project with the required dependencies and configurations, enabling them to quickly validate ideas and concepts.

Overall, Spring Initializr serves as a time-saving tool that simplifies the process of setting up Spring Boot projects, making it a popular choice among developers in various scenarios, from project bootstrapping to learning and experimentation.

### Implementation

Spring Initializr is a great tool for setting up a new Spring Boot project quickly. In this guide, we will go through the process of creating a Spring Boot Maven project with Web and Spring Data JPA dependencies using Spring Initializr.

#### Step 1: Open Spring Initializr

Go to the Spring Initializr website at [https://start.spring.io/](https://start.spring.io/).

#### Step 2: Configure Project Settings

In the "Project Metadata" section, configure the following settings:

- **Project**: Select "Maven Project".
- **Language**: Select "Java".
- **Spring Boot**: Choose the desired Spring Boot version (e.g., 2.5.4).
- **Project Metadata**:
  - **Group**: Enter your desired group name (e.g., com.example).
  - **Artifact**: Enter your desired artifact name (e.g., demo) which will be the name of your project and the root package.
  - **Name**: This will be auto-filled based on the artifact name.
  - **Description**: Enter a brief description of your project (e.g., Demo project for Spring Boot).
  - **Package name**: This will be auto-filled based on the group and artifact names.
  - **Packaging**: Select "Jar" to keep it simple and portable.
  - **Java**: Select the desired Java version (e.g., 11 or 17).

#### Step 3: Add Dependencies

In the "Dependencies" section, add the following dependencies:

- **Spring Web**: This dependency is required for building web applications, including RESTful APIs. It includes Spring MVC and an embedded Tomcat server.
- **Spring Data JPA**: This dependency is required for working with relational databases using JPA (Java Persistence API). It provides a simplified way to interact with databases and perform CRUD operations.

You can search for these dependencies in the search bar and click on them to add them to your project.

#### Step 4: Generate the Project

After configuring the project settings and adding the dependencies, click on the "Generate" button. This will download a ZIP file containing your Spring Boot project.

#### Step 5: Extract and Open the Project

Extract the downloaded ZIP file to your desired location. Open the project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse, or VS Code).

Your new Spring Boot Maven project is now set up with Web and Spring Data JPA dependencies. You can start building your application by creating controllers, services, and repositories as needed.

#### Step 6: Running the Project

You can run the Spring Boot application both from the command line and your IDE.

- **From the Command Line**: Navigate to the project directory and run the following command:

  ```bash
  ./mvnw spring-boot:run
  ```

  This command uses the Maven Wrapper to run the Spring Boot application.

- **From the IDE**: Locate the main application class (annotated with `@SpringBootApplication`) and run it as a Java application.

Please note that you need to have the necessary plugins (Spring Boot Tools for VS Code, Spring Tools for Eclipse, or built-in support in IntelliJ IDEA) installed in your IDE to run Spring Boot applications seamlessly.
