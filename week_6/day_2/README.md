# APIs and Testing - Day 2

## Introduction to REST

**REpresentational State Transfer (REST)** is an architectural style for designing networked applications. It defines a set of constraints and principles for creating web services that are scalable, stateless, and easy to maintain.

A **RESTful API** is a way of accessing web services using standard HTTP methods such as GET, POST, PUT, DELETE, etc. RESTful APIs are designed to be simple, lightweight, and easy to use.

REST technology is generally preferred to the more robust Simple Object Access Protocol (SOAP) technology because REST is easier to use and more flexible. REST uses less bandwidth, making it suitable for internet usage. It is used to fetch or modify resources from a web service. All RESTful APIs are HTTP-based, but not all HTTP-based APIs are RESTful.

In HTTP, there are several methods that are commonly used in a RESTful architecture:

- **GET**: Retrieves data from a server. It is used to fetch resources without modifying them.
- **POST**: Sends data to a server to create a new resource. It is used to submit data for processing.
- **PUT**: Updates an existing resource on the server. It is used to modify or replace a resource.
- **DELETE**: Removes a resource from the server. It is used to delete a resource.
- **PATCH**: Partially updates an existing resource on the server. It is used to modify specific fields of a resource.

These correspond to the CRUD operations:

| CRUD Operation | HTTP Method |
| -------------- | ----------- |
| Create         | POST        |
| Read           | GET         |
| Update         | PUT/PATCH   |
| Delete         | DELETE      |

#### REST Constraints

There are some key constraints to consider when considering if a RESTful API is the right choice for your application:

- **Client-Server**: This constraint operates on the concept that the client and server should be separate entities and allows to evolve independently.
- **Stateless**: REST APIs are stateless, meaning that each request from a client to a server must contain all the information needed to understand and process the request. The server does not store any client context between requests.
- **Cacheable**: Because a stateless API can increase request overhead by handling large loads of incoming and outbound calls, a RESTful API should be able to encourage and cache responses to improve performance.
- **Uniform Interface**: RESTful APIs should have a consistent and uniform interface, making it easy for clients to interact with the API. This includes using standard HTTP methods, URIs, and media types.
- **Layered System**: A RESTful API can be composed of multiple layers, each with its own responsibilities. This allows for scalability and flexibility in the architecture.
- **Code on Demand (optional)**: This constraint allows servers to extend the functionality of a client by sending executable code, such as JavaScript, to be executed on the client side.

#### Using RESTful APIs

- You access data via endpoints (URIs) that represent resources.
  - For example, `/users/Ada` lets you access the user resource for Ada.
- You use HTTP methods to perform actions on those resources.
  - For example, you'd view Ada's information with a GET request to `/users/Ada`. You could modify her info with a POST or PUT request to the same endpoint.
  - You can use the other HTTP methods as needed (DELETE, PATCH, etc.).
- You can represent data however you want.
  - For example, that GET request to `/users/Ada` could return Ada's info in JSON string format. The POST request to modify her info could take a JSON string in the request body.
  - You could also use XML or another format, but JSON is the most common.
- Each request should be standalone/stateless.
  - For example, the GET request to `/users/Ada` should include all the information needed to process the request. The server shouldn't need to remember anything about previous requests from the client.

### Real World Application

Understanding REST (REpresentational State Transfer) is crucial for modern software development for several reasons:

- **Standardization**: REST has become the de facto standard for designing web APIs. Many popular services, such as Twitter, Facebook, and Google, use RESTful APIs to allow developers to interact with their platforms. Understanding REST allows developers to adhere to industry best practices and standards when designing and implementing APIs, promoting consistency and interoperability across different systems.
- **Statelessness**: RESTful APIs are stateless, meaning that each request from a client to a server must contain all the information needed to understand and process the request. This statelessness simplifies server design, improves scalability, and allows for easier caching of responses, leading to better performance and reduced latency.
- **Uniform Interface**: RESTful APIs have a uniform interface, which means that they use standard HTTP methods (GET, POST, PUT, DELETE) and URIs to interact with resources. This uniformity makes it easier for developers to understand and use APIs, as they can rely on familiar patterns and conventions.
- **Flexibility**: Data is not tied to resources or methods, allowing for a more flexible and adaptable architecture. This flexibility enables developers to evolve their APIs over time without breaking existing clients.
- **Interoperability**: RESTful APIs can be consumed by a wide range of clients, including web browsers, mobile apps, and server-side applications. This interoperability allows developers to create applications that can interact with various services and platforms, enhancing the overall user experience.

In summary, understanding REST is essential for modern software development as it enables developers to create scalable, flexible, and interoperable web APIs that adhere to industry standards and best practices.

### Implementation

REST stands for REpresentational State Transfer, which is a set of rules and conventions for building web services. RESTful APIs use standard HTTP methods (GET, POST, PUT, DELETE) to perform operations on resources, which are identified by URIs (Uniform Resource Identifiers).

