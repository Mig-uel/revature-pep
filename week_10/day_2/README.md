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

## Testing RESTful APIs with MockMvc and RestTemplate

#### What is Integration Testing?

Integration testing is a type of software testing that focuses on verifying the interactions and integration between different components or modules of an application. Unlike unit testing, which tests individual components in isolation, integration testing ensures that these components work together as expected when combined.

In a Spring Boot application, integration testing typically involves testing the interaction between various layers of the application, such as the controller layer, service layer, and repository layer. It may also involve testing the integration with external systems, such as databases, web services, or messaging systems.
These tests evaluate the application's overall behavior rather than just individual units, ensuring that the components work together correctly and that data flows seamlessly through the application.

Integration tests start the Spring application context, allowing you to test the application in an environment that closely resembles production. This helps verify that endpoints map correctly, responses generate as expected, and injected dependencies collaborate properly. Integration testing catches issues that unit tests might miss, such as misconfigurations, incorrect mappings, or problems with data serialization/deserialization.

**MockMvc** and **RestTemplate** both test RESTful APIs in Spring Boot applications, but they serve different purposes and are used in different contexts.

#### What is MockMvc and its Purpose?

`MockMvc` is a testing framework provided by Spring that allows you to test your Spring MVC controllers in isolation without starting a full web server. It is lightweight and fast, making it ideal for controller-level integration tests.

With `MockMvc`, you can simulate HTTP requests to your controllers and verify the responses, status codes, headers, and content. It provides a fluent API for building requests and assertions, making it easy to write and read tests.

```java
@SpringBootTest // Load the full application context // All beans are created and autowired
@AutoConfigureMockMvc // Enable and configure MockMvc
public class UserControllerMockMvcTest {
  @Autowired
  private MockMvc mockMvc; // Inject MockMvc instance

  @Test
  public void testGetUserById() throws Exception {
    mockMvc.perform(get("/users/{id}", 1L)) // Perform GET request to /users/1
        .andExpect(status().isOk()) // Expect HTTP 200 OK status
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)) // Expect JSON response
        .andExpect(jsonPath("$.id").value(1L)) // Expect id field to be 1
        .andExpect(jsonPath("$.name").value("John Doe")); // Expect name field to be "John Doe"
  }
}
```

- `@SpringBootTest`: This annotation loads the full application context, allowing you to test the entire application with all its beans created and autowired.
- `@AutoConfigureMockMvc`: This annotation enables and configures `MockMvc` for the test class, allowing you to inject a `MockMvc` instance.
- `mockMvc.perform(get("/users/{id}", 1L))`: This line performs a GET request to the `/users/1` endpoint.
- `.andExpect(...)`: These methods are used to set expectations for the response, such as the status code, content type, and specific JSON fields.

`MockMvc` simulates a request to the controller and endpoint without starting a web server, making it fast and efficient for testing controller logic.

#### What is RestTemplate and its Purpose?

`RestTemplate` is a Spring Class for making HTTP requests to RESTful web services. It is typically used in integration tests where you want to test the interaction between your application and an external service or API. It supports common HTTP methods like `GET`, `POST`, `PUT`, `DELETE`, etc and primarily handles synchronous requests (blocking calls). For asynchronous requests, you can use `WebClient` from the Spring WebFlux module.

In integration tests, `RestTemplate` validates interactions between your application and external services, ensuring that requests are correctly formed and responses are properly handled. It is often used for service-layer integration tests and can also test your controller layer. Unlike `MockMvc`, `RestTemplate` requires a running web server to send actual HTTP requests, which makes it slower and less isolated.

```java
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // Start server on random port
public class UserControllerRestTemplateTest {
  @LocalServerPort
  private int port; // Inject the random port number

  @Autowired
  private TestRestTemplate restTemplate; // Inject TestRestTemplate instance

  @Test
  public void testGetUserById() {
    String url = "http://localhost:" + port + "/users/1"; // Construct URL with random port

    User user = restTemplate.getForObject(url, User.class); // Perform GET request to /users/1

    assertThat(user.getId()).isEqualTo(1L); // Assert that the id is 1
  }
}
```

