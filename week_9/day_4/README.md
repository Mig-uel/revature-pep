# Spring and Spring Boot Basics - Day 4

## Controllers and `@Controller` Annotation

In Spring Web, a **Controller** is a class that acts as the entry point for handling HTTP requests. Controllers are responsible for processing incoming requests, preparing a model, and returning the appropriate view to be rendered.

Controllers follow the Model-View-Controller (MVC) design pattern, separating business logic, user interface, and request handling.

#### `@Controller`

The `@Controller` annotation is used to define a controller class in Spring. It marks a class as a Spring MVC controller, allowing it to handle web requests and typically returns a view name to be rendered.

Example:

```java
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class MyController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("message", "Hello, Spring MVC!");
        return "hello";
    }
}
```

In this example, `MyController` is a controller class that handles GET requests to the `/hello` endpoint. It adds a message to the model and returns the view name `hello`, which corresponds to a template (e.g., `hello.html`).

#### `@RestController`

The `@RestController` annotation is a convenience annotation that combines `@Controller` and `@ResponseBody`. It is used to create RESTful web services where the controller methods return data directly (usually in JSON or XML format) instead of rendering a view.

Example:

```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MyRestController {

    @GetMapping("/api/hello")
    public Map<String, String> hello() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, Spring REST!");
        return response;
    }
}
```

In this example, `MyRestController` is a REST controller that handles GET requests to the `/api/hello` endpoint. It returns a JSON response containing a message.

#### Key Annotations

- `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`: These annotations are used to map HTTP methods to specific controller methods.
- `@RequestParam`: Used to bind request parameters to method parameters.
- `@PathVariable`: Used to bind URI template variables to method parameters (e.g., `/users/{id}`).
- `@RequestBody`: Used to bind the body of a request to a method parameter, typically for POST or PUT requests.
- `@ResponseBody`: Indicates that the return value of a method should be used as the response body, typically in RESTful services.
- `@RequestMapping`: A more general annotation that can be used to map HTTP requests to handler methods, supporting multiple HTTP methods and paths (e.g., `@RequestMapping(value = "/path", method = RequestMethod.GET)`).

### Real World Example

Controllers are at the heart of any Spring MVC application. They handle user interactions, process data, and return appropriate responses. For instance, in an e-commerce application, controllers would manage product listings, user authentication, order processing, and more.

Some real-world use cases include:

1. **E-commerce Applications**: Controllers manage product catalogs, shopping carts, and order processing.
   - Displaying product listings (`@GetMapping("/products")`)
   - Adding products to the cart (`@PostMapping("/cart/add")`)
   - Viewing order history (`@GetMapping("/orders")`)
2. **Banking Systems**: Controllers handle account management, transactions, and user authentication.
   - Viewing account details (`@GetMapping("/account/{id}")`)
   - Performing transactions (`@PostMapping("/transaction")`)
   - User login and registration (`@PostMapping("/login")`, `@PostMapping("/register")`)
3. **Educational Platforms**: Controllers manage courses, student enrollments, and content delivery.
   - Listing available courses (`@GetMapping("/courses")`)
   - Enrolling in a course (`@PostMapping("/enroll")`)
   - Accessing course materials (`@GetMapping("/course/{id}/materials")`)

By managing and routing client requests, controllers play a crucial role in the functionality and user experience of web applications built with Spring and Spring Boot.

### Implementation

In this section, we will implement both a traditional Spring MVC controller using `@Controller` and a RESTful controller using `@RestController`. We will also introduce a Data Transfer Object (DTO) to demonstrate how data can be transferred between the client and server.

#### 1: `@Controller` Example

```java
@Controller // Indicates that this class is a Spring MVC controller
public class WebPageController {
    @GetMapping("/greeting") // Maps GET requests to /greeting to this method
    // Takes in a Model object to pass data to the view
    public String greeting(Model model) {
        // Adds a message to the model to be used in the view
        model.addAttribute("message", "Welcome to Spring MVC!"); // Adds a message to the model and can be accessed in the view via ${message}

        // Returns the name of the view (e.g., greeting.html)
        return "greeting"; // Returns the name of the view (e.g., greeting.html)
    }
}
```

Explanation:

- The `WebPageController` class is annotated with `@Controller`, indicating that it is a Spring MVC controller. Spring will detect this class and register it as a controller in the application context. This is also a bean managed by Spring.
- The `greeting` method is mapped to handle GET requests to the `/greeting` endpoint using the `@GetMapping` annotation.
- The method takes a `Model` object as a parameter, which is used to pass data to the view.
- Inside the method, we add an attribute named `message` to the model with the value "Welcome to Spring MVC!" which can be accessed in the view using `${message}`.
- Finally, the method returns the name of the view (`greeting`), which corresponds to a template file (e.g., `greeting.html`).
- This is server-side rendering, where the server generates the HTML view and sends it to the client.

#### 2: `@RestController` Example