Let's consider an example of a website that provides access to book data. Programming languages have many different libraries and frameworks that can be used to create RESTful APIs. When you access a REST API's data, you do not need to know how the REST API works, you just need to know the interface (the endpoints, the data format, etc.) it provides.

Let's say the book website provides the following API:

The API will allow clients to perform CRUD (Create, Read, Update, Delete) operations on book resources using its interface, which is by sending HTTP requests to specific endpoints.

| HTTP Method | Endpoint        | Description                        |
| ----------- | --------------- | ---------------------------------- |
| GET         | /api/books      | Retrieve a list of all books       |
| GET         | /api/books/{id} | Retrieve a specific book by its ID |
| POST        | /api/books      | Create a new book                  |
| PUT         | /api/books/{id} | Update an existing book by its ID  |
| DELETE      | /api/books/{id} | Delete a book by its ID            |

You can send these requests from a web browser or an application you develop. An example request/response exchange might look like this:

Make the request on a terminal:

```bash
curl -X GET http://example.com/api/books
```

Data returned from the server:

```json
[
  {
    "id": 1,
    "title": "The Great Gatsby",
    "author": "F. Scott Fitzgerald",
    "published_year": 1925
  },
  {
    "id": 2,
    "title": "To Kill a Mockingbird",
    "author": "Harper Lee",
    "published_year": 1960
  }
]
```

This response is in JSON format, which is a common data format used in RESTful APIs. The client can then parse this JSON data and use it as needed.

## Introduction to Javalin

#### What is Javalin?

Javalin is a lightweight web framework for Java and Kotlin that makes it easy to create RESTful APIs and web applications. It is designed to be simple, flexible, and easy to use, with a focus on developer productivity.

It supports modern features such as HTTP/2, WebSockets, and asynchronous programming.

Javalin is servlet-based, which means it can run on any servlet container, such as Apache Tomcat or Jetty. It also has a small footprint and minimal dependencies, making it easy to integrate into existing projects.

Its main goals are simplicity, a great developer experience, and first-class interoperability between Java and Kotlin. Kotlin is a modern programming language that runs on the Java Virtual Machine (JVM) and is fully interoperable with Java. It is designed to be concise, expressive, and safe, with features such as null safety, extension functions, and coroutines.

Many developers would say Javalin is a library rather than a framework because it is lightweight and does not impose a lot of structure or conventions on the application. It provides a simple and flexible API for handling HTTP requests and responses, but it does not dictate how the application should be organized or structured.

### Real World Application

#### Why Use Javalin?

- **Simplicity**
  - Unlike other Java and Kotlin web frameworks, Javalin is designed to be simple and easy to use. It has a minimalistic API that allows developers to quickly create RESTful APIs and web applications without a lot of boilerplate code. You never extend any classes or implement any interfaces. You just create a Javalin instance and start defining routes.
- **Lightweight**
  - Javalin has a small footprint and minimal dependencies, making it easy to integrate into existing projects. It is also servlet-based, which means it can run on any servlet container, such as Apache Tomcat or Jetty.
  - Javalin is just a few thousand lines of code on top of Jetty, and its performance is comparable to using Jetty directly.
- **Interoperability**
  - Javalin is designed to work seamlessly with both Java and Kotlin, making it easy for developers to use their preferred language. It also supports modern features such as HTTP/2, WebSockets, and asynchronous programming.
- **Flexibility**
  - Javalin is a library rather than a framework, which means it does not impose a lot of structure or conventions on the application. This allows developers to organize their code in a way that makes sense for their specific use case.
  - Javalin is designed to be simple and blocking, as this is the easiest programming model to reason about. However, if you set a `Future` as the result of a handler, Javalin will automatically handle it asynchronously.
- **OpenAPI/Swagger Support**
  - Many lightweight Java and Kotlin web frameworks do not have built-in support for OpenAPI/Swagger, which can make it difficult to document and test APIs. Javalin has built-in support for OpenAPI/Swagger, making it easy to generate API documentation and test APIs using tools like Swagger UI.
- **Jetty**
  - Javalin runs on top of Jetty, one of the most used and stable web servers on the JVM. You can configure Jetty server fully, including SSL, HTTP/2, and everything else Jetty supports.

### Implementation

In Javalin, there are no requirements for your application structure. In other words, we do not have any of that extra "fluff" like annotations, reflection, and the like. You can structure your application however you want.

As you can see, the "Hello, world!" example below is very straightforward:

```java
package com.example;

import io.javalin.Javalin;

public class Main {
    public static void main(String[] args) {
      Javalin app = Javalin.create().start(7000);
      app.get("/", ctx -> ctx.result("Hello, world!"));
    }
}
```

This code creates a Javalin instance, starts it on port 7000, and defines a single route that responds to GET requests to the root URL ("/") with the text "Hello, world!".

You can build and package this application as a JAR file. If you use Maven, add this to your `pom.xml`:

```xml
<dependency>
    <groupid>io.javalin</groupid>
    <artifactid>javalin</artifactid>
    <version>2.5.0</version>
</dependency>
```

