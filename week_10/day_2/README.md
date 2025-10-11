# Spring, HTML/CSS, JavaScript Intro - Day 2

## Spring Boot Actuator

Spring Boot Actuator is a sub-project of Spring Boot Framework that provides production-ready features to help you monitor and manage your application. It offers a set of built-in endpoints that expose various metrics, health checks, and other useful information about your application.

#### Key Features of Spring Boot Actuator

- **Endpoints**: Actuator provides several built-in endpoints that can be accessed via HTTP or JMX. Some common endpoints include:
  - `/actuator/health`: Displays the health status of the application.
  - `/actuator/info`: Provides general information about the application.
  - `/actuator/metrics`: Exposes various metrics about the application, such as memory usage, CPU usage, and request counts.
  - `/actuator/env`: Shows the current environment properties and configurations.
  - `/actuator/loggers`: Allows you to view and modify the logging levels of your application at runtime.
- **Health Checks**: Provides endpoints to check the health of your application, including database connectivity, disk space, and custom health indicators.
- **Metrics**: Collects and exposes various metrics about your application, such as memory usage, garbage collection, web request statistics, and more. These metrics can be integrated with monitoring systems like Prometheus, Grafana, etc and be used to identify performance bottlenecks and optimize resource usage.
- **Application Info**: Provides detailed information about the application, including version, build time, and other custom metadata.
- **Loggers**: Actuator provided the ability to view and modify the logging levels of your application at runtime, which can be useful for debugging and troubleshooting.
- **Auditing**: It automatically audits events in your application, which can be accessed through the `/actuator/auditevents` endpoint.
- **HTTP Tracing**: Actuator provides HTTP tracing capabilities, allowing you to trace incoming HTTP requests and responses up to the last 100 requests. This can be useful for debugging and monitoring purposes.

#### Security

Actuator endpoints expose sensitive information about your application, so it's important to secure them properly.

---

Spring Boot Actuator is an essential tool for monitoring and managing Spring Boot applications in production environments. It provides valuable insights into the health, performance, and behavior of your application, helping you ensure its reliability and stability. This is a must-have tool for any serious Spring Boot developer.

### Real World Application

Here are some real-world application of Spring Boot Actuator:

- **Continuous Monitoring**: Operations teams can continuously monitor the health and performance of Spring Boot applications in production environments using Actuator endpoints. This helps identify issues early and ensures the application is running smoothly.
- **Integration with Monitoring Systems**: Health checks provided by Spring Boot Actuator can be integrated with external monitoring systems like Prometheus, Grafana, or New Relic. This allows for centralized monitoring and alerting based on the health status of the application.
- **Performance Optimization**: Developers can use metrics to identify performance bottlenecks and optimize resource usage. For example, if memory usage is consistently high, developers can investigate and optimize memory-intensive operations.
- **Capacity Planning**: Operations teams can use metrics to plan for capacity upgrades based on trends in resource usage over time. This helps ensure that the application can handle increased traffic and workload.
- **Debugging and Troubleshooting**: Developers and operations teams can use logging endpoints to troubleshoot issues in production environments and debug problems quickly.
- **Compliance and Security**: Audit endpoints provide insights into security-related events, helping organizations meet compliance requirements and enhance security measures.
- **Configuration Management**: Operations teams can use environment information to troubleshoot configuration-related issues in production environments.
- **Troubleshooting Configuration Issues**: Developers can use environment information to troubleshoot configuration-related issues in production environments.
- **Business-specific Monitoring**: Developers can create custom endpoints to monitor business-specific metrics and events, providing insights into application-specific behavior.
- **Operational Tasks**: Operations teams can create custom endpoints to perform operational tasks, such as clearing caches or triggering specific actions in the application.

### Implementation

This is an example of setting up Spring Boot Actuator in a Spring Boot application and monitoring its basic endpoints. Let's say we have a simple Spring Boot application that includes: Spring Web and Spring Boot Actuator dependencies.

#### Step 1: Enable Actuator Endpoints

Spring Boot Actuator comes with several built-in endpoints, but some of them are disabled by default for security reasons. To enable specific endpoints, you can configure them in the `application.properties` or `application.yml` file.

```bash
management.endpoints.web.exposure.include=* # Enable all endpoints
# or
management.endpoints.web.exposure.include=health,info,metrics # Enable specific endpoints
```

