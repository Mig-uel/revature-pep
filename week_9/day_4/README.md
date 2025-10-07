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

## HTTP Method Annotations

Spring MVC includes several specialized annotations for mapping HTTP methods to controller methods. These annotations all `@RequestMapping` under the hood but provide a more concise and readable way to define request mappings for specific HTTP methods. They all have the same attributes as `@RequestMapping`, such as `value`, `path`, `params`, `headers`, `consumes`, and `produces`, but they are specifically designed for common HTTP methods.

Here are the commonly used HTTP method annotations in Spring MVC:

- `@GetMapping`: Maps HTTP GET requests to a specific handler method. It is typically used for retrieving resources or data.

```java
@GetMapping("/items") // Maps GET requests to /items to this method
public List<Item> getItems() {
    // Logic to retrieve and return a list of items
}
```

- `@PostMapping`: Maps HTTP POST requests to a specific handler method. It is typically used for creating new resources.

```java
@PostMapping("/items") // Maps POST requests to /items to this method
public Item createItem(@RequestBody Item item) {
    // Logic to create and return the new item
}
```

- `@PutMapping`: Maps HTTP PUT requests to a specific handler method. It is typically used for updating existing resources.

```java
@PutMapping("/items/{id}") // Maps PUT requests to /items/{id} to this method
public Item updateItem(@PathVariable Long id, @RequestBody Item item) {
    // Logic to update and return the item with the specified ID
}
```

- `@DeleteMapping`: Maps HTTP DELETE requests to a specific handler method. It is typically used for deleting resources.

```java
@DeleteMapping("/items/{id}") // Maps DELETE requests to /items/{id} to this method
public void deleteItem(@PathVariable Long id) {
    // Logic to delete the item with the specified ID
}
```

- `@PatchMapping`: Maps HTTP PATCH requests to a specific handler method. It is typically used for partially updating resources.

```java
@PatchMapping("/items/{id}") // Maps PATCH requests to /items/{id} to this method
public Item partiallyUpdateItem(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
    // Logic to partially update and return the item with the specified ID
}
```

These annotations provide a more intuitive way to define request mappings for specific HTTP methods, making the code easier to read and maintain. They are commonly used in RESTful web services to handle different types of operations on resources.

### Real World Application

Each controller method can instead now include the convenience annotations like `@GetMapping`, `@PostMapping`, etc., to clearly indicate the HTTP method being handled. This improves code readability and makes it easier to understand the purpose of each method at a glance.

- `@PostMapping` for adding a new product.
- `@GetMapping` to find all products or a specific product by ID.
- `@DeleteMapping` to remove a product by ID.

### Implementation

Below is an example of using HTTP method annotations.

```java
@RestController("/api/users") // Combines @Controller and @ResponseBody, meaning methods return data directly and sets base path for all endpoints in this controller
public class UserController {
    @PostMapping("/register") // Maps POST requests to /api/users/register to this method
    public User register(@RequestBody User user) {
        // Logic to register user
        return user;
    }

    @PostMapping("/login") // Maps POST requests to /api/users/login to this method
    public User login(@RequestBody LoginRequest loginRequest) {
        // Login logic here
        return user;
    }

    @GetMapping("/{userId}") // Maps GET requests to /api/users/{userId} to this method
    public User getUserProfile(@PathVariable Long userId) {
        // Fetch user profile logic here
        return user;
    }

    @PutMapping("/{userId}") // Maps PUT requests to /api/users/{userId} to this method
    public User updateUserProfile(@PathVariable Long userId, @RequestBody User updatedUser) {
        // Update user profile logic here
        return updatedUser;
    }
}
```

We can see clients can perform requests such as a `POST` request to `/api/users/register` or a `GET` request to `/api/users/{userId}` to interact with the user management functionality of the application.

## Request Parameters and Path Variables

`@RequestParam` and `@PathVariable` are two annotations in Spring MVC that are used to extract values from the URL of an HTTP request. They serve different purposes and are used in different scenarios.

#### `@RequestParam`

The `@RequestParam` annotation is used to bind a request parameter (query parameter) from the URL to a method parameter in a controller. It is typically used for extracting values from the query string of a URL.