You will also needs a logger and a JSON parser.

```xml
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-simple</artifactId>
    <version>2.0.7</version>
</dependency>
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.16.0-rc1</version>
    <type>jar</type>
</dependency>
```

Then you an package your application with:

```bash
mvn package
```

You can then run your application with:

```bash
java -jar target/your-jar-file.jar
```

## Configuration

Javalin can be configured using the `JavalinConfig` class. You can set various options such as the port number, context path, and more.

```java
Javalin app = Javalin.create(config -> {
    config.defaultContentType = "application/json";
    config.enableCorsForAllOrigins();
}).start(7000);
```

Some information about Javalin configuration:

- Javalin runs on an embedded Jetty server, which means you can configure it using Jetty's configuration options.
- The architecture for adding other embedded servers (e.g., Netty, Undertow) is in place, and pull requests are welcome.
- Javalin can be used to start and stop the server programmatically, which is useful for testing and development.
- If you don't need any custom configuration, you can quick start Javalin with `Javalin.create().start(7000);`.
- You can customize the embedded server in Javalin by providing a custom `Server` instance.
- You can configure your embedded Jetty server and Javalin will attach its own handlers to the end of the handler chain.

### Real World Application

Advantages of Remote Server Configuration:

- Easy to turn on and off on the server without changing code.
- Easy to monitor resource usage and performance.
- Easy to monitor security and access logs.
- Lower maintenance costs.

### Implementation

#### Starting and Stopping the Server

To start and stop the server programmatically, you can use the `start()` and `stop()` methods:

```java
Javalin app = Javalin.create()
              .start() // starts the server (sync/blocking)
              .stop(); // stops the server (sync/blocking)
```

#### Quick Start

If you don't need any custom configuration, you can quick start Javalin with:

```java
Javalin app = Javalin.start(7000);
```

This creates a new server which listens on the specified port (7000 in this case), and starts it immediately.

#### Configuration

The following snippet shows all the configuration options currently available in Javalin:

```java
Javalin.create() // creates a new Javalin instance with default configuration
    .contextPath("/api") // sets the context path for the application aka base URL
    .dontIgnoreTrailingSlashes() // makes "/path" and "/path/" different endpoints
    .defaultContentType("application/json") // sets the default content type for responses
    .defaultCharacterEncoding("utf-8") // sets the default character encoding for responses
    .disableStartupBanner() // disables the startup banner in the console
    .enableDevLogging() // enables development logging
    .enableCorsForOrigin("https://example.com") // enables CORS for a specific origin
    .enableDynamicGzip() // enables dynamic gzip compression for responses
    .enableRouteOverview("/routes") // enables a route overview at the specified
    .enableStandardRequestLogging() // enables standard request logging
    .enableStaticFiles("/public") // serves static files from the specified directory
    .maxBodySizeForRequestCache(1024 * 1024) // sets the maximum body size for request cache
    .port(7000) // sets the port for the server
    .start(); // starts the server
```

Any argument in `contextPath()` will be normalized to start with a `/` and not end with a `/`. So `contextPath("api")` and `contextPath("/api/")` will both be normalized to `/api`.

#### Custom Server

If you need to customize the embedded server, you can call the `app.embedServer()` method with a custom `Server` instance:

```java
app.embedServer(new EmbeddedJettyFactory() {
   Server server = new Server();
    // customize the server here
    return server;
});
```

This allows you to configure your embedded Jetty server fully, including SSL, HTTP/2, and everything else Jetty supports.

#### Custom Jetty Handlers

You can configure your embedded Jetty server with a handler chain, and Javalin will attach its own handlers to the end of the chain:

```java
StatisticsHandler statisticsHandler = new StatisticsHandler();

Javalin.create()
    .embeddedServer(new EmbeddedJettyFactory(()-> {
      Server server = new Server();
      server.setHandler(statisticsHandler);
      return server;
    }
    )).start();
```

This allows you to add custom Jetty handlers to your application, such as logging, monitoring, or authentication handlers.

#### Examples of Different Configurations

##### HTTP Configuration

```java
Javalin.create(config -> {
  config.http.generateEtags = true; // if Javalin should generate ETags for responses (etags are used for caching)
  config.http.prefer405over404 = true; // if Javalin should return 405 Method Not Allowed instead of 404 Not Found when no handler is found for the request method
  config.http.maxRequestSize = 10 * 1024 * 1024; // max request size in bytes (default is 10MB)
  config.http.defaultContentType = "application/json"; // default content type for responses
  config.http.asyncTimeout = 10_000; // async request timeout in milliseconds (default is 10 seconds)
})
```

This configuration sets various HTTP options for the Javalin application, such as enabling ETag generation, preferring 405 responses over 404, setting a maximum request size, defining a default content type, and specifying an async request timeout.

##### Routing Configuration