This configuration will expose all Actuator endpoints over HTTP. However, exposing all endpoints in a production environment is not recommended for security reasons. For the sake of this example and testing purposes, we will enable all endpoints but in a production environment, you should only enable the necessary endpoints.

#### Step 2: Access Actuator Endpoints

Once the application is running, we can access the Actuator endpoints via HTTP.

The most basic endpoint is the `/actuator/health` endpoint, which provides information about the health status of the application.

```bash
curl http://localhost:8080/actuator/health # Access health endpoint
```

We should see a response like this:

```json
{
  "status": "UP"
}
```

## Built-in Actuator Endpoints

Spring Boot Actuator comes with several built-in endpoints that provide various information about the application.

#### List of Common Built-in Endpoints

| Endpoint                | Description                                                                                                                                                                                                                                                          |
| ----------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `/actuator/health`      | Displays the health status of the application.                                                                                                                                                                                                                       |
| `/actuator/info`        | Provides arbitrary application information. By default, this endpoint is empty. You can populate it with information such as build version, git commit ID, and more by customizing the `info` properties in your `application.properties` or `application.yml` file. |
| `/actuator/metrics`     | Exposes various metrics about the application, such as memory usage, CPU usage, and request counts.                                                                                                                                                                  |
| `/actuator/env`         | Shows the current environment properties and configurations.                                                                                                                                                                                                         |
| `/actuator/loggers`     | Allows you to view and modify the logging levels of your application at runtime.                                                                                                                                                                                     |
| `/actuator/auditevents` | Provides access to audit events in the application. You can customize with events get captured based on your application needs.                                                                                                                                      |
| `/actuator/threaddump`  | Provides a thread dump of the application, which can be useful for diagnosing performance issues.                                                                                                                                                                    |
| `/actuator/httptrace`   | Displays the last 100 HTTP request-response exchanges. This can be useful for debugging and monitoring purposes.                                                                                                                                                     |
| `/actuator/heapdump`    | Generates a heap dump of the application, which can be useful for diagnosing memory-related issues.                                                                                                                                                                  |

Each of these endpoints plays a crucial role in monitoring and managing your Spring Boot application, providing insights into its health, performance, and configuration.

### Real World Application

In a real-world enterprise application, each Spring Boot Actuator endpoint serves a specific purpose:

- `/health`: In a microservices architecture, orchestration tools use this endpoint to monitor the health of individual services. If a service is unhealthy, the orchestrator can spin up a new instance or route traffic away from the unhealthy service.
- `/info`: This endpoint can be configured to provide details about the application version, build time, and other metadata. This information is useful for tracking deployments and ensuring that the correct version of the application is running in different environments (development, staging, production).
- `/metrics`: In a large scale application, performance monitoring is crucial. This endpoint provides vital metrics such as request counts, response times, and memory usage. These metrics can be used for capacity planning, identifying performance bottlenecks, and tuning the application for better performance.
- `/loggers`: During incident response, this endpoint allows support teams to dynamically adjust logging levels to `DEBUG` or `TRACE` without restarting the application. This is particularly useful for diagnosing issues in production environments.
- `/threaddump`: In a high-load scenario, where the application might be slowing down or hanging, a thread dump can help engineers identify deadlocks, thread starvation, or other concurrency issues.
- `/heapdump`: Memory leaks can be detrimental to application performance. This endpoint allows developers to generate a heap dump for analysis, helping to identify memory leaks or inefficient memory usage patterns. The heap dump can be analyzed using tools like Eclipse MAT (Memory Analyzer Tool) to pinpoint the source of memory issues.
- `/auditevents`: In applications with strict compliance requirements, this endpoint can be used to track security-related events, such as user logins, data access, and configuration changes. This information is crucial for auditing and ensuring compliance with regulations like GDPR or HIPAA.
- `/httptrace`: This endpoint is useful for debugging issues related to HTTP requests. It provides a history of the last 100 HTTP requests and responses, which can help identify patterns or anomalies in request handling.
- `/env`: In complex applications with multiple configuration sources (e.g., environment variables, property files, cloud config), this endpoint helps developers and operations teams verify the effective configuration of the application at runtime.

These endpoints collectively help maintain a smooth, highly available, and secure application, making them indispensable in modern Spring Boot applications.