```java
// Example: URL - /search?query=spring
@GetMapping("/search")
public List<Item> searchItems(@RequestParam String query) {
    // Logic to search for items based on the query parameter
    return items;
}
```

In this example, the `searchItems` method takes a `query` parameter from the URL's query string (e.g., `/search?query=spring`). The value of the `query` parameter is automatically bound to the `query` method parameter. Does the name of the variable matter? Yes, by default, the name of the method parameter must match the name of the request parameter. However, you can specify a different name using the `name` attribute of the `@RequestParam` annotation.

```java
@GetMapping("/search")
public List<Item> searchItems(@RequestParam(name = "q") String query) {
    // Logic to search for items based on the query parameter
    return items;
}
```

In this case, the method will look for a query parameter named `q` in the URL (e.g., `/search?q=spring`).

You can also specify whether a request parameter is required or optional using the `required` attribute. By default, request parameters are required.

```java
@GetMapping("/search")
public List<Item> searchItems(@RequestParam(name = "q", required = false) String query) {
    // Logic to search for items based on the query parameter
    return items;
}
```

In this case, the `query` parameter is optional. If it is not provided in the request, it will be `null`.
You can also provide a default value for a request parameter using the `defaultValue` attribute.

```java
@GetMapping("/search")
public List<Item> searchItems(@RequestParam(name = "q", defaultValue = "all") String query) {
    // Logic to search for items based on the query parameter
    return items;
}
```

In this case, if the `q` parameter is not provided in the request, it will default to "all".

#### `@PathVariable`

The `@PathVariable` annotation is used to bind a URI template variable from the URL to a method parameter in a controller. It is typically used for extracting values from the path of the URL.

```java
// Example: URL - /items/42
@GetMapping("/items/{id}")
public Item getItemById(@PathVariable Long id) {
    // Logic to retrieve the item with the specified ID
    return item;
}
```

In this example, the `getItemById` method takes an `id` parameter from the URL path (e.g., `/items/42`). The value of the `id` path variable is automatically bound to the `id` method parameter. Does the name of the variable matter? Yes, by default, the name of the method parameter must match the name of the path variable. However, you can specify a different name using the `name` attribute of the `@PathVariable` annotation.

```java
@GetMapping("/items/{itemId}")
public Item getItemById(@PathVariable(name = "itemId") Long id) {
    // Logic to retrieve the item with the specified ID
    return item;
}
```

In this case, the method will look for a path variable named `itemId` in the URL (e.g., `/items/42`).
You can also specify whether a path variable is required or optional using the `required` attribute. By default, path variables are required.

```java
@GetMapping("/items/{id}")
public Item getItemById(@PathVariable(name = "id", required = false) Long id) {
    // Logic to retrieve the item with the specified ID
    return item;
}
```

In this case, the `id` path variable is optional. If it is not provided in the request, it will be `null`. However, note that making a path variable optional is not common practice, as it can lead to ambiguous URL mappings.
You can also provide a default value for a path variable using the `defaultValue` attribute.

```java
@GetMapping("/items/{id}")
public Item getItemById(@PathVariable(name = "id", defaultValue = "1") Long id) {
    // Logic to retrieve the item with the specified ID
    return item;
}
```

In this case, if the `id` path variable is not provided in the request, it will default to `1`.

### Real World Application

A simple application of `@PathVariable` could be in a user profile endpoint where the user ID is part of the URL, such as `/users/{userId}`. This allows for easy retrieval of user-specific data based on the provided user ID.
Similarly, `@RequestParam` could be used in a search functionality where the search term is passed as a query parameter, such as `/search?query=spring`. This allows for flexible searching based on user input.

### Implementation

Consider the following example that demonstrates the use of both `@RequestParam` and `@PathVariable` in a Spring MVC controller.