```java
Javalin.create(config -> {
  config.routing.contextPath = "/api"; // base URL for all routes
  config.routing.ignoreTrailingSlashes = false; // if trailing slashes should be ignored when matching routes (so "/path" and "/path/" are the same endpoint)
  config.routing.treatMultipleSlashesAsSingleSlash = true; // if multiple slashes should be treated as a single slash when matching routes (so "/path//to///resource" is the same as "/path/to/resource")
})
```

This configuration sets routing options for the Javalin application, such as defining a base URL for all routes, specifying whether to ignore trailing slashes, and determining how to handle multiple consecutive slashes in URLs.

#### Real Example with HttpClient

Below we will show how we could use Javalin to create an application that generates random names assuming that we have a random name generator API already created.

```java
private static CompletableFuture<HttpResponse<String>> getRandomName() {
  HttpRequest req = HttpRequest.newBuilder()
      .uri(URI.create("https://random-name-generator-api.com/api/v1/names"))
      .build(); // creates a new HttpRequest to the random name generator API

  return HttpClient.sendAsync(req, HttpResponse.BodyHandlers.ofString()); // returns a CompletableFuture that will complete with the HttpResponse
}
```

The above code creates an `HttpRequest` to the random name generator API and sends it asynchronously using `HttpClient`. It returns a `CompletableFuture` that will complete with the `HttpResponse`. It will either resolve in a random name or an error. Below, we will implement the Javalin code that will asynchronously return a random name to the client.

```java
app.get("/random-name" ctx -> {
  ctx.future(() -> {
    return getRandomName()
          .thenApply(res -> ctx.html(res.body())).status(res.statusCode()); // if the request is successful, return the name in the response body with the same status code as the API
          .exceptionally(throwable -> {
            ctx.status(500).result("Could not fetch a random name: " + throwable.getMessage());
            return null;
          }); // if the request fails, return a 500 status code with an error message
  })
})
```

This code defines a GET endpoint at `/random-name` that uses the `getRandomName()` method to fetch a random name from the external API. It uses `ctx.future()` to handle the asynchronous operation, returning the name in the response body if successful or a 500 status code with an error message if it fails.

### Handlers

Javalin has three main types of handlers:

- **Before Handlers**: These handlers are executed before the main request handler. They are typically used for tasks such as authentication, logging, or modifying the request context. Before handlers can be defined globally for all routes or for specific routes.
- **Main/Endpoint Handlers**: These handlers are executed when a specific route is matched. They are responsible for processing the request and generating the response. Main handlers can be defined for specific HTTP methods (GET, POST, PUT, DELETE, etc.) and routes.
- **After Handlers**: These handlers are executed after the main request handler. They are typically used for tasks such as logging, modifying the response, or cleaning up resources. After handlers can also be defined globally for all routes or for specific routes.

There are also exception handlers and error handlers:

- **Exception Handlers**: These handlers are executed when an exception is thrown during the processing of a request. They can be used to handle specific types of exceptions and generate appropriate error responses.
- **Error Handlers**: These handlers are executed when a specific HTTP error status code is returned. They can be used to customize the error response for specific status codes.

The before, main/endpoint, and after handlers require three parameters:

- The HTTP method (GET, POST, PUT, DELETE, etc.)
- The path (e.g., "/users", "/books/{id}", etc.)
- A handler function that takes a `Context` object as a parameter and performs the desired actions

The Handler interface has a `void` return type, meaning it does not return any value. Instead, it modifies the `Context` object to set the response.

You use a method like `ctx.result(result)` to set the response body, `ctx.status(code)` to set the response status code, `ctx.json(object)` to return JSON data, `ctx.future(supplier)` to handle asynchronous operations, and other methods to set headers, cookies, etc, which will be sent back to the client.

Here is an example of how to define before, main/endpoint, and after handlers in Javalin:

```java
Javalin app = Javalin.create().start(7000);
app.before(ctx -> {
    // This code will run before every request
    System.out.println("Before handler: " + ctx.method() + " " + ctx.path());
});
```

```java
app.get("/hello", ctx -> {
    // This code will run when a GET request is made to /hello
    ctx.result("Hello, world!");
});
```

```java
app.after(ctx -> {
    // This code will run after every request
    System.out.println("After handler: " + ctx.method() + " " + ctx.path());
});
```

#### Before Handlers

Before handlers are executed before the main request handler. They are typically used for tasks such as authentication, logging, or modifying the request context. Before handlers can be defined globally for all routes or for specific routes.

```java
app.before(ctx -> {
  // runs before all requests
});
app.before("/path/*", ctx -> {
  // runs before requests to /path/*
});
```

#### Endpoint Handlers

Endpoint handlers are executed when a specific route is matched. They are responsible for processing the request and generating the response. Main handlers can be defined for specific HTTP methods (GET, POST, PUT, DELETE, etc.) and routes. Uncommon HTTP methods like OPTIONS, HEAD, and TRACE are also supported but via `Javalin#addHandler`.