- `@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)`: This annotation starts the Spring Boot application on a random port, allowing you to test the application with a running web server.
- `@LocalServerPort`: This annotation injects the random port number into the test class.
- `@Autowired`: This annotation injects a `TestRestTemplate` instance, which is a convenient subclass of `RestTemplate` for integration testing.
- `restTemplate.getForObject(url, User.class)`: This line performs a GET request to the specified URL and maps the response to a `User` object.
- `assertThat(user.getId()).isEqualTo(1L)`: This assertion verifies that the `id` field of the returned `User` object is equal to `1L`.

#### Comparison of MockMvc and RestTemplate

| Feature      | MockMvc                                                            | RestTemplate/TestRestTemplate                                                                                             |
| ------------ | ------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------- |
| Server       | No server required; tests controllers in isolation                 | Requires a running web server; tests full application context                                                             |
| Scope        | Controller layer only                                              | Tests the controller together with services, repositories, databases, and other beans                                     |
| Dependencies | Allows mocking dependencies, making tests faster and more isolated | Uses real dependencies, making tests slower and less isolated but more realistic                                          |
| Performance  | Fast and lightweight due to no server startup                      | Slower due to server startup and actual HTTP requests                                                                     |
| Use Case     | Ideal for unit testing controllers and verifying request/response  | Ideal for integration testing and verifying end-to-end functionality (controller + service + repository working together) |

### Real World Application

Here's a sample enterprise-level application where MockMVC and RESTTemplate could be used for integration testing:

**Application**: E-commerce platform
**Description**: An online marketplace where vendors sell products to customers.
**Scenario**: Testing the checkout process, including adding items to a cart, entering shipping and payment details, and submitting the order.

**Steps**:

1. Use MockMVC to simulate adding items to a cart (POST /cart with product IDs and quantities).
2. Use RESTTemplate to call /shipping and retrieve available shipping options.
3. Use MockMVC to send shipping information to /checkout.
4. Use RESTTemplate to submit payment information to the payment gateway API.
5. Verify the order exists in the database with the correct details.

This approach ensures robust, reliable, and secure functionality by simulating requests and responses between internal and external systems, thereby guaranteeing seamless integration.

### Implementation

Below is a demonstration of testing a controller layer with `MockMvc` and `RestTemplate` in a Spring Boot application.

#### Step 1: Define User Model

```java
@Data // Lombok annotation to generate getters, setters, toString, etc.
public class User {
    private Long id;
    private String username;
    private String email;

    // Constructors, getters, setters, toString, etc. will be generated by Lombok
}
```

#### Step 2: Define the UserRepository Interface

```java
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  User save(User user);
  Optional<User> findById(Long id);
  void delete(User user);
  List<User> findAll();
}
```

#### Step 3: Define the UserService Class

```java
@Service // Marks this class as a Spring service component
@AllArgsConstructor // Lombok annotation to generate constructor with all arguments
public class UserService {
  private final UserRepository userRepository;

  public User createUser(User user) {
    return userRepository.save(user);
  }

  public User getUserById(Long id) {
    return userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
  }

  public User updateUser(Long id, User userDetails) {
    User existingUser = getUserById(id);
    existingUser.setUsername(userDetails.getUsername());
    existingUser.setEmail(userDetails.getEmail());
    return userRepository.save(existingUser);
  }

  public void deleteUser(Long id) {
    User existingUser = getUserById(id);
    userRepository.delete(existingUser);
  }
}
```

#### Step 4: Define the UserController Class

```java
@RestController // Marks this class as a REST controller
@RequestMapping("/api/users") // Base URL for all endpoints in this controller
public class UserController {
  @Autowired
  private UserService userService;

  @PostMapping // Handles HTTP POST requests to /api/users
  public ResponseEntity<User> createUser(@RequestBody User user) {
    User createdUser = userService.createUser(user);
    return new ResponseEntity<>(createdUser, HttpStatus.CREATED); // Return 201 Created status
  }

  @GetMapping("/{id}") // Handles HTTP GET requests to /api/users/{id}
  public ResponseEntity<User> getUserById(@PathVariable Long id) {
    User user = userService.getUserById(id);
    return ResponseEntity.ok(user); // Return 200 OK status
  }

  @PutMapping("/{id}") // Handles HTTP PUT requests to /api/users/{id}
  public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
    User updatedUser = userService.updateUser(id, user);
    return ResponseEntity.ok(updatedUser); // Return 200 OK status
  }

  @DeleteMapping("/{id}") // Handles HTTP DELETE requests to /api/users/{id}
  public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    userService.deleteUser(id);
    return ResponseEntity.noContent().build(); // Return 204 No Content status
  }
}
```