```java
package com.sample.controller;

import com.sample.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController("/student") // Combines @Controller and @ResponseBody, meaning methods return data directly and sets base path for all endpoints in this controller
public class StudentController {

    private List<Student> studentList = new ArrayList<>();

    {
        studentList.add(new Student("admin@mail.com", "IT", 100, "adminPass"));
        studentList.add(new Student("Charles@mail.com", "Biology", 72, "password"));
        studentList.add(new Student("Nick@mail.com", "Computer Science", 18, "superPass"));
    }

    @GetMapping("info/{email}")
    public Student displayInfo(@PathVariable String email) {

        for (Student student : studentList) {
            if (student.getEmail().equals(email))
                return student;
        }
        return null;
    }

    @PostMapping("submit")
    public String submit(@RequestParam String email,
                                       @RequestParam String major,
                                       @RequestParam int age,
                                       @RequestParam String password) {

        studentList.add(new Student(email, major, age, password));
        return "Successfully submitted";
    }
}
```

In this example:

- The `StudentController` class is annotated with `@RestController`, indicating that it is a RESTful controller. This annotation combines `@Controller` and `@ResponseBody`, meaning that the methods in this class will return data directly (usually in JSON format) instead of rendering a view.
- The class is also annotated with `@RequestMapping("/student")`, which sets a base path for all endpoints in this controller. All endpoints will be prefixed with `/student`.
- The `displayInfo` method is mapped to handle GET requests to the `/student/info/{email}` endpoint using the `@GetMapping` annotation. It takes an `email` path variable from the URL and searches for a student with that email in the `studentList`. If found, it returns the student object; otherwise, it returns `null`.
- The `submit` method is mapped to handle POST requests to the `/student/submit` endpoint using the `@PostMapping` annotation. It takes four request parameters: `email`, `major`, `age`, and `password`. It creates a new `Student` object with the provided values and adds it to the `studentList`. Finally, it returns a success message.
- The `Student` class is a simple model class that represents a student with fields for email, major, age, and password. It includes a constructor and getter methods for each field.

## Request Body & `@RequestBody` Annotation

The `@RequestBody` annotation in Spring MVC is used to bind the body of an HTTP request to a method parameter in a controller method. It is typically used in controller methods to extract data from the request body and convert it into a Java object. This is particularly useful for handling POST, PUT, and PATCH requests where the request body contains data that needs to be processed.

When a method parameter is annotated with `@RequestBody`, Spring will automatically deserialize the incoming request body (which is usually in JSON or XML format) into the specified Java object using message converters. This allows you to work with strongly typed objects in your controller methods, making it easier to handle and manipulate the data.

`@RequestBody` requires that the information provided matches the structure of the Java object it is being mapped to. If the structure does not match, Spring will throw an error.

```java
@PostMapping("/create")
public User createUser(@RequestBody User user) {
    // Logic to create a new user
    return user; // Returns the created user as JSON in the response body
}
```

### Real World Application

A simple application of `@RequestBody` could be in a user registration endpoint where the user details (such as name, email, and password) are sent in the request body as JSON. The controller method can then use `@RequestBody` to bind the incoming JSON data to a `User` object, which can be processed and saved to a database.

### Implementation

Consider an example application where we have students who can register using their email as a unique identifier. `@RequestBody` will help users request updates to their student information through the `update` handler method by sending a JSON object in the request body and binding it to a `Student` object.

Note: we will need a JSON processing library like Jackson to handle the serialization and deserialization of JSON data. Spring Boot includes Jackson by default when you use the `spring-boot-starter-web` dependency.

> Student Controller

```java
@RestController("/student") // Combines @Controller and @ResponseBody, meaning methods return data directly and sets base path for all endpoints in this controller
public class StudentController {
    private List<Student> studentList = new ArrayList<>();

    {
        studentList.add(new Student("john.doe@example.com", "Computer Science", 20, "password123"));
        studentList.add(new Student("jane.smith@example.com", "Mathematics", 22, "password456"));
        studentList.add(new Student("alice.johnson@example.com", "Physics", 21, "password789"));
    }

    @PutMapping("/update") // Maps PUT requests to /student/update to this method
    public String updateStudent(@RequestBody Student updatedStudent) {
        for (Student student : studentList) {
            if (student.getEmail().equals(updatedStudent.getEmail())) {
                student.setMajor(updatedStudent.getMajor());
                student.setAge(updatedStudent.getAge());
                student.setPassword(updatedStudent.getPassword());
                return "Student information updated successfully.";
            }
        }
        return "Student not found.";
    }
}
```