```java
app.get("/path", ctx -> {
  // runs for GET requests to /path
  ctx.json(object); // returns JSON response
});
app.post("/path", ctx -> {
  // runs for POST requests to /path
  ctx.status(201).result("Created"); // returns 201 Created status
});
```

Handler paths can include path parameters, which are denoted by curly braces `{}`. For example, `/users/{id}` would match requests like `/users/1` or `/users/42`, and the value of the `id` parameter can be accessed using `ctx.pathParam("id")`.

```java
app.get("/users/{id}", ctx -> {
  ctx.result("User ID: " + ctx.pathParam("id"));
})
```

However, you cannot extract the value of a wildcard (`*`) using `ctx.pathParam()`. Wildcards are used to match any part of a path, but they do not create a named parameter that can be accessed.

```java
app.get("/files/*", ctx -> {
  ctx.result("This matches any path under /files/");
});
```

#### After Handlers

After handlers are executed after the main request handler (even if an exception is thrown). They are typically used for tasks such as logging, modifying the response, or cleaning up resources. After handlers can also be defined globally for all routes or for specific routes. You might know after handlers as `filters`, `interceptors`, or `middleware` in other frameworks.

```java
app.after(ctx -> {
  // runs after all requests
});
app.after("/path/*", ctx -> {
  // runs after requests to /path/*
});
```

#### Context

The `Context` object (`ctx`) is a central part of Javalin's request handling. It provides access to the HTTP request and response, as well as various methods for manipulating them.

| Request Methods           | Description                                      |
| ------------------------- | ------------------------------------------------ |
| `body()`                  | Returns the request body as a string.            |
| `pathParam()`             | Retrieves a path parameter by name.              |
| `attribute("key", value)` | Sets an attribute in the request context.        |
| `attribute("key")`        | Retrieves an attribute from the request context. |
| `path()`                  | Returns the request path.                        |
| `method()`                | Returns the HTTP method of the request.          |
| `queryParam("name")`      | Retrieves a query parameter by name.             |

| Response Methods                | Description                                                                               |
| ------------------------------- | ----------------------------------------------------------------------------------------- |
| `redirect("/path", statusCode)` | Redirects the client to the specified path with an optional status code (default is 302). |
| `status(code)`                  | Sets the HTTP status code for the response.                                               |
| `status()`                      | Retrieves the current HTTP status code of the response.                                   |

### Real World Application

Typical uses for HTTP handlers include:

- **Authentication and Authorization**: Before handlers can be used to check if a user is authenticated and authorized to access a specific resource. If not, the handler can return a 401 Unauthorized or 403 Forbidden response.
- **Logging and Monitoring**: Before and after handlers can be used to log requests and responses for monitoring and debugging purposes. This can include logging the request method, path, status code, and response time.
- **Input Validation**: Before handlers can be used to validate input data before it is processed by the main handler. If the input is invalid, the handler can return a 400 Bad Request response.
- **RSS Feeds**: After handlers can be used to modify the response to include additional information, such as adding an RSS feed to a blog post response.
- **Image Server**: If you want a web application to serve images of different sizes, you could use before handlers to check if the requested size is valid and after handlers to resize the image before sending it back to the client.
- **Error Handling**: Exception handlers can be used to catch and handle specific exceptions that may occur during request processing. This allows for graceful error handling and the ability to return meaningful error messages to the client.

### Implementation

Let's look into a more realistic use case for Javalin and handlers.

First, we need to create a simple data model of the object we are going to be working with. In this case, we will create a package called `user` and create a `User` class.

```java
package com.example.user;

public class User {
  public final int id;
  public final String name;

  // constructor
}
```

Also, we need to set up our data access object (DAO) to handle the data storage and retrieval. We will use an in-memory object to store our users for simplicity.

```java
class UserDao {
  private List<User> users = Arrays.asList(
    new User(0, "Steve Rogers"),
    new User(1, "Tony Stark"),
    new User(2, "Carol Danvers")
  ); // sample data

  private static UserDao userDao = null; // singleton instance

  private UserDao() {} // private constructor to prevent instantiation

  static UserDao instance() {
    if (userDao == null) {
      userDao = new UserDao();
    }
    return userDao;
  } // get the singleton instance

  // Optional<T> is a container object which may or may not contain a non-null value.
  Optional<User> getUserById(int id) {
    return users.stream()
                .filter(u -> u.id == id)
                .findAny();
  } // get a user by id

  // Iterable is a collection of objects that can be iterated over.
  Iterable<String> getAllUsernames() {
    return users.stream()
                .map(user -> user.name)
                .toList();
  } // get all usernames
}
```

Implementing our DAO as a singleton makes it easier to manage the data access throughout our application. We could also declare it as a static member of our main class or use dependency injection from a library like Spring.

Finally, we want to create our `controller` class. A controller is responsible for handling the HTTP requests and responses. Javalin allows us to be very flexible when we declare route handlers, so this is only one way of defining them.

We create a new class called `UserController.java`:

