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