## Unit Testing Service Layer Methods with JUnit and Mockito

#### Unit Testing in Spring Boot Applications with JUnit and Mockito

Unit testing is an essential practice in software development that helps ensure the quality and correctness of your application's components. In the context of Spring Boot applications, unit testing focuses on isolating individual components or classes and verifying their behavior without relying on external dependencies, such as databases, web services, or other components.

JUnit and Mockito are two widely used libraries for unit testing in Java applications, including Spring Boot applications. JUnit is a robust testing framework that simplifies the creation, and maintenance of tests. Mockito is a flexible mocking framework that allows you to create mock objects for dependencies, enabling you to isolate the unit under test.

#### JUnit

JUnit is an open-source testing framework for Java that provides annotations and assertions to facilitate the creation of test cases. It allows you to define test methods, set up test environments, and verify expected outcomes.

Key Features of JUnit:

- Annotations to define test methods, setup, and teardown methods.
- Assertions to verify expected outcomes.
- Test runners to execute tests and report results.

#### Mockito

Mockito is a popular mocking framework for Java that allows you to create mock objects for dependencies. Developers often use it when testing components that interact with external systems, such as databases or web services. By using mock objects, you can isolate the unit under test and control the behavior of its dependencies.

Key Features of Mockito:

- Create mock objects for classes and interfaces.
- Lets you stub methods to return specific values or throw exceptions.
- Verify how many times a method was called and with what arguments.
- Supports argument matchers for flexible verification.

#### Testing the Service Layer with Mocking

Developers test the service layer in a Spring Boot application by writing unit tests for each service method with JUnit. They use Mockito to mock the repository interface, which is a dependency of the service layer. This allows them to isolate the service layer and test its behavior without relying on the actual database.

By mocking the repository layer, developers create test scenarios in which the service layer returns specific data or throws exceptions. They use the `@Mock` annotation to create a mock instance of the repository interface and call the `when` method to stub the repository methods.

Together, JUnit and Mockito provide a comprehensive solution for unit testing in Spring Boot applications. They help ensure that individual components behave as expected, leading to more reliable and maintainable code.

### Real World Application

Unit testing plays a crucial role in ensuring the reliability and maintainability of software by validating individual components in isolation to ensure they function as expected.

Examples include:

- **E-commerce Applications**
  E-commerce platforms require robust backend systems to manage customer data, product inventory, and order processing. Unit testing with JUnit and Mockito enables developers to verify the functionality of components, including user registration, login, cart management, and payment processing, thereby ensuring system stability and reliability.

- **Financial Services**
  Banking and financial applications require high security and accuracy for transactions, account management, and the generation of reports. Unit testing with Spring Boot, JUnit, and Mockito helps developers maintain complex financial tools while minimizing the risk of bugs and ensuring compliance with regulations.

- **Internet of Things (IoT)**
  IoT applications often involve numerous interconnected devices that require reliable and efficient software components. Spring Boot is a popular choice for building microservices in IoT systems, and unit testing validates individual components to ensure the system performs smoothly and securely.

- **Healthcare Systems**
  Healthcare applications handle sensitive data and demand high availability, accuracy, and security. Unit testing with JUnit and Mockito enables rigorous testing of components responsible for managing patient data, scheduling appointments, and billing.

- **Content Management Systems (CMS)**
  CMS applications manage user-generated content, including text, images, and videos. Spring Boot helps build scalable, modular CMS platforms, and unit testing ensures that content editors, media uploaders, and authentication systems function correctly, providing a stable and secure platform.

In conclusion, unit testing with JUnit and Mockito is essential for ensuring the quality and reliability of software applications across various industries. By isolating components and verifying their behavior, developers can create robust, maintainable, and secure applications that meet the demands of modern software development.

### Implementation

In this guide, we explore the implementation of unit testing in Spring Boot applications using JUnit and Mockito.

#### Step 1: Add Dependencies

```xml
<dependencies>
    <!-- JUnit 5 and Spring Boot Test with Mockito -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
    <!-- Lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.26</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

#### Step 2: Create Model Class

```java
import lombok.Data; // Using Lombok for boilerplate code reduction

@Data // Lombok annotation to generate getters, setters, toString, etc.
public class Customer {
    private Long id;
    private String name;
    private String email;