```java
package com.example.user;

public class UserController {
  // Handler is a functional interface that represents a function that takes a Context object and returns void (part of Javalin library)
  public static Handler fetchAllUserNames = ctx -> {
    UserDao dao = UserDao.instance();
    Iterable<String> users = dao.getAllUsernames();
    ctx.json(user);
  }

  // Fetch a user by id
  public static Handler fetchById = ctx -> {
    // Get the id from the path parameter and convert it to an integer
    // Objects.requireNonNull() is used to ensure that the value is not null, otherwise it will throw a NullPointerException (part of java.util package)
    int id = Integer.parseInt(Objects.requireNonNull(ctx.pathParam("id")));

    // Get singleton instance of UserDao
    UserDao dao = UserDao.instance();

    // Get the user by id
    // Optional<T> is a container object which may or may not contain a non-null value (part of java.util package)
    Optional<User> user = dao.getUserById(id);

    // If the user is found, return it as JSON, otherwise return a 404 Not Found status
    if (user.isPresent()) {
      // Return the user object in the response body as JSON
      ctx.json(user.get()); // user.get() returns the value if present, otherwise throws NoSuchElementException (part of Optional class)
    } else {
      ctx.status(404).html("Not found"); // return 404 Not Found status with a message
    }

    /**
     * Alternative to if/else statement
     *
     * // Using ifPresent() method of Optional class which takes a Consumer
     * // functional interface as a parameter
     * user.ifPresent(u -> ctx.json(u)); // if the user is present, return it as JSON
     *
     * if (!user.isPresent()) {
     *  ctx.html("Not found");
     * }
     */
  }
}
```

By declaring the handlers as static, we ensure that the controller itself holds no state. But, in more complex applications, we may want to store state between requests, in which case we'd need to remove the static keyword and instantiate the controller class in our main application.

Also, note that unit testing is harder with static members, so if you plan to write tests for your handlers, consider using instance methods instead.

#### Adding Routes

We now have multiple ways of fetching data from our model. The last step is to expose this data via REST endpoints. We need to to register two new routes in our main application class.

```java
app.get("/users", UserController.fetchAllUserNames); // fetch all usernames
app.get("/users/{id}", UserController.fetchById); // fetch a user by id
```

After compiling and running the application, we can test our endpoints using a tool like Postman or curl.

#### Extending Routes

Retrieving data is a vital task in most microservices.

However, we also need to be able to store data in our database. Javalin provides the full set of path handlers (GET, POST, PUT, DELETE, PATCH) to perform CRUD operations on our resources.

We saw an example of a `GET` request above, but `POST`, `PUT`, `DELETE`, and `PATCH` are also available.

Also, if we include the Jackson dependency in our project, we can easily convert JSON data to Java objects and vice versa.

```java
app.post("/", ctx -> {
  User user = ctx.bodyAsClass(User.class); // convert the request body to a User object
  // store the user in the database
  ctx.status(201).json(user); // return the created user with a 201 Created status
})
```

The above code snippet shows how to handle a `POST` request to create a new user. The `ctx.bodyAsClass(User.class)` method is used to convert the JSON request body into a `User` object. After storing the user in the database (not shown in this example), we return the created user in the response body with a 201 Created status.

## Exception Handling

#### Exception Mapping

All handlers (before, endpoint, after) can throw exceptions and any subclass of `Exception`. The `app.exception()` method allows you to map specific exception types to handlers that will be executed when those exceptions are thrown.

```java
// Handle NullPointerException specifically
app.exception(NullPointerException.class, (e, ctx) -> {
  ctx.status(400).json("Null value encountered");
});

// Catch all for any other exceptions
app.exception(Exception.class, (e, ctx) -> {
  // Will not trigger if a more specific exception-mapper is found
  ctx.status(500).json("Internal server error");
});
```

#### Error Mapping

Error mapping is similar to exception mapping, but it is used to handle specific HTTP status codes instead of exceptions. The `app.error()` method allows you to map specific status codes to handlers that will be executed when those status codes are returned.

For example, you can create a custom handler for 404 Not Found errors in use cases where a resource is not found:

```java
app.error(404, ctx -> {
  ctx.json("Custom 404 Not Found message");
})
```

This code snippet defines a custom handler for 404 Not Found errors. When a request results in a 404 status code, the handler will return a JSON response with the message "Custom 404 Not Found message".

#### Exception and Error Mapping

Sometimes we want to handle both exceptions and specific error codes in a unified way. For example, we might want to return a 400 Bad Request status code for `IllegalArgumentException` and a 404 Not Found status code for `NoSuchElementException`.

```java
app.exception(FileNotFoundException.class, (e, ctx -> {
  ctx.status(404);
}).error(404, ctx -> {
  ctx.json("Resource not found");
}));
```

This code snippet defines an exception handler for `FileNotFoundException` that sets the response status to 404 Not Found. It also defines an error handler for 404 status codes that returns a JSON response with the message "Resource not found". This way, both exceptions and 404 errors are handled in a consistent manner.