This controller handles CRUD operations for the `User` entity, providing endpoints to create, retrieve, update, and delete users and returns JSON responses with appropriate HTTP status codes. The `UserService` contains the business logic for managing users and is injected into the controller using field injection with `@Autowired`.

#### Step 5: Create Test Suite with MockMvc and RestTemplate

```java
@SpringBootTest // Load the full application context
@AutoConfigureMockMvc // Enable and configure MockMvc
public class UserControllerMockMvcTest {
  @Autowired
  private MockMvc mockMvc; // Inject MockMvc instance

  @MockBean
  private UserService userService; // Mock the UserService dependency

  @MockBean
  private UserRepository userRepository; // Mock the UserRepository dependency

  @Mock
  private RestTemplate restTemplate; // Mock RestTemplate for external API calls

  @Captor
  private ArgumentCaptor<User> userCaptor; // Capture User arguments passed to methods

  @Autowired
  private ObjectMapper objectMapper; // For JSON serialization/deserialization
}
```

This test setup:

- Loads the full application context with `@SpringBootTest`.
- Configures `MockMvc` for testing the controller layer (HTTP requests and responses) with `@AutoConfigureMockMvc`.
- Mocks the `UserService` and `UserRepository` dependencies using `@MockBean`, allowing you to define their behavior in tests.
- Mocks `RestTemplate` to simulate external API calls without making real HTTP requests.
- Uses `@Captor` to capture `User` arguments passed to methods for verification. For example, you can verify that the correct `User` object was passed to the `createUser` method.
- Injects `ObjectMapper` for JSON serialization and deserialization, which is useful for converting between Java objects and JSON strings in tests.

#### Step 6: Write Integration Tests for UserController

This file includes detailed `@Test` methods for demonstrating the use of `MockMvc` and `RestTemplate` usage for:

- Creating a user with `POST /api/users`
- Retrieving a user by ID with `GET /api/users/{id}`
- Updating a user with `PUT /api/users/{id}`
- Deleting a user with `DELETE /api/users/{id}`
- Listing all users with `GET /api/users`

Each test:

- Sets up data and mocks behavior for dependencies.
- Performs HTTP requests using `MockMvc`.
- Asserts the expected outcomes, including status codes and response content.
- Verifies interactions with mocked dependencies using Mockito.

```java
@Test // Test case for creating a user
  public void testCreateUser() throws Exception {
    User user = new User();
    user.setUsername("johndoe");
    user.setEmail("johndoe@example.com");

    when(userService.createUser(any(User.class))).thenReturn(user); // Mock the createUser method

    mockMvc.perform(post("/api/users") // Perform POST request to /api/users
            .contentType(MediaType.APPLICATION_JSON) // Set content type to JSON
            .content(objectMapper.writeValueAsString(user))) // Convert user object to JSON string
        .andExpect(status().isCreated()) // Expect HTTP 201 Created status
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)) // Expect JSON response
        .andExpect(jsonPath("$.username").value("johndoe")) // Expect username field to be "johndoe"
        .andExpect(jsonPath("$.email").value("johndoe@example.com"));

    verify(userService, times(1)).createUser(userCaptor.capture()); // Capture the User argument
    User capturedUser = userCaptor.getValue();
    assertEquals("johndoe", capturedUser.getUsername()); // Assert that the username is correct
    assertEquals("johndoe@example.com", capturedUser.getEmail()); // Assert that the email is correct
  }
```

## Intro to Integration Testing

### Integration Testing in Software Development

Integration testing is a critical phase in the software development lifecycle that focuses on verifying the interactions and integration between different components or modules of an application. Unlike unit testing, which tests individual components in isolation, integration testing ensures that these components work together as expected when combined. In this phase, you combine individual software modules and test them collectively to ensure they function correctly as a group.

### Why Integration Testing Matters

Modern software systems often consist of multiple interconnected components, such as databases, web services, and third-party APIs. These components must work together seamlessly to deliver the desired functionality.