    // Constructors, getters, setters, toString, etc. will be generated by Lombok
}
```

#### Step 3: CustomerRepository Interface

```java
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
  Customer save(Customer customer);
  Optional<Customer> findById(Long id);
  void delete(Customer customer);
  List<Customer> findAll();
```

#### Step 4: CustomerService Class

```java
@Service
@AllArgsConstructor // Lombok annotation to generate constructor with all arguments
public class CustomerService {
  private final CustomerRepository customerRepository;

  public List<Customer> getAllCustomers() {
    return customerRepository.findAll();
  }

  public Customer getCustomerById(Long id) {
    return customerRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
  }

  public Customer createCustomer(Customer customer) {
    return customerRepository.save(customer);
  }

  public Customer updateCustomer(Long id, Customer customerDetails) {
    Customer existingCustomer = getCustomerById(id);
    existingCustomer.setName(customerDetails.getName());
    existingCustomer.setEmail(customerDetails.getEmail());
    return customerRepository.save(existingCustomer);
  }

  public void deleteCustomer(Long id) {
    Customer existingCustomer = getCustomerById(id);
    customerRepository.delete(existingCustomer);
  }
}
```

> Note: We do not need `@Autowired` when using constructor injection with Lombok's `@AllArgsConstructor`.

#### Step 5: CustomerServiceTest Class

```java
@ExtendWith(MockitoExtension.class) // Enable Mockito annotations
public class CustomerServiceTest {
  // Test cases will go here in the next step
}
```

The `@ExtendWith(MockitoExtension.class)` annotation integrates Mockito with JUnit 5, allowing the use of Mockito annotations like `@Mock` and `@InjectMocks` in the test class. This also allows automatic mock initialization and injection without needing to call `MockitoAnnotations.openMocks(this)` manually.

#### Step 6: Mocking Dependencies

```java
@ExtendWith(MockitoExtension.class) // Enable Mockito annotations
public class CustomerServiceTest {
  @Mock
  private CustomerRepository customerRepository; // Mock the repository dependency

  @InjectMocks
  private CustomerService customerService; // Inject the mock into the service
}
```

- `@Mock` creates a mock instance of the `CustomerRepository` interface. This mock will simulate the behavior of the actual repository without interacting with a real database. It allows us to define specific behaviors for the repository methods during testing.
- `@InjectMocks` creates an instance of the `CustomerService` class and injects the mocked `CustomerRepository` into it. This allows us to test the service layer in isolation, ensuring that any interactions with the repository are controlled and predictable.

#### Step 7: Writing Test Cases

```java
@ExtendWith(MockitoExtension.class) // Enable Mockito annotations
public class CustomerServiceTest {
  @Mock
  private CustomerRepository customerRepository; // Mock the repository dependency

  @InjectMocks
  private CustomerService customerService; // Inject the mock into the service

  @Test // Test case for creating a customer
  public void testCreateCustomer()  {
    Customer customer = new Customer();
    customer.setFirstName("John");
    customer.setLastName("Doe");

    when(customerRepository.save(customer)).thenReturn(customer); // Mock the save method

    Customer createdCustomer = customerService.createCustomer(customer);

    verify(customerRepository, times(1)).save(customer); // Verify save was called once
  }

  @Test // Test case for retrieving a customer by ID
  public void testGetCustomerById() {
    Long customerId = 1L;
    Customer customer = new Customer();
    customer.setId(customerId);
    customer.setFirstName("John");
    customer.setLastName("Doe");

    when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer)); // Mock findById // Returns Optional meaning it may or may not contain a value

    Customer foundCustomer = customerService.getCustomerById(customerId);

    assertNotNull(foundCustomer); // Assert that the customer is not null
    assertEquals(customerId, foundCustomer.getId()); // Assert that the IDs match
    verify(customerRepository, times(1)).findById(customerId); // Verify findById was called once
  }

  @Test // Test case for deleting a customer
  public void testDeleteCustomer() {
    Customer customer = new Customer();
    customer.setId(1L);
    customer.setFirstName("John");
    customer.setLastName("Doe");

    when(customerRepository.findById(1L)).thenReturn(Optional.of(customer)); // Mock findById

    customerService.deleteCustomer(1L); // Call the delete method

    verify(customerRepository, times(1)).findById(1L); // Verify findById was called once
    verify(customerRepository, times(1)).delete(customer); // Verify delete was called once
  }
}
```

w