### Real World Application

#### Why Handle Java Exceptions?

Java exception handling is important because it helps maintain the normal flow of the application, even when unexpected errors occur. If Java exceptions are not handled properly, programs can crash or behave unpredictably, leading to a poor user experience and potential data loss. This would be very frustrating for users and could lead to a loss of trust in the application.

The worst situation is if your application crashes while the user is doing any important work, especially if they have not saved their work. To make the user interface robust, it is important to handle exceptions to prevent the application from unexpectedly crashing and losing user data.

There can be many causes for a sudden crash of the application, such as invalid user input, network issues, file not found errors, database connection failures, and more. For example, if we try to add two users with duplicate IDs to the database, we should throw an exception and handle it gracefully, rather than letting the application crash.

Developers can predict many of the Java exceptions that may occur in their code and handle them appropriately.

The best course of action is to explicitly handle those exceptions to recover from them gracefully. Programming languages provide ways to handle exceptions, starting from specific exceptions to more general ones. Tracking exceptions centrally offers visibility to your development team on the quality of the code and what causes these exceptions so they can be fixed.

### Implementation

In this example, we will demonstrate how to use error and exception handlers within a note-saving application. For simplicity, we will only include code that is relevant to exception and error handling.

#### `Note.java` and `NoteController.java`

We will need a `Note` class to represent our notes:

```java
public class Note {
  private long id;
  private String content;
  private String priority; // can be "low", "medium", or "high"

  // constructor, getters, and setters
}
```

We will also need a `NoteController` class to handle our note-related operations:

```java
public class NoteController {
  // ...service layer configuration code omitted for brevity

  // method that starts Javalin and sets up routes
  public void setup() {
    // create Javalin object
    Javalin app = Javalin.create().start(7000);

    // endpoints
    app.get("/notes", this::getAllNotes);
    app.get("/notes/{id}", this::getNoteById);

    app.error(404, this::handleNotFound); // handle 404 errors
    app.exception(Exception.class, this::handleException); // handle all exceptions
  }

  private void getAllNotes(Context ctx) {
    List<Note> notes = noteService.getAllNotes();
    ctx.json(notes);
  }

  private void getNoteById(Context ctx) {
    long id = Long.parseLong(ctx.pathParam("id"));
    Note note = noteService.getNoteById(id)
                           .orElseThrow(() -> new NoSuchElementException("Note not found with id: " + id));
    ctx.json(note);
  }

  private void handleNotFound(Context ctx) {
    ctx.status(404).json("The requested resource was not found.");
  }

  private void handleException(Exception e, Context ctx) {
    ctx.status(500).json("An unexpected error occurred: " + e.getMessage());
  }
}
```

In this code snippet, we define a `Note` class to represent our notes and a `NoteController` class to handle note-related operations. The `setup()` method initializes the Javalin application, sets up the routes, and registers the error and exception handlers
. The `getAllNotes()` and `getNoteById()` methods handle the respective endpoints, while the `handleNotFound()` and `handleException()` methods handle 404 errors and general exceptions, respectively.

#### Error Mapping

The `app.error()` call requires that we specify a status code to map to a handler. In this case, we are mapping the 404 Not Found status code to the `handleNotFound()` method. This method sets the response status to 404 and returns a JSON message indicating that the requested resource was not found.

#### Exception Mapping

The `app.exception()` call requires that we specify an exception type to map to a handler. In this case, we are mapping the `Exception` class to the `handleException()` method. This method sets the response status to 500 Internal Server Error and returns a JSON message indicating that an unexpected error occurred, along with the exception message.

## JSON

JSON (JavaScript Object Notation) is a lightweight data interchange format that is easy for humans to read and write, and easy for machines to parse and generate. It is commonly used in web applications to transmit data between a server and a client.

A JSON object is a collection of key-value pairs, where the keys are strings and the values can be strings, numbers, booleans, arrays, or other JSON objects.

Example:

```json
{
  "key1": "value1",
  "key2": 123,
  "key3": true,
  "key4": ["item1", "item2", "item3"],
  "key5": {
    "nestedKey1": "nestedValue1",
    "nestedKey2": 456
  }
}
```

### Real World Application

Some common use cases for JSON include:

- **APIs**: JSON is often used as the data format for RESTful APIs, allowing clients to send and receive data in a structured way.
- **Configuration Files**: JSON is commonly used for configuration files in web applications, allowing developers to easily modify settings without changing code.
- **Data Storage**: JSON can be used as a lightweight data storage format, allowing applications to store and retrieve data in a structured way.
- **Data Interchange**: JSON is often used as a data interchange format between different programming languages and platforms, allowing for easy integration between systems.

## Exposing and Consuming Restful API Endpoints

#### What is a RESTful API?

If you've ever spend any time programming or researching programming, you've probably heard of the term API. An API stands for Application Programming Interface. It is a medium that allows two applications to communicate with each other. APIs are used in many different contexts, but one of the most common is in web development.