```java
@RestController // Indicates that this class is a RESTful controller
// Combines @Controller and @ResponseBody, meaning methods return data directly
@RequestMapping("/api") // Base path for all endpoints in this controller
public class ApiController {
    @GetMapping("/status") // Maps GET requests to /api/status to this method
    public Map<String, String> getStatus() {
        Map<String, String> response = getStatus();
        response.put("status", "Service is running");
        response.put("framework", "Spring Boot");
        return response; // Returns a JSON response with status information
    }

    @PostMapping("/submit") // Maps POST requests to /api/submit to this method
    // Accepts a DataDTO object from the request body
    // The @RequestBody annotation binds the incoming JSON to the DataDTO object
    public ResponseEntity<String> submitData(@RequestBody DataDTO data) {
        // Simulate processing the received data
        String message = String.format("Received data for %s aged %d", data.getName(), data.getAge());

        // Return a success response
        return ResponseEntity.ok(message); // Returns a 200 OK response with a message
    }
}
```

Explanation:

- The `ApiController` class is annotated with `@RestController`, indicating that it is a RESTful controller. This annotation combines `@Controller` and `@ResponseBody`, meaning that the methods in this class will return data directly (usually in JSON format) instead of rendering a view.
- The class is also annotated with `@RequestMapping("/api")`, which sets a base path for all endpoints in this controller. All endpoints will be prefixed with `/api`.
- The `getStatus` method is mapped to handle GET requests to the `/api/status` endpoint using the `@GetMapping` annotation. It returns a JSON response containing the service status and framework information.
- The `submitData` method is mapped to handle POST requests to the `/api/submit` endpoint using the `@PostMapping` annotation. It accepts a `DataDTO` object from the request body, which is automatically deserialized from JSON using the `@RequestBody` annotation.
- Inside the `submitData` method, we simulate processing the received data and create a response message.
- Finally, the method returns a `ResponseEntity` with a 200 OK status and the response message.
- Where does `ResponseEntity` come from? It is part of the `org.springframework.http` package and is used to represent the entire HTTP response, including status code, headers, and body.

#### 3: Data Transfer Object (DTO)

```java
public class MyDTO {
    private String name;
    private int age;

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
```

Explanation:

- The `MyDTO` class is a simple Data Transfer Object (DTO) that contains two fields: `name` (of type `String`) and `age` (of type `int`).
- It includes getter and setter methods for both fields, allowing other classes to access and modify the values of `name` and `age`.
- DTOs are commonly used to transfer data between different layers of an application, such as between the client and server in a RESTful API.
- In the `ApiController`, the `submitData` method accepts a `MyDTO` object as a parameter, which is populated with data from the incoming JSON request body.
- This allows for a clean separation of data representation and business logic, making the code more maintainable and easier to understand.
- Can we validate the DTO? Yes, we can use annotations from the `javax.validation.constraints` package (e.g., `@NotNull`, `@Size`, `@Min`, `@Max`) to enforce validation rules on the fields of the DTO. Additionally, we can use the `@Valid` annotation in the controller method parameter to trigger validation.
- And can we return validation errors? Yes, if the DTO is invalid, Spring will automatically return a 400 Bad Request response with details about the validation errors.
- Is this similar to NestJS DTOs? Yes, the concept of DTOs is similar in both Spring and NestJS. In both frameworks, DTOs are used to define the structure of data being transferred between the client and server, and they help ensure that the data adheres to specific validation rules.
- Spring uses Jackson (by default) for JSON serialization and deserialization, while NestJS uses the `class-transformer` and `class-validator` libraries for similar purposes.
- You must include both **getters and setters** in the DTO class for Spring to properly serialize and deserialize the object. Without these methods, Spring will not be able to access the fields of the DTO, leading to issues when processing incoming requests or generating responses.

#### Bonus Tips

- To enable automatic JSON serialization and deserialization, ensure that you have the `spring-boot-starter-web` dependency in your `pom.xml` or `build.gradle` file. This starter includes Jackson, which is the default JSON processor for Spring Boot.
- Use `@Valid` with `@RequestBody` and annotate DTO fields with validation constraints (e.g., `@NotNull`, `@Size`) to enforce data integrity and automatically handle validation errors.
- Combine controllers wit service layers to separate business logic from request handling, promoting cleaner and more maintainable code.

---

With this setup, you are now able to:

- Serve dynamic web pages with MVC.
- Handle API request with REST endpoints.
- Bind and validate request data cleanly using DTOs.

## `@RequestMapping` & `@ResponseBody`

#### `@RequestMapping`

In Spring MVC, the `@RequestMapping` annotation is used to map HTTP requests to handler methods in controller classes. It can be applied at both the class level and the method level. It allows developers to define which method should handle a particular URL pattern and HTTP method (such as GET, POST, PUT, DELETE). The `@RequestMapping` annotation can also specify additional attributes such as headers, parameters, and content types.

You can use `@RequestMapping` at the class level to specify a common base URL for all methods in the controller, and then use it at the method level to define specific endpoints. This is useful for organizing related endpoints within a single controller.

```java
@Controller
@RequestMapping("/api") // Base path for all endpoints in this controller
public class ApiController {
    // Handler methods go here...
}
```

You can use `@RequestMapping` at the method level to further specify the HTTP method and path for each endpoint. This allows you to have multiple handler methods within the same controller, each handling different HTTP methods or paths.