## ResponseEntity Class

`ResponseEntity` is a class that is meant to represent the entire HTTP response, including the status code, headers, and body. It is a generic class that can be used to return any type of object as the response body. This allows for much more flexibility when it comes to the following:

- The body is includes and can be given a generic type to help ensure the type safety of the API's HTTP responses.
- Optionally, we can include header information without requiring direct access to the `HttpServletResponse` object.
- Incorporating status codes, especially for handler methods that may not always behave as expected.

```java
@GetMapping("/example")
public ResponseEntity<String> example() {
    String responseBody = "Hello, World!";
    return ResponseEntity.ok(responseBody); // Returns a 200 OK response with the response body
}
```

#### HTTP Status Codes

`ResponseEntity` allows you to specify the HTTP status code to be returned in the response. You can use predefined constants from the `HttpStatus` enum or use the `ResponseEntity` builder methods to set the status code or provide a custom status code.

```java
@GetMapping("/custom")
public ResponseEntity<String> customResponse() {
    String responseBody = "Custom Response";
    return ResponseEntity.status(HttpStatus.CREATED).body(responseBody); // Returns a 201 Created response with the response body
}
```

#### HTTP Headers

You can also set custom HTTP headers in the response using the `ResponseEntity` class. This can be done using the `headers` method of the `ResponseEntity` builder.

```java
@GetMapping("/headers")
public ResponseEntity<String> responseWithHeaders() {
    String responseBody = "Response with Headers";
    HttpHeaders headers = new HttpHeaders();
    headers.add("Custom-Header", "HeaderValue");
    return ResponseEntity.ok().headers(headers).body(responseBody); // Returns a 200 OK response with custom headers and the response body
}
```

#### Body

`ResponseEntity` supports returning a response body along with the status code and headers. You can pass the body content as a parameter to the constructor or use the `body` method of the `ResponseEntity` builder. The body can be of any type, including Java objects, collections, strings, etc.

```java
@GetMapping("/body")
public ResponseEntity<List<String>> responseWithBody() {
    List<String> responseBody = Arrays.asList("Item1", "Item2", "Item3");
    return ResponseEntity.ok(responseBody); // Returns a 200 OK response with a list of strings as the response body
}
```

The `ResponseEntity` class offers flexible control of our HTTP responses through several static methods such as:

- The `.status()` method, which takes either an `HttpStatus` enum value or an integer representing the status code.
- The `.body()` method, which sets the body of the response.
- The `.header()` and `.headers()` methods, which allow us to set individual headers or multiple headers at once.
- The `.build()` method, which constructs the `ResponseEntity` object.

### Real World Application

`ResponseEntity` helps build flexible responses by providing complete control over our HTTP responses. This is particularly useful in RESTful APIs where we may need to return different status codes based on the outcome of an operation (e.g., 200 OK for success, 201 Created for resource creation, 400 Bad Request for client errors, 404 Not Found for missing resources, etc.). Additionally, we can include custom headers and response bodies as needed.

### Implementation

Consider an example application where we have students who can submit their information. ResponseEntity<Object> will replace the method signature return type of our handler method, and Object would be replaced with the type that we intend to return. Our return statement will now contain ResponseEntity static methods for constructing our HTTP response.

```java
@RestController("/student") // Combines @Controller and @ResponseBody, meaning methods return data directly and sets base path for all endpoints in this controller
public class StudentController {
    private List<Student> studentList = new ArrayList<>();

    {
        studentList.add(new Student("John", "Doe", "john.doe@example.com"));
        studentList.add(new Student("Jane", "Smith", "jane.smith@example.com"));
    }

    @PostMapping("/submit") // Maps POST requests to /student/submit to this method
    public ResponseEntity<String> submitInfo(@RequestBody Student student) {
        studentList.add(student);

        return ResponseEntity.status(HttpStatus.CREATED).body("Student information submitted successfully.");
    }
}
```