Roy Fielding, one of the principal authors of the HTTP specification, defined REST (Representational State Transfer) in his 2000 doctoral dissertation. REST is an architectural style for designing networked applications. It is based on a set of principles that emphasize scalability, simplicity, and interoperability.

When a request is made via REST API, it sends a representation of the resource's current state to the requestor or endpoint. This state representation can be in various formats, such as JSON, XML, or HTML. JSON is the most commonly used format for RESTful APIs due to its simplicity and ease of use.

#### Exposing Endpoints

You could let the users CREATE, READ, UPDATE, or DELETE (CRUD) resources in your application using HTTP methods through your RESTful API. That of course adheres to the REST principles. RESTful APIs use standard HTTP methods to perform CRUD operations on resources. The most commonly used HTTP methods are:

- **POST**: Used to create a new resource.
- **GET**: Used to retrieve a resource or a collection of resources.
- **PUT**: Used to update an existing resource.
- **DELETE**: Used to delete a resource.

These methods say how resources should be manipulated.

A REST resource is a piece of identifiable information that can be accessed and manipulated via a RESTful API. Resources are typically represented as URLs (Uniform Resource Locators) and can be anything from a single object to a collection of objects. Note that resources are not necessarily domain entities, but they often are. Exposing endpoints means that you enable information to be accessed through some form of interface, in this case, a RESTful API. An endpoint is a specific URL that represents a resource and can be accessed using HTTP methods.

For example, in a RESTful API for managing a collection of books, exposing endpoints might involve defining resources such as `/books` for the collection of books and `/books/{id}` for individual book resources. After defining those resources, you'll need to define **routes** or **handlers** that will handle the HTTP requests made to those endpoints. These are typically methods or functions that wait for an HTTP request to be made to a specific endpoint and then perform the appropriate action based on the HTTP method used. The result of the execution should be a response that is sent back to the client.

#### Consuming Endpoints

Consuming endpoints involves sending requests to the exposed endpoints of another application or service to access its functionalities or resources. In other words, it's the process of making HTTP requests to a RESTful API to interact with the resources it provides.

To consume endpoints, you use HTTP client libraries or tools in your application to send requests to the specified URLs and handle the responses returned by the server. You typically specify the HTTP method (GET, POST, PUT, DELETE, etc.), along with any necessary headers, query parameters, or request bodies., and process the response data received from the server.

In a client application (e.g., a web or mobile app), consuming endpoints might involve sending GET requests to retrieve a list of books from a remote server, sending POST requests to create new books, or sending PUT requests to update existing book information, and sending DELETE requests to remove books from the collection.

### Implementation

#### Exposing Endpoints

##### Step 1: Identify Your Resources

The first thing to do when building a RESTful API is to identify the resources that you want to expose and define. These resources will allow users to interact with one or all blog posts in your application.

- `/posts`: Represents a collection of blog posts.
- `/posts/{id}`: Represents a single blog post identified by its unique ID.

Next, let's define some endpoints we could expose to a client application.

#### Step 2: Identify Your Endpoints

These endpoints will allow the client to perform various actions such as creating, reading, updating, and deleting blog posts.

| HTTP Method | Endpoint    | Description                              |
| ----------- | ----------- | ---------------------------------------- |
| GET         | /posts      | Retrieve a list of all blog posts.       |
| GET         | /posts/{id} | Retrieve a specific blog post by its ID. |
| POST        | /posts      | Create a new blog post.                  |
| PUT         | /posts/{id} | Update an existing blog post by its ID.  |
| DELETE      | /posts/{id} | Delete a specific blog post by its ID.   |

We could also identify resources and endpoints for other entities in our application, such as users and comments.

#### Step 3: Implementation

The implementation of a RESTful API will vary depending on the programming language and framework you are using. You will most likely be using a web framework like Express.js for Node.js, Flask for Python, or Spring Boot for Java.

Examples of routes/handlers for the `GET` to `/posts` endpoint:

```js
app.get("/posts", (req, res) => {
  // Logic to retrieve all blog posts from the database
  const posts = getAllPostsFromDatabase();
  res.json(posts); // Send the list of posts as a JSON response
});
```

```python
@app.route('/posts', methods=['GET'])
def get_posts():
    # Logic to retrieve all blog posts from the database
    posts = get_all_posts_from_database()
    return jsonify(posts)  # Send the list of posts as a JSON response
```

```java
@GetMapping("/posts")
public List<Post> getAllPosts() {
    // Logic to retrieve all blog posts from the database
    return postService.getAllPosts(); // Return the list of posts as a JSON response
}
```

#### Consuming Endpoints

To consume the endpoints of a RESTful API, you can use various HTTP client libraries or tools depending on your programming language or environment. We will keep it simple and use a simple command line tool called `curl` to demonstrate how to consume the endpoints we defined earlier.

```bash
curl -X GET http://localhost:7000/posts
```

The result of the above command would be a JSON array of all blog posts in the application.