```java
@Controller // Indicates that this class is a Spring MVC controller
@RequestMapping("/api") // Base path for all endpoints in this controller
public class ApiController {
    @RequestMapping("/hello", method = RequestMethod.GET) // Maps GET requests to /api/hello to this method
    public String hello() {
        // Handle GET request
        return "Hello, World!";
    }

    @RequestMapping("/save", method = RequestMethod.POST) // Maps POST requests to /api/save to this method
    public String saveData() {
        // Handle POST request
        return "Data saved!";
    }
}
```

The `@RequestMapping` annotation provides attributes for configuring request mappings to further refine the mapping conditions. Some commonly used attributes include:

- `value` or `path`: Specifies the URL pattern to which the method should respond. You can use either `value` or `path`, but not both.

```java
@RequestMapping(value = "/example") // or @RequestMapping(path = "/example")
```

- `method`: Specifies the HTTP method (e.g., GET, POST, PUT, DELETE) that the method should handle. This is typically set using the `RequestMethod` enum provided by Spring (e.g., `RequestMethod.GET`, `RequestMethod.POST`).

```java
@RequestMapping(value = "/example", method = RequestMethod.GET)
```

- `params`: Specifies request parameters that must be present for the method to be invoked. This can be useful for differentiating between methods that handle the same URL but require different parameters.

```java
@RequestMapping(value = "/example", method = RequestMethod.GET, params = "type=admin")
```

- `headers`: Specifies request headers that must be present for the method to be invoked. This can be useful for handling requests with specific headers.

```java
@RequestMapping(value = "/example", method = RequestMethod.GET, headers = "X-Custom-Header=Value")
```

- `consumes`: Specifies the media types that the method can consume. This is useful for handling requests with specific content types (e.g., `application/json`).

```java
@RequestMapping(value = "/example", method = RequestMethod.POST, consumes = "application/json")
```

- `produces`: Specifies the media types that the method can produce. This is useful for handling responses with specific content types (e.g., `application/json`).

```java
@RequestMapping(value = "/example", method = RequestMethod.GET, produces = "application/json")
```

#### `@ResponseBody`

The `@ResponseBody` annotation in Spring MVC is used to indicate that the return value of a method should be written directly to the HTTP response body, rather than being interpreted as a view name. This is particularly useful for creating RESTful web services where you want to return data (such as JSON or XML) directly to the client.

This annotation is typically used at the class level or method level within a controller. When applied at the class level, it indicates that all methods in the class will return data directly in the response body. When applied at the method level, it indicates that only that specific method will return data in the response body.

When a method is annotated with `@ResponseBody`, Spring will automatically convert the return value to the appropriate format based on the client's request (e.g., JSON, XML) using message converters. This allows you to easily create endpoints that return data without needing to create separate view templates.

```java
@Controller
public class MyController {
    @GetMapping("/data")
    @ResponseBody // Indicates that the return value should be written directly to the response body
    public Map<String, String> getData() {
        Map<String, String> data = new HashMap<>();
        data.put("key", "value");
        return data; // This will be converted to JSON and sent in the response body
    }
}
```

### Real World Application

URLs like `/login`, `/register`, `/user`, `/admin`, and `/addProduct` can be mapped to specific controller methods using `@RequestMapping` or its specialized variants like `@GetMapping`, `@PostMapping`, etc. These mappings help in organizing the endpoints of a web application and defining how different HTTP requests should be handled.

The `@ResponseBody` annotation ensures that the view type returned for each of the above requests generate the appropriate response format (e.g., JSON, XML) directly in the HTTP response body, making it suitable for RESTful APIs.

### Implementation

Below is an example of using `@RequestMapping` and `@ResponseBody` annotations.

```java
@Controller // Indicates that this class is a Spring MVC controller
@RequestMapping("/api/users") // Base path for all endpoints in this controller
public class UserController {
    @RequestMapping("/register", method = RequestMethod.POST) // Maps POST requests to /api/users/register to this method
    public @ResponseBody User register(@RequestBody User user) {
        // Simulate user registration logic
        user.setId(1L); // Simulate setting an ID after registration
        return user; // Returns the registered user as JSON in the response body
    }

    @RequestMapping("/login", method = RequestMethod.POST) // Maps POST requests to /api/users/login to this method
    public @ResponseBody User login(@RequestBody LoginRequest loginRequest) {
        // Login logic here
    }

    @RequestMapping("/{userId}", method = RequestMethod.GET) // Maps GET requests to /api/users/{userId} to this method
    public @ResponseBody User getUserProfile(@PathVariable Long userId) {
        // Fetch user profile logic here
    }

    @RequestMapping("/{userId}", method = RequestMethod.PUT) // Maps PUT requests to /api/users/{userId} to this method
    @ResponseBody
    public User updateUserProfile(@PathVariable Long userId, @RequestBody User updatedUser) {
        // Update user profile logic here
        return updatedUser;
    }
}
```

Clients can perform requests such as a `POST` request to `/api/users/register` or a `GET` request to `/api/users/{userId}` to interact with the user management functionality of the application.