While unit tests verifies that individual parts of a system function correctly, integration tests validate that these parts interact properly. This is crucial because even if each component works perfectly in isolation, issues can arise when they are integrated. Integration testing helps identify problems related to data flow, communication protocols, and overall system behavior.

#### Levels of Integration Testing

Integration testing can be performed at various levels, including:

- **Component Integration Testing**: Testing the interaction between individual components or modules within a single application.
- **System Integration Testing**: Testing the interaction between different systems or applications, such as a web application and a database.
- **End-to-End Testing**: Testing the entire application flow from start to finish, simulating real user scenarios.

#### Integration Testing in Spring Boot Applications

Spring provides strong support for integration testing through its testing framework. Spring Boot provides annotations such as `@SpringBootTest` and `@DataJpaTest` to help you create application contexts with the required configuration for your tests.

In a spring application, you may need to test interactions between:

- Service and repository layers
- Your application and the database
- Your application and other Spring Boot components, such as caching or Actuator endpoints
- Your application and external systems, such as RESTful APIs or message brokers

The Spring Boot Test module also offers additional tools and annotations that simplify integration testing across the Spring ecosystem.

### Real World Application

Integration testing ensures software quality across various industries by verifying that components function correctly together.

**E-commerce Platforms**
E-commerce platforms integrate various components, including the user interface, payment gateway, product catalog, and shipping module. Integration testing confirms these components work together to provide a seamless customer experience.

**Banking Systems**
Banking systems connect multiple subsystems, including user accounts, transaction processing, and credit card services. Comprehensive integration testing prevents glitches that could result in financial losses or damage a bank's reputation.

**Healthcare Systems**
Healthcare applications, such as Electronic Health Records (EHRs), integrate patient data, billing, insurance, pharmacy, and laboratory systems to facilitate seamless patient care. Integration testing ensures these systems communicate correctly, preventing errors that could affect patient care.

**Social Media Platforms**
Social media platforms integrate features like user profiles, messaging, notifications, and news feeds. Integration testing ensures smooth communication between these modules for a consistent user experience.

**Enterprise Resource Planning (ERP) Systems**
ERP systems unify business functions, including finance, HR, and supply chain management. Integration testing ensures that data flows accurately across these functions, reducing the risk of operational issues in production.

### Implementation

Here's a step-by-step guide to setting up integration testing in a Spring Boot application using the `@SpringBootTest` annotation.

#### Step 1: Add Dependencies

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
```

#### Step 2: Create an Integration Test Class

Place your integration test class in the `src/test/java` directory, typically in the same package as the class being tested. Annotate the class with `@SpringBootTest` to load the full application context during testing.

```java
@SpringBootTest // Load the full application context
class ExampleIntegrationTest {
  @Test // Mark this method as a test case
  void contextLoads() {
    // Test to ensure the application context loads successfully
  }
}
```

#### Step 3: Inject Dependencies

Use Spring's dependency injection to access components, services, or utilities within your test class. For example, inject a `TestRestTemplate` to perform HTTP requests against your application during integration tests.

```java
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // Start server on random port
class ExampleIntegrationTest {
  @Autowired
  private TestRestTemplate restTemplate; // Inject TestRestTemplate instance

  @Test
  void contextLoads() {
    // Test to ensure the application context loads successfully
    // Execute test logic using the injected restTemplate
  }
 }
```

#### Step 4: Write Integration Test Methods

Use the injected components to perform actions and validate the expected results with assertions from libraries like JUnit or AssertJ.

```java
@Test
void testGetEndpoint() {
  ResponseEntity<String> response = restTemplate.getForEntity("/api/example", String.class);
  assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
  assertEquals("Expected Response", response.getBody());
}
```

#### Step 5: Run the Tests

- **In an IDE**: Right-click the test class or method and select "Run".
- **Using Maven**: Run `mvn test` from the command line to execute all tests in the project.

Integration tests typically take longer than unit tests due to the need to start the application context and interact with multiple components. However, they provide valuable insights into the overall behavior of the application and help identify issues that may not be apparent in isolated unit tests.

In summary, integration testing confirms that your application's components work together as intended, ensuring a reliable and robust software system.
